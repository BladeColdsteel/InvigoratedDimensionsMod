package com.bladecoldsteel.invigorateddimensions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class InvigoratedDimensionsConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWN_REPLACEMENT;
    public static final ForgeConfigSpec.ConfigValue<String> DIFFICULTY_MODE;

    static {
        BUILDER.push("Invigorated Dimensions Config");

        SPAWN_REPLACEMENT = BUILDER
                .comment("Set this value to determine whether mobs, other than pixelmon, still spawn. | DEFAULT: true")
                .define("spawn-replacement", true);
        DIFFICULTY_MODE = BUILDER
                .comment("Sets difficulty mode. | progressive: Boss stats scale based on how many bosses have been defeated. Starts similar to Ender Dragon and Wither | linear: Boss stats stay consistent throughout playthrough, similar to other Minecraft Bosses | DEFAULT: progressive")
                .define("difficulty-mode", "progressive");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
