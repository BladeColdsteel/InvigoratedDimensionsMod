package com.bladecoldsteel.invigorateddimensions.emberwilds.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.boss.FireLordEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EmberwildsEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<FireLordEntity>> FIRE_LORD =
            ENTITY_TYPES.register("fire_lord",
                    () -> EntityType.Builder.of(FireLordEntity::new,
                                    EntityClassification.MONSTER).sized(1.0f, 8.0F)
                            .fireImmune()
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "fire_lord").toString()));
    //Monster

    //Passive

    //Projectile


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
