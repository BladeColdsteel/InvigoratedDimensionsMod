package com.bladecoldsteel.invigorateddimensions.world.dimension;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class ElectricHighlandsRiftTeleporter implements ITeleporter {

    private BlockPos pos;

    public ElectricHighlandsRiftTeleporter(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Entity entity1 = repositionEntity.apply(false);
        if (!(entity1 instanceof ServerPlayerEntity)) {
            return entity1;
        }
        ServerPlayerEntity player = (ServerPlayerEntity) entity1;

        BlockPos targetBlockMid = new BlockPos(
                pos.getX(),
                pos.getY(),
                pos.getZ()
        );
        BlockPos targetBlockMid1 = new BlockPos(
                pos.getX(),
                pos.getY() + 1,
                pos.getZ()
        );
        BlockPos targetBlockMid2 = new BlockPos(
                pos.getX(),
                pos.getY() + 2,
                pos.getZ()
        );
        BlockPos targetBlockMid3 = new BlockPos(
                pos.getX(),
                pos.getY() + 3,
                pos.getZ()
        );
        BlockPos targetBlockSide1 = new BlockPos(
                pos.getX() + 1,
                pos.getY(),
                pos.getZ()
        );
        BlockPos targetBlockSide1A = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 1,
                pos.getZ()
        );
        BlockPos targetBlockSide1B = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 2,
                pos.getZ()
        );
        BlockPos targetBlockSide1C = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 3,
                pos.getZ()
        );
        BlockPos targetBlockSide2 = new BlockPos(
                pos.getX() - 1,
                pos.getY(),
                pos.getZ()
        );
        BlockPos targetBlockSide2A = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 1,
                pos.getZ()
        );
        BlockPos targetBlockSide2B = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 2,
                pos.getZ()
        );
        BlockPos targetBlockSide2C = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 3,
                pos.getZ()
        );
        BlockPos targetBlockSide3 = new BlockPos(
                pos.getX(),
                pos.getY(),
                pos.getZ() + 1
        );
        BlockPos targetBlockSide3A = new BlockPos(
                pos.getX(),
                pos.getY() + 1,
                pos.getZ() + 1
        );
        BlockPos targetBlockSide3B = new BlockPos(
                pos.getX(),
                pos.getY() + 2,
                pos.getZ() + 1
        );
        BlockPos targetBlockSide3C = new BlockPos(
                pos.getX(),
                pos.getY() + 3,
                pos.getZ() + 1
        );
        BlockPos targetBlockSide4 = new BlockPos(
                pos.getX(),
                pos.getY(),
                pos.getZ() - 1
        );
        BlockPos targetBlockSide4A = new BlockPos(
                pos.getX(),
                pos.getY() + 1,
                pos.getZ() - 1
        );
        BlockPos targetBlockSide4B = new BlockPos(
                pos.getX(),
                pos.getY() + 2,
                pos.getZ() - 1
        );
        BlockPos targetBlockSide4C = new BlockPos(
                pos.getX(),
                pos.getY() + 3,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner1 = new BlockPos(
                pos.getX() + 1,
                pos.getY(),
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner1A = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 1,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner1B = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 2,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner1C = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 3,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner2 = new BlockPos(
                pos.getX() - 1,
                pos.getY(),
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner2A = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 1,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner2B = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 2,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner2C = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 3,
                pos.getZ() + 1
        );
        BlockPos targetBlockCorner3 = new BlockPos(
                pos.getX() + 1,
                pos.getY(),
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner3A = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 1,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner3B = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 2,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner3C = new BlockPos(
                pos.getX() + 1,
                pos.getY() + 3,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner4 = new BlockPos(
                pos.getX() - 1,
                pos.getY(),
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner4A = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 1,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner4B = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 2,
                pos.getZ() - 1
        );
        BlockPos targetBlockCorner4C = new BlockPos(
                pos.getX() - 1,
                pos.getY() + 3,
                pos.getZ() - 1
        );
        player.teleportTo(pos.getX() + 0.5D, targetBlockMid.getY() + 1.0D, pos.getZ() + 0.5D);

        destWorld.setBlock(targetBlockMid, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockMid1, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockMid2, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockMid3, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide1, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide1A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide1B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide1C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide2, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide2A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide2B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide2C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide3, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide3A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide3B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide3C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide4, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide4A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide4B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockSide4C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner1, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner1A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner1B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner1C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner2, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner2A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner2B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner2C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner3, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner3A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner3B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner3C, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner4, ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner4A, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner4B, Blocks.AIR.defaultBlockState(), 4);
        destWorld.setBlock(targetBlockCorner4C, Blocks.AIR.defaultBlockState(), 4);

        return entity1;
    }
}
