package com.bladecoldsteel.invigorateddimensions.world.gen.structure;

import com.bladecoldsteel.invigorateddimensions.world.gen.InvigoratedPieces;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ShrinePiece extends AbstractVillagePiece {
    private static final Logger LOGGER = LogManager.getLogger();

    public ShrinePiece(TemplateManager tm, JigsawPiece piece, BlockPos pos, int groundLevelDelta, Rotation rot, MutableBoundingBox box) {
        super(tm, piece, pos, groundLevelDelta, rot, box);
    }

    public ShrinePiece(TemplateManager templateManager, CompoundNBT nbt) {
        super(templateManager, nbt);
    }

    @Override
    public IStructurePieceType getType() {
        return InvigoratedPieces.SHRINE_PIECE;
    }

    @Override
    public boolean postProcess(ISeedReader world, StructureManager manager, ChunkGenerator gen, Random random, MutableBoundingBox box, ChunkPos chunkPos, BlockPos blockPos) {
        boolean placed = super.postProcess(world, manager, gen, random, box, chunkPos, blockPos);

        MutableBoundingBox bb = this.getBoundingBox();

        int x0 = Math.max(box.x0, bb.x0);
        int y0 = Math.max(box.y0, bb.y0);
        int z0 = Math.max(box.z0, bb.z0);
        int x1 = Math.min(box.x1, bb.x1);
        int y1 = Math.min(box.y1, bb.y1);
        int z1 = Math.min(box.z1, bb.z1);

        y0 = Math.max(0, y0);
        y1 = Math.min(255, y1);

        BlockPos.Mutable m = new BlockPos.Mutable();
        final int flags = 18;

        for (int pass = 0; pass < 2; pass++) {
            for (int x = x0; x <= x1; x++) {
                for (int y = y0; y <= y1; y++) {
                    for (int z = z0; z <= z1; z++) {
                        m.set(x, y, z);

                        if (world.getFluidState(m).getType() == Fluids.WATER) {
                            BlockState cur = world.getBlockState(m);

                            if (cur.getBlock() == Blocks.WATER || cur.is(Blocks.AIR) || cur.getMaterial().isReplaceable()) {
                                world.setBlock(m, Blocks.STONE.defaultBlockState(), flags);
                                continue;
                            }
                        }

                        BlockState state = world.getBlockState(m);
                        if (state.hasProperty(BlockStateProperties.WATERLOGGED)
                                && state.getValue(BlockStateProperties.WATERLOGGED)) {
                            world.setBlock(m, state.setValue(BlockStateProperties.WATERLOGGED, false), flags);
                        }
                    }
                }
            }
        }

        return placed;
    }
}
