package com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.ultra.entity.tileentity.UltraDimTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class BeastlyBoarTuskPortalTileEntity extends TileEntity {
    private BlockPos destination;
    public BeastlyBoarTuskPortalTileEntity() {
        super(UltraDimTileEntities.BEASTLY_BOAR_PORTAL_TILE.get());
        System.out.println("[Boar Portal TE] CONSTRUCTOR CALLED");
    }

    public void setDestination(BlockPos destination) {
        this.destination = destination;
        setChanged();
    }

    public BlockPos getDestination() {
        return destination;
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putBoolean("HasDestination", destination != null);
        if (destination != null) {
            nbt.putInt("DestinationX", destination.getX());
            nbt.putInt("DestinationY", destination.getY());
            nbt.putInt("DestinationZ", destination.getZ());
        }
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        if (nbt.getBoolean("HasDestination")) {
            destination = new BlockPos(nbt.getInt("DestinationX"), nbt.getInt("DestinationY"), nbt.getInt("DestinationZ"));
        } else {
            destination = null;
        }
    }
}
