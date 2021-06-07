package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.lord.EntityTetra;
import com.huto.forcesofreality.model.entity.lord.ModelTetra;
import com.huto.forcesofreality.render.entity.layer.LayerTetraGlow;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTetra extends MobRenderer<EntityTetra, ModelTetra> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tetra/model_tetra.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/tetra/model_tetra.png");

	public RenderTetra(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelTetra(), 0.5f);
		addLayer(new LayerTetraGlow(this));
	}

	@Override
	public void render(EntityTetra entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	protected float handleRotationFloat(EntityTetra livingBase, float partialTicks) {
		return 1f;
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTetra entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}