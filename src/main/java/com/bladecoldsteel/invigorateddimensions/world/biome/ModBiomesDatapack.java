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
    public static RegistryKey<Biome> INSECTIOD_PARADISIO = registerBiome("insectoid_paradisio");
    public static RegistryKey<Biome> INSECTIOD_PARADISIO_FOREST = registerBiome("insectoid_paradisio_forest");
    public static RegistryKey<Biome> VALLEY_OF_DEATH = registerBiome("valley_of_death");
    public static RegistryKey<Biome> VALLEY_OF_DEATH_FOREST = registerBiome("valley_of_death_forest");
    public static RegistryKey<Biome> FEYWILD_EXPANSE = registerBiome("feywild_expanse");
    public static RegistryKey<Biome> FEYWILD_EXPANSE_FOREST = registerBiome("feywild_expanse_forest");
    public static RegistryKey<Biome> INFINITE_DUNGEON = registerBiome("infinite_dungeon");
    public static RegistryKey<Biome> TERRA_NATA = registerBiome("terra_nata");
    public static RegistryKey<Biome> TERRA_NATA_FOREST = registerBiome("terra_nata_forest");
    public static RegistryKey<Biome> CELESTIAL_REALM = registerBiome("celestial_realm");
    public static RegistryKey<Biome> CELESTIAL_REALM_FOREST = registerBiome("celestial_realm_forest");
    public static RegistryKey<Biome> DEEP_TUNDRA = registerBiome("deep_tundra");
    public static RegistryKey<Biome> DEEP_TUNDRA_FOREST = registerBiome("deep_tundra_forest");
    public static RegistryKey<Biome> CORROSIVE_FIELDS = registerBiome("corrosive_fields");
    public static RegistryKey<Biome> CORROSIVE_FIELDS_FOREST = registerBiome("corrosive_fields_forest");
    public static RegistryKey<Biome> DREAMLAND = registerBiome("dreamland");
    public static RegistryKey<Biome> DREAMLAND_FOREST = registerBiome("dreamland_forest");
    public static RegistryKey<Biome> CAVERNOUS_COVE = registerBiome("cavernous_cove");
    public static RegistryKey<Biome> CAVERNOUS_COVE_FOREST = registerBiome("cavernous_cove_forest");
    public static RegistryKey<Biome> GHASTLY_MARSH = registerBiome("ghastly_marsh");
    public static RegistryKey<Biome> METALLIC_MOUNTAINS = registerBiome("metallic_mountains");
    public static RegistryKey<Biome> METALLIC_MOUNTAINS_FOREST = registerBiome("metallic_mountains_forest");

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
        BiomeDictionary.addTypes(INSECTIOD_PARADISIO, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(INSECTIOD_PARADISIO_FOREST, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(VALLEY_OF_DEATH, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(VALLEY_OF_DEATH_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(FEYWILD_EXPANSE, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(FEYWILD_EXPANSE_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(INFINITE_DUNGEON, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(TERRA_NATA, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(TERRA_NATA_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CELESTIAL_REALM, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CELESTIAL_REALM_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(DEEP_TUNDRA, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(DEEP_TUNDRA_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CORROSIVE_FIELDS, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CORROSIVE_FIELDS_FOREST, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(DREAMLAND, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(DREAMLAND_FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CAVERNOUS_COVE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(CAVERNOUS_COVE_FOREST, BiomeDictionary.Type.HOT, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(GHASTLY_MARSH, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(METALLIC_MOUNTAINS, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.MAGICAL);
        BiomeDictionary.addTypes(METALLIC_MOUNTAINS_FOREST, BiomeDictionary.Type.HOT, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.MAGICAL);
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
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(INSECTIOD_PARADISIO, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(INSECTIOD_PARADISIO_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(VALLEY_OF_DEATH, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(VALLEY_OF_DEATH_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(FEYWILD_EXPANSE, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(FEYWILD_EXPANSE_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(INFINITE_DUNGEON, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(TERRA_NATA, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(TERRA_NATA_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(CELESTIAL_REALM, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(CELESTIAL_REALM_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(DEEP_TUNDRA, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(DEEP_TUNDRA_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CORROSIVE_FIELDS, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CORROSIVE_FIELDS_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(DREAMLAND, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(DREAMLAND_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CAVERNOUS_COVE, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CAVERNOUS_COVE_FOREST, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(GHASTLY_MARSH, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(METALLIC_MOUNTAINS, 0));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(METALLIC_MOUNTAINS_FOREST, 0));
    }
}
