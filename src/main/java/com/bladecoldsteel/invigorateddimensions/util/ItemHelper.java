package com.bladecoldsteel.invigorateddimensions.util;

import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemHelper {
    public static <T extends Item>RegistryObject<T> registerActivator(String name, DeferredRegister<Item> itemRegistry, Function<Item.Properties, T> itemFactory, ItemGroup tab) {
        return itemRegistry.register(name, () -> itemFactory.apply(new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<Item> registerItem(String name, DeferredRegister<Item> itemRegistry, Item.Properties itemFactory, ItemGroup tab, int stackSize) {
        return itemRegistry.register(name, () -> new Item(itemFactory.tab(tab).stacksTo(stackSize)));
    }
    public static <T extends Item> RegistryObject<ArmorItem> registerArmor(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IArmorMaterial armorMaterial, EquipmentSlotType armorSlot) {
        return itemRegistry.register(name, () -> new ArmorItem(armorMaterial, armorSlot, new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<SwordItem> registerSword(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        return itemRegistry.register(name, () -> new SwordItem(toolMaterial, attackDamage, attackSpeed, new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<PickaxeItem> registerPickaxe(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        return itemRegistry.register(name, () -> new PickaxeItem(toolMaterial, attackDamage, attackSpeed, new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<AxeItem> registerAxe(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        return itemRegistry.register(name, () -> new AxeItem(toolMaterial, attackDamage, attackSpeed, new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<ShovelItem> registerShovel(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        return itemRegistry.register(name, () -> new ShovelItem(toolMaterial, attackDamage, attackSpeed, new Item.Properties().tab(tab)));
    }
    public static <T extends Item> RegistryObject<HoeItem> registerHoe(String name, DeferredRegister<Item> itemRegistry, ItemGroup tab, IItemTier toolMaterial, int attackDamage, float attackSpeed) {
        return itemRegistry.register(name, () -> new HoeItem(toolMaterial, attackDamage, attackSpeed, new Item.Properties().tab(tab)));
    }

    public static Function<Item.Properties, UniversalActivatorItem> activatorItem(RegistryKey<World> destinationDimension, Supplier<? extends Block> portalBlock) {
        return props -> new UniversalActivatorItem(
                props
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
                    .durability(1),
                destinationDimension, portalBlock);
    }

    public static Food foodItem(int nutrition, float saturation, boolean isMeat, boolean canAlwaysEat, boolean fastFood, Effect effects, float effectChance, int effectTimer, int effectLevel) {
        Food.Builder foodBuilder = new Food.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation);
        if (effects != null) foodBuilder.effect(() -> new EffectInstance(effects, effectTimer, effectLevel), effectChance);
        if (isMeat) foodBuilder.meat();
        if (canAlwaysEat) foodBuilder.alwaysEat();
        if (fastFood) foodBuilder.fast();

        return foodBuilder.build();
    }
}
