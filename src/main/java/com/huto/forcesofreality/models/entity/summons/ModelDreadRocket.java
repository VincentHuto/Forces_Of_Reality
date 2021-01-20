package com.huto.forcesofreality.models.entity.summons;

import com.huto.forcesofreality.entities.projectiles.EntityDreadRocket;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDreadRocket extends EntityModel<EntityDreadRocket> {
	public ModelRenderer rocket;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone3;
	private final ModelRenderer cone;
	private final ModelRenderer bone10;
	private final ModelRenderer bone7;
	private final ModelRenderer bone2;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;

	public ModelDreadRocket() {
		textureWidth = 16;
		textureHeight = 16;

		rocket = new ModelRenderer(this);
		rocket.setRotationPoint(0.0F, 21.0222F, 0.0F);
		setRotationAngle(rocket, 1.5708F, 0.0F, 0.0F);
		rocket.setTextureOffset(0, 0).addBox(-1.0F, -2.0222F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		rocket.setTextureOffset(8, 4).addBox(-0.5F, -4.3222F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.6F, 2.1778F, 0.5F);
		rocket.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, -0.2618F);
		bone4.setTextureOffset(8, 8).addBox(-0.983F, -2.2294F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.1F, 2.1778F, -1.0F);
		rocket.addChild(bone5);
		setRotationAngle(bone5, -0.2618F, 0.0F, 0.0F);
		bone5.setTextureOffset(4, 6).addBox(-0.5F, -2.2035F, -0.6136F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.1F, 2.1778F, 2.0F);
		rocket.addChild(bone6);
		setRotationAngle(bone6, 0.2618F, 0.0F, 0.0F);
		bone6.setTextureOffset(7, 12).addBox(-0.6F, -6.2402F, -0.865F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.6F, 2.1778F, 0.0F);
		rocket.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.2618F);
		bone3.setTextureOffset(8, 0).addBox(-0.017F, -2.2294F, -0.49F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cone = new ModelRenderer(this);
		cone.setRotationPoint(0.5F, 1.9778F, -0.5F);
		rocket.addChild(cone);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-0.4F, 0.2F, 2.5F);
		cone.addChild(bone10);
		setRotationAngle(bone10, 0.2618F, 0.0F, 0.0F);
		bone10.setTextureOffset(0, 6).addBox(-0.5F, -2.2035F, -1.3864F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-0.4F, -4.8F, 0.5F);
		cone.addChild(bone7);
		setRotationAngle(bone7, -0.2618F, 0.0F, 0.0F);
		bone7.setTextureOffset(4, 10).addBox(-0.6F, -0.9586F, -0.7551F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-1.1F, -4.8F, 0.5F);
		cone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, 0.2618F);
		bone2.setTextureOffset(11, 11).addBox(-0.1843F, -1.0811F, -0.49F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(1.6F, 2.1778F, 0.5F);
		rocket.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.0F, -0.2618F);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.6F, -2.8222F, 0.5F);
		rocket.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.0F, -0.2618F);
		bone9.setTextureOffset(0, 10).addBox(-0.75F, -1.0987F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDreadRocket entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		rocket.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}