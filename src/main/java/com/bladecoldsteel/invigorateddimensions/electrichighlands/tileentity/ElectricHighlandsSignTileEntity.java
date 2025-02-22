package com.bladecoldsteel.invigorateddimensions.electrichighlands.tileentity;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ElectricHighlandsSignTileEntity extends SignTileEntity {
    public ElectricHighlandsSignTileEntity() {
        super();
    }

    @Override
    public TileEntityType<?> getType() {
        return ElectricHighlandsTileEntities.SIGN_TILE_ENTITIES.get();
    }
}
