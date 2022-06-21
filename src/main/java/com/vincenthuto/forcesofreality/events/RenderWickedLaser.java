package com.vincenthuto.forcesofreality.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.RenderTypeInit;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderLevelLastEvent;

public class RenderWickedLaser {

	public static void renderLaser(RenderLevelLastEvent event, Player player, float ticks) {
		if (ForcesOfReality.findMechanGloveInHand(player).getItem() instanceof ItemMechanGlove) {
			int range = ((ItemMechanGlove) ForcesOfReality.findMechanGloveInHand(player).getItem()).getRange();
			Vec3 playerPos = player.getEyePosition(ticks).add(0, -0.15f, 0);
			HitResult trace = player.pick(range, ticks, false);
			drawLasers(event, playerPos, trace, 0, 0, 0, 255 / 255f, 180 / 255f, 0, 0.02f, player, ticks, -0.02f);
		} else {
			int range = 5;
			Vec3 playerPos = player.getEyePosition(ticks).add(0, -0.15f, 0);
			HitResult trace = player.pick(range, ticks, false);
			drawLasers(event, playerPos, trace, 0, 0, 0, 255 / 255f, 180 / 255f, 0, 0.02f, player, ticks, -0.02f);
		}
	}

	private static void drawLasers(RenderLevelLastEvent event, Vec3 from, HitResult trace, double xOffset,
			double yOffset, double zOffset, float r, float g, float b, float thickness, Player player, float ticks,
			float speedModifier) {
		InteractionHand activeHand;
		if (player.getMainHandItem().getItem() instanceof ItemMechanGlove) {
			activeHand = InteractionHand.MAIN_HAND;
			player.getItemInHand(activeHand);
			@SuppressWarnings("static-access")
			ItemStack stack = ItemStack
					.of((CompoundTag) player.getItemInHand(activeHand).getTag().get("selectedstack"));
			if (stack.getItem() == ItemInit.wicked_module_laser.get() && player.isUsingItem()) {
				VertexConsumer builder;
				double distance = Math.max(1, from.subtract(trace.getLocation()).length());
				long gameTime = player.level.getGameTime();
				double v = gameTime * speedModifier;
				float additiveThickness = (thickness * 3.5f) * calculateLaserFlickerModifier(gameTime);

				float beam2r = 83 / 255f;
				float beam2g = 0 / 255f;
				float beam2b = 101 / 255f;

				Vec3 view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
				MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();

				PoseStack matrix = event.getPoseStack();

				matrix.pushPose();

				matrix.translate(-view.x(), -view.y(), -view.z());
				matrix.translate(from.x, from.y, from.z);
				matrix.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(ticks, -player.getYRot(), -player.yRotO)));
				matrix.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(ticks, player.getXRot(), player.xRotO)));

				PoseStack.Pose matrixstack$entry = matrix.last();
				Matrix3f matrixNormal = matrixstack$entry.normal();
				Matrix4f positionMatrix = matrixstack$entry.pose();

				// additive laser beam
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_ADDITIVE);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, additiveThickness,
						activeHand, distance, 0.5, 1, ticks, 1, 1, 1, 0.7f);
				// main laser, colored part
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_BEAM);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness, activeHand,
						distance, v, v + distance * 1.5, ticks, 255, 255, 255, 1f);

				// core
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_CORE);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness / 2, activeHand,
						distance, v, v + distance * 1.5, ticks, beam2r, beam2g, beam2b, 1f);
				matrix.popPose();
				buffer.endBatch();
			}
		}
		if (player.getOffhandItem().getItem() instanceof ItemMechanGlove) {
			activeHand = InteractionHand.OFF_HAND;
			player.getItemInHand(activeHand);
			@SuppressWarnings("static-access")
			ItemStack stack = ItemStack
					.of((CompoundTag) player.getItemInHand(activeHand).getTag().get("selectedstack"));
			if (stack.getItem() == ItemInit.wicked_module_laser.get() && player.isUsingItem()) {
				VertexConsumer builder;
				double distance = Math.max(1, from.subtract(trace.getLocation()).length());
				long gameTime = player.level.getGameTime();
				double v = gameTime * speedModifier;
				float additiveThickness = (thickness * 3.5f) * calculateLaserFlickerModifier(gameTime);

				float beam2r = 83 / 255f;
				float beam2g = 0 / 255f;
				float beam2b = 101 / 255f;

				Vec3 view = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
				MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();

				PoseStack matrix = event.getPoseStack();

				matrix.pushPose();

				matrix.translate(-view.x(), -view.y(), -view.z());
				matrix.translate(from.x, from.y, from.z);
				matrix.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(ticks, -player.getYRot(), -player.yRotO)));
				matrix.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(ticks, player.getXRot(), player.xRotO)));

				PoseStack.Pose matrixstack$entry = matrix.last();
				Matrix3f matrixNormal = matrixstack$entry.normal();
				Matrix4f positionMatrix = matrixstack$entry.pose();

				// additive laser beam
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_ADDITIVE);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, additiveThickness,
						activeHand, distance, 0.5, 1, ticks, 255, 255, 255, 0.7f);

				// main laser, colored part
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_BEAM);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness, activeHand,
						distance, v, v + distance * 1.5, ticks, 255, 255, 255, 1f);

				// core
				builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_CORE);
				drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness / 2, activeHand,
						distance, v, v + distance * 1.5, ticks, beam2r, beam2g, beam2b, 1f);
				matrix.popPose();
				buffer.endBatch();
			}
		} else {
			return;
		}

	}

	private static float calculateLaserFlickerModifier(long gameTime) {
		return 0.9f + 0.1f * Mth.sin(gameTime * 0.99f) * Mth.sin(gameTime * 0.3f) * Mth.sin(gameTime * 0.1f);
	}

	private static void drawBeam(double xOffset, double yOffset, double zOffset, VertexConsumer builder,
			Matrix4f positionMatrix, Matrix3f matrixNormalIn, float thickness, InteractionHand hand, double distance,
			double v1, double v2, float ticks, float r, float g, float b, float alpha) {
		Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
		vector3f.transform(matrixNormalIn);
		LocalPlayer player = Minecraft.getInstance().player;
		// Support for hand sides remembering to take into account of Skin options
		if (Minecraft.getInstance().options.mainHand().get() != HumanoidArm.RIGHT)
			hand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
		float startXOffset = -0.25f;
		float startYOffset = -.115f;
		float startZOffset = 0.65f + (1 - player.getFieldOfViewModifier());
		if (hand == InteractionHand.OFF_HAND) {
			startYOffset = -.120f;
			startXOffset = 0.25f;
		}
		float f = (Mth.lerp(ticks, player.xRotO, player.getXRot()) - Mth.lerp(ticks, player.xBobO, player.xBob));
		float f1 = (Mth.lerp(ticks, player.yRotO, player.getYRot()) - Mth.lerp(ticks, player.yBobO, player.yBob));
		startXOffset = startXOffset + (f1 / 750);
		startYOffset = startYOffset + (f / 750);

		Vector4f vec1 = new Vector4f(startXOffset, -thickness + startYOffset, startZOffset, 1.0F);
		vec1.transform(positionMatrix);
		Vector4f vec2 = new Vector4f((float) xOffset, -thickness + (float) yOffset, (float) distance + (float) zOffset,
				1.0F);
		vec2.transform(positionMatrix);
		Vector4f vec3 = new Vector4f((float) xOffset, thickness + (float) yOffset, (float) distance + (float) zOffset,
				1.0F);
		vec3.transform(positionMatrix);
		Vector4f vec4 = new Vector4f(startXOffset, thickness + startYOffset, startZOffset, 1.0F);
		vec4.transform(positionMatrix);

		if (hand == InteractionHand.MAIN_HAND) {
			builder.vertex(vec4.x(), vec4.y(), vec4.z(), r, g, b, alpha, 0, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec3.x(), vec3.y(), vec3.z(), r, g, b, alpha, 0, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec2.x(), vec2.y(), vec2.z(), r, g, b, alpha, 1, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec1.x(), vec1.y(), vec1.z(), r, g, b, alpha, 1, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			// Rendering a 2nd time to allow you to see both sides in multiplayer, shouldn't
			// be necessary with culling disabled but here we are....
			builder.vertex(vec1.x(), vec1.y(), vec1.z(), r, g, b, alpha, 1, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec2.x(), vec2.y(), vec2.z(), r, g, b, alpha, 1, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec3.x(), vec3.y(), vec3.z(), r, g, b, alpha, 0, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec4.x(), vec4.y(), vec4.z(), r, g, b, alpha, 0, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
		} else {
			builder.vertex(vec1.x(), vec1.y(), vec1.z(), r, g, b, alpha, 1, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec2.x(), vec2.y(), vec2.z(), r, g, b, alpha, 1, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec3.x(), vec3.y(), vec3.z(), r, g, b, alpha, 0, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec4.x(), vec4.y(), vec4.z(), r, g, b, alpha, 0, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			// Rendering a 2nd time to allow you to see both sides in multiplayer, shouldn't
			// be necessary with culling disabled but here we are....
			builder.vertex(vec4.x(), vec4.y(), vec4.z(), r, g, b, alpha, 0, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec3.x(), vec3.y(), vec3.z(), r, g, b, alpha, 0, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec2.x(), vec2.y(), vec2.z(), r, g, b, alpha, 1, (float) v2, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
			builder.vertex(vec1.x(), vec1.y(), vec1.z(), r, g, b, alpha, 1, (float) v1, OverlayTexture.NO_OVERLAY,
					15728880, vector3f.x(), vector3f.y(), vector3f.z());
		}
	}

}