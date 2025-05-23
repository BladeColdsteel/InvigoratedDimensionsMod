package com.bladecoldsteel.invigorateddimensions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class InvigoratedDimensionsConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SPAWN_REPLACEMENT;

    static {
        BUILDER.push("Invigorated Dimensions Config");

        SPAWN_REPLACEMENT = BUILDER
                .comment("Set this value to determine whether mobs, other than pixelmon, still spawn. | DEFAULT: true")
                .define("spawn-replacement", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
