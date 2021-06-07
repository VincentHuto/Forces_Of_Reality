package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.guardian.EntityHastur;
import com.huto.forcesofreality.model.entity.guardian.ModelHastur;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class LayerHasturAura extends LayerRenderer<EntityHastur, ModelHastur> {
	private static final ResourceLocation COLIN_ARMOR = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/entity/hastur/hastur_aura.png");
	private final ModelHastur hasturModel = new ModelHastur();

	public LayerHasturAura(IEntityRenderer<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			EntityHastur entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (entitylivingbaseIn.isArmored()) {
			float f = (float) entitylivingbaseIn.ticksExisted + partialTicks;
			hasturModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			this.getEntityModel().copyModelAttributesTo(hasturModel);
			float swirlSpeedMod = 0.00f;
			if (!entitylivingbaseIn.isVulnerable()) {
				swirlSpeedMod = 0.01f;
			} else {
				swirlSpeedMod = 0.04f;
			}
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEnergySwirl(COLIN_ARMOR, f * swirlSpeedMod, f * 0.01F));
			hasturModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
					headPitch);
			hasturModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F,
					0.5F, 0.5F);
		}
	}

}
