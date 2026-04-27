package com.bladecoldsteel.invigorateddimensions.universal.network;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerInputState {
    private static final Map<UUID, InputState> INPUTS = new HashMap<>();

    public static void set(UUID playerId, boolean forward, boolean drillUp, boolean sneak, boolean left, boolean right) {
        INPUTS.put(playerId, new InputState(forward, drillUp, sneak, left, right));
    }

    public static boolean isPressingForward(UUID playerId) {
        return INPUTS.getOrDefault(playerId, InputState.EMPTY).forward;
    }

    public static boolean isPressingDrillUp(UUID playerId) {
        return INPUTS.getOrDefault(playerId, InputState.EMPTY).drillUp;
    }

    public static boolean isPressingSneak(UUID playerId) {
        return INPUTS.getOrDefault(playerId, InputState.EMPTY).sneak;
    }

    public static boolean isPressingLeft(UUID playerId) {
        return INPUTS.getOrDefault(playerId, InputState.EMPTY).left;
    }

    public static boolean isPressingRight(UUID playerId) {
        return INPUTS.getOrDefault(playerId, InputState.EMPTY).right;
    }

    public static void clear(UUID playerId) {
        INPUTS.remove(playerId);
    }

    private static class InputState {
        private static final InputState EMPTY = new InputState(false, false, false, false, false);

        private final boolean forward;
        private final boolean drillUp;
        private final boolean sneak;
        private final boolean left;
        private final boolean right;

        private InputState(boolean forward, boolean drillUp, boolean sneak, boolean left, boolean right) {
            this.forward = forward;
            this.drillUp = drillUp;
            this.sneak = sneak;
            this.left = left;
            this.right = right;
        }
    }
}
