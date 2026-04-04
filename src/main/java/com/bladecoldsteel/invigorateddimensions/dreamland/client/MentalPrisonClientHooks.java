package com.bladecoldsteel.invigorateddimensions.dreamland.client;

import com.bladecoldsteel.invigorateddimensions.dreamland.screens.custom.screens.MentalPrisonScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MentalPrisonClientHooks {
    public static void openScreenIfNeeded(LivingEntity entity) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if (player != null && entity == player) {
            if (!player.isCreative()) {
                if (!(mc.screen instanceof MentalPrisonScreen)) {
                    mc.setScreen(new MentalPrisonScreen());
                }
            }
        }
    }

    public static void closeScreenIfOpen(LivingEntity entity) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;
        if (player != null && entity == player) {
            if (mc.screen instanceof MentalPrisonScreen) {
                mc.setScreen(null);
            }
        }
    }
}
