package com.bladecoldsteel.invigorateddimensions.grassyknoll.item;

import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GrassyKnollItemGroup {
    public static final ItemGroup GRASSY_KNOLL_GROUP = new ItemGroup("invigorated_dimensions_grassy_knoll_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GrassyKnollBlocks.GRASSY_LOG.get());
        }
    };
}
