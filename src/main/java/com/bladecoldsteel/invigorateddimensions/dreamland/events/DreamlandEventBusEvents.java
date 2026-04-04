package com.bladecoldsteel.invigorateddimensions.dreamland.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.dreamland.entity.DreamlandEntityTypes;
import com.bladecoldsteel.invigorateddimensions.dreamland.entity.custom.boss.PitulantPendulumEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DreamlandEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(DreamlandEntityTypes.PITULANT_PENDULUM.get(), PitulantPendulumEntity.setCustomAttributes().build());
    }
}
