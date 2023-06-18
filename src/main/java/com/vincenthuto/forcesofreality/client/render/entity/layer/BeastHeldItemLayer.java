package com.vincenthuto.forcesofreality.client.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeastHeldItemLayer<T extends LivingEntity, M extends EntityModel<T> & ArmedModel>
		extends RenderLayer<T, M> {
	public BeastHeldItemLayer(RenderLayerParent<T, M> p_i50934_1_) {
		super(p_i50934_1_);
	}
  
	
	
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		boolean flag = entitylivingbaseIn.getMainArm() == HumanoidArm.RIGHT;
		ItemStack itemstack = flag ? entitylivingbaseIn.getOffhandItem() : entitylivingbaseIn.getMainHandItem();
		ItemStack itemstack1 = flag ? entitylivingbaseIn.getMainHandItem() : entitylivingbaseIn.getOffhandItem();
		if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
			matrixStackIn.pushPose();
			this.renderArmWithItem(entitylivingbaseIn, itemstack1, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
					HumanoidArm.RIGHT, matrixStackIn, bufferIn, packedLightIn);
			this.renderArmWithItem(entitylivingbaseIn, itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
					HumanoidArm.LEFT, matrixStackIn, bufferIn, packedLightIn);
			matrixStackIn.popPose();
		}
	}

	private void renderArmWithItem(LivingEntity ent, ItemStack stack, ItemDisplayContext p_229135_3_,
			HumanoidArm hand, PoseStack ms, MultiBufferSource p_229135_6_, int p_229135_7_) {
		if (!stack.isEmpty()) {
			ms.pushPose();
			this.getParentModel().translateToHand(hand, ms);
			boolean flag = hand == HumanoidArm.LEFT;
			ms.mulPose(Vector3.XP.rotationDegrees(-90.0F).toMoj());
			ms.mulPose(Vector3.YP.rotationDegrees(180.0F).toMoj());
			ms.translate((flag ? -1 : 1) / 16.0F + 0.1d, 0.325D, -0.325D);

			Minecraft.getInstance().getItemRenderer().renderStatic(ent, stack, p_229135_3_, flag, ms, p_229135_6_,
					ent.level(), p_229135_7_, p_229135_7_, p_229135_7_);
			ms.popPose();
		}
	}
}
