package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityMechan;
import com.huto.hutosmod.models.entity.ModelMechan;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMechan extends MobRenderer<EntityMechan, ModelMechan> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/mechan/model_mechan.png");

	public RenderMechan(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelMechan(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityMechan entity) {
		return TEXTURE;

	}

}
