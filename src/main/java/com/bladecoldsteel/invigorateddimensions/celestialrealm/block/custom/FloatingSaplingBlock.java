package com.bladecoldsteel.invigorateddimensions.celestialrealm.block.custom;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FloatingSaplingBlock extends SaplingBlock {
    public FloatingSaplingBlock(Tree tree, Properties properties) {
        super(tree, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(HeavenlyRealmBlocks.STONE.get()) || super.mayPlaceOn(state, worldIn, pos);
    }
}
