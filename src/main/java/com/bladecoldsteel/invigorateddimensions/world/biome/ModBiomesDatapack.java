package com.bladecoldsteel.invigorateddimensions.world.biome;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomesDatapack {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, InvigoratedDimensions.MOD_ID);

    public static RegistryKey<Biome> ELECTRIC_RIFT = registerBiome("electric_rift");
    public static RegistryKey<Biome> ELECTRIC_HIGHLANDS = registerBiome("electric_highlands");

    private static RegistryKey<Biome> registerBiome(String name) {
        BIOMES.register(name, BiomeMaker::theVoidBiome);
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, name));
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ELECTRIC_RIFT, 20));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ELECTRIC_HIGHLANDS, 0));
    }
}
