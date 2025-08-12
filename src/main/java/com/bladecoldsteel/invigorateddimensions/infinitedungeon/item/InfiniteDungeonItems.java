package com.bladecoldsteel.invigorateddimensions.infinitedungeon.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.infinitedungeon.block.InfiniteDungeonBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InfiniteDungeonItems {
    private static final ItemGroup TAB = InfiniteDungeonItemGroup.FIGHTING_RIFT_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.register(
            "tough_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.INFINITE_DUNGEON, () -> InfiniteDungeonBlocks.PORTAL.get()),
            TAB
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
