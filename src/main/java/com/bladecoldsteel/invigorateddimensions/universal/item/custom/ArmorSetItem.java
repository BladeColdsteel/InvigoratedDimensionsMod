package com.bladecoldsteel.invigorateddimensions.universal.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArmorSetItem extends ArmorItem {
    public ArmorSetItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isClientSide()) {
            if (this.slot != EquipmentSlotType.HEAD) return;
            if (hasFullSuitOfArmorOn(player)) {
                if (hasCorrectArmor(this.material, player)) {
                    if (player.tickCount % getSetBonusInterval() == 0) {
                        applyFullSetBonus(world, player, stack);
                    }
                }
            }
        }

        super.onArmorTick(stack, world, player);
    }

    protected void applyFullSetBonus(World world, PlayerEntity player, ItemStack item) {

    }

    protected int getSetBonusInterval() {
        return 1;
    }

    protected boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.inventory.getArmor(0);
        ItemStack leggings = player.inventory.getArmor(1);
        ItemStack chestplate = player.inventory.getArmor(2);
        ItemStack helmet = player.inventory.getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    protected boolean hasCorrectArmor(IArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem) player.inventory.getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.inventory.getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.inventory.getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.inventory.getArmor(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
