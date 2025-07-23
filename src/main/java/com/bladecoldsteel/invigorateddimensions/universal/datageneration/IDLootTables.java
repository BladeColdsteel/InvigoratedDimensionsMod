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
import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
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
import net.minecraft.loot.conditions.RandomChanceWithLooting;
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
            dropSelf(CavernousCoveBlocks.ROCKY_LOG);
                //Stone
            dropSelf(CavernousCoveBlocks.ROCKY_COBBLESTONE);
            dropOther(CavernousCoveBlocks.ROCKY_STONE, CavernousCoveBlocks.ROCKY_COBBLESTONE.get());
                //Ore

                //Other

            //Flying
                //Wood
            dropSelf(HeavenlyRealmBlocks.FLOATING_LOG);
                //Stone
            dropSelf(HeavenlyRealmBlocks.FLOATING_COBBLESTONE);
            dropOther(HeavenlyRealmBlocks.FLOATING_STONE, HeavenlyRealmBlocks.FLOATING_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(HeavenlyRealmBlocks.FLOATING_SAPLING);
            //Poison
                //Wood
            dropSelf(CorrosiveFieldsBlocks.CORROSIVE_LOG);
                //Stone
            dropSelf(CorrosiveFieldsBlocks.CORROSIVE_COBBLESTONE);
            dropOther(CorrosiveFieldsBlocks.CORROSIVE_STONE, CorrosiveFieldsBlocks.CORROSIVE_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(CorrosiveFieldsBlocks.CORROSIVE_SAPLING);
            //Ice
                //Wood
            dropSelf(DeepTundraBlocks.ICEY_LOG);
                //Stone
            dropSelf(DeepTundraBlocks.ICEY_COBBLESTONE);
            dropOther(DeepTundraBlocks.ICEY_STONE, DeepTundraBlocks.ICEY_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(DeepTundraBlocks.ICEY_SAPLING);
            //Dragon
                //Wood
            dropSelf(DraconicRiftBlocks.DRACONIC_LOG);
                //Stone

                //Ore

                //Other
            dropSelf(DraconicRiftBlocks.DRACONIC_SAPLING);
            //Psychic
                //Wood
            dropSelf(DreamlandBlocks.PSYCHEDELIC_LOG);
                //Stone
            dropSelf(DreamlandBlocks.PSYCHEDELIC_COBBLESTONE);
            dropOther(DreamlandBlocks.PSYCHEDELIC_STONE, DreamlandBlocks.PSYCHEDELIC_COBBLESTONE.get());
                //Ore

                //Other
            dropSelf(DreamlandBlocks.PSYCHEDELIC_SAPLING);
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
            dropSelf(EmberwildsBlocks.EMBERED_LOG);
                //Stone

                //Ore

                //Other
            dropSelf(EmberwildsBlocks.EMBERED_SAPLING);
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
