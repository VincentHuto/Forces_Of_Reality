package com.huto.forces_of_reality.render.entity.projectile;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.summons.EntityEldritchGrip;
import com.huto.forces_of_reality.models.entity.summons.ModelEldritchGrip;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderEldritchGrip extends MobRenderer<EntityEldritchGrip, ModelEldritchGrip> {
/*	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/tentacle/model_tentacle.png");*/

	public RenderEldritchGrip(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelEldritchGrip(), 0.0f);

	}

	@Override
	public void render(EntityEldritchGrip entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	@Override
	public ResourceLocation getEntityTexture(EntityEldritchGrip entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/eldritch_grip/model_eldritch_grip.png");
	}

}