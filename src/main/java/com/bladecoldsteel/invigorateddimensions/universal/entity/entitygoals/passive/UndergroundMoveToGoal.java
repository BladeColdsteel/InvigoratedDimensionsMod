package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.passive;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.AbstractUndergroundGoal;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.IUndergroundMob;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.BlockPos;

public class UndergroundMoveToGoal extends AbstractUndergroundGoal {
    protected int undergroundTime = 0;
    protected final int maxUnderGroundTime;

    public UndergroundMoveToGoal(IUndergroundMob mob, double speed, int maxUndergroundTime, int stuckTimerLimit) {
        super(mob, (CreatureEntity) mob, speed, stuckTimerLimit);
        this.maxUnderGroundTime = maxUndergroundTime;
    }

    @Override
    public void tick() {
        if (target == null) return;

        undergroundTime++;

        if (undergroundTime == 1) {
            undergroundMob.enterUnderground();
        }

        if (undergroundTime < maxUnderGroundTime) {
            BlockPos targetPos = getUndergroundTargetPos();
            moveTowardsUnderground(targetPos);

            tickStuckCheck();
        } else {
            undergroundMob.exitUnderground();
        }
    }

    @Override
    public void start() {
        super.start();
        undergroundTime = 0;
        entityMob.getNavigation().stop();
        entityMob.getMoveControl().setWantedPosition(entityMob.getX(), entityMob.getY(), entityMob.getZ(), 0);
        entityMob.setDeltaMovement(0, 0, 0);
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse() && undergroundTime < maxUnderGroundTime;
    }
}
