package com.vincenthuto.forcesofreality.client.render.entity.passive;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.passive.ModelSlug;
import com.vincenthuto.forcesofreality.common.entity.passive.EntitySlug;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderSlug extends MobRenderer<EntitySlug, ModelSlug> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderSlug(Context renderManagerIn) {
		super(renderManagerIn, new ModelSlug(renderManagerIn.bakeLayer(ModelSlug.LAYER_LOCATION)), 0.1f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntitySlug entity) {
		return entity.getSlugTypeName();

	}

}
