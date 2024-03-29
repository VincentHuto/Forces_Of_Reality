package com.vincenthuto.forcesofreality.client.render.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.summon.ModelEldritchGrip;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityEldritchGrip;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderEldritchGrip extends MobRenderer<EntityEldritchGrip, ModelEldritchGrip> {
	/*
	 * protected static final ResourceLocation TEXTURE = new
	 * ResourceLocation(ForcesOfReality.MOD_ID,
	 * "textures/entity/tentacle/model_tentacle.png");
	 */

	public RenderEldritchGrip(net.minecraft.client.renderer.entity.EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ModelEldritchGrip(renderManagerIn.bakeLayer(ModelEldritchGrip.LAYER_LOCATION)), 0.0f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityEldritchGrip entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/eldritch_grip/model_eldritch_grip.png");
	}

	@Override
	public void render(EntityEldritchGrip entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

}