package com.bladecoldsteel.invigorateddimensions.grassyknoll.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.custom.boss.AngryTreantEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GrassyKnollEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<AngryTreantEntity>> ANGRY_TREANT =
            ENTITY_TYPES.register("angry_treant",
                    () -> EntityType.Builder.of(AngryTreantEntity::new,
                                    EntityClassification.MONSTER).sized(2.0F, 8.0F)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "angry_treant").toString()));
    //Monster

    //Passive

    //Projectile
    public static final RegistryObject<EntityType<AngryTreantEntity.AppleItemProjectile>> APPLE_PROJECTILE =
            ENTITY_TYPES.register("apple_projectile",
                    () -> EntityType.Builder.<AngryTreantEntity.AppleItemProjectile>of(AngryTreantEntity.AppleItemProjectile::new, EntityClassification.MISC)
                            .sized(0.25f, 0.25f)
                            .setTrackingRange(4)
                            .setUpdateInterval(10)
                            .setShouldReceiveVelocityUpdates(true)
                            .setCustomClientFactory((spawn, world) ->
                                    new AngryTreantEntity.AppleItemProjectile(GrassyKnollEntityTypes.APPLE_PROJECTILE.get(), world))
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "apple_projectile").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
