package com.bladecoldsteel.invigorateddimensions.network;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.ElectricHighlandsEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ParalysisEventHandler {
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player.hasEffect(ElectricHighlandsEffects.PARALYZED.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        PlayerEntity player = event.getPlayer();
        if (player.hasEffect(ElectricHighlandsEffects.PARALYZED.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        PlayerEntity player = event.getPlayer();
        if (player.hasEffect(ElectricHighlandsEffects.PARALYZED.get())) {
            event.setCanceled(true);
        }
    }
}
