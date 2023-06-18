package com.vincenthuto.forcesofreality.client.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.guardian.ModelHastur;
import com.vincenthuto.forcesofreality.client.render.entity.guardians.BossColorMap;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityHastur;
import com.vincenthuto.hutoslib.math.Quaternion;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class LayerHasturPortal extends RenderLayer<EntityHastur, ModelHastur> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/temp_gray.png");

	public static double angleOf(Vec3 p1, Vec3 p2) {
		final double deltaY = p2.z - p1.z;
		final double deltaX = p2.x - p1.x;
		final double result = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return result < 0 ? 360d + result : result;
	}

	public LayerHasturPortal(RenderLayerParent<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityHastur entity) {
		return TEXTURE;
	}

	@Override
	public void render(PoseStack matrix, MultiBufferSource buf, int packedLight, EntityHastur entity, float limbSwing,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.deathTicks > 0) {
			matrix.pushPose();
			Player player = Minecraft.getInstance().player;
			Vec3 playerV = player.getEyePosition(partialTicks);
			Vec3 portal = entity.position();
			float scale = 0.35F;
			double yOffset = -1.5;
			matrix.translate(0, yOffset, 0);
			matrix.mulPose(new Quaternion(new Vector3(0, 1, 0), 90, true).toMoj());
			matrix.mulPose(new Quaternion(new Vector3(0, 1, 0), 180F - (float) angleOf(portal, playerV), true).toMoj());

			float progress = ((entity.tickCount + partialTicks) % 90) / 90F;
			scale += (float) Math.cos(2 * Math.PI * progress) / 6F;

			if (entity.getClientTicks() == -1) {
				entity.setClientTicks(entity.tickCount);
			}

			if (entity.getClientTicks() != -1)

			{
				progress = (entity.tickCount - entity.getClientTicks() + partialTicks) / 40;
				if (progress >= 1.3F)
					entity.setClientTicks(-1);
				else {
					if (progress <= 0.45F) {
						float sin = (float) -Math.sin(Math.PI * progress / 0.45F) / 5F;
						scale *= (1 + sin);
					} else {
						float sin = (float) Math.sin(Math.PI * (progress - 0.35F) * (progress - 0.35F));
						float sinSq = sin * sin;
						scale *= (1 + sinSq);
					}
				}
			}

			matrix.scale(scale, scale, 1);

			// this.renderManager.textureManager.bindTexture(this.getEntityTexture(entity));
			VertexConsumer builder = buf.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));
			int color = BossColorMap.getColor(entity.getBossInfo());
			int r = color >> 16 & 255, g = color >> 8 & 255, b = color & 255;
			builder.vertex(matrix.last().pose(), -1, -1, 0).color(r, g, b, 255).uv(1, 1)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), -1, 1, 0).color(r, g, b, 255).uv(1, 0)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), 1, 1, 0).color(r, g, b, 255).uv(0, 0)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), 1, -1, 0).color(r, g, b, 255).uv(0, 1)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
					.endVertex();

			matrix.popPose();
		}
	}

}