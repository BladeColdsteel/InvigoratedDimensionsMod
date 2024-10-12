package com.bladecoldsteel.invigorateddimensions.world.dimension;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomSurfaceBuilders {

    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS =
            DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, InvigoratedDimensions.MOD_ID);

    public static void register(IEventBus eventBus) {
        SURFACE_BUILDERS.register(eventBus);
    }

}
