package com.bladecoldsteel.invigorateddimensions.block.custom.trees;

import com.bladecoldsteel.invigorateddimensions.world.gen.ModConfiguredFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class ElectricallyChargedTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean b) {
        return ModConfiguredFeatures.ELECTRICALLY_CHARGED;
    }
}
