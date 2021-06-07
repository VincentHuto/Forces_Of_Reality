package com.huto.forcesofreality.render.entity.mobs;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.mob.EntityDerangedBeast;
import com.huto.forcesofreality.model.entity.mob.ModelDerangedBeast;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDerangedBeast extends MobRenderer<EntityDerangedBeast, ModelDerangedBeast> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/deranged_beast/model_deranged_beast_grey.png");

	public RenderDerangedBeast(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDerangedBeast(), 0.5f);

	}

	@Override
	public void render(EntityDerangedBeast entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}


	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityDerangedBeast entity) {
		return entity.getBeastTypeName();
	}

}