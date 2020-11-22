package com.huto.hutosmod.models.entity.passive;

import com.huto.hutosmod.entities.passive.EntityIbis;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelIbis extends EntityModel<EntityIbis> {
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Body;
	private final ModelRenderer RightWing;
	private final ModelRenderer LeftWing;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;

	public ModelIbis() {
		textureWidth = 32;
		textureHeight = 32;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.0F, 20.0F, 4.0F);
		RightLeg.setTextureOffset(0, 15).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(10, 14).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(7, 11).addBox(-1.0F, 4.0F, -3.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);
		RightLeg.setTextureOffset(12, 12).addBox(0.0F, 4.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(4, 11).addBox(-2.0F, 4.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.0F, 20.0F, 4.0F);
		LeftLeg.setTextureOffset(4, 15).addBox(0.0F, 2.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(14, 14).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(9, 11).addBox(0.0F, 4.0F, -3.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);
		LeftLeg.setTextureOffset(13, 0).addBox(1.0F, 4.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(13, 2).addBox(-1.0F, 4.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 18.0F, 2.5F);
		Body.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.5F, 4.0F, 4.0F, 7.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-2.0F, 17.0F, 0.0F);
		RightWing.setTextureOffset(10, 14).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(2.0F, 17.0F, 0.0F);
		LeftWing.setTextureOffset(0, 11).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 17.0F, -1.0F);
		Neck.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 14.0F, -2.0F);
		Head.setTextureOffset(0, 11).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(0.0F, -1.0F, -5.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 5).addBox(0.0F, 0.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityIbis entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		//this.Body.rotateAngleX = ((float) Math.PI / 2F);
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		
		this.RightWing.rotateAngleZ = ageInTicks;
		this.LeftWing.rotateAngleZ = -ageInTicks;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		Neck.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}