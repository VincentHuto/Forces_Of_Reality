package com.huto.forces_of_reality.render.entity.summons;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.summons.EntityHasturClone;
import com.huto.forces_of_reality.models.entity.summons.ModelHasturClone;
import com.huto.forces_of_reality.render.entity.layer.LayerHasturClone;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHasturClone extends MobRenderer<EntityHasturClone, ModelHasturClone> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_dead.png");

	public RenderHasturClone(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelHasturClone(), 0.5f);
		this.addLayer(new LayerHasturClone(this));
	}

	@Override
	public void render(EntityHasturClone entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHasturClone entity) {
		return TEXTURE;

	}
}