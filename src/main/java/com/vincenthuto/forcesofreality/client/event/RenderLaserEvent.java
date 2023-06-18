package com.vincenthuto.forcesofreality.client.event;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderLevelStageEvent ;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class RenderLaserEvent {

	private static final Field shadowSize = ObfuscationReflectionHelper.findField(EntityRenderer.class, "shadowRadius");
	public static float defaultShadowSize;

//	@SubscribeEvent
//	public static void renderPlayerEvent(RenderPlayerEvent.Pre evt) {
//		Player playerEntity = evt.getPlayer();
//		playerEntity.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
//			try {
//				float f = shadowSize.getFloat(evt.getRenderer());
//				if (f != 0.0f) {
//					defaultShadowSize = f;
//				}
//				if (covens.getDevotionByCoven(EnumCovenants.HASTUR) > 5
//						&& playerEntity.getMainHandItem().getItem() == ItemInit.yellow_sign.get()) {
//					evt.setCanceled(true);
//					/*
//					 * PacketHandler.CHANNELCOVENANT.send(
//					 * PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> playerEntity), new
//					 * CovenantPacketClient());
//					 */
//					evt.getPoseStack().pushPose();
//					ModelPlayerTrueXanthousKing model = new ModelPlayerTrueXanthousKing();
//					MultiBufferSource.BufferSource impl = MultiBufferSource
//							.immediate(Tesselator.getInstance().getBuilder());
//					evt.getPoseStack().translate(0, 1.5, 0);
//					evt.getPoseStack().mulPose(new Quaternion(Vector3.XP, 180, true));
//					model.setupAnim(evt.getEntityLiving(), evt.getPlayer().animationPosition,
//							evt.getPlayer().animationSpeed, evt.getEntityLiving().tickCount,
//							evt.getPlayer().getYHeadRot() * .25f, evt.getPlayer().getXRot());
//					evt.getPoseStack().mulPose(new Quaternion(Vector3.YP, evt.getPlayer().getYRot(), true));
//					VertexConsumer ivertexbuilder = impl
//							.getBuffer(model.renderType((new ResourceLocation(ForcesOfReality.MOD_ID,
//									"textures/entity/true_xanthous_king/model_true_xanthous_king.png"))));
//					model.renderToBuffer(evt.getPoseStack(), ivertexbuilder, evt.getPackedLight(),
//							OverlayTexture.NO_OVERLAY, 100, 100, 100, 100);
//					shadowSize.setFloat(evt.getRenderer(), 1.5f);
//					impl.endBatch();
//					evt.getPoseStack().popPose();
//
//				} else {
//					shadowSize.setFloat(evt.getRenderer(), 0.5f);
//				}
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		});
//	}

	@SubscribeEvent
	public static void RenderLevelStageEvent (RenderLevelStageEvent  evt) {
		List<AbstractClientPlayer> players = Minecraft.getInstance().level.players();
		Player myplayer = Minecraft.getInstance().player;
		for (Player player : players) {
			if (player.distanceToSqr(myplayer) > 500)
				continue;
			RenderMechanLaser.renderLaser(evt, player, Minecraft.getInstance().getFrameTime());
			RenderWickedLaser.renderLaser(evt, player, Minecraft.getInstance().getFrameTime());

		}
	}

}
