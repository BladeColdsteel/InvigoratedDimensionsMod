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
            dropSelf(FeywildExpanseBlocks.FEYAN_LOG);
                //Stone
            dropSelf(FeywildExpanseBlocks.FEYAN_COBBLESTONE);
            dropOther(FeywildExpanseBlocks.FEYAN_STONE, FeywildExpanseBlocks.FEYAN_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(FeywildExpanseBlocks.FEYAN_SAPLING);
            //Ghost
                //Wood
            dropSelf(GhastlyMarshBlocks.SPOOKY_LOG);
                //Stone
            dropSelf(GhastlyMarshBlocks.SPOOKY_COBBLESTONE);
            dropOther(GhastlyMarshBlocks.SPOOKY_STONE, GhastlyMarshBlocks.SPOOKY_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(GhastlyMarshBlocks.SPOOKY_SAPLING);
            //Grass
                //Wood
            dropSelf(GrassyKnollBlocks.GRASSY_LOG);
                //Stone
            dropSelf(GrassyKnollBlocks.GRASSY_COBBLESTONE);
            dropOther(GrassyKnollBlocks.GRASSY_STONE, GrassyKnollBlocks.GRASSY_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(GrassyKnollBlocks.GRASSY_SAPLING);
            //Fighting
                //Wood
            dropSelf(InfiniteDungeonBlocks.TOUGH_LOG);
                //Stone
            dropSelf(InfiniteDungeonBlocks.TOUGH_COBBLESTONE);
            dropOther(InfiniteDungeonBlocks.TOUGH_STONE, InfiniteDungeonBlocks.TOUGH_COBBLESTONE.get());
                //Ore

                //Other

            //Bug
                //Wood
            dropSelf(InsectoidParadisioBlocks.BUGGED_LOG);
                //Stone
            dropSelf(InsectoidParadisioBlocks.BUGGED_COBBLESTONE);
            dropOther(InsectoidParadisioBlocks.BUGGED_STONE, InsectoidParadisioBlocks.BUGGED_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(InsectoidParadisioBlocks.BUGGED_SAPLING);
            //Steel
                //Wood
            dropSelf(MetallicMountainsBlocks.METALLIC_LOG);
                //Stone
            dropSelf(MetallicMountainsBlocks.METALLIC_COBBLESTONE);
            dropOther(MetallicMountainsBlocks.METALLIC_STONE, MetallicMountainsBlocks.METALLIC_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(MetallicMountainsBlocks.METALLIC_SAPLING);
            //Ground
                //Wood
            dropSelf(TerraNataBlocks.GROUNDED_LOG);
                //Stone
            dropSelf(TerraNataBlocks.GROUNDED_COBBLESTONE);
            dropOther(TerraNataBlocks.GROUNDED_STONE, TerraNataBlocks.GROUNDED_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(TerraNataBlocks.GROUNDED_SAPLING);
            //Dark
                //Wood
            dropSelf(ValleyDeathBlocks.DARKENED_LOG);
                //Stone
            dropSelf(ValleyDeathBlocks.DARKENED_COBBLESTONE);
            dropOther(ValleyDeathBlocks.DARKENED_STONE, ValleyDeathBlocks.DARKENED_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(ValleyDeathBlocks.DARKENED_SAPLING);
            //Water
                //Wood
            dropSelf(WateryDepthsBlocks.WATERY_LOG);
                //Stone
            dropSelf(WateryDepthsBlocks.WATERY_COBBLESTONE);
            dropOther(WateryDepthsBlocks.WATERY_STONE, WateryDepthsBlocks.WATERY_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(WateryDepthsBlocks.WATERY_SAPLING);
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
