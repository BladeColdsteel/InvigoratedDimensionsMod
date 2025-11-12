package com.bladecoldsteel.invigorateddimensions.overworld.entity.model.boss;

import com.bladecoldsteel.invigorateddimensions.overworld.entity.custom.boss.FossilizedTraderEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class FossilizedTraderModel <T extends FossilizedTraderEntity> extends SegmentedModel<T> {
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_leg_r1;
	private final ModelRenderer body;
	private final ModelRenderer body_2_r1;
	private final ModelRenderer head;
	private final ModelRenderer left_arm;
	private final ModelRenderer center_arm_left_r1;
	private final ModelRenderer left_arm_r1;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_r1;

	public FossilizedTraderModel() {
		texWidth = 256;
		texHeight = 256;

		left_leg = new ModelRenderer(this);
		left_leg.setPos(0.0F, -7.0F, 0.0F);
		left_leg.texOffs(80, 162).addBox(-12.0F, -1.0F, -10.0F, 12.0F, 32.0F, 16.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setPos(0.0F, -8.0F, 0.0F);
		

		right_leg_r1 = new ModelRenderer(this);
		right_leg_r1.setPos(1.0F, 18.0F, 21.0F);
		right_leg.addChild(right_leg_r1);
		setRotationAngle(right_leg_r1, 0.6109F, 0.0F, 0.0F);
		right_leg_r1.texOffs(152, 0).addBox(-1.0F, -32.7F, -15.0F, 12.0F, 39.0F, 16.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, -32.0F, 0.0F);
		body.texOffs(128, 120).addBox(-12.0F, -2.0F, -10.0F, 24.0F, 26.0F, 16.0F, 0.0F, false);

		body_2_r1 = new ModelRenderer(this);
		body_2_r1.setPos(-11.0F, -1.0F, 5.0F);
		body.addChild(body_2_r1);
		setRotationAngle(body_2_r1, 0.3491F, 0.0F, 0.0F);
		body_2_r1.texOffs(0, 148).addBox(-1.0F, -24.0F, -15.0F, 24.0F, 24.0F, 16.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -72.0F, -16.0F);
		setRotationAngle(head, 0.3491F, 0.0F, 0.0F);
		head.texOffs(0, 76).addBox(-16.0F, -20.0F, -17.0F, 32.0F, 40.0F, 32.0F, 0.0F, false);
		head.texOffs(152, 55).addBox(-3.0F, 2.0F, -21.0F, 6.0F, 16.0F, 4.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setPos(-18.0F, -45.3552F, -3.7825F);
		

		center_arm_left_r1 = new ModelRenderer(this);
		center_arm_left_r1.setPos(5.0F, 10.778F, -13.1579F);
		left_arm.addChild(center_arm_left_r1);
		setRotationAngle(center_arm_left_r1, 0.3491F, 0.0F, 0.0F);
		center_arm_left_r1.texOffs(136, 162).addBox(1.0F, -11.1F, -11.1F, 12.0F, 12.0F, 12.0F, 0.0F, false);

		left_arm_r1 = new ModelRenderer(this);
		left_arm_r1.setPos(-5.0F, 4.778F, 5.8421F);
		left_arm.addChild(left_arm_r1);
		setRotationAngle(left_arm_r1, 0.3491F, 0.0F, 0.0F);
		left_arm_r1.texOffs(128, 76).addBox(-1.0F, -12.0F, -31.0F, 12.0F, 12.0F, 32.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setPos(18.0F, -40.0F, -7.0F);
		

		right_arm_r1 = new ModelRenderer(this);
		right_arm_r1.setPos(-5.0F, 22.0F, -6.0F);
		right_arm.addChild(right_arm_r1);
		setRotationAngle(right_arm_r1, -1.5708F, 0.0F, 0.0F);
		right_arm_r1.texOffs(0, 0).addBox(-1.0F, -12.0F, -31.0F, 12.0F, 12.0F, 64.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);

		final float SPEED_SCALE = 0.20F;
		final float AMP_SCALE   = 0.20F;

		this.left_arm.xRot  = MathHelper.sin(limbSwing * (0.5F * SPEED_SCALE)) * (0.9F  * AMP_SCALE) * limbSwingAmount;
		this.right_arm.xRot = MathHelper.sin(limbSwing * (3.0F * SPEED_SCALE)) * (2.5F  * AMP_SCALE) * limbSwingAmount;
		this.left_leg.xRot  = MathHelper.sin(limbSwing * (3.0F * SPEED_SCALE)) * (1.25F * AMP_SCALE) * limbSwingAmount;
		this.right_leg.xRot = MathHelper.sin(limbSwing * (0.5F * SPEED_SCALE)) * (0.3F  * AMP_SCALE) * limbSwingAmount;
		this.right_leg.zRot = MathHelper.sin(limbSwing * (1.0F * SPEED_SCALE)) * (-0.5F * AMP_SCALE) * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.body_2_r1, this.left_leg, this.right_leg, this.left_arm, this.left_arm_r1, this.center_arm_left_r1, this.right_arm, this.right_arm_r1);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}