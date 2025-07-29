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
        itemBlock(DraconicRiftBlocks.PLANKS);
        itemBlock(DreamlandBlocks.PLANKS);
        itemBlock(EmberwildsBlocks.PLANKS);
        itemBlock(FeywildExpanseBlocks.PLANKS);
        itemBlock(GhastlyMarshBlocks.PLANKS);
        itemBlock(GrassyKnollBlocks.PLANKS);
        itemBlock(InfiniteDungeonBlocks.PLANKS);
        itemBlock(InsectoidParadisioBlocks.PLANKS);
        itemBlock(MetallicMountainsBlocks.PLANKS);
        //Logs
        itemBlock(InsectoidParadisioBlocks.LOG);
        itemBlock(ValleyDeathBlocks.DARKENED_LOG);
        itemBlock(DraconicRiftBlocks.LOG);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG);
        itemBlock(FeywildExpanseBlocks.LOG);
        itemBlock(InfiniteDungeonBlocks.LOG);
        itemBlock(EmberwildsBlocks.LOG);
        itemBlock(HeavenlyRealmBlocks.LOG);
        itemBlock(GhastlyMarshBlocks.LOG);
        itemBlock(GrassyKnollBlocks.LOG);
        itemBlock(TerraNataBlocks.GROUNDED_LOG);
        itemBlock(DeepTundraBlocks.LOG);
        itemBlock(CorrosiveFieldsBlocks.LOG);
        itemBlock(DreamlandBlocks.LOG);
        itemBlock(CavernousCoveBlocks.LOG);
        itemBlock(MetallicMountainsBlocks.LOG);
        itemBlock(WateryDepthsBlocks.WATERY_LOG);
        //Wood
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD);
        itemBlock(CavernousCoveBlocks.WOOD);
        itemBlock(HeavenlyRealmBlocks.WOOD);
        itemBlock(CorrosiveFieldsBlocks.WOOD);
        itemBlock(DeepTundraBlocks.WOOD);
        itemBlock(DraconicRiftBlocks.WOOD);
        itemBlock(DreamlandBlocks.WOOD);
        itemBlock(EmberwildsBlocks.WOOD);
        itemBlock(FeywildExpanseBlocks.WOOD);
        itemBlock(GhastlyMarshBlocks.WOOD);
        itemBlock(GrassyKnollBlocks.WOOD);
        itemBlock(InfiniteDungeonBlocks.WOOD);
        itemBlock(InsectoidParadisioBlocks.WOOD);
        itemBlock(MetallicMountainsBlocks.WOOD);
        //Stripped Logs
        itemBlock(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
        //Stripped Wood
        itemBlock(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
        //Stone
        itemBlock(InsectoidParadisioBlocks.STONE);
        itemBlock(ValleyDeathBlocks.DARKENED_STONE);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE);
        itemBlock(FeywildExpanseBlocks.STONE);
        itemBlock(InfiniteDungeonBlocks.STONE);
        itemBlock(HeavenlyRealmBlocks.STONE);
        itemBlock(GhastlyMarshBlocks.STONE);
        itemBlock(GrassyKnollBlocks.STONE);
        itemBlock(TerraNataBlocks.GROUNDED_STONE);
        itemBlock(DeepTundraBlocks.STONE);
        itemBlock(CorrosiveFieldsBlocks.STONE);
        itemBlock(DreamlandBlocks.STONE);
        itemBlock(CavernousCoveBlocks.STONE);
        itemBlock(MetallicMountainsBlocks.STONE);
        itemBlock(WateryDepthsBlocks.WATERY_STONE);
        //Cobblestone
        itemBlock(InsectoidParadisioBlocks.COBBLESTONE);
        itemBlock(ValleyDeathBlocks.DARKENED_COBBLESTONE);
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
        itemBlock(FeywildExpanseBlocks.COBBLESTONE);
        itemBlock(InfiniteDungeonBlocks.COBBLESTONE);
        itemBlock(HeavenlyRealmBlocks.COBBLESTONE);
        itemBlock(GhastlyMarshBlocks.COBBLESTONE);
        itemBlock(GrassyKnollBlocks.COBBLESTONE);
        itemBlock(TerraNataBlocks.GROUNDED_COBBLESTONE);
        itemBlock(DeepTundraBlocks.COBBLESTONE);
        itemBlock(CorrosiveFieldsBlocks.COBBLESTONE);
        itemBlock(DreamlandBlocks.COBBLESTONE);
        itemBlock(CavernousCoveBlocks.COBBLESTONE);
        itemBlock(MetallicMountainsBlocks.COBBLESTONE);
        itemBlock(WateryDepthsBlocks.WATERY_COBBLESTONE);
        //Stone Bricks
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
        itemBlock(CavernousCoveBlocks.STONE_BRICKS);
        itemBlock(HeavenlyRealmBlocks.STONE_BRICKS);
        itemBlock(CorrosiveFieldsBlocks.STONE_BRICKS);
        itemBlock(DeepTundraBlocks.STONE_BRICKS);
        itemBlock(DreamlandBlocks.STONE_BRICKS);
        itemBlock(FeywildExpanseBlocks.STONE_BRICKS);
        itemBlock(GhastlyMarshBlocks.STONE_BRICKS);
        itemBlock(GrassyKnollBlocks.STONE_BRICKS);
        itemBlock(InfiniteDungeonBlocks.STONE_BRICKS);
        itemBlock(InsectoidParadisioBlocks.STONE_BRICKS);
        itemBlock(MetallicMountainsBlocks.STONE_BRICKS);
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
        wallInventory("psychedelic_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/psychedelic_cobblestone"));
        wallInventory("psychedelic_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/psychedelic_stone_bricks"));
        wallInventory("feyan_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/feyan_cobblestone"));
        wallInventory("feyan_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/feyan_stone_bricks"));
        wallInventory("spooky_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/spooky_cobblestone"));
        wallInventory("spooky_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/spooky_stone_bricks"));
        wallInventory("grassy_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/grassy_cobblestone"));
        wallInventory("grassy_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/grassy_stone_bricks"));
        wallInventory("tough_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/tough_cobblestone"));
        wallInventory("tough_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/tough_stone_bricks"));
        wallInventory("bugged_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/bugged_cobblestone"));
        wallInventory("bugged_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/bugged_stone_bricks"));
        wallInventory("metallic_cobblestone_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/metallic_cobblestone"));
        wallInventory("metallic_stone_bricks_wall", new ResourceLocation(InvigoratedDimensions.MOD_ID, "block/metallic_stone_bricks"));
        //Fences
        itemFence(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE, "electrically_charged_planks");
        itemFence(CavernousCoveBlocks.FENCE, "rocky_planks");
        itemFence(HeavenlyRealmBlocks.FENCE, "floating_planks");
        itemFence(CorrosiveFieldsBlocks.FENCE, "corrosive_planks");
        itemFence(DeepTundraBlocks.FENCE, "icey_planks");
        itemFence(DraconicRiftBlocks.FENCE, "draconic_planks");
        itemFence(DreamlandBlocks.FENCE, "psychedelic_planks");
        itemFence(EmberwildsBlocks.FENCE, "embered_planks");
        itemFence(FeywildExpanseBlocks.FENCE, "feyan_planks");
        itemFence(GhastlyMarshBlocks.FENCE, "spooky_planks");
        itemFence(GrassyKnollBlocks.FENCE, "grassy_planks");
        itemFence(InfiniteDungeonBlocks.FENCE, "tough_planks");
        itemFence(InsectoidParadisioBlocks.FENCE, "bugged_planks");
        itemFence(MetallicMountainsBlocks.FENCE, "metallic_planks");
        //Fence Gates
        itemBlock(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE);
        itemBlock(CavernousCoveBlocks.FENCE_GATE);
        itemBlock(HeavenlyRealmBlocks.FENCE_GATE);
        itemBlock(CorrosiveFieldsBlocks.FENCE_GATE);
        itemBlock(DeepTundraBlocks.FENCE_GATE);
        itemBlock(DraconicRiftBlocks.FENCE_GATE);
        itemBlock(DreamlandBlocks.FENCE_GATE);
        itemBlock(EmberwildsBlocks.FENCE_GATE);
        itemBlock(FeywildExpanseBlocks.FENCE_GATE);
        itemBlock(GhastlyMarshBlocks.FENCE_GATE);
        itemBlock(GrassyKnollBlocks.FENCE_GATE);
        itemBlock(InfiniteDungeonBlocks.FENCE_GATE);
        itemBlock(InsectoidParadisioBlocks.FENCE_GATE);
        itemBlock(MetallicMountainsBlocks.FENCE_GATE);
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
        itemBlock(DraconicRiftBlocks.WOODEN_STAIRS);
        itemBlock(DreamlandBlocks.WOODEN_STAIRS);
        itemBlock(DreamlandBlocks.COBBLESTONE_STAIRS);
        itemBlock(DreamlandBlocks.STONE_STAIRS);
        itemBlock(DreamlandBlocks.STONE_BRICKS_STAIRS);
        itemBlock(EmberwildsBlocks.WOODEN_STAIRS);
        itemBlock(FeywildExpanseBlocks.WOODEN_STAIRS);
        itemBlock(FeywildExpanseBlocks.COBBLESTONE_STAIRS);
        itemBlock(FeywildExpanseBlocks.STONE_STAIRS);
        itemBlock(FeywildExpanseBlocks.STONE_BRICKS_STAIRS);
        itemBlock(GhastlyMarshBlocks.WOODEN_STAIRS);
        itemBlock(GhastlyMarshBlocks.COBBLESTONE_STAIRS);
        itemBlock(GhastlyMarshBlocks.STONE_STAIRS);
        itemBlock(GhastlyMarshBlocks.STONE_BRICKS_STAIRS);
        itemBlock(GrassyKnollBlocks.WOODEN_STAIRS);
        itemBlock(GrassyKnollBlocks.COBBLESTONE_STAIRS);
        itemBlock(GrassyKnollBlocks.STONE_STAIRS);
        itemBlock(GrassyKnollBlocks.STONE_BRICKS_STAIRS);
        itemBlock(InfiniteDungeonBlocks.WOODEN_STAIRS);
        itemBlock(InfiniteDungeonBlocks.COBBLESTONE_STAIRS);
        itemBlock(InfiniteDungeonBlocks.STONE_STAIRS);
        itemBlock(InfiniteDungeonBlocks.STONE_BRICKS_STAIRS);
        itemBlock(InsectoidParadisioBlocks.WOODEN_STAIRS);
        itemBlock(InsectoidParadisioBlocks.COBBLESTONE_STAIRS);
        itemBlock(InsectoidParadisioBlocks.STONE_STAIRS);
        itemBlock(InsectoidParadisioBlocks.STONE_BRICKS_STAIRS);
        itemBlock(MetallicMountainsBlocks.WOODEN_STAIRS);
        itemBlock(MetallicMountainsBlocks.COBBLESTONE_STAIRS);
        itemBlock(MetallicMountainsBlocks.STONE_STAIRS);
        itemBlock(MetallicMountainsBlocks.STONE_BRICKS_STAIRS);
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
        itemBlock(DraconicRiftBlocks.WOODEN_SLAB);
        itemBlock(DreamlandBlocks.WOODEN_SLAB);
        itemBlock(DreamlandBlocks.COBBLESTONE_SLAB);
        itemBlock(DreamlandBlocks.STONE_SLAB);
        itemBlock(DreamlandBlocks.STONE_BRICKS_SLAB);
        itemBlock(EmberwildsBlocks.WOODEN_SLAB);
        itemBlock(FeywildExpanseBlocks.WOODEN_SLAB);
        itemBlock(FeywildExpanseBlocks.COBBLESTONE_SLAB);
        itemBlock(FeywildExpanseBlocks.STONE_SLAB);
        itemBlock(FeywildExpanseBlocks.STONE_BRICKS_SLAB);
        itemBlock(GhastlyMarshBlocks.WOODEN_SLAB);
        itemBlock(GhastlyMarshBlocks.COBBLESTONE_SLAB);
        itemBlock(GhastlyMarshBlocks.STONE_SLAB);
        itemBlock(GhastlyMarshBlocks.STONE_BRICKS_SLAB);
        itemBlock(GrassyKnollBlocks.WOODEN_SLAB);
        itemBlock(GrassyKnollBlocks.COBBLESTONE_SLAB);
        itemBlock(GrassyKnollBlocks.STONE_SLAB);
        itemBlock(GrassyKnollBlocks.STONE_BRICKS_SLAB);
        itemBlock(InfiniteDungeonBlocks.WOODEN_SLAB);
        itemBlock(InfiniteDungeonBlocks.COBBLESTONE_SLAB);
        itemBlock(InfiniteDungeonBlocks.STONE_SLAB);
        itemBlock(InfiniteDungeonBlocks.STONE_BRICKS_SLAB);
        itemBlock(InsectoidParadisioBlocks.WOODEN_SLAB);
        itemBlock(InsectoidParadisioBlocks.COBBLESTONE_SLAB);
        itemBlock(InsectoidParadisioBlocks.STONE_SLAB);
        itemBlock(InsectoidParadisioBlocks.STONE_BRICKS_SLAB);
        itemBlock(MetallicMountainsBlocks.WOODEN_SLAB);
        itemBlock(MetallicMountainsBlocks.COBBLESTONE_SLAB);
        itemBlock(MetallicMountainsBlocks.STONE_SLAB);
        itemBlock(MetallicMountainsBlocks.STONE_BRICKS_SLAB);
        //Saplings
        itemBlockFlat(InsectoidParadisioBlocks.SAPLING);
        itemBlockFlat(ValleyDeathBlocks.DARKENED_SAPLING);
        itemBlockFlat(DraconicRiftBlocks.SAPLING);
        itemBlockFlat(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING);
        itemBlockFlat(FeywildExpanseBlocks.SAPLING);
        itemBlockFlat(EmberwildsBlocks.SAPLING);
        itemBlockFlat(HeavenlyRealmBlocks.SAPLING);
        itemBlockFlat(GhastlyMarshBlocks.SAPLING);
        itemBlockFlat(GrassyKnollBlocks.SAPLING);
        itemBlockFlat(TerraNataBlocks.GROUNDED_SAPLING);
        itemBlockFlat(DeepTundraBlocks.SAPLING);
        itemBlockFlat(CorrosiveFieldsBlocks.SAPLING);
        itemBlockFlat(DreamlandBlocks.SAPLING);
        itemBlockFlat(MetallicMountainsBlocks.SAPLING);
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
