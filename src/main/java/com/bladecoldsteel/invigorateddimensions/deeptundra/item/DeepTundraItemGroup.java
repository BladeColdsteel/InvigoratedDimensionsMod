package com.bladecoldsteel.invigorateddimensions.deeptundra.item;

import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DeepTundraItemGroup {
    public static final ItemGroup ICEY_RIFT_GROUP = new ItemGroup("invigorated_dimensions_icy_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DeepTundraBlocks.ICEY_LOG.get());
        }
    };
}
