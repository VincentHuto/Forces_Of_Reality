package com.huto.forces_of_reality.render.entity.projectile;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.projectiles.EntityTrackingOrb;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTrackingOrb extends EntityRenderer<EntityTrackingOrb> {

	public RenderTrackingOrb(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityTrackingOrb entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

}