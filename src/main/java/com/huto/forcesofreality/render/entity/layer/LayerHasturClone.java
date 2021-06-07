package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntityHasturClone;
import com.huto.forcesofreality.model.entity.summon.ModelHasturClone;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerHasturClone extends LayerRenderer<EntityHasturClone, ModelHasturClone> {
	private final ModelHasturClone slimeModel = new ModelHasturClone();

	public LayerHasturClone(IEntityRenderer<EntityHasturClone, ModelHasturClone> p_i50923_1_) {
		super(p_i50923_1_);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			EntityHasturClone entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		matrixStackIn.scale(1f, 1f, 1f);
		this.getEntityModel().copyModelAttributesTo(this.slimeModel);
		this.slimeModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		this.slimeModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
				headPitch);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(
				new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/hastur/modelhastur_trans.png")));
		this.slimeModel.render(matrixStackIn, ivertexbuilder, packedLightIn,
				LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
	}
}