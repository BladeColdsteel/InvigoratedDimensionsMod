package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemHelper {
    public static <T extends Item>RegistryObject<T> register(String name, DeferredRegister<Item> itemRegistry, Function<Item.Properties, T> itemFactory, ItemGroup tab) {
        return itemRegistry.register(name, () -> itemFactory.apply(new Item.Properties().tab(tab)));
    }

    public static Function<Item.Properties, UniversalActivatorItem> activatorItem(RegistryKey<World> destinationDimension, Supplier<? extends Block> portalBlock) {
        return props -> new UniversalActivatorItem(
                props
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
                    .durability(1),
                destinationDimension, portalBlock);
    }

    public static Supplier<SwordItem> swordItem(ItemTier itemTier, int baseDamage, float attackSpeed, int durability) {
        return () -> new SwordItem(itemTier, baseDamage, attackSpeed, new Item.Properties()
                .durability(durability)
                .fireResistant()
                .stacksTo(1));
    }
}
