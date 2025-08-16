package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.structure.ShrineStructure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class UniversalStructures {

        public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, InvigoratedDimensions.MOD_ID);

        public static final RegistryObject<Structure<NoFeatureConfig>> ELEMENTAL_SHRINE = STRUCTURES.register("elemental_shrine_structure", () -> new ShrineStructure(NoFeatureConfig.CODEC));

        public static final class ConfiguredStructures {
                //Elemental Shrine Structure
                public static final StructureFeature<?, ?> ELEMENTAL_SHRINE = UniversalStructures.ELEMENTAL_SHRINE.get().configured(IFeatureConfig.NONE);
        }

        public static void registerStructures() {
                //Elemental Shrine Structure
                setupStructure(ELEMENTAL_SHRINE.get(), new StructureSeparationSettings(128, 16, 276320045), true);
        }

        public static void registerConfiguredStructures() {
                //Elemental Shrine Structure
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "elemental_shrine_structure"), ELEMENTAL_SHRINE.get().configured(IFeatureConfig.NONE));
                FlatGenerationSettings.STRUCTURE_FEATURES.put(ELEMENTAL_SHRINE.get(), ConfiguredStructures.ELEMENTAL_SHRINE);
        }

        public static void addDimensionalSpacing(final WorldEvent.Load event) {
                if (event.getWorld() instanceof ServerWorld) {
                        ServerWorld serverWorld = (ServerWorld)event.getWorld();

                        if (serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD)) {
                                return;
                        }

                        Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
                        tempMap.put(UniversalStructures.ELEMENTAL_SHRINE.get(), DimensionStructuresSettings.DEFAULTS.get(UniversalStructures.ELEMENTAL_SHRINE.get()));
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

        public static void onBiomeLoad(final BiomeLoadingEvent event) {
                if (event.getName() == null) return;

                switch (event.getCategory()) {
                        case NETHER:
                        case THEEND:
                        case OCEAN:
                        case BEACH:
                        case RIVER:
                                return;
                        default:
                                break;
                }

                final RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
                if (!BiomeDictionary.hasType(key, BiomeDictionary.Type.OVERWORLD)) {
                        return;
                }

                event.getGeneration().addStructureStart(
                        UniversalStructures.ConfiguredStructures.ELEMENTAL_SHRINE
                );
        }

}