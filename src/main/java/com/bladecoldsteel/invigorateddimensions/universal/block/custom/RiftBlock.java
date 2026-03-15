package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom.RiftBlockTileEntity;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import com.bladecoldsteel.invigorateddimensions.world.dimension.RiftTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

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
                int safeY = 60;
                Random random = new Random();
                BlockPos targetPos = new BlockPos(entity.position().x * 5, safeY + random.nextInt(21), entity.position().z * 5);
                player.changeDimension(destWorld, new RiftTeleporter(targetPos));
            }
        }
     }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
        if (world.isClientSide) {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof RiftBlockTileEntity) {
                RiftBlockTileEntity rift = (RiftBlockTileEntity) tile;
                ResourceLocation target = rift.getTargetDimension();

                if (target == null) {
                    player.displayClientMessage(new StringTextComponent("This rift has not been activated."), true);
                } else {
                    DimensionInfo info = DimensionInfoDataLoader.INSTANCE.dimensionData.get(target);

                    if (info != null) {
                        int colorCode = info.color;
                        player.displayClientMessage(new StringTextComponent("This energies from this rift lead to the " + info.name + "!"), true);
                    } else {
                        player.displayClientMessage(new StringTextComponent("This energies from this rift lead to the " + target.toString() + "!"), true);
                    }
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}
