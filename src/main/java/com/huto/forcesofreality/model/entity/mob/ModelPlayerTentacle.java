package com.huto.forcesofreality.model.entity.mob;

import com.huto.forcesofreality.entity.summon.EntityPlayerTentacle;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelPlayerTentacle extends EntityModel<EntityPlayerTentacle> {
	private final ModelRenderer Tip;
	private final ModelRenderer Third;
	private final ModelRenderer Second;
	private final ModelRenderer Base;

	public ModelPlayerTentacle() {
		textureWidth = 64;
		textureHeight = 64;

		Tip = new ModelRenderer(this);
		Tip.setRotationPoint(0.0F, 10.1F, 0.0F);
		Tip.setTextureOffset(0, 0).addBox(-1.0F, -2.1F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		Tip.setTextureOffset(0, 23).addBox(-2.0F, -3.1F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Tip.setTextureOffset(12, 23).addBox(-1.0F, -5.1F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Tip.setTextureOffset(18, 12).addBox(-2.0F, -6.1F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Tip.setTextureOffset(24, 0).addBox(-1.0F, -10.1F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Third = new ModelRenderer(this);
		Third.setRotationPoint(0.0F, 15.0F, 0.0F);
		Third.setTextureOffset(20, 20).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Second = new ModelRenderer(this);
		Second.setRotationPoint(0.0F, 19.5F, 0.0F);
		Second.setTextureOffset(0, 12).addBox(-3.0F, -4.5F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);

		Base = new ModelRenderer(this);
		Base.setRotationPoint(0.0F, 24.0F, 0.0F);
		Base.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityPlayerTentacle entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		float parTicks = ClientUtils.getPartialTicks();

		this.Base.rotateAngleX = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Base.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Second.rotateAngleX = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Second.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Third.rotateAngleX = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Third.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Tip.rotateAngleX = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0925);
		this.Tip.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0925);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Tip.render(matrixStack, buffer, packedLight, packedOverlay);
		Third.render(matrixStack, buffer, packedLight, packedOverlay);
		Second.render(matrixStack, buffer, packedLight, packedOverlay);
		Base.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}