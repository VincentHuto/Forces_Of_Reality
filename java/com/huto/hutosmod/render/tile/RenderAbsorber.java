package com.huto.hutosmod.render.tile;

import java.util.Vector;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.RenderInit;
import com.huto.hutosmod.models.ModelDrumMagatama;
import com.huto.hutosmod.models.ModelFloatingCube;
import com.huto.hutosmod.objects.tileenties.EnumAbsorberStates;
import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.ibm.icu.text.DecimalFormat;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector4f;

public class RenderAbsorber extends TileEntityRenderer<TileEntityAbsorber> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();
	private final ModelFloatingCube cube = new ModelFloatingCube();

	public RenderAbsorber(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityAbsorber te, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn, int combinedOverlayIn) {
		// Add items above block
		int items = 0;
		for (int i = 0; i < te.getSizeInventory(); i++)
			if (te.getItemHandler().getStackInSlot(i).isEmpty())
				break;
			else
				items++;
		float[] angles = new float[te.getSizeInventory()];

		float anglePer = 360F / items;
		float totalAngle = 0F;
		for (int i = 0; i < angles.length; i++)
			angles[i] = totalAngle += anglePer;

		double time = ClientTickHandler.ticksInGame + partialTicks;

		Minecraft.getInstance().textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
		for (int i = 0; i < te.getSizeInventory(); i++) {
			matrixStackIn.push();
			matrixStackIn.translate(0.5F, 1.25F, 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(angles[i] + (float) time));
			// Edit True Radius
			matrixStackIn.translate(0.025F, -0.5F, 0.025F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
			// Edit Radius Movement
			matrixStackIn.translate(0D, 0.175D + i * 0.55, 0F);
			// Block/Item Scale
			matrixStackIn.scale(0.5f, 0.5f, 0.5f);
			ItemStack stack = te.getItemHandler().getStackInSlot(i);
			Minecraft mc = Minecraft.getInstance();
			if (!stack.isEmpty()) {
				mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
						matrixStackIn, bufferIn);
			}
			matrixStackIn.pop();
		}
		matrixStackIn.translate(0.5, 0.9, 0.5);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);

		ResourceLocation textureExport = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_red.png");
		ResourceLocation textureImport = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_blue.png");
		ResourceLocation textureDefault = new ResourceLocation(
				HutosMod.MOD_ID + ":textures/blocks/end_portal_default.png");
		ResourceLocation textureBoth = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_purple.png");
		ResourceLocation textureMode;

		// Switch Textures
		if (te.clientEnumMode == EnumAbsorberStates.DEFAULT) {
			textureMode = textureDefault;
		} else if (te.clientEnumMode == EnumAbsorberStates.IMPORT) {
			textureMode = textureImport;
		} else if (te.clientEnumMode == EnumAbsorberStates.EXPORT) {
			textureMode = textureExport;
		} else if (te.clientEnumMode == EnumAbsorberStates.BOTH) {
			textureMode = textureBoth;
		} else {
			textureMode = textureDefault;
		}

		// Magatamas
		for (int i = 0; i < te.getTankLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.4F;
			final float radiusMod = 0.0F;
			int cubes = te.getTankLevel();
			float offsetPerCube = 360 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 5F) / 10F;
			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotation(yRotate));
			matrixStackIn.rotate(Vector3f.ZP.rotation(135));
			IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas.getRenderType(textureMode));
			magatamas.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();
		}
		// Cube
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3 * 0.14;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.push();
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) ticks));
		matrixStackIn.translate(-0.125, y - 0.75, -0.125);
		matrixStackIn.scale(4, 4, 4);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(cube.getRenderType(textureMode));
		cube.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

		// draw Laser Connection

		float r = 122 + te.getWorld().rand.nextInt(35) / 255f;
		float g = 122 / 255f;
		float b = 122 / 255f;

		// Switch Colors
		if (te.clientEnumMode == EnumAbsorberStates.DEFAULT) {
			r = 122 + te.getWorld().rand.nextInt(35) / 255f;
			g = 122 / 255f;
			b = 122 / 255f;
		} else if (te.clientEnumMode == EnumAbsorberStates.IMPORT) {
			r = 192 + te.getWorld().rand.nextInt(35) / 255f;
			g = 122 / 255f;
			b = 255 / 255f;
		} else if (te.clientEnumMode == EnumAbsorberStates.EXPORT) {
			r = 122 / 255f;
			g = 1 / 255f;
			b = 1 / 255f;
		} else if (te.clientEnumMode == EnumAbsorberStates.BOTH) {
			r = 122 + te.getWorld().rand.nextInt(35) / 255f;
			g = 1 / 255f;
			b = 122 / 255f;
		} else {
			r = 122 + te.getWorld().rand.nextInt(35) / 255f;
			g = 122 / 255f;
			b = 122 / 255f;
		}

		matrixStackIn.push();
		matrixStackIn.translate(0.5, 0, 0.5);

		// matrixStackIn.scale(5f, 5f, 5f);
		Vector3d vecPosOther;
		Vector3d vecPos = new Vector3d(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		if (te.linkedBlocks != null) {
			for (int i = 0; i < te.linkedBlocks.size(); i++) {
				vecPosOther = new Vector3d(te.linkedBlocks.get(i).getX(), te.linkedBlocks.get(i).getY(),
						te.linkedBlocks.get(i).getZ());
				Vector3d test2 = vecPosOther.subtract(vecPos);
				RayTraceResult trace = te.getWorld().rayTraceBlocks(new RayTraceContext(vecPos, test2,
						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, null));
				double distance2 = vecPos.distanceTo(vecPosOther);
				DecimalFormat df = new DecimalFormat("0");
				distance2 = (int) distance2;
				drawLasers(matrixStackIn, vecPos, trace, test2.x * distance2, test2.y * distance2, test2.z * distance2,
						r, g, b, (.08f), (float) ticks, .09f, te);

			}
		}
		matrixStackIn.pop();

	}

	private static void drawLasers(MatrixStack matrixStack, Vector3d from, RayTraceResult trace, double xOffset,
			double yOffset, double zOffset, float r, float g, float b, float thickness, float ticks,
			float speedModifier, TileEntityAbsorber tile) {

		IVertexBuilder builder;
		double distance = Math.max(0, 1 - (from.subtract(trace.getHitVec()).length()));
		long gameTime = tile.getWorld().getGameTime();
		double v = gameTime * speedModifier;
		// How wide the blur is on the beam
		float additiveThickness = (thickness * 9.5f) * calculateLaserFlickerModifier(gameTime);

		// Core Color
		float beam2r = 255 / 255f;
		float beam2g = 255 / 255f;
		float beam2b = 255 / 255f;

		Vector3d view = Minecraft.getInstance().gameRenderer.getActiveRenderInfo().getProjectedView();
		IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();

		matrixStack.push();

		matrixStack.translate(-view.getX(), -view.getY(), -view.getZ());
		matrixStack.translate(from.x, from.y, from.z);

		MatrixStack.Entry matrixstack$entry = matrixStack.getLast();
		Matrix3f matrixNormal = matrixstack$entry.getNormal();
		Matrix4f positionMatrix = matrixstack$entry.getMatrix();

		// additive laser beam
		builder = buffer.getBuffer(RenderInit.LASER_MAIN_ADDITIVE);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, additiveThickness, distance, 0.5, 1,
				ticks, r, g, b, 0.7f);

		// main laser, colored part
		builder = buffer.getBuffer(RenderInit.LASER_MAIN_BEAM);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness, distance, v,
				v + distance * 1.5, ticks, r, g, b, 0.9f);

		// core
		builder = buffer.getBuffer(RenderInit.LASER_MAIN_CORE);
		drawBeam(xOffset, yOffset, zOffset, builder, positionMatrix, matrixNormal, thickness / 2, distance, v,
				v + distance * 1.5, ticks, beam2r, beam2g, beam2b, 1f);
		matrixStack.pop();
		buffer.finish();
	}

	private static float calculateLaserFlickerModifier(long gameTime) {
		return 0.9f + 0.1f * MathHelper.sin(gameTime * 0.9f) * MathHelper.sin(gameTime * 0.3f)
				* MathHelper.sin(gameTime * 0.1f);
	}

	private static void drawBeam(double xOffset, double yOffset, double zOffset, IVertexBuilder builder,
			Matrix4f positionMatrix, Matrix3f matrixNormalIn, float thickness, double distance, double v1, double v2,
			float ticks, float r, float g, float b, float alpha) {
		Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
		vector3f.transform(matrixNormalIn);

		Vector4f vec1 = new Vector4f(0, -thickness + 0, 0, 1.0F);
		vec1.transform(positionMatrix);
		Vector4f vec2 = new Vector4f((float) xOffset, -thickness + (float) yOffset, (float) distance + (float) zOffset,
				1.0F);
		vec2.transform(positionMatrix);
		Vector4f vec3 = new Vector4f((float) xOffset, thickness + (float) yOffset, (float) distance + (float) zOffset,
				1.0F);
		vec3.transform(positionMatrix);
		Vector4f vec4 = new Vector4f(0, thickness + 0, 0, 1.0F);
		vec4.transform(positionMatrix);

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

	}
}
