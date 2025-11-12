package com.bladecoldsteel.invigorateddimensions.overworld.entity.custom.boss;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.OverworldEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class FossilizedTraderEntity extends MonsterEntity implements IRangedAttackMob {
    private final ServerBossInfo bossEvent;

    public FossilizedTraderEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.bossEvent = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.WHITE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
        this.setHealth(this.getMaxHealth());
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 200.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.34D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 250.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 200.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                    .add(Attributes.MOVEMENT_SPEED, 0.34D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 3.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 10, 20.0F));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PlayerEntity.class, 5.0F, 1.0F, 1.2D));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return this.random.nextInt(40) + 5;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.VILLAGER_AMBIENT, 0.2F, 1.0F);
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        this.playSound(SoundEvents.WITHER_SKELETON_HURT, 1.0F, 1.7F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.VILLAGER_DEATH, 0.7F, 2.0F);
        return null;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.ZOMBIE_VILLAGER_STEP, 0.2F, 1.0F);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        EmeraldItemProjectile projectile = new EmeraldItemProjectile(this.level, this);
        projectile.setOwner(this);
        projectile.setPos(this.getX(), this.getEyeY() - 0.1, this.getZ());

        double dx = target.getX() - this.getX();
        double dz = target.getZ() - this.getZ();
        double dy = target.getEyeY() - projectile.getY();
        double horizon = MathHelper.sqrt(dx * dx + dz * dz);
        dy += horizon * 0.1;

        float speed = 1.6F;
        float inaccuracy = (float)(10 - this.level.getDifficulty().getId() * 4);

        projectile.shoot(dx, dy, dz, speed, inaccuracy);
        this.playSound(SoundEvents.VILLAGER_TRADE, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(projectile);
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
    }

    @Override
    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.remove();
        } else {
            this.noActionTime = 0;
        }
    }

    public static class EmeraldItemProjectile extends ProjectileItemEntity {
        public EmeraldItemProjectile(EntityType<? extends ProjectileItemEntity> entity, World world) {
            super(entity, world);
        }

        public EmeraldItemProjectile(World world, LivingEntity shooter) {
            super(OverworldEntityTypes.EMERALD_PROJECTILE.get(), shooter, world);
        }

        public EmeraldItemProjectile(World world, double x, double y, double z) {
            super(OverworldEntityTypes.EMERALD_PROJECTILE.get(), x, y, z, world);
        }

        @Override
        protected Item getDefaultItem() {
            return Items.EMERALD;
        }

        @OnlyIn(Dist.CLIENT)
        private IParticleData getParticle() {
            ItemStack item = this.getItemRaw();
            return (IParticleData) (item.isEmpty() ? ParticleTypes.ITEM : new ItemParticleData(ParticleTypes.ITEM, item));
        }

        @Override
        public void handleEntityEvent(byte amount) {
            if (amount == 3) {
                IParticleData particle = this.getParticle();

                for (int i = 0; i < 8; ++i) {
                    this.level.addParticle(particle, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
                }
            }
        }

        @Override
        protected void onHitEntity(EntityRayTraceResult result) {
            super.onHitEntity(result);
            Entity entity = result.getEntity();
            int damage = entity instanceof PlayerEntity ? 5 : 0;
            entity.hurt(DamageSource.thrown(this, this.getOwner()), (float) damage);
            entity.push(this.getDeltaMovement().x * 0.1, 0.1, this.getDeltaMovement().z * 0.1);
        }

        @Override
        protected void onHit(RayTraceResult result) {
            super.onHit(result);
            if (!this.level.isClientSide) {
                this.level.broadcastEntityEvent(this, (byte) 3);
                this.remove();
            }
        }

        @Override
        public IPacket<?> getAddEntityPacket() {
            return NetworkHooks.getEntitySpawningPacket(this);
        }
    }
}
