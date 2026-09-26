package com.bladecoldsteel.invigorateddimensions.ultra.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.UltraDimEntityTypes;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.custom.BeastlyBoarEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UltraDimEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(UltraDimEntityTypes.BEASTLY_BOAR.get(), BeastlyBoarEntity.setCustomAttributes().build());
    }
}
