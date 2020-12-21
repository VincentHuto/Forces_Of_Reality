package com.huto.forces_of_reality.render.entity.lords;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.lords.EntityMechan;
import com.huto.forces_of_reality.models.entity.lords.ModelMechan;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMechan extends MobRenderer<EntityMechan, ModelMechan> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/mechan/model_mechan.png");

	public RenderMechan(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelMechan(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityMechan entity) {
		return TEXTURE;

	}

}
