package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.monster;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.IUndergroundMob;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.passive.UndergroundMoveToGoal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;

public class UndergroundAttackGoal extends UndergroundMoveToGoal {
    private final double attackDistance;
    public UndergroundAttackGoal(IUndergroundMob mob, double speed, int maxUndergroundTime, double attackDistance, int stuckTimerLimit) {
        super(mob, speed, maxUndergroundTime, stuckTimerLimit);
        this.attackDistance = attackDistance;
    }

    @Override
    public void tick() {
        if (target == null) return;

        undergroundTime++;

        if (undergroundTime == 1) {
            undergroundMob.enterUnderground();
        }

        if (undergroundTime < maxUnderGroundTime) {
            if (this.isHorizontallyCloseTo(getTargetPos(), attackDistance)) {
                checkAndPerformAttack(target);
            } else {
                moveTowardsUnderground(getUndergroundTargetPos());
            }

            tickStuckCheck();
        } else {
            undergroundMob.exitUnderground();
        }
    }

    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.isValidTarget(target)) {
            this.entityMob.swing(Hand.MAIN_HAND);
            this.entityMob.doHurtTarget(target);
        }
    }
}
