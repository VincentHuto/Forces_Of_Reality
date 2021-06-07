package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityXanthousKing;
import com.huto.forcesofreality.model.entity.lord.ModelXanthousKing;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderXanthousKing extends MobRenderer<EntityXanthousKing, ModelXanthousKing> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/xanthous_king/model_xanthous_king.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/xanthous_king/model_xanthous_king.png");

	public RenderXanthousKing(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelXanthousKing(), 4.5f);
		//this.addLayer(new LayerXanthousKingAura(this));
	//	this.addLayer(new LayerXanthousKingDeath(this));
	//	this.addLayer(new LayerXanthousKingPortal(this));

	}

	@Override
	public void render(EntityXanthousKing entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityXanthousKing entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}