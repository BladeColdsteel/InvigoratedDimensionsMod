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
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
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
        makePlanks(DreamlandBlocks.PLANKS, DreamlandBlocks.LOG).save(consumer);
        makeWood(DreamlandBlocks.WOOD, DreamlandBlocks.LOG).save(consumer);
        makeStairs(DreamlandBlocks.WOODEN_STAIRS, DreamlandBlocks.PLANKS).save(consumer);
        makeSlab(DreamlandBlocks.WOODEN_SLAB, DreamlandBlocks.PLANKS).save(consumer);
        makeFence(DreamlandBlocks.FENCE, DreamlandBlocks.PLANKS).save(consumer);
        makeFenceGate(DreamlandBlocks.FENCE_GATE, DreamlandBlocks.PLANKS).save(consumer);
        makeButton(DreamlandBlocks.WOODEN_BUTTON, DreamlandBlocks.PLANKS).save(consumer);
        makePressurePlate(DreamlandBlocks.WOODEN_PRESSURE_PLATE, DreamlandBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(DreamlandBlocks.STONE_BRICKS, DreamlandBlocks.STONE).save(consumer);
        makeStairs(DreamlandBlocks.STONE_STAIRS, DreamlandBlocks.STONE).save(consumer);
        makeStairs(DreamlandBlocks.COBBLESTONE_STAIRS, DreamlandBlocks.COBBLESTONE).save(consumer);
        makeStairs(DreamlandBlocks.STONE_BRICKS_STAIRS, DreamlandBlocks.STONE_BRICKS).save(consumer);
        makeSlab(DreamlandBlocks.COBBLESTONE_SLAB, DreamlandBlocks.COBBLESTONE).save(consumer);
        makeSlab(DreamlandBlocks.STONE_SLAB, DreamlandBlocks.STONE).save(consumer);
        makeSlab(DreamlandBlocks.STONE_BRICKS_SLAB, DreamlandBlocks.STONE_BRICKS).save(consumer);
        makeWall(DreamlandBlocks.COBBLESTONE_WALL, DreamlandBlocks.COBBLESTONE).save(consumer);
        makeWall(DreamlandBlocks.STONE_BRICKS_WALL, DreamlandBlocks.STONE_BRICKS).save(consumer);
        makeButton(DreamlandBlocks.STONE_BUTTON, DreamlandBlocks.STONE).save(consumer);
        makePressurePlate(DreamlandBlocks.STONE_PRESSURE_PLATE, DreamlandBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(DreamlandBlocks.STONE, DreamlandBlocks.STONE_BRICKS.get()).save(consumer, name("psychedelic_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(DreamlandBlocks.STONE, DreamlandBlocks.STONE_STAIRS.get()).save(consumer, name("psychedelic_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(DreamlandBlocks.STONE, DreamlandBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("psychedelic_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(DreamlandBlocks.STONE, DreamlandBlocks.STONE_SLAB.get(), 2).save(consumer, name("psychedelic_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(DreamlandBlocks.STONE, DreamlandBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("psychedelic_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(DreamlandBlocks.STONE_BRICKS, DreamlandBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("psychedelic_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(DreamlandBlocks.COBBLESTONE, DreamlandBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("psychedelic_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(DreamlandBlocks.COBBLESTONE, DreamlandBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("psychedelic_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(DreamlandBlocks.STONE.get(), DreamlandBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_psychedelic_cobblestone"));
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
        makePlanks(EmberwildsBlocks.PLANKS, EmberwildsBlocks.LOG).save(consumer);
        makeWood(EmberwildsBlocks.WOOD, EmberwildsBlocks.LOG).save(consumer);
        makeStairs(EmberwildsBlocks.WOODEN_STAIRS, EmberwildsBlocks.PLANKS).save(consumer);
        makeSlab(EmberwildsBlocks.WOODEN_SLAB, EmberwildsBlocks.PLANKS).save(consumer);
        makeFence(EmberwildsBlocks.FENCE, EmberwildsBlocks.PLANKS).save(consumer);
        makeFenceGate(EmberwildsBlocks.FENCE_GATE, EmberwildsBlocks.PLANKS).save(consumer);
        makeButton(EmberwildsBlocks.WOODEN_BUTTON, EmberwildsBlocks.PLANKS).save(consumer);
        makePressurePlate(EmberwildsBlocks.WOODEN_PRESSURE_PLATE, EmberwildsBlocks.PLANKS).save(consumer);
            //Stone
        makeMinecraftButton(EmberwildsBlocks.STONE_BUTTON, Blocks.END_STONE).save(consumer);
        makeMinecraftPressurePlate(EmberwildsBlocks.STONE_PRESSURE_PLATE, Blocks.END_STONE).save(consumer);
            //Smelting

        //Fairy
            //Wooden
        makePlanks(FeywildExpanseBlocks.PLANKS, FeywildExpanseBlocks.LOG).save(consumer);
        makeWood(FeywildExpanseBlocks.WOOD, FeywildExpanseBlocks.LOG).save(consumer);
        makeStairs(FeywildExpanseBlocks.WOODEN_STAIRS, FeywildExpanseBlocks.PLANKS).save(consumer);
        makeSlab(FeywildExpanseBlocks.WOODEN_SLAB, FeywildExpanseBlocks.PLANKS).save(consumer);
        makeFence(FeywildExpanseBlocks.FENCE, FeywildExpanseBlocks.PLANKS).save(consumer);
        makeFenceGate(FeywildExpanseBlocks.FENCE_GATE, FeywildExpanseBlocks.PLANKS).save(consumer);
        makeButton(FeywildExpanseBlocks.WOODEN_BUTTON, FeywildExpanseBlocks.PLANKS).save(consumer);
        makePressurePlate(FeywildExpanseBlocks.WOODEN_PRESSURE_PLATE, FeywildExpanseBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(FeywildExpanseBlocks.STONE_BRICKS, FeywildExpanseBlocks.STONE).save(consumer);
        makeStairs(FeywildExpanseBlocks.STONE_STAIRS, FeywildExpanseBlocks.STONE).save(consumer);
        makeStairs(FeywildExpanseBlocks.COBBLESTONE_STAIRS, FeywildExpanseBlocks.COBBLESTONE).save(consumer);
        makeStairs(FeywildExpanseBlocks.STONE_BRICKS_STAIRS, FeywildExpanseBlocks.STONE_BRICKS).save(consumer);
        makeSlab(FeywildExpanseBlocks.COBBLESTONE_SLAB, FeywildExpanseBlocks.COBBLESTONE).save(consumer);
        makeSlab(FeywildExpanseBlocks.STONE_SLAB, FeywildExpanseBlocks.STONE).save(consumer);
        makeSlab(FeywildExpanseBlocks.STONE_BRICKS_SLAB, FeywildExpanseBlocks.STONE_BRICKS).save(consumer);
        makeWall(FeywildExpanseBlocks.COBBLESTONE_WALL, FeywildExpanseBlocks.COBBLESTONE).save(consumer);
        makeWall(FeywildExpanseBlocks.STONE_BRICKS_WALL, FeywildExpanseBlocks.STONE_BRICKS).save(consumer);
        makeButton(FeywildExpanseBlocks.STONE_BUTTON, FeywildExpanseBlocks.STONE).save(consumer);
        makePressurePlate(FeywildExpanseBlocks.STONE_PRESSURE_PLATE, FeywildExpanseBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.STONE_BRICKS.get()).save(consumer, name("feyan_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.STONE_STAIRS.get()).save(consumer, name("feyan_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("feyan_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.STONE_SLAB.get(), 2).save(consumer, name("feyan_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("feyan_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(FeywildExpanseBlocks.STONE_BRICKS, FeywildExpanseBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("feyan_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(FeywildExpanseBlocks.COBBLESTONE, FeywildExpanseBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("feyan_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(FeywildExpanseBlocks.COBBLESTONE, FeywildExpanseBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("feyan_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(FeywildExpanseBlocks.STONE.get(), FeywildExpanseBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_feyan_cobblestone"));
        //Ghost
            //Wooden
        makePlanks(GhastlyMarshBlocks.PLANKS, GhastlyMarshBlocks.LOG).save(consumer);
        makeWood(GhastlyMarshBlocks.WOOD, GhastlyMarshBlocks.LOG).save(consumer);
        makeStairs(GhastlyMarshBlocks.WOODEN_STAIRS, GhastlyMarshBlocks.PLANKS).save(consumer);
        makeSlab(GhastlyMarshBlocks.WOODEN_SLAB, GhastlyMarshBlocks.PLANKS).save(consumer);
        makeFence(GhastlyMarshBlocks.FENCE, GhastlyMarshBlocks.PLANKS).save(consumer);
        makeFenceGate(GhastlyMarshBlocks.FENCE_GATE, GhastlyMarshBlocks.PLANKS).save(consumer);
        makeButton(GhastlyMarshBlocks.WOODEN_BUTTON, GhastlyMarshBlocks.PLANKS).save(consumer);
        makePressurePlate(GhastlyMarshBlocks.WOODEN_PRESSURE_PLATE, GhastlyMarshBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(GhastlyMarshBlocks.STONE_BRICKS, GhastlyMarshBlocks.STONE).save(consumer);
        makeStairs(GhastlyMarshBlocks.STONE_STAIRS, GhastlyMarshBlocks.STONE).save(consumer);
        makeStairs(GhastlyMarshBlocks.COBBLESTONE_STAIRS, GhastlyMarshBlocks.COBBLESTONE).save(consumer);
        makeStairs(GhastlyMarshBlocks.STONE_BRICKS_STAIRS, GhastlyMarshBlocks.STONE_BRICKS).save(consumer);
        makeSlab(GhastlyMarshBlocks.COBBLESTONE_SLAB, GhastlyMarshBlocks.COBBLESTONE).save(consumer);
        makeSlab(GhastlyMarshBlocks.STONE_SLAB, GhastlyMarshBlocks.STONE).save(consumer);
        makeSlab(GhastlyMarshBlocks.STONE_BRICKS_SLAB, GhastlyMarshBlocks.STONE_BRICKS).save(consumer);
        makeWall(GhastlyMarshBlocks.COBBLESTONE_WALL, GhastlyMarshBlocks.COBBLESTONE).save(consumer);
        makeWall(GhastlyMarshBlocks.STONE_BRICKS_WALL, GhastlyMarshBlocks.STONE_BRICKS).save(consumer);
        makeButton(GhastlyMarshBlocks.STONE_BUTTON, GhastlyMarshBlocks.STONE).save(consumer);
        makePressurePlate(GhastlyMarshBlocks.STONE_PRESSURE_PLATE, GhastlyMarshBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.STONE_BRICKS.get()).save(consumer, name("spooky_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.STONE_STAIRS.get()).save(consumer, name("spooky_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("spooky_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.STONE_SLAB.get(), 2).save(consumer, name("spooky_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("spooky_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(GhastlyMarshBlocks.STONE_BRICKS, GhastlyMarshBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("spooky_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(GhastlyMarshBlocks.COBBLESTONE, GhastlyMarshBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("spooky_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(GhastlyMarshBlocks.COBBLESTONE, GhastlyMarshBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("spooky_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(GhastlyMarshBlocks.STONE.get(), GhastlyMarshBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_spooky_cobblestone"));
        //Grass
            //Wooden
        makePlanks(GrassyKnollBlocks.PLANKS, GrassyKnollBlocks.LOG).save(consumer);
        makeWood(GrassyKnollBlocks.WOOD, GrassyKnollBlocks.LOG).save(consumer);
        makeStairs(GrassyKnollBlocks.WOODEN_STAIRS, GrassyKnollBlocks.PLANKS).save(consumer);
        makeSlab(GrassyKnollBlocks.WOODEN_SLAB, GrassyKnollBlocks.PLANKS).save(consumer);
        makeFence(GrassyKnollBlocks.FENCE, GrassyKnollBlocks.PLANKS).save(consumer);
        makeFenceGate(GrassyKnollBlocks.FENCE_GATE, GrassyKnollBlocks.PLANKS).save(consumer);
        makeButton(GrassyKnollBlocks.WOODEN_BUTTON, GrassyKnollBlocks.PLANKS).save(consumer);
        makePressurePlate(GrassyKnollBlocks.WOODEN_PRESSURE_PLATE, GrassyKnollBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(GrassyKnollBlocks.STONE_BRICKS, GrassyKnollBlocks.STONE).save(consumer);
        makeStairs(GrassyKnollBlocks.STONE_STAIRS, GrassyKnollBlocks.STONE).save(consumer);
        makeStairs(GrassyKnollBlocks.COBBLESTONE_STAIRS, GrassyKnollBlocks.COBBLESTONE).save(consumer);
        makeStairs(GrassyKnollBlocks.STONE_BRICKS_STAIRS, GrassyKnollBlocks.STONE_BRICKS).save(consumer);
        makeSlab(GrassyKnollBlocks.COBBLESTONE_SLAB, GrassyKnollBlocks.COBBLESTONE).save(consumer);
        makeSlab(GrassyKnollBlocks.STONE_SLAB, GrassyKnollBlocks.STONE).save(consumer);
        makeSlab(GrassyKnollBlocks.STONE_BRICKS_SLAB, GrassyKnollBlocks.STONE_BRICKS).save(consumer);
        makeWall(GrassyKnollBlocks.COBBLESTONE_WALL, GrassyKnollBlocks.COBBLESTONE).save(consumer);
        makeWall(GrassyKnollBlocks.STONE_BRICKS_WALL, GrassyKnollBlocks.STONE_BRICKS).save(consumer);
        makeButton(GrassyKnollBlocks.STONE_BUTTON, GrassyKnollBlocks.STONE).save(consumer);
        makePressurePlate(GrassyKnollBlocks.STONE_PRESSURE_PLATE, GrassyKnollBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(GrassyKnollBlocks.STONE, GrassyKnollBlocks.STONE_BRICKS.get()).save(consumer, name("grassy_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(GrassyKnollBlocks.STONE, GrassyKnollBlocks.STONE_STAIRS.get()).save(consumer, name("grassy_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(GrassyKnollBlocks.STONE, GrassyKnollBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("grassy_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(GrassyKnollBlocks.STONE, GrassyKnollBlocks.STONE_SLAB.get(), 2).save(consumer, name("grassy_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(GrassyKnollBlocks.STONE, GrassyKnollBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("grassy_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(GrassyKnollBlocks.STONE_BRICKS, GrassyKnollBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("grassy_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(GrassyKnollBlocks.COBBLESTONE, GrassyKnollBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("grassy_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(GrassyKnollBlocks.COBBLESTONE, GrassyKnollBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("grassy_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(GrassyKnollBlocks.STONE.get(), GrassyKnollBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_grassy_cobblestone"));
        //Fighting
            //Wooden
        makePlanks(InfiniteDungeonBlocks.PLANKS, InfiniteDungeonBlocks.LOG).save(consumer);
        makeWood(InfiniteDungeonBlocks.WOOD, InfiniteDungeonBlocks.LOG).save(consumer);
        makeStairs(InfiniteDungeonBlocks.WOODEN_STAIRS, InfiniteDungeonBlocks.PLANKS).save(consumer);
        makeSlab(InfiniteDungeonBlocks.WOODEN_SLAB, InfiniteDungeonBlocks.PLANKS).save(consumer);
        makeFence(InfiniteDungeonBlocks.FENCE, InfiniteDungeonBlocks.PLANKS).save(consumer);
        makeFenceGate(InfiniteDungeonBlocks.FENCE_GATE, InfiniteDungeonBlocks.PLANKS).save(consumer);
        makeButton(InfiniteDungeonBlocks.WOODEN_BUTTON, InfiniteDungeonBlocks.PLANKS).save(consumer);
        makePressurePlate(InfiniteDungeonBlocks.WOODEN_PRESSURE_PLATE, InfiniteDungeonBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(InfiniteDungeonBlocks.STONE_BRICKS, InfiniteDungeonBlocks.STONE).save(consumer);
        makeStairs(InfiniteDungeonBlocks.STONE_STAIRS, InfiniteDungeonBlocks.STONE).save(consumer);
        makeStairs(InfiniteDungeonBlocks.COBBLESTONE_STAIRS, InfiniteDungeonBlocks.COBBLESTONE).save(consumer);
        makeStairs(InfiniteDungeonBlocks.STONE_BRICKS_STAIRS, InfiniteDungeonBlocks.STONE_BRICKS).save(consumer);
        makeSlab(InfiniteDungeonBlocks.COBBLESTONE_SLAB, InfiniteDungeonBlocks.COBBLESTONE).save(consumer);
        makeSlab(InfiniteDungeonBlocks.STONE_SLAB, InfiniteDungeonBlocks.STONE).save(consumer);
        makeSlab(InfiniteDungeonBlocks.STONE_BRICKS_SLAB, InfiniteDungeonBlocks.STONE_BRICKS).save(consumer);
        makeWall(InfiniteDungeonBlocks.COBBLESTONE_WALL, InfiniteDungeonBlocks.COBBLESTONE).save(consumer);
        makeWall(InfiniteDungeonBlocks.STONE_BRICKS_WALL, InfiniteDungeonBlocks.STONE_BRICKS).save(consumer);
        makeButton(InfiniteDungeonBlocks.STONE_BUTTON, InfiniteDungeonBlocks.STONE).save(consumer);
        makePressurePlate(InfiniteDungeonBlocks.STONE_PRESSURE_PLATE, InfiniteDungeonBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.STONE_BRICKS.get()).save(consumer, name("tough_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.STONE_STAIRS.get()).save(consumer, name("tough_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("tough_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.STONE_SLAB.get(), 2).save(consumer, name("tough_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("tough_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(InfiniteDungeonBlocks.STONE_BRICKS, InfiniteDungeonBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("tough_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(InfiniteDungeonBlocks.COBBLESTONE, InfiniteDungeonBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("tough_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(InfiniteDungeonBlocks.COBBLESTONE, InfiniteDungeonBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("tough_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(InfiniteDungeonBlocks.STONE.get(), InfiniteDungeonBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_tough_cobblestone"));
        //Bug
            //Wooden
        makePlanks(InsectoidParadisioBlocks.PLANKS, InsectoidParadisioBlocks.LOG).save(consumer);
        makeWood(InsectoidParadisioBlocks.WOOD, InsectoidParadisioBlocks.LOG).save(consumer);
        makeStairs(InsectoidParadisioBlocks.WOODEN_STAIRS, InsectoidParadisioBlocks.PLANKS).save(consumer);
        makeSlab(InsectoidParadisioBlocks.WOODEN_SLAB, InsectoidParadisioBlocks.PLANKS).save(consumer);
        makeFence(InsectoidParadisioBlocks.FENCE, InsectoidParadisioBlocks.PLANKS).save(consumer);
        makeFenceGate(InsectoidParadisioBlocks.FENCE_GATE, InsectoidParadisioBlocks.PLANKS).save(consumer);
        makeButton(InsectoidParadisioBlocks.WOODEN_BUTTON, InsectoidParadisioBlocks.PLANKS).save(consumer);
        makePressurePlate(InsectoidParadisioBlocks.WOODEN_PRESSURE_PLATE, InsectoidParadisioBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(InsectoidParadisioBlocks.STONE_BRICKS, InsectoidParadisioBlocks.STONE).save(consumer);
        makeStairs(InsectoidParadisioBlocks.STONE_STAIRS, InsectoidParadisioBlocks.STONE).save(consumer);
        makeStairs(InsectoidParadisioBlocks.COBBLESTONE_STAIRS, InsectoidParadisioBlocks.COBBLESTONE).save(consumer);
        makeStairs(InsectoidParadisioBlocks.STONE_BRICKS_STAIRS, InsectoidParadisioBlocks.STONE_BRICKS).save(consumer);
        makeSlab(InsectoidParadisioBlocks.COBBLESTONE_SLAB, InsectoidParadisioBlocks.COBBLESTONE).save(consumer);
        makeSlab(InsectoidParadisioBlocks.STONE_SLAB, InsectoidParadisioBlocks.STONE).save(consumer);
        makeSlab(InsectoidParadisioBlocks.STONE_BRICKS_SLAB, InsectoidParadisioBlocks.STONE_BRICKS).save(consumer);
        makeWall(InsectoidParadisioBlocks.COBBLESTONE_WALL, InsectoidParadisioBlocks.COBBLESTONE).save(consumer);
        makeWall(InsectoidParadisioBlocks.STONE_BRICKS_WALL, InsectoidParadisioBlocks.STONE_BRICKS).save(consumer);
        makeButton(InsectoidParadisioBlocks.STONE_BUTTON, InsectoidParadisioBlocks.STONE).save(consumer);
        makePressurePlate(InsectoidParadisioBlocks.STONE_PRESSURE_PLATE, InsectoidParadisioBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.STONE_BRICKS.get()).save(consumer, name("bugged_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.STONE_STAIRS.get()).save(consumer, name("bugged_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("bugged_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.STONE_SLAB.get(), 2).save(consumer, name("bugged_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("bugged_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(InsectoidParadisioBlocks.STONE_BRICKS, InsectoidParadisioBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("bugged_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(InsectoidParadisioBlocks.COBBLESTONE, InsectoidParadisioBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("bugged_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(InsectoidParadisioBlocks.COBBLESTONE, InsectoidParadisioBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("bugged_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(InsectoidParadisioBlocks.STONE.get(), InsectoidParadisioBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_bugged_cobblestone"));
        //Steel
            //Wooden
        makePlanks(MetallicMountainsBlocks.PLANKS, MetallicMountainsBlocks.LOG).save(consumer);
        makeWood(MetallicMountainsBlocks.WOOD, MetallicMountainsBlocks.LOG).save(consumer);
        makeStairs(MetallicMountainsBlocks.WOODEN_STAIRS, MetallicMountainsBlocks.PLANKS).save(consumer);
        makeSlab(MetallicMountainsBlocks.WOODEN_SLAB, MetallicMountainsBlocks.PLANKS).save(consumer);
        makeFence(MetallicMountainsBlocks.FENCE, MetallicMountainsBlocks.PLANKS).save(consumer);
        makeFenceGate(MetallicMountainsBlocks.FENCE_GATE, MetallicMountainsBlocks.PLANKS).save(consumer);
        makeButton(MetallicMountainsBlocks.WOODEN_BUTTON, MetallicMountainsBlocks.PLANKS).save(consumer);
        makePressurePlate(MetallicMountainsBlocks.WOODEN_PRESSURE_PLATE, MetallicMountainsBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(MetallicMountainsBlocks.STONE_BRICKS, MetallicMountainsBlocks.STONE).save(consumer);
        makeStairs(MetallicMountainsBlocks.STONE_STAIRS, MetallicMountainsBlocks.STONE).save(consumer);
        makeStairs(MetallicMountainsBlocks.COBBLESTONE_STAIRS, MetallicMountainsBlocks.COBBLESTONE).save(consumer);
        makeStairs(MetallicMountainsBlocks.STONE_BRICKS_STAIRS, MetallicMountainsBlocks.STONE_BRICKS).save(consumer);
        makeSlab(MetallicMountainsBlocks.COBBLESTONE_SLAB, MetallicMountainsBlocks.COBBLESTONE).save(consumer);
        makeSlab(MetallicMountainsBlocks.STONE_SLAB, MetallicMountainsBlocks.STONE).save(consumer);
        makeSlab(MetallicMountainsBlocks.STONE_BRICKS_SLAB, MetallicMountainsBlocks.STONE_BRICKS).save(consumer);
        makeWall(MetallicMountainsBlocks.COBBLESTONE_WALL, MetallicMountainsBlocks.COBBLESTONE).save(consumer);
        makeWall(MetallicMountainsBlocks.STONE_BRICKS_WALL, MetallicMountainsBlocks.STONE_BRICKS).save(consumer);
        makeButton(MetallicMountainsBlocks.STONE_BUTTON, MetallicMountainsBlocks.STONE).save(consumer);
        makePressurePlate(MetallicMountainsBlocks.STONE_PRESSURE_PLATE, MetallicMountainsBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.STONE_BRICKS.get()).save(consumer, name("metallic_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.STONE_STAIRS.get()).save(consumer, name("metallic_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("metallic_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.STONE_SLAB.get(), 2).save(consumer, name("metallic_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("metallic_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(MetallicMountainsBlocks.STONE_BRICKS, MetallicMountainsBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("metallic_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(MetallicMountainsBlocks.COBBLESTONE, MetallicMountainsBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("metallic_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(MetallicMountainsBlocks.COBBLESTONE, MetallicMountainsBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("metallic_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(MetallicMountainsBlocks.STONE.get(), MetallicMountainsBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_metallic_cobblestone"));
        //Ground
            //Wooden
        makePlanks(TerraNataBlocks.PLANKS, TerraNataBlocks.LOG).save(consumer);
        makeWood(TerraNataBlocks.WOOD, TerraNataBlocks.LOG).save(consumer);
        makeStairs(TerraNataBlocks.WOODEN_STAIRS, TerraNataBlocks.PLANKS).save(consumer);
        makeSlab(TerraNataBlocks.WOODEN_SLAB, TerraNataBlocks.PLANKS).save(consumer);
        makeFence(TerraNataBlocks.FENCE, TerraNataBlocks.PLANKS).save(consumer);
        makeFenceGate(TerraNataBlocks.FENCE_GATE, TerraNataBlocks.PLANKS).save(consumer);
        makeButton(TerraNataBlocks.WOODEN_BUTTON, TerraNataBlocks.PLANKS).save(consumer);
        makePressurePlate(TerraNataBlocks.WOODEN_PRESSURE_PLATE, TerraNataBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(TerraNataBlocks.STONE_BRICKS, TerraNataBlocks.STONE).save(consumer);
        makeStairs(TerraNataBlocks.STONE_STAIRS, TerraNataBlocks.STONE).save(consumer);
        makeStairs(TerraNataBlocks.COBBLESTONE_STAIRS, TerraNataBlocks.COBBLESTONE).save(consumer);
        makeStairs(TerraNataBlocks.STONE_BRICKS_STAIRS, TerraNataBlocks.STONE_BRICKS).save(consumer);
        makeSlab(TerraNataBlocks.COBBLESTONE_SLAB, TerraNataBlocks.COBBLESTONE).save(consumer);
        makeSlab(TerraNataBlocks.STONE_SLAB, TerraNataBlocks.STONE).save(consumer);
        makeSlab(TerraNataBlocks.STONE_BRICKS_SLAB, TerraNataBlocks.STONE_BRICKS).save(consumer);
        makeWall(TerraNataBlocks.COBBLESTONE_WALL, TerraNataBlocks.COBBLESTONE).save(consumer);
        makeWall(TerraNataBlocks.STONE_BRICKS_WALL, TerraNataBlocks.STONE_BRICKS).save(consumer);
        makeButton(TerraNataBlocks.STONE_BUTTON, TerraNataBlocks.STONE).save(consumer);
        makePressurePlate(TerraNataBlocks.STONE_PRESSURE_PLATE, TerraNataBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(TerraNataBlocks.STONE, TerraNataBlocks.STONE_BRICKS.get()).save(consumer, name("grounded_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(TerraNataBlocks.STONE, TerraNataBlocks.STONE_STAIRS.get()).save(consumer, name("grounded_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(TerraNataBlocks.STONE, TerraNataBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("grounded_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(TerraNataBlocks.STONE, TerraNataBlocks.STONE_SLAB.get(), 2).save(consumer, name("grounded_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(TerraNataBlocks.STONE, TerraNataBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("grounded_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(TerraNataBlocks.STONE_BRICKS, TerraNataBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("grounded_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(TerraNataBlocks.COBBLESTONE, TerraNataBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("grounded_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(TerraNataBlocks.COBBLESTONE, TerraNataBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("grounded_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(TerraNataBlocks.STONE.get(), TerraNataBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_grounded_cobblestone"));
        //Dark
            //Wooden
        makePlanks(ValleyDeathBlocks.PLANKS, ValleyDeathBlocks.LOG).save(consumer);
        makeWood(ValleyDeathBlocks.WOOD, ValleyDeathBlocks.LOG).save(consumer);
        makeStairs(ValleyDeathBlocks.WOODEN_STAIRS, ValleyDeathBlocks.PLANKS).save(consumer);
        makeSlab(ValleyDeathBlocks.WOODEN_SLAB, ValleyDeathBlocks.PLANKS).save(consumer);
        makeFence(ValleyDeathBlocks.FENCE, ValleyDeathBlocks.PLANKS).save(consumer);
        makeFenceGate(ValleyDeathBlocks.FENCE_GATE, ValleyDeathBlocks.PLANKS).save(consumer);
        makeButton(ValleyDeathBlocks.WOODEN_BUTTON, ValleyDeathBlocks.PLANKS).save(consumer);
        makePressurePlate(ValleyDeathBlocks.WOODEN_PRESSURE_PLATE, ValleyDeathBlocks.PLANKS).save(consumer);
            //Stone
        makeBricks(ValleyDeathBlocks.STONE_BRICKS, ValleyDeathBlocks.STONE).save(consumer);
        makeStairs(ValleyDeathBlocks.STONE_STAIRS, ValleyDeathBlocks.STONE).save(consumer);
        makeStairs(ValleyDeathBlocks.COBBLESTONE_STAIRS, ValleyDeathBlocks.COBBLESTONE).save(consumer);
        makeStairs(ValleyDeathBlocks.STONE_BRICKS_STAIRS, ValleyDeathBlocks.STONE_BRICKS).save(consumer);
        makeSlab(ValleyDeathBlocks.COBBLESTONE_SLAB, ValleyDeathBlocks.COBBLESTONE).save(consumer);
        makeSlab(ValleyDeathBlocks.STONE_SLAB, ValleyDeathBlocks.STONE).save(consumer);
        makeSlab(ValleyDeathBlocks.STONE_BRICKS_SLAB, ValleyDeathBlocks.STONE_BRICKS).save(consumer);
        makeWall(ValleyDeathBlocks.COBBLESTONE_WALL, ValleyDeathBlocks.COBBLESTONE).save(consumer);
        makeWall(ValleyDeathBlocks.STONE_BRICKS_WALL, ValleyDeathBlocks.STONE_BRICKS).save(consumer);
        makeButton(ValleyDeathBlocks.STONE_BUTTON, ValleyDeathBlocks.STONE).save(consumer);
        makePressurePlate(ValleyDeathBlocks.STONE_PRESSURE_PLATE, ValleyDeathBlocks.STONE).save(consumer);
        stonecuttingSingleRecipe(ValleyDeathBlocks.STONE, ValleyDeathBlocks.STONE_BRICKS.get()).save(consumer, name("darkened_stone_brick_stonecutting"));
        stonecuttingSingleRecipe(ValleyDeathBlocks.STONE, ValleyDeathBlocks.STONE_STAIRS.get()).save(consumer, name("darkened_stone_stairs_stonecutting"));
        stonecuttingSingleRecipe(ValleyDeathBlocks.STONE, ValleyDeathBlocks.STONE_BRICKS_STAIRS.get()).save(consumer, name("darkened_stone_brick_stairs_stonecutting"));
        stonecuttingMultipleRecipe(ValleyDeathBlocks.STONE, ValleyDeathBlocks.STONE_SLAB.get(), 2).save(consumer, name("darkened_stone_slabs_stonecutting"));
        stonecuttingMultipleRecipe(ValleyDeathBlocks.STONE, ValleyDeathBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("darkened_stone_brick_slabs_stonecutting_stone"));
        stonecuttingMultipleRecipe(ValleyDeathBlocks.STONE_BRICKS, ValleyDeathBlocks.STONE_BRICKS_SLAB.get(), 2).save(consumer, name("darkened_stone_brick_slabs_stonecutting_stone_brick"));
        stonecuttingMultipleRecipe(ValleyDeathBlocks.COBBLESTONE, ValleyDeathBlocks.COBBLESTONE_SLAB.get(), 2).save(consumer, name("darkened_cobblestone_slabs_stonecutting"));
        stonecuttingSingleRecipe(ValleyDeathBlocks.COBBLESTONE, ValleyDeathBlocks.COBBLESTONE_STAIRS.get()).save(consumer, name("darkened_cobblestone_stairs_stonecutting"));
            //Smelting
        smeltingRecipe(ValleyDeathBlocks.STONE.get(), ValleyDeathBlocks.COBBLESTONE.get(), 0.7F).save(consumer, name("smelt_darkened_cobblestone"));
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
