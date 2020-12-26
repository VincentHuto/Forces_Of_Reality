package com.huto.forcesofreality.render.entity.passive;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.entities.passive.EntityDreamWalker;
import com.huto.forcesofreality.models.entity.passive.ModelDreamWalker;
import com.huto.forcesofreality.render.entity.layer.LayerDreamWalkerMask;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDreamWalker extends MobRenderer<EntityDreamWalker, ModelDreamWalker> {

	public RenderDreamWalker(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDreamWalker(), 0.5f);
		this.addLayer(new LayerDreamWalkerMask(this));

	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityDreamWalker entity) {
		Minecraft mc = Minecraft.getInstance();
		if (!(mc.getRenderViewEntity() instanceof AbstractClientPlayerEntity))
			return DefaultPlayerSkin.getDefaultSkinLegacy();
		return ((AbstractClientPlayerEntity) mc.getRenderViewEntity()).getLocationSkin();
	}

}