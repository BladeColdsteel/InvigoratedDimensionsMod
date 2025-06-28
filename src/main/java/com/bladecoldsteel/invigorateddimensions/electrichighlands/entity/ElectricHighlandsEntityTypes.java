package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.ChargedCrawlerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<EntityType<ChargedCrawlerEntity>> CHARGED_CRAWLER =
            ENTITY_TYPES.register("charged_crawler",
                    () -> EntityType.Builder.of(ChargedCrawlerEntity::new,
                                EntityClassification.MONSTER).sized(1f, 1f)
                            .build(new ResourceLocation(InvigoratedDimensions.MOD_ID, "charged_crawler").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
