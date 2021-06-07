package com.huto.forcesofreality.render.entity.projectile;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntityEldritchGrip;
import com.huto.forcesofreality.model.entity.summon.ModelEldritchGrip;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderEldritchGrip extends MobRenderer<EntityEldritchGrip, ModelEldritchGrip> {
/*	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
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