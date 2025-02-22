package com.bladecoldsteel.invigorateddimensions.electrichighlands.util;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<SoundEvent> ELECTRIC_HIGHLANDS_PORTAL_AMBIENT = registerSoundEvent("electric_highlands_portal_ambient");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(InvigoratedDimensions.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
