package com.bladecoldsteel.invigorateddimensions.commands;

import net.minecraft.entity.Entity;
import net.minecraft.world.server.ServerWorld;

@FunctionalInterface
interface TargetListener {

    ServerWorld getTargetDimension(Entity target);

}
