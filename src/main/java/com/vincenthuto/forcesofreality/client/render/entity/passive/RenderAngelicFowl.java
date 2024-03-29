package com.vincenthuto.forcesofreality.client.render.entity.passive;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.passive.ModelAngelicFowl;
import com.vincenthuto.forcesofreality.common.entity.passive.EntityAngelicFowl;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderAngelicFowl extends MobRenderer<EntityAngelicFowl, ModelAngelicFowl> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/angelic_fowl/model_angelic_fowl.png");

	public RenderAngelicFowl(Context renderManagerIn) {
		super(renderManagerIn, new ModelAngelicFowl(renderManagerIn.bakeLayer(ModelAngelicFowl.LAYER_LOCATION)), 0.2f);

	}

	@Override
	protected float getBob(EntityAngelicFowl livingBase, float partialTicks) {
		float f = Mth.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
		float f1 = Mth.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
		return (Mth.sin(f) + 1.0F) * f1;
	}

	@Override
	public ResourceLocation getTextureLocation(EntityAngelicFowl entity) {
		return TEXTURE;

	}

}
