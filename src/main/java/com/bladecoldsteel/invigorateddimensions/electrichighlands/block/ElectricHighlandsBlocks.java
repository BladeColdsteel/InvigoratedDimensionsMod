package com.bladecoldsteel.invigorateddimensions.electrichighlands.block;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom.*;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItemGroup;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.world.gen.features.trees.ElectricTree;
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

public class ElectricHighlandsBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Block> ELECTRIC_HIGHLANDS_PORTAL = registerBlock("electric_highlands_portal",
            ElectricHighlandsPortalBlock::new);
    public static final RegistryObject<Block> ELECTRIC_HIGHLANDS_RIFT = registerBlock("electric_highlands_rift",
            ElectricHighlandsRiftBlock::new);

    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_SAPLING = registerBlock("electrically_charged_sapling",
            () -> new SaplingBlock(new ElectricTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_LOG = registerBlock("electrically_charged_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOOD = registerBlock("electrically_charged_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_WOOD)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_ELECTRICALLY_CHARGED_LOG = registerBlock("stripped_electrically_charged_logs",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_ELECTRICALLY_CHARGED_WOOD = registerBlock("stripped_electrically_charged_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> CRYSTALLIZED_LEAVES = registerBlock("crystallized_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)
                    .sound(SoundType.GLASS)
                    .harvestTool(ToolType.HOE)
                    .strength(0.2f)));

    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_PLANKS = registerBlock("electrically_charged_planks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOODEN_STAIRS = registerBlock("electrically_charged_wooden_stairs",
            () -> new StairsBlock(() -> ELECTRICALLY_CHARGED_PLANKS.get().defaultBlockState(),
                    AbstractBlock.Properties.copy(Blocks.OAK_STAIRS)
                            .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_FENCE = registerBlock("electrically_charged_fence",
            () -> new FenceBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_FENCE_GATE = registerBlock("electrically_charged_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE_GATE)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_DOOR = registerBlock("electrically_charged_door",
            () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOODEN_SLAB = registerBlock("electrically_charged_wooden_slab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.OAK_SLAB)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOODEN_BUTTON = registerBlock("electrically_charged_wooden_button",
            () -> new WoodButtonBlock(AbstractBlock.Properties.copy(Blocks.OAK_BUTTON)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE = registerBlock("electrically_charged_wooden_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR = registerBlock("electrically_charged_wooden_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)
                    .harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_SIGN = BLOCKS.register("electrically_charged_sign",
            () -> new ElectricHighlandsStandingSignBlock(AbstractBlock.Properties.copy(Blocks.OAK_SIGN)
                    .harvestTool(ToolType.AXE), ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_WALL_SIGN = BLOCKS.register("electrically_charged_wall_sign",
            () -> new ElectricHighlandsWallSignBlock(AbstractBlock.Properties.copy(Blocks.OAK_WALL_SIGN)
                    .harvestTool(ToolType.AXE), ElectricHighlandsWoodTypes.ELECTRICALLY_CHARGED));

    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE = registerBlock("electrically_charged_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(3f)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE = registerBlock("electrically_charged_stone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.copy(Blocks.STONE_PRESSURE_PLATE)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_BUTTON = registerBlock("electrically_charged_stone_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.copy(Blocks.STONE_BUTTON)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_SLABS = registerBlock("electrically_charged_stone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.STONE_SLAB)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(3f)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_STAIRS = registerBlock("electrically_charged_stone_stairs",
            () -> new StairsBlock(() -> ELECTRICALLY_CHARGED_STONE.get().defaultBlockState(),
                    AbstractBlock.Properties.copy(Blocks.STONE_STAIRS)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()
                            .strength(3f)
                            .harvestLevel(1)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_BRICKS = registerBlock("electrically_charged_stone_bricks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE_BRICKS)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(3.5f)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_BRICK_SLABS = registerBlock("electrically_charged_stone_brick_slab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.STONE_BRICK_SLAB)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()
                            .strength(3.5f)
                            .harvestLevel(1)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS = registerBlock("electrically_charged_stone_brick_stairs",
            () -> new StairsBlock(() -> ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(),
                    AbstractBlock.Properties.copy(Blocks.STONE_BRICK_STAIRS)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()
                            .strength(3.5f)
                            .harvestLevel(1)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_STONE_BRICK_WALL = registerBlock("electrically_charged_stone_brick_wall",
            () -> new WallBlock(AbstractBlock.Properties
                    .of(Material.STONE)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)
                    .harvestLevel(1)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS = registerBlock("electrically_charged_chiseled_stone_bricks",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.CHISELED_STONE_BRICKS)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(3.5f)));

    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_COBBLESTONE = registerBlock("electrically_charged_cobblestone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COBBLESTONE)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(2f)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS = registerBlock("electrically_charged_cobblestone_stairs",
            () -> new StairsBlock(() -> ELECTRICALLY_CHARGED_COBBLESTONE.get().defaultBlockState(),
                    AbstractBlock.Properties.copy(Blocks.COBBLESTONE_STAIRS)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()
                            .strength(2f)
                            .harvestLevel(1)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_COBBLESTONE_SLABS = registerBlock("electrically_charged_cobblestone_slab",
            () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.COBBLESTONE_SLAB)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(2f)));
    public static final RegistryObject<Block> ELECTRICALLY_CHARGED_COBBLESTONE_WALL = registerBlock("electrically_charged_cobblestone_wall",
            () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(2f, 6f)));

    public static final RegistryObject<Block> CHARGED_COAL_ORE = registerBlock("charged_coal_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHARGED_IRON_ORE = registerBlock("charged_iron_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHARGED_GOLD_ORE = registerBlock("charged_gold_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHARGED_DIAMOND_ORE = registerBlock("charged_diamond_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHARGED_GLOWSTONE_ORE = registerBlock("charged_glowstone_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHARGED_VOLTCRYST_ORE = registerBlock("charged_voltcryst_ore",
            () -> new ElectricOres(AbstractBlock.Properties.copy(ELECTRICALLY_CHARGED_STONE.get())
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HIGHLANDS_PORTAL_FRAME = registerBlock("highlandian_portal_frame",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)
                    .harvestLevel(2)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
                    .strength(10f)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ElectricHighlandsItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
