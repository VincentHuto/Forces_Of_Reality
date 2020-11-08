package com.huto.hutosmod.render.entity.layer;

import com.huto.hutosmod.entities.EntityDarkYoung;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.models.entity.ModelDarkYoung;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class LayerDarkYoungPendant extends LayerRenderer<EntityDarkYoung, ModelDarkYoung> {
	ModelDarkYoung model;

	public LayerDarkYoungPendant(IEntityRenderer<EntityDarkYoung, ModelDarkYoung> entityRendererIn) {
		super(entityRendererIn);
		model = entityRendererIn.getEntityModel();
	}

	@Override
	public void render(MatrixStack matrix, IRenderTypeBuffer buf, int packedLight, EntityDarkYoung entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		RenderHelper.enableStandardItemLighting();
		matrix.push();
		matrix.rotate(Vector3f.XN.rotationDegrees(180f));
		matrix.scale(0.5f, 0.5f, 0.5f);
		matrix.translate(0, -3.1, -1);
		model.frontHead.translateRotate(matrix);
		Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ItemInit.everwatchful_pendant.get()),
				TransformType.FIXED, packedLight, OverlayTexture.NO_OVERLAY, matrix, buf);
		matrix.pop();

		matrix.push();
		matrix.rotate(Vector3f.XN.rotationDegrees(180f));
		matrix.scale(0.5f, 0.5f, 0.5f);
		matrix.translate(0, -3.1, 0.75f);
		model.rearHead.translateRotate(matrix);
		Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(ItemInit.everwatchful_pendant.get()),
				TransformType.FIXED, packedLight, OverlayTexture.NO_OVERLAY, matrix, buf);
		matrix.pop();

	}
}