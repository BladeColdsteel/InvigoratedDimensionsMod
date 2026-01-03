package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;

import java.util.EnumSet;

public class GrowTreeGoal<T extends CreatureEntity & SpawnOnPlayer> extends Goal {
    private final T mob;
    private LivingEntity target;
    private int attackTime;
    private int seeTime;
    private final double speedModifier;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;

    public GrowTreeGoal(T mob, double speedModifier, int attackIntervalMin, int attackIntervalMax, int attackRadius) {
        this.attackTime = -1;
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.attackIntervalMin = attackIntervalMin;
        this.attackIntervalMax = attackIntervalMax;
        this.attackRadius = attackRadius;
        this.attackRadiusSqr = attackRadius * attackRadius;
        this.target = this.mob.getTarget();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public void stop() {
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.mob.getTarget();
        if (target != null && target.isAlive() && target.distanceTo(mob) <= attackRadius && target.distanceTo(mob) >= 3) {
            this.target = target;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.target != null && this.target.isAlive() && this.target.distanceTo(mob) <= attackRadius && target.distanceTo(mob) >= 3;
    }

    @Override
    public void tick() {
        if (this.target != null && this.target.isAlive() && this.target.distanceTo(mob) <= attackRadius && target.distanceTo(mob) >= 3) {
            double distanceToTargetSqr = this.mob.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
            boolean canSeeTarget = this.mob.getSensing().canSee(this.target);

            if (canSeeTarget) {
                ++this.seeTime;
            } else {
                this.seeTime = 0;
            }

            if (!(distanceToTargetSqr > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
                this.mob.getNavigation().stop();
            } else {
                this.mob.getNavigation().moveTo(this.target, this.speedModifier);
            }

            this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

            float distance;
            if (--this.attackTime == 0) {
                distance = this.attackRadius / MathHelper.sqrt(distanceToTargetSqr);
                float distanceClamp = distance;
                distanceClamp = MathHelper.clamp(distanceClamp, 0.1F, 1.0F);
                this.mob.spawnOnPlayer(this.target, distanceClamp);
                this.attackTime = MathHelper.floor(distance * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
            } else if (this.attackTime < 0) {
                distance = this.attackRadius / MathHelper.sqrt(distanceToTargetSqr);
                this.attackTime = MathHelper.floor(distance * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
            }
        }
    }
}
