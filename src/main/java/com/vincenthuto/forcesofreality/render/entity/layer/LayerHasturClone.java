//package com.vincenthuto.forcesofreality.render.entity.layer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.entity.summon.EntityHasturClone;
//import com.vincenthuto.forcesofreality.model.entity.summon.ModelHasturClone;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.entity.LivingEntityRenderer;
//import net.minecraft.client.renderer.entity.RenderLayerParent;
//import net.minecraft.client.renderer.entity.layers.RenderLayer;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//@OnlyIn(Dist.CLIENT)
//public class LayerHasturClone extends RenderLayer<EntityHasturClone, ModelHasturClone> {
//	private final ModelHasturClone slimeModel = new ModelHasturClone();
//
//	public LayerHasturClone(RenderLayerParent<EntityHasturClone, ModelHasturClone> p_i50923_1_) {
//		super(p_i50923_1_);
//	}
//
//	@Override
//	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
//			EntityHasturClone entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
//			float ageInTicks, float netHeadYaw, float headPitch) {
//		matrixStackIn.scale(1f, 1f, 1f);
//		this.getParentModel().copyPropertiesTo(this.slimeModel);
//		this.slimeModel.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
//		this.slimeModel.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
//		VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(
//				new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/hastur/modelhastur_trans.png")));
//		this.slimeModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn,
//				LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
//	}
//}