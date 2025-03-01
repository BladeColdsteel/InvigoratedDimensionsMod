package com.bladecoldsteel.invigorateddimensions.electrichighlands.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom.ElectricHighlandsActivatorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<Item> ELECTRIC_HIGHLANDS_ACTIVATOR = ITEMS.register("electric_highlands_activator",
            ElectricHighlandsActivatorItem::new);
    public static final RegistryObject<Item> VOLTCRYST = ITEMS.register("voltcryst",
            () -> new Item(new Item.Properties().tab(ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP)));

    public static final RegistryObject<Item> ELECTRICALLY_CHARGED_SIGN = ITEMS.register("electrically_charged_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16).tab(ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP),
                    ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN.get(), ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
