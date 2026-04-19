package com.bladecoldsteel.invigorateddimensions.terranata.entity.model;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.terranata.entity.custom.GiantEarthmawEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GiantEarthmawModel extends AnimatedGeoModel<GiantEarthmawEntity> {
	private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/giant_earthmaw.geo.json");
	private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/giant_earthmaw.png");
	private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/giant_earthmaw/giant_earthmaw.animation.json");

	@Override
	public ResourceLocation getModelLocation(GiantEarthmawEntity giantEarthmawEntity) {
		return modelResource;
	}

	@Override
	public ResourceLocation getTextureLocation(GiantEarthmawEntity giantEarthmawEntity) {
		return textureResource;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(GiantEarthmawEntity giantEarthmawEntity) {
		return animationResource;
	}
}