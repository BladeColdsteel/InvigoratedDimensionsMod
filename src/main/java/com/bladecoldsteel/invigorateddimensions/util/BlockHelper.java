package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.custom.FloatingSaplingBlock;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.FlyingTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockHelper {
    public static <T extends Block> RegistryObject<T> register(String name, DeferredRegister<Block> blockRegistry, DeferredRegister<Item> itemRegistry, Supplier<T> blockSupplier, ItemGroup tab) {
        RegistryObject<T> block = blockRegistry.register(name, blockSupplier);
        itemRegistry.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
        return block;
    }

    public static Supplier<Block> woodenBlock(float strength, int harvestLevel, boolean needsTool) {
        return () -> new Block(buildProperties(Material.WOOD, strength, strength, ToolType.AXE, harvestLevel, SoundType.WOOD, needsTool));
    }

    public static Supplier<Block> stoneBlock(float strength, int harvestLevel, boolean needsTool) {
        return () -> new Block(buildProperties(Material.STONE, strength, strength, ToolType.PICKAXE, harvestLevel, SoundType.STONE, needsTool));
    }

    public static Supplier<SlabBlock> slabBlock(Material material, float strength, ToolType tool, int harvestLevel, SoundType sound, boolean needsTool) {
        return () -> new SlabBlock(buildProperties(material, strength, strength, tool, harvestLevel, sound, needsTool));
    }

    public static Supplier<StairsBlock> stairsBlock(RegistryObject<? extends Block> baseBlock, Material material, float strength, ToolType tool, int harvestLevel, SoundType sound, boolean needsTool) {
        return () -> new StairsBlock(baseBlock.get().defaultBlockState(), buildProperties(material, strength, strength, tool, harvestLevel, sound, needsTool));
    }

    public static Supplier<WallBlock> wallBlock(float strength) {
        return () -> new WallBlock(buildProperties(Material.STONE, strength, strength, ToolType.PICKAXE, 0, SoundType.STONE, true));
    }

    public static Supplier<RotatedPillarBlock> logBlock(float strength) {
        return () -> new RotatedPillarBlock(buildProperties(Material.WOOD, strength, strength, ToolType.AXE, 0, SoundType.WOOD, false));
    }

    public static Supplier<FenceBlock> fenceBlock(float strength) {
        return () -> new FenceBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).strength(strength));
    }

    public static Supplier<FenceGateBlock> fenceGateBlock(float strength) {
        return () -> new FenceGateBlock(buildProperties(Material.WOOD, strength, strength, ToolType.AXE, 0, SoundType.WOOD, false));
    }

    public static Supplier<WoodButtonBlock> woodButton(float strength) {
        return () -> new WoodButtonBlock(buildProperties(Material.WOOD, strength, strength, ToolType.AXE, 0, SoundType.WOOD, false));
    }

    public static Supplier<StoneButtonBlock> stoneButton(float strength) {
        return () -> new StoneButtonBlock(buildProperties(Material.STONE, strength, strength, ToolType.PICKAXE, 0, SoundType.STONE, true));
    }

    public static Supplier<PressurePlateBlock> woodPressurePlate(float strength) {
        return () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, buildProperties(Material.WOOD, strength, strength, ToolType.AXE, 0, SoundType.WOOD, false));
    }

    public static Supplier<PressurePlateBlock> stonePressurePlate(float strength) {
        return () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, buildProperties(Material.STONE, strength, strength, ToolType.PICKAXE, 0, SoundType.STONE, true));
    }

    public static Supplier<SaplingBlock> sapling(Tree tree, Block copySapling) {
        return () -> new SaplingBlock(tree, AbstractBlock.Properties.copy(copySapling));
    }

    public static Supplier<FloatingSaplingBlock> floatingSapling(Block copySapling) {
        return () -> new FloatingSaplingBlock(new FlyingTree(), AbstractBlock.Properties.copy(copySapling));
    }

    private static AbstractBlock.Properties buildProperties(Material material, float hardness, float resistance, ToolType tool, int harvestLevel, SoundType sound, boolean needsTool) {
        AbstractBlock.Properties props = AbstractBlock.Properties.of(material)
                .strength(hardness, resistance)
                .sound(sound)
                .harvestTool(tool)
                .harvestLevel(harvestLevel);

        if (needsTool) props = props.requiresCorrectToolForDrops();

        return props;
    }
}
