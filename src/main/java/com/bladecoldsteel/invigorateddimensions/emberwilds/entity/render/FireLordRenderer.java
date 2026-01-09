package com.bladecoldsteel.invigorateddimensions.emberwilds.entity.render;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.FireLordEntity;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.model.FireLordModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;

public class FireLordRenderer extends MobRenderer<FireLordEntity, FireLordModel<FireLordEntity>> {
    public FireLordRenderer(EntityRendererManager manager) {
        super(manager, new FireLordModel<>(1.0F, 0.0F, 64, 256), 1.0F);
        this.addLayer(new FireLordEyesRenderer(this));
        this.addLayer(new BipedArmorLayer<>(this,
                new BipedModel<>(0.5F),
                new BipedModel<>(1.0F)));
    }

    @Override
    public ResourceLocation getTextureLocation(FireLordEntity fireLordEntity) {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/fire_lord.png");
    }
}