package com.vincenthuto.forcesofreality.client.render.entity.lords;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.lord.ModelMechan;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityMechan;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderMechan extends MobRenderer<EntityMechan, ModelMechan> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/mechan/model_mechan.png");

	public RenderMechan(Context renderManagerIn) {
		super(renderManagerIn, new ModelMechan(renderManagerIn.bakeLayer(ModelMechan.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityMechan entity) {
		return TEXTURE;

	}

}
