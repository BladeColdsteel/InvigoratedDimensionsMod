package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.boss;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.projectiles.LightningItemProjectileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class RagingTempestEntity extends MonsterEntity implements IAnimatable, IRangedAttackMob, IChargeableMob {
    private final ServerBossInfo bossEvent;
    private static final DataParameter<Integer> BEAM_TARGET_ID;
    private int shotsFiredSinceBeam = 0;
    private boolean isShootingLightning = false;
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.model.idle");
    protected static final AnimationBuilder LIGHTNING_ANIM = new AnimationBuilder().addAnimation("animation.model.lightningStrike");
    protected static final AnimationBuilder BEAM_ANIM = new AnimationBuilder().addAnimation("animation.model.voltageBeam");

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public RagingTempestEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.bossEvent = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
        this.setHealth(this.getMaxHealth());
        this.getNavigation().setCanFloat(true);
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData data, @Nullable CompoundNBT compoundNBT) {
        return super.finalizeSpawn(world, difficulty, reason, data, compoundNBT);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BEAM_TARGET_ID, 0);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 250.0D)
                    .add(Attributes.ARMOR, 4.5D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.2D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 250.0D)
                    .add(Attributes.ARMOR, 5.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.2D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 250.0D)
                    .add(Attributes.ARMOR, 5.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.2D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 0.75D, 60, 32.0F));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, 0.75D, 45.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source == DamageSource.LIGHTNING_BOLT) {
            return false;
        } else {
            return super.hurt(source, amount);
        }
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return (int) (this.random.nextInt(40) + this.getHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CONDUIT_AMBIENT_SHORT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.CORAL_BLOCK_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.TRIDENT_THUNDER;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.CHAIN_PLACE, 0.2F, 1.0F);
    }

    @Override
    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());

        Vector3d vector3d = this.getDeltaMovement().multiply(1.0, 0.6, 1.0);
        if (!this.level.isClientSide) {
            LivingEntity target = this.getTarget();
            if (target != null && target.isAlive()) {
                double d0 = vector3d.y;
                if (this.getY() < target.getY() || !this.isPowered() && this.getY() < target.getY() + 5.0) {
                    d0 = Math.max(0.0, d0);
                    d0 += 0.3 - d0 * 0.6000000238418579;
                }

                vector3d = new Vector3d(vector3d.x, d0, vector3d.z);
                Vector3d vector3d1 = new Vector3d(target.getX() - this.getX(), 0.0, target.getZ() - this.getZ());
                if (getHorizontalDistanceSqr(vector3d1) > 9.0) {
                    Vector3d vector3d2 = vector3d1.normalize();
                    vector3d = vector3d.add(vector3d2.x * 0.3 - vector3d.x * 0.6, 0.0, vector3d2.z * 0.3 - vector3d.z * 0.6);
                }
                this.setDeltaMovement(vector3d);
            }
        }

        if (getHorizontalDistanceSqr(vector3d) > 0.05) {
            this.yRot = (float)MathHelper.atan2(vector3d.z, vector3d.x) * 57.295776F - 90.0F;
        }
    }

    @Override
    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.remove();
        } else {
            this.noActionTime = 0;
        }
    }

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    protected <E extends RagingTempestEntity> PlayState animationController(final AnimationEvent<E> event) {
        if (this.getBeamTargetID() != 0) {
            event.getController().setAnimation(BEAM_ANIM);
            return PlayState.CONTINUE;
        } else if (this.isShootingLightning) {
            event.getController().setAnimation(LIGHTNING_ANIM);
            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float v) {
        if (this.shotsFiredSinceBeam < 2) {
            this.isShootingLightning = true;
            LightningItemProjectileEntity projectile = new LightningItemProjectileEntity(this.level, this);
            projectile.setOwner(this);
            projectile.setPos(this.getX(), this.getEyeY() - 0.1, this.getZ());

            double dx = target.getX() - this.getX();
            double dz = target.getZ() - this.getZ();
            double dy = target.getEyeY() - projectile.getY();
            double horizon = MathHelper.sqrt(dx * dx + dz * dz);
            dy += horizon * 0.1;

            float speed = 1.1F;
            float inaccuracy = (float)(10 - this.level.getDifficulty().getId() * 8);

            projectile.shoot(dx, dy, dz, speed, inaccuracy);
            this.shotsFiredSinceBeam++;
            this.playSound(SoundEvents.BEACON_ACTIVATE, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.level.addFreshEntity(projectile);
            this.isShootingLightning = false;
        }
    }

    @Override
    public boolean isPowered() {
        return false;
    }

    public void setBeamTarget(@Nullable LivingEntity target) {
        this.entityData.set(BEAM_TARGET_ID, target == null ? 0 : target.getId());
    }

    public int getBeamTargetID() {
        return this.entityData.get(BEAM_TARGET_ID);
    }

    static {
        BEAM_TARGET_ID = EntityDataManager.defineId(RagingTempestEntity.class, DataSerializers.INT);
    }

    static class AttackGoal extends Goal {
        private final RagingTempestEntity entity;
        private int attackTime;

        public AttackGoal(RagingTempestEntity entity) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            int shotsFired = entity.shotsFiredSinceBeam;
            return target != null && target.isAlive() && shotsFired >= 2;
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.entity.getTarget();
            int shotsFired = entity.shotsFiredSinceBeam;
            return target != null && target.isAlive() && shotsFired >= 2 && (this.entity.distanceToSqr(target) > 25.0);
        }

        public void start() {
            this.attackTime = -10;
            this.entity.getNavigation().stop();
            this.entity.getLookControl().setLookAt(this.entity.getTarget(), 90.0F, 90.0F);
            this.entity.hasImpulse = true;
        }

        public void stop() {
            this.entity.setBeamTarget(null);
            this.entity.shotsFiredSinceBeam = 0;
        }

        public void tick() {
            BlockPos tempestPos = new BlockPos(this.entity.getX(), this.entity.getY(), this.entity.getZ());
            LivingEntity target = this.entity.getTarget();
            if (target == null || !target.isAlive()) {
                this.entity.setTarget(null);
                this.entity.setBeamTarget(null);
                this.entity.shotsFiredSinceBeam = 0;
                return;
            }
            this.entity.getNavigation().stop();
            this.entity.getLookControl().setLookAt(target, 90.0F, 90.0F);
            if (!this.entity.canSee(target)) {
                this.entity.setTarget(null);
                this.entity.setBeamTarget(null);
                this.entity.shotsFiredSinceBeam = 0;
            } else {
                ++this.attackTime;
                if (!this.entity.level.isClientSide()) {
                    if (this.attackTime == 0) {
                        this.entity.setBeamTarget(target);
                        this.entity.level.playSound(null, tempestPos, SoundEvents.BEACON_ACTIVATE, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    } else if (this.attackTime >= 140 && this.attackTime < 150) {

                        ServerWorld server = (ServerWorld) this.entity.level;

                        Vector3d start = this.entity.position().add(0.0, this.entity.getEyeHeight(), 0.0);
                        Vector3d stop = target.position().add(0.0, target.getEyeHeight() * 0.5, 0.0);

                        Vector3d diff = stop.subtract(start);
                        double len = diff.length();
                        Vector3d dir = diff.normalize();

                        double step = 0.3;
                        int point = (int) (len / step);

                        for (int i = 0; i <= point; i++) {
                            Vector3d p = start.add(dir.scale(i * step));

                            double jx = (this.entity.getRandom().nextDouble() - 0.5) * 0.05;
                            double jy = (this.entity.getRandom().nextDouble() - 0.5) * 0.05;
                            double jz = (this.entity.getRandom().nextDouble() - 0.5) * 0.05;

                            server.sendParticles(ParticleTypes.END_ROD,
                                    p.x + jx, p.y + jy, p.z + jz,
                                    1,
                                    0.0, 0.0, 0.0,
                                    0.0);
                        }
                    } else if (this.attackTime == 150) {
                        float damage = 4.0F;
                        if (this.entity.level.getDifficulty() == Difficulty.HARD) {
                            damage += 2.0F;
                        }

                        this.entity.level.playSound(null, tempestPos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                        target.hurt(DamageSource.indirectMagic(this.entity, this.entity), damage);
                        target.hurt(DamageSource.mobAttack(this.entity), (float)this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
                        this.entity.setTarget(null);
                        this.entity.setBeamTarget(null);
                        this.entity.shotsFiredSinceBeam = 0;
                    }
                }
                super.tick();
            }
        }
    }
}
