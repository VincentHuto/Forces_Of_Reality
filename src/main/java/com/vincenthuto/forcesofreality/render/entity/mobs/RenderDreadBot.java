package com.vincenthuto.forcesofreality.render.entity.mobs;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityDreadBot;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelDreadBot;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderDreadBot extends MobRenderer<EntityDreadBot, ModelDreadBot> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dread_bot/model_dread_bot.png");

	public RenderDreadBot(Context renderManagerIn) {
		super(renderManagerIn, new ModelDreadBot(renderManagerIn.bakeLayer(ModelDreadBot.LAYER_LOCATION)), 0.1f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityDreadBot entity) {
		return TEXTURE;

	}

}
