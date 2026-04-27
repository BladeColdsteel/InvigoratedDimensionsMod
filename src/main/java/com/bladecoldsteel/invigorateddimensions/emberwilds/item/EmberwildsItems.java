package com.bladecoldsteel.invigorateddimensions.emberwilds.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.item.IDArmorMaterials;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalTooltipArmorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EmberwildsItems {
    private static final ItemGroup TAB = EmberwildsItemGroup.EMBERWILDS_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalTooltipArmorItem> FIRE_LORD_CROWN = ItemHelper.registerTooltipArmor(
            "fire_lord_crown", ITEMS, TAB, IDArmorMaterials.FIRE_LORD_CROWN, EquipmentSlotType.HEAD, new Item.Properties().rarity(Rarity.EPIC), "Relic");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
