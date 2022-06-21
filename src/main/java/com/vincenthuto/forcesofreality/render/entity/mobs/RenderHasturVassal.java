package com.vincenthuto.forcesofreality.render.entity.mobs;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityHasturVassal;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelVassalOfHastur;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderHasturVassal extends MobRenderer<EntityHasturVassal, ModelVassalOfHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur_vassal/model_hastur_vassal.png");
	private static final RenderType RENDER_TYPE = RenderType.eyes(TEXTURE);

	public RenderHasturVassal(Context renderManagerIn) {
		super(renderManagerIn, new ModelVassalOfHastur(renderManagerIn.bakeLayer(ModelVassalOfHastur.LAYER_LOCATION)), 0.8f);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityHasturVassal entity) {
		return TEXTURE;

	}

	public static RenderType getRenderType() {
		return RENDER_TYPE;
	}

	@Override
	protected void setupRotations(EntityHasturVassal entityLiving, PoseStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		float f = Mth.lerp(partialTicks, entityLiving.prevSquidPitch, entityLiving.squidPitch);
		float f1 = Mth.lerp(partialTicks, entityLiving.prevSquidYaw, entityLiving.squidYaw);
		matrixStackIn.translate(0.0D, 0.5D, 0.0D);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - rotationYaw));
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(f));
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(f1));
//		matrixStackIn.translate(0.0D, (double) -1.2F, 0.0D);
	}

	@Override
	protected float getBob(EntityHasturVassal livingBase, float partialTicks) {
		return Mth.lerp(partialTicks, livingBase.lastTentacleAngle, livingBase.tentacleAngle);
	}

}
