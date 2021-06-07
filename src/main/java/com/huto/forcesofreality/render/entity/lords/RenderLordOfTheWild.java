package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityLordOfTheWild;
import com.huto.forcesofreality.model.entity.lord.ModelLordOfTheWild;
import com.huto.forcesofreality.render.entity.layer.LayerLordOfTheWildLines;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLordOfTheWild extends MobRenderer<EntityLordOfTheWild, ModelLordOfTheWild> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/lord_of_the_wild/model_lord_of_the_wild.png");
	public RenderLordOfTheWild(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelLordOfTheWild(), 2.5f);
		this.addLayer(new LayerLordOfTheWildLines(this));

	}

	@Override
	public ResourceLocation getEntityTexture(EntityLordOfTheWild entity) {
		return TEXTURE;

	}
}