package com.bladecoldsteel.invigorateddimensions.util;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class CustomKeybinds {
    public static KeyBinding DRILL_UP;
    private static final String INVIGORATED_CATEGORIES = "key.categories.invigorated_dimensions";

    public static void register() {
        DRILL_UP = new KeyBinding(
                "key.invigorated_dimensions.drill_up",
                KeyConflictContext.IN_GAME,
                InputMappings.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                INVIGORATED_CATEGORIES
        );

        ClientRegistry.registerKeyBinding(DRILL_UP);
    }
}
