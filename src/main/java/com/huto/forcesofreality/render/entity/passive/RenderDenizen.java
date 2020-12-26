package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.passive.EntityDenizen;
import com.huto.forcesofreality.models.entity.passive.ModelDenizen;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizen extends MobRenderer<EntityDenizen, ModelDenizen> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen/model_denizen.png");

	public RenderDenizen(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDenizen(), 0.5f);
	}

	@Override
	public void render(EntityDenizen entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDenizen entity) {
		return entity.getDenizenTypeName();
	}
}