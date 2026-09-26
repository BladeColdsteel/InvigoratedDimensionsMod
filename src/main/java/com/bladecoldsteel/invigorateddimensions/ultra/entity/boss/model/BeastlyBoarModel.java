package com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.model;

import com.bladecoldsteel.invigorateddimensions.InvigoratedDimensions;
import com.bladecoldsteel.invigorateddimensions.ultra.entity.boss.custom.BeastlyBoarEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class BeastlyBoarModel extends AnimatedGeoModel<BeastlyBoarEntity> {
	private static final ResourceLocation modelResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "geo/beastly_boar.geo.json");
	private static final ResourceLocation textureResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "textures/entity/beastly_boar.png");
	private static final ResourceLocation animationResource = new ResourceLocation(InvigoratedDimensions.MOD_ID, "animations/beastly_boar/beastly_boar.animation.json");

	@Override
	public ResourceLocation getModelLocation(BeastlyBoarEntity rimeboundEntity) {
		return modelResource;
	}

	@Override
	public ResourceLocation getTextureLocation(BeastlyBoarEntity rimeboundEntity) {
		return textureResource;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BeastlyBoarEntity rimeboundEntity) {
		return animationResource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setLivingAnimations(BeastlyBoarEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

		if (head != null) {
			head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
			head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
		}
	}
}