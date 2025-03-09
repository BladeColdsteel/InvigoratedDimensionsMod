package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import net.minecraft.block.Blocks;
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

public class DarkFeatures {
    public static final DeferredRegister<Feature<?>> DARK_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DARKENED_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(ValleyDeathBlocks.DARKENED_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new DarkOakFoliagePlacer(FeatureSpread.fixed(1), FeatureSpread.fixed(1)),
                        new DarkOakTrunkPlacer(4, 4, 5),
                        new TwoLayerFeature(1, 1, 2))
                        .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> OBSIDIAN_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(Blocks.OBSIDIAN.defaultBlockState())
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Dark Features...");
        //Trees
        register("darkened_tree", DarkFeatures.ConfiguredFeatures.DARKENED_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(36)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Boulders
        register("obsidian_boulder", DarkFeatures.ConfiguredFeatures.OBSIDIAN_BOULDER.range(256).squared().count(16));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
