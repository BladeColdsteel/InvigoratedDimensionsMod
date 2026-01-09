package com.bladecoldsteel.invigorateddimensions.emberwilds.entity.render;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.custom.FireLordEntity;
import com.bladecoldsteel.invigorateddimensions.emberwilds.entity.model.FireLordModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class FireLordEyesRenderer extends LayerRenderer<FireLordEntity, FireLordModel<FireLordEntity>> {
    private static final ResourceLocation EYES = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/fire_lord_eyes.png");

    public FireLordEyesRenderer(IEntityRenderer<FireLordEntity, FireLordModel<FireLordEntity>> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack matrix, IRenderTypeBuffer buffer, int packedLight, FireLordEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType renderType = RenderType.eyes(EYES);
        EntityModel<FireLordEntity> model = this.getParentModel();

        model.renderToBuffer(matrix, buffer.getBuffer(renderType), 0xF000F, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}