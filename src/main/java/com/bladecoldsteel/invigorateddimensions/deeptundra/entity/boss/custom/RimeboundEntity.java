package com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.projectile.custom.HarmfulSnowballEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossBreathGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossMeleeGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossRangedGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.ICombatAnimatedBoss;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
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

public class RimeboundEntity extends BossMonsterEntity implements IAnimatable, IRangedAttackMob, ICombatAnimatedBoss {
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.idle");
    protected static final AnimationBuilder SNOWBALL_ANIM = new AnimationBuilder().addAnimation("animation.snowball");
    protected static final AnimationBuilder BREATH_ANIM = new AnimationBuilder().addAnimation("animation.frost_breath");
    private int snowballAttackDelay = 0;
    private LivingEntity snowballTarget;
    private int snowballsThrown = 0;

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public RimeboundEntity(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world, BossInfo.Color.BLUE);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 350.0D)
                    .add(Attributes.ARMOR, 6.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.0D)
                    .add(Attributes.FOLLOW_RANGE, 55.0D)
                    .add(Attributes.ATTACK_DAMAGE, 15.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 350.0D)
                    .add(Attributes.ARMOR, 5.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.0D)
                    .add(Attributes.FOLLOW_RANGE, 40.0D)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 350.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.0D)
                    .add(Attributes.FOLLOW_RANGE, 40.0D)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new BossMeleeGoal(this, 0.0D, true, 40, 1.5D));
        this.goalSelector.addGoal(1, new BossRangedGoal(this, 0.0D, 3, 10, 64.0F, 40));
        this.goalSelector.addGoal(1, new BossBreathGoal(this, 40, 200,
                ParticleTypes.END_ROD, 16.0D, 50.0D, 40, 0.05D, 3.0F, 10,
                Effects.MOVEMENT_SLOWDOWN, 0, 200, false, false));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide() && this.snowballAttackDelay > 0) {
            this.snowballAttackDelay--;

            if (this.snowballAttackDelay == 0 && this.snowballTarget != null && this.snowballTarget.isAlive()) {
                this.throwSnowballAt(this.snowballTarget);
                this.snowballsThrown++;

                if (this.snowballsThrown < 5) {
                    this.snowballAttackDelay = 8;
                } else {
                    this.snowballTarget = null;
                    this.snowballsThrown = 0;
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

    protected <E extends RimeboundEntity> PlayState animationController(final AnimationEvent<E> event) {
        if (this.getCurrentAction() == CombatAction.BREATH) {
            event.getController().setAnimation(BREATH_ANIM);
            return PlayState.CONTINUE;
        } else if (this.getCurrentAction() == CombatAction.RANGED) {
            event.getController().setAnimation(SNOWBALL_ANIM);
            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
        }
    }

    @Override
    public void chooseNextAction() {
        if (!isActionReady()) return;

        LivingEntity target = getTarget();
        if (target == null || !target.isAlive()) return;
        double distanceSqr = this.distanceToSqr(target);

        if (distanceSqr < 64.0D) {
            setCurrentAction(random.nextBoolean() ? BossMonsterEntity.CombatAction.MELEE : CombatAction.BREATH);
        } else if (distanceSqr < 256.0D) {
            setCurrentAction(random.nextBoolean() ? CombatAction.BREATH : CombatAction.RANGED);
        } else if (distanceSqr < 512.0D){
            setCurrentAction(CombatAction.RANGED);
        } else {
            setCurrentAction(CombatAction.NONE);
        }
    }

    @Override
    public void reloadCombatAnimations() {
        AnimationController<?> controller = this.factory
                .getOrCreateAnimationData(this.hashCode())
                .getAnimationControllers()
                .get("Animations");

        if (controller != null) {
            controller.markNeedsReload();
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        this.snowballTarget = target;
        this.snowballAttackDelay = 8;
    }

    private void throwSnowballAt(LivingEntity target) {
        HarmfulSnowballEntity snowball = new HarmfulSnowballEntity(this.level, this);

        double localX = -0.75D;
        double localY = 1.8D;
        double localZ = 0.15D;

        double yawRad = Math.toRadians(this.yBodyRot);

        double rotatedX = localX * Math.cos(yawRad) - localZ * Math.sin(yawRad);
        double rotatedZ = localX * Math.sin(yawRad) + localZ * Math.cos(yawRad);

        double spawnX = this.getX() + rotatedX;
        double spawnY = this.getY() + localY;
        double spawnZ = this.getZ() + rotatedZ;

        snowball.setPos(spawnX, spawnY, spawnZ);

        double targetY = target.getEyeY() - 1.1D;
        double dx = target.getX() - spawnX;
        double dy = targetY - spawnY;
        double dz = target.getZ() - spawnZ;

        float arc = MathHelper.sqrt(dx * dx + dz * dz) * 0.2F;

        snowball.shoot(dx, dy + arc, dz, 1.6F, 2.0F);

        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowball);
    }
}
