package com.vincenthuto.forcesofreality.client.render.entity.projectile;
//package com.vincenthuto.forcesofreality.render.entity.projectile;
//
//import javax.annotation.Nonnull;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.entity.summon.EntityPlayerTentacle;
//import com.vincenthuto.forcesofreality.model.entity.mob.ModelPlayerTentacle;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class RenderPlayerTentacle extends MobRenderer<EntityPlayerTentacle, ModelPlayerTentacle> {
//	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
//			"textures/entity/tentacle/model_tentacle.png");
//
//	public RenderPlayerTentacle(Context renderManagerIn) {
//		super(renderManagerIn, new ModelPlayerTentacle(), 0.5f);
//
//	}
//
//	@Override
//	public void render(EntityPlayerTentacle entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
//			MultiBufferSource bufferIn, int packedLightIn) {
//		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//
//	}
//
//	// Growth Scaling
//	@Override
//	protected void scale(EntityPlayerTentacle entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
//		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
//		float f = 0.0F;
//		int i = entitylivingbaseIn.tickCount;
//		if (i > 0) {
//			f = (i - partialTickTime) / 30.0F * 0.8F;
//		}
//
//		if (f > 1.3) {
//			f = 1.3f;
//		}
//		if (entitylivingbaseIn.deathTicks == 1) {
//			matrixStackIn.scale(f, f, f);
//		}
//
//		if (entitylivingbaseIn.deathTicks > 0) {
//			float d = entitylivingbaseIn.deathTicks;
//			matrixStackIn.scale(d, d, d);
//
//		}
//	}
//
//	@Nonnull
//	@Override
//	public ResourceLocation getTextureLocation(@Nonnull EntityPlayerTentacle entity) {
//		return entity.getTentacleTypeName();
//	}
//
//}