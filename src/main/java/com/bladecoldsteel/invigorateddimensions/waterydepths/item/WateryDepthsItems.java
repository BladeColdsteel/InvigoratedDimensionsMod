package com.bladecoldsteel.invigorateddimensions.waterydepths.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.waterydepths.block.WateryDepthsBlocks;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WateryDepthsItems {
    private static final ItemGroup TAB = WateryDepthsItemGroup.WATERY_DEPTHS_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "watery_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.WATERY_DEPTHS, () -> WateryDepthsBlocks.PORTAL.get()),
            TAB
    );

    public static final RegistryObject<Item> WATER_BOSS_KEY = ItemHelper.registerItem(
            "water_boss_key", ITEMS, new Item.Properties().rarity(Rarity.EPIC), TAB, 16);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
