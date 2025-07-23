package com.bladecoldsteel.invigorateddimensions.universal.datageneration;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider.IDRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
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

            //Stone

            //Smelting

        //Flying
            //Wooden

            //Stone

            //Smelting

        //Poison
            //Wooden

            //Stone

            //Smelting

        //Ice
            //Wooden

            //Stone

            //Smelting

        //Dragon
            //Wooden

            //Stone

            //Smelting

        //Psychic
            //Wooden

            //Stone

            //Smelting

        //Electric
            //Wooden
        makePlanks(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeWood(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeWood(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD, ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG).save(consumer);
        makeSign(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
        makeSticks(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS).save(consumer);
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

        //Ghost
            //Wooden

            //Stone

            //Smelting

        //Grass
            //Wooden

            //Stone

            //Smelting

        //Fighting
            //Wooden

            //Stone

            //Smelting

        //Bug
            //Wooden

            //Stone

            //Smelting

        //Steel
            //Wooden

            //Stone

            //Smelting

        //Ground
            //Wooden

            //Stone

            //Smelting

        //Dark
            //Wooden

            //Stone

            //Smelting

        //Water
            //Wooden

            //Stone

            //Smelting

    }

    private ResourceLocation name(String name) {
        return new ResourceLocation(InvigoratedDimensions.MOD_ID, name);
    }
}
