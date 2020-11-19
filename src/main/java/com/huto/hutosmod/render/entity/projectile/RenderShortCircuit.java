package com.huto.hutosmod.render.entity.projectile;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.projectiles.EntityShortCircuit;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderShortCircuit extends EntityRenderer<EntityShortCircuit> {

	public RenderShortCircuit(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityShortCircuit entity) {
		return new ResourceLocation(HutosMod.MOD_ID + "textures/entity/tracker.png");
	}

}