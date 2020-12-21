package com.huto.forces_of_reality.render.entity.passive;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.passive.EntitySlug;
import com.huto.forces_of_reality.models.entity.passive.ModelSlug;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSlug extends MobRenderer<EntitySlug, ModelSlug> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderSlug(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelSlug(), 0.1f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntitySlug entity) {
		return entity.getSlugTypeName();

	}

}
