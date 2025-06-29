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
    public static final RegistryKey<DimensionType> GRASSY_KNOLL_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "grassy_knoll"));
    public static final RegistryKey<World> GRASSY_KNOLL = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "grassy_knoll"));
    public static final RegistryKey<DimensionType> INSECTIOD_PARADISIO_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "insectoid_paradisio"));
    public static final RegistryKey<World> INSECTIOD_PARADISIO = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "insectoid_paradisio"));
    public static final RegistryKey<DimensionType> VALLEY_OF_DEATH_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "valley_of_death"));
    public static final RegistryKey<World> VALLEY_OF_DEATH = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "valley_of_death"));
    public static final RegistryKey<DimensionType> FEYWILD_EXPANSE_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "feywild_expanse"));
    public static final RegistryKey<World> FEYWILD_EXPANSE = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "feywild_expanse"));
    public static final RegistryKey<DimensionType> INFINITE_DUNGEON_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "infinite_dungeon"));
    public static final RegistryKey<World> INFINITE_DUNGEON = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "infinite_dungeon"));
    public static final RegistryKey<DimensionType> TERRA_NATA_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "terra_nata"));
    public static final RegistryKey<World> TERRA_NATA = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "terra_nata"));
    public static final RegistryKey<DimensionType> CELESTIAL_REALM_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "celestial_realm"));
    public static final RegistryKey<World> CELESTIAL_REALM = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "celestial_realm"));
    public static final RegistryKey<DimensionType> DEEP_TUNDRA_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "deep_tundra"));
    public static final RegistryKey<World> DEEP_TUNDRA = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "deep_tundra"));
    public static final RegistryKey<DimensionType> CORROSIVE_FIELDS_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "corrosive_fields"));
    public static final RegistryKey<World> CORROSIVE_FIELDS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "corrosive_fields"));
    public static final RegistryKey<DimensionType> DREAMLAND_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "dreamland"));
    public static final RegistryKey<World> DREAMLAND = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(InvigoratedDimensions.MOD_ID, "dreamland"));

    public static void register() {

        System.out.println("Registering Chunk Generator and Biome Provider...");

        Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(InvigoratedDimensions.MOD_ID, "chunk_generator"),
                CustomChunkGenerator.CODEC);
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "biome_provider"),
                CustomNetherBiomeProvider.NETHER_CODEC);

        System.out.println("Custom Chunk Generator and Biome Provider registered successfully!");
    }
}
