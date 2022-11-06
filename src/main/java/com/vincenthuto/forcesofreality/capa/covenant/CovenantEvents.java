package com.vincenthuto.forcesofreality.capa.covenant;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
import com.vincenthuto.hutoslib.client.HLTextUtils;
import com.vincenthuto.hutoslib.math.MathUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

public class CovenantEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "covenant"), new CovenantProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayer player = (ServerPlayer) event.getEntity();
		Map<EnumCovenants, Integer> Covenant = CovenantProvider.getPlayerDevotion(player);
		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
				new PacketCovenantServer(Covenant));
//		player.displayClientMessage(
//				 Component.translatable("Welcome! Current Blood Tendency: " + ChatFormatting.GOLD + Covenant), false);
	}

	@SubscribeEvent
	public static void attachCapabilitiesTile(final AttachCapabilitiesEvent<BlockEntity> event) {
//		if (event.getObject() instanceof BlockEntityVisceralRecaller) {
//			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "covenant"), new CovenantProvider());
//		}
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayer player = (ServerPlayer) event.getEntity();
		Map<EnumCovenants, Integer> Covenant = CovenantProvider.getPlayerDevotion(player);
		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
				new PacketCovenantServer(Covenant));
//		player.displayClientMessage(
//				 Component.translatable("Welcome! Current Blood Tendency: " + ChatFormatting.GOLD + Covenant), false);
	}

	@SubscribeEvent
	public static void onPlayerHitsBlock(PlayerInteractEvent.LeftClickEmpty e) {
		/*
		 * // Causes particles when the air is hit if (e.getLevel().isRemote) {
		 * PacketHandler.CHANNELBLOODVOLUME .sendToServer(new
		 * PacketGroundBloodDraw(ClientEventSubscriber.getPartialTicks())); }
		 */
	}

	@SubscribeEvent
	public static void onPlayerDamage(LivingDamageEvent e) {
//		// Radiant Protection
//		if (e.getEntityLiving() instanceof Player) {
//			Player player = (Player) e.getEntityLiving();
//			IRunesItemHandler itemHandler = player.getCapability(RunesCapabilities.RUNES)
//					.orElseThrow(NullPointerException::new);
//			if (itemHandler.getStackInSlot(0).getItem() == ItemInit.rune_radiance_c.get()) {
//				double dist = e.getEntityLiving().distanceTo(player);
//				HitResult trace = e.getEntityLiving().pick(dist, 0, false);
//				PacketHandler.CHANNELBLOODVOLUME.sendToServer(new PacketEntityHitParticle(trace.getLocation().x,
//						trace.getLocation().y, trace.getLocation().z));
//			}
//			if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ItemInit.chitinite_chestplate.get()) {
//				e.setAmount((float) (e.getAmount() * 0.25));
//				double dist = e.getEntityLiving().distanceTo(player);
//				HitResult trace = e.getEntityLiving().pick(dist, 0, false);
//				PacketHandler.CHANNELBLOODVOLUME.sendToServer(new PacketEntityHitParticle(trace.getLocation().x,
//						trace.getLocation().y, trace.getLocation().z));
//			}
//
//		}
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {

		Player peorig = event.getOriginal();
		Player playernew = event.getEntity();
		if (event.isWasDeath()) {
			peorig.reviveCaps();
			ICovenant bloodTendencyNew = playernew.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new);
			bloodTendencyNew.setDevotion(peorig.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalArgumentException::new).getDevotion());
			peorig.invalidateCaps();
		}

	}

	@SubscribeEvent
	public static void respawn(PlayerRespawnEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (!player.getCommandSenderWorld().isClientSide) {
				ICovenant tendency = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
						new PacketCovenantServer(tendency.getDevotion()));
			}
		}
	}

	private static Font fontRenderer;

	@SuppressWarnings({ "deprecation", "unused" })
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(receiveCanceled = true)
	public static void onRenderGameOverlay(RenderGuiOverlayEvent.Post event) {

		if (fontRenderer == null) {
			fontRenderer = Minecraft.getInstance().font;
		}
		Player player = Minecraft.getInstance().player;
		if (player != null) {
			if (player.isAlive()) {
				ICovenant tendency = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				ItemStack stack = player.getMainHandItem();
				Item item = stack.getItem();

				// Allegiance Identifier overlay
				if (item == ItemInit.allegiance_identifier.get()) {
					Item renderItem = ItemInit.allegiance_identifier.get();
					int centerX = (Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2) - 6;
					int centerY = (Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2) - 15;
					double angleBetweenEach = 360.0 / EnumCovenants.values().length;
					Point point = new Point(centerX - 34, centerY - 36), center = new Point(centerX, centerY);
					for (int i = 0; i < tendency.getDevotion().keySet().size(); i++) {
						EnumCovenants selectedCoven = (EnumCovenants) tendency.getDevotion().keySet()
								.toArray()[i];
						// 
						fontRenderer.draw(event.getPoseStack(), HLTextUtils.toProperCase(selectedCoven.toString()),
								point.x, point.y + 20, new Color(255, 0, 0, 255).getRGB());
						fontRenderer.draw(event.getPoseStack(),
								String.valueOf(tendency.getDevotionByCoven(selectedCoven)), point.x, point.y + 30,
								new Color(255, 0, 0, 255).getRGB());

						Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(new ItemStack(renderItem),
								point.x, point.y);

						point = MathUtils.rotatePointAbout(point, center, angleBetweenEach);
					}
				}

				// Redraws Icons so they dont get overwrote
				// GuiUtil.drawTexturedModalRect(0, 0, 0, 0, 16, 16);
				Minecraft.getInstance().textureManager
						.bindForSetup(new ResourceLocation("minecraft", "textures/gui/icons.png"));

				for (EnumCovenants tendencys : tendency.getDevotion().keySet()) {
					if (tendency.getDevotionByCoven(tendencys) >= 10) {
						float devoMult = (tendency.getDevotionByCoven(tendencys) / 3) < 250
								? (tendency.getDevotionByCoven(tendencys) / 3)
								: 250;
						switch (tendencys) {

						default:
							/*
							 * AbstractGui.fill(event.getPoseStack(), 0, 0, event.getWindow().getWidth(),
							 * event.getWindow().getHeight(), new Color(0, 0, 0, 0).getRGB());
							 * 
							 * fontRenderer.drawString(event.getPoseStack(), "No Covenant", 5, 5, new
							 * Color(0, 0, 0, 0).getRGB());
							 */
							Minecraft.getInstance().textureManager
									.bindForSetup(new ResourceLocation("minecraft", "textures/gui/icons.png"));
							break;
						}
					}
				}
			}
		}
	}

}