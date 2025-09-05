package com.bladecoldsteel.invigorateddimensions.world.dimension;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.block.ElectricHighlandsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class RiftTeleporter implements ITeleporter {

    private BlockPos pos;

    public RiftTeleporter(BlockPos pos) {
        this.pos = pos;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Entity entity1 = repositionEntity.apply(false);
        if (!(entity1 instanceof ServerPlayerEntity)) {
            return entity1;
        }
        ServerPlayerEntity player = (ServerPlayerEntity) entity1;

        BlockPos base = (this.pos != null) ? this.pos : destWorld.getSharedSpawnPos();
        int safeY = net.minecraft.util.math.MathHelper.clamp(base.getY(), 6, destWorld.getMaxBuildHeight() - 6);
        base = new BlockPos(base.getX(), safeY, base.getZ());

        ServerChunkProvider cm = destWorld.getChunkSource();
        ChunkPos cpos = new ChunkPos(base);
        cm.addRegionTicket(TicketType.POST_TELEPORT, cpos, 1, 0);

        BlockState floor = ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_STONE_BRICKS.get().defaultBlockState();
        BlockState center = ElectricHighlandsBlocks.ELECTRICALLY_CHARGED_CHISELED_STONE_BRICKS.get().defaultBlockState();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos pad = base.offset(dx, 0, dz);

                BlockState desired = (dx == 0 && dz == 0) ? center : floor;
                if (destWorld.getBlockState(pad) != desired) {
                    destWorld.setBlock(pad, desired, 3);
                }

                for (int dy = 1; dy <= 3; dy++) {
                    BlockPos air = pad.above(dy);
                    if (!destWorld.isEmptyBlock(air)) {
                        destWorld.setBlock(air, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }

        player.teleportTo(base.getX() + 0.5D, base.getY() + 1.0D, base.getZ() + 0.5D);
        return player;
    }
}
