package com.bladecoldsteel.invigorateddimensions.item;

import com.bladecoldsteel.invigorateddimensions.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup INVIGORATED_DIMENSIONS_GROUP = new ItemGroup("invigorated_dimensions_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.ELECTRICALLY_CHARGED_LOG.get());
        }
    };
}
