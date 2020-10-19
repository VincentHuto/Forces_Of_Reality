package com.huto.hutosmod.render.entity.layer;

import com.huto.hutosmod.HutosMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("rawtypes")
public class LayerPlayerHeat<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

	public LayerPlayerHeat(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}
	PlayerModel playerModel = new PlayerModel<>(1f, true);
	private static final ResourceLocation COLIN_ARMOR = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/entity/colin/colin_armor2.png");

	@SuppressWarnings("unchecked")
	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn,
			LivingEntity ent, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		
		if(ent.isGlowing()) {
			//IRenderTypeBuffer buff = new ModOutlineLayerBuffer(bufferIn);
		}
		
		
		float f = (float) ent.ticksExisted + partialTicks;
		playerModel.setLivingAnimations(ent, limbSwing, limbSwingAmount, partialTicks);
		this.getEntityModel().copyModelAttributesTo(playerModel);
		float swirlSpeedMod = 0.01f;
		IVertexBuilder ivertexbuilder = bufferIn
				.getBuffer(RenderType.getEnergySwirl(COLIN_ARMOR, f * swirlSpeedMod, f * 0.01F));
		playerModel.setRotationAngles(ent, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		playerModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F,
				0.5F);

	}

}
