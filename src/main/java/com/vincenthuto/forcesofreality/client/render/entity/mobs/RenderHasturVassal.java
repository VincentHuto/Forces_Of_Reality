package com.vincenthuto.forcesofreality.client.render.entity.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.mob.ModelVassalOfHastur;
import com.vincenthuto.forcesofreality.common.entity.mob.EntityHasturVassal;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderHasturVassal extends MobRenderer<EntityHasturVassal, ModelVassalOfHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur_vassal/model_hastur_vassal.png");
	private static final RenderType RENDER_TYPE = RenderType.eyes(TEXTURE);

	public static RenderType getRenderType() {
		return RENDER_TYPE;
	}

	public RenderHasturVassal(Context renderManagerIn) {
		super(renderManagerIn, new ModelVassalOfHastur(renderManagerIn.bakeLayer(ModelVassalOfHastur.LAYER_LOCATION)), 0.8f);

	}

	@Override
	protected float getBob(EntityHasturVassal livingBase, float partialTicks) {
		return Mth.lerp(partialTicks, livingBase.lastTentacleAngle, livingBase.tentacleAngle);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityHasturVassal entity) {
		return TEXTURE;

	}

	@Override
	protected void setupRotations(EntityHasturVassal entityLiving, PoseStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		float f = Mth.lerp(partialTicks, entityLiving.prevSquidPitch, entityLiving.squidPitch);
		float f1 = Mth.lerp(partialTicks, entityLiving.prevSquidYaw, entityLiving.squidYaw);
		matrixStackIn.translate(0.0D, 0.5D, 0.0D);
		matrixStackIn.mulPose(Vector3.YP.rotationDegrees(180.0F - rotationYaw).toMoj());
		matrixStackIn.mulPose(Vector3.XP.rotationDegrees(f).toMoj());
		matrixStackIn.mulPose(Vector3.YP.rotationDegrees(f1).toMoj());
//		matrixStackIn.translate(0.0D, (double) -1.2F, 0.0D);
	}

}
