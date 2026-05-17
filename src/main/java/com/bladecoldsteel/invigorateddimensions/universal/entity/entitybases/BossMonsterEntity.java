package com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc.ICombatAnimatedBoss;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

import javax.annotation.Nullable;

public class BossMonsterEntity extends MonsterEntity {
    private final ServerBossInfo bossEvent;

    private BossMonsterEntity.CombatAction currentAction = BossMonsterEntity.CombatAction.NONE;
    private int combatCooldown = 0;

    public enum CombatAction {
        NONE,
        MELEE,
        RANGED,
        TELEPORT,
        EFFECT,
        BREATH,
        UNDERGROUND_MOVE,
        UNDERGROUND_ATTACK
    }

    public BossMonsterEntity(EntityType<? extends MonsterEntity> type, World world, BossInfo.Color color) {
        super(type, world);
        this.bossEvent = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), color, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.addGoal(6, new MoveTowardsTargetGoal(this, 0.75D, 45.0F));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public BossMonsterEntity.CombatAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(BossMonsterEntity.CombatAction action) {
        if (this.currentAction != action) {
            this.currentAction = action;

            if (this instanceof ICombatAnimatedBoss) {
                ((ICombatAnimatedBoss) this).reloadCombatAnimations();
            }
        }

    }

    public boolean isActionReady() {
        return combatCooldown <= 0 && currentAction == BossMonsterEntity.CombatAction.NONE;
    }

    public void resetCombatCooldown(int ticks) {
        this.combatCooldown = ticks;
    }

    @Override
    public void tick() {
        super.tick();

        if (combatCooldown > 0) {
            combatCooldown--;
        }

        if (!level.isClientSide && isTargetValid()) {
            chooseNextAction();
        }
    }

    @Override
    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    protected int getExperienceReward(PlayerEntity player) {
        return (int) (this.random.nextInt(40) + this.getHealth());
    }

    @Override
    public void setCustomName(@Nullable ITextComponent name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void checkDespawn() {
        if (this.level.getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.remove();
        } else {
            this.noActionTime = 0;
        }
    }

    public void chooseNextAction() {
        if (!isActionReady()) return;

        this.setCurrentAction(CombatAction.MELEE);
    }

    public boolean isTargetValid() {
        LivingEntity target = getTarget();
        return target != null && target.isAlive();
    }
}
