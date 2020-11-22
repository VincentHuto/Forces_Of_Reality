package com.huto.hutosmod.render.entity.guardians;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.guardians.EntityBeastFromBeyond;
import com.huto.hutosmod.models.entity.guardians.ModelBeastFromBeyond;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBeastFromBeyond extends MobRenderer<EntityBeastFromBeyond, ModelBeastFromBeyond> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");

	public RenderBeastFromBeyond(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelBeastFromBeyond(), 1.5f);
		// this.addLayer(new LayerHasturAura(this));
		// this.addLayer(new LayerHasturDeath(this));
	}

	@Override
	public void render(EntityBeastFromBeyond entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityBeastFromBeyond entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBeastFromBeyond entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}