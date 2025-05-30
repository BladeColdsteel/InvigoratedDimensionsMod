package com.bladecoldsteel.invigorateddimensions.universal.screens.custom.screens;

import com.bladecoldsteel.invigorateddimensions.universal.network.InvigoratedDimensionsNetworkHandler;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.RotateBlockPacket;
import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.EnergySinkContainer;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.EnergySinkTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class EnergySinkScreen extends ContainerScreen<EnergySinkContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("invigorated_dimensions", "textures/gui/energy_sink.png");

    public EnergySinkScreen(EnergySinkContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        int centerX = this.leftPos + this.imageWidth / 2;
        int centerY = this.topPos + this.imageHeight / 2;

        this.addButton(new Button(centerX - 30, centerY - 40, 60, 20, new StringTextComponent("Rotate"), button -> {
            InvigoratedDimensionsNetworkHandler.INSTANCE.sendToServer(new RotateBlockPacket(menu.getTile().getBlockPos()));
        }));
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, 8.0F, 6.0F, 4210752);
        this.font.draw(matrixStack, this.inventory.getDisplayName(), 8.0F, (float)(this.imageHeight - 96 + 2), 4210752);

        EnergySinkTileEntity tile = this.menu.getTile();
        if (tile != null) {
            int output = tile.getCurrentOutput();
            this.font.draw(matrixStack, "Generating: " + output + " FE/t", 8, 20, 4210752);

            String facingInfo = tile.getFacingInfo();
            this.font.draw(matrixStack, facingInfo, 8, 32, 4210752);
        }
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bind(TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);

        ItemStack blockItem = this.menu.getTile().getTargetBlockItem();
        if (!blockItem.isEmpty()) {
            int x = this.leftPos + 8;
            int y = this.topPos + 52;

            this.itemRenderer.renderAndDecorateItem(blockItem, x, y);
            this.itemRenderer.renderGuiItemDecorations(this.font, blockItem, x, y);

            if (mouseX >= x && mouseX < x + 16 && mouseY >= y && mouseY < y + 16) {
                this.renderTooltip(matrixStack, blockItem, mouseX, mouseY);
            }
        }
    }
}
