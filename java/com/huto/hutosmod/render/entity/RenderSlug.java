package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntitySlug;
import com.huto.hutosmod.models.ModelSlug;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSlug extends MobRenderer<EntitySlug, ModelSlug> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderSlug(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelSlug(), 0.1f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntitySlug entity) {
		return entity.getSlugTypeName();

	}

}
