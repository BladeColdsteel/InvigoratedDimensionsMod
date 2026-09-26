package com.bladecoldsteel.invigorateddimensions.ultra.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.custom.BeastlyBoarEntity;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.projectile.BoarTuskProjectileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UltraDimEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<BeastlyBoarEntity>> BEASTLY_BOAR =
            ENTITY_TYPES.register("beastly_boar",
                    () -> EntityType.Builder.of(BeastlyBoarEntity::new,
                                    EntityClassification.MONSTER).sized(3.0F, 3.0F)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "beastly_boar").toString()));
    //Monster

    //Passive

    //Projectile
    public static final RegistryObject<EntityType<BoarTuskProjectileEntity>> BOAR_TUSK_PROJECTILE =
            ENTITY_TYPES.register("boar_tusk_projectile",
                    () -> EntityType.Builder.<BoarTuskProjectileEntity>of(BoarTuskProjectileEntity::new, EntityClassification.MISC)
                            .sized(0.25f, 0.25f)
                            .setTrackingRange(4)
                            .setUpdateInterval(10)
                            .setShouldReceiveVelocityUpdates(true)
                            .setCustomClientFactory((spawn, world) ->
                                    new BoarTuskProjectileEntity(UltraDimEntityTypes.BOAR_TUSK_PROJECTILE.get(), world))
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "boar_tusk_projectile").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
