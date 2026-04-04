package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals;

import com.bladecoldsteel.invigorateddimensions.universal.entity.entitybases.BossMonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;

public class BossTeleportGoal extends Goal {
    private final BossMonsterEntity mob;
    private LivingEntity target;
    private int teleportTime;
    private int teleportDistance;
    private final int combatCooldown;

    public BossTeleportGoal(BossMonsterEntity entity, int teleportDistance, int combatCooldown) {
        this.mob = entity;
        this.teleportDistance = teleportDistance;
        this.combatCooldown = combatCooldown;

        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        this.target = this.mob.getTarget();
        return target != null && target.isAlive() && mob.getCurrentAction() == BossMonsterEntity.CombatAction.TELEPORT;
    }

    @Override
    public boolean canContinueToUse() {
        this.target = this.mob.getTarget();
        return target != null && target.isAlive() && mob.getCurrentAction() == BossMonsterEntity.CombatAction.TELEPORT;
    }

    @Override
    public void start() {
        this.target = this.mob.getTarget();
        this.teleportTime = 20;
    }

    @Override
    public void stop() {
        this.target = null;
        this.teleportTime = 20;
    }

    @Override
    public void tick() {
        if (target != null && target.isAlive() && mob.getCurrentAction() == BossMonsterEntity.CombatAction.TELEPORT) {
            World world = mob.level;
            if (this.teleportTime <= 0) {
                float xOffset = mob.getRandom().nextInt(teleportDistance + 1) - ((float) teleportDistance / 2);
                float yOffset = mob.getRandom().nextFloat();
                float zOffset = mob.getRandom().nextInt(teleportDistance + 1) - ((float) teleportDistance / 2);

                BlockPos randomTP = new BlockPos(mob.getX() + xOffset, mob.getY() + yOffset, mob.getZ() + zOffset);

                boolean feetOpen = !world.getBlockState(randomTP).isCollisionShapeFullBlock(world, randomTP);
                boolean headOpen = !world.getBlockState(randomTP.above()).isCollisionShapeFullBlock(world, randomTP.above());
                boolean topOpen = !world.getBlockState(randomTP.above(2)).isCollisionShapeFullBlock(world, randomTP.above(2));
                boolean groundSolid = world.getBlockState(randomTP.below()).isCollisionShapeFullBlock(world, randomTP.below());

                if (feetOpen && headOpen && topOpen && groundSolid) {
                    if (this.mob.randomTeleport(randomTP.getX() + 0.5, randomTP.getY(), randomTP.getZ() + 0.5, false)) {
                        mob.setCurrentAction(BossMonsterEntity.CombatAction.NONE);
                        mob.resetCombatCooldown(this.combatCooldown);
                    }
                }
            } else {
                --this.teleportTime;
            }
        }
    }
}
