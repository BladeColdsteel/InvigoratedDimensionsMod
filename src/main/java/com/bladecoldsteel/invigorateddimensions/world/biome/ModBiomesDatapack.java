package com.bladecoldsteel.invigorateddimensions.world.biome;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeDictionary;
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
    public static RegistryKey<Biome> WATERY_DEPTHS = registerBiome("watery_depths");
    public static RegistryKey<Biome> WATERY_DEPTHS_FOREST = registerBiome("watery_depths_forest");
    public static RegistryKey<Biome> GRASSY_KNOLL = registerBiome("grassy_knoll");
    public static RegistryKey<Biome> GRASSY_KNOLL_FOREST = registerBiome("grassy_knoll_forest");

    private static RegistryKey<Biome> registerBiome(String name) {
        BIOMES.register(name, BiomeMaker::theVoidBiome);
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, name));
    }

    public static void toDictionary() {
        BiomeDictionary.addTypes(ELECTRIC_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(WATER_RIFT, BiomeDictionary.Type.WET, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.WATER, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(FIRE_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(GRASS_RIFT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(ICE_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(FIGHTING_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(POISON_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(GROUND_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(FLYING_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(PSYCHIC_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(BUG_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(ROCK_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(GHOST_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(DRAGON_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(DARK_RIFT, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(STEEL_RIFT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(FAIRY_RIFT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(ELECTRIC_HIGHLANDS, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(ELECTRIC_HIGHLANDS_FOREST, BiomeDictionary.Type.HOT, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(WATERY_DEPTHS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.WATER, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(WATERY_DEPTHS_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(GRASSY_KNOLL, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(GRASSY_KNOLL_FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
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
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(WATERY_DEPTHS, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(WATERY_DEPTHS_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GRASSY_KNOLL, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(GRASSY_KNOLL_FOREST, 0));
    }
}
