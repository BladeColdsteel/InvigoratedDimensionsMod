package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DragonFeatures {

    public static final DeferredRegister<Feature<?>> DRAGON_FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest OVERWORLD_FILLER = new TagMatchRuleTest(Tags.Blocks.STONE);

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DRACONIC_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(DraconicRiftBlocks.DRACONIC_LOG.get().defaultBlockState()),
                    new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                    new JungleFoliagePlacer(FeatureSpread.fixed(1), FeatureSpread.fixed(0), 2),
                    new MegaJungleTrunkPlacer(13, 5, 12),
                    new TwoLayerFeature(1, 1, 1))
                    .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> END_STONE_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, Blocks.END_STONE.defaultBlockState(), 44)
        );

        public static final ConfiguredFeature<?, ?> END_STONE_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(Blocks.END_STONE.defaultBlockState())
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Dragon Features...");
        //Trees
        register("draconic_tree", ConfiguredFeatures.DRACONIC_TREE
                .decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.05f, 3)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Ores
        register("end_stone_patch", ConfiguredFeatures.END_STONE_PATCH.range(256).squared().count(20));
        //Boulders
        register("end_stone_boulder", ConfiguredFeatures.END_STONE_BOULDER.range(256).squared().count(8));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
