package com.bladecoldsteel.invigorateddimensions.terranata.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.entity.TerraNataEntityTypes;
import com.bladecoldsteel.invigorateddimensions.terranata.entity.custom.GiantEarthmawEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TerraNataEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(TerraNataEntityTypes.GIANT_EARTHMAW.get(), GiantEarthmawEntity.setCustomAttributes().build());
    }
}
