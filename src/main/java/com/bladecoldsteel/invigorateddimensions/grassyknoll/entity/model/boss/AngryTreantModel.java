package com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.model.boss;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.grassyknoll.entity.custom.boss.AngryTreantEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AngryTreantModel extends AnimatedGeoModel<AngryTreantEntity> {
    private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/angry_treant.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/angry_treant.png");
    private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/angry_treant/angry_treant.animation.json");

    @Override
    public ResourceLocation getModelLocation(AngryTreantEntity entity) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(AngryTreantEntity entity) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AngryTreantEntity entity) {
        return animationResource;
    }
}
