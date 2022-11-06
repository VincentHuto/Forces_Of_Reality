package com.vincenthuto.forcesofreality.render.entity.guardians;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityTheFirstBeast;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelTheFirstBeast;
import com.vincenthuto.forcesofreality.render.entity.layer.BeastHeldItemLayer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTheFirstBeast extends MobRenderer<EntityTheFirstBeast, ModelTheFirstBeast> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/the_first_beast/model_the_first_beast.png");

	public RenderTheFirstBeast(Context renderManagerIn) {
		super(renderManagerIn, new ModelTheFirstBeast(renderManagerIn.bakeLayer(ModelTheFirstBeast.LAYER_LOCATION)),
				1.5f);
		this.addLayer(new BeastHeldItemLayer<>(this));

	}

	@Override
	public ResourceLocation getTextureLocation(EntityTheFirstBeast entity) {
		return TEXTURE;
	}

	@Override
	public void render(EntityTheFirstBeast entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}