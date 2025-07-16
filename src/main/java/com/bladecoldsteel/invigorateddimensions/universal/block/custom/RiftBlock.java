package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.RiftBlockTileEntity;
import com.bladecoldsteel.invigorateddimensions.world.dimension.RiftTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class RiftBlock extends Block {
    public RiftBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new RiftBlockTileEntity();
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        super.stepOn(world, pos, entity);
        if (world.isClientSide) return;
        if (entity.getVehicle() != null || entity.isVehicle()) return;

        TileEntity tile = world.getBlockEntity(pos);
        if (!(tile instanceof RiftBlockTileEntity)) return;

        RiftBlockTileEntity rift = (RiftBlockTileEntity) tile;
        ResourceLocation target = rift.getTargetDimension();
        if (target == null) return;

        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            ServerWorld destWorld = world.getServer().getLevel(RegistryKey.create(Registry.DIMENSION_REGISTRY, target));

            if (destWorld != null && destWorld != player.level) {
                BlockPos targetPos = new BlockPos(entity.position().x * 5, entity.position().y, entity.position().z * 5);
                player.changeDimension(destWorld, new RiftTeleporter(targetPos));
            }
        }
     }
}
