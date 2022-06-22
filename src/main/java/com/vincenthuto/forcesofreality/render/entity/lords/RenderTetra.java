package com.vincenthuto.forcesofreality.render.entity.lords;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityTetra;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelTetra;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerTetraGlow;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTetra extends MobRenderer<EntityTetra, ModelTetra> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tetra/model_tetra.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tetra/model_tetra.png");

	public RenderTetra(Context renderManagerIn) {
		super(renderManagerIn, new ModelTetra(renderManagerIn.bakeLayer(ModelTetra.LAYER_LOCATION)), 0.5f);
		addLayer(new LayerTetraGlow(this));
	}

	@Override
	public void render(EntityTetra entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);


	}

	@Override
	protected float getBob(EntityTetra livingBase, float partialTicks) {
		return 1f;
	}

	@Override
	public ResourceLocation getTextureLocation(EntityTetra entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}