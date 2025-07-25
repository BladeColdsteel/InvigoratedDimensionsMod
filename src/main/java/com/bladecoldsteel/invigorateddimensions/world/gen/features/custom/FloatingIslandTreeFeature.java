package com.bladecoldsteel.invigorateddimensions.world.gen.features.custom;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;

import java.util.*;

import static net.minecraft.world.gen.feature.TreeFeature.isFree;
import static net.minecraft.world.gen.feature.TreeFeature.setBlockKnownShape;

public class FloatingIslandTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public FloatingIslandTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    private static boolean isFloatingStone(IWorldGenerationBaseReader p_236418_0_, BlockPos p_236418_1_) {
        return p_236418_0_.isStateAtPosition(p_236418_1_, (p_236409_0_) -> {
            Block lvt_1_1_ = p_236409_0_.getBlock();
            return lvt_1_1_ == HeavenlyRealmBlocks.STONE.get();
        });
    }

    @Override
    public boolean place(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, BaseTreeFeatureConfig config) {
        Set<BlockPos> lvt_6_1_ = Sets.newHashSet();
        Set<BlockPos> lvt_7_1_ = Sets.newHashSet();
        Set<BlockPos> lvt_8_1_ = Sets.newHashSet();
        MutableBoundingBox lvt_9_1_ = MutableBoundingBox.getUnknownBox();
        boolean lvt_10_1_ = this.doPlace(iSeedReader, random, blockPos, lvt_6_1_, lvt_7_1_, lvt_9_1_, config);
        if (lvt_9_1_.x0 <= lvt_9_1_.x1 && lvt_10_1_ && !lvt_6_1_.isEmpty()) {
            if (!config.decorators.isEmpty()) {
                List<BlockPos> lvt_11_1_ = Lists.newArrayList(lvt_6_1_);
                List<BlockPos> lvt_12_1_ = Lists.newArrayList(lvt_7_1_);
                lvt_11_1_.sort(Comparator.comparingInt(Vector3i::getY));
                lvt_12_1_.sort(Comparator.comparingInt(Vector3i::getY));
                config.decorators.forEach((p_236405_6_) -> {
                    p_236405_6_.place(iSeedReader, random, lvt_11_1_, lvt_12_1_, lvt_8_1_, lvt_9_1_);
                });
            }

            VoxelShapePart lvt_11_2_ = this.updateLeaves(iSeedReader, lvt_9_1_, lvt_6_1_, lvt_8_1_);
            Template.updateShapeAtEdge(iSeedReader, 3, lvt_11_2_, lvt_9_1_.x0, lvt_9_1_.y0, lvt_9_1_.z0);
            return true;
        } else {
            return false;
        }
    }

    private boolean doPlace(IWorldGenerationReader world, Random random, BlockPos blockPos, Set<BlockPos> setPos1, Set<BlockPos> setPos2, MutableBoundingBox boundingBox, BaseTreeFeatureConfig treeConfig) {
        int lvt_8_1_ = treeConfig.trunkPlacer.getTreeHeight(random);
        int lvt_9_1_ = treeConfig.foliagePlacer.foliageHeight(random, lvt_8_1_, treeConfig);
        int lvt_10_1_ = lvt_8_1_ - lvt_9_1_;
        int lvt_11_1_ = treeConfig.foliagePlacer.foliageRadius(random, lvt_10_1_);
        BlockPos lvt_12_2_;
        int lvt_14_2_;
        if (!treeConfig.fromSapling) {
            int lvt_13_1_ = world.getHeightmapPos(Heightmap.Type.OCEAN_FLOOR, blockPos).getY();
            lvt_14_2_ = world.getHeightmapPos(Heightmap.Type.WORLD_SURFACE, blockPos).getY();
            if (lvt_14_2_ - lvt_13_1_ > treeConfig.maxWaterDepth) {
                return false;
            }

            int lvt_15_3_;
            if (treeConfig.heightmap == Heightmap.Type.OCEAN_FLOOR) {
                lvt_15_3_ = lvt_13_1_;
            } else if (treeConfig.heightmap == Heightmap.Type.WORLD_SURFACE) {
                lvt_15_3_ = lvt_14_2_;
            } else {
                lvt_15_3_ = world.getHeightmapPos(treeConfig.heightmap, blockPos).getY();
            }

            lvt_12_2_ = new BlockPos(blockPos.getX(), lvt_15_3_, blockPos.getZ());
        } else {
            lvt_12_2_ = blockPos;
        }

        if (lvt_12_2_.getY() >= 1 && lvt_12_2_.getY() + lvt_8_1_ + 1 <= 256) {
            if (!isFloatingStone(world, lvt_12_2_.below())) {
                return false;
            } else {
                OptionalInt lvt_13_2_ = treeConfig.minimumSize.minClippedHeight();
                lvt_14_2_ = this.getMaxFreeTreeHeight(world, lvt_8_1_, lvt_12_2_, treeConfig);
                if (lvt_14_2_ >= lvt_8_1_ || lvt_13_2_.isPresent() && lvt_14_2_ >= lvt_13_2_.getAsInt()) {
                    List<FoliagePlacer.Foliage> lvt_15_4_ = treeConfig.trunkPlacer.placeTrunk(world, random, lvt_14_2_, lvt_12_2_, setPos1, boundingBox, treeConfig);
                    int finalLvt_14_2_ = lvt_14_2_;
                    lvt_15_4_.forEach((p_236407_8_) -> {
                        treeConfig.foliagePlacer.createFoliage(world, random, treeConfig, finalLvt_14_2_, p_236407_8_, lvt_9_1_, lvt_11_1_, setPos2, boundingBox);
                    });
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private static boolean isVine(IWorldGenerationBaseReader p_236414_0_, BlockPos p_236414_1_) {
        return p_236414_0_.isStateAtPosition(p_236414_1_, (p_236415_0_) -> {
            return p_236415_0_.is(Blocks.VINE);
        });
    }

    private int getMaxFreeTreeHeight(IWorldGenerationBaseReader p_241521_1_, int p_241521_2_, BlockPos p_241521_3_, BaseTreeFeatureConfig p_241521_4_) {
        BlockPos.Mutable lvt_5_1_ = new BlockPos.Mutable();

        for(int lvt_6_1_ = 0; lvt_6_1_ <= p_241521_2_ + 1; ++lvt_6_1_) {
            int lvt_7_1_ = p_241521_4_.minimumSize.getSizeAtHeight(p_241521_2_, lvt_6_1_);

            for(int lvt_8_1_ = -lvt_7_1_; lvt_8_1_ <= lvt_7_1_; ++lvt_8_1_) {
                for(int lvt_9_1_ = -lvt_7_1_; lvt_9_1_ <= lvt_7_1_; ++lvt_9_1_) {
                    lvt_5_1_.setWithOffset(p_241521_3_, lvt_8_1_, lvt_6_1_, lvt_9_1_);
                    if (!isFree(p_241521_1_, lvt_5_1_) || !p_241521_4_.ignoreVines && isVine(p_241521_1_, lvt_5_1_)) {
                        return lvt_6_1_ - 2;
                    }
                }
            }
        }

        return p_241521_2_;
    }

    private VoxelShapePart updateLeaves(IWorld p_236403_1_, MutableBoundingBox p_236403_2_, Set<BlockPos> p_236403_3_, Set<BlockPos> p_236403_4_) {
        List<Set<BlockPos>> lvt_5_1_ = Lists.newArrayList();
        VoxelShapePart lvt_6_1_ = new BitSetVoxelShapePart(p_236403_2_.getXSpan(), p_236403_2_.getYSpan(), p_236403_2_.getZSpan());
        boolean lvt_7_1_ = true;

        for(int lvt_8_1_ = 0; lvt_8_1_ < 6; ++lvt_8_1_) {
            lvt_5_1_.add(Sets.newHashSet());
        }

        BlockPos.Mutable lvt_8_2_ = new BlockPos.Mutable();
        Iterator var9 = Lists.newArrayList(p_236403_4_).iterator();

        BlockPos lvt_10_2_;
        while(var9.hasNext()) {
            lvt_10_2_ = (BlockPos)var9.next();
            if (p_236403_2_.isInside(lvt_10_2_)) {
                ((VoxelShapePart)lvt_6_1_).setFull(lvt_10_2_.getX() - p_236403_2_.x0, lvt_10_2_.getY() - p_236403_2_.y0, lvt_10_2_.getZ() - p_236403_2_.z0, true, true);
            }
        }

        var9 = Lists.newArrayList(p_236403_3_).iterator();

        while(var9.hasNext()) {
            lvt_10_2_ = (BlockPos)var9.next();
            if (p_236403_2_.isInside(lvt_10_2_)) {
                ((VoxelShapePart)lvt_6_1_).setFull(lvt_10_2_.getX() - p_236403_2_.x0, lvt_10_2_.getY() - p_236403_2_.y0, lvt_10_2_.getZ() - p_236403_2_.z0, true, true);
            }

            Direction[] var11 = Direction.values();
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
                Direction lvt_14_1_ = var11[var13];
                lvt_8_2_.setWithOffset(lvt_10_2_, lvt_14_1_);
                if (!p_236403_3_.contains(lvt_8_2_)) {
                    BlockState lvt_15_1_ = p_236403_1_.getBlockState(lvt_8_2_);
                    if (lvt_15_1_.hasProperty(BlockStateProperties.DISTANCE)) {
                        ((Set)lvt_5_1_.get(0)).add(lvt_8_2_.immutable());
                        setBlockKnownShape(p_236403_1_, lvt_8_2_, (BlockState)lvt_15_1_.setValue(BlockStateProperties.DISTANCE, 1));
                        if (p_236403_2_.isInside(lvt_8_2_)) {
                            ((VoxelShapePart)lvt_6_1_).setFull(lvt_8_2_.getX() - p_236403_2_.x0, lvt_8_2_.getY() - p_236403_2_.y0, lvt_8_2_.getZ() - p_236403_2_.z0, true, true);
                        }
                    }
                }
            }
        }

        for(int lvt_9_1_ = 1; lvt_9_1_ < 6; ++lvt_9_1_) {
            Set<BlockPos> lvt_10_3_ = (Set)lvt_5_1_.get(lvt_9_1_ - 1);
            Set<BlockPos> lvt_11_1_ = (Set)lvt_5_1_.get(lvt_9_1_);
            Iterator var25 = lvt_10_3_.iterator();

            while(var25.hasNext()) {
                BlockPos lvt_13_1_ = (BlockPos)var25.next();
                if (p_236403_2_.isInside(lvt_13_1_)) {
                    ((VoxelShapePart)lvt_6_1_).setFull(lvt_13_1_.getX() - p_236403_2_.x0, lvt_13_1_.getY() - p_236403_2_.y0, lvt_13_1_.getZ() - p_236403_2_.z0, true, true);
                }

                Direction[] var27 = Direction.values();
                int var28 = var27.length;

                for(int var16 = 0; var16 < var28; ++var16) {
                    Direction lvt_17_1_ = var27[var16];
                    lvt_8_2_.setWithOffset(lvt_13_1_, lvt_17_1_);
                    if (!lvt_10_3_.contains(lvt_8_2_) && !lvt_11_1_.contains(lvt_8_2_)) {
                        BlockState lvt_18_1_ = p_236403_1_.getBlockState(lvt_8_2_);
                        if (lvt_18_1_.hasProperty(BlockStateProperties.DISTANCE)) {
                            int lvt_19_1_ = (Integer)lvt_18_1_.getValue(BlockStateProperties.DISTANCE);
                            if (lvt_19_1_ > lvt_9_1_ + 1) {
                                BlockState lvt_20_1_ = (BlockState)lvt_18_1_.setValue(BlockStateProperties.DISTANCE, lvt_9_1_ + 1);
                                setBlockKnownShape(p_236403_1_, lvt_8_2_, lvt_20_1_);
                                if (p_236403_2_.isInside(lvt_8_2_)) {
                                    ((VoxelShapePart)lvt_6_1_).setFull(lvt_8_2_.getX() - p_236403_2_.x0, lvt_8_2_.getY() - p_236403_2_.y0, lvt_8_2_.getZ() - p_236403_2_.z0, true, true);
                                }

                                lvt_11_1_.add(lvt_8_2_.immutable());
                            }
                        }
                    }
                }
            }
        }

        return lvt_6_1_;
    }
}
