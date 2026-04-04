package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.Hand;

public class BossMeleeGoal extends MeleeAttackGoal {
    private final int combatCooldown;
    private final double rangeControl;

    public BossMeleeGoal(CreatureEntity entity, double speedModifier, boolean followTarget, int combatCooldown, double rangeControl) {
        super(entity, speedModifier, followTarget);
        this.combatCooldown = combatCooldown;
        this.rangeControl = rangeControl;
    }

    @Override
    public boolean canUse() {
        if (((BossMonsterEntity) mob).getCurrentAction() == BossMonsterEntity.CombatAction.MELEE) {
            return super.canUse();
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (((BossMonsterEntity) mob).getCurrentAction() == BossMonsterEntity.CombatAction.MELEE) {
            return super.canContinueToUse();
        } else {
            return false;
        }
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity p_190102_1_, double p_190102_2_) {
        double d0 = this.getAttackReachSqr(p_190102_1_);
        if (p_190102_2_ <= d0 && this.isTimeToAttack()) {
            this.resetAttackCooldown();
            this.mob.swing(Hand.MAIN_HAND);
            this.mob.doHurtTarget(p_190102_1_);
            ((BossMonsterEntity) mob).resetCombatCooldown(this.combatCooldown);
            ((BossMonsterEntity) mob).setCurrentAction(BossMonsterEntity.CombatAction.NONE);
        }
    }

    @Override
    protected double getAttackReachSqr(LivingEntity target) {
        double baseReach = this.mob.getBbWidth() * 2.0F;
        double totalReach = baseReach + this.rangeControl;

        return totalReach * totalReach + target.getBbWidth();
    }

    @Override
    public void stop() {
        super.stop();
        ((BossMonsterEntity) mob).setCurrentAction(BossMonsterEntity.CombatAction.NONE);
    }
}
