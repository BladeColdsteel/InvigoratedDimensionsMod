package com.bladecoldsteel.invigorateddimensions.universal.entity.tileentity.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ElementalShrineModel<T extends Entity> extends EntityModel<T> {
	private final ModelRenderer main;

	public ElementalShrineModel() {
		this.texWidth = 256;
		this.texHeight = 256;

		this.main = new ModelRenderer(this);
		this.main.setPos(0.0F, 0.0F, 0.0F);

		this.main.texOffs(80, 90).addBox(-8.0F, -50.0F, -8.0F, 16.0F, 8.0F, 16.0F);
		this.main.texOffs(96, 28).addBox(-7.0F, -54.0F, -7.0F, 14.0F, 4.0F, 14.0F);
		this.main.texOffs(104, 0).addBox(-6.0F, -56.0F, -6.0F, 12.0F, 2.0F, 12.0F);
		this.main.texOffs(104, 14).addBox(-5.0F, -58.0F, -5.0F, 10.0F, 2.0F, 10.0F);
		this.main.texOffs(96, 46).addBox(-3.0F, -60.0F, -3.0F, 6.0F, 2.0F, 6.0F);
		this.main.texOffs(80, 114).addBox(-2.0F, -62.0F, -2.0F, 4.0F, 2.0F, 4.0F);
		this.main.texOffs(96, 114).addBox(-1.0F, -64.0F, -1.0F, 2.0F, 2.0F, 2.0F);
		this.main.texOffs(88, 56).addBox(-9.0F, -42.0F, -9.0F, 18.0F, 16.0F, 18.0F);
		this.main.texOffs(0, 88).addBox(-10.0F, -26.0F, -10.0F, 20.0F, 10.0F, 20.0F);
		this.main.texOffs(0, 56).addBox(-11.0F, -16.0F, -11.0F, 22.0F, 10.0F, 22.0F);
		this.main.texOffs(0, 28).addBox(-12.0F, -6.0F, -12.0F, 24.0F, 4.0F, 24.0F);
		this.main.texOffs(0, 0).addBox(-13.0F, -2.0F, -13.0F, 26.0F, 2.0F, 26.0F);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder builder, int light, int overlay, float red, float green, float blue, float alpha) {
		this.main.render(matrixStack, builder, light, overlay, red, green,blue,alpha);
	}
}