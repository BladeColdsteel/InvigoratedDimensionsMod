package com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.item.GhastlyMarshItemGroup;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.item.GhastlyMarshItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.GhostTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class GhastlyMarshBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> SPOOKY_SAPLING = registerBlock("spooky_sapling",
            () -> new SaplingBlock(new GhostTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<RotatedPillarBlock> SPOOKY_LOG = registerBlock("spooky_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.JUNGLE_LOG)
                    .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> SPOOKY_STONE = registerBlock("spooky_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)));
    public static final RegistryObject<Block> SPOOKY_COBBLESTONE = registerBlock("spooky_cobblestone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COBBLESTONE)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(2f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        GhastlyMarshItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(GhastlyMarshItemGroup.SPOOKY_RIFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
