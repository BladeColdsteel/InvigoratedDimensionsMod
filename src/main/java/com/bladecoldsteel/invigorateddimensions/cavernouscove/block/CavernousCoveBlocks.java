package com.bladecoldsteel.invigorateddimensions.cavernouscove.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.item.CavernousCoveItemGroup;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.item.CavernousCoveItems;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.item.CorrosiveFieldsItemGroup;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.item.CorrosiveFieldsItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.PoisonTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CavernousCoveBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<RotatedPillarBlock> ROCKY_LOG = registerBlock("rocky_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.JUNGLE_LOG)
                    .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> ROCKY_STONE = registerBlock("rocky_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)));
    public static final RegistryObject<Block> ROCKY_COBBLESTONE = registerBlock("rocky_cobblestone",
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
        CavernousCoveItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CavernousCoveItemGroup.ROCKY_RIFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
