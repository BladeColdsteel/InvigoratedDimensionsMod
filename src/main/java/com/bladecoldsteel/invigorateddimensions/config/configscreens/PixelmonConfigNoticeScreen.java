package com.bladecoldsteel.invigorateddimensions.config.configscreens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class PixelmonConfigNoticeScreen extends Screen {
    public PixelmonConfigNoticeScreen() {
        super(new StringTextComponent("Pixelmon Config Notice"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.addButton(new Button(centerX - 75, centerY + 40, 150, 20,
                new StringTextComponent("Continue"), (button) -> {
            playRandomTypeClick();
            Minecraft.getInstance().setScreen(null);
            }
        ));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        drawCenteredString(matrixStack, this.font, "Pixelmon config files were Updated", this.width / 2, 40, 0xFFAA00);
        drawCenteredString(matrixStack, this.font, "Vanilla mob spawning has been enabled for you", this.width / 2, 70, 0xFFFFFF);
        drawCenteredString(matrixStack, this.font, "Please restart the game for these changes to take effect", this.width / 2, 85, 0xAAAAAA);
        drawCenteredString(matrixStack, this.font, "Once done this message will not appear again", this.width / 2, 100, 0xAAAAAA);
        drawCenteredString(matrixStack, this.font, "If you wish for this to change, go to the invigorated-dimensions-common config and set spawn-replacement to false", this.width / 2, 115, 0xAAAAAA);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }

    private static final ResourceLocation[] TYPE_SOUNDS = {
            new ResourceLocation("minecraft", "item.flintandsteel.use"),         // Fire
            new ResourceLocation("minecraft", "item.bucket.empty"),              // Water
            new ResourceLocation("minecraft", "entity.lightning_bolt.thunder"),  // Electric
            new ResourceLocation("minecraft", "entity.ghast.shoot"),             // Ghost
            new ResourceLocation("minecraft", "block.grass.break"),              // Grass
            new ResourceLocation("minecraft", "block.glass.break")
    };

    private void playRandomTypeClick() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ResourceLocation soundId = TYPE_SOUNDS[new Random().nextInt(TYPE_SOUNDS.length)];

        mc.player.playSound(
                ForgeRegistries.SOUND_EVENTS.getValue(soundId),
                1.0F, 1.0F
        );

        System.out.println("[InvigoratedDimensions] Played click sound: " + soundId);
    }
}
