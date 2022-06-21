//package com.vincenthuto.forcesofreality.render.entity.summons;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.entity.summon.EntityHasturClone;
//import com.vincenthuto.forcesofreality.model.entity.summon.ModelHasturClone;
//import com.vincenthuto.forcesofreality.render.entity.layer.LayerHasturClone;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.entity.MobRenderer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class RenderHasturClone extends MobRenderer<EntityHasturClone, ModelHasturClone> {
//
//	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
//			"textures/entity/hastur/modelhastur_dead.png");
//
//	public RenderHasturClone(Context renderManagerIn) {
//		super(renderManagerIn, new ModelHasturClone(), 0.5f);
//		this.addLayer(new LayerHasturClone(this));
//	}
//
//	@Override
//	public void render(EntityHasturClone entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
//			MultiBufferSource bufferIn, int packedLightIn) {
//		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//
//		matrixStackIn.pushPose();
//		matrixStackIn.popPose();
//
//	}
//
//	@Override
//	public ResourceLocation getTextureLocation(EntityHasturClone entity) {
//		return TEXTURE;
//
//	}
//}