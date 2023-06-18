package com.vincenthuto.forcesofreality.client.render.entity.projectile;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.summon.ModelDreadRocketTracking;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityDreadRocketDirected;
import com.vincenthuto.hutoslib.math.Quaternion;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDreadRocketDirected extends EntityRenderer<EntityDreadRocketDirected> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dread_rocket/model_dread_rocket.png");
	private final ModelDreadRocketTracking leashKnotModel;

	public RenderDreadRocketDirected(Context renderManagerIn) {
		super(renderManagerIn);
		leashKnotModel = new ModelDreadRocketTracking(renderManagerIn.bakeLayer(ModelDreadRocketTracking.LAYER_LOCATION));

	}
	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityDreadRocketDirected entity) {
		return TEXTURE;
	}

	@Override
	public void render(EntityDreadRocketDirected entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		matrixStackIn.translate(0, -1, 0);
		matrixStackIn.mulPose(new Quaternion(Vector3.YP, (float) entityIn.getDeltaMovement().z * 5, false).toMoj());
		matrixStackIn.mulPose(new Quaternion(Vector3.YP, (float) entityIn.getDeltaMovement().x * 5, false).toMoj());

		this.leashKnotModel.setupAnim(entityIn, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(this.leashKnotModel.renderType(TEXTURE));
		this.leashKnotModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY,
				1.0F, 1.0F, 1.0F, 1.0F);

		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

}