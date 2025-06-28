package com.bladecoldsteel.invigorateddimensions.world.dimension;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<DimensionType> ELECTRIC_HIGHLANDS_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "electric_highlands"));
    public static final RegistryKey<World> ELECTRIC_HIGHLANDS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "electric_highlands"));

    public static final RegistryKey<DimensionType> WATERY_DEPTHS_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "watery_depths"));
    public static final RegistryKey<World> WATERY_DEPTHS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "watery_depths"));

    public static void register() {

        System.out.println("Registering Chunk Generator and Biome Provider...");

        Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(InvigoratedDimensions.MOD_ID, "chunk_generator"),
                CustomChunkGenerator.CODEC);
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "biome_provider"),
                CustomNetherBiomeProvider.NETHER_CODEC);

        System.out.println("Custom Chunk Generator and Biome Provider registered successfully!");
    }
}
