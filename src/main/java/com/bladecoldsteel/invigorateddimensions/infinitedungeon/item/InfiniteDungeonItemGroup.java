package com.bladecoldsteel.invigorateddimensions.infinitedungeon.item;

import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class InfiniteDungeonItemGroup {
    public static final ItemGroup FIGHTING_RIFT_GROUP = new ItemGroup("invigorated_dimensions_fighting_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(InfiniteDungeonBlocks.TOUGH_LOG.get());
        }
    };
}
