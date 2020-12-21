package com.huto.forces_of_reality.render.entity.mobs;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.mobs.EntityScuttlingOcculus;
import com.huto.forces_of_reality.models.entity.mobs.ModelScuttlingOcculus;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderScuttlingOcculus extends MobRenderer<EntityScuttlingOcculus, ModelScuttlingOcculus> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/scuttlingocculus/modelscuttlingocculus.png");

	public RenderScuttlingOcculus(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelScuttlingOcculus(), 0.1f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityScuttlingOcculus entity) {
		return TEXTURE;

	}

}
