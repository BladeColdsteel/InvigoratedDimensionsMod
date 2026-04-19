package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.IUndergroundMob;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.passive.UndergroundMoveToGoal;

public class BossUndergroundMoveToGoal extends UndergroundMoveToGoal {
    protected final BossMonsterEntity boss;
    private final int combatCooldown;

    public BossUndergroundMoveToGoal(IUndergroundMob mob, double speed, int stuckTimerLimit, int maxUndergroundTime, int combatCooldown) {
        super(mob, speed, maxUndergroundTime, stuckTimerLimit);
        this.combatCooldown = combatCooldown;
        this.boss = (BossMonsterEntity) this.entityMob;
    }

    @Override
    public boolean canUse() {
        if (boss.getCurrentAction() == BossMonsterEntity.CombatAction.UNDERGROUND_MOVE) {
            return super.canUse();
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (boss.getCurrentAction() == BossMonsterEntity.CombatAction.UNDERGROUND_MOVE) {
            return super.canContinueToUse();
        } else {
            return false;
        }
    }

    @Override
    public void stop() {
        super.stop();
        boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
        boss.resetCombatCooldown(this.combatCooldown);
    }
}
