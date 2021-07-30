package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.passive.EntityDenizenSage;
import com.huto.forcesofreality.model.entity.passive.ModelDenizenSage;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizenSage extends MobRenderer<EntityDenizenSage, ModelDenizenSage> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen_sage/model_denizen.png");

	public RenderDenizenSage(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelDenizenSage(), 0.5f);
		this.addLayer(new ItemInHandLayer<EntityDenizenSage, ModelDenizenSage>(this));

	}

	@Override
	public void render(EntityDenizenSage entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDenizenSage entity) {
		return entity.getDenizenTypeName();
	}
}