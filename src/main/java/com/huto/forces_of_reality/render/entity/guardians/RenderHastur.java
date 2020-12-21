package com.huto.forces_of_reality.render.entity.guardians;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.guardians.EntityHastur;
import com.huto.forces_of_reality.models.entity.guardians.ModelHastur;
import com.huto.forces_of_reality.render.entity.layer.LayerHasturAura;
import com.huto.forces_of_reality.render.entity.layer.LayerHasturDeath;
import com.huto.forces_of_reality.render.entity.layer.LayerHasturPortal;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHastur extends MobRenderer<EntityHastur, ModelHastur> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_dead.png");

	public RenderHastur(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelHastur(), 0.5f);
		this.addLayer(new LayerHasturAura(this));
		this.addLayer(new LayerHasturDeath(this));
		this.addLayer(new LayerHasturPortal(this));

	}

	@Override
	public void render(EntityHastur entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityHastur entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}