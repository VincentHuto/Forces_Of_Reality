package com.huto.forces_of_reality.models.entity.mobs;

import com.google.common.collect.ImmutableList;
import com.huto.forces_of_reality.entities.mobs.EntityHasturVassal;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelHasturVassal extends EntityModel<EntityHasturVassal> {
	private final ModelRenderer body;
	private final ModelRenderer cloak;
	private final ModelRenderer mouth;
	private final ModelRenderer teeth;
	private final ModelRenderer tentacle1;
	private final ModelRenderer tentacle2;
	private final ModelRenderer tentacle3;
	private final ModelRenderer tentacle4;
	private final ModelRenderer tentacle5;
	private final ModelRenderer tentacle6;
	private final ModelRenderer tentacle7;
	private final ModelRenderer tentacle8;
	private ImmutableList<ModelRenderer> tentacles;

	public ModelHasturVassal() {
		textureWidth = 64;
		textureHeight = 64;
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 16.0F, 12.0F, 0.0F, false);

		cloak = new ModelRenderer(this);
		cloak.setRotationPoint(0.0F, 0.0F, 12.1F);
		body.addChild(cloak);
		cloak.setTextureOffset(0, 17).addBox(-7.0F, -8.0F, -18.1F, 0.0F, 17.0F, 12.0F, 0.0F, false);
		cloak.setTextureOffset(0, 17).addBox(6.1F, -8.0F, -18.1F, 0.0F, 17.0F, 12.0F, 0.0F, false);
		cloak.setTextureOffset(0, 29).addBox(-6.0F, -7.0F, -18.2F, 12.0F, 16.0F, 0.0F, 0.0F, false);
		cloak.setTextureOffset(0, 29).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 17.0F, 0.0F, 0.0F, false);

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, -11.2879F, 0.0F);
		body.addChild(mouth);
		mouth.setTextureOffset(10, 20).addBox(-6.0F, 1.2879F, -8.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		mouth.setTextureOffset(10, 20).addBox(-6.0F, 1.2879F, 6.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		mouth.setTextureOffset(10, 20).addBox(-6.0F, -0.7121F, 7.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);
		mouth.setTextureOffset(10, 20).addBox(-6.0F, -0.7121F, -8.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(6.0F, 0.2879F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		mouth.setTextureOffset(10, 12).addBox(-8.0F, -0.7121F, -6.0F, 1.0F, 2.0F, 12.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(-7.0F, 0.2879F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(-7.0F, 0.2879F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		mouth.setTextureOffset(10, 12).addBox(6.0F, 0.2879F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(7.0F, -0.7121F, -6.0F, 1.0F, 2.0F, 12.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(-8.0F, 1.2879F, -6.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		mouth.setTextureOffset(10, 12).addBox(6.0F, 1.2879F, -6.0F, 2.0F, 1.0F, 12.0F, 0.0F, false);
		mouth.setTextureOffset(0, 0).addBox(-6.0F, 2.2879F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);

		teeth = new ModelRenderer(this);
		teeth.setRotationPoint(-8.0F, -7.7121F, -1.0F);
		mouth.addChild(teeth);
		teeth.setTextureOffset(46, 30).addBox(10.0F, 5.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, true);
		teeth.setTextureOffset(46, 30).addBox(11.0F, 3.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		teeth.setTextureOffset(46, 30).addBox(9.0F, 7.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, true);
		teeth.setTextureOffset(46, 30).addBox(4.0F, 4.0F, 4.0F, 1.0F, 6.0F, 1.0F, 0.0F, true);
		teeth.setTextureOffset(46, 30).addBox(5.0F, 4.0F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, true);
		teeth.setTextureOffset(48, 30).addBox(1.0F, 6.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(1.0F, 6.0F, -1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(1.0F, 6.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(1.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(1.0F, 6.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(4.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(6.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(8.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(10.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(12.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(13.0F, 6.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(13.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(13.0F, 6.0F, 1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(13.0F, 6.0F, -1.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(13.0F, 6.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(12.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(10.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(8.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(6.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		teeth.setTextureOffset(48, 30).addBox(4.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		tentacle1 = new ModelRenderer(this);
		tentacle1.setRotationPoint(5.0F, 31.0F, 0.0F);
		setRotationAngle(tentacle1, 0.0F, 1.5708F, 0.0F);
		tentacle1.setTextureOffset(0, 39).addBox(-5.9F, 1.0F, 2.0F, 12.0F, 24.0F, 0.0F, 0.0F, false);
		tentacle1.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		tentacle1.setTextureOffset(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		tentacle1.setTextureOffset(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		tentacle2 = new ModelRenderer(this);
		tentacle2.setRotationPoint(3.5F, 31.0F, 3.5F);
		setRotationAngle(tentacle2, 0.0F, 0.7854F, 0.0F);
		tentacle2.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		tentacle2.setTextureOffset(0, 31).addBox(-3.5F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, 0.0F, false);

		tentacle3 = new ModelRenderer(this);
		tentacle3.setRotationPoint(0.0F, 31.0F, 5.0F);
		tentacle3.setTextureOffset(0, 29).addBox(-6.0F, 1.0F, 2.1F, 12.0F, 24.0F, 0.0F, 0.0F, false);
		tentacle3.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		tentacle3.setTextureOffset(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		tentacle3.setTextureOffset(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		tentacle4 = new ModelRenderer(this);
		tentacle4.setRotationPoint(-3.5F, 31.0F, 3.5F);
		setRotationAngle(tentacle4, 0.0F, -0.7854F, 0.0F);
		tentacle4.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		tentacle4.setTextureOffset(0, 31).addBox(-3.0F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, 0.0F, false);

		tentacle5 = new ModelRenderer(this);
		tentacle5.setRotationPoint(-5.0F, 31.0F, 0.0F);
		setRotationAngle(tentacle5, 0.0F, -1.5708F, 0.0F);
		tentacle5.setTextureOffset(0, 30).addBox(-6.0F, 1.0F, 2.0F, 12.0F, 23.0F, 0.0F, 0.0F, false);
		tentacle5.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		tentacle5.setTextureOffset(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		tentacle5.setTextureOffset(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		tentacle6 = new ModelRenderer(this);
		tentacle6.setRotationPoint(-3.5F, 31.0F, -3.5F);
		setRotationAngle(tentacle6, 0.0F, -2.3562F, 0.0F);
		tentacle6.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		tentacle6.setTextureOffset(0, 31).addBox(-3.0F, 1.0F, -0.5F, 6.0F, 21.0F, 0.0F, 0.0F, false);

		tentacle7 = new ModelRenderer(this);
		tentacle7.setRotationPoint(0.0F, 31.0F, -5.0F);
		setRotationAngle(tentacle7, 0.0F, -3.1416F, 0.0F);
		tentacle7.setTextureOffset(0, 29).addBox(-6.0F, 1.0F, 2.0F, 12.0F, 24.0F, 0.0F, 0.0F, false);
		tentacle7.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		tentacle7.setTextureOffset(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		tentacle7.setTextureOffset(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		tentacle8 = new ModelRenderer(this);
		tentacle8.setRotationPoint(3.5F, 31.0F, -3.5F);
		setRotationAngle(tentacle8, 0.0F, -3.927F, 0.0F);
		tentacle8.setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		tentacle8.setTextureOffset(0, 31).addBox(-3.0F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, 0.0F, false);

		this.tentacles = ImmutableList.of(this.tentacle1, this.tentacle2, this.tentacle3, this.tentacle4,
				this.tentacle5, this.tentacle6, this.tentacle7, this.tentacle8);
	}

	@Override
	public void setRotationAngles(EntityHasturVassal entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		for (ModelRenderer modelrenderer : this.tentacles) {
			modelrenderer.rotateAngleX = ageInTicks;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle7.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacle8.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}