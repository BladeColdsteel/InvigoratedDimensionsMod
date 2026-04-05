package com.bladecoldsteel.invigorateddimensions.universal.item.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class UniversalTooltipArmorItem extends ArmorItem {
    private final String lines;
    public UniversalTooltipArmorItem(Properties properties, IArmorMaterial armorMaterial, EquipmentSlotType armorSlot, String lines) {
        super(armorMaterial, armorSlot, properties);
        this.lines = lines;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent(lines).withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
