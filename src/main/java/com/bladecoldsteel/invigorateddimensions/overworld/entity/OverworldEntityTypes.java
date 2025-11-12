package com.bladecoldsteel.invigorateddimensions.overworld.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.custom.boss.FossilizedTraderEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class OverworldEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<FossilizedTraderEntity>> FOSSIL_TRADER =
            ENTITY_TYPES.register("fossilized_trader",
                    () -> EntityType.Builder.of(FossilizedTraderEntity::new,
                                EntityClassification.MONSTER).sized(0.6F * 1.5F, 8.0F)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "fossilized_trader").toString()));
    //Monster

    //Passive

    //Projectile
    public static final RegistryObject<EntityType<FossilizedTraderEntity.EmeraldItemProjectile>> EMERALD_PROJECTILE =
            ENTITY_TYPES.register("emerald_projectile",
                    () -> EntityType.Builder.<FossilizedTraderEntity.EmeraldItemProjectile>of(FossilizedTraderEntity.EmeraldItemProjectile::new, EntityClassification.MISC)
                            .sized(0.25f, 0.25f)
                            .setTrackingRange(4)
                            .setUpdateInterval(10)
                            .setShouldReceiveVelocityUpdates(true)
                            .setCustomClientFactory((spawn, world) ->
                                    new FossilizedTraderEntity.EmeraldItemProjectile(OverworldEntityTypes.EMERALD_PROJECTILE.get(), world))
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "emerald_projectile").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
