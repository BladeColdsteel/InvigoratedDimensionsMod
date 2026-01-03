package com.bladecoldsteel.invigorateddimensions.commands;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommandEventHandler {

    @SubscribeEvent
    public static void handlerRegisterCommandsEvent(RegisterCommandsEvent event) {
        DimensionTeleportCommand.register(event.getDispatcher());
    }
}
