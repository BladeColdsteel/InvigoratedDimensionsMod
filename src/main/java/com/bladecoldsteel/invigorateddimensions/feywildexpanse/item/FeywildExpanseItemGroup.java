package com.bladecoldsteel.invigorateddimensions.feywildexpanse.item;

import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FeywildExpanseItemGroup {
    public static final ItemGroup FEYWILD_EXPANSE_GROUP = new ItemGroup("invigorated_dimensions_feywild_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FeywildExpanseBlocks.FEYAN_LOG.get());
        }
    };
}
