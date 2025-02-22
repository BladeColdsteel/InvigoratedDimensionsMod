package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.structure.ElectricHighlandsRiftStructure;
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
import java.util.Map;

public class ElectricHighlandsStructures {

        public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, InvigoratedDimensions.MOD_ID);

        public static final RegistryObject<Structure<NoFeatureConfig>> ELECTRIC_RIFT = STRUCTURES.register("electric_rift_structure", () -> new ElectricHighlandsRiftStructure(NoFeatureConfig.CODEC));

        public static final class ConfiguredStructures {
                public static final StructureFeature<?, ?> ELECTRIC_RIFT = ElectricHighlandsStructures.ELECTRIC_RIFT.get().configured(IFeatureConfig.NONE);
        }

        public static void registerStructures() {
                setupStructure(ELECTRIC_RIFT.get(), new StructureSeparationSettings(24, 8, 276320045), true);
        }

        public static void registerConfiguredStructures() {
                Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(InvigoratedDimensions.MOD_ID, "electric_rift_structure"), ELECTRIC_RIFT.get().configured(IFeatureConfig.NONE));

                FlatGenerationSettings.STRUCTURE_FEATURES.put(ELECTRIC_RIFT.get(), ConfiguredStructures.ELECTRIC_RIFT);
        }

        public static void addDimensionalSpacing(final WorldEvent.Load event) {
                if (event.getWorld() instanceof ServerWorld) {
                        ServerWorld serverWorld = (ServerWorld)event.getWorld();

                        if (serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD)) {
                                return;
                        }

                        Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
                        tempMap.put(ElectricHighlandsStructures.ELECTRIC_RIFT.get(), DimensionStructuresSettings.DEFAULTS.get(ElectricHighlandsStructures.ELECTRIC_RIFT.get()));
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
