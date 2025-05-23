package com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.model;

import com.bladecoldsteel.invigorateddimensions.electrichighlands.entity.custom.ChargedCrawlerEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ChargedCrawlerModel<T extends ChargedCrawlerEntity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer eye_r1;
	private final ModelRenderer body_r1;
	private final ModelRenderer front_leg_L;
	private final ModelRenderer front_leg_2L_r1;
	private final ModelRenderer front_leg_1L_r1;
	private final ModelRenderer front_leg_R;
	private final ModelRenderer front_leg_2R_r1;
	private final ModelRenderer front_leg_1R_r1;
	private final ModelRenderer mid_leg_L;
	private final ModelRenderer mid_leg_2L_r1;
	private final ModelRenderer mid_leg_1L_r1;
	private final ModelRenderer mid_leg_R;
	private final ModelRenderer mid_leg_2R_r1;
	private final ModelRenderer mid_leg_1R_r1;
	private final ModelRenderer back_leg_L;
	private final ModelRenderer back_leg_2L_r1;
	private final ModelRenderer back_leg_1L_r1;
	private final ModelRenderer back_leg_R;
	private final ModelRenderer back_leg_2R_r1;
	private final ModelRenderer back_leg_1R_r1;

	public ChargedCrawlerModel() {
		this.texWidth = 64;
		this.texHeight = 64;

		body = new ModelRenderer(this);
		body.setPos(-1.0F, 17.0F, -8.0F);


		eye_r1 = new ModelRenderer(this);
		eye_r1.setPos(0.0F, 0.0F, -1.0F);
		body.addChild(eye_r1);
		setRotationAngle(eye_r1, 0.0F, 0.0F, 0.7854F);
		eye_r1.texOffs(45, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setPos(0.0F, 2.0F, 1.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.0F, 0.0F, 0.7854F);
		body_r1.texOffs(0, 0).addBox(-4.0F, -5.0F, -1.0F, 6.0F, 6.0F, 16.0F, 0.0F, false);

		front_leg_L = new ModelRenderer(this);
		front_leg_L.setPos(-1.0F, 17.0F, -8.0F);


		front_leg_2L_r1 = new ModelRenderer(this);
		front_leg_2L_r1.setPos(12.0F, 6.0F, 4.0F);
		front_leg_L.addChild(front_leg_2L_r1);
		setRotationAngle(front_leg_2L_r1, 0.0F, 0.0F, 1.1345F);
		front_leg_2L_r1.texOffs(0, 23).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		front_leg_1L_r1 = new ModelRenderer(this);
		front_leg_1L_r1.setPos(8.0F, -3.0F, 4.0F);
		front_leg_L.addChild(front_leg_1L_r1);
		setRotationAngle(front_leg_1L_r1, 0.0F, 0.0F, -0.3927F);
		front_leg_1L_r1.texOffs(0, 38).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		front_leg_R = new ModelRenderer(this);
		front_leg_R.setPos(0.0F, 24.0F, 0.0F);


		front_leg_2R_r1 = new ModelRenderer(this);
		front_leg_2R_r1.setPos(-8.0F, -10.0F, -4.0F);
		front_leg_R.addChild(front_leg_2R_r1);
		setRotationAngle(front_leg_2R_r1, 0.0F, 0.0F, -1.1345F);
		front_leg_2R_r1.texOffs(0, 28).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		front_leg_1R_r1 = new ModelRenderer(this);
		front_leg_1R_r1.setPos(-3.0F, -8.0F, -4.0F);
		front_leg_R.addChild(front_leg_1R_r1);
		setRotationAngle(front_leg_1R_r1, 0.0F, 0.0F, 0.3927F);
		front_leg_1R_r1.texOffs(19, 38).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		mid_leg_L = new ModelRenderer(this);
		mid_leg_L.setPos(0.0F, 24.0F, 0.0F);


		mid_leg_2L_r1 = new ModelRenderer(this);
		mid_leg_2L_r1.setPos(11.0F, -1.0F, 1.0F);
		mid_leg_L.addChild(mid_leg_2L_r1);
		setRotationAngle(mid_leg_2L_r1, 0.0F, 0.0F, 1.1345F);
		mid_leg_2L_r1.texOffs(0, 33).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		mid_leg_1L_r1 = new ModelRenderer(this);
		mid_leg_1L_r1.setPos(7.0F, -10.0F, 1.0F);
		mid_leg_L.addChild(mid_leg_1L_r1);
		setRotationAngle(mid_leg_1L_r1, 0.0F, 0.0F, -0.3927F);
		mid_leg_1L_r1.texOffs(19, 43).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		mid_leg_R = new ModelRenderer(this);
		mid_leg_R.setPos(0.0F, 24.0F, 0.0F);


		mid_leg_2R_r1 = new ModelRenderer(this);
		mid_leg_2R_r1.setPos(-8.0F, -10.0F, 1.0F);
		mid_leg_R.addChild(mid_leg_2R_r1);
		setRotationAngle(mid_leg_2R_r1, 0.0F, 0.0F, -1.1345F);
		mid_leg_2R_r1.texOffs(29, 23).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		mid_leg_1R_r1 = new ModelRenderer(this);
		mid_leg_1R_r1.setPos(-3.0F, -8.0F, 1.0F);
		mid_leg_R.addChild(mid_leg_1R_r1);
		setRotationAngle(mid_leg_1R_r1, 0.0F, 0.0F, 0.3927F);
		mid_leg_1R_r1.texOffs(38, 38).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		back_leg_L = new ModelRenderer(this);
		back_leg_L.setPos(0.0F, 24.0F, 0.0F);


		back_leg_2L_r1 = new ModelRenderer(this);
		back_leg_2L_r1.setPos(11.0F, -1.0F, 6.0F);
		back_leg_L.addChild(back_leg_2L_r1);
		setRotationAngle(back_leg_2L_r1, 0.0F, 0.0F, 1.1345F);
		back_leg_2L_r1.texOffs(29, 33).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		back_leg_1L_r1 = new ModelRenderer(this);
		back_leg_1L_r1.setPos(7.0F, -10.0F, 6.0F);
		back_leg_L.addChild(back_leg_1L_r1);
		setRotationAngle(back_leg_1L_r1, 0.0F, 0.0F, -0.3927F);
		back_leg_1L_r1.texOffs(38, 43).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		back_leg_R = new ModelRenderer(this);
		back_leg_R.setPos(0.0F, 24.0F, 0.0F);


		back_leg_2R_r1 = new ModelRenderer(this);
		back_leg_2R_r1.setPos(-7.0F, -10.0F, 6.0F);
		back_leg_R.addChild(back_leg_2R_r1);
		setRotationAngle(back_leg_2R_r1, 0.0F, 0.0F, -1.1345F);
		back_leg_2R_r1.texOffs(29, 28).addBox(-11.0F, -2.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);

		back_leg_1R_r1 = new ModelRenderer(this);
		back_leg_1R_r1.setPos(-3.0F, -8.0F, 6.0F);
		back_leg_R.addChild(back_leg_1R_r1);
		setRotationAngle(back_leg_1R_r1, 0.0F, 0.0F, 0.3927F);
		back_leg_1R_r1.texOffs(0, 43).addBox(-6.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0F;
		float degree = 1.0F;

		//Front and Back legs move together
		this.front_leg_L.xRot = MathHelper.cos(limbSwing * speed) * degree * limbSwingAmount;
		this.back_leg_L.xRot = MathHelper.cos(limbSwing * speed) * degree * limbSwingAmount;
		this.front_leg_R.xRot = MathHelper.cos(limbSwing * speed + (float)Math.PI) * degree * limbSwingAmount;
		this.back_leg_R.xRot = MathHelper.cos(limbSwing * speed + (float)Math.PI) * degree * limbSwingAmount;

		//Middle legs move opposite their own side
		this.mid_leg_L.xRot = MathHelper.cos(limbSwing * speed + (float)Math.PI) * degree * limbSwingAmount;
		this.mid_leg_R.xRot = MathHelper.cos(limbSwing * speed) * degree * limbSwingAmount;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.front_leg_L, this.front_leg_R, this.mid_leg_L, this.mid_leg_R, this.back_leg_L, this.back_leg_R);
	}
}