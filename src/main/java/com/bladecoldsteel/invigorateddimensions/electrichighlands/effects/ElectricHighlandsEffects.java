package com.bladecoldsteel.invigorateddimensions.electrichighlands.effects;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.custom.ChargedEffect;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.effects.custom.ParalyzedEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Effect> CHARGED = EFFECTS.register("charged", ChargedEffect::new);
    public static final RegistryObject<Effect> PARALYZED = EFFECTS.register("paralyzed", ParalyzedEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
