package com.bladecoldsteel.invigorateddimensions.universal.datageneration;

import com.bladecoldsteel.invigorateddimensions.cavernouscove.block.CavernousCoveBlocks;
import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.bladecoldsteel.invigorateddimensions.corrosivefields.block.CorrosiveFieldsBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.draconicrift.block.DraconicRiftBlocks;
import com.bladecoldsteel.invigorateddimensions.dreamland.block.DreamlandBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.ElectricHighlandsEntityTypes;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.ElectricHighlandsItems;
import com.bladecoldsteel.invigorateddimensions.emberwilds.block.EmberwildsBlocks;
import com.bladecoldsteel.invigorateddimensions.feywildexpanse.block.FeywildExpanseBlocks;
import com.bladecoldsteel.invigorateddimensions.ghastlymarsh.block.GhastlyMarshBlocks;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.metallicmountains.block.MetallicMountainsBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider.IDBlockLootTableProvider;
import com.bladecoldsteel.invigorateddimensions.valleydeath.block.ValleyDeathBlocks;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.KilledByPlayer;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IDLootTables extends LootTableProvider {
    private static final ILootCondition.IBuilder SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final Set<Item> IMMUNE_TO_EXPLOSIONS = Stream.of(net.minecraft.block.Blocks.DRAGON_EGG, net.minecraft.block.Blocks.BEACON, net.minecraft.block.Blocks.CONDUIT, net.minecraft.block.Blocks.SKELETON_SKULL, net.minecraft.block.Blocks.WITHER_SKELETON_SKULL, net.minecraft.block.Blocks.PLAYER_HEAD, net.minecraft.block.Blocks.ZOMBIE_HEAD, net.minecraft.block.Blocks.CREEPER_HEAD, net.minecraft.block.Blocks.DRAGON_HEAD, net.minecraft.block.Blocks.SHULKER_BOX, net.minecraft.block.Blocks.BLACK_SHULKER_BOX, net.minecraft.block.Blocks.BLUE_SHULKER_BOX, net.minecraft.block.Blocks.BROWN_SHULKER_BOX, net.minecraft.block.Blocks.CYAN_SHULKER_BOX, net.minecraft.block.Blocks.GRAY_SHULKER_BOX, net.minecraft.block.Blocks.GREEN_SHULKER_BOX, net.minecraft.block.Blocks.LIGHT_BLUE_SHULKER_BOX, net.minecraft.block.Blocks.LIGHT_GRAY_SHULKER_BOX, net.minecraft.block.Blocks.LIME_SHULKER_BOX, net.minecraft.block.Blocks.MAGENTA_SHULKER_BOX, net.minecraft.block.Blocks.ORANGE_SHULKER_BOX, net.minecraft.block.Blocks.PINK_SHULKER_BOX, net.minecraft.block.Blocks.PURPLE_SHULKER_BOX, net.minecraft.block.Blocks.RED_SHULKER_BOX, net.minecraft.block.Blocks.WHITE_SHULKER_BOX, net.minecraft.block.Blocks.YELLOW_SHULKER_BOX).map(IItemProvider::asItem).collect(ImmutableSet.toImmutableSet());
    private static final float[] DEFEAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public IDLootTables(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getName() {
        return "Invigorated Dimensions LootTables";
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
    return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK), Pair.of(Entities::new, LootParameterSets.ENTITY));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationTracker) {
    }

    public static class Blocks extends IDBlockLootTableProvider {
        @Override
        protected void addTables() {
            //Rock
                //Wood
            dropSelf(CavernousCoveBlocks.LOG);
            dropSelf(CavernousCoveBlocks.PLANKS);
            //dropSelf(CavernousCoveBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(CavernousCoveBlocks.WOODEN_BUTTON);
            dropSelf(CavernousCoveBlocks.WOODEN_STAIRS);
            slab(CavernousCoveBlocks.WOODEN_SLAB);
            dropSelf(CavernousCoveBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(CavernousCoveBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(CavernousCoveBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(CavernousCoveBlocks.WOOD);
            //dropSelf(CavernousCoveBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(CavernousCoveBlocks.FENCE);
            dropSelf(CavernousCoveBlocks.FENCE_GATE);
            //dropSelf(CavernousCoveBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(CavernousCoveBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(CavernousCoveBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, CavernousCoveBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(CavernousCoveBlocks.COBBLESTONE);
            dropSelf(CavernousCoveBlocks.COBBLESTONE_WALL);
            dropSelf(CavernousCoveBlocks.COBBLESTONE_STAIRS);
            slab(CavernousCoveBlocks.COBBLESTONE_SLAB);
            dropSelf(CavernousCoveBlocks.STONE_BRICKS);
            slab(CavernousCoveBlocks.STONE_BRICKS_SLAB);
            dropSelf(CavernousCoveBlocks.STONE_BRICKS_STAIRS);
            dropSelf(CavernousCoveBlocks.STONE_BRICKS_WALL);
            //dropSelf(CavernousCoveBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(CavernousCoveBlocks.STONE_SLAB);
            dropSelf(CavernousCoveBlocks.STONE_STAIRS);
            dropSelf(CavernousCoveBlocks.STONE_BUTTON);
            dropSelf(CavernousCoveBlocks.STONE_PRESSURE_PLATE);
            dropOther(CavernousCoveBlocks.STONE, CavernousCoveBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(CavernousCoveBlocks.PORTAL_FRAME);
            dropNothing(CavernousCoveBlocks.PORTAL);
            //Flying
                //Wood
            dropSelf(HeavenlyRealmBlocks.LOG);
            dropSelf(HeavenlyRealmBlocks.PLANKS);
            //dropSelf(HeavenlyRealmBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(HeavenlyRealmBlocks.WOODEN_BUTTON);
            dropSelf(HeavenlyRealmBlocks.WOODEN_STAIRS);
            slab(HeavenlyRealmBlocks.WOODEN_SLAB);
            dropSelf(HeavenlyRealmBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(HeavenlyRealmBlocks.WOOD);
            //dropSelf(HeavenlyRealmBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(HeavenlyRealmBlocks.FENCE);
            dropSelf(HeavenlyRealmBlocks.FENCE_GATE);
            //dropSelf(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(HeavenlyRealmBlocks.COBBLESTONE);
            dropSelf(HeavenlyRealmBlocks.COBBLESTONE_WALL);
            dropSelf(HeavenlyRealmBlocks.COBBLESTONE_STAIRS);
            slab(HeavenlyRealmBlocks.COBBLESTONE_SLAB);
            dropSelf(HeavenlyRealmBlocks.STONE_BRICKS);
            slab(HeavenlyRealmBlocks.STONE_BRICKS_SLAB);
            dropSelf(HeavenlyRealmBlocks.STONE_BRICKS_STAIRS);
            dropSelf(HeavenlyRealmBlocks.STONE_BRICKS_WALL);
            //dropSelf(HeavenlyRealmBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(HeavenlyRealmBlocks.STONE_SLAB);
            dropSelf(HeavenlyRealmBlocks.STONE_STAIRS);
            dropSelf(HeavenlyRealmBlocks.STONE_BUTTON);
            dropSelf(HeavenlyRealmBlocks.STONE_PRESSURE_PLATE);
            dropOther(HeavenlyRealmBlocks.STONE, HeavenlyRealmBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(HeavenlyRealmBlocks.SAPLING);
            dropSelf(HeavenlyRealmBlocks.PORTAL_FRAME);
            dropNothing(HeavenlyRealmBlocks.PORTAL);
            //Poison
                //Wood
            dropSelf(CorrosiveFieldsBlocks.LOG);
            dropSelf(CorrosiveFieldsBlocks.PLANKS);
            //dropSelf(CorrosiveFieldsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(CorrosiveFieldsBlocks.WOODEN_BUTTON);
            dropSelf(CorrosiveFieldsBlocks.WOODEN_STAIRS);
            slab(CorrosiveFieldsBlocks.WOODEN_SLAB);
            dropSelf(CorrosiveFieldsBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(CorrosiveFieldsBlocks.WOOD);
            //dropSelf(CorrosiveFieldsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(CorrosiveFieldsBlocks.FENCE);
            dropSelf(CorrosiveFieldsBlocks.FENCE_GATE);
            //dropSelf(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(CorrosiveFieldsBlocks.COBBLESTONE);
            dropSelf(CorrosiveFieldsBlocks.COBBLESTONE_WALL);
            dropSelf(CorrosiveFieldsBlocks.COBBLESTONE_STAIRS);
            slab(CorrosiveFieldsBlocks.COBBLESTONE_SLAB);
            dropSelf(CorrosiveFieldsBlocks.STONE_BRICKS);
            slab(CorrosiveFieldsBlocks.STONE_BRICKS_SLAB);
            dropSelf(CorrosiveFieldsBlocks.STONE_BRICKS_STAIRS);
            dropSelf(CorrosiveFieldsBlocks.STONE_BRICKS_WALL);
            //dropSelf(CorrosiveFieldsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(CorrosiveFieldsBlocks.STONE_SLAB);
            dropSelf(CorrosiveFieldsBlocks.STONE_STAIRS);
            dropSelf(CorrosiveFieldsBlocks.STONE_BUTTON);
            dropSelf(CorrosiveFieldsBlocks.STONE_PRESSURE_PLATE);
            dropOther(CorrosiveFieldsBlocks.STONE, CorrosiveFieldsBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(CorrosiveFieldsBlocks.SAPLING);
            dropSelf(CorrosiveFieldsBlocks.PORTAL_FRAME);
            dropNothing(CorrosiveFieldsBlocks.PORTAL);
            //Ice
                //Wood
            dropSelf(DeepTundraBlocks.LOG);
            dropSelf(DeepTundraBlocks.PLANKS);
            //dropSelf(DeepTundraBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(DeepTundraBlocks.WOODEN_BUTTON);
            dropSelf(DeepTundraBlocks.WOODEN_STAIRS);
            slab(DeepTundraBlocks.WOODEN_SLAB);
            dropSelf(DeepTundraBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(DeepTundraBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(DeepTundraBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(DeepTundraBlocks.WOOD);
            //dropSelf(DeepTundraBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(DeepTundraBlocks.FENCE);
            dropSelf(DeepTundraBlocks.FENCE_GATE);
            //dropSelf(DeepTundraBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(DeepTundraBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(DeepTundraBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, DeepTundraBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(DeepTundraBlocks.COBBLESTONE);
            dropSelf(DeepTundraBlocks.COBBLESTONE_WALL);
            dropSelf(DeepTundraBlocks.COBBLESTONE_STAIRS);
            slab(DeepTundraBlocks.COBBLESTONE_SLAB);
            dropSelf(DeepTundraBlocks.STONE_BRICKS);
            slab(DeepTundraBlocks.STONE_BRICKS_SLAB);
            dropSelf(DeepTundraBlocks.STONE_BRICKS_STAIRS);
            dropSelf(DeepTundraBlocks.STONE_BRICKS_WALL);
            //dropSelf(DeepTundraBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(DeepTundraBlocks.STONE_SLAB);
            dropSelf(DeepTundraBlocks.STONE_STAIRS);
            dropSelf(DeepTundraBlocks.STONE_BUTTON);
            dropSelf(DeepTundraBlocks.STONE_PRESSURE_PLATE);
            dropOther(DeepTundraBlocks.STONE, DeepTundraBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(DeepTundraBlocks.SAPLING);
            dropSelf(DeepTundraBlocks.PORTAL_FRAME);
            dropNothing(DeepTundraBlocks.PORTAL);
            //Dragon
                //Wood
            dropSelf(DraconicRiftBlocks.LOG);
            dropSelf(DraconicRiftBlocks.PLANKS);
            //dropSelf(DraconicRiftBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(DraconicRiftBlocks.WOODEN_BUTTON);
            dropSelf(DraconicRiftBlocks.WOODEN_STAIRS);
            slab(DraconicRiftBlocks.WOODEN_SLAB);
            dropSelf(DraconicRiftBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(DraconicRiftBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(DraconicRiftBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(DraconicRiftBlocks.WOOD);
            //dropSelf(DraconicRiftBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(DraconicRiftBlocks.FENCE);
            dropSelf(DraconicRiftBlocks.FENCE_GATE);
            //dropSelf(DraconicRiftBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(DraconicRiftBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(DraconicRiftBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, DraconicRiftBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            //dropSelf(DraconicRiftBlocks.COBBLESTONE);
            //dropSelf(DraconicRiftBlocks.COBBLESTONE_WALL);
            //dropSelf(DraconicRiftBlocks.COBBLESTONE_STAIRS);
            //slab(DraconicRiftBlocks.COBBLESTONE_SLAB);
            //dropSelf(DraconicRiftBlocks.STONE_BRICKS);
            //slab(DraconicRiftBlocks.STONE_BRICKS_SLAB);
            //dropSelf(DraconicRiftBlocks.STONE_BRICKS_STAIRS);
            //dropSelf(DraconicRiftBlocks.STONE_BRICKS_WALL);
            //dropSelf(DraconicRiftBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            //slab(DraconicRiftBlocks.STONE_SLAB);
            //dropSelf(DraconicRiftBlocks.STONE_STAIRS);
            dropSelf(DraconicRiftBlocks.STONE_BUTTON);
            dropSelf(DraconicRiftBlocks.STONE_PRESSURE_PLATE);
            //dropOther(DraconicRiftBlocks.STONE, DraconicRiftBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(DraconicRiftBlocks.SAPLING);
            //Psychic
                //Wood
            dropSelf(DreamlandBlocks.LOG);
            dropSelf(DreamlandBlocks.PLANKS);
            //dropSelf(DreamlandBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(DreamlandBlocks.WOODEN_BUTTON);
            dropSelf(DreamlandBlocks.WOODEN_STAIRS);
            slab(DreamlandBlocks.WOODEN_SLAB);
            dropSelf(DreamlandBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(DreamlandBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(DreamlandBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(DreamlandBlocks.WOOD);
            //dropSelf(DreamlandBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(DreamlandBlocks.FENCE);
            dropSelf(DreamlandBlocks.FENCE_GATE);
            //dropSelf(DreamlandBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(DreamlandBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(DreamlandBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, DreamlandBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(DreamlandBlocks.COBBLESTONE);
            dropSelf(DreamlandBlocks.COBBLESTONE_WALL);
            dropSelf(DreamlandBlocks.COBBLESTONE_STAIRS);
            slab(DreamlandBlocks.COBBLESTONE_SLAB);
            dropSelf(DreamlandBlocks.STONE_BRICKS);
            slab(DreamlandBlocks.STONE_BRICKS_SLAB);
            dropSelf(DreamlandBlocks.STONE_BRICKS_STAIRS);
            dropSelf(DreamlandBlocks.STONE_BRICKS_WALL);
            //dropSelf(DreamlandBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(DreamlandBlocks.STONE_SLAB);
            dropSelf(DreamlandBlocks.STONE_STAIRS);
            dropSelf(DreamlandBlocks.STONE_BUTTON);
            dropSelf(DreamlandBlocks.STONE_PRESSURE_PLATE);
            dropOther(DreamlandBlocks.STONE, DreamlandBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(DreamlandBlocks.SAPLING);
            dropSelf(DreamlandBlocks.PORTAL_FRAME);
            dropNothing(DreamlandBlocks.PORTAL);
            //Electric
                //Wood
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_LOG);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_PLANKS);
            dropSelf(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_BUTTON);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_STAIRS);
            slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_SLAB);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_PRESSURE_PLATE);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            this.add(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOOD);
            dropSelf(ElectricHighlandsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_FENCE_GATE);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN);
            dropOther(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_WALL);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_STAIRS);
            slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE_SLABS);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS);
            slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_SLABS);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_STAIRS);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICK_WALL);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_SLABS);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_STAIRS);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BUTTON);
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_PRESSURE_PLATE);
            dropOther(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_COBBLESTONE.get());
                //Ore
            dropWithFortune(ElectricHighlandsBlocks.CHARGED_COAL_ORE, Items.COAL);
            dropSelf(ElectricHighlandsBlocks.CHARGED_IRON_ORE);
            dropSelf(ElectricHighlandsBlocks.CHARGED_GOLD_ORE);
            dropWithFortune(ElectricHighlandsBlocks.CHARGED_DIAMOND_ORE, Items.DIAMOND);
            dropWithFortune(ElectricHighlandsBlocks.CHARGED_GLOWSTONE_ORE, Items.GLOWSTONE_DUST);
            dropWithFortune(ElectricHighlandsBlocks.CHARGED_VOLTCRYST_ORE, ElectricHighlandsItems.VOLTCRYST);
                //Other
            dropSelf(ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SAPLING);
            dropSelf(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME);
            //Fire
                //Wood
            dropSelf(EmberwildsBlocks.LOG);
            dropSelf(EmberwildsBlocks.PLANKS);
            //dropSelf(EmberwildsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(EmberwildsBlocks.WOODEN_BUTTON);
            dropSelf(EmberwildsBlocks.WOODEN_STAIRS);
            slab(EmberwildsBlocks.WOODEN_SLAB);
            dropSelf(EmberwildsBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(EmberwildsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(EmberwildsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(EmberwildsBlocks.WOOD);
            //dropSelf(EmberwildsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(EmberwildsBlocks.FENCE);
            dropSelf(EmberwildsBlocks.FENCE_GATE);
            //dropSelf(EmberwildsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(EmberwildsBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(EmberwildsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, EmberwildsBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            //dropSelf(EmberwildsBlocks.COBBLESTONE);
            //dropSelf(EmberwildsBlocks.COBBLESTONE_WALL);
            //dropSelf(EmberwildsBlocks.COBBLESTONE_STAIRS);
            //slab(EmberwildsBlocks.COBBLESTONE_SLAB);
            //dropSelf(EmberwildsBlocks.STONE_BRICKS);
            //slab(EmberwildsBlocks.STONE_BRICKS_SLAB);
            //dropSelf(EmberwildsBlocks.STONE_BRICKS_STAIRS);
            //dropSelf(EmberwildsBlocks.STONE_BRICKS_WALL);
            //dropSelf(EmberwildsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            //slab(EmberwildsBlocks.STONE_SLAB);
            //dropSelf(EmberwildsBlocks.STONE_STAIRS);
            dropSelf(EmberwildsBlocks.STONE_BUTTON);
            dropSelf(EmberwildsBlocks.STONE_PRESSURE_PLATE);
            //dropOther(EmberwildsBlocks.STONE, EmberwildsBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(EmberwildsBlocks.SAPLING);
            //Fairy
                //Wood
            dropSelf(FeywildExpanseBlocks.LOG);
            dropSelf(FeywildExpanseBlocks.PLANKS);
            //dropSelf(FeywildExpanseBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(FeywildExpanseBlocks.WOODEN_BUTTON);
            dropSelf(FeywildExpanseBlocks.WOODEN_STAIRS);
            slab(FeywildExpanseBlocks.WOODEN_SLAB);
            dropSelf(FeywildExpanseBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(FeywildExpanseBlocks.WOOD);
            //dropSelf(FeywildExpanseBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(FeywildExpanseBlocks.FENCE);
            dropSelf(FeywildExpanseBlocks.FENCE_GATE);
            //dropSelf(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, FeywildExpanseBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(FeywildExpanseBlocks.COBBLESTONE);
            dropSelf(FeywildExpanseBlocks.COBBLESTONE_WALL);
            dropSelf(FeywildExpanseBlocks.COBBLESTONE_STAIRS);
            slab(FeywildExpanseBlocks.COBBLESTONE_SLAB);
            dropSelf(FeywildExpanseBlocks.STONE_BRICKS);
            slab(FeywildExpanseBlocks.STONE_BRICKS_SLAB);
            dropSelf(FeywildExpanseBlocks.STONE_BRICKS_STAIRS);
            dropSelf(FeywildExpanseBlocks.STONE_BRICKS_WALL);
            //dropSelf(FeywildExpanseBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(FeywildExpanseBlocks.STONE_SLAB);
            dropSelf(FeywildExpanseBlocks.STONE_STAIRS);
            dropSelf(FeywildExpanseBlocks.STONE_BUTTON);
            dropSelf(FeywildExpanseBlocks.STONE_PRESSURE_PLATE);
            dropOther(FeywildExpanseBlocks.STONE, FeywildExpanseBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(FeywildExpanseBlocks.SAPLING);
            dropSelf(FeywildExpanseBlocks.PORTAL_FRAME);
            dropNothing(FeywildExpanseBlocks.PORTAL);
            //Ghost
                //Wood
            dropSelf(GhastlyMarshBlocks.LOG);
            dropSelf(GhastlyMarshBlocks.PLANKS);
            //dropSelf(GhastlyMarshBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(GhastlyMarshBlocks.WOODEN_BUTTON);
            dropSelf(GhastlyMarshBlocks.WOODEN_STAIRS);
            slab(GhastlyMarshBlocks.WOODEN_SLAB);
            dropSelf(GhastlyMarshBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(GhastlyMarshBlocks.WOOD);
            //dropSelf(GhastlyMarshBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(GhastlyMarshBlocks.FENCE);
            dropSelf(GhastlyMarshBlocks.FENCE_GATE);
            //dropSelf(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, GhastlyMarshBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(GhastlyMarshBlocks.COBBLESTONE);
            dropSelf(GhastlyMarshBlocks.COBBLESTONE_WALL);
            dropSelf(GhastlyMarshBlocks.COBBLESTONE_STAIRS);
            slab(GhastlyMarshBlocks.COBBLESTONE_SLAB);
            dropSelf(GhastlyMarshBlocks.STONE_BRICKS);
            slab(GhastlyMarshBlocks.STONE_BRICKS_SLAB);
            dropSelf(GhastlyMarshBlocks.STONE_BRICKS_STAIRS);
            dropSelf(GhastlyMarshBlocks.STONE_BRICKS_WALL);
            //dropSelf(GhastlyMarshBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(GhastlyMarshBlocks.STONE_SLAB);
            dropSelf(GhastlyMarshBlocks.STONE_STAIRS);
            dropSelf(GhastlyMarshBlocks.STONE_BUTTON);
            dropSelf(GhastlyMarshBlocks.STONE_PRESSURE_PLATE);
            dropOther(GhastlyMarshBlocks.STONE, GhastlyMarshBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(GhastlyMarshBlocks.SAPLING);
            dropSelf(GhastlyMarshBlocks.PORTAL_FRAME);
            dropNothing(GhastlyMarshBlocks.PORTAL);
            //Grass
                //Wood
            dropSelf(GrassyKnollBlocks.LOG);
            dropSelf(GrassyKnollBlocks.PLANKS);
            //dropSelf(GrassyKnollBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(GrassyKnollBlocks.WOODEN_BUTTON);
            dropSelf(GrassyKnollBlocks.WOODEN_STAIRS);
            slab(GrassyKnollBlocks.WOODEN_SLAB);
            dropSelf(GrassyKnollBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(GrassyKnollBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(GrassyKnollBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(GrassyKnollBlocks.WOOD);
            //dropSelf(GrassyKnollBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(GrassyKnollBlocks.FENCE);
            dropSelf(GrassyKnollBlocks.FENCE_GATE);
            //dropSelf(GrassyKnollBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(GrassyKnollBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(GrassyKnollBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, GrassyKnollBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(GrassyKnollBlocks.COBBLESTONE);
            dropSelf(GrassyKnollBlocks.COBBLESTONE_WALL);
            dropSelf(GrassyKnollBlocks.COBBLESTONE_STAIRS);
            slab(GrassyKnollBlocks.COBBLESTONE_SLAB);
            dropSelf(GrassyKnollBlocks.STONE_BRICKS);
            slab(GrassyKnollBlocks.STONE_BRICKS_SLAB);
            dropSelf(GrassyKnollBlocks.STONE_BRICKS_STAIRS);
            dropSelf(GrassyKnollBlocks.STONE_BRICKS_WALL);
            //dropSelf(GrassyKnollBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(GrassyKnollBlocks.STONE_SLAB);
            dropSelf(GrassyKnollBlocks.STONE_STAIRS);
            dropSelf(GrassyKnollBlocks.STONE_BUTTON);
            dropSelf(GrassyKnollBlocks.STONE_PRESSURE_PLATE);
            dropOther(GrassyKnollBlocks.STONE, GrassyKnollBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(GrassyKnollBlocks.SAPLING);
            dropSelf(GrassyKnollBlocks.PORTAL_FRAME);
            dropNothing(GrassyKnollBlocks.PORTAL);
            //Fighting
                //Wood
            dropSelf(InfiniteDungeonBlocks.LOG);
            dropSelf(InfiniteDungeonBlocks.PLANKS);
            //dropSelf(InfiniteDungeonBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(InfiniteDungeonBlocks.WOODEN_BUTTON);
            dropSelf(InfiniteDungeonBlocks.WOODEN_STAIRS);
            slab(InfiniteDungeonBlocks.WOODEN_SLAB);
            dropSelf(InfiniteDungeonBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(InfiniteDungeonBlocks.WOOD);
            //dropSelf(InfiniteDungeonBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(InfiniteDungeonBlocks.FENCE);
            dropSelf(InfiniteDungeonBlocks.FENCE_GATE);
            //dropSelf(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(InfiniteDungeonBlocks.COBBLESTONE);
            dropSelf(InfiniteDungeonBlocks.COBBLESTONE_WALL);
            dropSelf(InfiniteDungeonBlocks.COBBLESTONE_STAIRS);
            slab(InfiniteDungeonBlocks.COBBLESTONE_SLAB);
            dropSelf(InfiniteDungeonBlocks.STONE_BRICKS);
            slab(InfiniteDungeonBlocks.STONE_BRICKS_SLAB);
            dropSelf(InfiniteDungeonBlocks.STONE_BRICKS_STAIRS);
            dropSelf(InfiniteDungeonBlocks.STONE_BRICKS_WALL);
            //dropSelf(InfiniteDungeonBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(InfiniteDungeonBlocks.STONE_SLAB);
            dropSelf(InfiniteDungeonBlocks.STONE_STAIRS);
            dropSelf(InfiniteDungeonBlocks.STONE_BUTTON);
            dropSelf(InfiniteDungeonBlocks.STONE_PRESSURE_PLATE);
            dropOther(InfiniteDungeonBlocks.STONE, InfiniteDungeonBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(InfiniteDungeonBlocks.PORTAL_FRAME);
            dropNothing(InfiniteDungeonBlocks.PORTAL);
            //Bug
                //Wood
            dropSelf(InsectoidParadisioBlocks.LOG);
            dropSelf(InsectoidParadisioBlocks.PLANKS);
            //dropSelf(InsectoidParadisioBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(InsectoidParadisioBlocks.WOODEN_BUTTON);
            dropSelf(InsectoidParadisioBlocks.WOODEN_STAIRS);
            slab(InsectoidParadisioBlocks.WOODEN_SLAB);
            dropSelf(InsectoidParadisioBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(InsectoidParadisioBlocks.WOOD);
            //dropSelf(InsectoidParadisioBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(InsectoidParadisioBlocks.FENCE);
            dropSelf(InsectoidParadisioBlocks.FENCE_GATE);
            //dropSelf(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(InsectoidParadisioBlocks.COBBLESTONE);
            dropSelf(InsectoidParadisioBlocks.COBBLESTONE_WALL);
            dropSelf(InsectoidParadisioBlocks.COBBLESTONE_STAIRS);
            slab(InsectoidParadisioBlocks.COBBLESTONE_SLAB);
            dropSelf(InsectoidParadisioBlocks.STONE_BRICKS);
            slab(InsectoidParadisioBlocks.STONE_BRICKS_SLAB);
            dropSelf(InsectoidParadisioBlocks.STONE_BRICKS_STAIRS);
            dropSelf(InsectoidParadisioBlocks.STONE_BRICKS_WALL);
            //dropSelf(InsectoidParadisioBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(InsectoidParadisioBlocks.STONE_SLAB);
            dropSelf(InsectoidParadisioBlocks.STONE_STAIRS);
            dropSelf(InsectoidParadisioBlocks.STONE_BUTTON);
            dropSelf(InsectoidParadisioBlocks.STONE_PRESSURE_PLATE);
            dropOther(InsectoidParadisioBlocks.STONE, InsectoidParadisioBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(InsectoidParadisioBlocks.SAPLING);
            dropSelf(InsectoidParadisioBlocks.PORTAL_FRAME);
            dropNothing(InsectoidParadisioBlocks.PORTAL);
            //Steel
                //Wood
            dropSelf(MetallicMountainsBlocks.LOG);
            dropSelf(MetallicMountainsBlocks.PLANKS);
            //dropSelf(MetallicMountainsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(MetallicMountainsBlocks.WOODEN_BUTTON);
            dropSelf(MetallicMountainsBlocks.WOODEN_STAIRS);
            slab(MetallicMountainsBlocks.WOODEN_SLAB);
            dropSelf(MetallicMountainsBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(MetallicMountainsBlocks.WOOD);
            //dropSelf(MetallicMountainsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(MetallicMountainsBlocks.FENCE);
            dropSelf(MetallicMountainsBlocks.FENCE_GATE);
            //dropSelf(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, MetallicMountainsBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(MetallicMountainsBlocks.COBBLESTONE);
            dropSelf(MetallicMountainsBlocks.COBBLESTONE_WALL);
            dropSelf(MetallicMountainsBlocks.COBBLESTONE_STAIRS);
            slab(MetallicMountainsBlocks.COBBLESTONE_SLAB);
            dropSelf(MetallicMountainsBlocks.STONE_BRICKS);
            slab(MetallicMountainsBlocks.STONE_BRICKS_SLAB);
            dropSelf(MetallicMountainsBlocks.STONE_BRICKS_STAIRS);
            dropSelf(MetallicMountainsBlocks.STONE_BRICKS_WALL);
            //dropSelf(MetallicMountainsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(MetallicMountainsBlocks.STONE_SLAB);
            dropSelf(MetallicMountainsBlocks.STONE_STAIRS);
            dropSelf(MetallicMountainsBlocks.STONE_BUTTON);
            dropSelf(MetallicMountainsBlocks.STONE_PRESSURE_PLATE);
            dropOther(MetallicMountainsBlocks.STONE, MetallicMountainsBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(MetallicMountainsBlocks.SAPLING);
            dropSelf(MetallicMountainsBlocks.PORTAL_FRAME);
            dropNothing(MetallicMountainsBlocks.PORTAL);
            //Ground
                //Wood
            dropSelf(TerraNataBlocks.LOG);
            dropSelf(TerraNataBlocks.PLANKS);
            //dropSelf(TerraNataBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(TerraNataBlocks.WOODEN_BUTTON);
            dropSelf(TerraNataBlocks.WOODEN_STAIRS);
            slab(TerraNataBlocks.WOODEN_SLAB);
            dropSelf(TerraNataBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(TerraNataBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(TerraNataBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(TerraNataBlocks.WOOD);
            //dropSelf(TerraNataBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(TerraNataBlocks.FENCE);
            dropSelf(TerraNataBlocks.FENCE_GATE);
            //dropSelf(TerraNataBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(TerraNataBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(TerraNataBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, TerraNataBlocks.ELECTRICALLY_CHARGED_SIGN.get());
            //Stone
            dropSelf(TerraNataBlocks.COBBLESTONE);
            dropSelf(TerraNataBlocks.COBBLESTONE_WALL);
            dropSelf(TerraNataBlocks.COBBLESTONE_STAIRS);
            slab(TerraNataBlocks.COBBLESTONE_SLAB);
            dropSelf(TerraNataBlocks.STONE_BRICKS);
            slab(TerraNataBlocks.STONE_BRICKS_SLAB);
            dropSelf(TerraNataBlocks.STONE_BRICKS_STAIRS);
            dropSelf(TerraNataBlocks.STONE_BRICKS_WALL);
            //dropSelf(TerraNataBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(TerraNataBlocks.STONE_SLAB);
            dropSelf(TerraNataBlocks.STONE_STAIRS);
            dropSelf(TerraNataBlocks.STONE_BUTTON);
            dropSelf(TerraNataBlocks.STONE_PRESSURE_PLATE);
            dropOther(TerraNataBlocks.STONE, TerraNataBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(TerraNataBlocks.SAPLING);
            dropSelf(TerraNataBlocks.PORTAL_FRAME);
            dropNothing(TerraNataBlocks.PORTAL);
            //Dark
                //Wood
            dropSelf(ValleyDeathBlocks.LOG);
            dropSelf(ValleyDeathBlocks.PLANKS);
            //dropSelf(ValleyDeathBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(ValleyDeathBlocks.WOODEN_BUTTON);
            dropSelf(ValleyDeathBlocks.WOODEN_STAIRS);
            slab(ValleyDeathBlocks.WOODEN_SLAB);
            dropSelf(ValleyDeathBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(ValleyDeathBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(ValleyDeathBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(ValleyDeathBlocks.WOOD);
            //dropSelf(ValleyDeathBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(ValleyDeathBlocks.FENCE);
            dropSelf(ValleyDeathBlocks.FENCE_GATE);
            //dropSelf(ValleyDeathBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(ValleyDeathBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(ValleyDeathBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, ValleyDeathBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(ValleyDeathBlocks.COBBLESTONE);
            dropSelf(ValleyDeathBlocks.COBBLESTONE_WALL);
            dropSelf(ValleyDeathBlocks.COBBLESTONE_STAIRS);
            slab(ValleyDeathBlocks.COBBLESTONE_SLAB);
            dropSelf(ValleyDeathBlocks.STONE_BRICKS);
            slab(ValleyDeathBlocks.STONE_BRICKS_SLAB);
            dropSelf(ValleyDeathBlocks.STONE_BRICKS_STAIRS);
            dropSelf(ValleyDeathBlocks.STONE_BRICKS_WALL);
            //dropSelf(ValleyDeathBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(ValleyDeathBlocks.STONE_SLAB);
            dropSelf(ValleyDeathBlocks.STONE_STAIRS);
            dropSelf(ValleyDeathBlocks.STONE_BUTTON);
            dropSelf(ValleyDeathBlocks.STONE_PRESSURE_PLATE);
            dropOther(ValleyDeathBlocks.STONE, ValleyDeathBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(ValleyDeathBlocks.SAPLING);
            dropSelf(ValleyDeathBlocks.PORTAL_FRAME);
            dropNothing(ValleyDeathBlocks.PORTAL);
            //Water
                //Wood
            dropSelf(WateryDepthsBlocks.LOG);
            dropSelf(WateryDepthsBlocks.PLANKS);
            //dropSelf(WateryDepthsBlocks.STRIPPED_ELECTRICALLY_CHARGED_LOG);
            dropSelf(WateryDepthsBlocks.WOODEN_BUTTON);
            dropSelf(WateryDepthsBlocks.WOODEN_STAIRS);
            slab(WateryDepthsBlocks.WOODEN_SLAB);
            dropSelf(WateryDepthsBlocks.WOODEN_PRESSURE_PLATE);
            //dropSelf(WateryDepthsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //this.add(WateryDepthsBlocks.ELECTRICALLY_CHARGED_DOOR.get(), (block) -> createSinglePropConditionTable(block, DoorBlock.HALF, DoubleBlockHalf.LOWER));
            dropSelf(WateryDepthsBlocks.WOOD);
            //dropSelf(WateryDepthsBlocks.STRIPPED_ELECTRICALLY_CHARGED_WOOD);
            dropSelf(WateryDepthsBlocks.FENCE);
            dropSelf(WateryDepthsBlocks.FENCE_GATE);
            //dropSelf(WateryDepthsBlocks.ELECTRICALLY_CHARGED_WOODEN_TRAPDOOR);
            //dropSelf(WateryDepthsBlocks.ELECTRICALLY_CHARGED_SIGN);
            //dropOther(WateryDepthsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN, WateryDepthsBlocks.ELECTRICALLY_CHARGED_SIGN.get());
                //Stone
            dropSelf(WateryDepthsBlocks.COBBLESTONE);
            dropSelf(WateryDepthsBlocks.COBBLESTONE_WALL);
            dropSelf(WateryDepthsBlocks.COBBLESTONE_STAIRS);
            slab(WateryDepthsBlocks.COBBLESTONE_SLAB);
            dropSelf(WateryDepthsBlocks.STONE_BRICKS);
            slab(WateryDepthsBlocks.STONE_BRICKS_SLAB);
            dropSelf(WateryDepthsBlocks.STONE_BRICKS_STAIRS);
            dropSelf(WateryDepthsBlocks.STONE_BRICKS_WALL);
            //dropSelf(WateryDepthsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS);
            slab(WateryDepthsBlocks.STONE_SLAB);
            dropSelf(WateryDepthsBlocks.STONE_STAIRS);
            dropSelf(WateryDepthsBlocks.STONE_BUTTON);
            dropSelf(WateryDepthsBlocks.STONE_PRESSURE_PLATE);
            dropOther(WateryDepthsBlocks.STONE, WateryDepthsBlocks.COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(WateryDepthsBlocks.SAPLING);
            dropSelf(WateryDepthsBlocks.PORTAL_FRAME);
            dropNothing(WateryDepthsBlocks.PORTAL);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Stream.of(
                    CavernousCoveBlocks.BLOCKS,
                    HeavenlyRealmBlocks.BLOCKS,
                    CorrosiveFieldsBlocks.BLOCKS,
                    DeepTundraBlocks.BLOCKS,
                    DraconicRiftBlocks.BLOCKS,
                    DreamlandBlocks.BLOCKS,
                    ElectricHighlandsBlocks.BLOCKS,
                    EmberwildsBlocks.BLOCKS,
                    FeywildExpanseBlocks.BLOCKS,
                    GhastlyMarshBlocks.BLOCKS,
                    GrassyKnollBlocks.BLOCKS,
                    InfiniteDungeonBlocks.BLOCKS,
                    InsectoidParadisioBlocks.BLOCKS,
                    MetallicMountainsBlocks.BLOCKS,
                    TerraNataBlocks.BLOCKS,
                    ValleyDeathBlocks.BLOCKS,
                    WateryDepthsBlocks.BLOCKS
            ).flatMap(reg -> reg.getEntries().stream().map(Supplier::get)).collect(Collectors.toList());
        }
    }

    protected static <T> T withExplosionDecay(IItemProvider item, ILootFunctionConsumer<T> function) {
        return !IMMUNE_TO_EXPLOSIONS.contains(item.asItem()) ? function.apply(ExplosionDecay.explosionDecay()) : function.unwrap();
    }

    public static class Entities extends EntityLootTables {
        @Override
        protected void addTables() {
            this.add(ElectricHighlandsEntityTypes.CHARGED_CRAWLER.get(), LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setRolls(ConstantRange.exactly(1))
                            .add(ItemLootEntry.lootTableItem(ElectricHighlandsItems.VOLTCRYST.get())
                                    .apply(SetCount.setCount(RandomValueRange.between(0.0F, 2.0F)))
                                    .apply(LootingEnchantBonus.lootingMultiplier(RandomValueRange.between(0.0F, 1.0F)))
                                    .when(KilledByPlayer.killedByPlayer()))
                            .add(ItemLootEntry.lootTableItem(ElectricHighlandsItems.ELECTRIC_HIGHLANDS_ACTIVATOR.get())
                                    .when(KilledByPlayer.killedByPlayer())
                                    .when(MatchTool.toolMatches(
                                            ItemPredicate.Builder.item().hasEnchantment(
                                                    new EnchantmentPredicate(Enchantments.MOB_LOOTING, MinMaxBounds.IntBound.exactly(3))
                                            )
                                    )))));
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities() {
            return ElectricHighlandsEntityTypes.ENTITY_TYPES.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
        }
    }
}
