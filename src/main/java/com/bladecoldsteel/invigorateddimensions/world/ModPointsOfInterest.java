package com.bladecoldsteel.invigorateddimensions.world;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPointsOfInterest {

    public static final DeferredRegister<PointOfInterestType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<PointOfInterestType> ELECTRIC_HIGHLANDS_PORTAL = POI.register("electric_highlands_portal",
            () -> new PointOfInterestType("electric_highlands_portal", PointOfInterestType.getBlockStates(ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get()), 0, 1));

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
        System.out.println("Registering Point of Interest: Electric Highlands Portal");
        ELECTRIC_HIGHLANDS_PORTAL.ifPresent(poi -> {
            System.out.println("POI Name: " + poi.toString());
            System.out.println("Registered Blocks: " + poi.getBlockStates());
        });
    }

}
