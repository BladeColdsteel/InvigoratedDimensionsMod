package com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.custom;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.PassiveEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.ResetAngerGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
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
import java.util.Random;
import java.util.UUID;

public class ElementalShrineProtectorsEntity extends PassiveEntity implements IAngerable, IAnimatable {
    private static final RangedInteger PERSISTENT_ANGER_TIME = TickRangeConverter.rangeOfSeconds(20, 60);
    private int remainingPersistentAngerTime;
    private UUID persistentAngerTarget;
    protected static final AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("animation.walk");
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.idle");

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public ElementalShrineProtectorsEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);

        System.out.println("[Shrine Protector] CONSTRUCTED - Client: " + world.isClientSide);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return CreatureEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, MobEntity.class, 5, false, false, (p_234199_0_) -> {
            return p_234199_0_ instanceof IMob && !(p_234199_0_ instanceof CreeperEntity);
        }));
        this.targetSelector.addGoal(4, new ResetAngerGoal(this, false));
    }

    private boolean isAngryAt(Object o) {
        if (!EntityPredicates.ATTACK_ALLOWED.test((Entity) o)) {
            return false;
        }

        if (((Entity) o).getType() == EntityType.PLAYER && this.isAngryAtAllPlayers(((Entity) o).level)){
            return true;
        }

        return ((Entity) o).getUUID().equals(this.getPersistentAngerTarget());
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldHover()) {
            this.setNoGravity(true);
            double hoverMotion = Math.sin(this.tickCount * 0.1D) * 0.02D;

            this.setDeltaMovement(
                    this.getDeltaMovement().x,
                    hoverMotion,
                    this.getDeltaMovement().z);
        } else {
            this.setNoGravity(false);
            if (!this.isOnGround() && this.getDeltaMovement().y < 0.0D) {
                this.setDeltaMovement(
                        this.getDeltaMovement().x,
                        this.getDeltaMovement().y * 0.5D,
                        this.getDeltaMovement().z
                );
            }
        }
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return (int) (this.random.nextInt(20) + this.getHealth());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.2F, 1.0F);
    }

    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.randomValue(this.random));
    }

    public void setRemainingPersistentAngerTime(int angerTime) {
        this.remainingPersistentAngerTime = angerTime;
    }

    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    public void setPersistentAngerTarget(@Nullable UUID target) {
        this.persistentAngerTarget = target;
    }

    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    private boolean shouldHover() {
        int hoverGap = 2;
        BlockPos entityPos = this.blockPosition();
        for (int i = 0; i <= hoverGap; i++) {
            BlockPos checkPos = entityPos.below(i);
            if (!this.level.getBlockState(checkPos).is(Blocks.AIR)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected <E extends ElementalShrineProtectorsEntity> PlayState animationController(final AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(WALK_ANIM);
            return PlayState.CONTINUE;
        } else if (!event.isMoving()){
            event.getController().setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    public static boolean isValidShrineSpawn(ISeedReader world, BlockPos pos) {
        BlockState floor = world.getBlockState(pos.below());
        BlockState feet = world.getBlockState(pos);
        BlockState mid = world.getBlockState(pos.above());
        BlockState head = world.getBlockState(pos.above(2));

        return !floor.is(Blocks.AIR) && floor.getMaterial().isSolid() && feet.is(Blocks.AIR) && mid.is(Blocks.AIR) && head.is(Blocks.AIR);
    }
}
