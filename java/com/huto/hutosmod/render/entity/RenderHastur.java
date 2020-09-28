package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityHastur;
import com.huto.hutosmod.models.ModelHastur;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHastur extends MobRenderer<EntityHastur, ModelHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/example_entity.png");

	public RenderHastur(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelHastur(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityHastur entity) {
		return TEXTURE;
	}
}