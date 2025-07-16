package com.bladecoldsteel.invigorateddimensions.universal.screens;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.ElementalShrineContainer;
import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.EnergySinkContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UniversalContainers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<ContainerType<EnergySinkContainer>> ENERGY_SINK_MENU =
            CONTAINERS.register("energy_sink",
                    () -> IForgeContainerType.create((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        return new EnergySinkContainer(windowId, inv, pos);
                    }));
    public static final RegistryObject<ContainerType<ElementalShrineContainer>> ELEMENTAL_SHRINE_MENU =
            CONTAINERS.register("elemental_shrine",
                    () -> IForgeContainerType.create((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        return new ElementalShrineContainer(windowId, inv, pos);
                    }));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
