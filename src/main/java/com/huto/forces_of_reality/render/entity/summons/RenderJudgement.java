package com.huto.forces_of_reality.render.entity.summons;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.projectiles.EntityJudgement;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderJudgement extends EntityRenderer<EntityJudgement> {

	public RenderJudgement(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityJudgement entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

}