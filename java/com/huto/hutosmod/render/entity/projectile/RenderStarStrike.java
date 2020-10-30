package com.huto.hutosmod.render.entity.projectile;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.projectiles.EntityStarStrike;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderStarStrike extends EntityRenderer<EntityStarStrike> {

	public RenderStarStrike(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityStarStrike entity) {
		return new ResourceLocation(HutosMod.MOD_ID + "textures/entity/tracker.png");
	}

}