package com.bladecoldsteel.invigorateddimensions.terranata.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.item.TerraNataItemGroup;
import com.bladecoldsteel.invigorateddimensions.terranata.item.TerraNataItems;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.GroundTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TerraNataBlocks {
    private static final ItemGroup TAB = TerraNataItemGroup.GROUND_RIFT_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    //Wooden Blocks
    public static final RegistryObject<Block> PLANKS = BlockHelper.register(
            "grounded_planks", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.woodenBlock(1.0F, 1, false),
            TAB
    );
    //Stone Blocks
    public static final RegistryObject<Block> STONE = BlockHelper.register(
            "grounded_stone", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> COBBLESTONE = BlockHelper.register(
            "grounded_cobblestone", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> STONE_BRICKS = BlockHelper.register(
            "grounded_stone_bricks", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    //Slabs
    public static final RegistryObject<SlabBlock> WOODEN_SLAB = BlockHelper.register(
            "grounded_wooden_slab", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.slabBlock(Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_SLAB = BlockHelper.register(
            "grounded_stone_slab", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> COBBLESTONE_SLAB = BlockHelper.register(
            "grounded_cobblestone_slab", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_BRICKS_SLAB = BlockHelper.register(
            "grounded_stone_bricks_slab", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Stairs
    public static final RegistryObject<StairsBlock> WOODEN_STAIRS = BlockHelper.register(
            "grounded_wooden_stairs", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stairsBlock(PLANKS, Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_STAIRS = BlockHelper.register(
            "grounded_stone_stairs", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stairsBlock(STONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> COBBLESTONE_STAIRS = BlockHelper.register(
            "grounded_cobblestone_stairs", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stairsBlock(COBBLESTONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_BRICKS_STAIRS = BlockHelper.register(
            "grounded_stone_bricks_stairs", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stairsBlock(STONE_BRICKS, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Walls
    public static final RegistryObject<WallBlock> COBBLESTONE_WALL = BlockHelper.register(
            "grounded_cobblestone_wall", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    public static final RegistryObject<WallBlock> STONE_BRICKS_WALL = BlockHelper.register(
            "grounded_stone_bricks_wall", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    //Logs
    public static final RegistryObject<RotatedPillarBlock> LOG = BlockHelper.register(
            "grounded_logs", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    public static final RegistryObject<RotatedPillarBlock> WOOD = BlockHelper.register(
            "grounded_wood", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    //Fences
    public static final RegistryObject<FenceBlock> FENCE = BlockHelper.register(
            "grounded_fence", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.fenceBlock(1.0F),
            TAB
    );
    //Fence Gates
    public static final RegistryObject<FenceGateBlock> FENCE_GATE = BlockHelper.register(
            "grounded_fence_gate", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.fenceGateBlock(1.0F),
            TAB
    );
    //Buttons
    public static final RegistryObject<WoodButtonBlock> WOODEN_BUTTON = BlockHelper.register(
            "grounded_wooden_button", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.woodButton(1.0F),
            TAB
    );
    public static final RegistryObject<StoneButtonBlock> STONE_BUTTON = BlockHelper.register(
            "grounded_stone_button", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stoneButton(2.0F),
            TAB
    );
    //Pressure Plates
    public static final RegistryObject<PressurePlateBlock> WOODEN_PRESSURE_PLATE = BlockHelper.register(
            "grounded_wooden_pressure_plate", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.woodPressurePlate(1.0F),
            TAB
    );
    public static final RegistryObject<PressurePlateBlock> STONE_PRESSURE_PLATE = BlockHelper.register(
            "grounded_stone_pressure_plate", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.stonePressurePlate(2.0F),
            TAB
    );
    //Sapling
    public static final RegistryObject<SaplingBlock> SAPLING = BlockHelper.register(
            "grounded_sapling", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.sapling(new GroundTree(), Blocks.OAK_SAPLING),
            TAB);
    //Portal Blocks
    public static final RegistryObject<GeneralizedPortalBlock> PORTAL = BlockHelper.register(
            "terra_nata_portal", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.portalBlock(() -> TerraNataBlocks.PORTAL_FRAME.get(), () -> TerraNataBlocks.PORTAL.get(), ModDimensions.TERRA_NATA, ModPointsOfInterest.TERRA_NATA_PORTAL),
            TAB
    );
    public static final RegistryObject<Block> PORTAL_FRAME = BlockHelper.register(
            "grounded_portal_frame", BLOCKS, TerraNataItems.ITEMS,
            BlockHelper.portalFrameBlock(4),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
