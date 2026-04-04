package com.bladecoldsteel.invigorateddimensions.dreamland.entity.model.boss;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.dreamland.entity.custom.boss.PitulantPendulumEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PitulantPendulumModel extends AnimatedGeoModel<PitulantPendulumEntity> {
    private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/pitulant_pendulum.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/pitulant_pendulum.png");
    private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/pitulant_pendulum/pitulant_pendulum.animation.json");

    @Override
    public ResourceLocation getModelLocation(PitulantPendulumEntity entity) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(PitulantPendulumEntity entity) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PitulantPendulumEntity entity) {
        return animationResource;
    }
}
