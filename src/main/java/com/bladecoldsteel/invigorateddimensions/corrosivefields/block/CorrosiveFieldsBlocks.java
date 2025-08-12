package com.bladecoldsteel.invigorateddimensions.corrosivefields.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.item.CorrosiveFieldsItemGroup;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.item.CorrosiveFieldsItems;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.PoisonTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CorrosiveFieldsBlocks {
    private static final ItemGroup TAB = CorrosiveFieldsItemGroup.CORROSIVE_RIFT_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    //Wooden Blocks
    public static final RegistryObject<Block> PLANKS = BlockHelper.register(
            "corrosive_planks", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.woodenBlock(1.0F, 1, false),
            TAB
    );
    //Stone Blocks
    public static final RegistryObject<Block> STONE = BlockHelper.register(
            "corrosive_stone", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> COBBLESTONE = BlockHelper.register(
            "corrosive_cobblestone", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> STONE_BRICKS = BlockHelper.register(
            "corrosive_stone_bricks", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    //Slabs
    public static final RegistryObject<SlabBlock> WOODEN_SLAB = BlockHelper.register(
            "corrosive_wooden_slab", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.slabBlock(Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_SLAB = BlockHelper.register(
            "corrosive_stone_slab", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> COBBLESTONE_SLAB = BlockHelper.register(
            "corrosive_cobblestone_slab", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_BRICKS_SLAB = BlockHelper.register(
            "corrosive_stone_bricks_slab", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Stairs
    public static final RegistryObject<StairsBlock> WOODEN_STAIRS = BlockHelper.register(
            "corrosive_wooden_stairs", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stairsBlock(PLANKS, Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_STAIRS = BlockHelper.register(
            "corrosive_stone_stairs", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stairsBlock(STONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> COBBLESTONE_STAIRS = BlockHelper.register(
            "corrosive_cobblestone_stairs", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stairsBlock(COBBLESTONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_BRICKS_STAIRS = BlockHelper.register(
            "corrosive_stone_bricks_stairs", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stairsBlock(STONE_BRICKS, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Walls
    public static final RegistryObject<WallBlock> COBBLESTONE_WALL = BlockHelper.register(
            "corrosive_cobblestone_wall", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    public static final RegistryObject<WallBlock> STONE_BRICKS_WALL = BlockHelper.register(
            "corrosive_stone_bricks_wall", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    //Logs
    public static final RegistryObject<RotatedPillarBlock> LOG = BlockHelper.register(
            "corrosive_logs", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    public static final RegistryObject<RotatedPillarBlock> WOOD = BlockHelper.register(
            "corrosive_wood", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    //Fences
    public static final RegistryObject<FenceBlock> FENCE = BlockHelper.register(
            "corrosive_fence", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.fenceBlock(1.0F),
            TAB
    );
    //Fence Gates
    public static final RegistryObject<FenceGateBlock> FENCE_GATE = BlockHelper.register(
            "corrosive_fence_gate", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.fenceGateBlock(1.0F),
            TAB
    );
    //Buttons
    public static final RegistryObject<WoodButtonBlock> WOODEN_BUTTON = BlockHelper.register(
            "corrosive_wooden_button", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.woodButton(1.0F),
            TAB
    );
    public static final RegistryObject<StoneButtonBlock> STONE_BUTTON = BlockHelper.register(
            "corrosive_stone_button", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stoneButton(2.0F),
            TAB
    );
    //Pressure Plates
    public static final RegistryObject<PressurePlateBlock> WOODEN_PRESSURE_PLATE = BlockHelper.register(
            "corrosive_wooden_pressure_plate", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.woodPressurePlate(1.0F),
            TAB
    );
    public static final RegistryObject<PressurePlateBlock> STONE_PRESSURE_PLATE = BlockHelper.register(
            "corrosive_stone_pressure_plate", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.stonePressurePlate(2.0F),
            TAB
    );
    //Sapling
    public static final RegistryObject<SaplingBlock> SAPLING = BlockHelper.register(
            "corrosive_sapling", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.sapling(new PoisonTree(), Blocks.OAK_SAPLING),
            TAB);
    //Portal Blocks
    public static final RegistryObject<GeneralizedPortalBlock> PORTAL = BlockHelper.register(
            "corrosive_fields_portal", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.portalBlock(() -> CorrosiveFieldsBlocks.PORTAL_FRAME.get(), () -> CorrosiveFieldsBlocks.PORTAL.get(), ModDimensions.CORROSIVE_FIELDS, ModPointsOfInterest.CORROSIVE_FIELDS_PORTAL),
            TAB
    );
    public static final RegistryObject<Block> PORTAL_FRAME = BlockHelper.register(
            "corrosive_portal_frame", BLOCKS, CorrosiveFieldsItems.ITEMS,
            BlockHelper.portalFrameBlock(4),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
