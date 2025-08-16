package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.structure.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DimensionPortalStructures {
        private static final Map<ResourceLocation, List<StructureFeature<?, ?>>> STRUCTURE_BY_BIOME = new HashMap<>();

        public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, InvigoratedDimensions.MOD_ID);

        //Rock
        public static final RegistryObject<Structure<NoFeatureConfig>> ROCK_PORTAL = STRUCTURES.register("rock_portal", () -> new RockPortalStructure(NoFeatureConfig.CODEC));
        //Flying
        public static final RegistryObject<Structure<NoFeatureConfig>> FLYING_PORTAL = STRUCTURES.register("flying_portal", () -> new FlyingPortalStructure(NoFeatureConfig.CODEC));
        //Poison
        public static final RegistryObject<Structure<NoFeatureConfig>> POISON_PORTAL = STRUCTURES.register("poison_portal", () -> new PoisonPortalStructure(NoFeatureConfig.CODEC));
        //Ice
        public static final RegistryObject<Structure<NoFeatureConfig>> ICE_PORTAL = STRUCTURES.register("ice_portal", () -> new IcePortalStructure(NoFeatureConfig.CODEC));
        //Psychic
        public static final RegistryObject<Structure<NoFeatureConfig>> PSYCHIC_PORTAL = STRUCTURES.register("psychic_portal", () -> new PsychicPortalStructure(NoFeatureConfig.CODEC));
        //Electric
        public static final RegistryObject<Structure<NoFeatureConfig>> ELECTRIC_PORTAL = STRUCTURES.register("electric_portal", () -> new ElectricPortalStructure(NoFeatureConfig.CODEC));
        //Fairy
        public static final RegistryObject<Structure<NoFeatureConfig>> FAIRY_PORTAL = STRUCTURES.register("fairy_portal", () -> new FairyPortalStructure(NoFeatureConfig.CODEC));
        //Ghost
        public static final RegistryObject<Structure<NoFeatureConfig>> GHOST_PORTAL = STRUCTURES.register("ghost_portal", () -> new GhostPortalStructure(NoFeatureConfig.CODEC));
        //Grass
        public static final RegistryObject<Structure<NoFeatureConfig>> GRASS_PORTAL = STRUCTURES.register("grass_portal", () -> new GrassPortalStructure(NoFeatureConfig.CODEC));
        //Fighting
        public static final RegistryObject<Structure<NoFeatureConfig>> FIGHTING_PORTAL = STRUCTURES.register("fighting_portal", () -> new FightingPortalStructure(NoFeatureConfig.CODEC));
        //Bug
        public static final RegistryObject<Structure<NoFeatureConfig>> BUG_PORTAL = STRUCTURES.register("bug_portal", () -> new BugPortalStructure(NoFeatureConfig.CODEC));
        //Steel
        public static final RegistryObject<Structure<NoFeatureConfig>> STEEL_PORTAL = STRUCTURES.register("steel_portal", () -> new SteelPortalStructure(NoFeatureConfig.CODEC));
        //Ground
        public static final RegistryObject<Structure<NoFeatureConfig>> GROUND_PORTAL = STRUCTURES.register("ground_portal", () -> new GroundPortalStructure(NoFeatureConfig.CODEC));
        //Dark
        public static final RegistryObject<Structure<NoFeatureConfig>> DARK_PORTAL = STRUCTURES.register("dark_portal", () -> new DarkPortalStructure(NoFeatureConfig.CODEC));
        //Water
        public static final RegistryObject<Structure<NoFeatureConfig>> WATER_PORTAL = STRUCTURES.register("water_portal", () -> new WaterPortalStructure(NoFeatureConfig.CODEC));

        public static final class ConfiguredStructures {
                //Rock
                public static final StructureFeature<?, ?> ROCK_PORTAL = DimensionPortalStructures.ROCK_PORTAL.get().configured(IFeatureConfig.NONE);
                //Flying
                public static final StructureFeature<?, ?> FLYING_PORTAL = DimensionPortalStructures.FLYING_PORTAL.get().configured(IFeatureConfig.NONE);
                //Poison
                public static final StructureFeature<?, ?> POISON_PORTAL = DimensionPortalStructures.POISON_PORTAL.get().configured(IFeatureConfig.NONE);
                //Ice
                public static final StructureFeature<?, ?> ICE_PORTAL = DimensionPortalStructures.ICE_PORTAL.get().configured(IFeatureConfig.NONE);
                //Psychic
                public static final StructureFeature<?, ?> PSYCHIC_PORTAL = DimensionPortalStructures.PSYCHIC_PORTAL.get().configured(IFeatureConfig.NONE);
                //Electric
                public static final StructureFeature<?, ?> ELECTRIC_PORTAL = DimensionPortalStructures.ELECTRIC_PORTAL.get().configured(IFeatureConfig.NONE);
                //Fairy
                public static final StructureFeature<?, ?> FAIRY_PORTAL = DimensionPortalStructures.FAIRY_PORTAL.get().configured(IFeatureConfig.NONE);
                //Ghost
                public static final StructureFeature<?, ?> GHOST_PORTAL = DimensionPortalStructures.GHOST_PORTAL.get().configured(IFeatureConfig.NONE);
                //Grass
                public static final StructureFeature<?, ?> GRASS_PORTAL = DimensionPortalStructures.GRASS_PORTAL.get().configured(IFeatureConfig.NONE);
                //Fighting
                public static final StructureFeature<?, ?> FIGHTING_PORTAL = DimensionPortalStructures.FIGHTING_PORTAL.get().configured(IFeatureConfig.NONE);
                //Bug
                public static final StructureFeature<?, ?> BUG_PORTAL = DimensionPortalStructures.BUG_PORTAL.get().configured(IFeatureConfig.NONE);
                //Steel
                public static final StructureFeature<?, ?> STEEL_PORTAL = DimensionPortalStructures.STEEL_PORTAL.get().configured(IFeatureConfig.NONE);
                //Ground
                public static final StructureFeature<?, ?> GROUND_PORTAL = DimensionPortalStructures.GROUND_PORTAL.get().configured(IFeatureConfig.NONE);
                //Dark
                public static final StructureFeature<?, ?> DARK_PORTAL = DimensionPortalStructures.DARK_PORTAL.get().configured(IFeatureConfig.NONE);
                //Water
                public static final StructureFeature<?, ?> WATER_PORTAL = DimensionPortalStructures.WATER_PORTAL.get().configured(IFeatureConfig.NONE);
        }

        public static void registerStructures() {
                //Rock
                setupStructure(ROCK_PORTAL.get(), new StructureSeparationSettings(48, 16, 189473251), true);
                //Flying
                setupStructure(FLYING_PORTAL.get(), new StructureSeparationSettings(48, 16, 412589367), true);
                //Poison
                setupStructure(POISON_PORTAL.get(), new StructureSeparationSettings(48, 16, 937154820), true);
                //Ice
                setupStructure(ICE_PORTAL.get(), new StructureSeparationSettings(48, 16, 521748396), true);
                //Psychic
                setupStructure(PSYCHIC_PORTAL.get(), new StructureSeparationSettings(48, 16, 305982147), true);
                //Electric
                setupStructure(ELECTRIC_PORTAL.get(), new StructureSeparationSettings(48, 16, 748395120), true);
                //Fairy
                setupStructure(FAIRY_PORTAL.get(), new StructureSeparationSettings(48, 16, 159472683), true);
                //Ghost
                setupStructure(GHOST_PORTAL.get(), new StructureSeparationSettings(48, 16, 862317459), true);
                //Grass
                setupStructure(GRASS_PORTAL.get(), new StructureSeparationSettings(48, 16, 274839615), true);
                //Fighting
                setupStructure(FIGHTING_PORTAL.get(), new StructureSeparationSettings(48, 16, 693158247), true);
                //Bug
                setupStructure(BUG_PORTAL.get(), new StructureSeparationSettings(48, 16, 518237946), true);
                //Steel
                setupStructure(STEEL_PORTAL.get(), new StructureSeparationSettings(48, 16, 437192586), true);
                //Ground
                setupStructure(GROUND_PORTAL.get(), new StructureSeparationSettings(48, 16, 983217456), true);
                //Dark
                setupStructure(DARK_PORTAL.get(), new StructureSeparationSettings(48, 16, 246871359), true);
                //Water
                setupStructure(WATER_PORTAL.get(), new StructureSeparationSettings(48, 16, 714593862), true);
        }

        public static void registerConfiguredStructures() {
                //Rock
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "rock_portal"), ROCK_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(ROCK_PORTAL.get(), ConfiguredStructures.ROCK_PORTAL);
                //Flying
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "flying_portal"), FLYING_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(FLYING_PORTAL.get(), ConfiguredStructures.FLYING_PORTAL);
                //Poison
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "poison_portal"), POISON_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(POISON_PORTAL.get(), ConfiguredStructures.POISON_PORTAL);
                //Ice
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "ice_portal"), ICE_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(ICE_PORTAL.get(), ConfiguredStructures.ICE_PORTAL);
                //Psychic
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "psychic_portal"), PSYCHIC_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(PSYCHIC_PORTAL.get(), ConfiguredStructures.PSYCHIC_PORTAL);
                //Electric
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "electric_portal"), ELECTRIC_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(ELECTRIC_PORTAL.get(), ConfiguredStructures.ELECTRIC_PORTAL);
                //Fairy
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "fairy_portal"), FAIRY_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(FAIRY_PORTAL.get(), ConfiguredStructures.FAIRY_PORTAL);
                //Ghost
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "ghost_portal"), GHOST_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(GHOST_PORTAL.get(), ConfiguredStructures.GHOST_PORTAL);
                //Grass
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "grass_portal"), GRASS_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(GRASS_PORTAL.get(), ConfiguredStructures.GRASS_PORTAL);
                //Fighting
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "fighting_portal"), FIGHTING_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(FIGHTING_PORTAL.get(), ConfiguredStructures.FIGHTING_PORTAL);
                //Bug
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "bug_portal"), BUG_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(BUG_PORTAL.get(), ConfiguredStructures.BUG_PORTAL);
                //Steel
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "steel_portal"), STEEL_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(STEEL_PORTAL.get(), ConfiguredStructures.STEEL_PORTAL);
                //Ground
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "ground_portal"), GROUND_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(GROUND_PORTAL.get(), ConfiguredStructures.GROUND_PORTAL);
                //Dark
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "dark_portal"), DARK_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(DARK_PORTAL.get(), ConfiguredStructures.DARK_PORTAL);
                //Water
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "water_portal"), WATER_PORTAL.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(WATER_PORTAL.get(), ConfiguredStructures.WATER_PORTAL);
        }

        public static void addDimensionalSpacing(final WorldEvent.Load event) {
                if (event.getWorld() instanceof ServerWorld) {
                        ServerWorld serverWorld = (ServerWorld)event.getWorld();

                        if (serverWorld.dimension().equals(World.NETHER) || serverWorld.dimension().equals(World.END)) {
                                return;
                        }

                        if (serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator
                                && serverWorld.dimension().equals(World.OVERWORLD)) {
                                return;
                        }

                        Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
                        tempMap.put(DimensionPortalStructures.ROCK_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.ROCK_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.FLYING_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.FLYING_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.POISON_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.POISON_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.ICE_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.ICE_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.PSYCHIC_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.PSYCHIC_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.ELECTRIC_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.ELECTRIC_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.FAIRY_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.FAIRY_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.GHOST_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.GHOST_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.GRASS_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.GRASS_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.FIGHTING_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.FIGHTING_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.BUG_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.BUG_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.STEEL_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.STEEL_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.GROUND_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.GROUND_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.DARK_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.DARK_PORTAL.get()));
                        tempMap.put(DimensionPortalStructures.WATER_PORTAL.get(), DimensionStructuresSettings.DEFAULTS.get(DimensionPortalStructures.WATER_PORTAL.get()));
                        serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
                }
        }

        private static <F extends Structure<?>> void setupStructure(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
                Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

                if (transformSurroundingLand) {
                        Structure.NOISE_AFFECTING_FEATURES =
                                ImmutableList.<Structure<?>>builder()
                                        .addAll(Structure.NOISE_AFFECTING_FEATURES)
                                        .add(structure)
                                        .build();
                }

                DimensionStructuresSettings.DEFAULTS =
                        ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                                .putAll(DimensionStructuresSettings.DEFAULTS)
                                .put(structure, structureSeparationSettings)
                                .build();
        }
}
