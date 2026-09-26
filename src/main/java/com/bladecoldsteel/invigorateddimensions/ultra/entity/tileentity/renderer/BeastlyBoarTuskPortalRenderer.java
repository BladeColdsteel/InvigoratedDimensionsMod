package com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.renderer;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.custom.BeastlyBoarTuskPortalTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class BeastlyBoarTuskPortalRenderer extends TileEntityRenderer<BeastlyBoarTuskPortalTileEntity> {
    private static final ResourceLocation PORTAL_TEXTURE = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/block/beastly_boar_tusk_portal.png");

    public BeastlyBoarTuskPortalRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(BeastlyBoarTuskPortalTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        matrixStack.pushPose();

        matrixStack.translate(0.5D, 0.0D, 0.5D);
        float cameraYaw = Minecraft.getInstance().gameRenderer.getMainCamera().getYRot();
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - cameraYaw));
        Matrix4f matrix = matrixStack.last().pose();
        IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityTranslucent(PORTAL_TEXTURE));

        float left = -0.5F;
        float right = 0.5F;
        float bottom = 0.0F;
        float up = 2.0F;

        vertexBuilder.vertex(matrix, left, bottom, 0.0F).color(255, 255, 255, 255).uv(0.0F, 1.0F).overlayCoords(combinedOverlay).uv2(combinedLight).normal(0.0F, 0.0F, 1.0F).endVertex();
        vertexBuilder.vertex(matrix, right, bottom, 0.0F).color(255, 255, 255, 255).uv(1.0F, 1.0F).overlayCoords(combinedOverlay).uv2(combinedLight).normal(0.0F, 0.0F, 1.0F).endVertex();
        vertexBuilder.vertex(matrix, right, up, 0.0F).color(255, 255, 255, 255).uv(1.0F, 0.0F).overlayCoords(combinedOverlay).uv2(combinedLight).normal(0.0F, 0.0F, 1.0F).endVertex();
        vertexBuilder.vertex(matrix, left, up, 0.0F).color(255, 255, 255, 255).uv(0.0F, 0.0F).overlayCoords(combinedOverlay).uv2(combinedLight).normal(0.0F, 0.0F, 1.0F).endVertex();

        matrixStack.popPose();
    }
}
