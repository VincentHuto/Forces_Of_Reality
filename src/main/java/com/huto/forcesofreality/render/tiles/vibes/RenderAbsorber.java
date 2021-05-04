package com.huto.forcesofreality.render.tiles.vibes;

import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.RenderTypeInit;
import com.huto.forcesofreality.models.block.ModelDrumMagatama;
import com.huto.forcesofreality.models.block.ModelFloatingCube;
import com.huto.forcesofreality.objects.tileenties.util.EnumAbsorberStates;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;
import com.huto.forcesofreality.render.tiles.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.block.DirectionalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;

public class RenderAbsorber extends TileEntityRenderer<TileEntityAbsorber> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();
	private final ModelFloatingCube cube = new ModelFloatingCube();
	public static long lastRefreshTime;
	public static final DirectionProperty FACING = DirectionalBlock.FACING;

	public RenderAbsorber(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityAbsorber te, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn, int combinedOverlayIn) {

		// draw Laser Connection
		float r = 122 / 255f;
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

		PlayerEntity player = Minecraft.getInstance().player;
		World world = player.getEntityWorld();
		List<PlayerEntity> players = world.getEntitiesWithinAABB(PlayerEntity.class,
				te.getRenderBoundingBox().grow(10));
		if (players.contains(player)) {
			drawLasers(matrixStackIn, te.getLasers(), r, g, b);
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

		ResourceLocation textureExport = new ResourceLocation(
				ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_red.png");
		ResourceLocation textureImport = new ResourceLocation(
				ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_blue.png");
		ResourceLocation textureDefault = new ResourceLocation(
				ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_default.png");
		ResourceLocation textureBoth = new ResourceLocation(
				ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_purple.png");
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
		if (te.getBlockState().getValues().get(FACING).toString().toUpperCase().equals(FaceDirection.UP.toString())
				|| te.getBlockState().getValues().get(FACING).toString().toUpperCase()
						.equals(FaceDirection.DOWN.toString())) {
			matrixStackIn.translate(-0.125, y - 0.9, -0.125);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.WEST.toString())) {
			matrixStackIn.translate(-0.125, -0.9, -0.125 - (y * 1.3));

		}else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.EAST.toString())) {
			matrixStackIn.translate(-0.125, -0.9, 0.125 - (y * 1.3));

		}else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.NORTH.toString())) {
			matrixStackIn.translate(0.125 +y, -0.9, -0.125);

		}else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.SOUTH.toString())) {
			matrixStackIn.translate(0.125 +y, -0.9, -0.125);

		}
		matrixStackIn.scale(4, 4, 4);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(cube.getRenderType(textureMode));
		cube.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

	}

	public static void drawLasers(MatrixStack matrixStackIn, SetMultimap<BlockPos, BlockPos> lasers, float r, float g,
			float b) {
		final Minecraft mc = Minecraft.getInstance();
		World world = mc.world;
		IRenderTypeBuffer.Impl buffer = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
		long gameTime = world.getGameTime();
		double v = gameTime * 0.04;
		Vector3d view = mc.gameRenderer.getActiveRenderInfo().getProjectedView();
		matrixStackIn.push();
		matrixStackIn.translate(-view.getX(), -view.getY(), -view.getZ());
		IVertexBuilder builder;
		builder = buffer.getBuffer(RenderTypeInit.LASER_MAIN_ADDITIVE);
		SetMultimap<BlockPos, BlockPos> lasersCopy = HashMultimap.create(lasers);
		lasersCopy.forEach((source, target) -> {
			matrixStackIn.push();

			matrixStackIn.translate(source.getX(), source.getY(), source.getZ());
			matrixStackIn.scale(2, 2, 2);
			float diffX = target.getX() + .5f - source.getX();
			float diffY = target.getY() + .5f - source.getY();
			float diffZ = target.getZ() + .5f - source.getZ();
			Vector3f startLaser = new Vector3f(0.5f, .57f, 0.5f);
			Vector3f endLaser = new Vector3f(diffX, diffY, diffZ);
			Vector3f sortPos = new Vector3f(source.getX(), source.getY(), source.getZ());
			Matrix4f positionMatrix = matrixStackIn.getLast().getMatrix();
			drawLaser(builder, positionMatrix, endLaser, startLaser, r, g, b, 1f, 0.025f, v, v + diffY * -5.5, sortPos);
			matrixStackIn.pop();
		});
		matrixStackIn.pop();
		buffer.finish(RenderTypeInit.LASER_MAIN_ADDITIVE);
	}

	public static Vector3f adjustBeamToEyes(Vector3f from, Vector3f to, Vector3f sortPos) {
		// This method takes the player's position into account, and adjusts the beam so
		// that its rendered properly whereever you stand
		PlayerEntity player = Minecraft.getInstance().player;
		Vector3f P = new Vector3f((float) player.getPosX() - sortPos.getX(),
				(float) player.getPosYEye() - sortPos.getY(), (float) player.getPosZ() - sortPos.getZ());

		Vector3f PS = from.copy();
		PS.sub(P);
		Vector3f SE = to.copy();
		SE.sub(from);

		Vector3f adjustedVec = PS.copy();
		adjustedVec.cross(SE);
		adjustedVec.normalize();
		return adjustedVec;
	}

	public static void drawLaser(IVertexBuilder builder, Matrix4f positionMatrix, Vector3f from, Vector3f to, float r,
			float g, float b, float alpha, float thickness, double v1, double v2, Vector3f sortPos) {
		Vector3f adjustedVec = adjustBeamToEyes(from, to, sortPos);
		adjustedVec.mul(thickness); // Determines how thick the beam is

		Vector3f p1 = from.copy();
		p1.add(adjustedVec);
		Vector3f p2 = from.copy();
		p2.sub(adjustedVec);
		Vector3f p3 = to.copy();
		p3.add(adjustedVec);
		Vector3f p4 = to.copy();
		p4.sub(adjustedVec);

		builder.pos(positionMatrix, p1.getX(), p1.getY(), p1.getZ()).color(r, g, b, alpha).tex(1, (float) v1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).endVertex();
		builder.pos(positionMatrix, p3.getX(), p3.getY(), p3.getZ()).color(r, g, b, alpha).tex(1, (float) v2)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).endVertex();
		builder.pos(positionMatrix, p4.getX(), p4.getY(), p4.getZ()).color(r, g, b, alpha).tex(0, (float) v2)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).endVertex();
		builder.pos(positionMatrix, p2.getX(), p2.getY(), p2.getZ()).color(r, g, b, alpha).tex(0, (float) v1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).endVertex();
	}

	public static boolean canAdd(BlockPos sourcePos, BlockPos targetPos) {
		SetMultimap<BlockPos, BlockPos> lasers = HashMultimap.create();
		if (!lasers.containsKey(targetPos))
			return true;
		Set<BlockPos> tempSet = lasers.get(targetPos);
		if (!tempSet.contains(sourcePos))
			return true;
		return false;
	}
}