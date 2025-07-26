package com.bladecoldsteel.invigorateddimensions.universal.datageneration;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider.IDRecipeProvider;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class IDRecipes extends IDRecipeProvider {
    public IDRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        //Rock
            //Wooden
        makePlanks(CavernousCoveBlocks.PLANKS, CavernousCoveBlocks.LOG).save(consumer);
        makeWood(CavernousCoveBlocks.WOOD, CavernousCoveBlocks.LOG).save(consumer);
        makeStairs(CavernousCoveBlocks.WOODEN_STAIRS, CavernousCoveBlocks.PLANKS).save(consumer);
        makeSlab(CavernousCoveBlocks.WOODEN_SLAB, CavernousCoveBlocks.PLANKS).save(consumer);
        makeFence(CavernousCoveBlocks.FENCE, CavernousCoveBlocks.PLANKS).save(consumer);
        makeFenceGate(CavernousCoveBlocks.FENCE_GATE, CavernousCoveBlocks.PLANKS).save(consumer);
        makeButton(CavernousCoveBlocks.WOODEN_BUTTON, CavernousCoveBlocks.PLANKS).save(consumer);
        makePressurePlate(CavernousCoveBlocks.WOODEN_PRESSURE_PLATE, CavernousCoveBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(CavernousCoveBlocks.STONE_BRICKS, CavernousCoveBlocks.STONE).save(consumer);
        makeStairs(CavernousCoveBlocks.STONE_STAIRS, CavernousCoveBlocks.STONE).save(consumer);
        makeStairs(CavernousCoveBlocks.COBBLESTONE_STAIRS, CavernousCoveBlocks.COBBLESTONE).save(consumer);
        makeStairs(CavernousCoveBlocks.STONE_BRICKS_STAIRS, CavernousCoveBlocks.STONE_BRICKS).save(consumer);
        makeSlab(CavernousCoveBlocks.COBBLESTONE_SLAB, CavernousCoveBlocks.COBBLESTONE).save(consumer);
        makeSlab(CavernousCoveBlocks.STONE_SLAB, CavernousCoveBlocks.STONE).save(consumer);
        makeSlab(CavernousCoveBlocks.STONE_BRICKS_SLAB, CavernousCoveBlocks.STONE_BRICKS).save(consumer);
        makeWall(CavernousCoveBlocks.COBBLESTONE_WALL, CavernousCoveBlocks.COBBLESTONE).save(consumer);
        makeWall(CavernousCoveBlocks.STONE_BRICKS_WALL, CavernousCoveBlocks.STONE_BRICKS).save(consumer);
        makeButton(CavernousCoveBlocks.STONE_BUTTON, CavernousCoveBlocks.STONE).save(consumer);
        makePressurePlate(CavernousCoveBlocks.STONE_PRESSURE_PLATE, CavernousCoveBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(CavernousCoveBlocks.STONE, CavernousCoveBlocks.STONE_BRICKS.get()).save(consumer, name("rocky_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(CavernousCoveBlocks.STONE, CavernousCoveBlocks.STONE_STAIRS.get()).save(consumer, name("rocky_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(CavernousCoveBlocks.STONE, CavernousCoveBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("rocky_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(CavernousCoveBlocks.STONE, CavernousCoveBlocks.STONE_SLAB.get(), 2).save(consumer, name("rocky_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(CavernousCoveBlocks.STONE, CavernousCoveBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("rocky_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(CavernousCoveBlocks.STONE_BRICKS, CavernousCoveBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("rocky_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(CavernousCoveBlocks.COBBLESTONE, CavernousCoveBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("rocky_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(CavernousCoveBlocks.COBBLESTONE, CavernousCoveBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("rocky_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(CavernousCoveBlocks.STONE.get(), CavernousCoveBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_rocky_cobblestone"));
        //Flying
            //Wooden
        makePlanks(HeavenlyRealmBlocks.PLANKS, HeavenlyRealmBlocks.LOG).save(consumer);
        makeWood(HeavenlyRealmBlocks.WOOD, HeavenlyRealmBlocks.LOG).save(consumer);
        makeStairs(HeavenlyRealmBlocks.WOODEN_STAIRS, HeavenlyRealmBlocks.PLANKS).save(consumer);
        makeSlab(HeavenlyRealmBlocks.WOODEN_SLAB, HeavenlyRealmBlocks.PLANKS).save(consumer);
        makeFence(HeavenlyRealmBlocks.FENCE, HeavenlyRealmBlocks.PLANKS).save(consumer);
        makeFenceGate(HeavenlyRealmBlocks.FENCE_GATE, HeavenlyRealmBlocks.PLANKS).save(consumer);
        makeButton(HeavenlyRealmBlocks.WOODEN_BUTTON, HeavenlyRealmBlocks.PLANKS).save(consumer);
        makePressurePlate(HeavenlyRealmBlocks.WOODEN_PRESSURE_PLATE, HeavenlyRealmBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(HeavenlyRealmBlocks.STONE_BRICKS, HeavenlyRealmBlocks.STONE).save(consumer);
        makeStairs(HeavenlyRealmBlocks.STONE_STAIRS, HeavenlyRealmBlocks.STONE).save(consumer);
        makeStairs(HeavenlyRealmBlocks.COBBLESTONE_STAIRS, HeavenlyRealmBlocks.COBBLESTONE).save(consumer);
        makeStairs(HeavenlyRealmBlocks.STONE_BRICKS_STAIRS, HeavenlyRealmBlocks.STONE_BRICKS).save(consumer);
        makeSlab(HeavenlyRealmBlocks.COBBLESTONE_SLAB, HeavenlyRealmBlocks.COBBLESTONE).save(consumer);
        makeSlab(HeavenlyRealmBlocks.STONE_SLAB, HeavenlyRealmBlocks.STONE).save(consumer);
        makeSlab(HeavenlyRealmBlocks.STONE_BRICKS_SLAB, HeavenlyRealmBlocks.STONE_BRICKS).save(consumer);
        makeWall(HeavenlyRealmBlocks.COBBLESTONE_WALL, HeavenlyRealmBlocks.COBBLESTONE).save(consumer);
        makeWall(HeavenlyRealmBlocks.STONE_BRICKS_WALL, HeavenlyRealmBlocks.STONE_BRICKS).save(consumer);
        makeButton(HeavenlyRealmBlocks.STONE_BUTTON, HeavenlyRealmBlocks.STONE).save(consumer);
        makePressurePlate(HeavenlyRealmBlocks.STONE_PRESSURE_PLATE, HeavenlyRealmBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.STONE_BRICKS.get()).save(consumer, name("floating_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.STONE_STAIRS.get()).save(consumer, name("floating_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("floating_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.STONE_SLAB.get(), 2).save(consumer, name("floating_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("floating_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(HeavenlyRealmBlocks.STONE_BRICKS, HeavenlyRealmBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("floating_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(HeavenlyRealmBlocks.COBBLESTONE, HeavenlyRealmBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("floating_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(HeavenlyRealmBlocks.COBBLESTONE, HeavenlyRealmBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("floating_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(HeavenlyRealmBlocks.STONE.get(), HeavenlyRealmBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_floating_cobblestone"));
        //Poison
            //Wooden
        makePlanks(CorrosiveFieldsBlocks.PLANKS, CorrosiveFieldsBlocks.LOG).save(consumer);
        makeWood(CorrosiveFieldsBlocks.WOOD, CorrosiveFieldsBlocks.LOG).save(consumer);
        makeStairs(CorrosiveFieldsBlocks.WOODEN_STAIRS, CorrosiveFieldsBlocks.PLANKS).save(consumer);
        makeSlab(CorrosiveFieldsBlocks.WOODEN_SLAB, CorrosiveFieldsBlocks.PLANKS).save(consumer);
        makeFence(CorrosiveFieldsBlocks.FENCE, CorrosiveFieldsBlocks.PLANKS).save(consumer);
        makeFenceGate(CorrosiveFieldsBlocks.FENCE_GATE, CorrosiveFieldsBlocks.PLANKS).save(consumer);
        makeButton(CorrosiveFieldsBlocks.WOODEN_BUTTON, CorrosiveFieldsBlocks.PLANKS).save(consumer);
        makePressurePlate(CorrosiveFieldsBlocks.WOODEN_PRESSURE_PLATE, CorrosiveFieldsBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(CorrosiveFieldsBlocks.STONE_BRICKS, CorrosiveFieldsBlocks.STONE).save(consumer);
        makeStairs(CorrosiveFieldsBlocks.STONE_STAIRS, CorrosiveFieldsBlocks.STONE).save(consumer);
        makeStairs(CorrosiveFieldsBlocks.COBBLESTONE_STAIRS, CorrosiveFieldsBlocks.COBBLESTONE).save(consumer);
        makeStairs(CorrosiveFieldsBlocks.STONE_BRICKS_STAIRS, CorrosiveFieldsBlocks.STONE_BRICKS).save(consumer);
        makeSlab(CorrosiveFieldsBlocks.COBBLESTONE_SLAB, CorrosiveFieldsBlocks.COBBLESTONE).save(consumer);
        makeSlab(CorrosiveFieldsBlocks.STONE_SLAB, CorrosiveFieldsBlocks.STONE).save(consumer);
        makeSlab(CorrosiveFieldsBlocks.STONE_BRICKS_SLAB, CorrosiveFieldsBlocks.STONE_BRICKS).save(consumer);
        makeWall(CorrosiveFieldsBlocks.COBBLESTONE_WALL, CorrosiveFieldsBlocks.COBBLESTONE).save(consumer);
        makeWall(CorrosiveFieldsBlocks.STONE_BRICKS_WALL, CorrosiveFieldsBlocks.STONE_BRICKS).save(consumer);
        makeButton(CorrosiveFieldsBlocks.STONE_BUTTON, CorrosiveFieldsBlocks.STONE).save(consumer);
        makePressurePlate(CorrosiveFieldsBlocks.STONE_PRESSURE_PLATE, CorrosiveFieldsBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.STONE_BRICKS.get()).save(consumer, name("corrosive_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.STONE_STAIRS.get()).save(consumer, name("corrosive_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("corrosive_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.STONE_SLAB.get(), 2).save(consumer, name("corrosive_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("corrosive_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(CorrosiveFieldsBlocks.STONE_BRICKS, CorrosiveFieldsBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("corrosive_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(CorrosiveFieldsBlocks.COBBLESTONE, CorrosiveFieldsBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("corrosive_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(CorrosiveFieldsBlocks.COBBLESTONE, CorrosiveFieldsBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("corrosive_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(CorrosiveFieldsBlocks.STONE.get(), CorrosiveFieldsBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_corrosive_cobblestone"));
        //Ice
            //Wooden
        makePlanks(DeepTundraBlocks.PLANKS, DeepTundraBlocks.LOG).save(consumer);
        makeWood(DeepTundraBlocks.WOOD, DeepTundraBlocks.LOG).save(consumer);
        makeStairs(DeepTundraBlocks.WOODEN_STAIRS, DeepTundraBlocks.PLANKS).save(consumer);
        makeSlab(DeepTundraBlocks.WOODEN_SLAB, DeepTundraBlocks.PLANKS).save(consumer);
        makeFence(DeepTundraBlocks.FENCE, DeepTundraBlocks.PLANKS).save(consumer);
        makeFenceGate(DeepTundraBlocks.FENCE_GATE, DeepTundraBlocks.PLANKS).save(consumer);
        makeButton(DeepTundraBlocks.WOODEN_BUTTON, DeepTundraBlocks.PLANKS).save(consumer);
        makePressurePlate(DeepTundraBlocks.WOODEN_PRESSURE_PLATE, DeepTundraBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(DeepTundraBlocks.STONE_BRICKS, DeepTundraBlocks.STONE).save(consumer);
        makeStairs(DeepTundraBlocks.STONE_STAIRS, DeepTundraBlocks.STONE).save(consumer);
        makeStairs(DeepTundraBlocks.COBBLESTONE_STAIRS, DeepTundraBlocks.COBBLESTONE).save(consumer);
        makeStairs(DeepTundraBlocks.STONE_BRICKS_STAIRS, DeepTundraBlocks.STONE_BRICKS).save(consumer);
        makeSlab(DeepTundraBlocks.COBBLESTONE_SLAB, DeepTundraBlocks.COBBLESTONE).save(consumer);
        makeSlab(DeepTundraBlocks.STONE_SLAB, DeepTundraBlocks.STONE).save(consumer);
        makeSlab(DeepTundraBlocks.STONE_BRICKS_SLAB, DeepTundraBlocks.STONE_BRICKS).save(consumer);
        makeWall(DeepTundraBlocks.COBBLESTONE_WALL, DeepTundraBlocks.COBBLESTONE).save(consumer);
        makeWall(DeepTundraBlocks.STONE_BRICKS_WALL, DeepTundraBlocks.STONE_BRICKS).save(consumer);
        makeButton(DeepTundraBlocks.STONE_BUTTON, DeepTundraBlocks.STONE).save(consumer);
        makePressurePlate(DeepTundraBlocks.STONE_PRESSURE_PLATE, DeepTundraBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(DeepTundraBlocks.STONE, DeepTundraBlocks.STONE_BRICKS.get()).save(consumer, name("icey_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(DeepTundraBlocks.STONE, DeepTundraBlocks.STONE_STAIRS.get()).save(consumer, name("icey_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(DeepTundraBlocks.STONE, DeepTundraBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("icey_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(DeepTundraBlocks.STONE, DeepTundraBlocks.STONE_SLAB.get(), 2).save(consumer, name("icey_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(DeepTundraBlocks.STONE, DeepTundraBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("icey_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(DeepTundraBlocks.STONE_BRICKS, DeepTundraBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("icey_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(DeepTundraBlocks.COBBLESTONE, DeepTundraBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("icey_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(DeepTundraBlocks.COBBLESTONE, DeepTundraBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("icey_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(DeepTundraBlocks.STONE.get(), DeepTundraBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_icey_cobblestone"));
        //Dragon
        makePlanks(DraconicRiftBlocks.PLANKS, DraconicRiftBlocks.LOG).save(consumer);
        makeWood(DraconicRiftBlocks.WOOD, DraconicRiftBlocks.LOG).save(consumer);
        makeStairs(DraconicRiftBlocks.WOODEN_STAIRS, DraconicRiftBlocks.PLANKS).save(consumer);
        makeSlab(DraconicRiftBlocks.WOODEN_SLAB, DraconicRiftBlocks.PLANKS).save(consumer);
        makeFence(DraconicRiftBlocks.FENCE, DraconicRiftBlocks.PLANKS).save(consumer);
        makeFenceGate(DraconicRiftBlocks.FENCE_GATE, DraconicRiftBlocks.PLANKS).save(consumer);
        makeButton(DraconicRiftBlocks.WOODEN_BUTTON, DraconicRiftBlocks.PLANKS).save(consumer);
        makePressurePlate(DraconicRiftBlocks.WOODEN_PRESSURE_PLATE, DraconicRiftBlocks.PLANKS).save(consumer);
            //Stone
        makeMinecraftButton(DraconicRiftBlocks.STONE_BUTTON, Blocks.END_STONE).save(consumer);
        makeMinecraftPressurePlate(DraconicRiftBlocks.STONE_PRESSURE_PLATE, Blocks.END_STONE).save(consumer);
            //Smelting

        //Psychic
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(DreamlandBlocks.PSYCHEDELIC_STONE.get(), DreamlandBlocks.PSYCHEDELIC_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_psychedelic_cobblestone"));
        //Electric
            //Wooden
        makePlanks(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeWood(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeWood(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD, ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeSign(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeStairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeSlab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_SLAB, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeFence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeFenceGate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeDoor(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeTrapdoor(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeButton(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makePressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
            //Stone
        makeBricks(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE).save(consumer);
        makeChiseledBricks(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS).save(consumer);
        makeStairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE).save(consumer);
        makeStairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE).save(consumer);
        makeStairs(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS).save(consumer);
        makeSlab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE).save(consumer);
        makeSlab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE).save(consumer);
        makeSlab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS).save(consumer);
        makeWall(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_WALL, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE).save(consumer);
        makeWall(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_WALL, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS).save(consumer);
        makeButton(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BUTTON, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE).save(consumer);
        makePressurePlate(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE).save(consumer);
        stonecuttingSingleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get()).save(consumer, name("electric_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS.get()).save(consumer, name("chiseled_electric_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_STAIRS.get()).save(consumer, name("electric_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS.get()).save(consumer, name("electric_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS.get(), 2).save(consumer, name("electric_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS.get(), 2).save(consumer, name("electric_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS.get(), 2).save(consumer, name("electric_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS.get(), 2).save(consumer, name("electric_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS.get()).save(consumer, name("electric_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE.get(), ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_charged_cobblestone"));

        smeltingRecipe(Items.COAL, ElectricHighlandsBlocks.CHARGED_COAL_ORE.get(), 0.7F).save(consumer, name("smelt_charged_coal"));
        blastingRecipe(Items.COAL, ElectricHighlandsBlocks.CHARGED_COAL_ORE.get(), 0.7F).save(consumer, name("blast_charged_coal"));
        smeltingRecipe(Items.DIAMOND, ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE.get(), 0.7F).save(consumer, name("smelt_charged_diamond"));
        blastingRecipe(Items.DIAMOND, ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE.get(), 0.7F).save(consumer, name("blast_charged_diamond"));
        smeltingRecipe(Items.IRON_INGOT, ElectricHighlandsBlocks.CHARGED_IRON_ORE.get(), 0.7F).save(consumer, name("smelt_charged_iron"));
        blastingRecipe(Items.IRON_INGOT, ElectricHighlandsBlocks.CHARGED_IRON_ORE.get(), 0.7F).save(consumer, name("blast_charged_iron"));
        smeltingRecipe(Items.GOLD_INGOT, ElectricHighlandsBlocks.CHARGED_GOLD_ORE.get(), 0.7F).save(consumer, name("smelt_charged_gold"));
        blastingRecipe(Items.GOLD_INGOT, ElectricHighlandsBlocks.CHARGED_GOLD_ORE.get(), 0.7F).save(consumer, name("blast_charged_gold"));
        smeltingRecipe(Items.GLOWSTONE, ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE.get(), 0.7F).save(consumer, name("smelt_charged_glowstone"));
        blastingRecipe(Items.GLOWSTONE, ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE.get(), 0.7F).save(consumer, name("blast_charged_glowstone"));
        smeltingRecipe(ElectricHighlandsItems.VOLTCRYST.get(), ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE.get(), 0.7F).save(consumer, name("smelt_charged_voltcryst"));
        blastingRecipe(ElectricHighlandsItems.VOLTCRYST.get(), ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE.get(), 0.7F).save(consumer, name("blast_charged_voltcryst"));
        //Fire
            //Wooden

            //Stone

            //Smelting

        //Fairy
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(FeywildExpanseBlocks.FEYAN_STONE.get(), FeywildExpanseBlocks.FEYAN_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_feyan_cobblestone"));
        //Ghost
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(GhastlyMarshBlocks.SPOOKY_STONE.get(), GhastlyMarshBlocks.SPOOKY_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_spooky_cobblestone"));
        //Grass
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(GrassyKnollBlocks.GRASSY_STONE.get(), GrassyKnollBlocks.GRASSY_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_grassy_cobblestone"));
        //Fighting
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(InfiniteDungeonBlocks.TOUGH_STONE.get(), InfiniteDungeonBlocks.TOUGH_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_tough_cobblestone"));
        //Bug
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(InsectoidParadisioBlocks.BUGGED_STONE.get(), InsectoidParadisioBlocks.BUGGED_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_bugged_cobblestone"));
        //Steel
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(MetallicMountainsBlocks.METALLIC_STONE.get(), MetallicMountainsBlocks.METALLIC_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_metallic_cobblestone"));
        //Ground
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(TerraNataBlocks.GROUNDED_STONE.get(), TerraNataBlocks.GROUNDED_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_grounded_cobblestone"));
        //Dark
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(ValleyDeathBlocks.DARKENED_STONE.get(), ValleyDeathBlocks.DARKENED_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_darkened_cobblestone"));
        //Water
            //Wooden

            //Stone

            //Smelting
        smeltingRecipe(WateryDepthsBlocks.WATERY_STONE.get(), WateryDepthsBlocks.WATERY_COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_watery_cobblestone"));
        //Universal
        ShapedRecipeBuilder.shaped(UniversalBlocks.ENERGY_SINK.get())
                .pattern("I I")
                .pattern("IVI")
                .pattern(" I ")
                .define('I', ElectricHighlandsItems.VOLTCRYST.get())
                .define('V', Items.HOPPER)
                .unlockedBy("has_voltcryst", has(ElectricHighlandsItems.VOLTCRYST.get()))
                .save(consumer);
    }

    private ResourceLocation name(String name) {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, name);
    }
}
