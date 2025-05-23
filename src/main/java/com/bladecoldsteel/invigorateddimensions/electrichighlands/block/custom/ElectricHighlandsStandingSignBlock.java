package com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.tileentity.ElectricHighlandsSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ElectricHighlandsStandingSignBlock extends StandingSignBlock {
    public ElectricHighlandsStandingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ElectricHighlandsSignTileEntity();
    }
}
