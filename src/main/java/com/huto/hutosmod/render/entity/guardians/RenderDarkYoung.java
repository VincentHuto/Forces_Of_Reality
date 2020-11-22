package com.huto.hutosmod.render.entity.guardians;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.guardians.EntityDarkYoung;
import com.huto.hutosmod.models.entity.guardians.ModelDarkYoung;
import com.huto.hutosmod.render.entity.layer.LayerDarkYoungDeath;
import com.huto.hutosmod.render.entity.layer.LayerDarkYoungPendant;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDarkYoung extends MobRenderer<EntityDarkYoung, ModelDarkYoung> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");

	public RenderDarkYoung(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDarkYoung(), 1.5f);
		this.addLayer(new LayerDarkYoungPendant(this));
		this.addLayer(new LayerDarkYoungDeath(this));
	}

	@Override
	public void render(EntityDarkYoung entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityDarkYoung entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			//matrixStackIn.rotate(Vector3f.YP.rotation((float) ((d*0.005)*partialTickTime)));
			matrixStackIn.translate(0,d*0.01, 0);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDarkYoung entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}