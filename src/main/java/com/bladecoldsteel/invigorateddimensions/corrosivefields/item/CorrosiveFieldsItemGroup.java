package com.bladecoldsteel.invigorateddimensions.corrosivefields.item;

import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CorrosiveFieldsItemGroup {
    public static final ItemGroup CORROSIVE_RIFT_GROUP = new ItemGroup("invigorated_dimensions_corrosive_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CorrosiveFieldsBlocks.LOG.get());
        }
    };
}
