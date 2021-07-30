package com.huto.forcesofreality.render.entity.guardians;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.guardian.EntityHastur;
import com.huto.forcesofreality.model.entity.guardian.ModelHastur;
import com.huto.forcesofreality.render.entity.layer.LayerHasturAura;
import com.huto.forcesofreality.render.entity.layer.LayerHasturDeath;
import com.huto.forcesofreality.render.entity.layer.LayerHasturPortal;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
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

	public RenderHastur(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelHastur(), 0.5f);
		this.addLayer(new LayerHasturAura(this));
		this.addLayer(new LayerHasturDeath(this));
		this.addLayer(new LayerHasturPortal(this));

	}

	@Override
	public void render(EntityHastur entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
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