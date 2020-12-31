package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.passive.EntityAngelicFowl;
import com.huto.forcesofreality.models.entity.passive.ModelAngelicFowl;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderAngelicFowl extends MobRenderer<EntityAngelicFowl, ModelAngelicFowl> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/angelic_fowl/model_angelic_fowl.png");

	public RenderAngelicFowl(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelAngelicFowl(), 0.2f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityAngelicFowl entity) {
		return TEXTURE;

	}

	@Override
	protected float handleRotationFloat(EntityAngelicFowl livingBase, float partialTicks) {
		float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
		float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
		return (MathHelper.sin(f) + 1.0F) * f1;
	}

}
