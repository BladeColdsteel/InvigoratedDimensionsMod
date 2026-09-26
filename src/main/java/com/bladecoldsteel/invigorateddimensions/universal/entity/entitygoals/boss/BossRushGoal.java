package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;

public class BossRushGoal extends Goal {
    private final BossMonsterEntity boss;
    private final int combatCooldown;
    private LivingEntity target;
    private final float attackDamage;

    private final int maxRushTimer;
    private int rushTimer;
    private final double rushRange;
    private Vector3d rushPos;
    private RushPhases phase;

    public BossRushGoal(BossMonsterEntity entity, int combatCooldown, int rushTimer, double rushRange, float attackDamage) {
        this.boss = entity;
        this.combatCooldown = combatCooldown;
        this.attackDamage = attackDamage;

        this.maxRushTimer = rushTimer;
        this.rushRange = rushRange;

        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public void tick() {
        this.rushTimer--;

        if (target != null && !target.isAlive()) {
            stop();
            return;
        }
        if (this.phase == RushPhases.BUILDUP) {
            this.boss.getLookControl().setLookAt(this.target, 45.0F, 45.0F);
            this.boss.getNavigation().stop();
            if (this.rushTimer <= this.maxRushTimer * .9) {
                this.phase = RushPhases.CHARGE;
            }
        } else if (this.phase == RushPhases.CHARGE) {
            this.boss.getNavigation().setSpeedModifier(1.5D);
            AxisAlignedBB bossBounding = this.boss.getBoundingBox();
            AxisAlignedBB targetBounding = target.getBoundingBox();
            this.boss.getNavigation().moveTo(rushPos.x, rushPos.y, rushPos.z, 1.5F);
            if (bossBounding.intersects(targetBounding)) {
                double targetDifferenceX = this.boss.getX() - target.getX();
                double targetDifferenceZ = this.boss.getZ() - target.getZ();
                target.hurt(DamageSource.mobAttack(this.boss), this.attackDamage);
                target.knockback(1.0F, targetDifferenceX, targetDifferenceZ);
            }
            if (this.rushTimer <= this.maxRushTimer * .2) {
                this.phase = RushPhases.PAUSE;
            }
        } else if (this.phase == RushPhases.PAUSE) {
            this.boss.getLookControl().setLookAt(this.target, 45.0F, 45.0F);
            this.boss.getNavigation().stop();
        } else {
            stop();
        }

        if (this.rushTimer <= 0) {
            stop();
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.boss.getTarget();

        if (!(target instanceof PlayerEntity)) {
            return false;
        }

        if (boss.isTargetValid() && boss.getCurrentAction() == BossMonsterEntity.CombatAction.RUSH
                && boss.distanceTo(target) <= this.rushRange && boss.distanceTo(target) >= 3.0F) {
            this.target = target;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.rushTimer > 0 && boss.getCurrentAction() == BossMonsterEntity.CombatAction.RUSH && boss.isAlive();
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        this.rushTimer = this.maxRushTimer;
        this.boss.getLookControl().setLookAt(this.target, 45.0F, 45.0F);
        this.boss.getNavigation().stop();
        this.rushPos = this.target.position();
        this.phase = RushPhases.BUILDUP;
    }

    @Override
    public void stop() {
        this.target = null;
        this.rushPos = null;
        this.rushTimer = 0;
        this.boss.getNavigation().stop();
        boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
        boss.resetCombatCooldown(this.combatCooldown);
    }

    private enum RushPhases {
        BUILDUP,
        CHARGE,
        PAUSE
    }
}
