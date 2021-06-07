package com.huto.forcesofreality.render.entity.passive;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.passive.EntityDenizenSage;
import com.huto.forcesofreality.model.entity.passive.ModelDenizenSage;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDenizenSage extends MobRenderer<EntityDenizenSage, ModelDenizenSage> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/denizen_sage/model_denizen.png");

	public RenderDenizenSage(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDenizenSage(), 0.5f);
		this.addLayer(new HeldItemLayer<EntityDenizenSage, ModelDenizenSage>(this));

	}

	@Override
	public void render(EntityDenizenSage entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDenizenSage entity) {
		return entity.getDenizenTypeName();
	}
}