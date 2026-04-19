package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.boss;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import java.util.EnumSet;

public class BossEffectGoal extends Goal {
    private LivingEntity target;
    private final BossMonsterEntity boss;
    private int seeTime;
    private final int combatCooldown;
    private final double speedModifier;
    private final Effect goalEffect;
    private final int effectLevel;
    private final int effectTime;
    private final boolean visibleEffect;
    private final boolean showIcon;

    public BossEffectGoal(BossMonsterEntity entity, double speedModifier, Effect effect, int effectLevel, int effectTime, boolean visibleEffect, boolean showIcon, int combatCooldown) {
        this.boss = entity;
        this.speedModifier = speedModifier;
        this.goalEffect = effect;
        this.effectLevel = effectLevel;
        this.effectTime = effectTime;
        this.visibleEffect = visibleEffect;
        this.showIcon = showIcon;
        this.combatCooldown = combatCooldown;

        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public void stop() {
        this.target = null;
        this.seeTime = 0;
    }

    @Override
    public void tick() {
        if (this.target != null && this.target.isAlive()) {
            boolean canSeeTarget = this.boss.getSensing().canSee(this.target);

            if (canSeeTarget) {
                ++this.seeTime;
            } else {
                this.seeTime = 0;
            }

            if (this.seeTime == 60) {
                this.boss.getNavigation().stop();

                this.target.addEffect(new EffectInstance(goalEffect, this.effectTime, this.effectLevel, true, visibleEffect, showIcon));
                this.target.addEffect(new EffectInstance(Effects.WITHER, this.effectTime, 1, true, visibleEffect, showIcon));

                boss.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
                boss.resetCombatCooldown(this.combatCooldown);

            } else {
                this.boss.getNavigation().moveTo(this.target, this.speedModifier);
            }

            this.boss.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.boss.getTarget();
        if (boss.isTargetValid() && boss.getCurrentAction() == BossMonsterEntity.CombatAction.EFFECT) {
            this.target = target;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.target != null && this.target.isAlive() && boss.getCurrentAction() == BossMonsterEntity.CombatAction.EFFECT;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }
}
