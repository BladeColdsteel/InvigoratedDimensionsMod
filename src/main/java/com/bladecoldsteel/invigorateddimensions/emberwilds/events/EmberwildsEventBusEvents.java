package com.bladecoldsteel.invigorateddimensions.emberwilds.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.EmberwildsEntityTypes;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.boss.FireLordEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EmberwildsEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EmberwildsEntityTypes.FIRE_LORD.get(), FireLordEntity.setCustomAttributes().build());
    }
}
