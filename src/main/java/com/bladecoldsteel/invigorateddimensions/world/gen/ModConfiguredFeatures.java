package com.bladecoldsteel.invigorateddimensions.world.gen;


import com.bladecoldsteel.invigorateddimensions.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModConfiguredFeatures {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ELECTRICALLY_CHARGED =
            register("electrically_charged", Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.ELECTRICALLY_CHARGED_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(ModBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                            new SpruceFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(2), FeatureSpread.fixed(1)),
                            new StraightTrunkPlacer(8, 4, 3),
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key,
                                                                                 ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

    static {
        LOGGER.info("ModConfiguredFeatures initialized.");
    }

}
