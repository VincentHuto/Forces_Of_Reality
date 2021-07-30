package com.huto.forcesofreality.render.entity.projectile;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.projectile.EntityHolyFlare;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHolyFlare extends EntityRenderer<EntityHolyFlare> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tentacle/model_tentacle.png");

	public RenderHolyFlare(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);

	}

	@Override
	public void render(EntityHolyFlare entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHolyFlare entity) {
		return TEXTURE;
	}

}