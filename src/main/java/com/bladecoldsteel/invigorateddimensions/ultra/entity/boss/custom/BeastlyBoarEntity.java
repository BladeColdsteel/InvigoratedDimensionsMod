package com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.custom;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.projectile.BoarTuskProjectileEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossMeleeGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossRangedGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossRushGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class BeastlyBoarEntity extends BossMonsterEntity implements IAnimatable, IRangedAttackMob {
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.walk");

    private int tuskAttackDelay = 0;
    private LivingEntity tuskTarget;
    private int tusksThrown = 0;

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public BeastlyBoarEntity(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world, BossInfo.Color.GREEN);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 500.0D)
                    .add(Attributes.ARMOR, 1.5D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D)
                    .add(Attributes.FOLLOW_RANGE, 65.0D)
                    .add(Attributes.ATTACK_DAMAGE, 15.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 300.0D)
                    .add(Attributes.ARMOR, 1.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 0.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D)
                    .add(Attributes.FOLLOW_RANGE, 40.0D)
                    .add(Attributes.ATTACK_DAMAGE, 7.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 300.0D)
                    .add(Attributes.ARMOR, 1.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 0.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.2D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D)
                    .add(Attributes.FOLLOW_RANGE, 40.0D)
                    .add(Attributes.ATTACK_DAMAGE, 7.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new BossMeleeGoal(this, 0.1D, true, 60, 1.5D));
        this.goalSelector.addGoal(1, new BossRangedGoal(this, 0.1D, 10, 20, 16.0F, 40));
        this.goalSelector.addGoal(1, new BossRushGoal(this, 60, 90, 15.0D, 10.0F));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.HOGLIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HOGLIN_DEATH;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide() && this.tuskAttackDelay > 0) {
            this.tuskAttackDelay--;

            if (this.tuskAttackDelay == 0 && this.tuskTarget != null && this.tuskTarget.isAlive()) {
                this.throwTusk(this.tuskTarget);
                this.tusksThrown++;

                if (this.tusksThrown < 5) {
                    this.tuskAttackDelay = 10;
                } else {
                    this.tuskTarget = null;
                    this.tusksThrown = 0;
                    this.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
                    this.resetCombatCooldown(60);
                }
            }
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected <E extends BeastlyBoarEntity> PlayState animationController(final AnimationEvent<E> event) {
        event.getController().setAnimation(IDLE_ANIM);
        return PlayState.CONTINUE;
    }

    @Override
    public void chooseNextAction() {
        if (!isActionReady()) return;

        LivingEntity target = getTarget();
        if (target == null || !target.isAlive()) return;
        double distanceSqr = this.distanceToSqr(target);

        if (distanceSqr < 16.0D) {
            setCurrentAction(random.nextBoolean() ? BossMonsterEntity.CombatAction.MELEE : CombatAction.RUSH);
        } else if (distanceSqr < 256.0D) {
            setCurrentAction(random.nextBoolean() ? CombatAction.RUSH : CombatAction.RANGED);
        } else if (distanceSqr < 512.0D){
            setCurrentAction(CombatAction.RANGED);
        } else {
            setCurrentAction(CombatAction.NONE);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        this.tuskTarget = target;
        this.tuskAttackDelay = 8;
    }

    private void throwTusk(LivingEntity target) {
        BoarTuskProjectileEntity tusk = new BoarTuskProjectileEntity(this, this.level);

        double localX = -0.75D;
        double localY = 1.8D;
        double localZ = 0.15D;

        double yawRad = Math.toRadians(this.yBodyRot);

        double rotatedX = localX * Math.cos(yawRad) - localZ * Math.sin(yawRad);
        double rotatedZ = localX * Math.sin(yawRad) + localZ * Math.cos(yawRad);

        double spawnX = this.getX() + rotatedX;
        double spawnY = this.getY() + localY;
        double spawnZ = this.getZ() + rotatedZ;

        tusk.setPos(spawnX, spawnY, spawnZ);

        double targetY = target.getEyeY() - 1.1D;
        double dx = target.getX() - spawnX;
        double dy = targetY - spawnY;
        double dz = target.getZ() - spawnZ;

        float arc = MathHelper.sqrt(dx * dx + dz * dz) * 0.2F;

        tusk.shoot(dx, dy + arc, dz, 1.6F, 2.0F);

        this.playSound(SoundEvents.EGG_THROW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(tusk);
    }
}
