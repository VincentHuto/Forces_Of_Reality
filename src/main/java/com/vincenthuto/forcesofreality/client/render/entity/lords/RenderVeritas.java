package com.vincenthuto.forcesofreality.client.render.entity.lords;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.lord.ModelVeritas;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityVeritas;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderVeritas extends MobRenderer<EntityVeritas, ModelVeritas> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/veritas/model_veritas.png");

	public RenderVeritas(Context renderManagerIn) {
		super(renderManagerIn, new ModelVeritas(renderManagerIn.bakeLayer(ModelVeritas.LAYER_LOCATION)), 0.8f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityVeritas entity) {
		return TEXTURE;

	}

}
