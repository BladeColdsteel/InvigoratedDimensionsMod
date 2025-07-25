package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FlyingFeatures {
    public static final DeferredRegister<Feature<?>> FLYING_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest OVERWORLD_FILLER = new TagMatchRuleTest(Tags.Blocks.STONE);

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLYING_TREE = CustomFeatures.STONE_TREE.get()
                .configured(new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(HeavenlyRealmBlocks.LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new BushFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(3), 3),
                        new StraightTrunkPlacer(1, 0, 1),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines().build());

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FLYING_TREE_CR = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(HeavenlyRealmBlocks.LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new BushFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(3), 3),
                        new StraightTrunkPlacer(1, 0, 1),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> FLOATING_STONE_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, HeavenlyRealmBlocks.STONE.get().defaultBlockState(), 44)
        );

        public static final ConfiguredFeature<NoFeatureConfig, ?> FLOATING_STONE_ISLAND = CustomFeatures.FLOATING_STONE_ISLAND.get()
                .configured(NoFeatureConfig.INSTANCE);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Flying Features...");
        //Trees
        register("flying_tree", FlyingFeatures.ConfiguredFeatures.FLYING_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(32)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        register("flying_tree_cr", FlyingFeatures.ConfiguredFeatures.FLYING_TREE_CR
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(32)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Ores
        register("floating_stone_boulder", FlyingFeatures.ConfiguredFeatures.FLOATING_STONE_PATCH.range(256).squared().count(8));
        //Floating Islands
        register("floating_islands", FlyingFeatures.ConfiguredFeatures.FLOATING_STONE_ISLAND
                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(125, 175, 225)))
                .decorated(Placement.SQUARE.configured(new NoPlacementConfig())));

    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
