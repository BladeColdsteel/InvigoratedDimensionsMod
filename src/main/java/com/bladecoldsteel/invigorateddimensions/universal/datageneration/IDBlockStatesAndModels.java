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
        //Logs
        log(InsectoidParadisioBlocks.BUGGED_LOG, "bugged_logs");
        log(ValleyDeathBlocks.DARKENED_LOG, "darkened_logs");
        log(DraconicRiftBlocks.DRACONIC_LOG, "draconic_logs");
        log(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG, "electrically_charged_logs");
        log(FeywildExpanseBlocks.FEYAN_LOG, "feyan_logs");
        log(InfiniteDungeonBlocks.TOUGH_LOG, "tough_logs");
        log(EmberwildsBlocks.EMBERED_LOG, "embered_logs");
        log(HeavenlyRealmBlocks.FLOATING_LOG, "floating_logs");
        log(GhastlyMarshBlocks.SPOOKY_LOG, "spooky_logs");
        log(GrassyKnollBlocks.GRASSY_LOG, "grassy_logs");
        log(TerraNataBlocks.GROUNDED_LOG, "grounded_logs");
        log(DeepTundraBlocks.ICEY_LOG, "icey_logs");
        log(CorrosiveFieldsBlocks.CORROSIVE_LOG, "corrosive_logs");
        log(DreamlandBlocks.PSYCHEDELIC_LOG, "psychedelic_logs");
        log(CavernousCoveBlocks.ROCKY_LOG, "rocky_logs");
        log(MetallicMountainsBlocks.METALLIC_LOG, "metallic_logs");
        log(WateryDepthsBlocks.WATERY_LOG, "watery_logs");
        //Stripped Logs
        log(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG, "stripped_electrically_charged_logs");
        //Wood
        uniformLog(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD, "electrically_charged_logs_side");
        //Stripped Wood
        uniformLog(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD, "stripped_electrically_charged_logs_side");
        //Stone
        block(InsectoidParadisioBlocks.BUGGED_STONE);
        block(ValleyDeathBlocks.DARKENED_STONE);
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        block(FeywildExpanseBlocks.FEYAN_STONE);
        block(InfiniteDungeonBlocks.TOUGH_STONE);
        block(HeavenlyRealmBlocks.FLOATING_STONE);
        block(GhastlyMarshBlocks.SPOOKY_STONE);
        block(GrassyKnollBlocks.GRASSY_STONE);
        block(TerraNataBlocks.GROUNDED_STONE);
        block(DeepTundraBlocks.ICEY_STONE);
        block(CorrosiveFieldsBlocks.CORROSIVE_STONE);
        block(DreamlandBlocks.PSYCHEDELIC_STONE);
        block(CavernousCoveBlocks.ROCKY_STONE);
        block(MetallicMountainsBlocks.METALLIC_STONE);
        block(WateryDepthsBlocks.WATERY_STONE);
        //Cobblestone
        block(InsectoidParadisioBlocks.BUGGED_COBBLESTONE);
        block(ValleyDeathBlocks.DARKENED_COBBLESTONE);
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        block(FeywildExpanseBlocks.FEYAN_COBBLESTONE);
        block(InfiniteDungeonBlocks.TOUGH_COBBLESTONE);
        block(HeavenlyRealmBlocks.FLOATING_COBBLESTONE);
        block(GhastlyMarshBlocks.SPOOKY_COBBLESTONE);
        block(GrassyKnollBlocks.GRASSY_COBBLESTONE);
        block(TerraNataBlocks.GROUNDED_COBBLESTONE);
        block(DeepTundraBlocks.ICEY_COBBLESTONE);
        block(CorrosiveFieldsBlocks.CORROSIVE_COBBLESTONE);
        block(DreamlandBlocks.PSYCHEDELIC_COBBLESTONE);
        block(CavernousCoveBlocks.ROCKY_COBBLESTONE);
        block(MetallicMountainsBlocks.METALLIC_COBBLESTONE);
        block(WateryDepthsBlocks.WATERY_COBBLESTONE);
        //Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        //Chiseled Stone Bricks
        block(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
        //Walls
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_WALL.get(), modLoc("block/electrically_charged_cobblestone"));
        wallBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_WALL.get(), modLoc("block/electrically_charged_stone_bricks"));
        //Fences
        fence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        //Fence Gates
        fenceGateBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE.get(), modLoc("block/electrically_charged_planks"));
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
        //Slabs
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_SLAB, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
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
        crossBlock(HeavenlyRealmBlocks.FLOATING_SAPLING);
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
        //Pressure Plate
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        pressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        //Portal Frame
        block(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME);
    }
}
