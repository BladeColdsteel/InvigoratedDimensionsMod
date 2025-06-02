package com.bladecoldsteel.invigorateddimensions.universal.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UniversalItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Item> BASE_ESSENCE = ITEMS.register("base_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> NORMAL_ESSENCE = ITEMS.register("normal_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> ELECTRIC_ESSENCE = ITEMS.register("electric_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> WATER_ESSENCE = ITEMS.register("water_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> GRASS_ESSENCE = ITEMS.register("grass_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> STEEL_ESSENCE = ITEMS.register("steel_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> FAIRY_ESSENCE = ITEMS.register("fairy_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> ROCK_ESSENCE = ITEMS.register("rock_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> GROUND_ESSENCE = ITEMS.register("ground_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> DARK_ESSENCE = ITEMS.register("dark_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> FIGHTING_ESSENCE = ITEMS.register("fighting_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> BUG_ESSENCE = ITEMS.register("bug_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> DRAGON_ESSENCE = ITEMS.register("dragon_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> ICE_ESSENCE = ITEMS.register("ice_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> POISON_ESSENCE = ITEMS.register("poison_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> GHOST_ESSENCE = ITEMS.register("ghost_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> PSYCHIC_ESSENCE = ITEMS.register("psychic_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));
    public static final RegistryObject<Item> FLYING_ESSENCE = ITEMS.register("flying_essence",
            () -> new Item(new Item.Properties().tab(UniversalItemGroup.UNIVERSAL_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
