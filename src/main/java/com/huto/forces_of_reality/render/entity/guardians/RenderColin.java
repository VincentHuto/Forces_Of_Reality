package com.huto.forces_of_reality.render.entity.guardians;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.guardians.EntityColin;
import com.huto.forces_of_reality.models.entity.guardians.ModelColin;
import com.huto.forces_of_reality.render.entity.layer.LayerColinAura;
import com.huto.forces_of_reality.render.entity.layer.LayerColinDeath;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderColin extends MobRenderer<EntityColin, ModelColin> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/colin/modelcolin.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/colin/modelcolin_dead.png");

	public RenderColin(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelColin(), 0.5f);
		this.addLayer(new LayerColinAura(this));
		this.addLayer(new LayerColinDeath(this));

	}

	@Override
	public void render(EntityColin entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	@Override
	public ResourceLocation getEntityTexture(EntityColin entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}