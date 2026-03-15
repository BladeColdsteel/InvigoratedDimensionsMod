package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.config.PixelmonConfigModifier;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientStartupHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
           File configDir = FMLPaths.CONFIGDIR.get().toFile();
           System.out.println("[InvigoratedDimensions] Client setup started. Checking config...");
           PixelmonConfigModifier.updatePixelmonConfig(configDir);
        });
    }

    @SubscribeEvent
    public static void onBlockColors(ColorHandlerEvent.Block event) {
        BlockColors colors = event.getBlockColors();

        colors.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) return 0xA8A8A8;
            return BiomeColors.getAverageGrassColor(world, pos);
        },
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS.get(),
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS_STAIRS.get(),
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS_SLABS.get());
    }

    @SubscribeEvent
    public static void onItemColors(ColorHandlerEvent.Item event) {
        ItemColors colors = event.getItemColors();

        colors.register((stack, tintIndex) -> 0xA8A8A8,
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS.get(),
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS_STAIRS.get(),
                UniversalBlocks.ELEMENTAL_SHRINE_WALLS_SLABS.get());
    }
}
