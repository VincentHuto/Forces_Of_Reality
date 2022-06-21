package com.vincenthuto.forcesofreality.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class LayerPlayerAura extends RenderLayer<Player, PlayerModel<Player>> {
	private static final ResourceLocation COLIN_ARMOR = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/entity/colin/colin_armor2.png");
	private final PlayerModel<Player> colinModel;

	public LayerPlayerAura(RenderLayerParent<Player, PlayerModel<Player>> entityRendererIn) {
		super(entityRendererIn);
		colinModel = entityRendererIn.getModel();
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
			Player entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
			float netHeadYaw, float headPitch) {
		float f = entitylivingbaseIn.tickCount + partialTicks;
		colinModel.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		this.getParentModel().copyPropertiesTo(colinModel);
		float swirlSpeedMod = 0.01f;
		VertexConsumer ivertexbuilder = bufferIn
				.getBuffer(RenderType.energySwirl(COLIN_ARMOR, f * swirlSpeedMod, f * 0.01F));
		colinModel.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		colinModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F,
				0.5F, 0.5F);
	}

}
