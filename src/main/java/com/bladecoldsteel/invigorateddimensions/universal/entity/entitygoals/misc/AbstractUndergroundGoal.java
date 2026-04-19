package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;

public abstract class AbstractUndergroundGoal extends Goal {
    protected final IUndergroundMob undergroundMob;
    protected final CreatureEntity entityMob;
    protected LivingEntity target;

    protected int recalcTimer;
    protected int stuckTimer;
    protected int stuckTimerLimit;

    protected final double speed;

    public AbstractUndergroundGoal(IUndergroundMob undergroundMob, CreatureEntity entityMob, double speed, int stuckTimerLimit) {
        this.undergroundMob = undergroundMob;
        this.entityMob = entityMob;
        this.speed = speed;
        this.stuckTimerLimit = stuckTimerLimit;

        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        this.target = entityMob.getTarget();
        return isValidTarget(this.target);
    }

    @Override
    public boolean canContinueToUse() {
        return isValidTarget(this.target);
    }

    @Override
    public void start() {
        this.recalcTimer = 0;
        this.stuckTimer = 0;
    }

    @Override
    public void stop() {
        this.target = null;
    }

    protected boolean isValidTarget(LivingEntity target) {
        return target != null && target.isAlive();
    }

    protected double distancetoTargetSqr() {
        return this.target == null ? Double.MAX_VALUE : this.entityMob.distanceToSqr(this.target);
    }

    protected boolean isValidUndergroundPosition(BlockPos pos) {
        return undergroundMob.canTunnel(pos) && undergroundMob.canTunnel(pos.above());
    }

    protected void moveTowards(BlockPos targetPos) {
        Vector3d current = entityMob.position();
        Vector3d targetVec = new Vector3d(
                targetPos.getX() + 0.5,
                targetPos.getY() + 0.5,
                targetPos.getZ() + 0.5
        );

        Vector3d direction = targetVec.subtract(current);

        if (direction.lengthSqr() > 0.0001) {
            direction = direction.normalize().scale(speed);
            entityMob.setDeltaMovement(direction);
        }
    }

    protected void moveTowardsUnderground(BlockPos targetPos) {
        Vector3d current = entityMob.position();
        Vector3d targetVec = new Vector3d(
                targetPos.getX() + 0.5,
                current.y,
                targetPos.getZ() + 0.5
        );

        Vector3d direction = targetVec.subtract(current);

        if (direction.lengthSqr() > 0.0001) {
            direction = direction.normalize().scale(speed);
            entityMob.setDeltaMovement(direction);
        }
    }

    protected boolean isCloseTo(BlockPos pos, double distance) {
        return entityMob.position().distanceToSqr(
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5
        ) <= distance * distance;
    }

    protected void tickStuckCheck() {
        stuckTimer++;

        if (stuckTimer > stuckTimerLimit) {
            undergroundMob.exitUnderground();
            stuckTimer = 0;
        }
    }

    protected BlockPos getTargetPos() {
        return target != null ? target.blockPosition() : entityMob.blockPosition();
    }

    protected BlockPos getUndergroundTargetPos() {
        if (target == null) {
            return entityMob.blockPosition();
        }

        BlockPos targetPos = target.blockPosition();
        return new BlockPos(targetPos.getX(), entityMob.blockPosition().getY(), targetPos.getZ());
    }

    protected boolean isHorizontallyCloseTo(BlockPos pos, double distance) {
        double dx = entityMob.getX() - (pos.getX() + 0.5D);
        double dz = entityMob.getZ() - (pos.getZ() + 0.5D);
        return (dx * dx + dz * dz) <= distance * distance;
    }
}
