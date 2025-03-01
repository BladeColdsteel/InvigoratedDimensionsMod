package com.bladecoldsteel.invigorateddimensions.electrichighlands.item;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ElectricHighlandsItemGroup {
    public static final ItemGroup ELECTRIC_HIGHLANDS_GROUP = new ItemGroup("invigorated_dimensions_electric_highlands_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get());
        }
    };
}
