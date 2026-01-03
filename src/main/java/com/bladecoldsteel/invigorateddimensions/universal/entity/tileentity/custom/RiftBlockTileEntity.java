package com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.UniversalTileEntities;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfo;
import com.bladecoldsteel.invigorateddimensions.util.DimensionInfoDataLoader;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RiftBlockTileEntity extends TileEntity implements ITickableTileEntity {
    private ResourceLocation targetDimension = null;
    public RiftBlockTileEntity() {
        super(UniversalTileEntities.RIFT_BLOCK_TILE.get());
    }

    public void setTargetDimension(ResourceLocation targetDimension) {
        this.targetDimension = targetDimension;
        this.setChanged();
    }

    public ResourceLocation getTargetDimension() {
        return targetDimension;
    }

    @Override
    public void tick() {
        if (level == null || level.isClientSide || targetDimension == null) return;

        DimensionInfo info = DimensionInfoDataLoader.INSTANCE.dimensionData.get(targetDimension);
        if (info == null) return;

        int color = info.color;
        float r = ((color >> 16) & 0xFF) / 255F;
        float g = ((color >> 8) & 0xFF) / 255F;
        float b = (color & 0xFF) / 255F;

        level.addParticle(
                new RedstoneParticleData(r, g, b, 1.0F),
                worldPosition.getX() + 0.5 + (level.random.nextDouble() - 0.5),
                worldPosition.getY() + 1.1,
                worldPosition.getZ() + 0.5 + (level.random.nextDouble() - 0.5),
                0, 0.01, 0
        );
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
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
}
