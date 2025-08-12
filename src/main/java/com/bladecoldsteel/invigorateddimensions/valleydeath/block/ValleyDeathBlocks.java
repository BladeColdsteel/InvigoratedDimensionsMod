package com.bladecoldsteel.invigorateddimensions.valleydeath.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.block.custom.GeneralizedPortalBlock;
import com.bladecoldsteel.invigorateddimensions.util.BlockHelper;
import com.bladecoldsteel.invigorateddimensions.valleydeath.item.ValleyDeathItemGroup;
import com.bladecoldsteel.invigorateddimensions.valleydeath.item.ValleyDeathItems;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.DarkTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ValleyDeathBlocks {
    private static final ItemGroup TAB = ValleyDeathItemGroup.DARKENED_RIFT_GROUP;
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    //Wooden Blocks
    public static final RegistryObject<Block> PLANKS = BlockHelper.register(
            "darkened_planks", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.woodenBlock(1.0F, 1, false),
            TAB
    );
    //Stone Blocks
    public static final RegistryObject<Block> STONE = BlockHelper.register(
            "darkened_stone", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> COBBLESTONE = BlockHelper.register(
            "darkened_cobblestone", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    public static final RegistryObject<Block> STONE_BRICKS = BlockHelper.register(
            "darkened_stone_bricks", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stoneBlock(4.0F, 1, true),
            TAB
    );
    //Slabs
    public static final RegistryObject<SlabBlock> WOODEN_SLAB = BlockHelper.register(
            "darkened_wooden_slab", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.slabBlock(Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_SLAB = BlockHelper.register(
            "darkened_stone_slab", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> COBBLESTONE_SLAB = BlockHelper.register(
            "darkened_cobblestone_slab", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<SlabBlock> STONE_BRICKS_SLAB = BlockHelper.register(
            "darkened_stone_bricks_slab", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.slabBlock(Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Stairs
    public static final RegistryObject<StairsBlock> WOODEN_STAIRS = BlockHelper.register(
            "darkened_wooden_stairs", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stairsBlock(PLANKS, Material.WOOD, 2.0F,  ToolType.AXE, 1, SoundType.WOOD, false),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_STAIRS = BlockHelper.register(
            "darkened_stone_stairs", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stairsBlock(STONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> COBBLESTONE_STAIRS = BlockHelper.register(
            "darkened_cobblestone_stairs", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stairsBlock(COBBLESTONE, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    public static final RegistryObject<StairsBlock> STONE_BRICKS_STAIRS = BlockHelper.register(
            "darkened_stone_bricks_stairs", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stairsBlock(STONE_BRICKS, Material.STONE, 4.0F, ToolType.PICKAXE, 1, SoundType.STONE, true),
            TAB
    );
    //Walls
    public static final RegistryObject<WallBlock> COBBLESTONE_WALL = BlockHelper.register(
            "darkened_cobblestone_wall", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    public static final RegistryObject<WallBlock> STONE_BRICKS_WALL = BlockHelper.register(
            "darkened_stone_bricks_wall", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.wallBlock(4.0F),
            TAB
    );
    //Logs
    public static final RegistryObject<RotatedPillarBlock> LOG = BlockHelper.register(
            "darkened_logs", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    public static final RegistryObject<RotatedPillarBlock> WOOD = BlockHelper.register(
            "darkened_wood", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.logBlock(2.0F),
            TAB
    );
    //Fences
    public static final RegistryObject<FenceBlock> FENCE = BlockHelper.register(
            "darkened_fence", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.fenceBlock(1.0F),
            TAB
    );
    //Fence Gates
    public static final RegistryObject<FenceGateBlock> FENCE_GATE = BlockHelper.register(
            "darkened_fence_gate", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.fenceGateBlock(1.0F),
            TAB
    );
    //Buttons
    public static final RegistryObject<WoodButtonBlock> WOODEN_BUTTON = BlockHelper.register(
            "darkened_wooden_button", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.woodButton(1.0F),
            TAB
    );
    public static final RegistryObject<StoneButtonBlock> STONE_BUTTON = BlockHelper.register(
            "darkened_stone_button", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stoneButton(2.0F),
            TAB
    );
    //Pressure Plates
    public static final RegistryObject<PressurePlateBlock> WOODEN_PRESSURE_PLATE = BlockHelper.register(
            "darkened_wooden_pressure_plate", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.woodPressurePlate(1.0F),
            TAB
    );
    public static final RegistryObject<PressurePlateBlock> STONE_PRESSURE_PLATE = BlockHelper.register(
            "darkened_stone_pressure_plate", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.stonePressurePlate(2.0F),
            TAB
    );
    //Sapling
    public static final RegistryObject<SaplingBlock> SAPLING = BlockHelper.register(
            "darkened_sapling", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.sapling(new DarkTree(), Blocks.OAK_SAPLING),
            TAB);
    //Portal Blocks
    public static final RegistryObject<GeneralizedPortalBlock> PORTAL = BlockHelper.register(
            "valley_of_death_portal", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.portalBlock(() -> ValleyDeathBlocks.PORTAL_FRAME.get(), () -> ValleyDeathBlocks.PORTAL.get(), ModDimensions.VALLEY_OF_DEATH, ModPointsOfInterest.VALLEY_DEATH_PORTAL),
            TAB
    );
    public static final RegistryObject<Block> PORTAL_FRAME = BlockHelper.register(
            "darkened_portal_frame", BLOCKS, ValleyDeathItems.ITEMS,
            BlockHelper.portalFrameBlock(4),
            TAB
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
