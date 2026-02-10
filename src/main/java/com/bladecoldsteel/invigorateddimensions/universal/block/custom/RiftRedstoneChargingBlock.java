package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;

public class RiftRedstoneChargingBlock extends RotatedPillarBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public RiftRedstoneChargingBlock() {
        super(Properties.of(Material.STONE)
                .strength(10.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .requiresCorrectToolForDrops());
        BlockState defaultBoolean = this.stateDefinition.any().setValue(POWERED, false);
        this.registerDefaultState(defaultBoolean);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder loot) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this));
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos1, Block block, BlockPos pos2, boolean isMoving) {
        if (world.isClientSide) return;

        boolean receivingPower = world.hasNeighborSignal(pos1);
        boolean currentlyPowered = state.getValue(POWERED);

        if (receivingPower != currentlyPowered) {
            world.setBlock(pos1, state.setValue(POWERED, receivingPower), 3);
        }

        super.neighborChanged(state, world, pos1, block, pos2, isMoving);
    }

    @Override
    public void onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            boolean receivingPower = world.hasNeighborSignal(pos);
            if (receivingPower != state.getValue(POWERED)) {
                world.setBlock(pos, state.setValue(POWERED, receivingPower), 3);
            }
        }
    }
}
