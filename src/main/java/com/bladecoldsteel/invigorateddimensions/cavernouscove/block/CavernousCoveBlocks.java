package com.bladecoldsteel.invigorateddimensions.cavernouscove.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.item.CavernousCoveItemGroup;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.item.CavernousCoveItems;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CavernousCoveBlocks {
    private static final ItemGroup TAB = CavernousCoveItemGroup.ROCKY_RIFT_GROUP;

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);
    //Wooden Blocks
    public static final RegistryObject<Block> PLANKS = BlockHelper.register(
            "rocky_planks", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.woodenBlock(1.0F, 1, false),
            TAB
    );
    //Stone Blocks
    public static final RegistryObject<Block> STONE = BlockHelper.register(
            "rocky_stone", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> COBBLESTONE = BlockHelper.register(
            "rocky_cobblestone", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> STONE_BRICKS = BlockHelper.register(
            "rocky_stone_bricks", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    //Slabs
    public static final RegistryObject<SlabBlock> WOODEN_SLAB = BlockHelper.register(
            "rocky_wooden_slab", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.slabBlock(Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_SLAB = BlockHelper.register(
            "rocky_stone_slab", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> COBBLESTONE_SLAB = BlockHelper.register(
            "rocky_cobblestone_slab", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_BRICKS_SLAB = BlockHelper.register(
            "rocky_stone_bricks_slab", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Stairs
    public static final RegistryObject<StairsBlock> WOODEN_STAIRS = BlockHelper.register(
            "rocky_wooden_stairs", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stairsBlock(PLANKS, Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_STAIRS = BlockHelper.register(
            "rocky_stone_stairs", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stairsBlock(STONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> COBBLESTONE_STAIRS = BlockHelper.register(
            "rocky_cobblestone_stairs", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stairsBlock(COBBLESTONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_BRICKS_STAIRS = BlockHelper.register(
            "rocky_stone_bricks_stairs", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stairsBlock(STONE_BRICKS, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Walls
    public static final RegistryObject<WallBlock> COBBLESTONE_WALL = BlockHelper.register(
            "rocky_cobblestone_wall", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    public static final RegistryObject<WallBlock> STONE_BRICKS_WALL = BlockHelper.register(
            "rocky_stone_bricks_wall", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    //Logs
    public static final RegistryObject<RotatedPillarBlock> LOG = BlockHelper.register(
            "rocky_logs", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    public static final RegistryObject<RotatedPillarBlock> WOOD = BlockHelper.register(
            "rocky_wood", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    //Fences
    public static final RegistryObject<FenceBlock> FENCE = BlockHelper.register(
            "rocky_fence", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.fenceBlock(1.0F),
            TAB
    );
    //Fence Gates
    public static final RegistryObject<FenceGateBlock> FENCE_GATE = BlockHelper.register(
            "rocky_fence_gate", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.fenceGateBlock(1.0F),
            TAB
    );
    //Buttons
    public static final RegistryObject<WoodButtonBlock> WOODEN_BUTTON = BlockHelper.register(
            "rocky_wooden_button", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.woodButton(1.0F),
            TAB
    );
    public static final RegistryObject<StoneButtonBlock> STONE_BUTTON = BlockHelper.register(
            "rocky_stone_button", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stoneButton(2.0F),
            TAB
    );
    //Pressure Plates
    public static final RegistryObject<PressurePlateBlock> WOODEN_PRESSURE_PLATE = BlockHelper.register(
            "rocky_wooden_pressure_plate", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.woodPressurePlate(1.0F),
            TAB
    );
    public static final RegistryObject<PressurePlateBlock> STONE_PRESSURE_PLATE = BlockHelper.register(
            "rocky_stone_pressure_plate", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.stonePressurePlate(2.0F),
            TAB
    );
    //Portal Blocks
    public static final RegistryObject<GeneralizedPortalBlock> PORTAL = BlockHelper.register(
            "cavernous_cove_portal", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.portalBlock(() -> CavernousCoveBlocks.PORTAL_FRAME.get(), () -> CavernousCoveBlocks.PORTAL.get(), ModDimensions.CAVERNOUS_COVE, ModPointsOfInterest.CAVERNOUS_COVE_PORTAL),
            TAB
    );
    public static final RegistryObject<Block> PORTAL_FRAME = BlockHelper.register(
            "rocky_portal_frame", BLOCKS, CavernousCoveItems.ITEMS,
            BlockHelper.portalFrameBlock(4),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
