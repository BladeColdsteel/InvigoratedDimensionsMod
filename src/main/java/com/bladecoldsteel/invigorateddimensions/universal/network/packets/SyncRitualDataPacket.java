package com.bladecoldsteel.invigorateddimensions.universal.network.packets;

import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualData;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualDefinition;
import com.bladecoldsteel.invigorateddimensions.util.ritual.RitualType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SyncRitualDataPacket {
    private final Map<ResourceLocation, RitualDefinition> rituals;
    public SyncRitualDataPacket(Map<ResourceLocation, RitualDefinition> rituals) {
        this.rituals = rituals;
    }

    public static void encode(SyncRitualDataPacket msg, PacketBuffer buf) {
        buf.writeVarInt(msg.rituals.size());
        for (Map.Entry<ResourceLocation, RitualDefinition> entry : msg.rituals.entrySet()) {
            ResourceLocation id = entry.getKey();
            RitualDefinition ritual = entry.getValue();
            buf.writeResourceLocation(id);
            buf.writeResourceLocation(ritual.getDimension());
            buf.writeResourceLocation(ritual.getInput());
            buf.writeResourceLocation(ritual.getOutput());
            buf.writeEnum(ritual.getType());
            if (ritual.getRitualSpecifics() instanceof RitualDefinition.FireType && ritual.getType() == RitualType.FIRE_SACRIFICE) {
                RitualDefinition.FireType specifics = (RitualDefinition.FireType) ritual.getRitualSpecifics();
                buf.writeResourceLocation(specifics.fireType);
            } else if (ritual.getRitualSpecifics() instanceof RitualDefinition.FluidType && ritual.getType() == RitualType.FLUID_SACRIFICE) {
                RitualDefinition.FluidType specifics = (RitualDefinition.FluidType) ritual.getRitualSpecifics();
                buf.writeResourceLocation(specifics.fluidType);
            } else {
                throw new IllegalArgumentException("Unsupported ritual type: " + ritual.getType());
            }
        }
    }

    public static SyncRitualDataPacket decode(PacketBuffer buf) {
        int ritualCount = buf.readVarInt();
        Map<ResourceLocation, RitualDefinition> rituals = new HashMap<>();
        for (int i = 0; i < ritualCount; i++) {
            ResourceLocation id = buf.readResourceLocation();
            ResourceLocation dimension = buf.readResourceLocation();
            ResourceLocation input = buf.readResourceLocation();
            ResourceLocation output = buf.readResourceLocation();
            RitualType type = buf.readEnum(RitualType.class);
            RitualDefinition.RitualSpecifics specifics;
            if (type == RitualType.FIRE_SACRIFICE) {
                ResourceLocation specificFire = buf.readResourceLocation();
                specifics = new RitualDefinition.FireType(specificFire);
            } else if (type == RitualType.FLUID_SACRIFICE) {
                ResourceLocation specificWater = buf.readResourceLocation();
                specifics = new RitualDefinition.FluidType(specificWater);
            } else {
                throw new IllegalArgumentException("Unsupported ritual type: " + type);
            }
            rituals.put(id, new RitualDefinition(type, dimension, input, output, specifics));
        }
        System.out.println("[SyncRitualDataPacket] Decoded " + rituals.size() + " rituals.");
        return new SyncRitualDataPacket(rituals);
    }

    public static void handle(SyncRitualDataPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            RitualData.setRituals(msg.rituals);
            System.out.println("[SyncRitualDataPacket] Packet handled.");
        });
        ctx.get().setPacketHandled(true);
    }
}
