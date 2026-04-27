package com.bladecoldsteel.invigorateddimensions.universal.network.packets;

import com.bladecoldsteel.invigorateddimensions.universal.network.PlayerInputState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ClientInputPacket {
    private final boolean forward;
    private final boolean drillUp;
    private final boolean sneak;
    private final boolean left;
    private final boolean right;

    public ClientInputPacket(boolean forward, boolean drillUp, boolean sneak, boolean left, boolean right) {
        this.forward = forward;
        this.drillUp = drillUp;
        this.sneak = sneak;
        this.left = left;
        this.right = right;
    }

    public static void encode(ClientInputPacket msg, PacketBuffer buffer) {
        buffer.writeBoolean(msg.forward);
        buffer.writeBoolean(msg.drillUp);
        buffer.writeBoolean(msg.sneak);
        buffer.writeBoolean(msg.left);
        buffer.writeBoolean(msg.right);
    }

    public static ClientInputPacket decode(PacketBuffer buffer) {
        return new ClientInputPacket(
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean(),
                buffer.readBoolean()
        );
    }

    public static void handle(ClientInputPacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayerEntity player = context.get().getSender();
            if (player != null) {
                PlayerInputState.set(
                        player.getUUID(),
                        msg.forward,
                        msg.drillUp,
                        msg.sneak,
                        msg.left,
                        msg.right
                );
            }
        });
        context.get().setPacketHandled(true);
    }
}
