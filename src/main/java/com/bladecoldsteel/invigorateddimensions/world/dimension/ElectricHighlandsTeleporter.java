package com.bladecoldsteel.invigorateddimensions.world.dimension;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.custom.ElectricHighlandsPortalBlock;
import com.bladecoldsteel.invigorateddimensions.world.ModPointsOfInterest;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.village.PointOfInterest;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.DimensionType;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class ElectricHighlandsTeleporter implements ITeleporter {

    protected final ServerWorld world;

    public ElectricHighlandsTeleporter(ServerWorld worldIn) {
        this.world = worldIn;
    }

    public Optional<TeleportationRepositioner.Result> getExistingPortal(BlockPos pos) {
        PointOfInterestManager poiManager = this.world.getPoiManager();
        poiManager.ensureLoadedAndValid(this.world, pos, 64);
        Optional<PointOfInterest> optional = poiManager.getInSquare((poiType) ->
                poiType == ModPointsOfInterest.ELECTRIC_HIGHLANDS_PORTAL.get(), pos, 64, PointOfInterestManager.Status.ANY).sorted(Comparator.<PointOfInterest>comparingDouble((poi) ->
                poi.getPos().distSqr(pos)).thenComparingInt((poi) ->
                poi.getPos().getY())).filter((poi) ->
                this.world.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();

        if (optional.isPresent()) {
            System.out.println("Existing portal found at: " + optional.get().getPos());
        } else {
            System.out.println("No existing portal found.");
        }

        return optional.map((poi) -> {
            BlockPos blockPos = poi.getPos();
            this.world.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockPos), 3, blockPos);
            BlockState blockState = this.world.getBlockState(blockPos);
            return TeleportationRepositioner.getLargestRectangleAround(blockPos, blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) ->
                    this.world.getBlockState(posIn) == blockState);
        });
    }

    public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis, Entity entity) {
        System.out.println("Creating new portal at position: " + pos + " with axis: " + axis);

        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.world.getWorldBorder();
        int dimensionLogicalHeight = this.world.getHeight() - 1;
        BlockPos.Mutable mutablePos = pos.mutable();

        for (BlockPos.Mutable blockPos$mutable1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(dimensionLogicalHeight, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, blockPos$mutable1.getX(), blockPos$mutable1.getZ()));
            if (worldborder.isWithinBounds(blockPos$mutable1) && worldborder.isWithinBounds(blockPos$mutable1.move(direction, 1))) {
                blockPos$mutable1.move(direction.getOpposite(), 1);

                for (int l = j; l >= 0; --l) {
                    blockPos$mutable1.setY(l);
                    if (this.world.isEmptyBlock(blockPos$mutable1)) {
                        int i1;
                        for (i1 = l; l > 0 && this.world.isEmptyBlock(blockPos$mutable1.move(Direction.DOWN)); --l) {
                            }

                        if (l + 4 <= dimensionLogicalHeight) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                blockPos$mutable1.setY(l);
                                if (this.checkRegionForPlacement(blockPos$mutable1, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(blockPos$mutable1);
                                    if (this.checkRegionForPlacement(blockPos$mutable1, mutablePos, direction, -1) && this.checkRegionForPlacement(blockPos$mutable1, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockPos$mutable1.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockPos$mutable1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), MathHelper.clamp(pos.getY(), 70, this.world.getHeight() - 10), pos.getZ())).immutable();
            Direction direction1 = direction.getClockWise();
            if (!worldborder.isWithinBounds(blockpos)) {
                return Optional.empty();
            }

            for (int l1 = -1; l1 < 2; ++l1) {
                for (int k2 = 0; k2 < 2; ++k2) {
                    for (int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockState = i3 < 0 ? ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockpos, k2 * direction.getStepX() + l1 * direction1.getStepX(), i3, k2 * direction.getStepZ() + l1 * direction1.getStepZ());
                        this.world.setBlockAndUpdate(mutablePos, blockState);
                    }
                }
            }
        }

        for (int k1 = -1; k1 < 3; ++k1) {
            for (int i2 = -1; i2 < 4; ++i2) {
                if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
                    mutablePos.setWithOffset(blockpos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                    this.world.setBlock(mutablePos, ElectricHighlandsBlocks.HIGHLANDS_PORTAL_FRAME.get().defaultBlockState(), 3);
                }
            }
        }

        BlockState electricHighlandsPortal = ElectricHighlandsBlocks.ELECTRIC_HIGHLANDS_PORTAL.get().defaultBlockState().setValue(ElectricHighlandsPortalBlock.AXIS, axis);

        for (int j2 = 0; j2 < 2; ++j2) {
            for (int l2 = 0; l2 < 3; ++l2) {
                mutablePos.setWithOffset(blockpos, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
                this.world.setBlock(mutablePos, electricHighlandsPortal, 18);
            }
        }

        return Optional.of(new TeleportationRepositioner.Result(blockpos.immutable(), 2, 3));

    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for (int i = -1; i < 3; ++i) {
            for (int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.world.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        boolean destinationIsElectricHighlands = destWorld.dimension() == ModDimensions.ELECTRIC_HIGHLANDS;
        if (entity.level.dimension() != ModDimensions.ELECTRIC_HIGHLANDS && !destinationIsElectricHighlands) {
            return null;
        } else {
            WorldBorder border = destWorld.getWorldBorder();
            double minX = Math.max(-2.9999872E7D, border.getMinX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, border.getMinZ() + 16.0D);
            double maxX = Math.min(2.9999872E7D, border.getMaxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, border.getMaxZ() - 16.0D);
            double coordinateDifference = DimensionType.getTeleportationScale(entity.level.dimensionType(), destWorld.dimensionType());
            BlockPos blockPos = new BlockPos(MathHelper.clamp(entity.getX() * coordinateDifference, minX, maxX), entity.getY(), MathHelper.clamp(entity.getZ() * coordinateDifference, minZ, maxZ));
            return this.getOrMakePortal(entity, blockPos).map((result) -> {
                BlockState blockState = entity.level.getBlockState(entity.portalEntrancePos);
                Direction.Axis axis;
                Vector3d vector3d;
                if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                    axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                    TeleportationRepositioner.Result rectangle = TeleportationRepositioner.getLargestRectangleAround(entity.portalEntrancePos, axis, 21, Direction.Axis.Y, 21, (pos) -> entity.level.getBlockState(pos) == blockState);
                    vector3d = entity.getRelativePortalPosition(axis, rectangle);
                } else {
                    axis = Direction.Axis.X;
                    vector3d = new Vector3d(0.5D, 0.0D, 0.0D);
                }

                return PortalSize.createPortalInfo(destWorld, result, axis, vector3d, entity.getDimensions(entity.getPose()), entity.getDeltaMovement(), entity.yRot, entity.xRot);
            }).orElse(null);
        }
    }

    protected Optional<TeleportationRepositioner.Result> getOrMakePortal(Entity entity, BlockPos pos) {
        Optional<TeleportationRepositioner.Result> existingPortal = this.getExistingPortal(pos);
        if (existingPortal.isPresent()) {
            return existingPortal;
        } else {
            Direction.Axis portalAxis = this.world.getBlockState(entity.portalEntrancePos).getOptionalValue(ElectricHighlandsPortalBlock.AXIS).orElse(Direction.Axis.X);
            return this.makePortal(pos, portalAxis, entity);
        }
    }

    @Override
    public boolean playTeleportSound(ServerPlayerEntity player, ServerWorld sourceWorld, ServerWorld destWorld) {
        return false;
    }
}
