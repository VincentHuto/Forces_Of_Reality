package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityHastur;
import com.huto.hutosmod.models.ModelHastur;
import com.huto.hutosmod.render.entity.layer.LayerHasturAura;
import com.huto.hutosmod.render.entity.layer.LayerHasturDeath;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHastur extends MobRenderer<EntityHastur, ModelHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/hastur/modelhastur.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/hastur/modelhastur_dead.png");

	public RenderHastur(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelHastur(), 0.5f);
		this.addLayer(new LayerHasturAura(this));
		this.addLayer(new LayerHasturDeath(this));
	}

	@Override
	public void render(EntityHastur entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHastur entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}