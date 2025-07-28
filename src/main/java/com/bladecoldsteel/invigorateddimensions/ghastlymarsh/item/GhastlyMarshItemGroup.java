package com.bladecoldsteel.invigorateddimensions.ghastlymarsh.item;

import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GhastlyMarshItemGroup {
    public static final ItemGroup SPOOKY_RIFT_GROUP = new ItemGroup("invigorated_dimensions_spooky_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GhastlyMarshBlocks.LOG.get());
        }
    };
}
