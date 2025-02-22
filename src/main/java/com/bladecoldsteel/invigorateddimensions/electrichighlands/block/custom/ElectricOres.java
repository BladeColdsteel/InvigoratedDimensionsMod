package com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ElectricOres extends OreBlock {
    public ElectricOres(Properties properties) {
        super(properties);
    }

    @Override
    protected int xpOnDrop(Random random) {
        if (this == ElectricHighlandsBlocks.CHARGED_COAL_ORE.get()) {
            return MathHelper.nextInt(random, 0, 2);
        } else {
            return this == ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE.get()
                    || this == ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE.get()
                    || this == ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE.get() ? MathHelper.nextInt(random, 4, 8) : 0;
        }
    }
}
