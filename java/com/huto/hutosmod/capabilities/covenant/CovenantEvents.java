package com.huto.hutosmod.capabilities.covenant;

import java.awt.Color;
import java.util.Map;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RunesApi;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.network.CovenantPacketServer;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.objects.items.runes.ItemContractRune;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class CovenantEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "covenant"), new CovenantProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		Map<EnumCovenants, Integer> covenant = CovenantProvider.getPlayerDevotion(player);
		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
				new CovenantPacketServer(covenant));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Covenant: " + TextFormatting.GOLD + covenant), false);
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		Map<EnumCovenants, Integer> covenant = CovenantProvider.getPlayerDevotion(player);
		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
				new CovenantPacketServer(covenant));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Covenant: " + TextFormatting.GOLD + covenant), false);
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		ICovenant covenantOld = event.getOriginal().getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(IllegalStateException::new);
		ICovenant covenantNew = event.getEntity().getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(IllegalStateException::new);
		covenantNew.setDevotion(covenantOld.getDevotion());
		if (!event.getPlayer().getEntityWorld().isRemote) {
			PacketHandler.CHANNELCOVENANT.send(
					PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
					new CovenantPacketServer(covenantNew.getDevotion()));
		}
	}

	// SWITCHED TO CLIENTRENDEREVENT.THERMALLAYERHELPER
	@SubscribeEvent
	public static void onDropRune(LivingDeathEvent e) {
		if (e.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) e.getEntity();
			IRunesItemHandler runes = RunesApi.getRunesHandler(player).orElseThrow(IllegalArgumentException::new);
			for (int i = 0; i < runes.getSlots(); ++i) {
				if (!runes.getStackInSlot(i).isEmpty()
						&& runes.getStackInSlot(i).getItem() instanceof ItemContractRune) {
					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
							.orElseThrow(IllegalArgumentException::new);
					ItemContractRune contractRune = (ItemContractRune) runes.getStackInSlot(i).getItem();
					coven.setCovenDevotion(contractRune.getAssignedCovenant(),
							(coven.getDevotionByCoven(contractRune.getAssignedCovenant()) - 10));
					player.sendStatusMessage(
							new StringTextComponent(TextFormatting.DARK_AQUA + "Your Lord Renounces your Fealty"),
							false);
					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
							new CovenantPacketServer(coven.getDevotion()));
				}
			}
		}
	}

	private static FontRenderer fontRenderer;

	@SubscribeEvent(receiveCanceled = true)
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {

		if (fontRenderer == null) {
			fontRenderer = Minecraft.getInstance().fontRenderer;
		}
		PlayerEntity player = Minecraft.getInstance().player;
		if (player != null) {
			if (player.isAlive()) {
				if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() != ItemInit.influence_supressor
						.get()) {
					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
							.orElseThrow(IllegalArgumentException::new);
					for (EnumCovenants covens : coven.getDevotion().keySet()) {
						if (coven.getDevotionByCoven(covens) >= 10) {
							int devonMult = coven.getDevotionByCoven(covens) / 3;
							switch (covens) {
							case HASTUR:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 255, 0, devonMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Hasturs View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case ELDRITCH:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 0, 255, devonMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Azathoth View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case ASCENDENT:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 255, 255, devonMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Seraph View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case BEAST:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 0, 0, devonMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Beast View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;

							default:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(0, 0, 0, 0).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "No Covenant", 5, 5,
										new Color(0, 0, 0, 0).getRGB());
								break;
							}
						}
					}
				}
			}
		}
	}

}
// SWITCHED TO CLIENTRENDEREVENT.THERMALLAYERHELPER
/*
 * @OnlyIn(Dist.CLIENT)
 * 
 * @SubscribeEvent public static void overrideTooltips1(ItemTooltipEvent e) { if
 * (e.getItemStack().getItem() == ItemInit.yellow_sign.get()) { } }
 * 
 * @SubscribeEvent public static void renderHeatVision(PlayerTickEvent e) {
 * PlayerEntity player = e.player; World world = player.world; if
 * (world.isRemote) if (player.isAlive()) { ICovenant coven =
 * player.getCapability(CovenantProvider.COVEN_CAPA)
 * .orElseThrow(IllegalArgumentException::new); if (coven != null &&
 * coven.getDevotion().get(EnumCovenants.BEAST) != null) { if
 * (coven.getDevotion().get(EnumCovenants.BEAST) >= 10) { // Full Check
 * List<Entity> entList = world.getEntitiesInAABBexcluding(player,
 * player.getBoundingBox().grow(30), EntityPredicates.IS_ALIVE); for (Entity ent
 * : entList) { if (ent instanceof LivingEntity) { LivingEntity livEnt =
 * (LivingEntity) ent; if (livEnt != null) { if
 * (player.getItemStackFromSlot(EquipmentSlotType.HEAD) .getItem() ==
 * ItemInit.influence_supressor.get()) { // Warm Blooded if
 * (ModEntityPredicates.WARMBLOODED.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Heat Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Heat Signature"); }
 * ScorePlayerTeam heatTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Heat Signature"); if (livEnt.getEntityWorld().getGameTime() % 10 ==
 * 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * heatTeam.setColor(TextFormatting.RED); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * heatTeam.setColor(TextFormatting.GOLD); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * heatTeam.setColor(TextFormatting.YELLOW); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Heat Signature")) { livEnt.getEntityWorld().getScoreboard()
 * .addPlayerToTeam(livEnt.getCachedUniqueIdString(), heatTeam);
 * livEnt.setGlowing(true); if (player.getDistance(livEnt) > 30) {
 * livEnt.setGlowing(false); } } }
 * 
 * // Cold Blooded if (ModEntityPredicates.COLDBLOODED.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Cold Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Cold Signature"); }
 * ScorePlayerTeam coldTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Cold Signature"); if (livEnt.getEntityWorld().getGameTime() % 10 ==
 * 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * coldTeam.setColor(TextFormatting.AQUA); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * coldTeam.setColor(TextFormatting.BLUE); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * coldTeam.setColor(TextFormatting.DARK_AQUA); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Cold Signature")) { livEnt.getEntityWorld().getScoreboard()
 * .addPlayerToTeam(livEnt.getCachedUniqueIdString(), coldTeam);
 * livEnt.setGlowing(true); if (player.getDistance(livEnt) > 30) {
 * livEnt.setGlowing(false); } } }
 * 
 * // Undead if (ModEntityPredicates.UNDEAD.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Undead Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Undead Signature"); }
 * ScorePlayerTeam undeadTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Undead Signature"); if (livEnt.getEntityWorld().getGameTime() % 10
 * == 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * undeadTeam.setColor(TextFormatting.WHITE); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * undeadTeam.setColor(TextFormatting.GRAY); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * undeadTeam.setColor(TextFormatting.DARK_GRAY); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Undead Signature")) { livEnt.getEntityWorld().getScoreboard()
 * .addPlayerToTeam(livEnt.getCachedUniqueIdString(), undeadTeam);
 * livEnt.setGlowing(true); if (player.getDistance(livEnt) > 30) {
 * livEnt.setGlowing(false); } } }
 * 
 * // Ender Blooded if (ModEntityPredicates.ENDERBLOOD.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Ender Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Ender Signature"); }
 * ScorePlayerTeam enderTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Ender Signature"); if (livEnt.getEntityWorld().getGameTime() % 10
 * == 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * enderTeam.setColor(TextFormatting.LIGHT_PURPLE); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * enderTeam.setColor(TextFormatting.DARK_PURPLE); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * enderTeam.setColor(TextFormatting.BLACK); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Ender Signature")) { livEnt.getEntityWorld().getScoreboard()
 * .addPlayerToTeam(livEnt.getCachedUniqueIdString(), enderTeam);
 * livEnt.setGlowing(true); if (player.getDistance(livEnt) > 30) {
 * livEnt.setGlowing(false); } } } // Plant Blooded if
 * (ModEntityPredicates.PLANTBLOOD.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Plant Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Plant Signature"); }
 * ScorePlayerTeam plantTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Plant Signature"); if (livEnt.getEntityWorld().getGameTime() % 10
 * == 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * plantTeam.setColor(TextFormatting.GREEN); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * plantTeam.setColor(TextFormatting.YELLOW); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * plantTeam.setColor(TextFormatting.RED); } else if
 * (livEnt.getEntityWorld().getGameTime() % 6 == 0) {
 * plantTeam.setColor(TextFormatting.WHITE); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Plant Signature")) { livEnt.getEntityWorld().getScoreboard()
 * .addPlayerToTeam(livEnt.getCachedUniqueIdString(), plantTeam);
 * livEnt.setGlowing(true); if (player.getDistance(livEnt) > 30) {
 * livEnt.setGlowing(false); } } } // Infernal Blooded if
 * (ModEntityPredicates.INFERNALBLOOD.test(ent)) { if
 * (!livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Flame Signature")) {
 * livEnt.getEntityWorld().getScoreboard().createTeam("Flame Signature"); }
 * ScorePlayerTeam infernalTeam = livEnt.getEntityWorld().getScoreboard()
 * .getTeam("Flame Signature"); if (livEnt.getEntityWorld().getGameTime() % 10
 * == 0) { if (livEnt.getEntityWorld().getGameTime() % 3 == 2) {
 * infernalTeam.setColor(TextFormatting.RED); } else if
 * (livEnt.getEntityWorld().getGameTime() % 4 == 0) {
 * infernalTeam.setColor(TextFormatting.GOLD); } else if
 * (livEnt.getEntityWorld().getGameTime() % 5 == 0) {
 * infernalTeam.setColor(TextFormatting.YELLOW); } else if
 * (livEnt.getEntityWorld().getGameTime() % 6 == 0) {
 * infernalTeam.setColor(TextFormatting.DARK_GRAY); } } if
 * (livEnt.getEntityWorld().getScoreboard().getTeamNames()
 * .contains("Flame Signature")) {
 * livEnt.getEntityWorld().getScoreboard().addPlayerToTeam(
 * livEnt.getCachedUniqueIdString(), infernalTeam); livEnt.setGlowing(true); if
 * (player.getDistance(livEnt) > 30) { livEnt.setGlowing(false); } } } } else {
 * livEnt.setGlowing(false); }
 * 
 * } } } } } } }
 */
