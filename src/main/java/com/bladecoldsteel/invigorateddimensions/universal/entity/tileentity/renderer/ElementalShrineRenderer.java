package com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.renderer;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.models.ElementalShrineModel;
import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom.ElementalShrineTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;

public class ElementalShrineRenderer extends TileEntityRenderer<ElementalShrineTileEntity> {

    private final ResourceLocation texture = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/elemental_shrine/elemental_shrine.png");
    private final ElementalShrineModel<?> model = new ElementalShrineModel<>();

    public ElementalShrineRenderer(TileEntityRendererDispatcher rendererDispatcher) {
        super(rendererDispatcher);
    }

    @Override
    public void render(ElementalShrineTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        matrixStack.pushPose();

        matrixStack.translate(0.5D, 0.0D, 0.5D);
        matrixStack.scale(1.0F, -1.0F, -1.0F);
        Minecraft.getInstance().getTextureManager().bind(texture);
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/elemental_shrine/elemental_shrine.png")));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1, 1, 1, 1);

        matrixStack.popPose();
    }
}
