package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.passive.EntityAngelicFowl;
import com.huto.forcesofreality.model.entity.passive.ModelAngelicFowl;

import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderAngelicFowl extends MobRenderer<EntityAngelicFowl, ModelAngelicFowl> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/angelic_fowl/model_angelic_fowl.png");

	public RenderAngelicFowl(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelAngelicFowl(), 0.2f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityAngelicFowl entity) {
		return TEXTURE;

	}

	@Override
	protected float handleRotationFloat(EntityAngelicFowl livingBase, float partialTicks) {
		float f = Mth.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
		float f1 = Mth.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
		return (Mth.sin(f) + 1.0F) * f1;
	}

}
