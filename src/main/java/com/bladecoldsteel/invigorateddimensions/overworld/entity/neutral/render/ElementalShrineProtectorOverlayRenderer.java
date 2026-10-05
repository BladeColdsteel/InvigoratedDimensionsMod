package com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.render;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.custom.ElementalShrineProtectorsEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

import java.awt.Color;

public class ElementalShrineProtectorOverlayRenderer extends GeoLayerRenderer<ElementalShrineProtectorsEntity> {
    private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/elemental_shrine_protector_color_layer.png");
    public ElementalShrineProtectorOverlayRenderer(ElementalShrineProtectorRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, ElementalShrineProtectorsEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float betHeadYaw, float headPitch) {
        float hue = ((entity.tickCount + partialTicks) % 200) / 200.0F;
        int color = Color.HSBtoRGB(hue, 1.0F, 1.0F);

        float red = ((color >> 16) & 255) / 255.0F;
        float green = ((color >> 8) & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
    }
}
