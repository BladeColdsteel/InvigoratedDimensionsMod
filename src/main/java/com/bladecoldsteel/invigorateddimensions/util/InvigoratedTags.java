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
