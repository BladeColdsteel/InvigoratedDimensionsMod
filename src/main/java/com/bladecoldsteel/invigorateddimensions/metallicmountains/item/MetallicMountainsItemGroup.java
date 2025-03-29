package com.bladecoldsteel.invigorateddimensions.metallicmountains.item;

import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MetallicMountainsItemGroup {
    public static final ItemGroup STEEL_RIFT_GROUP = new ItemGroup("invigorated_dimensions_steel_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MetallicMountainsBlocks.METALLIC_LOG.get());
        }
    };
}
