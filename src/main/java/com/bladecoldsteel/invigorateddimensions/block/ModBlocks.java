package com.bladecoldsteel.invigorateddimensions.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.block.custom.AltarBlock;
import com.bladecoldsteel.invigorateddimensions.block.custom.trees.ElectricallyChargedTree;
import com.bladecoldsteel.invigorateddimensions.item.ModItemGroup;
import com.bladecoldsteel.invigorateddimensions.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);


    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_LOG = registerBlock("electrically_charged_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOOD = registerBlock("electrically_charged_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ELECTRICALLY_CHARGED_LOG = registerBlock("stripped_electrically_charged_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ELECTRICALLY_CHARGED_WOOD = registerBlock("stripped_electrically_charged_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_PLANKS = registerBlock("electrically_charged_planks",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CRYSTALLIZED_LEAVES = registerBlock("crystallized_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)
                    .randomTicks()
                    .sound(SoundType.GLASS)
                    .air()));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_SAPLING = registerBlock("electrically_charged_sapling",
            () -> new SaplingBlock(new ElectricallyChargedTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> ELECTRIC_ALTAR = registerBlock("electric_altar",
            () -> new AltarBlock(AbstractBlock.Properties.of(Material.METAL)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.INVIGORATED_DIMENSIONS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
