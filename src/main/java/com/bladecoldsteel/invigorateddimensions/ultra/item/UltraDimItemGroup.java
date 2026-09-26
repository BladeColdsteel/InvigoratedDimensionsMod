package com.bladecoldsteel.invigorateddimensions.ultra.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UltraDimItemGroup {
    public static final ItemGroup ULTRA_DIM_GROUP = new ItemGroup("invigorated_dimensions_ultra_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(UltraDimItems.BOAR_TUSK.get());
        }
    };
}
