package com.huto.forcesofreality.render.entity.guardians;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.guardians.EntityTheFirstBeast;
import com.huto.forcesofreality.models.entity.guardians.ModelTheFirstBeast;
import com.huto.forcesofreality.render.entity.layer.BeastHeldItemLayer;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTheFirstBeast extends MobRenderer<EntityTheFirstBeast, ModelTheFirstBeast> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/the_first_beast/model_the_first_beast.png");

	public RenderTheFirstBeast(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelTheFirstBeast(), 1.5f);
		this.addLayer(new BeastHeldItemLayer<EntityTheFirstBeast, ModelTheFirstBeast>(this));

	}

	@Override
	public void render(EntityTheFirstBeast entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTheFirstBeast entity) {
		return TEXTURE;
	}
}