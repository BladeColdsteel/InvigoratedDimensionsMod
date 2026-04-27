package com.bladecoldsteel.invigorateddimensions.terranata.item.custom;

import com.bladecoldsteel.invigorateddimensions.universal.item.custom.ArmorSetItem;
import com.bladecoldsteel.invigorateddimensions.universal.network.PlayerInputState;
import com.bladecoldsteel.invigorateddimensions.util.InvigoratedTags;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EarthmawArmorSetItem extends ArmorSetItem {
    public EarthmawArmorSetItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    protected void applyFullSetBonus(World world, PlayerEntity player, ItemStack item) {
        if (world.isClientSide()) return;

        List<BlockPos> targets = getTargetPos(player);

        for (BlockPos targetPos : targets) {
            if (isBreakable(world, targetPos)) {
                world.destroyBlock(targetPos, true);
            }
        }
    }

    @Override
    protected int getSetBonusInterval() {
        return 10;
    }

    private List<BlockPos> getTargetPos(PlayerEntity player) {
        List<BlockPos> targets = new ArrayList<>();
        BlockPos playerPos = player.blockPosition();

        if (PlayerInputState.isPressingForward(player.getUUID())) {
            BlockPos inFront = playerPos.relative(player.getDirection());
            targets.add(inFront);
            targets.add(inFront.above());
        }
        if (PlayerInputState.isPressingDrillUp(player.getUUID())) {
            targets.add(playerPos.above(2));
        }
        if (PlayerInputState.isPressingSneak(player.getUUID())) {
            targets.add(playerPos.below());
        }
        if (PlayerInputState.isPressingLeft(player.getUUID())) {
            targets.add(playerPos.relative(player.getDirection().getCounterClockWise()));
        }
        if (PlayerInputState.isPressingRight(player.getUUID())) {
            targets.add(playerPos.relative(player.getDirection().getClockWise()));
        }
        return targets;
    }

    private boolean isBreakable(World world, BlockPos pos) {
        return world.getBlockState(pos).is(InvigoratedTags.Blocks.EARTHMAW_ARMOR_BREAKABLE_BLOCKS);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new StringTextComponent("Relic").withStyle(TextFormatting.GOLD));
        super.appendHoverText(stack, world, tooltip, flag);
    }

    @Override
    public Rarity getRarity(ItemStack p_77613_1_) {
        return Rarity.EPIC;
    }
}
