package com.huto.forces_of_reality.render.entity.mobs;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.mobs.EntityHasturVassal;
import com.huto.forces_of_reality.models.entity.mobs.ModelHasturVassal;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class RenderHasturVassal extends MobRenderer<EntityHasturVassal, ModelHasturVassal> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur_vassal/model_hastur_vassal.png");
	private static final RenderType RENDER_TYPE = RenderType.getEyes(TEXTURE);

	public RenderHasturVassal(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelHasturVassal(), 0.8f);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHasturVassal entity) {
		return TEXTURE;

	}

	public static RenderType getRenderType() {
		return RENDER_TYPE;
	}

	@Override
	protected void applyRotations(EntityHasturVassal entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		float f = MathHelper.lerp(partialTicks, entityLiving.prevSquidPitch, entityLiving.squidPitch);
		float f1 = MathHelper.lerp(partialTicks, entityLiving.prevSquidYaw, entityLiving.squidYaw);
		matrixStackIn.translate(0.0D, 0.5D, 0.0D);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - rotationYaw));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f));
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f1));
//		matrixStackIn.translate(0.0D, (double) -1.2F, 0.0D);
	}

	@Override
	protected float handleRotationFloat(EntityHasturVassal livingBase, float partialTicks) {
		return MathHelper.lerp(partialTicks, livingBase.lastTentacleAngle, livingBase.tentacleAngle);
	}

}
