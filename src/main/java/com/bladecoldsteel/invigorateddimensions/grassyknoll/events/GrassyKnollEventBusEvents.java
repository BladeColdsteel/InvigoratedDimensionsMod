package com.bladecoldsteel.invigorateddimensions.grassyknoll.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.GrassyKnollEntityTypes;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.custom.boss.AngryTreantEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrassyKnollEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(GrassyKnollEntityTypes.ANGRY_TREANT.get(), AngryTreantEntity.setCustomAttributes().build());
    }
}
