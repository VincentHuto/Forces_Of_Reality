package com.huto.forcesofreality.render.entity.guardians;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.guardian.EntityBeastFromBeyond;
import com.huto.forcesofreality.model.entity.guardian.ModelBeastFromBeyond;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBeastFromBeyond extends MobRenderer<EntityBeastFromBeyond, ModelBeastFromBeyond> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");

	public RenderBeastFromBeyond(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelBeastFromBeyond(), 1.5f);
		// this.addLayer(new LayerHasturAura(this));
		// this.addLayer(new LayerHasturDeath(this));
	}

	@Override
	public void render(EntityBeastFromBeyond entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityBeastFromBeyond entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBeastFromBeyond entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}