package com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.world.ModParticleTypes;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.util.ElectricHighlandsSoundEvents;
import com.bladecoldsteel.invigorateddimensions.world.dimension.UniversalTeleporter;
import com.bladecoldsteel.invigorateddimensions.world.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;
import java.util.Random;

public class ElectricHighlandsPortalBlock extends Block {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public ElectricHighlandsPortalBlock() {
        super(Properties.of(Material.PORTAL)
                .strength(-1f)
                .noCollission()
                .lightLevel((state) -> 10)
                .noDrops()
        );
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(AXIS)) {
            case Z:
                return Z_AABB;
            case X:
            default:
                return X_AABB;
        }
    }

    public boolean trySpawnPortal(IWorld worldIn, BlockPos pos) {
        ElectricHighlandsPortalBlock.Size ElectricHighlandsPortalBlock$size = this.isPortal(worldIn, pos);
        if (ElectricHighlandsPortalBlock$size != null && !onTrySpawnPortal(worldIn, pos, ElectricHighlandsPortalBlock$size)) {
            ElectricHighlandsPortalBlock$size.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    public static boolean onTrySpawnPortal(IWorld world, BlockPos pos, ElectricHighlandsPortalBlock.Size size) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final ElectricHighlandsPortalBlock.Size size;

        public PortalSpawnEvent(IWorld world, BlockPos pos, BlockState state, ElectricHighlandsPortalBlock.Size size) {
            super(world, pos, state);
            this.size = size;
        }

        public ElectricHighlandsPortalBlock.Size getPortalSize() {
            return size;
        }
    }

    @Nullable
    public ElectricHighlandsPortalBlock.Size isPortal(IWorld worldIn, BlockPos pos) {
        ElectricHighlandsPortalBlock.Size ElectricHighlandsPortalBlock$size = new Size(worldIn, pos, Direction.Axis.X);
        if (ElectricHighlandsPortalBlock$size.isValid() && ElectricHighlandsPortalBlock$size.portalBlockCount == 0) {
            return ElectricHighlandsPortalBlock$size;
        } else {
            ElectricHighlandsPortalBlock.Size ElectricHighlandsPortalBlock$size1 = new Size(worldIn, pos, Direction.Axis.Z);
            return ElectricHighlandsPortalBlock$size1.isValid() && ElectricHighlandsPortalBlock$size1.portalBlockCount == 0 ? ElectricHighlandsPortalBlock$size1 : null;
        }
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new Size(worldIn, currentPos, direction$axis1)).validatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entity) {
        if(!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
            if(entity.isOnPortalCooldown()) {
                entity.setPortalCooldown();
            }
            else {
                if(!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
                    entity.portalEntrancePos = pos.immutable();
                }
                World entityWorld = entity.level;
                if(entityWorld != null) {
                    MinecraftServer minecraftserver = entityWorld.getServer();
                    RegistryKey<World> destination = entity.level.dimension() == ModDimensions.ELECTRIC_HIGHLANDS ? World.OVERWORLD : ModDimensions.ELECTRIC_HIGHLANDS;
                    if(minecraftserver != null) {
                        ServerWorld destinationWorld = minecraftserver.getLevel(destination);
                        if(destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                            entity.level.getProfiler().push("electric_highlands_portal");
                            entity.setPortalCooldown();
                            entity.changeDimension(destinationWorld, new UniversalTeleporter(destinationWorld, null, null, null, null));
                            entity.level.getProfiler().pop();
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0) {
            worldIn.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, ElectricHighlandsSoundEvents.ELECTRIC_HIGHLANDS_PORTAL_AMBIENT.get(), SoundCategory.BLOCKS, 0.3F, random.nextFloat() * 0.4F + 0.8F, false);
        }
        for (int i = 0; i < 4; ++i) {
            double x = (double)pos.getX() + random.nextDouble();
            double y = (double)pos.getY() + random.nextDouble();
            double z = (double)pos.getZ() + random.nextDouble();
            double xSpeed = ((double)random.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double)random.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double)random.nextFloat() - 0.5D) * 0.5D;
            int j = random.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
                x = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                xSpeed = random.nextFloat() * 2.0F * (float)j;
            } else {
                z = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                zSpeed = random.nextFloat() * 2.0F * (float)j;
            }

            worldIn.addParticle(ModParticleTypes.ELECTRIC_HIGHLANDS_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);

        }
    }

    @Override
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch (state.getValue(AXIS)) {
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public static class Size {
        private final IWorld world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        @Nullable
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
            this.world = worldIn;
            this.axis = axisIn;
            if (axisIn == Direction.Axis.X) {
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            } else {
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            for (BlockPos blockPos = pos; pos.getY() > blockPos.getY() - 21 && pos.getY() > 0 && this.canConnect(worldIn.getBlockState(pos.below())); pos = pos.below()) {
                ;
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if (i >= 0) {
                this.bottomLeft = pos.relative(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }
        }

        protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
            int i;
            for (i = 0; i < 22; i++) {
                BlockPos blockPos = pos.relative(directionIn, i);
                if (!this.canConnect(this.world.getBlockState(blockPos)) || !(this.world.getBlockState(blockPos.below()).getBlock().is(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get()))) {
                    break;
                }
            }

            BlockPos framePos = pos.relative(directionIn, i);
            return this.world.getBlockState(framePos).getBlock().is(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get()) ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected int calculatePortalHeight() {
            label56:
            for (this.height = 0; this.height < 21; ++this.height) {
                for (int i = 0; i < this.width; ++i) {
                    BlockPos blockPos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
                    BlockState blockState = this.world.getBlockState(blockPos);
                    if (!this.canConnect(blockState)) {
                        break label56;
                    }

                    Block block = blockState.getBlock();
                    if (block == ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get()) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        BlockPos framePos = blockPos.relative(this.leftDir);
                        if (!(this.world.getBlockState(framePos).getBlock().is(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get()))) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        BlockPos framePos = blockPos.relative(this.rightDir);
                        if (!(this.world.getBlockState(framePos).getBlock().is(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get()))) {
                            break label56;
                        }
                    }
                }
            }

            for (int j = 0; j < width; ++j) {
                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
                if (!(this.world.getBlockState(framePos).getBlock().is(ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get()))) {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        protected boolean canConnect(BlockState pos) {
            Block block = pos.getBlock();
            return pos.isAir() || block == ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get();
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks() {
            for (int i = 0; i < this.width; ++i) {
                BlockPos blockPos = this.bottomLeft.relative(this.rightDir, i);

                for (int j = 0; j < this.height; ++j) {
                    this.world.setBlock(blockPos.above(j), ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get().defaultBlockState().setValue(ElectricHighlandsPortalBlock.AXIS, this.axis), 18);
                }
            }
        }

        private boolean isPortalCountValidForSize() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean validatePortal() {
            return this.isValid() && this.isPortalCountValidForSize();
        }

    }

}
