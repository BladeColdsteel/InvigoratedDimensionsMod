package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SmashNearbyGoal extends Goal {
    private LivingEntity target;
    private final float attackRadius;
    private final float attackRadiusSqr;
    protected final CreatureEntity mob;

    public SmashNearbyGoal(CreatureEntity entity, int attackRadius) {
        this.mob = entity;
        this.attackRadius = attackRadius;
        this.attackRadiusSqr = attackRadius * attackRadius;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.mob.getTarget();
        if (target != null && target.isAlive() && target.distanceTo(mob) <= attackRadius) {
            this.target = target;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.target != null && this.target.isAlive() && this.target.distanceTo(mob) <= attackRadius;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }
}
