package com.bladecoldsteel.invigorateddimensions.dreamland.entity.custom.boss;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.BossMeleeGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.BossEffectGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.BossTeleportGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
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

public class PitulantPendulumEntity extends BossMonsterEntity implements IAnimatable {
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.idle");
    protected static final AnimationBuilder HYPNOTIZE = new AnimationBuilder().addAnimation("animation.hypnotize");
    protected static final AnimationBuilder BASH = new AnimationBuilder().addAnimation("animation.bash");

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public PitulantPendulumEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn, BossInfo.Color.PINK);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 450.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.1D)
                    .add(Attributes.FOLLOW_RANGE, 50.0D)
                    .add(Attributes.ATTACK_DAMAGE, 6.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 300.0D)
                    .add(Attributes.ARMOR, 2.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.1D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 300.0D)
                    .add(Attributes.ARMOR, 2.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.1D)
                    .add(Attributes.FOLLOW_RANGE, 45.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new BossEffectGoal(this, 0.0D, Effects.CONFUSION, 1, 200, true, true, 60));
        this.goalSelector.addGoal(1, new BossMeleeGoal(this, 0.1D, true, 40, 1.5D));
        this.goalSelector.addGoal(1, new BossTeleportGoal(this, 36, 60));
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BEACON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ANVIL_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ELDER_GUARDIAN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.METAL_STEP, 0.2F, 1.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    protected <E extends PitulantPendulumEntity> PlayState animationController(final AnimationEvent<E> event) {
        if (this.getCurrentAction() == CombatAction.EFFECT) {
            event.getController().setAnimation(HYPNOTIZE);
            return PlayState.CONTINUE;
        } else if (this.getCurrentAction() == CombatAction.MELEE) {
            event.getController().setAnimation(BASH);
            return PlayState.CONTINUE;
        } else if (this.getCurrentAction() == CombatAction.TELEPORT) {
            event.getController().setAnimation(HYPNOTIZE);
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
    public void chooseNextAction() {
        if (!isActionReady()) return;

        LivingEntity target = getTarget();
        double distanceSqr = this.distanceToSqr(target);

        if (distanceSqr < 9.0D) {
            setCurrentAction(random.nextBoolean() ? CombatAction.MELEE : CombatAction.EFFECT);
        } else if (distanceSqr < 64.0D) {
            setCurrentAction(random.nextBoolean() ? CombatAction.EFFECT : CombatAction.TELEPORT);
        } else {
            setCurrentAction(CombatAction.TELEPORT);
        }
    }
}
