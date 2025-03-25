package com.bladecoldsteel.invigorateddimensions.cavernouscove.item;

import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CavernousCoveItemGroup {
    public static final ItemGroup ROCKY_RIFT_GROUP = new ItemGroup("invigorated_dimensions_rocky_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CavernousCoveBlocks.ROCKY_LOG.get());
        }
    };
}
