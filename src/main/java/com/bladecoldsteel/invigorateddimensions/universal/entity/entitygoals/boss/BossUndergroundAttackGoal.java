package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.IUndergroundMob;
import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.monster.UndergroundAttackGoal;

public class BossUndergroundAttackGoal extends UndergroundAttackGoal {
    protected final BossMonsterEntity boss;
    private final int combatCooldown;

    public BossUndergroundAttackGoal(IUndergroundMob mob, double speed, int stuckTimerLimit, int maxUndergroundTime, double attackDistance, int combatCooldown) {
        super(mob, speed, maxUndergroundTime, attackDistance, stuckTimerLimit);
        this.combatCooldown = combatCooldown;
        this.boss = (BossMonsterEntity) this.entityMob;
    }

    @Override
    public boolean canUse() {
        if (boss.getCurrentAction() == BossMonsterEntity.CombatAction.UNDERGROUND_ATTACK) {
            return super.canUse();
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (boss.getCurrentAction() == BossMonsterEntity.CombatAction.UNDERGROUND_ATTACK) {
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
