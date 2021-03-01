package com.huto.forcesofreality.render.entity.layer;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeastHeldItemLayer<T extends LivingEntity, M extends EntityModel<T> & IHasArm>
		extends LayerRenderer<T, M> {
	public BeastHeldItemLayer(IEntityRenderer<T, M> p_i50934_1_) {
		super(p_i50934_1_);
	}

	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		boolean flag = entitylivingbaseIn.getPrimaryHand() == HandSide.RIGHT;
		ItemStack itemstack = flag ? entitylivingbaseIn.getHeldItemOffhand() : entitylivingbaseIn.getHeldItemMainhand();
		ItemStack itemstack1 = flag ? entitylivingbaseIn.getHeldItemMainhand()
				: entitylivingbaseIn.getHeldItemOffhand();
		if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
			matrixStackIn.push();
			this.func_229135_a_(entitylivingbaseIn, itemstack1,
					ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT, matrixStackIn, bufferIn,
					packedLightIn);
			this.func_229135_a_(entitylivingbaseIn, itemstack,
					ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT, matrixStackIn, bufferIn,
					packedLightIn);
			matrixStackIn.pop();
		}
	}

	private void func_229135_a_(LivingEntity ent, ItemStack stack,
			ItemCameraTransforms.TransformType p_229135_3_, HandSide hand, MatrixStack ms,
			IRenderTypeBuffer p_229135_6_, int p_229135_7_) {
		if (!stack.isEmpty()) {
			ms.push();
			this.getEntityModel().translateHand(hand, ms);
			boolean flag = hand == HandSide.LEFT;
			ms.rotate(Vector3f.XP.rotationDegrees(-90.0F));
			ms.rotate(Vector3f.YP.rotationDegrees(180.0F));
			ms.translate((double)((float)(flag ? -1 : 1) / 16.0F)+0.1d, 0.325D, -0.325D);

			Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(ent, stack, p_229135_3_, flag,
					ms, p_229135_6_, p_229135_7_);
			ms.pop();
		}
	}
}
