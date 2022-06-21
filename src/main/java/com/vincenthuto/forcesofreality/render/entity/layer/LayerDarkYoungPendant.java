package com.vincenthuto.forcesofreality.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.entity.guardian.EntityDarkYoung;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelDarkYoung;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;

public class LayerDarkYoungPendant extends RenderLayer<EntityDarkYoung, ModelDarkYoung> {
	ModelDarkYoung model;

	public LayerDarkYoungPendant(RenderLayerParent<EntityDarkYoung, ModelDarkYoung> entityRendererIn) {
		super(entityRendererIn);
		model = entityRendererIn.getModel();
	}

	@Override
	public void render(PoseStack matrix, MultiBufferSource buf, int packedLight, EntityDarkYoung entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		matrix.pushPose();
		matrix.mulPose(Vector3f.XN.rotationDegrees(180f));
		matrix.scale(0.5f, 0.5f, 0.5f);
		matrix.translate(0, -3.1, -1);
		model.frontHead.translateAndRotate(matrix);
		Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(ItemInit.everwatchful_pendant.get()),
				TransformType.FIXED, packedLight, OverlayTexture.NO_OVERLAY, matrix, buf, packedLight);
		matrix.popPose();

		matrix.pushPose();
		matrix.mulPose(Vector3f.XN.rotationDegrees(180f));
		matrix.scale(0.5f, 0.5f, 0.5f);
		matrix.translate(0, -3.1, 0.75f);
		model.rearHead.translateAndRotate(matrix);
		Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(ItemInit.everwatchful_pendant.get()),
				TransformType.FIXED, packedLight, OverlayTexture.NO_OVERLAY, matrix, buf, packedLight);
		matrix.popPose();

	}
}