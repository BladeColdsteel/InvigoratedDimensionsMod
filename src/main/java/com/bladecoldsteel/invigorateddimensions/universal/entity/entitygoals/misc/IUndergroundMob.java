package com.bladecoldsteel.invigorateddimensions.universal.entity.entitygoals.misc;

import net.minecraft.util.math.BlockPos;

public interface IUndergroundMob {
    boolean isUnderground();
    void enterUnderground();
    void exitUnderground();
    boolean canTunnel(BlockPos pos);
}
