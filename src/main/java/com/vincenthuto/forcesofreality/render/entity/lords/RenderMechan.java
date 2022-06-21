package com.vincenthuto.forcesofreality.render.entity.lords;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityMechan;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelMechan;

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
