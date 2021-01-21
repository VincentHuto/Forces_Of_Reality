package com.huto.forcesofreality.events;

import java.lang.reflect.Field;
import java.util.List;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.models.entity.lords.ModelPlayerTrueXanthousKing;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.SyncCovenPacket;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class RenderLaserEvent {
	@SubscribeEvent
	public static void renderWorldLastEvent(RenderWorldLastEvent evt) {
		List<AbstractClientPlayerEntity> players = Minecraft.getInstance().world.getPlayers();
		PlayerEntity myplayer = Minecraft.getInstance().player;

		for (PlayerEntity player : players) {
			if (player.getDistanceSq(myplayer) > 500)
				continue;
			RenderMechanLaser.renderLaser(evt, player, Minecraft.getInstance().getRenderPartialTicks());
		}
	}

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent evt) {
		if(!evt.player.world.isRemote) {
		if (evt.player.world.getGameTime() % 100 == 0) {
			evt.player.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
				PacketHandler.sendCovenToClients(new SyncCovenPacket(covens.getDevotion(), evt.player.getEntityId()),
						evt.player);
			});
		}
		}
	}

	@SubscribeEvent
	public static void logIn(PlayerLoggedInEvent evt) {
		if (!evt.getPlayer().getEntityWorld().isRemote) {
			for (PlayerEntity player : evt.getPlayer().world.getPlayers())
				player.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
					PacketHandler.sendCovenToClients(new SyncCovenPacket(covens.getDevotion(), player.getEntityId()),
							player);
				});
		}
	}

	private static final Field shadowSize = ObfuscationReflectionHelper.findField(EntityRenderer.class,
			"field_76989_e");
	@SuppressWarnings("unused")
	private static float defaultShadowSize;

	@SubscribeEvent
	public static void renderPlayerEvent(RenderPlayerEvent.Pre evt) {

		PlayerEntity playerEntity = evt.getPlayer();
		playerEntity.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {

			try {
				float f = shadowSize.getFloat(evt.getRenderer());
				if (f != 0.0f) {
					defaultShadowSize = f;
				}
				if (covens.getDevotionByCoven(EnumCovenants.HASTUR) > 5) {
					evt.setCanceled(true);

					evt.getMatrixStack().push();
					ModelPlayerTrueXanthousKing model = new ModelPlayerTrueXanthousKing();
					IRenderTypeBuffer.Impl impl = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
					evt.getMatrixStack().translate(0, 1.5, 0);
					evt.getMatrixStack().rotate(new Quaternion(Vector3f.XP, 180, true));
					model.setRotationAngles(evt.getEntityLiving(), evt.getPlayer().limbSwing,
							evt.getPlayer().limbSwingAmount, evt.getEntityLiving().ticksExisted,
							evt.getPlayer().getRotationYawHead()*.5f, evt.getPlayer().rotationPitch);
					evt.getMatrixStack().rotate(new Quaternion(Vector3f.YP, evt.getPlayer().rotationYaw, true));
					IVertexBuilder ivertexbuilder = impl
							.getBuffer(model.getRenderType((new ResourceLocation(ForcesOfReality.MOD_ID,
									"textures/entity/true_xanthous_king/model_true_xanthous_king.png"))));
					model.render(evt.getMatrixStack(), ivertexbuilder, evt.getLight(), OverlayTexture.NO_OVERLAY, 100,
							100, 100, 100);
					shadowSize.setFloat(evt.getRenderer(), 1.5f);
					impl.finish();
					evt.getMatrixStack().pop();

				} else {
					shadowSize.setFloat(evt.getRenderer(), 1);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}

	@SubscribeEvent
	public static void renderPlayer(RenderPlayerEvent.Pre evt) {
		/*
		 * PlayerEntity myplayer = Minecraft.getInstance().player;
		 * 
		 * ICovenant coven = evt.getPlayer().getCapability(CovenantProvider.COVEN_CAPA)
		 * .orElseThrow(NullPointerException::new); IKarmaActivation karmaAct =
		 * evt.getPlayer().getCapability(KarmaActivationProvider.KARMA_CAPA)
		 * .orElseThrow(NullPointerException::new);
		 * PacketHandler.CHANNELCOVENANT.sendToServer(new CovenantPacketClient());
		 * PacketHandler.CHANNELKARMA.sendToServer(new KarmaActivationPacketClient());
		 * 
		 * if (evt.getPlayer().getHeldItemMainhand().getItem() ==
		 * ItemInit.node_of_actualization.get()) {
		 * 
		 * evt.setCanceled(true); evt.getMatrixStack().push();
		 * ModelPlayerTrueXanthousKing model = new ModelPlayerTrueXanthousKing();
		 * IRenderTypeBuffer.Impl impl =
		 * IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
		 * evt.getMatrixStack().translate(0, 1.5, 0); evt.getMatrixStack().rotate(new
		 * Quaternion(Vector3f.XP, 180, true));
		 * model.setRotationAngles(evt.getEntityLiving(), evt.getPlayer().limbSwing,
		 * evt.getPlayer().limbSwingAmount, evt.getEntityLiving().ticksExisted,
		 * evt.getPlayer().rotationYawHead, evt.getPlayer().rotationPitch);
		 * evt.getMatrixStack().rotate(new Quaternion(Vector3f.YP,
		 * evt.getPlayer().rotationYaw, true)); IVertexBuilder ivertexbuilder = impl
		 * .getBuffer(model.getRenderType((new ResourceLocation(ForcesOfReality.MOD_ID,
		 * "textures/entity/true_xanthous_king/model_true_xanthous_king.png"))));
		 * model.render(evt.getMatrixStack(), ivertexbuilder, evt.getLight(),
		 * OverlayTexture.NO_OVERLAY, 100, 100, 100, 100); impl.finish();
		 * evt.getMatrixStack().pop(); }
		 */
	}

}
