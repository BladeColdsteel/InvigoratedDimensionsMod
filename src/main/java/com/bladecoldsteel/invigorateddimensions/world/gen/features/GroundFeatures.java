package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GroundFeatures {
    public static final DeferredRegister<Feature<?>> GROUND_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> GROUNDED_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(TerraNataBlocks.GROUNDED_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new AcaciaFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(0)),
                        new StraightTrunkPlacer(5, 4, 3),
                        new TwoLayerFeature(2, 1, 2))
                        .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> STONE_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(Blocks.STONE.defaultBlockState())
        );
        public static final ConfiguredFeature<?, ?> SAND_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(Blocks.SAND.defaultBlockState())
        );
        public static final ConfiguredFeature<?, ?> GRAVEL_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(Blocks.GRAVEL.defaultBlockState())
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Ground Features...");
        //Trees
        register("grounded_tree", GroundFeatures.ConfiguredFeatures.GROUNDED_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(12)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Boulders
        register("stone_boulder", GroundFeatures.ConfiguredFeatures.STONE_BOULDER.range(256).squared().count(6));
        register("sand_boulder", GroundFeatures.ConfiguredFeatures.SAND_BOULDER.range(256).squared().count(6));
        register("gravel_boulder", GroundFeatures.ConfiguredFeatures.GRAVEL_BOULDER.range(256).squared().count(6));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
