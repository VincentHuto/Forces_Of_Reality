package com.vincenthuto.forcesofreality.client.render.entity.passive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.passive.ModelDenizenSage;
import com.vincenthuto.forcesofreality.common.entity.passive.EntityDenizenSage;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizenSage extends MobRenderer<EntityDenizenSage, ModelDenizenSage> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen_sage/model_denizen.png");

	public RenderDenizenSage(Context renderManagerIn) {
		super(renderManagerIn, new ModelDenizenSage(renderManagerIn.bakeLayer(ModelDenizenSage.LAYER_LOCATION)), 0.5f);
		this.addLayer(new ItemInHandLayer<>(this, null));

	}

	@Override
	public ResourceLocation getTextureLocation(EntityDenizenSage entity) {
		return entity.getDenizenTypeName();
	}

	@Override
	public void render(EntityDenizenSage entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}