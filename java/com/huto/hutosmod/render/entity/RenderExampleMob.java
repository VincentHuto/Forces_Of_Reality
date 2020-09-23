package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.ExampleEntity;
import com.huto.hutosmod.models.ExampleEntityModel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderExampleMob extends MobRenderer<ExampleEntity, ExampleEntityModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/example_entity.png");

	public RenderExampleMob(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ExampleEntityModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(ExampleEntity entity) {
		return TEXTURE;
	}
}