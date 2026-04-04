package com.bladecoldsteel.invigorateddimensions.dreamland.effects;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.dreamland.effects.custom.MentalPrisonEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DreamlandEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Effect> MENTAL_PRISON = EFFECTS.register("mental_prison", MentalPrisonEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
