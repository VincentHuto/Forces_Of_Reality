package com.huto.forcesofreality.render.entity.summons;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntityHasturClone;
import com.huto.forcesofreality.model.entity.summon.ModelHasturClone;
import com.huto.forcesofreality.render.entity.layer.LayerHasturClone;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHasturClone extends MobRenderer<EntityHasturClone, ModelHasturClone> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_dead.png");

	public RenderHasturClone(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelHasturClone(), 0.5f);
		this.addLayer(new LayerHasturClone(this));
	}

	@Override
	public void render(EntityHasturClone entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHasturClone entity) {
		return TEXTURE;

	}
}