package com.bladecoldsteel.invigorateddimensions.universal.datageneration.provider;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class IDItemModelProvider extends ItemModelProvider {
    public IDItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator, InvigoratedDimensions.MOD_ID, fileHelper);
    }

    public ItemModelBuilder itemFence(Supplier<? extends Block> block, String name) {
        return withExistingParent(blockName(block), mcLoc("block/fence_inventory"))
                .texture("texture", ("block/" + name));
    }

    public ItemModelBuilder itemBlock(Supplier<? extends Block> block) {
        return itemBlock(block, blockName(block));
    }

    public ItemModelBuilder itemBlock(Supplier<? extends Block> block, String name) {
        return withExistingParent(blockName(block), modLoc("block/" + name));
    }

    public ItemModelBuilder itemBlockFlat(Supplier<? extends Block> block) {
        return itemBlockFlat(block, blockName(block));
    }

    public ItemModelBuilder itemBlockFlat(Supplier<? extends Block> block, String name) {
        return withExistingParent(blockName(block), mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + name));
    }

    public ItemModelBuilder normalItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    public ItemModelBuilder torchItem(Supplier<? extends Block> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    public ItemModelBuilder toolItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    public ItemModelBuilder rodItem(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    public ItemModelBuilder egg(Supplier<? extends Item> item) {
        return withExistingParent(item.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
    }

    public ItemModelBuilder sign(Supplier<? extends AbstractSignBlock> sign) {
        return withExistingParent(blockName(sign), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + blockName(sign)));
    }

    public String blockName(Supplier<? extends Block> block) {
        return block.get().getRegistryName().getPath();
    }

    protected ResourceLocation texture(String name) {
        return modLoc("block/" + name);
    }

    @Override
    protected void registerModels() {

    }
}
