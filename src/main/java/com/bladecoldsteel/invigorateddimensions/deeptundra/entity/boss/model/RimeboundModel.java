package com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.model;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.deeptundra.entity.boss.custom.RimeboundEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class RimeboundModel extends AnimatedGeoModel<RimeboundEntity> {
	private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/rimebound.geo.json");
	private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/rimebound.png");
	private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/rimebound/rimebound.animation.json");

	@Override
	public ResourceLocation getModelLocation(RimeboundEntity rimeboundEntity) {
		return modelResource;
	}

	@Override
	public ResourceLocation getTextureLocation(RimeboundEntity rimeboundEntity) {
		return textureResource;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(RimeboundEntity rimeboundEntity) {
		return animationResource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setLivingAnimations(RimeboundEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		IBone head = this.getAnimationProcessor().getBone("head");
		IBone head2 = this.getAnimationProcessor().getBone("head2");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

		if (head != null) {
			head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
			head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
		}

		if (head2 != null) {
			head2.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
			head2.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
		}
	}
}