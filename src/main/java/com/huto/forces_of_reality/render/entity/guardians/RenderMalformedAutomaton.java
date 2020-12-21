package com.huto.forces_of_reality.render.entity.guardians;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.guardians.EntityMalformedAutomaton;
import com.huto.forces_of_reality.models.entity.guardians.ModelMalformedAutomaton;
import com.huto.forces_of_reality.render.entity.layer.LayerAutomatonWindow;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderMalformedAutomaton extends MobRenderer<EntityMalformedAutomaton, ModelMalformedAutomaton> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");

	public RenderMalformedAutomaton(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelMalformedAutomaton(), 1.5f);
		this.addLayer(new LayerAutomatonWindow(this));
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

	@Override
	protected void applyRotations(EntityMalformedAutomaton entityLiving, MatrixStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		if (!((double) entityLiving.limbSwingAmount < 0.01D)) {
			float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(3.5F * f2));
		}
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