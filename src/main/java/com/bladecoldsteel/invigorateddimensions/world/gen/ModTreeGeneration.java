package com.bladecoldsteel.invigorateddimensions.world.gen;

import com.bladecoldsteel.invigorateddimensions.world.biome.ModBiomesDatapack;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Supplier;

public class ModTreeGeneration {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void generateTrees(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());

        LOGGER.info("Checking biome: {}", key.location());

        if(event.getName().equals(ModBiomesDatapack.ELECTRIC_RIFT.getRegistryName())) {
            LOGGER.info("Generating trees for the Electric Rift");
                List<Supplier<ConfiguredFeature<?, ?>>> base =
                        event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

                base.add(() -> ModConfiguredFeatures.ELECTRICALLY_CHARGED
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .decorated(Placement.COUNT_EXTRA.configured(
                                new AtSurfaceWithExtraConfig(1, .15f, 2))));
        } else {
            LOGGER.info("Biome {} does not match the Electric Rift", key.location());
        }

        if(event.getName().equals(ModBiomesDatapack.THUNDERING_PLAINS.getRegistryName())) {
            LOGGER.info("Generating trees for the Thundering Plains");
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModConfiguredFeatures.ELECTRICALLY_CHARGED
                    .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                    .decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(0, .015f, 1))));
        } else {
            LOGGER.info("Biome {} does not match the Thundering Plains", key.location());
        }
    }
}
