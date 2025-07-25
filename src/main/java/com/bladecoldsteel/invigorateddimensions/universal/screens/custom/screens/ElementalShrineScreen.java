package com.bladecoldsteel.invigorateddimensions.universal.screens.custom.screens;

import com.bladecoldsteel.invigorateddimensions.universal.network.InvigoratedDimensionsNetworkHandler;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.SubmitShrineItemPacket;
import com.bladecoldsteel.invigorateddimensions.universal.screens.custom.containers.ElementalShrineContainer;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementalShrineScreen extends ContainerScreen<ElementalShrineContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("invigorated_dimensions", "textures/gui/elemental_shrine.png");
    private ResourceLocation selectedDimension = null;
    private final Map<Button, ResourceLocation> dimensionButtonMap = new HashMap<>();
    private int scrollOffset = 0;
    private boolean isDragging = false;
    private static final int MAX_VISIBLE = 7;

    public ElementalShrineScreen(ElementalShrineContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.imageWidth = 276;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        System.out.println("[Screen] init() triggered");
        updateDimensionButtons();
        System.out.println("[Screen] updateDimensionButtons() called");
        System.out.println("[Screen] dimensionData size: " + DimensionInfoDataLoader.INSTANCE.dimensionData.size());
        int centerX = this.leftPos + this.imageWidth / 2;
        int centerY = this.topPos + this.imageHeight / 2;

        this.addButton(new Button(centerX - 32, centerY - 75, 50, 20, new StringTextComponent("Submit"), button -> {
            if (selectedDimension != null) {
                BlockPos pos = menu.getTile().getBlockPos();
                InvigoratedDimensionsNetworkHandler.INSTANCE.sendToServer(new SubmitShrineItemPacket(selectedDimension, pos));
            }
        }));
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, 8.0F, 6.0F, 4210752);
        this.font.draw(matrixStack, this.inventory.getDisplayName(), 108.0F, (float)(this.imageHeight - 96 + 2), 4210752);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bind(TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, x, y, this.getBlitOffset(), 0, 0, this.imageWidth, this.imageHeight, 256, 512);

        renderScrollbar(matrixStack);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);

        if (selectedDimension != null) {
            DimensionInfo data = DimensionInfoDataLoader.INSTANCE.dimensionData.get(selectedDimension);
            if (data != null) {
                int x = (this.width - this.imageWidth) / 2;
                int y = (this.height - this.imageHeight) / 2;

                PlayerEntity player = Minecraft.getInstance().player;
                ItemStack displayItem = new ItemStack(data.getDisplay_item());

                matrixStack.pushPose();
                float scale = 2.0F;
                int itemX = x + 105;
                int itemY = y + 32;
                matrixStack.translate(itemX, itemY, 100);
                matrixStack.scale(scale, scale, scale);
                RenderSystem.pushMatrix();
                RenderSystem.multMatrix(matrixStack.last().pose());
                this.itemRenderer.renderAndDecorateItem(displayItem, 0, 0);
                RenderSystem.popMatrix();
                matrixStack.popPose();

                int baseX = x + 150;
                int baseY = y + 30;
                int currentX = baseX;
                int currentY = baseY;
                int spacing = 30;
                int maxRight = x + this.width - 24;

                this.font.draw(matrixStack, data.name, x + 160, y + 15, data.color);

                for (DimensionInfo.TeleportationIngredient ingredient : data.recipe.getIngredients()) {
                    int totalRequired = ingredient.count;
                    int submitted = menu.getTile().getSubmittedCount(ForgeRegistries.ITEMS.getValue(ingredient.item));
                    int remaining = Math.max(totalRequired - submitted, 0);

                    ItemStack displayIngredient = ingredient.toStack().copy();
                    displayIngredient.setCount(remaining);

                    this.itemRenderer.renderAndDecorateItem(displayIngredient, currentX, currentY);
                    this.itemRenderer.renderGuiItemDecorations(this.font, displayIngredient, currentX, currentY);

                    if (mouseX >= currentX && mouseX < currentX + 16 && mouseY >= currentY && mouseY < currentY + 16) {
                        this.renderTooltip(matrixStack, displayIngredient, mouseX, mouseY);
                    }

                    currentX += spacing;
                    if (currentX > maxRight) {
                        currentX = baseX;
                        currentY += spacing;
                    }
                }
            }
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        int total = DimensionInfoDataLoader.INSTANCE.dimensionData.size();
        int maxScroll = Math.max(0, total - MAX_VISIBLE);
        if (maxScroll > 0) {
            scrollOffset = MathHelper.clamp(scrollOffset - (int) delta, 0, maxScroll);
            updateDimensionButtons();
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.isDragging = false;
        int scrollBarX = this.leftPos + 130;
        int scrollBarY = this.topPos + 20;
        if (canScroll() && mouseX >= scrollBarX && mouseX <= scrollBarX + 6 && mouseY >= scrollBarY && mouseY <= scrollBarY + 139) {
            this.isDragging = true;
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (this.isDragging) {
            int scrollBarY = this.topPos + 20;
            int total = DimensionInfoDataLoader.INSTANCE.dimensionData.size();
            int maxScroll = Math.max(0, total - MAX_VISIBLE);
            float scrollArea = 139F - 27F;
            float percent = (float)(mouseY - scrollBarY - 13.5F) / scrollArea;
            this.scrollOffset = MathHelper.clamp((int)(percent * maxScroll + 0.5F), 0, maxScroll);
            updateDimensionButtons();
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    private void renderScrollbar(MatrixStack matrixStack) {
        int total = DimensionInfoDataLoader.INSTANCE.dimensionData.size();
        int maxScroll = Math.max(0, total - MAX_VISIBLE);
        int scrollBarX = this.leftPos + 87;
        int scrollBarY = this.topPos + 19;

        if (canScroll()) {
            float percent = (float) scrollOffset / maxScroll;
            int handleY = scrollBarY + (int)(percent * (139 - 27));
            blit(matrixStack, scrollBarX, handleY, 6, 27, 0, 199, 6, 27, 256, 512);
        } else {
            blit(matrixStack, scrollBarX, scrollBarY, 6, 27, 6, 199, 6, 27, 256, 512);
        }
    }

    private boolean canScroll() {
        return DimensionInfoDataLoader.INSTANCE.dimensionData.size() > MAX_VISIBLE;
    }

    private void updateDimensionButtons() {
        this.buttons.clear();
        this.children.clear();

        List<Map.Entry<ResourceLocation, DimensionInfo>> entries = new ArrayList<>(DimensionInfoDataLoader.INSTANCE.dimensionData.entrySet());

        int guiLeft = this.leftPos;
        int guiTop = this.topPos;
        int buttonX = guiLeft + 5;
        int buttonY = guiTop + 18;
        float textScale = 0.75F;

        int start = scrollOffset;
        int end = Math.min(entries.size(), start + MAX_VISIBLE);

        for (int i = start; i < end; i++) {
            ResourceLocation id = entries.get(i).getKey();
            DimensionInfo info = entries.get(i).getValue();

            Button button = new ScaledTextButton(buttonX, buttonY, 88, 20, new StringTextComponent(info.name),
                    btn -> this.selectedDimension = id, textScale);

            this.addButton(button);
            dimensionButtonMap.put(button, id);
            buttonY += 20;
        }
    }

    public class ScaledTextButton extends Button {
        private final float textScale;

        public ScaledTextButton(int x, int y, int width, int height, ITextComponent title, IPressable onPress, float textScale) {
            super(x, y, width, height, title, onPress);
            this.textScale = textScale;
        }

        @Override
        public void renderButton(MatrixStack matrixStack, int mouseX, int moustY, float partialTicks) {
            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer font = minecraft.font;

            minecraft.getTextureManager().bind(WIDGETS_LOCATION);
            int i = this.getYImage(this.isHovered());
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, this.alpha);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();

            this.blit(matrixStack, this.x, this.y, 5, 46 + i * 20, this.width / 2, this.height);
            this.blit(matrixStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

            matrixStack.pushPose();

            float centerX = this.x + this.width / 2.0F;
            float centerY = this.y + (this.height - 8) / 2.0F;
            matrixStack.translate(centerX + 10, centerY, 0);
            matrixStack.scale(textScale, textScale, textScale);
            float scaledWidth = font.width(this.getMessage().getString()) / textScale;
            matrixStack.translate(-scaledWidth / 2.0F, 0, 0);
            int color = this.isHovered() ? 0xFFFFA0 : 0xE0E0E0;
            font.draw(matrixStack, this.getMessage().getString(), 0, 0, color);

            matrixStack.popPose();
        }
    }

}
