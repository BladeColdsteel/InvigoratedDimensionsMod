package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.network.InvigoratedDimensionsNetworkHandler;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.SyncRitualDataPacket;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualData;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDataLoader;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.Map;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventListenerRegistrar {
    @SubscribeEvent
    public static void onAddReloadListener(AddReloadListenerEvent event) {
        event.addListener(DimensionInfoDataLoader.INSTANCE);
        event.addListener(RitualDataLoader.INSTANCE);
        System.out.println("[EventListenerRegistrar] Registered DimensionInfoDataLoader and RitualDataLoader via AddReloadListenerEvent");
    }

    @SubscribeEvent
    public static void onDataSync(OnDatapackSyncEvent event) {
        Map<ResourceLocation, RitualDefinition> rituals = RitualData.getRitualsMap();
        SyncRitualDataPacket data = new SyncRitualDataPacket(rituals);
        ServerPlayerEntity serverPlayer = event.getPlayer();
        if (serverPlayer != null) {
            InvigoratedDimensionsNetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), data);
        } else {
            InvigoratedDimensionsNetworkHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), data);
        }
    }
}
