package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityMalformedAutomaton;
import com.huto.hutosmod.models.entity.ModelMalformedAutomaton;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderMalformedAutomaton extends MobRenderer<EntityMalformedAutomaton, ModelMalformedAutomaton> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");

	public RenderMalformedAutomaton(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelMalformedAutomaton(), 1.5f);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(EntityMalformedAutomaton entityIn, float entityYaw, float partialTicks,
			MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		GlStateManager.pushMatrix();
		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.5F);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.disableAlphaTest();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		matrixStackIn.pop();

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityMalformedAutomaton entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityMalformedAutomaton entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}