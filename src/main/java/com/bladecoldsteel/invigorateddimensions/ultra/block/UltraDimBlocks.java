package com.bladecoldsteel.invigorateddimensions.ultra.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.block.custom.BeastlyBoarTuskPortalBlock;
import com.bladecoldsteel.invigorateddimensions.ultra.item.UltraDimItemGroup;
import com.bladecoldsteel.invigorateddimensions.ultra.item.UltraDimItems;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UltraDimBlocks {
    private static final ItemGroup TAB = UltraDimItemGroup.ULTRA_DIM_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<BeastlyBoarTuskPortalBlock> BEASTLY_BOAR_PORTAL = BlockHelper.register(
            "beastly_boar_tusk_portal", BLOCKS, UltraDimItems.ITEMS,
            BlockHelper.beastlyBoarPortalBlock(),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
