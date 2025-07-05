package com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom;

import com.bladecoldsteel.invigorateddimensions.universal.tileentity.UniversalTileEntities;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ElementalShrineTileEntity extends TileEntity {
    public ElementalShrineTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public ElementalShrineTileEntity() {
        this(UniversalTileEntities.ELEMENTAL_SHRINE_TILE.get());
    }
}
