package com.bladecoldsteel.invigorateddimensions.grassyknoll.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.block.GrassyKnollBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.bladecoldsteel.invigorateddimensions.util.ItemHelper.foodItem;

public class GrassyKnollItems {
    private static final ItemGroup TAB = GrassyKnollItemGroup.GRASSY_KNOLL_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "grassy_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.GRASSY_KNOLL, () -> GrassyKnollBlocks.PORTAL.get()),
            TAB
    );
    public static final RegistryObject<Item> APPLESAUCE = ItemHelper.registerFood(
            "splattered_applesauce", ITEMS, new Item.Properties().food(foodItem(
                    5,
                    0.3F,
                    false,
                    false,
                    false,
                    null,
                    0.0F,
                    0,
                    0)),
            TAB
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
