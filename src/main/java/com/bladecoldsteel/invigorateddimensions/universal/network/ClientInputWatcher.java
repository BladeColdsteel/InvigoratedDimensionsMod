package com.bladecoldsteel.invigorateddimensions.universal.network;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.universal.network.packets.ClientInputPacket;
import com.bladecoldsteel.invigorateddimensions.util.CustomKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = InvigoratedDimensions.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE,
        value = Dist.CLIENT)
public class ClientInputWatcher {
    private static boolean pressingForward = false;
    private static boolean pressingShift = false;
    private static boolean pressingDrillUp = false;
    private static boolean pressingLeft = false;
    private static boolean pressingRight = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return;
        }
        boolean isPressingForward = minecraft.options.keyUp.isDown();
        boolean isPressingShift = minecraft.options.keyShift.isDown();
        boolean isPressingDrillUp = CustomKeybinds.DRILL_UP.isDown();
        boolean isPressingLeft = minecraft.options.keyLeft.isDown();
        boolean isPressingRight = minecraft.options.keyRight.isDown();
        if (isPressingForward != pressingForward) {
            pressingForward = isPressingForward;
        }
        if (isPressingDrillUp != pressingDrillUp) {
            pressingDrillUp = isPressingDrillUp;
        }
        if (isPressingShift != pressingShift) {
            pressingShift = isPressingShift;
        }
        if (isPressingLeft != pressingLeft) {
            pressingLeft = isPressingLeft;
        }
        if (isPressingRight != pressingRight) {
            pressingRight = isPressingRight;
        }

        InvigoratedDimensionsNetworkHandler.INSTANCE.sendToServer(
                new ClientInputPacket(
                        pressingForward,
                        pressingDrillUp,
                        pressingShift,
                        pressingLeft,
                        pressingRight
                )
        );

    }
}
