package com.bladecoldsteel.invigorateddimensions.electrichighlands.item.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IServerWorldInfo;

import javax.annotation.Nullable;
import java.util.List;

public class TempestBoltItem extends LightningBoltItem{
    public TempestBoltItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void weatherLightning(World world, PlayerEntity player, Hand hand) {
        ItemStack item = player.getItemInHand(hand);
        if (!world.isClientSide && world instanceof ServerWorld) {
            IServerWorldInfo info = (IServerWorldInfo) world.getLevelData();

            if (world.isThundering()) {

            } else if (world.isRaining()) {
                info.setThundering(true);
                info.setThunderTime(6000);
            } else {
                info.setRaining(true);
                info.setRainTime(6000);
            }

            super.weatherLightning(world, player, hand);
        }
    }

    @Override
    protected void consumeOnUse(ItemStack item, PlayerEntity player) {
        if (!player.abilities.instabuild) {
            item.hurtAndBreak(1, player, broken ->
                    broken.broadcastBreakEvent(EquipmentSlotType.MAINHAND));
        }
    }

    @Override
    protected int getStrikeRadius(World world) {
        if (world.isThundering()) {
            return 4;
        } else if (world.isRaining()) {
            return 2;
        }

        return 1;
    }

    @Override
    protected int getStrikeCount(World world) {
        if (world.isThundering()) {
            return 6;
        } else if (world.isRaining()) {
            return 3;
        }

        return 1;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Relic").withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public boolean isFoil(ItemStack p_77636_1_) {
        return true;
    }
}
