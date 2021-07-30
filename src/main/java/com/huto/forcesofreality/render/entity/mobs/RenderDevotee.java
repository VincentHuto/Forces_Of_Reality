package com.huto.forcesofreality.render.entity.mobs;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.mob.EntityDevotee;
import com.huto.forcesofreality.model.entity.mob.ModelDevotee;

import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderDevotee extends MobRenderer<EntityDevotee, ModelDevotee> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/devotee/model_devotee.png");

	public RenderDevotee(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelDevotee(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityDevotee entity) {
		return TEXTURE;

	}

}
