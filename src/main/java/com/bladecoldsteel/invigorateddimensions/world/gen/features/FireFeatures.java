package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FireFeatures {

    public static final DeferredRegister<Feature<?>> FIRE_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FIRE_TREE_STRAIGHT = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                   new SimpleBlockStateProvider(EmberwildsBlocks.EMBERED_LOG.get().defaultBlockState()),
                   new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                   new BlobFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(1), 2),
                   new StraightTrunkPlacer(5, 3, 1),
                   new TwoLayerFeature(1, 1, 2))
                   .ignoreVines().build());
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FIRE_TREE_FUNKY = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                   new SimpleBlockStateProvider(EmberwildsBlocks.EMBERED_LOG.get().defaultBlockState()),
                   new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                   new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(1), 1),
                   new ForkyTrunkPlacer(4, 2, 3),
                   new TwoLayerFeature(1, 1, 1))
                   .ignoreVines().build());
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Fire Features...");
        //Trees
        register("embered_tree_straight", ConfiguredFeatures.FIRE_TREE_STRAIGHT
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(16)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        register("embered_tree_funky", ConfiguredFeatures.FIRE_TREE_FUNKY
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(16)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
