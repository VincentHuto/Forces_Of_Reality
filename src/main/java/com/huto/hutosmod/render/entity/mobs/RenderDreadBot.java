package com.huto.hutosmod.render.entity.mobs;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.mobs.EntityDreadBot;
import com.huto.hutosmod.models.entity.mobs.ModelDreadBot;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDreadBot extends MobRenderer<EntityDreadBot, ModelDreadBot> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/dread_bot/model_dread_bot.png");

	public RenderDreadBot(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDreadBot(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityDreadBot entity) {
		return TEXTURE;

	}

}
