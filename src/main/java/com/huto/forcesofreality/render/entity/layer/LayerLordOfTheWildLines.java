package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityLordOfTheWild;
import com.huto.forcesofreality.model.entity.lord.ModelLordOfTheWild;
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
public class LayerLordOfTheWildLines extends RenderLayer<EntityLordOfTheWild, ModelLordOfTheWild> {
	private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/lord_of_the_wild/model_lord_of_the_wild_lines.png"));
	private static final RenderType RENDER_TYPE_VUN = RenderType.getEyes(new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/lord_of_the_wild/model_lord_of_the_wild_lines_vun.png"));

	public LayerLordOfTheWildLines(IEntityRenderer<EntityLordOfTheWild, ModelLordOfTheWild> rendererIn) {
		super(rendererIn);

	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			EntityLordOfTheWild entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (entitylivingbaseIn.isVulnerable()) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RENDER_TYPE_VUN);
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
					1.0F, 1.0F);
		} else if (entitylivingbaseIn.isArmored() && !entitylivingbaseIn.isVulnerable()) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RENDER_TYPE);
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
					1.0F, 1.0F);
		} else {

		}
	}
}
