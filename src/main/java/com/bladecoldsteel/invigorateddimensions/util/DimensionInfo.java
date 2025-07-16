package com.bladecoldsteel.invigorateddimensions.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class DimensionInfo {
    public final ResourceLocation dimension;
    public final ResourceLocation display_item;
    public final String name;
    public final int color;
    public final PortalUnlockConditions portal_unlock_conditions;
    public final TeleportationRecipe recipe;

    public DimensionInfo(ResourceLocation dimension, ResourceLocation display_item, String name, int color, PortalUnlockConditions portal_unlock_conditions, TeleportationRecipe recipe) {
        this.dimension = dimension;
        this.display_item = display_item;
        this.name = name;
        this.color = color;
        this.portal_unlock_conditions = portal_unlock_conditions;
        this.recipe = recipe;
    }

    public Item getDisplay_item() {
        return ForgeRegistries.ITEMS.getValue(display_item);
    }

    public static class PortalUnlockConditions {
        public final ResourceLocation advancement;
        public final ResourceLocation mob_kill;

        public PortalUnlockConditions(ResourceLocation advancement, ResourceLocation mob_kill) {
            this.advancement = advancement;
            this.mob_kill = mob_kill;
        }
    }

    public static class TeleportationRecipe {
        public final List<TeleportationIngredient> ingredients;

        public TeleportationRecipe(List<TeleportationIngredient> ingredients) {
           this.ingredients = ingredients;
        }

        public List<TeleportationIngredient> getIngredients() {
            return ingredients;
        }
    }

    public static class TeleportationIngredient {
        public final ResourceLocation item;
        public final int count;

        public TeleportationIngredient(ResourceLocation item, int count) {
            this.item = item;
            this.count = count;
        }

        public ItemStack toStack() {
            return new ItemStack(ForgeRegistries.ITEMS.getValue(item), count);
        }
    }
}