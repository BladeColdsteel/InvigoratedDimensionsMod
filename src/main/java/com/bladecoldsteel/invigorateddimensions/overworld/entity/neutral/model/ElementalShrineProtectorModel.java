package com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.model;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.overworld.entity.neutral.custom.ElementalShrineProtectorsEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ElementalShrineProtectorModel extends AnimatedGeoModel<ElementalShrineProtectorsEntity> {
    private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/elemental_shrine_protector.geo.json");
    private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/elemental_shrine_protector.png");
    private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/elemental_shrine_protector/elemental_shrine_protector.animation.json");

    @Override
    public ResourceLocation getModelLocation(ElementalShrineProtectorsEntity entity) {
        return modelResource;
    }

    @Override
    public ResourceLocation getTextureLocation(ElementalShrineProtectorsEntity entity) {
        return textureResource;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ElementalShrineProtectorsEntity entity) {
        return animationResource;
    }
}
