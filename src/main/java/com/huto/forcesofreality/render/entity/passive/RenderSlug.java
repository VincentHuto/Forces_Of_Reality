package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.passive.EntitySlug;
import com.huto.forcesofreality.model.entity.passive.ModelSlug;

import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderSlug extends MobRenderer<EntitySlug, ModelSlug> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderSlug(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelSlug(), 0.1f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntitySlug entity) {
		return entity.getSlugTypeName();

	}

}
