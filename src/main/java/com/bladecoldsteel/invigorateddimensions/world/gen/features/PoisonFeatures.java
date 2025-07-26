package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PoisonFeatures {
    public static final DeferredRegister<Feature<?>> POISON_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest OVERWORLD_FILLER = new TagMatchRuleTest(Tags.Blocks.STONE);

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CORROSIVE_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(CorrosiveFieldsBlocks.LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new BushFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 2),
                        new StraightTrunkPlacer(4, 2, 1),
                        new TwoLayerFeature(1, 0, 1))
                        .decorators(ImmutableList.of(LeaveVineTreeDecorator.INSTANCE)).build());

        public static final ConfiguredFeature<?, ?> CORROSIVE_STONE_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, CorrosiveFieldsBlocks.STONE.get().defaultBlockState(), 33)
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Poison Features...");
        //Trees
        register("poison_tree", PoisonFeatures.ConfiguredFeatures.CORROSIVE_TREE
                .decorated(Placement.COUNT_MULTILAYER.configured(new FeatureSpreadConfig(16)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Ores
        register("poison_stone_patch", PoisonFeatures.ConfiguredFeatures.CORROSIVE_STONE_PATCH.range(256).squared().count(30));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
