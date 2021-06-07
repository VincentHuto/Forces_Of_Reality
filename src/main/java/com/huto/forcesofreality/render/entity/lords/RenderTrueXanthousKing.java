package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityTrueXanthousKing;
import com.huto.forcesofreality.model.entity.lord.ModelTrueXanthousKing;
import com.huto.forcesofreality.render.entity.layer.LayerTrueXanthousGlow;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTrueXanthousKing extends MobRenderer<EntityTrueXanthousKing, ModelTrueXanthousKing> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/true_xanthous_king/model_true_xanthous_king.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/true_xanthous_king/model_true_xanthous_king.png");

	public RenderTrueXanthousKing(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelTrueXanthousKing(), 1.5f);
		addLayer(new LayerTrueXanthousGlow(this));
	}

	@Override
	public void render(EntityTrueXanthousKing entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityTrueXanthousKing entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}