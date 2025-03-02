package com.bladecoldsteel.invigorateddimensions.world.gen.features;


import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.util.InvigoratedTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricFeatures {

    public static final DeferredRegister<Feature<?>> ELECTRIC_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest HIGHLANDS_FILLER = new TagMatchRuleTest(InvigoratedTags.Blocks.BASE_STONE_ELECTRIC_HIGHLANDS);

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ELECTRIC_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(UniversalBlocks.CRYSTALLIZED_LEAVES.get().defaultBlockState()),
                        new SpruceFoliagePlacer(FeatureSpread.fixed(4), FeatureSpread.fixed(2), FeatureSpread.fixed(1)),
                        new StraightTrunkPlacer(6, 4, 3),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines().build());

        public static final ConfiguredFeature<?, ?> CHARGED_COAL_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_COAL_ORE.get().defaultBlockState(), 17)
        );
        public static final ConfiguredFeature<?, ?> CHARGED_IRON_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_IRON_ORE.get().defaultBlockState(), 9)
        );
        public static final ConfiguredFeature<?, ?> CHARGED_GOLD_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_GOLD_ORE.get().defaultBlockState(), 9)
        );
        public static final ConfiguredFeature<?, ?> CHARGED_DIAMOND_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE.get().defaultBlockState(), 8)
        );
        public static final ConfiguredFeature<?, ?> CHARGED_GLOWSTONE_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE.get().defaultBlockState(), 10)
        );
        public static final ConfiguredFeature<?, ?> CHARGED_VOLTCRYST_ORE = Feature.ORE.configured(
                new OreFeatureConfig(HIGHLANDS_FILLER, ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE.get().defaultBlockState(), 4)
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Electric Features...");
        //Trees
        register("electric_tree", ConfiguredFeatures.ELECTRIC_TREE
                .decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.05f, 2)))
                .decorated(Features.Placements.HEIGHTMAP_SQUARE));
        //Ores
        register("charged_coal_ore", ConfiguredFeatures.CHARGED_COAL_ORE.range(256).squared().count(120));
        register("charged_iron_ore", ConfiguredFeatures.CHARGED_IRON_ORE.range(256).squared().count(40));
        register("charged_gold_ore", ConfiguredFeatures.CHARGED_GOLD_ORE.range(256).squared().count(30));
        register("charged_diamond_ore", ConfiguredFeatures.CHARGED_DIAMOND_ORE.range(256).squared().count(10));
        register("charged_glowstone_ore", ConfiguredFeatures.CHARGED_GLOWSTONE_ORE.range(256).squared().count(60));
        register("charged_voltcryst_ore", ConfiguredFeatures.CHARGED_VOLTCRYST_ORE.range(256).squared().count(5));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }

}
