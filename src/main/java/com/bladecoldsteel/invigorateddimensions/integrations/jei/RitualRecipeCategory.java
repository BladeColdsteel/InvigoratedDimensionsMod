package com.bladecoldsteel.invigorateddimensions.integrations.jei;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.item.EmberwildsItems;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualType;
import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class RitualRecipeCategory implements IRecipeCategory<RitualDefinition> {
    public static final ResourceLocation UID = new ResourceLocation(InvigoratedDimensions.MOD_ID, "rituals");
    private final IDrawable background;
    private final IDrawable icon;
    //private final IDrawable finishArrow;

    public RitualRecipeCategory(IGuiHelper helper) {
        this.background = helper.createBlankDrawable(150, 64);
        this.icon = helper.createDrawableIngredient(new ItemStack(EmberwildsItems.FIRE_BOSS_KEY.get()));
        //this.finishArrow = helper.createDrawable();
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends RitualDefinition> getRecipeClass() {
        return RitualDefinition.class;
    }

    @Override
    public String getTitle() {
        return "Dimensional Ritual";
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    private ItemStack getInput(RitualDefinition recipe) {
        Item item = ForgeRegistries.ITEMS.getValue(recipe.getInput());
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    private ItemStack getOutput(RitualDefinition recipe) {
        Item item = ForgeRegistries.ITEMS.getValue(recipe.getOutput());
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    @Override
    public void setIngredients(RitualDefinition ritualDefinition, IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, getInput(ritualDefinition));
        ingredients.setOutput(VanillaTypes.ITEM, getOutput(ritualDefinition));
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, RitualDefinition ritualDefinition, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(0, true, 15, 10);
        stacks.init(1, false, 112, 10);

        stacks.set(0, getInput(ritualDefinition));
        stacks.set(1, getOutput(ritualDefinition));
    }

    @Override
    public void draw(RitualDefinition recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        TextureAtlasSprite fireSprite = minecraft.getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(new ResourceLocation("minecraft", "block/soul_fire_0"));

        ResourceLocation dimensionId = recipe.getDimension();
        String translationKey = "invigorated_dimensions.dimension." + dimensionId.getNamespace() + "." + dimensionId.getPath();
        String dimensionName = I18n.get(translationKey);

        minecraft.font.draw(matrixStack, "Input       Fire     Output", 12, 0, 0x404040);
        minecraft.font.draw(matrixStack, "Dimension: " + dimensionName, 5, 40, 0x404040);

        minecraft.getTextureManager().bind(AtlasTexture.LOCATION_BLOCKS);
        AbstractGui.blit(matrixStack, 67, 10, 0, 16, 16, fireSprite);
    }

    @Override
    public List<ITextComponent> getTooltipStrings(RitualDefinition recipe, double mouseX, double mouseY) {
        List<ITextComponent> tooltips = new ArrayList<>();
        if (mouseX >= 67 && mouseX < 83 && mouseY >= 10 && mouseY < 26) {
            tooltips.add(new StringTextComponent("Soul Fire"));
            tooltips.add(new StringTextComponent("Throw the item into Soul Fire"));
        }
        return tooltips;
    }
}
