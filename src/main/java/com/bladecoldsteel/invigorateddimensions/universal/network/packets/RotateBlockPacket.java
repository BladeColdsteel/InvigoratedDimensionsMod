package com.bladecoldsteel.invigorateddimensions.universal.network.packets;

import com.bladecoldsteel.invigorateddimensions.universal.block.custom.EnergySinkBlock;
import net.minecraft.block.BlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RotateBlockPacket {
    private final BlockPos pos;

    public RotateBlockPacket(BlockPos pos) {
        this.pos = pos;
    }

    public static void encode(RotateBlockPacket msg, PacketBuffer buffer) {
        buffer.writeBlockPos(msg.pos);
    }

    public static RotateBlockPacket decode(PacketBuffer buffer) {
        return new RotateBlockPacket(buffer.readBlockPos());
    }

    public static void handle(RotateBlockPacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerWorld world = context.get().getSender().getLevel();
            BlockState state = world.getBlockState(msg.pos);
            if (state.getBlock() instanceof EnergySinkBlock) {
                Direction current = state.getValue(EnergySinkBlock.FACING);
                Direction next = getNextDirection(current);
                world.setBlockAndUpdate(msg.pos, state.setValue(EnergySinkBlock.FACING, next));

                world.playSound(
                        null,
                        msg.pos,
                        SoundEvents.LEVER_CLICK,
                        SoundCategory.BLOCKS,
                        0.5F,
                        1.0F
                );
            }
        });
        context.get().setPacketHandled(true);
    }

    private static Direction getNextDirection(Direction current) {
        List<Direction> valid = Arrays.stream(Direction.values())
                .filter(d -> d != Direction.UP)
                .collect(Collectors.toList());
        int index = valid.indexOf(current);
        return valid.get((index + 1) % valid.size());
    }
}
