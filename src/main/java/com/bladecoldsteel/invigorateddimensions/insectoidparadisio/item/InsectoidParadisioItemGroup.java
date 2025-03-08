package com.bladecoldsteel.invigorateddimensions.insectoidparadisio.item;

import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class InsectoidParadisioItemGroup {
    public static final ItemGroup INSECTOID_PARADISIO_GROUP = new ItemGroup("invigorated_dimensions_buggy_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(InsectoidParadisioBlocks.BUGGED_LOG.get());
        }
    };
}
