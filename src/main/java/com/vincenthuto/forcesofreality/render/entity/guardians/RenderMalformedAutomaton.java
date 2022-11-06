package com.vincenthuto.forcesofreality.render.entity.guardians;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityMalformedAutomaton;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelMalformedAutomaton;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerAutomatonWindow;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderMalformedAutomaton extends MobRenderer<EntityMalformedAutomaton, ModelMalformedAutomaton> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/malformed_automaton/model_malformed_automaton.png");

	public RenderMalformedAutomaton(Context renderManagerIn) {
		super(renderManagerIn, new ModelMalformedAutomaton(renderManagerIn.bakeLayer(ModelMalformedAutomaton.LAYER_LOCATION)),1.5f);
		this.addLayer(new LayerAutomatonWindow(this));
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMalformedAutomaton entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(EntityMalformedAutomaton entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();

		GlStateManager._enableBlend();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager._disableBlend();

		matrixStackIn.popPose();

	}

	// Growth Scaling
	@Override
	protected void scale(EntityMalformedAutomaton entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}

	@Override
	protected void setupRotations(EntityMalformedAutomaton entityLiving, PoseStack matrixStackIn, float ageInTicks,
			float rotationYaw, float partialTicks) {
		super.setupRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		if (!(entityLiving.animationSpeed < 0.01D)) {
			float f1 = entityLiving.animationPosition - entityLiving.animationSpeed * (1.0F - partialTicks) + 6.0F;
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(3.5F * f2));
		}
	}
}