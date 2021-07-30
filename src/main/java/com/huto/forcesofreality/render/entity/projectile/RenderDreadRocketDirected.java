package com.huto.forcesofreality.render.entity.projectile;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.projectile.EntityDreadRocketDirected;
import com.huto.forcesofreality.model.entity.summon.ModelDreadRocketTracking;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDreadRocketDirected extends EntityRenderer<EntityDreadRocketDirected> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dread_rocket/model_dread_rocket.png");
	private final ModelDreadRocketTracking leashKnotModel = new ModelDreadRocketTracking();

	public RenderDreadRocketDirected(EntityRenderDispatcher renderManager) {
		super(renderManager);
	}

	@Override
	public void render(EntityDreadRocketDirected entityIn, float entityYaw, float partialTicks,
			PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		matrixStackIn.translate(0, -1, 0);
		matrixStackIn.rotate(new Quaternion(Vector3f.YP, (float) entityIn.getMotion().z*5, false));
		matrixStackIn.rotate(new Quaternion(Vector3f.YP, (float) entityIn.getMotion().x*5, false));

		this.leashKnotModel.setRotationAngles(entityIn, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.leashKnotModel.getRenderType(TEXTURE));
		this.leashKnotModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
				1.0F, 1.0F);

		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityDreadRocketDirected entity) {
		return TEXTURE;
	}

}