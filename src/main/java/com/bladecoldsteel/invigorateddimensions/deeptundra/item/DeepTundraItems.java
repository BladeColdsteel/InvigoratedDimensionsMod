package com.bladecoldsteel.invigorateddimensions.deeptundra.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.deeptundra.block.DeepTundraBlocks;
import com.bladecoldsteel.invigorateddimensions.deeptundra.item.custom.RimeboundCoreItem;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom.TempestBoltItem;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepTundraItems {
    private static final ItemGroup TAB = DeepTundraItemGroup.ICEY_RIFT_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "icey_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.DEEP_TUNDRA, () -> DeepTundraBlocks.PORTAL.get()),
            TAB
    );

    //Relic
    public static final RegistryObject<RimeboundCoreItem> RIMEBOUND_CORE = ITEMS.register("rimebound_core",
            () -> new RimeboundCoreItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .tab(TAB)
                    .durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
