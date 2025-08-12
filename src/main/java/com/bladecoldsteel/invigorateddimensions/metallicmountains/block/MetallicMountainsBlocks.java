package com.bladecoldsteel.invigorateddimensions.metallicmountains.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.item.MetallicMountainsItemGroup;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.item.MetallicMountainsItems;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.SteelTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MetallicMountainsBlocks {
    private static final ItemGroup TAB = MetallicMountainsItemGroup.STEEL_RIFT_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    //Wooden Blocks
    public static final RegistryObject<Block> PLANKS = BlockHelper.register(
            "metallic_planks", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.woodenBlock(1.0F, 1, false),
            TAB
    );
    //Stone Blocks
    public static final RegistryObject<Block> STONE = BlockHelper.register(
            "metallic_stone", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> COBBLESTONE = BlockHelper.register(
            "metallic_cobblestone", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> STONE_BRICKS = BlockHelper.register(
            "metallic_stone_bricks", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    //Slabs
    public static final RegistryObject<SlabBlock> WOODEN_SLAB = BlockHelper.register(
            "metallic_wooden_slab", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.slabBlock(Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_SLAB = BlockHelper.register(
            "metallic_stone_slab", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> COBBLESTONE_SLAB = BlockHelper.register(
            "metallic_cobblestone_slab", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_BRICKS_SLAB = BlockHelper.register(
            "metallic_stone_bricks_slab", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Stairs
    public static final RegistryObject<StairsBlock> WOODEN_STAIRS = BlockHelper.register(
            "metallic_wooden_stairs", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stairsBlock(PLANKS, Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_STAIRS = BlockHelper.register(
            "metallic_stone_stairs", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stairsBlock(STONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> COBBLESTONE_STAIRS = BlockHelper.register(
            "metallic_cobblestone_stairs", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stairsBlock(COBBLESTONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_BRICKS_STAIRS = BlockHelper.register(
            "metallic_stone_bricks_stairs", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stairsBlock(STONE_BRICKS, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Walls
    public static final RegistryObject<WallBlock> COBBLESTONE_WALL = BlockHelper.register(
            "metallic_cobblestone_wall", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    public static final RegistryObject<WallBlock> STONE_BRICKS_WALL = BlockHelper.register(
            "metallic_stone_bricks_wall", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    //Logs
    public static final RegistryObject<RotatedPillarBlock> LOG = BlockHelper.register(
            "metallic_logs", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    public static final RegistryObject<RotatedPillarBlock> WOOD = BlockHelper.register(
            "metallic_wood", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    //Fences
    public static final RegistryObject<FenceBlock> FENCE = BlockHelper.register(
            "metallic_fence", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.fenceBlock(1.0F),
            TAB
    );
    //Fence Gates
    public static final RegistryObject<FenceGateBlock> FENCE_GATE = BlockHelper.register(
            "metallic_fence_gate", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.fenceGateBlock(1.0F),
            TAB
    );
    //Buttons
    public static final RegistryObject<WoodButtonBlock> WOODEN_BUTTON = BlockHelper.register(
            "metallic_wooden_button", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.woodButton(1.0F),
            TAB
    );
    public static final RegistryObject<StoneButtonBlock> STONE_BUTTON = BlockHelper.register(
            "metallic_stone_button", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stoneButton(2.0F),
            TAB
    );
    //Pressure Plates
    public static final RegistryObject<PressurePlateBlock> WOODEN_PRESSURE_PLATE = BlockHelper.register(
            "metallic_wooden_pressure_plate", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.woodPressurePlate(1.0F),
            TAB
    );
    public static final RegistryObject<PressurePlateBlock> STONE_PRESSURE_PLATE = BlockHelper.register(
            "metallic_stone_pressure_plate", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.stonePressurePlate(2.0F),
            TAB
    );
    //Sapling
    public static final RegistryObject<SaplingBlock> SAPLING = BlockHelper.register(
            "metallic_sapling", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.sapling(new SteelTree(), Blocks.OAK_SAPLING),
            TAB);
    //Portal Blocks
    public static final RegistryObject<GeneralizedPortalBlock> PORTAL = BlockHelper.register(
            "metallic_mountains_portal", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.portalBlock(() -> MetallicMountainsBlocks.PORTAL_FRAME.get(), () -> MetallicMountainsBlocks.PORTAL.get(), ModDimensions.METALLIC_MOUNTAINS, ModPointsOfInterest.METALLIC_MOUNTAINS_PORTAL),
            TAB
    );
    public static final RegistryObject<Block> PORTAL_FRAME = BlockHelper.register(
            "metallic_portal_frame", BLOCKS, MetallicMountainsItems.ITEMS,
            BlockHelper.portalFrameBlock(4),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
