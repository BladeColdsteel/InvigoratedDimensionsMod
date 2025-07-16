package com.bladecoldsteel.invigorateddimensions.universal.block.custom;

import com.bladecoldsteel.invigorateddimensions.universal.block.UniversalBlocks;
import com.bladecoldsteel.invigorateddimensions.universal.tileentity.custom.ElementalShrineTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class ElementalShrineBlock extends Block {
    public ElementalShrineBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isClientSide) {
            TileEntity te = world.getBlockEntity(pos);
            if (te instanceof ElementalShrineTileEntity && player instanceof ServerPlayerEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) te, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ElementalShrineTileEntity();
    }

    private static final VoxelShape SHRINE_SHAPE = makeShrineShape();

    private static VoxelShape makeShrineShape() {
        VoxelShape shape = Block.box(-4.992, 0.000, -4.992, 20.992, 2.000, 20.992);
        shape = VoxelShapes.or(shape, Block.box(-4.000, 2.000, -4.000, 20.000, 6.000, 20.000));
        shape = VoxelShapes.or(shape, Block.box(-3.008, 6.000, -3.008, 19.008, 16.000, 19.008));
        shape = VoxelShapes.or(shape, Block.box(-2.000, 16.000, -2.000, 18.000, 26.000, 18.000));
        shape = VoxelShapes.or(shape, Block.box(-0.992, 26.000, -0.992, 17.008, 42.000, 17.008));
        shape = VoxelShapes.or(shape, Block.box(0.000, 42.000, 0.000, 16.010, 50.000, 16.010));
        shape = VoxelShapes.or(shape, Block.box(0.992, 50.000, 0.992, 14.992, 54.000, 14.992));
        shape = VoxelShapes.or(shape, Block.box(2.000, 54.000, 2.000, 14.000, 56.000, 14.000));
        shape = VoxelShapes.or(shape, Block.box(3.008, 56.000, 3.008, 12.992, 58.000, 12.992));
        shape = VoxelShapes.or(shape, Block.box(4.992, 58.000, 4.992, 11.008, 60.000, 11.008));
        shape = VoxelShapes.or(shape, Block.box(6.000, 60.000, 6.000, 10.000, 62.000, 10.000));
        shape = VoxelShapes.or(shape, Block.box(7.008, 62.000, 7.008, 8.992, 64.000, 8.992));
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHRINE_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHRINE_SHAPE;
    }

    @Override
    public VoxelShape getInteractionShape(BlockState p_199600_1_, IBlockReader p_199600_2_, BlockPos p_199600_3_) {
        return SHRINE_SHAPE;
    }
}
