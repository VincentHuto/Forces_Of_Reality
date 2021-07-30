package com.huto.forcesofreality.render.entity.guardians;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.guardian.EntitySeraphim;
import com.huto.forcesofreality.model.entity.guardian.ModelSeraphim;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSeraphim extends MobRenderer<EntitySeraphim, ModelSeraphim> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/seraphim/modelseraphim.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/seraphim/modelseraphim.png");

	public RenderSeraphim(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelSeraphim(), 0.5f);

	}

	@Override
	public void render(EntitySeraphim entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	protected float handleRotationFloat(EntitySeraphim livingBase, float partialTicks) {
		return 1f;
	}

	@Override
	public ResourceLocation getEntityTexture(EntitySeraphim entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}