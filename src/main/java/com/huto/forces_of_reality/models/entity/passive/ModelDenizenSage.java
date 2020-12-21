package com.huto.forces_of_reality.models.entity.passive;

import com.huto.forces_of_reality.entities.passive.EntityDenizenSage;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModelDenizenSage extends EntityModel<EntityDenizenSage> implements IHasArm {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	public ArmPose leftArmPose = ArmPose.EMPTY;
	public ArmPose rightArmPose = ArmPose.EMPTY;

	public ModelDenizenSage() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -2.0F);
		Head.setTextureOffset(52, 39).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(48, 32).addBox(-2.0F, -6.0F, -7.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(27, 51).addBox(-1.0F, -5.0F, -12.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		Head.setTextureOffset(30, 0).addBox(-1.0F, -3.0F, -14.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 9.6667F, 0.0F);
		Body.setTextureOffset(0, 24).addBox(-5.0F, -10.6667F, -2.0F, 10.0F, 12.0F, 9.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-5.0F, 1.3333F, -3.0F, 10.0F, 14.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(35, 19).addBox(-4.0F, -7.6667F, -7.0F, 8.0F, 8.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, -1.0F);
		RightArm.setTextureOffset(40, 0).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, -1.0F);
		LeftArm.setTextureOffset(38, 38).addBox(0.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
		RightLeg.setTextureOffset(16, 45).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 0).addBox(-1.1F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(45, 47).addBox(-1.2F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		RightLeg.setTextureOffset(54, 0).addBox(-2.2F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		RightLeg.setTextureOffset(29, 29).addBox(-0.2F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 45).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 24).addBox(-1.0F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(47, 9).addBox(-1.0F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		LeftLeg.setTextureOffset(36, 54).addBox(1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 7).addBox(-1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDenizenSage entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.Head.rotateAngleX = (-(float) Math.PI / 4F);
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.RightArm.rotateAngleY = 0.0F;
		this.LeftArm.rotateAngleY = 0.0F;
		boolean flag2 = entity.getPrimaryHand() == HandSide.RIGHT;
		boolean flag3 = flag2 ? this.leftArmPose.func_241657_a_() : this.rightArmPose.func_241657_a_();
		if (flag2 != flag3) {
			this.func_241655_c_(entity);
			this.func_241654_b_(entity);
		} else {
			this.func_241654_b_(entity);
			this.func_241655_c_(entity);
		}

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private void func_241654_b_(EntityDenizenSage p_241654_1_) {
		switch (this.rightArmPose) {
		case EMPTY:
			this.RightArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - 0.9424779F;
			this.RightArm.rotateAngleY = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.RightArm.rotateAngleY = 0.0F;
			break;
		case THROW_SPEAR:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - (float) Math.PI;
			this.RightArm.rotateAngleY = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY + 0.4F;
			this.RightArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			break;
		case CROSSBOW_CHARGE:
			ModelHelper.func_239102_a_(this.RightArm, this.LeftArm, p_241654_1_, true);
			break;
		case CROSSBOW_HOLD:
			ModelHelper.func_239104_a_(this.RightArm, this.LeftArm, this.Head, true);
		}

	}

	protected HandSide getMainHand(EntityDenizenSage entityIn) {
		HandSide handside = entityIn.getPrimaryHand();
		return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	}

	private void func_241655_c_(EntityDenizenSage p_241655_1_) {
		switch (this.leftArmPose) {
		case EMPTY:
			this.LeftArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - 0.9424779F;
			this.LeftArm.rotateAngleY = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.LeftArm.rotateAngleY = 0.0F;
			break;
		case THROW_SPEAR:
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - (float) Math.PI;
			this.LeftArm.rotateAngleY = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY - 0.4F;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
			this.RightArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			break;
		case CROSSBOW_CHARGE:
			ModelHelper.func_239102_a_(this.RightArm, this.LeftArm, p_241655_1_, false);
			break;
		case CROSSBOW_HOLD:
			ModelHelper.func_239104_a_(this.RightArm, this.LeftArm, this.Head, false);
		}

	}

	protected void func_230486_a_(EntityDenizenSage p_230486_1_, float p_230486_2_) {
		if (!(this.swingProgress <= 0.0F)) {
			HandSide handside = this.getMainHand(p_230486_1_);
			ModelRenderer modelrenderer = this.getArmForSide(handside);
			float f = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f) * ((float) Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.Body.rotateAngleY *= -1.0F;
			}

			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f = 1.0F - this.swingProgress;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = MathHelper.sin(f * (float) Math.PI);
			float f2 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX
					- ((double) f1 * 1.2D + (double) f2));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
	}

	protected float rotLerpRad(float angleIn, float maxAngleIn, float mulIn) {
		float f = (mulIn - maxAngleIn) % ((float) Math.PI * 2F);
		if (f < -(float) Math.PI) {
			f += ((float) Math.PI * 2F);
		}

		if (f >= (float) Math.PI) {
			f -= ((float) Math.PI * 2F);
		}

		return maxAngleIn + angleIn * f;
	}

	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		this.getArmForSide(sideIn).translateRotate(matrixStackIn);
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.LeftArm : this.RightArm;
	}

	public ModelRenderer getModelHead() {
		return this.Head;
	}

	@OnlyIn(Dist.CLIENT)
	public static enum ArmPose {
		EMPTY(false), ITEM(false), BLOCK(false), BOW_AND_ARROW(true), THROW_SPEAR(false), CROSSBOW_CHARGE(true),
		CROSSBOW_HOLD(true);

		private final boolean field_241656_h_;

		private ArmPose(boolean p_i241257_3_) {
			this.field_241656_h_ = p_i241257_3_;
		}

		public boolean func_241657_a_() {
			return this.field_241656_h_;
		}
	}

}