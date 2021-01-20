package com.huto.forcesofreality.events;

import java.util.List;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilities.covenant.ICovenant;
import com.huto.forcesofreality.models.armor.ModelCustomPlayerModel;
import com.huto.forcesofreality.models.entity.lords.ModelPlayerTrueXanthousKing;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.netty.util.HashedWheelTimer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
	public static void renderPlayerRotations(RenderPlayerEvent.Post evt) {

	}

	@SubscribeEvent
	public static void renderPlayer(RenderPlayerEvent.Pre evt) {
		ICovenant coven = evt.getPlayer().getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(NullPointerException::new);
		if (coven.getDevotionByCoven(EnumCovenants.HASTUR) > 2) {
			evt.setCanceled(true);
			evt.getMatrixStack().push();
			ModelPlayerTrueXanthousKing model = new ModelPlayerTrueXanthousKing();
			ModelCustomPlayerModel hasturModel = new ModelCustomPlayerModel();
			PlayerModel<LivingEntity> playerModel = new PlayerModel<>(1, false);
			IRenderTypeBuffer.Impl impl = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
			evt.getRenderer().getEntityModel();
			evt.getMatrixStack().translate(0, 1.5, 0);
			evt.getMatrixStack().rotate(new Quaternion(Vector3f.XP, 180, true));

			PlayerModel<AbstractClientPlayerEntity> oldPlayerModel = evt.getRenderer().getEntityModel();

			model.setRotationAngles(evt.getEntityLiving(), evt.getPlayer().limbSwing, evt.getPlayer().limbSwingAmount,
					evt.getEntityLiving().ticksExisted, evt.getPlayer().rotationYawHead, evt.getPlayer().rotationPitch);
			evt.getMatrixStack().rotate(new Quaternion(Vector3f.YP, evt.getPlayer().rotationYaw, true));

			IVertexBuilder ivertexbuilder = impl
					.getBuffer(model.getRenderType((new ResourceLocation(ForcesOfReality.MOD_ID,
							"textures/entity/true_xanthous_king/model_true_xanthous_king.png"))));
			model.render(evt.getMatrixStack(), ivertexbuilder, evt.getLight(), OverlayTexture.NO_OVERLAY, 100, 100, 100,
					100);
			impl.finish();

			evt.getMatrixStack().pop();
		}
	}

}
