package com.huto.hutosmod.render.entity.layer;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityHastur;
import com.huto.hutosmod.models.entity.ModelHastur;
import com.huto.hutosmod.render.entity.BossColorMap;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

public class LayerHasturPortal extends LayerRenderer<EntityHastur, ModelHastur> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/temp_gray.png");

	public LayerHasturPortal(IEntityRenderer<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityHastur entity) {
		return TEXTURE;
	}

	@Override
	public void render(MatrixStack matrix, IRenderTypeBuffer buf, int packedLight, EntityHastur entity, float limbSwing,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.deathTicks > 0) {
			matrix.push();
			PlayerEntity player = Minecraft.getInstance().player;
			Vector3d playerV = player.getEyePosition(partialTicks);
			Vector3d portal = entity.getPositionVec();
			float scale = 0.35F;
			double yOffset = -1.5;
			matrix.translate(0, yOffset, 0);
			matrix.rotate(new Quaternion(new Vector3f(0, 1, 0), 90, true));
			matrix.rotate(new Quaternion(new Vector3f(0, 1, 0), 180F - (float) angleOf(portal, playerV), true));

			float progress = ((entity.ticksExisted + partialTicks) % 90) / 90F;
			scale += (float) Math.cos(2 * Math.PI * progress) / 6F;

			if (entity.getClientTicks() == -1) {
				entity.setClientTicks(entity.ticksExisted);
			}

			if (entity.getClientTicks() != -1)

			{
				progress = (entity.ticksExisted - entity.getClientTicks() + partialTicks) / 40;
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
			IVertexBuilder builder = buf.getBuffer(RenderType.getEntityTranslucent(getEntityTexture(entity)));
			int color = BossColorMap.getColor(entity.getBossInfo());
			int r = color >> 16 & 255, g = color >> 8 & 255, b = color & 255;
			builder.pos(matrix.getLast().getMatrix(), -1, -1, 0).color(r, g, b, 255).tex(1, 1)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), -1, 1, 0).color(r, g, b, 255).tex(1, 0)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), 1, 1, 0).color(r, g, b, 255).tex(0, 0)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), 1, -1, 0).color(r, g, b, 255).tex(0, 1)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();

			matrix.pop();
		}
	}

	public static double angleOf(Vector3d p1, Vector3d p2) {
		final double deltaY = p2.z - p1.z;
		final double deltaX = p2.x - p1.x;
		final double result = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return result < 0 ? 360d + result : result;
	}

}