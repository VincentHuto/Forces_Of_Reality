package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.lords.EntityVeritas;
import com.huto.forcesofreality.models.entity.lords.ModelVeritas;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderVeritas extends MobRenderer<EntityVeritas, ModelVeritas> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/veritas/model_veritas.png");

	public RenderVeritas(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelVeritas(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityVeritas entity) {
		return TEXTURE;

	}

}
