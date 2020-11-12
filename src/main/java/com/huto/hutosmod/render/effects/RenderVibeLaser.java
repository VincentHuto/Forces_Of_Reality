package com.huto.hutosmod.render.effects;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.RenderTypeInit;
import com.huto.hutosmod.objects.items.tools.ItemFrequencyMatcher;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector4f;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class RenderVibeLaser {

	@SuppressWarnings("unused")
	private final static ResourceLocation laserBeam = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser.png");
	@SuppressWarnings("unused")
	private final static ResourceLocation laserBeam2 = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser2.png");
	@SuppressWarnings("unused")
	private final static ResourceLocation laserBeamGlow = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser_glow.png");

	public static void renderLaser(RenderWorldLastEvent event, PlayerEntity player, float ticks) {

		int range = 10;

		Vector3d playerPos = player.getEyePosition(ticks);
		RayTraceResult trace = player.pick(range, 0.0F, false);

		// parse data from item
		float speedModifier = 0.5f;
		drawLasers(event, playerPos, trace, 0, 0, 0, 1 + player.world.rand.nextInt(100) / 255f,
				1 + player.world.rand.nextInt(100) / 255f, 1 + player.world.rand.nextInt(100) / 255f, 0.02f, player,
				ticks, speedModifier);
	}

	@SuppressWarnings("unused")
	private static float getSpeedModifier(ItemStack stack) {
		return -0.02f;
	}

	@SuppressWarnings("unused")
	private static void drawLasers(RenderWorldLastEvent event, Vector3d from, RayTraceResult trace, double xOffset,
			double yOffset, double zOffset, float r, float g, float b, float thickness, PlayerEntity player,
			float ticks, float speedModifier) {
		Hand activeHand;
		if (player.getHeldItemMainhand().getItem() instanceof ItemFrequencyMatcher) {
			activeHand = Hand.MAIN_HAND;
		} else if (player.getHeldItemOffhand().getItem() instanceof ItemFrequencyMatcher) {
			activeHand = Hand.OFF_HAND;
		} else {
			return;
		}

		IVertexBuilder builder;
		ItemStack stack = player.getHeldItem(activeHand);
		double distance = Math.max(1, from.subtract(trace.getHitVec()).length());
		long gameTime = player.world.getGameTime();
		double v = gameTime * speedModifier;
		// How wide the blur is on the beam
		float additiveThickness = (thickness * 4.5f) * calculateLaserFlickerModifier(gameTime);

		// Core Color
		float beam2r = 255 / 255f;
		float beam2g = 255 / 255f;
		float beam2b = 255 / 255f;

		Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
		IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

		MatrixStack matrix = event.getMatrixStack();

		matrix.push();

		matrix.translate(-view.getX(), -view.getY(), -view.getZ());
		matrix.translate(from.x, from.y, from.z);
		matrix.rotate(
				Vector3f.YP.rotationDegrees(MathHelper.lerp(ticks, -player.rotationYaw, -player.prevRotationYaw)));
		matrix.rotate(
				Vector3f.XP.rotationDegrees(MathHelper.lerp(ticks, player.rotationPitch, player.prevRotationPitch)));

		MatrixStack.Entry matrixstack$entry = matrix.getLast();
		Matrix3f matrixNormal = matrixstack$entry.getNormal();
		Matrix4f positionMatrix = matrixstack$entry.getMatrix();

		// additive laser beam
		builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_ADDITIVE);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, additiveThickness, activeHand,
				distance, 0.5, 1, ticks, r, g, b, 0.7f);

		// main laser, colored part
		builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_BEAM);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness, activeHand, distance, v,
				v + distance * 1.5, ticks, r, g, b, 1f);

		// core
		builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_CORE);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness / 2, activeHand, distance,
				v, v + distance * 1.5, ticks, beam2r, beam2g, beam2b, 1f);
		matrix.pop();
//        RenderSystem.disableDepthTest();
		buffer.finish();
	}

	private static float calculateLaserFlickerModifier(long gameTime) {
		return 0.9f + 0.1f * MathHelper.sin(gameTime * 0.99f) * MathHelper.sin(gameTime * 0.3f)
				* MathHelper.sin(gameTime * 0.1f);
	}

	private static void drawBeam(double xOffset, double yOffset, double zOffset, IVertexBuilder builder,
			Matrix4f positionMatrix, Matrix3f matrixNormalIn, float thickness, Hand hand, double distance, double v1,
			double v2, float ticks, float r, float g, float b, float alpha) {
		Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
		vector3f.transform(matrixNormalIn);
		ClientPlayerEntity player = Minecraft.getInstance().player;
		// Support for hand sides remembering to take into account of Skin options
		if (Minecraft.getInstance().gameSettings.mainHand != HandSide.RIGHT)
			hand = hand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
		float startXOffset = -0.25f;
		float startYOffset = -.115f;
		float startZOffset = 0.65f + (1 - player.getFovModifier());
		if (hand == Hand.OFF_HAND) {
			startYOffset = -.120f;
			startXOffset = 0.25f;
		}
		float f = (MathHelper.lerp(ticks, player.prevRotationPitch, player.rotationPitch)
				- MathHelper.lerp(ticks, player.prevRenderArmPitch, player.renderArmPitch));
		float f1 = (MathHelper.lerp(ticks, player.prevRotationYaw, player.rotationYaw)
				- MathHelper.lerp(ticks, player.prevRenderArmYaw, player.renderArmYaw));
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

		if (hand == Hand.MAIN_HAND) {
			builder.addVertex(vec4.getX(), vec4.getY(), vec4.getZ(), r, g, b, alpha, 0, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec3.getX(), vec3.getY(), vec3.getZ(), r, g, b, alpha, 0, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec2.getX(), vec2.getY(), vec2.getZ(), r, g, b, alpha, 1, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec1.getX(), vec1.getY(), vec1.getZ(), r, g, b, alpha, 1, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			// Rendering a 2nd time to allow you to see both sides in multiplayer, shouldn't
			// be necessary with culling disabled but here we are....
			builder.addVertex(vec1.getX(), vec1.getY(), vec1.getZ(), r, g, b, alpha, 1, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec2.getX(), vec2.getY(), vec2.getZ(), r, g, b, alpha, 1, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec3.getX(), vec3.getY(), vec3.getZ(), r, g, b, alpha, 0, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec4.getX(), vec4.getY(), vec4.getZ(), r, g, b, alpha, 0, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
		} else {
			builder.addVertex(vec1.getX(), vec1.getY(), vec1.getZ(), r, g, b, alpha, 1, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec2.getX(), vec2.getY(), vec2.getZ(), r, g, b, alpha, 1, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec3.getX(), vec3.getY(), vec3.getZ(), r, g, b, alpha, 0, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec4.getX(), vec4.getY(), vec4.getZ(), r, g, b, alpha, 0, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			// Rendering a 2nd time to allow you to see both sides in multiplayer, shouldn't
			// be necessary with culling disabled but here we are....
			builder.addVertex(vec4.getX(), vec4.getY(), vec4.getZ(), r, g, b, alpha, 0, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec3.getX(), vec3.getY(), vec3.getZ(), r, g, b, alpha, 0, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec2.getX(), vec2.getY(), vec2.getZ(), r, g, b, alpha, 1, (float) v2,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
			builder.addVertex(vec1.getX(), vec1.getY(), vec1.getZ(), r, g, b, alpha, 1, (float) v1,
					OverlayTexture.NO_OVERLAY, 15728880, vector3f.getX(), vector3f.getY(), vector3f.getZ());
		}
	}

}