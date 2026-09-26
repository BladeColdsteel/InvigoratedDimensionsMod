package com.bladecoldsteel.invigorateddimensions.ultra.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.item.custom.BeastlyBoarTuskItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UltraDimItems {
    private static final ItemGroup TAB = UltraDimItemGroup.ULTRA_DIM_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Item> BOAR_TUSK = ItemHelper.registerItem(
            "boar_tusk", ITEMS, new Item.Properties(),
            TAB,
            64
    );

    public static final RegistryObject<BeastlyBoarTuskItem> BEASTLY_BOAR_TUSK = ItemHelper.registerBoarTusk(
            "beastly_boar_tusk", ITEMS, new Item.Properties(),
            TAB,
            1, 8, 0.5F
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
