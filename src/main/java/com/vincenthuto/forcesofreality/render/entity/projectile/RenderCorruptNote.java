package com.vincenthuto.forcesofreality.render.entity.projectile;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.projectile.EntityCorruptNote;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderCorruptNote extends EntityRenderer<EntityCorruptNote> {

	public RenderCorruptNote(Context renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityCorruptNote entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

}