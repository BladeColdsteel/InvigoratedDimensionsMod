package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.goal.RangedAttackGoal;

public class BossRangedGoal extends RangedAttackGoal {
    protected final BossMonsterEntity boss;
    private final int combatCooldown;
    private final int maxActionTime;
    private int actionTime;

    public BossRangedGoal(IRangedAttackMob mob, double speed, int attackIntervalMin, int attackIntervalMax, float attackRadius, int combatCooldown) {
        super(mob, speed, attackIntervalMin, attackIntervalMax, attackRadius);
        this.boss = (BossMonsterEntity) mob;
        this.combatCooldown = combatCooldown;
        this.maxActionTime = attackIntervalMax + this.combatCooldown;
    }

    @Override
    public void tick() {
        super.tick();
        this.actionTime++;

        if (this.actionTime >= this.maxActionTime) {
            boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
            boss.resetCombatCooldown(this.combatCooldown);
        }
    }

    @Override
    public boolean canUse() {
        if (boss.getCurrentAction() != BossMonsterEntity.CombatAction.RANGED) {
            return false;
        }
        boolean canUse = super.canUse();
        if (!canUse) {
            boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
            boss.resetCombatCooldown(this.combatCooldown);
        }

        return canUse;
    }

    @Override
    public boolean canContinueToUse() {
        return boss.getCurrentAction() == BossMonsterEntity.CombatAction.RANGED && this.actionTime < this.maxActionTime && super.canContinueToUse();
    }

    @Override
    public void start() {
        super.start();
        this.actionTime = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.actionTime = 0;
        if (boss.getCurrentAction() == BossMonsterEntity.CombatAction.RANGED) {
            boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
            boss.resetCombatCooldown(this.combatCooldown);
        }
    }
}
