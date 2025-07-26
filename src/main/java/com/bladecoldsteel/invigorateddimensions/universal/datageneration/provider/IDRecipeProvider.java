package com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider;

import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class IDRecipeProvider extends RecipeProvider {
    public IDRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    public ShapelessRecipeBuilder makePlanks(Supplier<? extends Block> plankOut, Supplier<? extends Block> logIn) {
        Block obj = logIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(plankOut.get(), 4)
                .requires(obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeDoor(Supplier<? extends Block> doorOut, Supplier<? extends Block> plankIn) {
        Block obj = plankIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(doorOut.get(), 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .define('P', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeTrapdoor(Supplier<? extends Block> trapdoorOut, Supplier<? extends Block> plankIn) {
        Block obj = plankIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(trapdoorOut.get(), 3)
                .pattern("PPP")
                .pattern("PPP")
                .define('P', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapelessRecipeBuilder makeButton(Supplier<? extends Block> buttonOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(buttonOut.get())
                .requires(obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makePressurePlate(Supplier<? extends Block> pressurePlatOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(pressurePlatOut.get())
                .pattern("BB")
                .define('B', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapelessRecipeBuilder makeMinecraftButton(Supplier<? extends Block> buttonOut, Block blockIn) {
        Block obj = blockIn;
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(buttonOut.get())
                .requires(obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeMinecraftPressurePlate(Supplier<? extends Block> pressurePlatOut, Block blockIn) {
        Block obj = blockIn;
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(pressurePlatOut.get())
                .pattern("BB")
                .define('B', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeStairs(Supplier<? extends Block> stairsOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(stairsOut.get(), 4)
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeSlab(Supplier<? extends Block> slabsOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(slabsOut.get(), 6)
                .pattern("MMM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeWall(Supplier<? extends Block> wallsOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(wallsOut.get(), 6)
                .pattern("MMM")
                .pattern("MMM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeFence(Supplier<? extends Block> fencesOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(fencesOut.get(), 6)
                .pattern("M/M")
                .pattern("M/M")
                .define('M', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeFenceGate(Supplier<? extends Block> fenceGatesOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(fenceGatesOut.get())
                .pattern("/M/")
                .pattern("/M/")
                .define('M', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeSticks(Supplier<? extends Block> plankIn) {
        Block obj = plankIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(Items.STICK, 4)
                .pattern("M")
                .pattern("M")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeBricks(Supplier<? extends Block> bricksOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(bricksOut.get(), 4)
                .pattern("MM")
                .pattern("MM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeChiseledBricks(Supplier<? extends Block> bricksOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(bricksOut.get())
                .pattern("M")
                .pattern("M")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeWood(Supplier<? extends Block> woodOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapedRecipeBuilder.shaped(woodOut.get(), 4)
                .pattern("MM")
                .pattern("MM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeIngotToBlock(Supplier<? extends Block> blockOut, Supplier<? extends Item> ingotIn) {
        Item obj = ingotIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(blockOut.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapelessRecipeBuilder makeBlockToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Block> blockIn) {
        Block obj = blockIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Block not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(ingotOut.get(), 9)
                .requires(obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeNuggetToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Item> nuggetIn) {
        Item obj = nuggetIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(ingotOut.get(), 1)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapelessRecipeBuilder makeIngotToNugget(Supplier<? extends Item> nuggetOut, Supplier<? extends Item> ingotIn) {
        Item obj = ingotIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(nuggetOut.get(), 9)
                .requires(obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeSword(Supplier<? extends Item> swordOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(swordOut.get())
                .pattern("#")
                .pattern("#")
                .pattern("/")
                .define('#', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makePickaxe(Supplier<? extends Item> pickaxeOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(pickaxeOut.get())
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeAxe(Supplier<? extends Item> axeOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(axeOut.get())
                .pattern("##")
                .pattern("#/")
                .pattern(" /")
                .define('#', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeShovel(Supplier<? extends Item> shovelOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(shovelOut.get())
                .pattern("#")
                .pattern("/")
                .pattern("/")
                .define('#', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeHoe(Supplier<? extends Item> hoeOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(hoeOut.get())
                .pattern("##")
                .pattern(" /")
                .pattern(" /")
                .define('#', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeHelmet(Supplier<? extends Item> helmetOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(helmetOut.get())
                .pattern("MMM")
                .pattern("M M")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeChestplate(Supplier<? extends Item> chestplateOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(chestplateOut.get())
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeLeggings(Supplier<? extends Item> leggingsOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(leggingsOut.get())
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeBoots(Supplier<? extends Item> bootsOut, Supplier<? extends Item> materialIn) {
        Item obj = materialIn.get();
        ResourceLocation reg = ForgeRegistries.ITEMS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(bootsOut.get())
                .pattern("M M")
                .pattern("M M")
                .define('M', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapelessRecipeBuilder makeStew(Supplier<? extends Item> stewOut, Supplier<? extends Block> mushroomIn) {
        Block obj = mushroomIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapelessRecipeBuilder.shapeless(stewOut.get())
                .requires(Items.BOWL)
                .requires(obj, 3)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeBoat(Supplier<? extends Item> boatOut, Supplier<? extends Block> planksIn) {
        Block obj = planksIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(boatOut.get())
                .pattern("P P")
                .pattern("PPP")
                .define('P', obj)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public ShapedRecipeBuilder makeSign(Supplier<? extends Block> signOut, Supplier<? extends Block> planksIn) {
        Block obj = planksIn.get();
        ResourceLocation reg = ForgeRegistries.BLOCKS.getKey(obj);
        if (reg == null) throw new IllegalStateException("Item not registered: " + obj);
        return ShapedRecipeBuilder.shaped(signOut.get(), 3)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .define('P', obj)
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + reg.getPath(), has(obj));
    }

    public CookingRecipeBuilder smeltingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return smeltingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder smeltingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(ingredient, count)), result, exp, 200)
                .unlockedBy("has_" + ingredient.asItem().getRegistryName(), has(ingredient));
    }

    public CookingRecipeBuilder smeltingRecipeTag(IItemProvider result, IItemProvider ingredient, float exp) {
        return smeltingRecipeTag(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder smeltingRecipeTag(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, exp, 200)
                .unlockedBy("has_" + ingredient, has(ingredient));
    }

    public CookingRecipeBuilder blastingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return blastingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder blastingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(ingredient, count)), result, exp, 100)
                .unlockedBy("has_" + ingredient.asItem().getRegistryName(), has(ingredient));
    }

    public CookingRecipeBuilder blastingRecipeTag(IItemProvider result, IItemProvider ingredient, float exp) {
        return blastingRecipeTag(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder blastingRecipeTag(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, exp, 100)
                .unlockedBy("has_" + ingredient, has(ingredient));
    }

    public CookingRecipeBuilder smokingRecipe(IItemProvider result, IItemProvider ingredient, float exp) {
        return smokingRecipe(result, ingredient, exp, 1);
    }

    public CookingRecipeBuilder smokingRecipe(IItemProvider result, IItemProvider ingredient, float exp, int count) {
        return CookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(ingredient, count)), result, exp, 100)
                .unlockedBy("has_" + ingredient.asItem().getRegistryName(), has(ingredient));
    }

    public SmithingRecipeBuilder smithingRecipe(Supplier<Item> input, Supplier<Item> upgradeItem, Supplier<Item> result) {
        return SmithingRecipeBuilder.smithing(Ingredient.of(input.get()), Ingredient.of(upgradeItem.get()), result.get())
                .unlocks("has_" + upgradeItem.get().getRegistryName(), has(upgradeItem.get()));
    }

    public SingleItemRecipeBuilder stonecuttingSingleRecipe(Supplier<Block> input, IItemProvider result) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input.get()), result)
                .unlocks("has_" + input.get().getRegistryName(), has(input.get()));
    }

    public SingleItemRecipeBuilder stonecuttingMultipleRecipe(Supplier<Block> input, IItemProvider result, int resultAmount) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input.get()), result, resultAmount)
                .unlocks("has_" + input.get().getRegistryName(), has(input.get()));
    }
}
