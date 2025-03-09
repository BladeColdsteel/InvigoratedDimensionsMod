package com.bladecoldsteel.invigorateddimensions.valleydeath.item;

import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ValleyDeathItemGroup {
    public static final ItemGroup DARKENED_RIFT_GROUP = new ItemGroup("invigorated_dimensions_darkened_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ValleyDeathBlocks.DARKENED_LOG.get());
        }
    };
}
