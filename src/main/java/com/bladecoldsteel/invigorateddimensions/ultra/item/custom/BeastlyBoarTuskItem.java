package com.bladecoldsteel.invigorateddimensions.ultra.item.custom;

import com.bladecoldsteel.invigorateddimensions.ultra.block.UltraDimBlocks;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.custom.BeastlyBoarTuskPortalTileEntity;
import com.bladecoldsteel.invigorateddimensions.universal.item.IDToolMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeastlyBoarTuskItem extends SwordItem {
    public BeastlyBoarTuskItem(int extraDamage, float extraAttackSpeed, Properties properties) {
        super(IDToolMaterials.ULTRA_BOAR_TUSK, extraDamage, extraAttackSpeed, properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        CompoundNBT tag = stack.getOrCreateTag();
        BlockState stateAbove = world.getBlockState(clickedPos.above());
        BlockState stateAboveAbove = world.getBlockState(clickedPos.above().above());

        if (!world.isClientSide) {
            if (player != null) {
                if (stateAbove.is(Blocks.AIR) && stateAboveAbove.is(Blocks.AIR) && !tag.contains("FirstPosX")) {
                    tag.putInt("FirstPosX", clickedPos.above().getX());
                    tag.putInt("FirstPosY", clickedPos.above().getY());
                    tag.putInt("FirstPosZ", clickedPos.above().getZ());
                    world.playSound(null, clickedPos.above(), SoundEvents.END_PORTAL_FRAME_FILL, SoundCategory.PLAYERS, 1.0F, 1.0F);
                } else if (stateAbove.is(Blocks.AIR) && stateAboveAbove.is(Blocks.AIR) && tag.contains("FirstPosX")) {
                    BlockPos firstPortal = new BlockPos(
                            tag.getInt("FirstPosX"),
                            tag.getInt("FirstPosY"),
                            tag.getInt("FirstPosZ")
                    );

                    BlockPos secondPortal = clickedPos.above();

                    if (!firstPortal.equals(secondPortal)) {
                        world.setBlock(firstPortal, UltraDimBlocks.BEASTLY_BOAR_PORTAL.get().defaultBlockState(), 3);
                        world.setBlock(secondPortal, UltraDimBlocks.BEASTLY_BOAR_PORTAL.get().defaultBlockState(), 3);
                        world.playSound(null, firstPortal, SoundEvents.BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        world.playSound(null, secondPortal, SoundEvents.BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);

                        TileEntity te1 = world.getBlockEntity(firstPortal);
                        TileEntity te2 = world.getBlockEntity(secondPortal);

                        if (te1 instanceof BeastlyBoarTuskPortalTileEntity && te2 instanceof BeastlyBoarTuskPortalTileEntity) {
                            BeastlyBoarTuskPortalTileEntity portal1 = (BeastlyBoarTuskPortalTileEntity) te1;
                            BeastlyBoarTuskPortalTileEntity portal2 = (BeastlyBoarTuskPortalTileEntity) te2;

                            portal1.setDestination(secondPortal);
                            portal2.setDestination(firstPortal);

                            tag.remove("FirstPosX");
                            tag.remove("FirstPosY");
                            tag.remove("FirstPosZ");

                            player.getCooldowns().addCooldown(this, 30 * 20);
                        } else {
                            System.out.println("[Boar Portal] ERROR: Tile entities are wrong or null");
                        }
                    } else {
                        System.out.println("[Boar Portal] ERROR: Portal positions are identical");
                    }
                } else {
                    System.out.println("[Boar Portal] ERROR: Portal space is obstructed");
                }
            } else {
                System.out.println("[Boar Portal] ERROR: Player is null");
            }
        }
        return ActionResultType.SUCCESS;
    }
}
