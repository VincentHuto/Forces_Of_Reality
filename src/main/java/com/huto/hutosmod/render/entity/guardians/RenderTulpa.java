package com.huto.hutosmod.render.entity.guardians;

import javax.annotation.Nonnull;

import com.huto.hutosmod.entities.guardians.EntityTulpa;
import com.huto.hutosmod.models.entity.guardians.ModelTulpa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTulpa extends MobRenderer<EntityTulpa, ModelTulpa> {

	public RenderTulpa(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelTulpa(), 2.5f);
		//this.addLayer(new LayerDreamWalkerMask(this));

	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityTulpa entity) {
		Minecraft mc = Minecraft.getInstance();
		if (!(mc.getRenderViewEntity() instanceof AbstractClientPlayerEntity))
			return DefaultPlayerSkin.getDefaultSkinLegacy();
		return ((AbstractClientPlayerEntity) mc.getRenderViewEntity()).getLocationSkin();
	}

}