package com.vincenthuto.forcesofreality.client.render.entity.mobs;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.mob.ModelDerangedBeast;
import com.vincenthuto.forcesofreality.common.entity.mob.EntityDerangedBeast;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDerangedBeast extends MobRenderer<EntityDerangedBeast, ModelDerangedBeast> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/deranged_beast/model_deranged_beast_grey.png");

	public RenderDerangedBeast(Context renderManagerIn) {
		super(renderManagerIn, new ModelDerangedBeast(renderManagerIn.bakeLayer(ModelDerangedBeast.LAYER_LOCATION)), 0.5f);

	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityDerangedBeast entity) {
		return entity.getBeastTypeName();
	}

	@Override
	public void render(EntityDerangedBeast entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

}