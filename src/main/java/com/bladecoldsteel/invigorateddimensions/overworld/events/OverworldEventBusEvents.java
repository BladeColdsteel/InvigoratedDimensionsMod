package com.bladecoldsteel.invigorateddimensions.overworld.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.OverworldEntityTypes;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.boss.custom.FossilizedTraderEntity;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.custom.ElementalShrineProtectorsEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OverworldEventBusEvents {
    @SubscribeEvent
    public static void  addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(OverworldEntityTypes.FOSSIL_TRADER.get(), FossilizedTraderEntity.setCustomAttributes().build());
        event.put(OverworldEntityTypes.SHRINE_PROTECTOR.get(), ElementalShrineProtectorsEntity.setCustomAttributes().build());
    }
}
