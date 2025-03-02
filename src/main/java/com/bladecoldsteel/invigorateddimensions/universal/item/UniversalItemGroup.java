package com.bladecoldsteel.invigorateddimensions.universal.item;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UniversalItemGroup {
    public static final ItemGroup UNIVERSAL_GROUP = new ItemGroup("invigorated_dimensions") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(UniversalBlocks.CRYSTALLIZED_LEAVES.get());
        }
    };
}
