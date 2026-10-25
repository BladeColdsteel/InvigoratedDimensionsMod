package com.bladecoldsteel.invigorateddimensions.util.ritual;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class RitualDefinition {
    public final RitualType type;
    public final ResourceLocation dimension;
    public final ResourceLocation input;
    public final ResourceLocation output;
    public final RitualSpecifics ritualSpecifics;

    public RitualDefinition(RitualType type, ResourceLocation dimension, ResourceLocation input, ResourceLocation output, RitualSpecifics specifics) {
        this.type = type;
        this.dimension = dimension;
        this.output = output;
        this.input = input;
        this.ritualSpecifics = specifics;
    }

    public RitualType getType() {
        return type;
    }

    public ResourceLocation getDimension() {
        return dimension;
    }

    public ResourceLocation getOutput() {
        return output;
    }

    public ResourceLocation getInput() {
        return input;
    }

    public RitualSpecifics getRitualSpecifics() {
        return ritualSpecifics;
    }

    public static class FireType implements RitualSpecifics {
        public final ResourceLocation fireType;

        public FireType(ResourceLocation fireType) {
            this.fireType = fireType;
        }

        public Block toBlock() {
            return ForgeRegistries.BLOCKS.getValue(fireType);
        }
    }

    public interface RitualSpecifics {
    }
}
