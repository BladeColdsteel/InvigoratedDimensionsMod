package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.DarkOakFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BugFeatures {
    public static final DeferredRegister<Feature<?>> BUG_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BUGGED_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(InsectoidParadisioBlocks.BUGGED_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new DarkOakFoliagePlacer(FeatureSpread.fixed(1), FeatureSpread.fixed(1)),
                        new DarkOakTrunkPlacer(8, 4, 5),
                        new TwoLayerFeature(1, 1, 2))
                        .ignoreVines().build());
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Bug Features...");
        //Trees
        register("bugged_tree", BugFeatures.ConfiguredFeatures.BUGGED_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(8)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
