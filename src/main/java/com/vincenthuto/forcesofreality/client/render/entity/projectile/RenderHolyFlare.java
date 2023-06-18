package com.vincenthuto.forcesofreality.client.render.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityHolyFlare;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHolyFlare extends EntityRenderer<EntityHolyFlare> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tentacle/model_tentacle.png");

	public RenderHolyFlare(net.minecraft.client.renderer.entity.EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityHolyFlare entity) {
		return TEXTURE;
	}

	@Override
	public void render(EntityHolyFlare entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

}