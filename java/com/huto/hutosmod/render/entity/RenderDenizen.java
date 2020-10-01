package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityDenizen;
import com.huto.hutosmod.models.ModelDenizen;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizen extends MobRenderer<EntityDenizen, ModelDenizen> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/model_denizen.png");

	public RenderDenizen(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDenizen(), 0.5f);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(EntityDenizen entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		GlStateManager.pushMatrix();
		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();

		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.1F);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 0.1F);
		GlStateManager.disableAlphaTest();
		GlStateManager.disableBlend();

		GlStateManager.popMatrix();
		matrixStackIn.pop();
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDenizen entity) {
		return entity.getDenizenTypeName();
	}
}