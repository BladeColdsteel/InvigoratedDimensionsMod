package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals;

import net.minecraft.entity.LivingEntity;

public interface SpawnOnPlayer {
    void spawnOnPlayer(LivingEntity target, float distanceFactor);
}