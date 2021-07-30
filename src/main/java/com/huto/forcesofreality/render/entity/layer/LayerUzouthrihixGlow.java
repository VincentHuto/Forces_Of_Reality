package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.huto.forcesofreality.model.entity.lord.ModelUzouthrhix;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerUzouthrihixGlow extends RenderLayer<EntityUzouthrhix, ModelUzouthrhix> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/uzouthrhix/model_uzouthrhix_awoken_mask.png"));

	
	
	public LayerUzouthrihixGlow(IEntityRenderer<EntityUzouthrhix, ModelUzouthrhix> rendererIn) {
		super(rendererIn);

	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			EntityUzouthrhix entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (entitylivingbaseIn.isVulnerable()) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RENDER_TYPE);
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
					1.0F, 1.0F);
		} else {

		}
	}
}
