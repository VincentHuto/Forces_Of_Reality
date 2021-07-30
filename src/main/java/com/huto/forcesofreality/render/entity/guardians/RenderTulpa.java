package com.huto.forcesofreality.render.entity.guardians;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.entity.guardian.EntityTulpa;
import com.huto.forcesofreality.model.entity.guardian.ModelTulpa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTulpa extends MobRenderer<EntityTulpa, ModelTulpa> {

	public RenderTulpa(EntityRenderDispatcher renderManagerIn) {
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