package com.bladecoldsteel.invigorateddimensions.waterydepths.item;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WateryDepthsItemGroup {
    public static final ItemGroup WATERY_DEPTHS_GROUP = new ItemGroup("invigorated_dimensions_watery_depths_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WateryDepthsBlocks.WATERY_LOG.get());
        }
    };
}
