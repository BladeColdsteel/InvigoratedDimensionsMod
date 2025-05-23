package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.config.PixelmonConfigModifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, value = Dist.CLIENT)
public class ClientStartupHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
           File configDir = FMLPaths.CONFIGDIR.get().toFile();
           System.out.println("[InvigoratedDimensions] Client setup started. Checking config...");
           PixelmonConfigModifier.updatePixelmonConfig(configDir);
        });
    }
}
