package com.bladecoldsteel.invigorateddimensions.celestialrealm.item;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HeavenlyRealmItemGroup {
    public static final ItemGroup FLYING_RIFT_GROUP = new ItemGroup("invigorated_dimensions_flying_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HeavenlyRealmBlocks.FLOATING_LOG.get());
        }
    };
}
