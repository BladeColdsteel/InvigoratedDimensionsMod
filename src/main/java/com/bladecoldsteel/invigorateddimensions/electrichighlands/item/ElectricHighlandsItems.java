package com.bladecoldsteel.invigorateddimensions.electrichighlands.item;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom.LightningBoltItem;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom.TempestBoltItem;
import com.bladecoldsteel.invigorateddimensions.universal.item.IDArmorMaterials;
import com.bladecoldsteel.invigorateddimensions.universal.item.IDToolMaterials;
import com.bladecoldsteel.invigorateddimensions.universal.item.custom.UniversalActivatorItem;
import com.bladecoldsteel.invigorateddimensions.util.ItemHelper;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElectricHighlandsItems {
    private static final ItemGroup TAB = ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP;
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InvigoratedDimensions.MOD_ID);

    //Activator
    public static final RegistryObject<UniversalActivatorItem> ACTIVATOR = ItemHelper.registerActivator(
            "electric_highlands_activator", ITEMS, ItemHelper.activatorItem(ModDimensions.ELECTRIC_HIGHLANDS, () -> ElectricHighlandsBlocks.PORTAL.get()),
            TAB
    );
    //Gem
    public static final RegistryObject<Item> VOLTCRYST = ITEMS.register("voltcryst",
            () -> new Item(new Item.Properties().tab(ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP)));
    //Tools
    public static final RegistryObject<SwordItem> VOLTCRYST_SWORD = ItemHelper.registerSword(
            "voltcryst_sword", ITEMS, TAB, IDToolMaterials.VOLTCRYST, 2, 1.6F);
    public static final RegistryObject<PickaxeItem> VOLTCRYST_PICKAXE = ItemHelper.registerPickaxe(
            "voltcryst_pickaxe", ITEMS, TAB, IDToolMaterials.VOLTCRYST, 0, 1.2F);
    public static final RegistryObject<AxeItem> VOLTCRYST_AXE = ItemHelper.registerAxe(
            "voltcryst_axe", ITEMS, TAB, IDToolMaterials.VOLTCRYST, 1, 0.8F);
    public static final RegistryObject<ShovelItem> VOLTCRYST_SHOVEL = ItemHelper.registerShovel(
            "voltcryst_shovel", ITEMS, TAB, IDToolMaterials.VOLTCRYST, -2, 1F);
    public static final RegistryObject<HoeItem> VOLTCRYST_HOE = ItemHelper.registerHoe(
            "voltcryst_hoe", ITEMS, TAB, IDToolMaterials.VOLTCRYST, -2, 1F);
    //Ingot

    //Sign
    public static final RegistryObject<Item> ELECTRICALLY_CHARGED_SIGN = ITEMS.register("electrically_charged_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16).tab(ElectricHighlandsItemGroup.ELECTRIC_HIGHLANDS_GROUP),
                    ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_SIGN.get(), ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_WALL_SIGN.get()));
    //Other
    public static final RegistryObject<LightningBoltItem> LIGHTNING_BOLT = ITEMS.register("lightning_bolt",
            () -> new LightningBoltItem(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .tab(TAB)
                    .stacksTo(16)));
    //Relic
    public static final RegistryObject<TempestBoltItem> TEMPEST_BOLT = ITEMS.register("tempest_bolt",
            () -> new TempestBoltItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .tab(TAB)
                    .durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
