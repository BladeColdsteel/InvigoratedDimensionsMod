package com.bladecoldsteel.invigorateddimensions.dreamland.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.dreamland.entity.custom.boss.PitulantPendulumEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DreamlandEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Ambient

    //Monster

    //Boss
    public static final RegistryObject<EntityType<PitulantPendulumEntity>> PITULANT_PENDULUM =
            ENTITY_TYPES.register("pitulant_pendulum",
                    () -> EntityType.Builder.of(PitulantPendulumEntity::new,
                                    EntityClassification.MONSTER).sized(1.25f, 3f)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "pitulant_pendulum").toString()));

    //Projectile


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
