package com.vincenthuto.forcesofreality.client.render.entity.mobs;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.mob.ModelScuttlingOcculus;
import com.vincenthuto.forcesofreality.common.entity.mob.EntityScuttlingOcculus;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderScuttlingOcculus extends MobRenderer<EntityScuttlingOcculus, ModelScuttlingOcculus> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/scuttling_occulus/model_scuttling_occulus.png");

	public RenderScuttlingOcculus(Context renderManagerIn) {
		super(renderManagerIn, new ModelScuttlingOcculus(renderManagerIn.bakeLayer(ModelScuttlingOcculus.LAYER_LOCATION)), 0.1f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityScuttlingOcculus entity) {
		return TEXTURE;

	}

}
