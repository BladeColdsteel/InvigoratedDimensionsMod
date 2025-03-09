package com.bladecoldsteel.invigorateddimensions.valleydeath.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.valleydeath.item.ValleyDeathItemGroup;
import com.bladecoldsteel.invigorateddimensions.valleydeath.item.ValleyDeathItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.DarkTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ValleyDeathBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> DARKENED_SAPLING = registerBlock("darkened_sapling",
            () -> new SaplingBlock(new DarkTree(), AbstractBlock.Properties.copy(Blocks.DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> DARKENED_LOG = registerBlock("darkened_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.JUNGLE_LOG)
                    .harvestTool(ToolType.AXE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ValleyDeathItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ValleyDeathItemGroup.DARKENED_RIFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
