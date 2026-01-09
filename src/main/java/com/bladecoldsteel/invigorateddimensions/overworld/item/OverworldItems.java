package com.bladecoldsteel.invigorateddimensions.overworld.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class OverworldItems {
    private static final ItemGroup TAB = ItemGroup.TAB_MATERIALS;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Item> FOSSILIZED_BONES = ItemHelper.registerItem(
            "fossil_bones", ITEMS, new Item.Properties()
                    .stacksTo(16)
                    .rarity(Rarity.UNCOMMON),
            TAB
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}