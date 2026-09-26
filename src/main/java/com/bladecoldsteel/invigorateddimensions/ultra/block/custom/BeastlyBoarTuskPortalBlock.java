package com.bladecoldsteel.invigorateddimensions.ultra.block.custom;

import com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.custom.BeastlyBoarTuskPortalTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BeastlyBoarTuskPortalBlock extends Block {
    protected static final VoxelShape PORTAL_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    public BeastlyBoarTuskPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isPassenger() && !entity.isVehicle()) {
            if (!world.isClientSide()) {
                TileEntity te = world.getBlockEntity(pos);
                if (te instanceof BeastlyBoarTuskPortalTileEntity) {
                    BlockPos destination = ((BeastlyBoarTuskPortalTileEntity) te).getDestination();
                    if (destination != null) {
                        entity.teleportTo(destination.getX() + 0.5, destination.getY(), destination.getZ() + 0.5);
                        world.playSound(null, pos.above(), SoundEvents.BEACON_DEACTIVATE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        world.setBlock(destination, Blocks.AIR.defaultBlockState(), 3);
                        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return PORTAL_AABB;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BeastlyBoarTuskPortalTileEntity();
    }
}
