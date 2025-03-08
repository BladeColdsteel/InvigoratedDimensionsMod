package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GrassFeatures {
    public static final DeferredRegister<Feature<?>> GRASS_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GRASSY_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(GrassyKnollBlocks.GRASSY_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new BushFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(3), 3),
                        new StraightTrunkPlacer(1, 0, 1),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines().build());
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Grass Features...");
        //Trees
        register("grassy_tree", ConfiguredFeatures.GRASSY_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(32)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
