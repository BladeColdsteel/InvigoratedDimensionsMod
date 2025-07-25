package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RockFeatures {
    public static final DeferredRegister<Feature<?>> ROCKY_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {
        static final RuleTest OVERWORLD_FILLER = new TagMatchRuleTest(Tags.Blocks.STONE);

        public static final ConfiguredFeature<?, ?> ROCKY_LOG_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, CavernousCoveBlocks.LOG.get().defaultBlockState(), 33)
        );
        public static final ConfiguredFeature<?, ?> ROCKY_STONE_PATCH = Feature.ORE.configured(
                new OreFeatureConfig(OVERWORLD_FILLER, CavernousCoveBlocks.STONE.get().defaultBlockState(), 33)
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Rock Features...");
        //Ores
        register("rocky_log_patch", RockFeatures.ConfiguredFeatures.ROCKY_LOG_PATCH.range(256).squared().count(40));
        register("rocky_stone_patch", RockFeatures.ConfiguredFeatures.ROCKY_STONE_PATCH.range(256).squared().count(40));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
