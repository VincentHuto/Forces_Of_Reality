package com.vincenthuto.forcesofreality.client.render.entity.lords;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.lord.ModelLordOfTheWild;
import com.vincenthuto.forcesofreality.client.render.entity.layer.LayerLordOfTheWildLines;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityLordOfTheWild;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLordOfTheWild extends MobRenderer<EntityLordOfTheWild, ModelLordOfTheWild> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/lord_of_the_wild/model_lord_of_the_wild.png");

	public RenderLordOfTheWild(Context renderManagerIn) {
		super(renderManagerIn, new ModelLordOfTheWild(renderManagerIn.bakeLayer(ModelLordOfTheWild.LAYER_LOCATION)), 2.5f);
		this.addLayer(new LayerLordOfTheWildLines(this));

	}

	@Override
	public ResourceLocation getTextureLocation(EntityLordOfTheWild entity) {
		return TEXTURE;

	}
}