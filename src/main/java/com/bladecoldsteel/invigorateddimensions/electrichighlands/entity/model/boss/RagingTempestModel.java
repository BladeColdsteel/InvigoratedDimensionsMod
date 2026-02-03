package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.model.boss;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.boss.RagingTempestEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RagingTempestModel extends AnimatedGeoModel<RagingTempestEntity> {
    private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/raging_tempest.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/raging_tempest.png");
    private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/raging_tempest/raging_tempest.animation.json");

    @Override
    public ResourceLocation getModelLocation(RagingTempestEntity entity) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(RagingTempestEntity entity) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RagingTempestEntity entity) {
        return animationResource;
    }
}
