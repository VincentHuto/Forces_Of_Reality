package com.huto.hutosmod.render.tiles;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableList;
import com.huto.hutosmod.entities.utils.Vector3;
import com.huto.hutosmod.objects.tileenties.TileEntityTeleporter;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTeleporter extends TileEntityRenderer<TileEntityTeleporter> {
	public static final ResourceLocation END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
	public static final ResourceLocation END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
	private static final Random RANDOM = new Random(31100L);
	private static final List<RenderType> RENDER_TYPES = IntStream.range(0, 16).mapToObj((p_228882_0_) -> {
		return RenderType.getEndPortal(p_228882_0_ + 1);
	}).collect(ImmutableList.toImmutableList());

	public RenderTeleporter(TileEntityRendererDispatcher p_i226006_1_) {
		super(p_i226006_1_);
	}

	public void render(TileEntityTeleporter tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		RANDOM.setSeed(31100L);
		double d0 = tileEntityIn.getPos().distanceSq(this.renderDispatcher.renderInfo.getProjectedView(), true);
		int i = this.getPasses(d0);
		float f = this.getOffset();
		Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
		this.renderCube(tileEntityIn, f, 0.135F, matrix4f, bufferIn.getBuffer(RENDER_TYPES.get(0)));

		for (int j = 1; j < i; ++j) {
			this.renderCube(tileEntityIn, f, 48 / (float) (12 - j), matrix4f, bufferIn.getBuffer(RENDER_TYPES.get(j)));
		}

	}

	@SuppressWarnings("static-access")
	private void renderCube(TileEntityTeleporter tileEntityIn, float offset, float fIn, Matrix4f matrix,
			IVertexBuilder vertxBuilder) {

		float f = (RANDOM.nextFloat() * 0.5F + 0.1F) * fIn;
		float f1 = (RANDOM.nextFloat() * 0.5F + 0.4F) * fIn;
		float f2 = (RANDOM.nextFloat() * 0.5F + 0.5F) * fIn;
		// matrix.mul(new Quaternion(Vector3f.XP, (float) Math.sin(System.nanoTime()),
		// false));
		// matrix.invert();
		
		this.renderFace(tileEntityIn, matrix, vertxBuilder, 1.0F, 1.0F, 1.85F, 0.0f, 0.0F, 1.0F, 1.0F, 0.0F, f1, f,
				f1, Direction.EAST);
		
		
		this.renderFace(tileEntityIn, matrix, vertxBuilder, 0.0F, 0.0F, 0.075F, 1.85F, 0.0F, 1.0F, 1.0F, 0.0F, f1, f, f,
				Direction.WEST);
		
		this.renderFace(tileEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, 1.85F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f, f1,
				f2, Direction.NORTH);
		
		this.renderFace(tileEntityIn, matrix, vertxBuilder, 0.0F, 1.0F, 0.075F, 1.85F, 1.0F, 1.0F, 1.0F, 1.0F, f2, f2,
				f, Direction.SOUTH);

		
	
		
		


		
		
		 
	}

	private void renderFace(TileEntityTeleporter tileEntityIn, Matrix4f matrix, IVertexBuilder vertextBuilder,
			float p_228884_4_, float p_228884_5_, float p_228884_6_, float p_228884_7_, float p_228884_8_,
			float p_228884_9_, float p_228884_10_, float p_228884_11_, float r, float g, float b, Direction direction) {

		PlayerEntity player = Minecraft.getInstance().player;
		World world = player.getEntityWorld();
		List<PlayerEntity> players = world.getEntitiesWithinAABB(PlayerEntity.class,
				tileEntityIn.getRenderBoundingBox().grow(8));
		double closestDistance = 0;
		
		if(players.contains(player)) {
		for (PlayerEntity currentPlayer : players) {
			Vector3 blockVec = Vector3.fromTileEntity(tileEntityIn);
			Vector3 playerVec = Vector3.fromEntityCenter(currentPlayer);
			// if (currentPlayer.getHeldItemMainhand().getItem() ==
			// ItemInit.frequency_matcher.get()) {}
			closestDistance = playerVec.distanceTo(blockVec);

			float alpha = (float) (1 - (closestDistance * 0.1f) + 0.3f);
			if (alpha > 1) {
				alpha = 1;
			}
			if (alpha < 0.25f) {
				alpha = 0;
			}
		/*	if (tileEntityIn.shouldRenderFace(direction) && world
					.getBlockState(currentPlayer.getPosition().add(0, -1, 0)).getBlock() == Blocks.QUARTZ_BLOCK) {*/
				if (tileEntityIn.shouldRenderFace(direction) && direction.equals(Direction.EAST)) {
				//Center
				vertextBuilder.pos(matrix, 1.001f, 1.85f, 0).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1.001f, 1.85f, 1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1.001f, 0, 1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1.001f, 0, 0).color(r, g, b, alpha).endVertex();
			/*	//Left
				vertextBuilder.pos(matrix, 1, 1.85f, 0+1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1+2, 1.85f+alpha, 1+2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1+2, 0, 1+2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1, 0, 0+1).color(r, g, b, alpha).endVertex();
				//Right
				vertextBuilder.pos(matrix, 1+2, 1.85f+alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1, 1.85f, 1-1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1, 0, 1-1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1+2, 0, 0-2* alpha).color(r, g, b, alpha).endVertex();
				//Top 
				vertextBuilder.pos(matrix, 1, 1.85f-0.1f, 0).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix,1+2.15f,  1.85f-0.1f+alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1+2.85f* alpha,  1.85f-0.1f+alpha,1+2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1, 1.85f-0.1f, 1).color(r, g, b, alpha).endVertex();
				//Bottom 
				vertextBuilder.pos(matrix,1+2* alpha,  0.01f,1.85f+ alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix,1+2* alpha, 0.01f, -2*alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 1,0.3f, -0.5f).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0, 0.3f, 0.5f).color(r, g, b, alpha).endVertex();*/
				}
				if (tileEntityIn.shouldRenderFace(direction) && direction.equals(Direction.WEST)) {
				//Center
				vertextBuilder.pos(matrix,-0.001f, 0, 0).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, -0.001f, 0, 1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, -0.001f, 1.85f, 1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, -0.001f, 1.85f, 0).color(r, g, b, alpha).endVertex();
			/*	//Left
				vertextBuilder.pos(matrix, 0-2, 0-alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0, 0, 1-1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0, 1.85f, 1-1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0-2, 1.85f+alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
				//Right
				vertextBuilder.pos(matrix, 0, 0, 0+1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0-2, 0-alpha, 1+2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0-2, 1.85f+alpha, 1+2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0, 1.85f, 0+1).color(r, g, b, alpha).endVertex();
				//Top
				vertextBuilder.pos(matrix,0,1.85f-0.1f,1).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix,-2* alpha,1.85f-0.1f+alpha,3* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix,-2* alpha,1.85f-0.1f+alpha,-2* alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix,0,1.85f-0.1f,0).color(r, g, b, alpha).endVertex();
				//Bottom
				vertextBuilder.pos(matrix, 0, 0.31f, 0).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, -2f*alpha, 0.01f, -2*alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, -2f*alpha, 0.01f, 1.85f+1.2f*alpha).color(r, g, b, alpha).endVertex();
				vertextBuilder.pos(matrix, 0, 0.31f, 1).color(r, g, b, alpha).endVertex();*/
					
				}
				
				if (tileEntityIn.shouldRenderFace(direction) && direction.equals(Direction.NORTH)) {
					//Center
					vertextBuilder.pos(matrix, 0, 1.85f, 0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 1.85f, 0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 0, -0.001f).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 0, -0.001f).color(r, g, b, alpha).endVertex();
				/*	
					//Left
					vertextBuilder.pos(matrix, 0-2* alpha, 1.85f+alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 1.85f, 1-1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 0, 1-1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0-2* alpha, 0-alpha, 0-2* alpha).color(r, g, b, alpha).endVertex();
					
					//Right
					vertextBuilder.pos(matrix, 0+1, 1.85f, 0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0+3* alpha, 1.85f+alpha, 1-3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0+3* alpha, 0-alpha, 1-3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0+1, 0, 0).color(r, g, b, alpha).endVertex();
					
					//Top
					vertextBuilder.pos(matrix,-2*alpha*alpha, 1.75f+alpha,-2).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,3*alpha, 1.75f+alpha,-2).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,1, 1.75f,0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,0, 1.75f,0).color(r, g, b, alpha).endVertex();
					
					//Bottom
					vertextBuilder.pos(matrix, 3* alpha, 0.01f,-2* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,-2* alpha* (alpha*1f), 0.01f,-2* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 0.3f, 1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 0.3f, 1).color(r, g, b, alpha).endVertex();
*/
				}
				if (tileEntityIn.shouldRenderFace(direction) && direction.equals(Direction.SOUTH)) {
					//Center
					vertextBuilder.pos(matrix, 0, 0, 1.001f).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 0, 1.001f).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 1.85f, 1.001f).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 1.85f, 1.001f).color(r, g, b, alpha).endVertex();
						
				/*	//Left
					vertextBuilder.pos(matrix, 1-3*alpha, 0, 0+3*alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1-1, 0, 1-0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1-1, 1.75f, 1-0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1-3*alpha, 1.75f+alpha, 0+3*alpha).color(r, g, b, alpha).endVertex();
					
					//Right
					vertextBuilder.pos(matrix, 3*alpha, 0, 3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,3*alpha, 1.75F+alpha,3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,1, 1.75F, 1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 0, 1).color(r, g, b, alpha).endVertex();
					
					
					//Top
					vertextBuilder.pos(matrix,0, 1.5F,0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 1.5F, 0).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 3*alpha, 1.75F+alpha, 3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,-2*alpha*alpha, 1.75F+alpha,3* alpha).color(r, g, b, alpha).endVertex();
					
					//Bottom
					vertextBuilder.pos(matrix, 3*alpha, 0.01f,3* alpha).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 1, 0.3f, 1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix, 0, 0.3f, 1).color(r, g, b, alpha).endVertex();
					vertextBuilder.pos(matrix,-2*alpha*alpha, 0.01f,3* alpha).color(r, g, b, alpha).endVertex();*/

				}
				
			}
		
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