package com.bladecoldsteel.invigorateddimensions.universal.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class MobSpawnPlacements {
    public static <T extends MobEntity> void registerOnGroundSolidSpawn(EntityType<T> entityType, int lightLevel) {
        EntitySpawnPlacementRegistry.register(
                entityType,
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                createSpawnPredicate(lightLevel)
        );
    }

    private static <T extends MobEntity> EntitySpawnPlacementRegistry.IPlacementPredicate<T> createSpawnPredicate(int lightLevel) {
        return (type, world, reason, pos, random) -> {
            BlockPos below = pos.below();
            BlockState blockBelow = world.getBlockState(below);
            boolean solidGround = !blockBelow.getCollisionShape(world, below).isEmpty();

            if (!solidGround) return false;

            if (lightLevel >= 0) {
                int light = world.getLightEmission(pos);
                return light <= lightLevel;
            }

            return true;
        };
    }
}
