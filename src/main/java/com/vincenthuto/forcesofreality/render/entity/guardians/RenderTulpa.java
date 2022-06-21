package com.vincenthuto.forcesofreality.render.entity.guardians;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.entity.guardian.EntityTulpa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTulpa extends MobRenderer<EntityTulpa, PlayerModel<EntityTulpa>> {

	public RenderTulpa(Context renderManagerIn) {
		super(renderManagerIn, new PlayerModel<>(renderManagerIn.bakeLayer(ModelLayers.PLAYER), false), 1.5f);
		// this.addLayer(new LayerDreamWalkerMask(this));

	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityTulpa entity) {
		Minecraft mc = Minecraft.getInstance();
		if (!(mc.getCameraEntity() instanceof AbstractClientPlayer))
			return DefaultPlayerSkin.getDefaultSkin();
		return ((AbstractClientPlayer) mc.getCameraEntity()).getSkinTextureLocation();
	}

}