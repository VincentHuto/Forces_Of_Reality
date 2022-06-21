package com.vincenthuto.forcesofreality.render.entity.guardians;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelHastur;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerHasturAura;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerHasturDeath;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerHasturPortal;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHastur extends MobRenderer<EntityHastur, ModelHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_dead.png");

	public RenderHastur(Context renderManagerIn) {
		super(renderManagerIn, new ModelHastur(renderManagerIn.bakeLayer(ModelHastur.LAYER_LOCATION)), 0.5f);
		this.addLayer(new LayerHasturAura(this));
		this.addLayer(new LayerHasturDeath(this));
		this.addLayer(new LayerHasturPortal(this));

	}

	@Override
	public void render(EntityHastur entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.pushPose();
		matrixStackIn.popPose();

	}

	@Override
	public ResourceLocation getTextureLocation(EntityHastur entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}