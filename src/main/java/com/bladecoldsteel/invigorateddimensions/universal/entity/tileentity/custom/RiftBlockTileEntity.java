package com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.UniversalTileEntities;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RiftBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private ResourceLocation targetDimension = null;
    public RiftBlockTileEntity() {
        super(UniversalTileEntities.RIFT_BLOCK_TILE.get());
    }

    public void setTargetDimension(ResourceLocation targetDimension) {
        this.targetDimension = targetDimension;
        this.setChanged();

        if (level != null) {
            BlockState state = getBlockState();
            level.sendBlockUpdated(worldPosition, state, state, 3);
        }
    }

    public ResourceLocation getTargetDimension() {
        return targetDimension;
    }

    @Override
    public void tick() {
        if (level == null || !level.isClientSide || targetDimension == null) return;

        DimensionInfo info = DimensionInfoDataLoader.INSTANCE.dimensionData.get(targetDimension);
        if (info == null) return;

        int coneHeight = 20;
        double coneSpeed = 0.25;
        double coneWidth = 0.6;
        int coneDensity = 32;

        double centerX = worldPosition.getX() + 0.5;
        double centerY = worldPosition.getY() + 0.2;
        double centerZ = worldPosition.getZ() + 0.5;

        double time = level.getGameTime() * coneSpeed;

        for (int i = 0; i < coneDensity; i++) {
            double height = ((level.getGameTime() + i * 4) % coneHeight) * 0.05;
            double radius = height * coneWidth;
            double angle = time + i * (Math.PI / 3);

            double x = centerX + Math.cos(angle) * radius;
            double y = centerY + height - 0.1;
            double z = centerZ + Math.sin(angle) * radius;

            level.addParticle(
                    particleFromColor(info.color, 1.5F),
                    x, y, z,
                    0.0D, 0.05D, 0D
            );
        }
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        targetDimension = null;

        if (nbt.contains("TargetDimension")) {
            targetDimension = new ResourceLocation(nbt.getString("TargetDimension"));
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        if (targetDimension != null) {
            nbt.putString("TargetDimension", targetDimension.toString());
        }
        return nbt;
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.save(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.load(state, tag);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT tag = new CompoundNBT();
        this.save(tag);
        return new SUpdateTileEntityPacket(this.getBlockPos(), 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.load(this.getBlockState(), pkt.getTag());
    }

    private static RedstoneParticleData particleFromColor(int color, float scale) {
        float r = ((color >> 16) & 0XFF) / 255.0F;
        float g = ((color >> 8) & 0XFF) / 255.0F;
        float b = (color & 0XFF) / 255.0F;

        return new RedstoneParticleData(r, g, b, scale);
    }
}
