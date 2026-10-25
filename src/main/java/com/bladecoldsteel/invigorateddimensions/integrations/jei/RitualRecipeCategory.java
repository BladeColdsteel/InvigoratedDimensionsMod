package com.bladecoldsteel.invigorateddimensions.integrations.jei;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.emberwilds.item.EmberwildsItems;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualType;
import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiFluidStackGroup;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fluids.FluidStack;
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

    private FluidStack getFluid(RitualDefinition recipe) {
        RitualDefinition.FluidType fluidSpecifics = (RitualDefinition.FluidType) recipe.getRitualSpecifics();
        Fluid fluid = ForgeRegistries.FLUIDS.getValue(fluidSpecifics.fluidType);
        return fluid == null ? FluidStack.EMPTY : new FluidStack(fluid, 1000);
    }

    @Override
    public void setIngredients(RitualDefinition ritualDefinition, IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, getInput(ritualDefinition));
        ingredients.setOutput(VanillaTypes.ITEM, getOutput(ritualDefinition));
        if (ritualDefinition.getType() == RitualType.FLUID_SACRIFICE) {
            ingredients.setInput(VanillaTypes.FLUID, getFluid(ritualDefinition));
        }
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, RitualDefinition ritualDefinition, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        IGuiFluidStackGroup fluids = recipeLayout.getFluidStacks();
        stacks.init(0, true, 15, 10);
        stacks.init(1, false, 112, 10);

        stacks.set(0, getInput(ritualDefinition));
        stacks.set(1, getOutput(ritualDefinition));

        if (ritualDefinition.getType() == RitualType.FLUID_SACRIFICE) {
            fluids.init(0, true, 67, 10, 16, 16, 1000, false, null);
            fluids.set(0, getFluid(ritualDefinition));
        }
    }

    @Override
    public void draw(RitualDefinition recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();

        ResourceLocation dimensionId = recipe.getDimension();
        String translationKey = "invigorated_dimensions.dimension." + dimensionId.getNamespace() + "." + dimensionId.getPath();
        String dimensionName = I18n.get(translationKey);

        if (recipe.getRitualSpecifics() instanceof RitualDefinition.FireType && recipe.getType() == RitualType.FIRE_SACRIFICE) {
            RitualDefinition.FireType specificFire = (RitualDefinition.FireType) recipe.getRitualSpecifics();
            TextureAtlasSprite animatedSprite = minecraft.getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(new ResourceLocation(specificFire.fireType.getNamespace(), "block/" + specificFire.fireType.getPath() + "_0"));
            minecraft.font.draw(matrixStack, "Input       Fire     Output", 12, 0, 0x404040);
            minecraft.font.draw(matrixStack, "Dimension: " + dimensionName, 5, 40, 0x404040);

            minecraft.getTextureManager().bind(AtlasTexture.LOCATION_BLOCKS);
            AbstractGui.blit(matrixStack, 67, 10, 0, 16, 16, animatedSprite);
        } else if (recipe.getRitualSpecifics() instanceof RitualDefinition.FluidType && recipe.getType() == RitualType.FLUID_SACRIFICE) {
            minecraft.font.draw(matrixStack, "Input      Fluid     Output", 12, 0, 0x404040);
            minecraft.font.draw(matrixStack, "Dimension: " + dimensionName, 5, 40, 0x404040);
        }
    }

    @Override
    public List<ITextComponent> getTooltipStrings(RitualDefinition recipe, double mouseX, double mouseY) {
        List<ITextComponent> tooltips = new ArrayList<>();
        if (mouseX >= 67 && mouseX < 83 && mouseY >= 10 && mouseY < 26) {
            if (recipe.getRitualSpecifics() instanceof RitualDefinition.FireType && recipe.getType() == RitualType.FIRE_SACRIFICE) {
                RitualDefinition.FireType specificFire = (RitualDefinition.FireType) recipe.getRitualSpecifics();
                tooltips.add(new StringTextComponent(specificFire.fireType.getPath().substring(0, 1).toUpperCase() + specificFire.fireType.getPath().substring(1).replace("_", " ")));
                tooltips.add(new StringTextComponent("Throw the item into " + specificFire.fireType.getPath().substring(0, 1).toUpperCase() + specificFire.fireType.getPath().substring(1).replace("_", " ")));
            } else if (recipe.getRitualSpecifics() instanceof RitualDefinition.FluidType && recipe.getType() == RitualType.FLUID_SACRIFICE) {
                RitualDefinition.FluidType specificFluid = (RitualDefinition.FluidType) recipe.getRitualSpecifics();
                tooltips.add(new StringTextComponent(specificFluid.fluidType.getPath().substring(0, 1).toUpperCase() + specificFluid.fluidType.getPath().substring(1).replace("_", " ")));
                tooltips.add(new StringTextComponent("Throw the item into " + specificFluid.fluidType.getPath().substring(0, 1).toUpperCase() + specificFluid.fluidType.getPath().substring(1).replace("_", " ")));
            }
        }
        return tooltips;
    }
}
