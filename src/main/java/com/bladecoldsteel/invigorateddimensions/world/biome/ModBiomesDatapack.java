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
    public static RegistryKey<Biome> WATER_RIFT = registerBiome("watery_rift");
    public static RegistryKey<Biome> FIRE_RIFT = registerBiome("firey_rift");
    public static RegistryKey<Biome> GRASS_RIFT = registerBiome("grassy_rift");
    public static RegistryKey<Biome> ICE_RIFT = registerBiome("icey_rift");
    public static RegistryKey<Biome> FIGHTING_RIFT = registerBiome("fighting_rift");
    public static RegistryKey<Biome> POISON_RIFT = registerBiome("poison_rift");
    public static RegistryKey<Biome> GROUND_RIFT = registerBiome("grounded_rift");
    public static RegistryKey<Biome> FLYING_RIFT = registerBiome("flying_rift");
    public static RegistryKey<Biome> PSYCHIC_RIFT = registerBiome("psychic_rift");
    public static RegistryKey<Biome> BUG_RIFT = registerBiome("buggy_rift");
    public static RegistryKey<Biome> ROCK_RIFT = registerBiome("rocky_rift");
    public static RegistryKey<Biome> GHOST_RIFT = registerBiome("spooky_rift");
    public static RegistryKey<Biome> DRAGON_RIFT = registerBiome("dragon_rift");
    public static RegistryKey<Biome> DARK_RIFT = registerBiome("darkened_rift");
    public static RegistryKey<Biome> STEEL_RIFT = registerBiome("steely_rift");
    public static RegistryKey<Biome> FAIRY_RIFT = registerBiome("fairy_rift");
    public static RegistryKey<Biome> ELECTRIC_HIGHLANDS = registerBiome("electric_highlands");
    public static RegistryKey<Biome> ELECTRIC_HIGHLANDS_FOREST = registerBiome("electric_highlands_forest");

    private static RegistryKey<Biome> registerBiome(String name) {
        BIOMES.register(name, BiomeMaker::theVoidBiome);
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, name));
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ELECTRIC_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(WATER_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(FIRE_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GRASS_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(ICE_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(FIGHTING_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(POISON_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(GROUND_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(FLYING_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(PSYCHIC_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BUG_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ROCK_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(GHOST_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(DRAGON_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(DARK_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(STEEL_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(FAIRY_RIFT, 15));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ELECTRIC_HIGHLANDS, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ELECTRIC_HIGHLANDS_FOREST, 0));
    }
}
