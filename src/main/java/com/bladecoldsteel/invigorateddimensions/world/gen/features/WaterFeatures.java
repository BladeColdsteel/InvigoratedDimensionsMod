package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WaterFeatures {

    public static final DeferredRegister<Feature<?>> WATER_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WATERY_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(WateryDepthsBlocks.WATERY_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new AcaciaFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(1)),
                        new ForkyTrunkPlacer(4, 1, 3),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines().build());
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Water Features...");
        //Trees
        register("water_tree", ConfiguredFeatures.WATERY_TREE
                .decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.05f, 1)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
