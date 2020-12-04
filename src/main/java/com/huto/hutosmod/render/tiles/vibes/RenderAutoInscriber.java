package com.huto.hutosmod.render.tiles.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.block.ModelDrumMagatama;
import com.huto.hutosmod.objects.items.tools.ItemKnapper;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.huto.hutosmod.objects.tileenties.vibes.TileEntityAutoInscriber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
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
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderAutoInscriber extends TileEntityRenderer<TileEntityAutoInscriber> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();

	public RenderAutoInscriber(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void render(TileEntityAutoInscriber te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.push();

		matrixStackIn.pop();

		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());

		double time = ClientTickHandler.ticksInGame + partialTicks;

		// Render Block
		for (int i = 0; i < te.getItemHandler().getSlots(); i++) {
			if (te.getItemHandler().getStackInSlot(i).getItem() == Items.OBSIDIAN) {
				Minecraft.getInstance().textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
				matrixStackIn.push();
				matrixStackIn.translate(0.5F, 0.4F, 0.5F);
				matrixStackIn.scale(1.0f, 1.0f, 1.0f);
				ItemStack stack = te.getItemHandler().getStackInSlot(i);
				Minecraft mc = Minecraft.getInstance();
				if (!stack.isEmpty()) {
					mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
							matrixStackIn, bufferIn);
				}
				matrixStackIn.pop();
			}
			// Render Knapper
			if (te.getItemHandler().getStackInSlot(i).getItem() instanceof ItemKnapper) {
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(135f));
				matrixStackIn.translate(0.75F, -1.45F, 0.5F);
				matrixStackIn.scale(1.0f, 1.0f, 1.0f);
				if (te.isActive) {
					matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) time));

				}

				ItemStack knapper = te.getItemHandler().getStackInSlot(i);
				Minecraft mc1 = Minecraft.getInstance();
				if (!knapper.isEmpty()) {
					mc1.getItemRenderer().renderItem(knapper, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
							matrixStackIn, bufferIn);
				}
				matrixStackIn.pop();
			}
		}

		GlStateManager.popMatrix();
		matrixStackIn.translate(0.5, 1.8, 0.5);
		matrixStackIn.scale(0.4f, 0.4f, 0.4f);
		// Cubes
		for (int i = 1; i < te.getLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 16F;
			final float rotationModifier = 0.3F;
			final float radiusBase = 0.55F;
			final float radiusMod = 0.01F;
			int cubes;
			if (te.getLevel() > 1) {
				cubes = te.getLevel() - 1;
			} else {
				cubes = 1;

			}
			float offsetPerCube = 135 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 90f;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 15F);

			// float xRotate = (float) Math.sin(ticks * rotationModifier) /15F;
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 2.5F);
			// float zRotate = (float) Math.cos(ticks * rotationModifier) / 15f;

			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			matrixStackIn.rotate(Vector3f.YN.rotation(yRotate / 12));
			matrixStackIn.rotate(Vector3f.ZP.rotation(135));
			// matrixStackIn.rotate(Vector3f.XP.rotation(xRotate / 12));

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

}
