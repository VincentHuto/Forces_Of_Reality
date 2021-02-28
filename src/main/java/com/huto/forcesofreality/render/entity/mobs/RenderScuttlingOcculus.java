package com.huto.forcesofreality.render.entity.mobs;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.mobs.EntityScuttlingOcculus;
import com.huto.forcesofreality.models.entity.mobs.ModelScuttlingOcculus;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderScuttlingOcculus extends MobRenderer<EntityScuttlingOcculus, ModelScuttlingOcculus> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/scuttling_occulus/model_scuttling_occulus.png");

	public RenderScuttlingOcculus(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelScuttlingOcculus(), 0.1f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityScuttlingOcculus entity) {
		return TEXTURE;

	}

}
