package com.huto.hutosmod.render.tile;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableList;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.ModelDrumMagatama;
import com.huto.hutosmod.objects.tileenties.TileEntityStorageDrum;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class RenderStorageDrum extends TileEntityRenderer<TileEntityStorageDrum> {

	/** The texture for the book above the enchantment table. */
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();

	// Portal Sctuff
	public static final ResourceLocation END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
	public static final ResourceLocation END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
	private static final Random RANDOM = new Random(31100L);
	private static final List<RenderType> RENDER_TYPES = IntStream.range(0, 16).mapToObj((p_228882_0_) -> {
		return RenderType.getEndPortal(p_228882_0_ + 1);
	}).collect(ImmutableList.toImmutableList());

	public RenderStorageDrum(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityStorageDrum te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

		float vibe = te.clientVibes;
		//System.out.println(te.getUpdateTag().get(te.TAG_VIBES));

		float heightMod = 0;
		// Check System that increments the mana based on amount and color
		if (vibe > 0 && vibe <= 300)
			heightMod = (float) (vibe / 300 * 1.7);
		if (vibe > 300 && vibe <= 600)
			heightMod = (float) (((vibe - 280) / 300) * 1.4);
		if (vibe > 600 && vibe <= 900) {
			heightMod = (float) (((vibe - 580) / 300) * 1.4);
		} else if (vibe > 900) {
			heightMod = (float) (((vibe - 880) / 300) * 3.5);
		}
		if (heightMod > 1.4) {
			heightMod = (float) 1.4;
		}

		double manaRatioColor = vibe / 300;
		float colorMod = 0;
		// Higher F1 = more blue
		if (manaRatioColor <= 1) {
			colorMod = 0.35F;
		} else if (manaRatioColor > 1 && manaRatioColor <= 2) {
			colorMod = 4.8F;

		} else if (manaRatioColor > 2 && manaRatioColor <= 3) {
			colorMod = 12.4F;

		}
		// Portal Schtuff
		RANDOM.setSeed(31100L);
		double d0 = te.getPos().distanceSq(this.renderDispatcher.renderInfo.getProjectedView(), true);
		int p = this.getPasses(d0);
		Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
		this.renderCube(te, 0.15f, colorMod, matrix4f, bufferIn.getBuffer(RENDER_TYPES.get(0)), heightMod);
		for (int j = 1; j < p; ++j) {
			this.renderCube(te, colorMod, 2.0F / (float) (18 - j), matrix4f, bufferIn.getBuffer(RENDER_TYPES.get(j)),
					heightMod);
		}

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
		for (int k = 0; k < te.getSizeInventory(); k++) {
			matrixStackIn.push();
			matrixStackIn.translate(0.5F, 2F, 0.5F);
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(angles[k] + (float) time * 0.8f));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(angles[k] + (float) time * 0.8f));
			matrixStackIn.rotate(Vector3f.YN.rotationDegrees(angles[k] + (float) time * 0.8f));
			// Edit True Radius
			matrixStackIn.translate(0.025F, -0.5F, 0.025F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
			// Edit Radius Movement
			matrixStackIn.translate(0D, 0.175D + k * 0.25, 0F);
			// Block/Item Scale
			matrixStackIn.scale(0.3f, 0.3f, 0.3f);
			ItemStack stack = te.getItemHandler().getStackInSlot(k);
			Minecraft mc = Minecraft.getInstance();
			if (!stack.isEmpty()) {
				mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
						matrixStackIn, bufferIn);
			}
			matrixStackIn.pop();
		}
		matrixStackIn.translate(0.5, 1.8, 0.5);
		matrixStackIn.scale(0.75f, 0.75f, 0.75f);
		// Cubes
		for (int i = 0; i < te.getTankLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.9F;
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
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas
					.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_red.png")));
			magatamas.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();
		}
	}

	private void renderCube(TileEntityStorageDrum te, float offset, float fIn, Matrix4f matrix, IVertexBuilder vertx,
			float heightModIn) {
		float r = (RANDOM.nextFloat() * 0.5F + 0.1F) * fIn;
		float g = (RANDOM.nextFloat() * 0.5F + 0.4F) * fIn;
		float b = (RANDOM.nextFloat() * 0.5F + 0.5F) * fIn;
		float a = 1f;
		this.renderFace(te, matrix, vertx, 0.125F, .875F, 0.0625F, heightModIn, .875F, .875F, .875F, .875F, r, g, b, a,
				Direction.SOUTH);
		this.renderFace(te, matrix, vertx, 0.125F, .875F, heightModIn, 0.00F, 0.125F, 0.125F, 0.125F, 0.125F, r, g, b,
				a, Direction.NORTH);
		this.renderFace(te, matrix, vertx, 0.875F, 0.875F, heightModIn, 0.0625F, 0.125F, 0.875F, 0.875F, 0.125F, r, g,
				b, a, Direction.EAST);
		this.renderFace(te, matrix, vertx, 0.125F, 0.125F, 0.00F, heightModIn, 0.125F, 0.875F, 0.875F, 0.125F, r, g, b,
				a, Direction.WEST);
		// Down isnt really needed because itll never be seen
		// this.renderFace(te, matrix, vertx, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F,
		// 1.0F, r, g, b, a, Direction.DOWN);
		this.renderFace(te, matrix, vertx, 0.125F, 0.875F, heightModIn, heightModIn, 0.875F, 0.875F, 0.125F, 0.125F, r,
				g, b, a, Direction.UP);
	}

	private void renderFace(TileEntityStorageDrum te, Matrix4f matrix, IVertexBuilder vertextBuilder, float x, float y,
			float z, float x1, float y1, float z1, float f1, float f2, float r, float g, float b, float a,
			Direction direction) {
		if (true) {
			vertextBuilder.pos(matrix, x, z, y1).color(r, g, b, a).endVertex();
			vertextBuilder.pos(matrix, y, z, z1).color(r, g, b, a).endVertex();
			vertextBuilder.pos(matrix, y, x1, f1).color(r, g, b, a).endVertex();
			vertextBuilder.pos(matrix, x, x1, f2).color(r, g, b, a).endVertex();
		}

	}

	protected int getPasses(double pass) {
		if (pass > 36864.0D) {
			return 1;
		} else if (pass > 25600.0D) {
			return 3;
		} else if (pass > 16384.0D) {
			return 5;
		} else if (pass > 9216.0D) {
			return 7;
		} else if (pass > 4096.0D) {
			return 9;
		} else if (pass > 1024.0D) {
			return 11;
		} else if (pass > 576.0D) {
			return 13;
		} else {
			return pass > 256.0D ? 14 : 15;
		}
	}

	protected float getOffset() {
		return 0.75F;
	}

}
