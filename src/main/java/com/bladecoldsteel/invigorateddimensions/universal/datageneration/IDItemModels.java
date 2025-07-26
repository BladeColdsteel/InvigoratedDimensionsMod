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
import com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider.IDItemModelProvider;
import com.bladecoldsteel.invigorateddimensions.universal.item.UniversalItems;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class IDItemModels extends IDItemModelProvider {
    public IDItemModels(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, fileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Invigorated Dimensions Item Models";
    }

    @Override
    protected void registerModels() {
        //Torch

        //Planks
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
        itemBlock(CavernousCoveBlocks.PLANKS);
        itemBlock(HeavenlyRealmBlocks.PLANKS);
        itemBlock(CorrosiveFieldsBlocks.PLANKS);
        itemBlock(DeepTundraBlocks.PLANKS);
        //Logs
        itemBlock(InsectoidParadisioBlocks.BUGGED_LOG);
        itemBlock(ValleyDeathBlocks.DARKENED_LOG);
        itemBlock(DraconicRiftBlocks.DRACONIC_LOG);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG);
        itemBlock(FeywildExpanseBlocks.FEYAN_LOG);
        itemBlock(InfiniteDungeonBlocks.TOUGH_LOG);
        itemBlock(EmberwildsBlocks.EMBERED_LOG);
        itemBlock(HeavenlyRealmBlocks.LOG);
        itemBlock(GhastlyMarshBlocks.SPOOKY_LOG);
        itemBlock(GrassyKnollBlocks.GRASSY_LOG);
        itemBlock(TerraNataBlocks.GROUNDED_LOG);
        itemBlock(DeepTundraBlocks.LOG);
        itemBlock(CorrosiveFieldsBlocks.LOG);
        itemBlock(DreamlandBlocks.PSYCHEDELIC_LOG);
        itemBlock(CavernousCoveBlocks.LOG);
        itemBlock(MetallicMountainsBlocks.METALLIC_LOG);
        itemBlock(WateryDepthsBlocks.WATERY_LOG);
        //Wood
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD);
        itemBlock(CavernousCoveBlocks.WOOD);
        itemBlock(HeavenlyRealmBlocks.WOOD);
        itemBlock(CorrosiveFieldsBlocks.WOOD);
        itemBlock(DeepTundraBlocks.WOOD);
        //Stripped Logs
        itemBlock(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
        //Stripped Wood
        itemBlock(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
        //Stone
        itemBlock(InsectoidParadisioBlocks.BUGGED_STONE);
        itemBlock(ValleyDeathBlocks.DARKENED_STONE);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        itemBlock(FeywildExpanseBlocks.FEYAN_STONE);
        itemBlock(InfiniteDungeonBlocks.TOUGH_STONE);
        itemBlock(HeavenlyRealmBlocks.STONE);
        itemBlock(GhastlyMarshBlocks.SPOOKY_STONE);
        itemBlock(GrassyKnollBlocks.GRASSY_STONE);
        itemBlock(TerraNataBlocks.GROUNDED_STONE);
        itemBlock(DeepTundraBlocks.STONE);
        itemBlock(CorrosiveFieldsBlocks.STONE);
        itemBlock(DreamlandBlocks.PSYCHEDELIC_STONE);
        itemBlock(CavernousCoveBlocks.STONE);
        itemBlock(MetallicMountainsBlocks.METALLIC_STONE);
        itemBlock(WateryDepthsBlocks.WATERY_STONE);
        //Cobblestone
        itemBlock(InsectoidParadisioBlocks.BUGGED_COBBLESTONE);
        itemBlock(ValleyDeathBlocks.DARKENED_COBBLESTONE);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        itemBlock(FeywildExpanseBlocks.FEYAN_COBBLESTONE);
        itemBlock(InfiniteDungeonBlocks.TOUGH_COBBLESTONE);
        itemBlock(HeavenlyRealmBlocks.COBBLESTONE);
        itemBlock(GhastlyMarshBlocks.SPOOKY_COBBLESTONE);
        itemBlock(GrassyKnollBlocks.GRASSY_COBBLESTONE);
        itemBlock(TerraNataBlocks.GROUNDED_COBBLESTONE);
        itemBlock(DeepTundraBlocks.COBBLESTONE);
        itemBlock(CorrosiveFieldsBlocks.COBBLESTONE);
        itemBlock(DreamlandBlocks.PSYCHEDELIC_COBBLESTONE);
        itemBlock(CavernousCoveBlocks.COBBLESTONE);
        itemBlock(MetallicMountainsBlocks.METALLIC_COBBLESTONE);
        itemBlock(WateryDepthsBlocks.WATERY_COBBLESTONE);
        //Stone Bricks
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        itemBlock(CavernousCoveBlocks.STONE_BRICKS);
        itemBlock(HeavenlyRealmBlocks.STONE_BRICKS);
        itemBlock(CorrosiveFieldsBlocks.STONE_BRICKS);
        itemBlock(DeepTundraBlocks.STONE_BRICKS);
        //Chiseled Stone Bricks
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
        //Walls
        wallInventory("electrically_charged_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/electrically_charged_cobblestone"));
        wallInventory("electrically_charged_stone_brick_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/electrically_charged_stone_bricks"));
        wallInventory("rocky_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/rocky_cobblestone"));
        wallInventory("rocky_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/rocky_stone_bricks"));
        wallInventory("floating_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/floating_cobblestone"));
        wallInventory("floating_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/floating_stone_bricks"));
        wallInventory("corrosive_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/corrosive_cobblestone"));
        wallInventory("corrosive_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/corrosive_stone_bricks"));
        wallInventory("icey_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/icey_cobblestone"));
        wallInventory("icey_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/icey_stone_bricks"));
        //Fences
        itemFence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, "electrically_charged_planks");
        itemFence(CavernousCoveBlocks.FENCE, "rocky_planks");
        itemFence(HeavenlyRealmBlocks.FENCE, "floating_planks");
        itemFence(CorrosiveFieldsBlocks.FENCE, "corrosive_planks");
        itemFence(DeepTundraBlocks.FENCE, "icey_planks");
        //Fence Gates
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE);
        itemBlock(CavernousCoveBlocks.FENCE_GATE);
        itemBlock(HeavenlyRealmBlocks.FENCE_GATE);
        itemBlock(CorrosiveFieldsBlocks.FENCE_GATE);
        itemBlock(DeepTundraBlocks.FENCE_GATE);
        //Ores
        itemBlock(ElectricHighlandsBlocks.CHARGED_COAL_ORE);
        itemBlock(ElectricHighlandsBlocks.CHARGED_IRON_ORE);
        itemBlock(ElectricHighlandsBlocks.CHARGED_GOLD_ORE);
        itemBlock(ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE);
        itemBlock(ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE);
        itemBlock(ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE);
        //Stairs
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_STAIRS);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_STAIRS);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS);
        itemBlock(CavernousCoveBlocks.WOODEN_STAIRS);
        itemBlock(CavernousCoveBlocks.COBBLESTONE_STAIRS);
        itemBlock(CavernousCoveBlocks.STONE_STAIRS);
        itemBlock(CavernousCoveBlocks.STONE_BRICKS_STAIRS);
        itemBlock(HeavenlyRealmBlocks.WOODEN_STAIRS);
        itemBlock(HeavenlyRealmBlocks.COBBLESTONE_STAIRS);
        itemBlock(HeavenlyRealmBlocks.STONE_STAIRS);
        itemBlock(HeavenlyRealmBlocks.STONE_BRICKS_STAIRS);
        itemBlock(CorrosiveFieldsBlocks.WOODEN_STAIRS);
        itemBlock(CorrosiveFieldsBlocks.COBBLESTONE_STAIRS);
        itemBlock(CorrosiveFieldsBlocks.STONE_STAIRS);
        itemBlock(CorrosiveFieldsBlocks.STONE_BRICKS_STAIRS);
        itemBlock(DeepTundraBlocks.WOODEN_STAIRS);
        itemBlock(DeepTundraBlocks.COBBLESTONE_STAIRS);
        itemBlock(DeepTundraBlocks.STONE_STAIRS);
        itemBlock(DeepTundraBlocks.STONE_BRICKS_STAIRS);
        //Slabs
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_SLAB);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS);
        itemBlock(CavernousCoveBlocks.WOODEN_SLAB);
        itemBlock(CavernousCoveBlocks.COBBLESTONE_SLAB);
        itemBlock(CavernousCoveBlocks.STONE_SLAB);
        itemBlock(CavernousCoveBlocks.STONE_BRICKS_SLAB);
        itemBlock(HeavenlyRealmBlocks.WOODEN_SLAB);
        itemBlock(HeavenlyRealmBlocks.COBBLESTONE_SLAB);
        itemBlock(HeavenlyRealmBlocks.STONE_SLAB);
        itemBlock(HeavenlyRealmBlocks.STONE_BRICKS_SLAB);
        itemBlock(CorrosiveFieldsBlocks.WOODEN_SLAB);
        itemBlock(CorrosiveFieldsBlocks.COBBLESTONE_SLAB);
        itemBlock(CorrosiveFieldsBlocks.STONE_SLAB);
        itemBlock(CorrosiveFieldsBlocks.STONE_BRICKS_SLAB);
        itemBlock(DeepTundraBlocks.WOODEN_SLAB);
        itemBlock(DeepTundraBlocks.COBBLESTONE_SLAB);
        itemBlock(DeepTundraBlocks.STONE_SLAB);
        itemBlock(DeepTundraBlocks.STONE_BRICKS_SLAB);
        //Saplings
        itemBlockFlat(InsectoidParadisioBlocks.BUGGED_SAPLING);
        itemBlockFlat(ValleyDeathBlocks.DARKENED_SAPLING);
        itemBlockFlat(DraconicRiftBlocks.DRACONIC_SAPLING);
        itemBlockFlat(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING);
        itemBlockFlat(FeywildExpanseBlocks.FEYAN_SAPLING);
        itemBlockFlat(EmberwildsBlocks.EMBERED_SAPLING);
        itemBlockFlat(HeavenlyRealmBlocks.SAPLING);
        itemBlockFlat(GhastlyMarshBlocks.SPOOKY_SAPLING);
        itemBlockFlat(GrassyKnollBlocks.GRASSY_SAPLING);
        itemBlockFlat(TerraNataBlocks.GROUNDED_SAPLING);
        itemBlockFlat(DeepTundraBlocks.SAPLING);
        itemBlockFlat(CorrosiveFieldsBlocks.SAPLING);
        itemBlockFlat(DreamlandBlocks.PSYCHEDELIC_SAPLING);
        itemBlockFlat(MetallicMountainsBlocks.METALLIC_SAPLING);
        itemBlockFlat(WateryDepthsBlocks.WATERY_SAPLING);
        //Door
        itemBlockFlat(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR, "electrically_charged_door");
        //Trapdoor
        itemBlockFlat(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR, "electrically_charged_trapdoor");
        //Portal Frame
        itemBlock(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME);
        //Gems
        normalItem(ElectricHighlandsItems.VOLTCRYST);
        //Ingots

        //Portal Activators
        normalItem(ElectricHighlandsItems.ELECTRIC_HIGHLANDS_ACTIVATOR);
        //Essences
        normalItem(UniversalItems.BASE_ESSENCE);
        normalItem(UniversalItems.BUG_ESSENCE);
        normalItem(UniversalItems.DARK_ESSENCE);
        normalItem(UniversalItems.DRAGON_ESSENCE);
        normalItem(UniversalItems.ELECTRIC_ESSENCE);
        normalItem(UniversalItems.FAIRY_ESSENCE);
        normalItem(UniversalItems.FIGHTING_ESSENCE);
        normalItem(UniversalItems.FIRE_ESSENCE);
        normalItem(UniversalItems.FLYING_ESSENCE);
        normalItem(UniversalItems.GHOST_ESSENCE);
        normalItem(UniversalItems.GRASS_ESSENCE);
        normalItem(UniversalItems.GROUND_ESSENCE);
        normalItem(UniversalItems.ICE_ESSENCE);
        normalItem(UniversalItems.POISON_ESSENCE);
        normalItem(UniversalItems.PSYCHIC_ESSENCE);
        normalItem(UniversalItems.ROCK_ESSENCE);
        normalItem(UniversalItems.STEEL_ESSENCE);
        normalItem(UniversalItems.WATER_ESSENCE);
        normalItem(UniversalItems.NORMAL_ESSENCE);
        //Sword

        //Pickaxe

        //Axe

        //Shovel

        //Hoe

        //Helmet

        //Chestplate

        //Leggings

        //Boots

        //Signs
        sign(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN);
        //Spawn Eggs
    }
}
