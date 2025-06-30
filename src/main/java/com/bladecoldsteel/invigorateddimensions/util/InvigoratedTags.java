package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class InvigoratedTags {

    public static class Blocks {

        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_ELECTRIC_HIGHLANDS =
                createTag("base_stone_electric_highlands");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_CAVERNOUS_COVE =
                createTag("base_stone_cavernous_cove");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_CELESTIAL_REALM =
                createTag("base_stone_celestial_realm");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_CORROSIVE_FIELDS =
                createTag("base_stone_corrosive_fields");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_DEEP_TUNDRA =
                createTag("base_stone_deep_tundra");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_DREAMLAND =
                createTag("base_stone_dreamland");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_FEYWILD_EXPANSE =
                createTag("base_stone_feywild_expanse");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_GHASTLY_MARSH =
                createTag("base_stone_ghastly_marsh");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_GRASSY_KNOLL =
                createTag("base_stone_grassy_knoll");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_INFINITE_DUNGEON =
                createTag("base_stone_infinite_dungeon");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_INSECTOID_PARADISIO =
                createTag("base_stone_insectoid_paradisio");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_METALLIC_MOUNTAINS =
                createTag("base_stone_metallic_mountains");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_TERRA_NATA =
                createTag("base_stone_terra_nata");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_VALLEY_OF_DEATH =
                createTag("base_stone_valley_of_death");
        public static final Tags.IOptionalNamedTag<Block> BASE_STONE_WATERY_DEPTHS =
                createTag("base_stone_watery_depths");
        public static final Tags.IOptionalNamedTag<Block> ELEMENTAL_SAPLINGS_BLOCK =
                createTag("elemental_saplings");
        public static final Tags.IOptionalNamedTag<Block> ELEMENTAL_STONES_BLOCK =
                createTag("elemental_stones");
        public static final Tags.IOptionalNamedTag<Block> ELEMENTAL_LOGS_BLOCK =
                createTag("elemental_logs");

        private static Tags.IOptionalNamedTag<Block> createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(InvigoratedDimensions.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final Tags.IOptionalNamedTag<Item> VOLTCRYST_FORGE = createForgeTag("gems/voltcryst");
        public static final Tags.IOptionalNamedTag<Item> VOLTCRYST_INVIGORATED = createTag("gems/voltcryst");

        public static final Tags.IOptionalNamedTag<Item> ELEMENTAL_SAPLINGS_ITEM = createTag("elemental_saplings");
        public static final Tags.IOptionalNamedTag<Item> ELEMENTAL_STONES_ITEM = createTag("elemental_stones");
        public static final Tags.IOptionalNamedTag<Item> ELEMENTAL_LOGS_ITEM = createTag("elemental_logs");

        private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(InvigoratedDimensions.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
