package com.huto.forcesofreality.render.entity.projectile;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntityEldritchGrip;
import com.huto.forcesofreality.model.entity.summon.ModelEldritchGrip;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderEldritchGrip extends MobRenderer<EntityEldritchGrip, ModelEldritchGrip> {
/*	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tentacle/model_tentacle.png");*/

	public RenderEldritchGrip(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelEldritchGrip(), 0.0f);

	}

	@Override
	public void render(EntityEldritchGrip entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityEldritchGrip entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/eldritch_grip/model_eldritch_grip.png");
	}

}