package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.ChargedCrawlerEntity;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.boss.RagingTempestEntity;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.projectiles.LightningItemProjectileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    //Ambient
    public static final RegistryObject<EntityType<ChargedCrawlerEntity>> CHARGED_CRAWLER =
            ENTITY_TYPES.register("charged_crawler",
                    () -> EntityType.Builder.of(ChargedCrawlerEntity::new,
                                EntityClassification.MONSTER).sized(1f, 1f)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "charged_crawler").toString()));

    //Monster

    //Boss
    public static final RegistryObject<EntityType<RagingTempestEntity>> RAGING_TEMPEST =
            ENTITY_TYPES.register("raging_tempest",
                    () -> EntityType.Builder.of(RagingTempestEntity::new,
                                    EntityClassification.MONSTER).sized(1.25f, 3f)
                            .fireImmune()
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "raging_tempest").toString()));

    //Projectile
    public static final RegistryObject<EntityType<LightningItemProjectileEntity>> LIGHTNING_BOLT_PROJECTILE =
            ENTITY_TYPES.register("lightning_bolt_projectile",
                    () -> EntityType.Builder.<LightningItemProjectileEntity>of(LightningItemProjectileEntity::new,
                                    EntityClassification.MISC).sized(0.25f, 0.25f)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "lightning_bolt_projectile").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
