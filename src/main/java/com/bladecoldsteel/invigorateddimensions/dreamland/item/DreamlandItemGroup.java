package com.bladecoldsteel.invigorateddimensions.dreamland.item;

import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DreamlandItemGroup {
    public static final ItemGroup PSYCHEDLIC_RIFT_GROUP = new ItemGroup("invigorated_dimensions_psychedelic_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DreamlandBlocks.PSYCHEDELIC_LOG.get());
        }
    };
}
