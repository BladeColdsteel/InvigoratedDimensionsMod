package com.bladecoldsteel.invigorateddimensions.terranata.entity.custom;

import com.bladecoldsteel.invigorateddimensions.config.InvigoratedDimensionsConfig;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossMeleeGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossUndergroundAttackGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss.BossUndergroundMoveToGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.IUndergroundMob;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
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

public class GiantEarthmawEntity extends BossMonsterEntity implements IAnimatable, IUndergroundMob {
    protected static final AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.idle");

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private boolean underground;

    public GiantEarthmawEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn, BossInfo.Color.YELLOW);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("progressive")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 525.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.5D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                    .add(Attributes.MOVEMENT_SPEED, 0.35D)
                    .add(Attributes.FOLLOW_RANGE, 60.0D)
                    .add(Attributes.ATTACK_DAMAGE, 13.0D);
        } else if (InvigoratedDimensionsConfig.DIFFICULTY_MODE.get().equalsIgnoreCase("linear")) {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 350.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                    .add(Attributes.MOVEMENT_SPEED, 0.35D)
                    .add(Attributes.FOLLOW_RANGE, 55.0D)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D);
        } else {
            return MonsterEntity.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 350.0D)
                    .add(Attributes.ARMOR, 3.0D)
                    .add(Attributes.ARMOR_TOUGHNESS, 1.0D)
                    .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                    .add(Attributes.MOVEMENT_SPEED, 0.35D)
                    .add(Attributes.FOLLOW_RANGE, 55.0D)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new BossMeleeGoal(this, 0.25D, true, 60, 1.0D));
        this.goalSelector.addGoal(1, new BossUndergroundMoveToGoal(this, 0.25D, 110, 100, 120));
        this.goalSelector.addGoal(1, new BossUndergroundAttackGoal(this, 0.25D, 110, 100, 3.0D, 120));
    }

    //@Override
    //public void tick() {
        //super.tick();
        //if (this.isUnderground()) {
            //BlockPos pos = this.blockPosition();

            //if (!canTunnel(pos) && (this.level.isEmptyBlock(pos.above()) || !canTunnel(pos.above()))) {
                //this.setPos(this.getX(), this.getY() - 0.5D, this.getZ());
            //}
        //}
    //}

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.HOGLIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.HOGLIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HOGLIN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.HOGLIN_STEP, 0.2F, 1.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Animations", 5, this::animationController));
    }

    protected <E extends GiantEarthmawEntity> PlayState animationController(final AnimationEvent<E> event) {
            event.getController().setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
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

        if (distanceSqr < 16.0D) {
            setCurrentAction(random.nextBoolean() ? BossMonsterEntity.CombatAction.MELEE : CombatAction.UNDERGROUND_ATTACK);
        } else if (distanceSqr < 64.0D) {
            setCurrentAction(random.nextBoolean() ? CombatAction.UNDERGROUND_MOVE : CombatAction.UNDERGROUND_ATTACK);
        } else {
            setCurrentAction(CombatAction.UNDERGROUND_MOVE);
        }
    }

    @Override
    public boolean isUnderground() {
        return this.underground;
    }

    @Override
    public void enterUnderground() {
        this.underground = true;

        this.getNavigation().stop();
        this.getMoveControl().setWantedPosition(this.getX(), this.getY(), this.getZ(), 0);
        this.setDeltaMovement(0, 0, 0);
        this.noPhysics = true;
        this.setNoGravity(true);



        BlockPos base = this.blockPosition();

        for (int i = 1; i <= 3; i++) {
            BlockPos below = base.below(i);
            if (canTunnel(below)) {
                this.setPos(this.getX(),below.getY() - 3.0D, this.getZ());
                break;
            }
        }
    }

    @Override
    public void exitUnderground() {
        if (this.isUnderground()) {

            BlockPos basePos = this.blockPosition();

            for (int i = 0; i <= 10; i++) {
                BlockPos candidate = basePos.above(i);

                boolean feetClear = this.level.isEmptyBlock(candidate);
                boolean sidesClear = this.level.isEmptyBlock(candidate.east()) && this.level.isEmptyBlock(candidate.west()) && this.level.isEmptyBlock(candidate.north()) && this.level.isEmptyBlock(candidate.south());

                if (feetClear && sidesClear) {
                    this.moveTo(candidate.getX() + 0.5D, candidate.getY(), candidate.getZ() + 0.5D, this.yRot, this.xRot);
                    this.noPhysics = false;
                    this.setNoGravity(false);
                    this.underground = false;
                    return;
                } else if (i == 10){
                    for (int j = 0; j <= 10; j++) {
                        candidate = basePos.above(j + i);

                        feetClear = this.level.isEmptyBlock(candidate);
                        sidesClear = this.level.isEmptyBlock(candidate.east()) && this.level.isEmptyBlock(candidate.west()) && this.level.isEmptyBlock(candidate.north()) && this.level.isEmptyBlock(candidate.south());

                        if (feetClear && sidesClear) {
                            this.moveTo(candidate.getX() + 0.5D, candidate.getY(), candidate.getZ() + 0.5D, this.yRot, this.xRot);
                            this.noPhysics = false;
                            this.setNoGravity(false);
                            this.underground = false;
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canTunnel(BlockPos pos) {
        BlockState state = this.level.getBlockState(pos);
        Material material = state.getMaterial();

        return material == Material.DIRT
                || material == Material.SAND
                || material == Material.CLAY
                || material == Material.GRASS
                || material == Material.TOP_SNOW;
    }
}