package com.vincenthuto.forcesofreality.client.render.entity.summons;
//package com.vincenthuto.forcesofreality.render.entity.summons;
//
//import javax.annotation.Nonnull;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.entity.summon.EntityThrone;
//import com.vincenthuto.forcesofreality.model.entity.summon.ModelThrone;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class RenderThrone extends MobRenderer<EntityThrone, ModelThrone> {
//	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
//			"textures/entity/tentacle/model_tentacle.png");
//
//	public RenderThrone(Context renderManagerIn) {
//		super(renderManagerIn, new ModelThrone(), 0.5f);
//
//	}
//
//	@Override
//	public void render(EntityThrone entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
//			MultiBufferSource bufferIn, int packedLightIn) {
//		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//
//	}
//
//	// Growth Scaling
//	@Override
//	protected void scale(EntityThrone entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
//		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
//		float f = 0.0F;
//		int i = entitylivingbaseIn.tickCount;
//		if (i > 0) {
//			f = (i - partialTickTime) / 30.0F * 0.5F;
//		}
//
//		if (f > 1.1) {
//			f = 1.1f;
//		}
//		if (entitylivingbaseIn.deathTicks == 1) {
//			matrixStackIn.scale(f, 1, f);
//		}
//
//		if (entitylivingbaseIn.deathTicks > 0) {
//			float d = entitylivingbaseIn.deathTicks;
//			matrixStackIn.scale(d, 1, d);
//
//		}
//	}
//
//	@Nonnull
//	@Override
//	public ResourceLocation getTextureLocation(@Nonnull EntityThrone entity) {
//		return entity.getTentacleTypeName();
//	}
//
//}