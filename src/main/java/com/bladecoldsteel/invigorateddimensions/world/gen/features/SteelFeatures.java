package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SteelFeatures {
    public static final DeferredRegister<Feature<?>> STEEL_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest OVERWORLD_FILLER = new TagMatchRuleTest(Tags.Blocks.STONE);

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> METALLIC_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(MetallicMountainsBlocks.LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new PineFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(3), FeatureSpread.fixed(4)),
                        new StraightTrunkPlacer(10, 6, 4),
                        new TwoLayerFeature(0, 0, 1))
                        .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> METALLIC_STONE_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, MetallicMountainsBlocks.STONE.get().defaultBlockState(), 33)
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Steel Features...");
        //Trees
        register("metallic_tree", SteelFeatures.ConfiguredFeatures.METALLIC_TREE
                .decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(2, 0.05f, 2)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Ores
        register("metallic_stone_patch", SteelFeatures.ConfiguredFeatures.METALLIC_STONE_PATCH.range(256).squared().count(20));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
