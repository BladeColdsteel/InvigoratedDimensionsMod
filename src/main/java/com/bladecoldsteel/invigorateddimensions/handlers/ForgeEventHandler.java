package com.bladecoldsteel.invigorateddimensions.handlers;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.commands.DimensionTeleportCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {

    @SubscribeEvent
    public static void handlerRegisterCommandsEvent(RegisterCommandsEvent event) {
        DimensionTeleportCommand.register(event.getDispatcher());
    }
}
