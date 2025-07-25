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
        //Logs
        log(InsectoidParadisioBlocks.BUGGED_LOG, "bugged_logs");
        log(ValleyDeathBlocks.DARKENED_LOG, "darkened_logs");
        log(DraconicRiftBlocks.DRACONIC_LOG, "draconic_logs");
        log(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG, "electrically_charged_logs");
        log(FeywildExpanseBlocks.FEYAN_LOG, "feyan_logs");
        log(InfiniteDungeonBlocks.TOUGH_LOG, "tough_logs");
        log(EmberwildsBlocks.EMBERED_LOG, "embered_logs");
        log(HeavenlyRealmBlocks.LOG, "floating_logs");
        log(GhastlyMarshBlocks.SPOOKY_LOG, "spooky_logs");
        log(GrassyKnollBlocks.GRASSY_LOG, "grassy_logs");
        log(TerraNataBlocks.GROUNDED_LOG, "grounded_logs");
        log(DeepTundraBlocks.ICEY_LOG, "icey_logs");
        log(CorrosiveFieldsBlocks.CORROSIVE_LOG, "corrosive_logs");
        log(DreamlandBlocks.PSYCHEDELIC_LOG, "psychedelic_logs");
        log(CavernousCoveBlocks.LOG, "rocky_logs");
        log(MetallicMountainsBlocks.METALLIC_LOG, "metallic_logs");
        log(WateryDepthsBlocks.WATERY_LOG, "watery_logs");
        //Stripped Logs
        log(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG, "stripped_electrically_charged_logs");
        //Wood
        uniformLog(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD, "electrically_charged_logs_side");
        uniformLog(CavernousCoveBlocks.WOOD, "rocky_logs_side");
        uniformLog(HeavenlyRealmBlocks.WOOD, "floating_logs_side");
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
        block(DeepTundraBlocks.ICEY_STONE);
        block(CorrosiveFieldsBlocks.CORROSIVE_STONE);
        block(DreamlandBlocks.PSYCHEDELIC_STONE);
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
        block(DeepTundraBlocks.ICEY_COBBLESTONE);
        block(CorrosiveFieldsBlocks.CORROSIVE_COBBLESTONE);
        block(DreamlandBlocks.PSYCHEDELIC_COBBLESTONE);
        block(CavernousCoveBlocks.COBBLESTONE);
        block(MetallicMountainsBlocks.METALLIC_COBBLESTONE);
        block(WateryDepthsBlocks.WATERY_COBBLESTONE);
        //Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        block(CavernousCoveBlocks.STONE_BRICKS);
        block(HeavenlyRealmBlocks.STONE_BRICKS);
        //Chiseled Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
        //Walls
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_WALL.get(), modLoc("block/electrically_charged_cobblestone"));
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_WALL.get(), modLoc("block/electrically_charged_stone_bricks"));
        wallBlock(CavernousCoveBlocks.COBBLESTONE_WALL.get(), modLoc("block/rocky_cobblestone"));
        wallBlock(CavernousCoveBlocks.STONE_BRICKS_WALL.get(), modLoc("block/rocky_stone_bricks"));
        wallBlock(HeavenlyRealmBlocks.COBBLESTONE_WALL.get(), modLoc("block/floating_cobblestone"));
        wallBlock(HeavenlyRealmBlocks.STONE_BRICKS_WALL.get(), modLoc("block/floating_stone_bricks"));
        //Fences
        fence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        fence(CavernousCoveBlocks.FENCE, CavernousCoveBlocks.PLANKS);
        fence(HeavenlyRealmBlocks.FENCE, HeavenlyRealmBlocks.PLANKS);
        //Fence Gates
        fenceGateBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE.get(), modLoc("block/electrically_charged_planks"));
        fenceGateBlock(CavernousCoveBlocks.FENCE_GATE.get(), modLoc("block/rocky_planks"));
        fenceGateBlock(HeavenlyRealmBlocks.FENCE_GATE.get(), modLoc("block/floating_planks"));
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
        //Doors
        door(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR, "electrically_charged");
        //Trapdoors
        trapDoor(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR, "electrically_charged");
        //Saplings
        crossBlock(InsectoidParadisioBlocks.BUGGED_SAPLING);
        crossBlock(ValleyDeathBlocks.DARKENED_SAPLING);
        crossBlock(DraconicRiftBlocks.DRACONIC_SAPLING);
        crossBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING);
        crossBlock(FeywildExpanseBlocks.FEYAN_SAPLING);
        crossBlock(EmberwildsBlocks.EMBERED_SAPLING);
        crossBlock(HeavenlyRealmBlocks.SAPLING);
        crossBlock(GhastlyMarshBlocks.SPOOKY_SAPLING);
        crossBlock(GrassyKnollBlocks.GRASSY_SAPLING);
        crossBlock(TerraNataBlocks.GROUNDED_SAPLING);
        crossBlock(DeepTundraBlocks.ICEY_SAPLING);
        crossBlock(CorrosiveFieldsBlocks.CORROSIVE_SAPLING);
        crossBlock(DreamlandBlocks.PSYCHEDELIC_SAPLING);
        crossBlock(MetallicMountainsBlocks.METALLIC_SAPLING);
        crossBlock(WateryDepthsBlocks.WATERY_SAPLING);
        //Button
        button(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        button(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        button(CavernousCoveBlocks.WOODEN_BUTTON, CavernousCoveBlocks.PLANKS);
        button(CavernousCoveBlocks.STONE_BUTTON, CavernousCoveBlocks.STONE);
        button(HeavenlyRealmBlocks.WOODEN_BUTTON, HeavenlyRealmBlocks.PLANKS);
        button(HeavenlyRealmBlocks.STONE_BUTTON, HeavenlyRealmBlocks.STONE);
        //Pressure Plate
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        pressurePlate(CavernousCoveBlocks.WOODEN_PRESSURE_PLATE, CavernousCoveBlocks.PLANKS);
        pressurePlate(CavernousCoveBlocks.STONE_PRESSURE_PLATE, CavernousCoveBlocks.STONE);
        pressurePlate(HeavenlyRealmBlocks.WOODEN_PRESSURE_PLATE, HeavenlyRealmBlocks.PLANKS);
        pressurePlate(HeavenlyRealmBlocks.STONE_PRESSURE_PLATE, HeavenlyRealmBlocks.STONE);
        //Portal Frame
        block(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME);
    }
}
