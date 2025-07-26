package com.bladecoldsteel.invigorateddimensions.universal.datageneration;

import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider.IDBlockstateProvider;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class IDBlockStatesAndModels extends IDBlockstateProvider {
    public IDBlockStatesAndModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Invigorated Dimensions Block and Model States";
    }

    @Override
    protected void registerStatesAndModels() {
        //Torch

        //Planks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        block(CavernousCoveBlocks.PLANKS);
        block(HeavenlyRealmBlocks.PLANKS);
        block(CorrosiveFieldsBlocks.PLANKS);
        block(DeepTundraBlocks.PLANKS);
        block(DraconicRiftBlocks.PLANKS);
        block(DreamlandBlocks.PLANKS);
        //Logs
        log(InsectoidParadisioBlocks.BUGGED_LOG, "bugged_logs");
        log(ValleyDeathBlocks.DARKENED_LOG, "darkened_logs");
        log(DraconicRiftBlocks.LOG, "draconic_logs");
        log(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG, "electrically_charged_logs");
        log(FeywildExpanseBlocks.FEYAN_LOG, "feyan_logs");
        log(InfiniteDungeonBlocks.TOUGH_LOG, "tough_logs");
        log(EmberwildsBlocks.EMBERED_LOG, "embered_logs");
        log(HeavenlyRealmBlocks.LOG, "floating_logs");
        log(GhastlyMarshBlocks.SPOOKY_LOG, "spooky_logs");
        log(GrassyKnollBlocks.GRASSY_LOG, "grassy_logs");
        log(TerraNataBlocks.GROUNDED_LOG, "grounded_logs");
        log(DeepTundraBlocks.LOG, "icey_logs");
        log(CorrosiveFieldsBlocks.LOG, "corrosive_logs");
        log(DreamlandBlocks.LOG, "psychedelic_logs");
        log(CavernousCoveBlocks.LOG, "rocky_logs");
        log(MetallicMountainsBlocks.METALLIC_LOG, "metallic_logs");
        log(WateryDepthsBlocks.WATERY_LOG, "watery_logs");
        //Stripped Logs
        log(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG, "stripped_electrically_charged_logs");
        //Wood
        uniformLog(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD, "electrically_charged_logs_side");
        uniformLog(CavernousCoveBlocks.WOOD, "rocky_logs_side");
        uniformLog(HeavenlyRealmBlocks.WOOD, "floating_logs_side");
        uniformLog(CorrosiveFieldsBlocks.WOOD, "corrosive_logs_side");
        uniformLog(DeepTundraBlocks.WOOD, "icey_logs_side");
        uniformLog(DraconicRiftBlocks.WOOD, "draconic_logs_side");
        uniformLog(DreamlandBlocks.WOOD, "psychedelic_logs_side");
        //Stripped Wood
        uniformLog(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD, "stripped_electrically_charged_logs_side");
        //Stone
        block(InsectoidParadisioBlocks.BUGGED_STONE);
        block(ValleyDeathBlocks.DARKENED_STONE);
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        block(FeywildExpanseBlocks.FEYAN_STONE);
        block(InfiniteDungeonBlocks.TOUGH_STONE);
        block(HeavenlyRealmBlocks.STONE);
        block(GhastlyMarshBlocks.SPOOKY_STONE);
        block(GrassyKnollBlocks.GRASSY_STONE);
        block(TerraNataBlocks.GROUNDED_STONE);
        block(DeepTundraBlocks.STONE);
        block(CorrosiveFieldsBlocks.STONE);
        block(DreamlandBlocks.STONE);
        block(CavernousCoveBlocks.STONE);
        block(MetallicMountainsBlocks.METALLIC_STONE);
        block(WateryDepthsBlocks.WATERY_STONE);
        //Cobblestone
        block(InsectoidParadisioBlocks.BUGGED_COBBLESTONE);
        block(ValleyDeathBlocks.DARKENED_COBBLESTONE);
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        block(FeywildExpanseBlocks.FEYAN_COBBLESTONE);
        block(InfiniteDungeonBlocks.TOUGH_COBBLESTONE);
        block(HeavenlyRealmBlocks.COBBLESTONE);
        block(GhastlyMarshBlocks.SPOOKY_COBBLESTONE);
        block(GrassyKnollBlocks.GRASSY_COBBLESTONE);
        block(TerraNataBlocks.GROUNDED_COBBLESTONE);
        block(DeepTundraBlocks.COBBLESTONE);
        block(CorrosiveFieldsBlocks.COBBLESTONE);
        block(DreamlandBlocks.COBBLESTONE);
        block(CavernousCoveBlocks.COBBLESTONE);
        block(MetallicMountainsBlocks.METALLIC_COBBLESTONE);
        block(WateryDepthsBlocks.WATERY_COBBLESTONE);
        //Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        block(CavernousCoveBlocks.STONE_BRICKS);
        block(HeavenlyRealmBlocks.STONE_BRICKS);
        block(CorrosiveFieldsBlocks.STONE_BRICKS);
        block(DeepTundraBlocks.STONE_BRICKS);
        block(DreamlandBlocks.STONE_BRICKS);
        //Chiseled Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
        //Walls
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_WALL.get(), modLoc("block/electrically_charged_cobblestone"));
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_WALL.get(), modLoc("block/electrically_charged_stone_bricks"));
        wallBlock(CavernousCoveBlocks.COBBLESTONE_WALL.get(), modLoc("block/rocky_cobblestone"));
        wallBlock(CavernousCoveBlocks.STONE_BRICKS_WALL.get(), modLoc("block/rocky_stone_bricks"));
        wallBlock(HeavenlyRealmBlocks.COBBLESTONE_WALL.get(), modLoc("block/floating_cobblestone"));
        wallBlock(HeavenlyRealmBlocks.STONE_BRICKS_WALL.get(), modLoc("block/floating_stone_bricks"));
        wallBlock(CorrosiveFieldsBlocks.COBBLESTONE_WALL.get(), modLoc("block/corrosive_cobblestone"));
        wallBlock(CorrosiveFieldsBlocks.STONE_BRICKS_WALL.get(), modLoc("block/corrosive_stone_bricks"));
        wallBlock(DeepTundraBlocks.COBBLESTONE_WALL.get(), modLoc("block/icey_cobblestone"));
        wallBlock(DeepTundraBlocks.STONE_BRICKS_WALL.get(), modLoc("block/icey_stone_bricks"));
        wallBlock(DreamlandBlocks.COBBLESTONE_WALL.get(), modLoc("block/psychedelic_cobblestone"));
        wallBlock(DreamlandBlocks.STONE_BRICKS_WALL.get(), modLoc("block/psychedelic_stone_bricks"));
        //Fences
        fence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        fence(CavernousCoveBlocks.FENCE, CavernousCoveBlocks.PLANKS);
        fence(HeavenlyRealmBlocks.FENCE, HeavenlyRealmBlocks.PLANKS);
        fence(CorrosiveFieldsBlocks.FENCE, CorrosiveFieldsBlocks.PLANKS);
        fence(DeepTundraBlocks.FENCE, DeepTundraBlocks.PLANKS);
        fence(DraconicRiftBlocks.FENCE, DraconicRiftBlocks.PLANKS);
        fence(DreamlandBlocks.FENCE, DreamlandBlocks.PLANKS);
        //Fence Gates
        fenceGateBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE.get(), modLoc("block/electrically_charged_planks"));
        fenceGateBlock(CavernousCoveBlocks.FENCE_GATE.get(), modLoc("block/rocky_planks"));
        fenceGateBlock(HeavenlyRealmBlocks.FENCE_GATE.get(), modLoc("block/floating_planks"));
        fenceGateBlock(CorrosiveFieldsBlocks.FENCE_GATE.get(), modLoc("block/corrosive_planks"));
        fenceGateBlock(DeepTundraBlocks.FENCE_GATE.get(), modLoc("block/icey_planks"));
        fenceGateBlock(DraconicRiftBlocks.FENCE_GATE.get(), modLoc("block/draconic_planks"));
        fenceGateBlock(DreamlandBlocks.FENCE_GATE.get(), modLoc("block/psychedelic_planks"));
        //Ores
        block(ElectricHighlandsBlocks.CHARGED_COAL_ORE);
        block(ElectricHighlandsBlocks.CHARGED_IRON_ORE);
        block(ElectricHighlandsBlocks.CHARGED_GOLD_ORE);
        block(ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE);
        block(ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE);
        block(ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE);
        //Stairs
        stairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        stairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        stairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        stairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        stairs(CavernousCoveBlocks.WOODEN_STAIRS, CavernousCoveBlocks.PLANKS);
        stairs(CavernousCoveBlocks.COBBLESTONE_STAIRS, CavernousCoveBlocks.COBBLESTONE);
        stairs(CavernousCoveBlocks.STONE_STAIRS, CavernousCoveBlocks.STONE);
        stairs(CavernousCoveBlocks.STONE_BRICKS_STAIRS, CavernousCoveBlocks.STONE_BRICKS);
        stairs(HeavenlyRealmBlocks.WOODEN_STAIRS, HeavenlyRealmBlocks.PLANKS);
        stairs(HeavenlyRealmBlocks.COBBLESTONE_STAIRS, HeavenlyRealmBlocks.COBBLESTONE);
        stairs(HeavenlyRealmBlocks.STONE_STAIRS, HeavenlyRealmBlocks.STONE);
        stairs(HeavenlyRealmBlocks.STONE_BRICKS_STAIRS, HeavenlyRealmBlocks.STONE_BRICKS);
        stairs(CorrosiveFieldsBlocks.WOODEN_STAIRS, CorrosiveFieldsBlocks.PLANKS);
        stairs(CorrosiveFieldsBlocks.COBBLESTONE_STAIRS, CorrosiveFieldsBlocks.COBBLESTONE);
        stairs(CorrosiveFieldsBlocks.STONE_STAIRS, CorrosiveFieldsBlocks.STONE);
        stairs(CorrosiveFieldsBlocks.STONE_BRICKS_STAIRS, CorrosiveFieldsBlocks.STONE_BRICKS);
        stairs(DeepTundraBlocks.WOODEN_STAIRS, DeepTundraBlocks.PLANKS);
        stairs(DeepTundraBlocks.COBBLESTONE_STAIRS, DeepTundraBlocks.COBBLESTONE);
        stairs(DeepTundraBlocks.STONE_STAIRS, DeepTundraBlocks.STONE);
        stairs(DeepTundraBlocks.STONE_BRICKS_STAIRS, DeepTundraBlocks.STONE_BRICKS);
        stairs(DraconicRiftBlocks.WOODEN_STAIRS, DraconicRiftBlocks.PLANKS);
        stairs(DreamlandBlocks.WOODEN_STAIRS, DreamlandBlocks.PLANKS);
        stairs(DreamlandBlocks.COBBLESTONE_STAIRS, DreamlandBlocks.COBBLESTONE);
        stairs(DreamlandBlocks.STONE_STAIRS, DreamlandBlocks.STONE);
        stairs(DreamlandBlocks.STONE_BRICKS_STAIRS, DreamlandBlocks.STONE_BRICKS);
        //Slabs
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_SLAB, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        slab(CavernousCoveBlocks.WOODEN_SLAB, CavernousCoveBlocks.PLANKS);
        slab(CavernousCoveBlocks.COBBLESTONE_SLAB, CavernousCoveBlocks.COBBLESTONE);
        slab(CavernousCoveBlocks.STONE_SLAB, CavernousCoveBlocks.STONE);
        slab(CavernousCoveBlocks.STONE_BRICKS_SLAB, CavernousCoveBlocks.STONE_BRICKS);
        slab(HeavenlyRealmBlocks.WOODEN_SLAB, HeavenlyRealmBlocks.PLANKS);
        slab(HeavenlyRealmBlocks.COBBLESTONE_SLAB, HeavenlyRealmBlocks.COBBLESTONE);
        slab(HeavenlyRealmBlocks.STONE_SLAB, HeavenlyRealmBlocks.STONE);
        slab(HeavenlyRealmBlocks.STONE_BRICKS_SLAB, HeavenlyRealmBlocks.STONE_BRICKS);
        slab(CorrosiveFieldsBlocks.WOODEN_SLAB, CorrosiveFieldsBlocks.PLANKS);
        slab(CorrosiveFieldsBlocks.COBBLESTONE_SLAB, CorrosiveFieldsBlocks.COBBLESTONE);
        slab(CorrosiveFieldsBlocks.STONE_SLAB, CorrosiveFieldsBlocks.STONE);
        slab(CorrosiveFieldsBlocks.STONE_BRICKS_SLAB, CorrosiveFieldsBlocks.STONE_BRICKS);
        slab(DeepTundraBlocks.WOODEN_SLAB, DeepTundraBlocks.PLANKS);
        slab(DeepTundraBlocks.COBBLESTONE_SLAB, DeepTundraBlocks.COBBLESTONE);
        slab(DeepTundraBlocks.STONE_SLAB, DeepTundraBlocks.STONE);
        slab(DeepTundraBlocks.STONE_BRICKS_SLAB, DeepTundraBlocks.STONE_BRICKS);
        slab(DraconicRiftBlocks.WOODEN_SLAB, DraconicRiftBlocks.PLANKS);
        slab(DreamlandBlocks.WOODEN_SLAB, DreamlandBlocks.PLANKS);
        slab(DreamlandBlocks.COBBLESTONE_SLAB, DreamlandBlocks.COBBLESTONE);
        slab(DreamlandBlocks.STONE_SLAB, DreamlandBlocks.STONE);
        slab(DreamlandBlocks.STONE_BRICKS_SLAB, DreamlandBlocks.STONE_BRICKS);
        //Doors
        door(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR, "electrically_charged");
        //Trapdoors
        trapDoor(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR, "electrically_charged");
        //Saplings
        crossBlock(InsectoidParadisioBlocks.BUGGED_SAPLING);
        crossBlock(ValleyDeathBlocks.DARKENED_SAPLING);
        crossBlock(DraconicRiftBlocks.SAPLING);
        crossBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING);
        crossBlock(FeywildExpanseBlocks.FEYAN_SAPLING);
        crossBlock(EmberwildsBlocks.EMBERED_SAPLING);
        crossBlock(HeavenlyRealmBlocks.SAPLING);
        crossBlock(GhastlyMarshBlocks.SPOOKY_SAPLING);
        crossBlock(GrassyKnollBlocks.GRASSY_SAPLING);
        crossBlock(TerraNataBlocks.GROUNDED_SAPLING);
        crossBlock(DeepTundraBlocks.SAPLING);
        crossBlock(CorrosiveFieldsBlocks.SAPLING);
        crossBlock(DreamlandBlocks.SAPLING);
        crossBlock(MetallicMountainsBlocks.METALLIC_SAPLING);
        crossBlock(WateryDepthsBlocks.WATERY_SAPLING);
        //Button
        button(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        button(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        button(CavernousCoveBlocks.WOODEN_BUTTON, CavernousCoveBlocks.PLANKS);
        button(CavernousCoveBlocks.STONE_BUTTON, CavernousCoveBlocks.STONE);
        button(HeavenlyRealmBlocks.WOODEN_BUTTON, HeavenlyRealmBlocks.PLANKS);
        button(HeavenlyRealmBlocks.STONE_BUTTON, HeavenlyRealmBlocks.STONE);
        button(CorrosiveFieldsBlocks.WOODEN_BUTTON, CorrosiveFieldsBlocks.PLANKS);
        button(CorrosiveFieldsBlocks.STONE_BUTTON, CorrosiveFieldsBlocks.STONE);
        button(DeepTundraBlocks.WOODEN_BUTTON, DeepTundraBlocks.PLANKS);
        button(DeepTundraBlocks.STONE_BUTTON, DeepTundraBlocks.STONE);
        button(DraconicRiftBlocks.WOODEN_BUTTON, DraconicRiftBlocks.PLANKS);
        minecraftButton(DraconicRiftBlocks.STONE_BUTTON, Blocks.END_STONE);
        button(DreamlandBlocks.WOODEN_BUTTON, DreamlandBlocks.PLANKS);
        button(DreamlandBlocks.STONE_BUTTON, DreamlandBlocks.STONE);
        //Pressure Plate
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        pressurePlate(CavernousCoveBlocks.WOODEN_PRESSURE_PLATE, CavernousCoveBlocks.PLANKS);
        pressurePlate(CavernousCoveBlocks.STONE_PRESSURE_PLATE, CavernousCoveBlocks.STONE);
        pressurePlate(HeavenlyRealmBlocks.WOODEN_PRESSURE_PLATE, HeavenlyRealmBlocks.PLANKS);
        pressurePlate(HeavenlyRealmBlocks.STONE_PRESSURE_PLATE, HeavenlyRealmBlocks.STONE);
        pressurePlate(CorrosiveFieldsBlocks.WOODEN_PRESSURE_PLATE, CorrosiveFieldsBlocks.PLANKS);
        pressurePlate(CorrosiveFieldsBlocks.STONE_PRESSURE_PLATE, CorrosiveFieldsBlocks.STONE);
        pressurePlate(DeepTundraBlocks.WOODEN_PRESSURE_PLATE, DeepTundraBlocks.PLANKS);
        pressurePlate(DeepTundraBlocks.STONE_PRESSURE_PLATE, DeepTundraBlocks.STONE);
        pressurePlate(DraconicRiftBlocks.WOODEN_PRESSURE_PLATE, DraconicRiftBlocks.PLANKS);
        minecraftPressurePlate(DraconicRiftBlocks.STONE_PRESSURE_PLATE, Blocks.END_STONE);
        pressurePlate(DreamlandBlocks.WOODEN_PRESSURE_PLATE, DreamlandBlocks.PLANKS);
        pressurePlate(DreamlandBlocks.STONE_PRESSURE_PLATE, DreamlandBlocks.STONE);
        //Portal Frame
        block(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME);
    }
}
