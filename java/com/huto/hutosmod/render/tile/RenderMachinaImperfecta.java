package com.huto.hutosmod.render.tile;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.block.ModelFloatingGearHoriz;
import com.huto.hutosmod.models.block.ModelFloatingGearVert;
import com.huto.hutosmod.objects.tileenties.TileEntityMachinaImperfecta;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderMachinaImperfecta extends TileEntityRenderer<TileEntityMachinaImperfecta> {
	private final ModelFloatingGearVert gearVert = new ModelFloatingGearVert();
	private final ModelFloatingGearHoriz gearHoriz = new ModelFloatingGearHoriz();

	public RenderMachinaImperfecta(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityMachinaImperfecta te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

		matrixStackIn.push();
		matrixStackIn.push();
		IRenderTypeBuffer.Impl impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		matrixStackIn.translate(0.5f, -1.12f, 0.5f);
		matrixStackIn.rotate(Vector3f.YP.rotation(te.getWorld().getGameTime()*0.22f));
		IVertexBuilder vb = impl.getBuffer(gearHoriz
				.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/entity/model_floating_gear.png")));
		gearHoriz.render(matrixStackIn, vb, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F,
				1.0F);
		
		matrixStackIn.rotate(Vector3f.YP.rotation(te.getWorld().getGameTime()*-0.44f));
		matrixStackIn.translate(0, .38, 0);
		gearHoriz.render(matrixStackIn, vb, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F,
				1.0F);
		impl.finish();

		matrixStackIn.pop();

		
		matrixStackIn.translate(0.5f, 0.6f, 0.5f);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		// Cubes
		for (int i = 0; i < te.clientDevo; i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.4F;
			final float radiusBase = 0.3F;
			final float radiusMod = 0.1F;
			int cubes = te.clientDevo;
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
			IRenderTypeBuffer.Impl irendertypebuffer$impl1 = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(gearVert
					.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/entity/model_floating_gear.png")));
			gearVert.render(matrixStackIn, ivertexbuilder1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F,
					1.0F);

			irendertypebuffer$impl1.finish();
			matrixStackIn.pop();

		}
		matrixStackIn.pop();

	}
}
