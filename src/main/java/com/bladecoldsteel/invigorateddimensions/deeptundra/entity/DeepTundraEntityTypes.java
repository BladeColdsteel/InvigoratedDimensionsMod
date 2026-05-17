package com.bladecoldsteel.invigorateddimensions.deeptundra.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom.RimeboundEntity;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.projectile.custom.HarmfulSnowballEntity;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.OverworldEntityTypes;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.boss.custom.FossilizedTraderEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepTundraEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Boss
    public static final RegistryObject<EntityType<RimeboundEntity>> RIMEBOUND =
            ENTITY_TYPES.register("rimebound",
                    () -> EntityType.Builder.of(RimeboundEntity::new,
                                    EntityClassification.MONSTER).sized(1.5F, 3.0F)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "rimebound").toString()));
    //Monster

    //Passive

    //Projectile
    public static final RegistryObject<EntityType<HarmfulSnowballEntity>> HARMFUL_SNOWBALL =
            ENTITY_TYPES.register("harmful_snowball",
                    () -> EntityType.Builder.<HarmfulSnowballEntity>of(HarmfulSnowballEntity::new, EntityClassification.MISC)
                            .sized(0.25f, 0.5f)
                            .setTrackingRange(4)
                            .setUpdateInterval(10)
                            .setShouldReceiveVelocityUpdates(true)
                            .setCustomClientFactory((spawn, world) ->
                                    new HarmfulSnowballEntity(DeepTundraEntityTypes.HARMFUL_SNOWBALL.get(), world))
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "harmful_snowball").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
