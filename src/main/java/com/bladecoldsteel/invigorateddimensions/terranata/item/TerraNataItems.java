package com.bladecoldsteel.invigorateddimensions.terranata.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.block.TerraNataBlocks;
import com.bladecoldsteel.invigorateddimensions.terranata.item.custom.EarthmawArmorSetItem;
import com.bladecoldsteel.invigorateddimensions.universal.item.IDArmorMaterials;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TerraNataItems {
    private static final ItemGroup TAB = TerraNataItemGroup.GROUND_RIFT_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "grounded_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.TERRA_NATA, () -> TerraNataBlocks.PORTAL.get()),
            TAB
    );

    public static final RegistryObject<Item> GIANT_WORM_TEETH = ItemHelper.registerItem(
            "giant_worm_teeth", ITEMS, new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON),
            TAB,
            64
    );
    public static final RegistryObject<Item> GIANT_WORM_HIDE = ItemHelper.registerItem(
            "giant_worm_hide", ITEMS, new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON),
            TAB,
            64
    );
    public static final RegistryObject<EarthmawArmorSetItem> EARTHMAW_HELMET = ItemHelper.registerEarthmawArmor(
            "earthmaw_helmet", ITEMS, TAB, IDArmorMaterials.EARTHMAW_ARMOR, EquipmentSlotType.HEAD
    );
    public static final RegistryObject<EarthmawArmorSetItem> EARTHMAW_CHESTPLATE = ItemHelper.registerEarthmawArmor(
            "earthmaw_chestplate", ITEMS, TAB, IDArmorMaterials.EARTHMAW_ARMOR, EquipmentSlotType.CHEST
    );
    public static final RegistryObject<EarthmawArmorSetItem> EARTHMAW_LEGGINGS = ItemHelper.registerEarthmawArmor(
            "earthmaw_leggings", ITEMS, TAB, IDArmorMaterials.EARTHMAW_ARMOR, EquipmentSlotType.LEGS
    );
    public static final RegistryObject<EarthmawArmorSetItem> EARTHMAW_BOOTS = ItemHelper.registerEarthmawArmor(
            "earthmaw_boots", ITEMS, TAB, IDArmorMaterials.EARTHMAW_ARMOR, EquipmentSlotType.FEET
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
