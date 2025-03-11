package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FightingFeatures {
    public static final DeferredRegister<Feature<?>> FIGHTING_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final class ConfiguredFeatures {


        public static final ConfiguredFeature<?, ?> TOUGH_LOGS_BOULDER = Feature.FOREST_ROCK.configured(
                new BlockStateFeatureConfig(InfiniteDungeonBlocks.TOUGH_LOG.get().defaultBlockState())
        );
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering Fighting Features...");
        //Boulders
        register("tough_log_boulder", FightingFeatures.ConfiguredFeatures.TOUGH_LOGS_BOULDER.range(256).squared().count(8));
    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, name), feature);
    }
}
