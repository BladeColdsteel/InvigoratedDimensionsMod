package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;

public class RiftChargingBlock extends RotatedPillarBlock {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public RiftChargingBlock() {
        super(Properties.of(Material.STONE)
                .strength(10.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(3)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(ACTIVE, false)
                .setValue(FACING, Direction.NORTH)
                .setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder loot) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(UniversalBlocks.PORTAL_CHARGING_BLOCK_REDSTONE.get()));
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, ACTIVE);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction.Axis axis = context.getClickedFace().getAxis();
        Direction facing = context.getHorizontalDirection().getOpposite();

        if (axis == Direction.Axis.X) {
            facing = (facing.getAxis() == Direction.Axis.X) ? facing : Direction.EAST;
        } else if (axis == Direction.Axis.Z) {
            facing = (facing.getAxis() == Direction.Axis.Z) ? facing : Direction.SOUTH;
        }

        return this.defaultBlockState()
                .setValue(AXIS, axis)
                .setValue(FACING, facing)
                .setValue(ACTIVE, false);
    }
}
