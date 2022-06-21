package com.vincenthuto.forcesofreality.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelHastur;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LayerHasturAura extends RenderLayer<EntityHastur, ModelHastur> {
	private static final ResourceLocation COLIN_ARMOR = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/entity/hastur/hastur_aura.png");
	private final ModelHastur hasturModel;

	public LayerHasturAura(RenderLayerParent<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
		hasturModel=entityRendererIn.getModel();
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
			EntityHastur entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (entitylivingbaseIn.isArmored()) {
			float f = entitylivingbaseIn.tickCount + partialTicks;
			hasturModel.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			this.getParentModel().copyPropertiesTo(hasturModel);
			float swirlSpeedMod = 0.00f;
			if (!entitylivingbaseIn.isVulnerable()) {
				swirlSpeedMod = 0.01f;
			} else {
				swirlSpeedMod = 0.04f;
			}
			VertexConsumer ivertexbuilder = bufferIn
					.getBuffer(RenderType.energySwirl(COLIN_ARMOR, f * swirlSpeedMod, f * 0.01F));
			hasturModel.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			hasturModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 0.5F,
					0.5F, 0.5F, 0.5F);
		}
	}

}
