package com.vincenthuto.forcesofreality.client.render.tile;
//package com.vincenthuto.forcesofreality.render.tile;
//
//import java.util.List;
//import java.util.Random;
//import java.util.stream.IntStream;
//
//import com.google.common.collect.ImmutableList;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import com.mojang.math.Matrix4f;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.core.Direction;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class RenderEndPortalExample<T extends TheEndPortalBlockEntity> extends BlockEntityRenderer<T> {
//	public static final ResourceLocation END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
//	public static final ResourceLocation END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
//	private static final Random RANDOM = new Random(31100L);
//	private static final List<RenderType> RENDER_TYPES = IntStream.range(0, 16).mapToObj((p_228882_0_) -> {
//		return RenderType.endPortal(p_228882_0_ + 1);
//	}).collect(ImmutableList.toImmutableList());
//
//	public RenderEndPortalExample(BlockEntityRenderDispatcher rendererDispatcherIn) {
//		super(rendererDispatcherIn);
//	}
//
//	public void render(T BlockEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn,
//			int combinedLightIn, int combinedOverlayIn) {
//		RANDOM.setSeed(31100L);
//		double d0 = BlockEntityIn.getBlockPos().distSqr(this.renderer.camera.getPosition(), true);
//		int i = this.getPasses(d0);
//		float f = this.getOffset();
//		Matrix4f matrix4f = matrixStackIn.last().pose();
//		this.renderCube(BlockEntityIn, f, 0.15F, matrix4f, bufferIn.getBuffer(RENDER_TYPES.get(0)));
//
//		for (int j = 1; j < i; ++j) {
//			this.renderCube(BlockEntityIn, f, 2.0F / (18 - j), matrix4f,
//					bufferIn.getBuffer(RENDER_TYPES.get(j)));
//		}
//
//	}
//
//	private void renderCube(T BlockEntityIn, float offset, float fIn, Matrix4f matrix, VertexConsumer vertxBuilder) {
//		float f = (RANDOM.nextFloat() * 0.5F + 0.1F) * fIn;
//		float f1 = (RANDOM.nextFloat() * 0.5F + 0.4F) * fIn;
//		float f2 = (RANDOM.nextFloat() * 0.5F + 0.5F) * fIn;
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, f, f1, f2,
//				Direction.SOUTH);
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f, f1, f2,
//				Direction.NORTH);
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, f, f1, f2,
//				Direction.EAST);
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, f, f1, f2,
//				Direction.WEST);
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f, f1, f2,
//				Direction.DOWN);
//		this.renderFace(BlockEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, offset, offset, 1.0F, 1.0F, 0.0F, 0.0F, f, f1,
//				f2, Direction.UP);
//	}
//
//	private void renderFace(T BlockEntityIn, Matrix4f matrix, VertexConsumer vertextBuilder, float p_228884_4_,
//			float p_228884_5_, float p_228884_6_, float p_228884_7_, float p_228884_8_, float p_228884_9_,
//			float p_228884_10_, float p_228884_11_, float r, float g, float b, Direction direction) {
//		if (BlockEntityIn.shouldRenderFace(direction)) {
//			vertextBuilder.vertex(matrix, p_228884_4_, p_228884_6_, p_228884_8_).color(r, g, b, 1.0F).endVertex();
//			vertextBuilder.vertex(matrix, p_228884_5_, p_228884_6_, p_228884_9_).color(r, g, b, 1.0F).endVertex();
//			vertextBuilder.vertex(matrix, p_228884_5_, p_228884_7_, p_228884_10_).color(r, g, b, 1.0F).endVertex();
//			vertextBuilder.vertex(matrix, p_228884_4_, p_228884_7_, p_228884_11_).color(r, g, b, 1.0F).endVertex();
//		}
//
//	}
//
//	protected int getPasses(double pass) {
//		if (pass > 36864.0D) {
//			return 1;
//		} else if (pass > 25600.0D) {
//			return 3;
//		} else if (pass > 16384.0D) {
//			return 5;
//		} else if (pass > 9216.0D) {
//			return 7;
//		} else if (pass > 4096.0D) {
//			return 9;
//		} else if (pass > 1024.0D) {
//			return 11;
//		} else if (pass > 576.0D) {
//			return 13;
//		} else {
//			return pass > 256.0D ? 14 : 15;
//		}
//	}
//
//	protected float getOffset() {
//		return 0.75F;
//	}
//}