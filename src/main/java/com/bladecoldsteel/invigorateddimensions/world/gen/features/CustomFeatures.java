package com.bladecoldsteel.invigorateddimensions.world.gen.features;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.custom.FloatingIslandFeature;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.custom.FloatingIslandTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomFeatures {
    public static final DeferredRegister<Feature<?>> INVIGORATED_FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> STONE_TREE =
            INVIGORATED_FEATURES.register("stone_tree", () -> new FloatingIslandTreeFeature(BaseTreeFeatureConfig.CODEC));
    public static final RegistryObject<Feature<NoFeatureConfig>> FLOATING_STONE_ISLAND =
            INVIGORATED_FEATURES.register("floating_stone_island", () -> new FloatingIslandFeature(NoFeatureConfig.CODEC));

    public static void register(IEventBus eventBus) {
            INVIGORATED_FEATURES.register(eventBus);
    }
}
