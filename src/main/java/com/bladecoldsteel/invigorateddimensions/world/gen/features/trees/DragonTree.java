package com.bladecoldsteel.invigorateddimensions.world.gen.features.trees;

import com.bladecoldsteel.invigorateddimensions.world.gen.features.DragonFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class DragonTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean b) {
        return DragonFeatures.ConfiguredFeatures.DRACONIC_TREE;
    }
}
