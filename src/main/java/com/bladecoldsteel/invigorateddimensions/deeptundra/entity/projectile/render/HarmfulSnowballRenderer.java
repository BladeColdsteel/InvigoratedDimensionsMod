package com.bladecoldsteel.invigorateddimensions.deeptundra.entity.projectile.render;

import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.projectile.custom.HarmfulSnowballEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;

public class HarmfulSnowballRenderer extends SpriteRenderer<HarmfulSnowballEntity> {
    public HarmfulSnowballRenderer(EntityRendererManager manager, ItemRenderer renderer) {
        super(manager, renderer);
    }

    @Override
    public void render(HarmfulSnowballEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        matrixStack.pushPose();
        matrixStack.scale(3.0F, 3.0F, 3.0F);
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
        matrixStack.popPose();
    }
}
