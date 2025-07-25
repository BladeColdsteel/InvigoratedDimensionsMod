package com.bladecoldsteel.invigorateddimensions.draconicrift.item;

import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DraconicRiftItemGroup {
    public static final ItemGroup DRACONIC_RIFT_GROUP = new ItemGroup("invigorated_dimensions_draconic_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DraconicRiftBlocks.LOG.get());
        }
    };
}
