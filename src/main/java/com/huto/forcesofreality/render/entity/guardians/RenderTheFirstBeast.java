package com.huto.forcesofreality.render.entity.guardians;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.guardian.EntityTheFirstBeast;
import com.huto.forcesofreality.model.entity.guardian.ModelTheFirstBeast;
import com.huto.forcesofreality.render.entity.layer.BeastHeldItemLayer;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTheFirstBeast extends MobRenderer<EntityTheFirstBeast, ModelTheFirstBeast> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/the_first_beast/model_the_first_beast.png");

	public RenderTheFirstBeast(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelTheFirstBeast(), 1.5f);
		this.addLayer(new BeastHeldItemLayer<EntityTheFirstBeast, ModelTheFirstBeast>(this));

	}

	@Override
	public void render(EntityTheFirstBeast entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTheFirstBeast entity) {
		return TEXTURE;
	}
}