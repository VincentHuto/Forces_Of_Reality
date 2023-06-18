package com.vincenthuto.forcesofreality.client.render.entity.lords;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.lord.ModelXanthousKing;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityXanthousKing;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderXanthousKing extends MobRenderer<EntityXanthousKing, ModelXanthousKing> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/xanthous_king/model_xanthous_king.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/xanthous_king/model_xanthous_king.png");

	public RenderXanthousKing(Context renderManagerIn) {
		super(renderManagerIn, new ModelXanthousKing(renderManagerIn.bakeLayer(ModelXanthousKing.LAYER_LOCATION)), 4.5f);
		// this.addLayer(new LayerXanthousKingAura(this));
		// this.addLayer(new LayerXanthousKingDeath(this));
		// this.addLayer(new LayerXanthousKingPortal(this));

	}

	@Override
	public ResourceLocation getTextureLocation(EntityXanthousKing entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@Override
	public void render(EntityXanthousKing entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}
}