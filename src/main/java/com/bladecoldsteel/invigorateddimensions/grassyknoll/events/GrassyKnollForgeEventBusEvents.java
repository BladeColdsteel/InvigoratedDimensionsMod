package com.bladecoldsteel.invigorateddimensions.grassyknoll.events;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.effects.GrassyKnollEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InvigoratedDimensions.MOD_ID)
public class GrassyKnollForgeEventBusEvents {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity target = event.getEntityLiving();
        if (!target.hasEffect(GrassyKnollEffects.BRITTLE.get())) {
            return;
        }

        EffectInstance brittle = target.getEffect(GrassyKnollEffects.BRITTLE.get());
        if (brittle == null) {
            return;
        }

        int amplifier = brittle.getAmplifier();
        float multiplier = 0.0F;
        Difficulty difficulty = target.level.getDifficulty();

        if (difficulty == Difficulty.EASY) {
            multiplier = 1.0F + (0.25F * amplifier);
        } else if (difficulty == Difficulty.NORMAL) {
            multiplier = 1.5F + (0.32F * amplifier);
        } else if (difficulty == Difficulty.HARD) {
            multiplier = 2.0F + (0.5F * amplifier);
        } else {
            multiplier = 1.0F;
        }

        event.setAmount(event.getAmount() * multiplier);
    }
}
