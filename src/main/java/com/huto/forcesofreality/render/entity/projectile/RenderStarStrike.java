package com.huto.forcesofreality.render.entity.projectile;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.projectile.EntityStarStrike;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderStarStrike extends EntityRenderer<EntityStarStrike> {

	public RenderStarStrike(EntityRenderDispatcher renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityStarStrike entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

}