package com.bladecoldsteel.invigorateddimensions.terranata.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.entity.custom.GiantEarthmawEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TerraNataEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<GiantEarthmawEntity>> GIANT_EARTHMAW =
            ENTITY_TYPES.register("giant_earthmaw",
                    () -> EntityType.Builder.of(GiantEarthmawEntity::new,
                                    EntityClassification.MONSTER).sized(2.0F, 1.0F)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "giant_earthmaw").toString()));
    //Monster

    //Passive

    //Projectile


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
