package com.bladecoldsteel.invigorateddimensions.dreamland.screens.custom.screens;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.dreamland.effects.DreamlandEffects;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.StringTextComponent;

public class MentalPrisonScreen extends Screen {
    private static final ResourceLocation WATCH_TEXTURE = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/gui/mental_prison_clock.png");
    private static final int WATCH_SIZE = 128;
    private float currentAngle;

    public MentalPrisonScreen() {
        super(new StringTextComponent("Mental Prison"));
    }

    @Override
    public void tick() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null && !mc.player.hasEffect(DreamlandEffects.MENTAL_PRISON.get())) {
            mc.setScreen(null);
        }
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        //Text
        drawCenteredString(matrixStack, this.font, "Click watch in the middle of the screen", this.width / 2, 40, 0xFFAA00);
        drawCenteredString(matrixStack, this.font, "to stop effect early.", this.width / 2, 50, 0xFFAA00);

        //Watch
        renderSwingingWatch(matrixStack, partialTicks);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Minecraft mc = Minecraft.getInstance();
        if (button == 0) {
            float threshold = 15.0F;
            if (Math.abs(currentAngle) <= threshold) {
                int watchCenterX = this.width / 2;
                int watchCenterY = this.height / 2 + 44;

                int halfSize = 64;

                boolean insideX = mouseX >= (watchCenterX - halfSize) && mouseX <= (watchCenterX + halfSize);
                boolean insideY = mouseY >= (watchCenterY - halfSize) && mouseY <= (watchCenterY + halfSize);
                if (insideX && insideY) {
                    mc.setScreen(null);
                    if (mc.player != null && mc.player.hasEffect(DreamlandEffects.MENTAL_PRISON.get())) {
                        mc.player.removeEffect(DreamlandEffects.MENTAL_PRISON.get());
                    }
                    return true;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void renderSwingingWatch(MatrixStack matrixStack, float partialTicks) {
        Minecraft mc = Minecraft.getInstance();
        mc.getTextureManager().bind(WATCH_TEXTURE);
        RenderSystem.color4f(1F, 1F, 1F, 1F);

        //Pivot
        float pivotX = this.width / 2.0F;
        float pivotY = this.height / 2.0F - 20.0F;

        //Swing
        float time = (mc.player != null ? mc.player.tickCount : 0) + partialTicks;
        this.currentAngle = MathHelper.sin(time * 0.12F) * 60.0F;

        matrixStack.pushPose();

        matrixStack.translate(pivotX, pivotY, 0.0D);
        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(currentAngle));
        blit(matrixStack, -WATCH_SIZE / 2, 0, 0, 0, WATCH_SIZE, WATCH_SIZE, WATCH_SIZE, WATCH_SIZE);

        matrixStack.popPose();
    }
}
