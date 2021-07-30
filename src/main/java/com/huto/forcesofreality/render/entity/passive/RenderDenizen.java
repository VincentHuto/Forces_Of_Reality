package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.passive.EntityDenizen;
import com.huto.forcesofreality.model.entity.passive.ModelDenizen;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizen extends MobRenderer<EntityDenizen, ModelDenizen> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderDenizen(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelDenizen(), 0.5f);
	}

	@Override
	public void render(EntityDenizen entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDenizen entity) {
		return entity.getDenizenTypeName();
	}
}