package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID)
public class ModWorldEvents {
    private static final Logger LOGGER = LogManager.getLogger();
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        LOGGER.info("BiomeLoadingEvent fired for biome: {}", event.getName());

        ModTreeGeneration.generateTrees(event);

    }
}
