package com.bladecoldsteel.invigorateddimensions.emberwilds.item;

import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EmberwildsItemGroup {
    public static final ItemGroup EMBERWILDS_GROUP = new ItemGroup("invigorated_dimensions_emberwilds_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(EmberwildsBlocks.EMBERED_LOG.get());
        }
    };
}
