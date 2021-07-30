package com.huto.forcesofreality.model.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@SuppressWarnings("rawtypes")
public class ModelVibeSeer extends HumanoidModel {
	private final ModelPart frontBand;
	private final ModelPart leftBand;
	private final ModelPart rightBand;
	private final ModelPart backBand;
	private final ModelPart gem;

	public ModelVibeSeer() {
		super(1.0f);
		textureWidth = 64;
		textureHeight = 128;

		frontBand = new ModelRenderer(this);
		frontBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		frontBand.setTextureOffset(0, 120).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		leftBand = new ModelRenderer(this);
		leftBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftBand.setTextureOffset(20, 100).addBox(4.0F, -7.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, true);

		rightBand = new ModelRenderer(this);
		rightBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightBand.setTextureOffset(20, 100).addBox(-5.0F, -7.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, true);

		backBand = new ModelRenderer(this);
		backBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		backBand.setTextureOffset(0, 120).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);

		gem = new ModelRenderer(this);
		gem.setRotationPoint(0.0F, 0.0F, 0.0F);
		gem.setTextureOffset(0, 100).addBox(-1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, true);
		this.bipedHead.addChild(backBand);
		this.bipedHead.addChild(frontBand);
		this.bipedHead.addChild(leftBand);
		this.bipedHead.addChild(rightBand);
		this.bipedHead.addChild(gem);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}