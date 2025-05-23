package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.render;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.ChargedCrawlerEntity;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.model.ChargedCrawlerModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChargedCrawlerRender extends MobRenderer<ChargedCrawlerEntity, ChargedCrawlerModel<ChargedCrawlerEntity>> {
    public ChargedCrawlerRender(EntityRendererManager manager) {
        super(manager, new ChargedCrawlerModel<>(), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(ChargedCrawlerEntity chargedCrawlerEntity) {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/charged_crawler.png");
    }
}
