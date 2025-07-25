package com.bladecoldsteel.invigorateddimensions.world.gen.features.custom;

import com.bladecoldsteel.invigorateddimensions.celestialrealm.block.HeavenlyRealmBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FloatingIslandFeature extends Feature<NoFeatureConfig> {
    public FloatingIslandFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {
        float intRadius = (float)(random.nextInt(3) + 4);

        if (!isAreaClear(iSeedReader, pos, intRadius)) {
            return false;
        } else {
            for(int verticalLayer = 0; intRadius > 0.5F; --verticalLayer) {
                for(int xRadius = MathHelper.floor(-intRadius); xRadius <= MathHelper.ceil(intRadius); ++xRadius) {
                    for(int zRadius = MathHelper.floor(-intRadius); zRadius <= MathHelper.ceil(intRadius); ++zRadius) {
                        if ((float)(xRadius * xRadius + zRadius * zRadius) <= (intRadius + 1.0F) * (intRadius + 1.0F)) {
                            this.setBlock(iSeedReader, pos.offset(xRadius, verticalLayer, zRadius), HeavenlyRealmBlocks.STONE.get().defaultBlockState());
                        }
                    }
                }

                intRadius = (float)((double)intRadius - ((double)random.nextInt(2) + 0.5));
            }

            return true;
        }
    }

    private boolean isAreaClear(ISeedReader iSeedReader, BlockPos pos, float radius) {
        for (int yOffset = 0; yOffset >= -Math.ceil(radius); --yOffset) { // Scan downward
            for (int xOffset = MathHelper.floor(-radius); xOffset <= MathHelper.ceil(radius); ++xOffset) {
                for (int zOffset = MathHelper.floor(-radius); zOffset <= MathHelper.ceil(radius); ++zOffset) {
                    BlockPos checkPos = pos.offset(xOffset, yOffset, zOffset);
                    if (!iSeedReader.getBlockState(checkPos).isAir()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
