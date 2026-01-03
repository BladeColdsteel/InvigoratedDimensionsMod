package com.bladecoldsteel.invigorateddimensions.insectoidparadisio.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.insectoidparadisio.block.InsectoidParadisioBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InsectoidParadisioItems {
    private static final ItemGroup TAB = InsectoidParadisioItemGroup.INSECTOID_PARADISIO_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "bugged_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.INSECTIOD_PARADISIO, () -> InsectoidParadisioBlocks.PORTAL.get()),
            TAB
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
