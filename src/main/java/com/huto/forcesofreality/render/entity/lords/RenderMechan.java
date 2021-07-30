package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityMechan;
import com.huto.forcesofreality.model.entity.lord.ModelMechan;

import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderMechan extends MobRenderer<EntityMechan, ModelMechan> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/mechan/model_mechan.png");

	public RenderMechan(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelMechan(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityMechan entity) {
		return TEXTURE;

	}

}
