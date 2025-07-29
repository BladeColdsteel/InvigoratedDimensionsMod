package com.bladecoldsteel.invigorateddimensions.terranata.item;

import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TerraNataItemGroup {
    public static final ItemGroup GROUND_RIFT_GROUP = new ItemGroup("invigorated_dimensions_grounded_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TerraNataBlocks.LOG.get());
        }
    };
}
