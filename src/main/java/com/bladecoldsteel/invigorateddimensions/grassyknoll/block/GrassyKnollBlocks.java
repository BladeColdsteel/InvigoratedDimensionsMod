package com.bladecoldsteel.invigorateddimensions.grassyknoll.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.item.GrassyKnollItemGroup;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.item.GrassyKnollItems;
import com.bladecoldsteel.invigorateddimensions.waterydepths.item.WateryDepthsItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.GrassTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class GrassyKnollBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> GRASSY_SAPLING = registerBlock("grassy_sapling",
            () -> new SaplingBlock(new GrassTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<RotatedPillarBlock> GRASSY_LOG = registerBlock("grassy_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)
                    .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> GRASSY_STONE = registerBlock("grassy_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)));
    public static final RegistryObject<Block> GRASSY_COBBLESTONE = registerBlock("grassy_cobblestone",
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
        GrassyKnollItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(GrassyKnollItemGroup.GRASSY_KNOLL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
