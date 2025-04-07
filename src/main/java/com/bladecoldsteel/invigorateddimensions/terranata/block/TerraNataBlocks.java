package com.bladecoldsteel.invigorateddimensions.terranata.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.item.TerraNataItemGroup;
import com.bladecoldsteel.invigorateddimensions.terranata.item.TerraNataItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.GroundTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TerraNataBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> GROUNDED_SAPLING = registerBlock("grounded_sapling",
            () -> new SaplingBlock(new GroundTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GROUNDED_LOG = registerBlock("grounded_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)
                    .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> GROUNDED_STONE = registerBlock("grounded_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)));
    public static final RegistryObject<Block> GROUNDED_COBBLESTONE = registerBlock("grounded_cobblestone",
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
        TerraNataItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(TerraNataItemGroup.GROUND_RIFT_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
