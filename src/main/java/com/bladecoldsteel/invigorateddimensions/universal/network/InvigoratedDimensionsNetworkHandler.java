package com.bladecoldsteel.invigorateddimensions.universal.network;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.RotateBlockPacket;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.SubmitShrineItemPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class InvigoratedDimensionsNetworkHandler {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(InvigoratedDimensions.MOD_ID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    public static void register() {
        int id = 0;

        INSTANCE.registerMessage(id++,
                //Rotate, mostly used for Energy sink
                RotateBlockPacket.class,
                RotateBlockPacket::encode,
                RotateBlockPacket::decode,
                RotateBlockPacket::handle
        );
        INSTANCE.registerMessage(id++,
                //Submit logic for Elemental Shrine
                SubmitShrineItemPacket.class,
                SubmitShrineItemPacket::encode,
                SubmitShrineItemPacket::decode,
                SubmitShrineItemPacket::handle
        );
    }
}
