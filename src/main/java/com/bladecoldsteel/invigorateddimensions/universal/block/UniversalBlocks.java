package com.bladecoldsteel.invigorateddimensions.universal.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.CrystallizedLeavesBlock;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.EnergySinkBlock;
import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItemGroup;
import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class UniversalBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> CRYSTALLIZED_LEAVES = registerBlock("crystallized_leaves",
            CrystallizedLeavesBlock::new);

    public static final RegistryObject<Block> ENERGY_SINK = registerBlock("energy_sink",
            () -> new EnergySinkBlock(AbstractBlock.Properties.of(Material.METAL)
                    .noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        UniversalItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
