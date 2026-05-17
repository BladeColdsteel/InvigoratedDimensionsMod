package com.bladecoldsteel.invigorateddimensions.deeptundra.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.DeepTundraEntityTypes;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom.RimeboundEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeepTundraEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(DeepTundraEntityTypes.RIMEBOUND.get(), RimeboundEntity.setCustomAttributes().build());
    }
}
