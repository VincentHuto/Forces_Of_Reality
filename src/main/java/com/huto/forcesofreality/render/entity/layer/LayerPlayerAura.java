package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;

public class LayerPlayerAura extends RenderLayer<Player, PlayerModel<Player>> {
	private static final ResourceLocation COLIN_ARMOR = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/entity/colin/colin_armor2.png");
	private final PlayerModel<Player> colinModel = new PlayerModel<Player>(1.0f, false);

	public LayerPlayerAura(RenderLayerParent<Player, PlayerModel<Player>> entityRendererIn) {
		super(entityRendererIn);
	}

	
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
			Player entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
			float f = (float) entitylivingbaseIn.ticksExisted + partialTicks;
			colinModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			this.getEntityModel().copyModelAttributesTo(colinModel);
			float swirlSpeedMod = 0.01f;
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEnergySwirl(COLIN_ARMOR, f * swirlSpeedMod, f * 0.01F));
			colinModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw,
					headPitch);
			colinModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F,
					0.5F);
	}

}
