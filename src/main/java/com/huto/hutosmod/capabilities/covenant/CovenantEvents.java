package com.huto.hutosmod.capabilities.covenant;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RunesApi;
import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;
import com.huto.hutosmod.objects.items.runes.ItemRune;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
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
	}

	@SubscribeEvent
	public static void respawn(PlayerRespawnEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			if (!player.getEntityWorld().isRemote) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
						new CovenantPacketServer(coven.getDevotion()));
			}
		}
	}

	// SWITCHED TO CLIENTRENDEREVENT.THERMALLAYERHELPER
	@SubscribeEvent
	public static void onDropRune(LivingDeathEvent e) {
		if (e.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) e.getEntity();
			IRunesItemHandler runes = RunesApi.getRunesHandler(player).orElseThrow(IllegalArgumentException::new);
			for (int i = 0; i < runes.getSlots(); ++i) {
				if (!runes.getStackInSlot(i).isEmpty() && runes.getStackInSlot(i).getItem() instanceof ItemRune) {
					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
							.orElseThrow(IllegalArgumentException::new);
					ItemRune contractRune = (ItemRune) runes.getStackInSlot(i).getItem();
					coven.setCovenDevotion(contractRune.getAssignedCovenant(), -contractRune.getDeepenAmount());
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

	@SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(receiveCanceled = true)
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {

		if (fontRenderer == null) {
			fontRenderer = Minecraft.getInstance().fontRenderer;
		}
		PlayerEntity player = Minecraft.getInstance().player;
		if (player != null) {
			if (player.isAlive()) {
				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				ItemStack stack = player.getHeldItemMainhand();
				Item item = stack.getItem();

				// Allegiance Identifier overlay
				if (item == ItemInit.allegiance_identifier.get()) {
					Item renderItem;
					int centerX = (Minecraft.getInstance().getMainWindow().getScaledWidth() / 2) - 5;
					int centerY = (Minecraft.getInstance().getMainWindow().getScaledHeight() / 2) - 15;
					double angleBetweenEach = 360.0 / EnumCovenants.values().length;
					Point point = new Point(centerX - 60, centerY - 36), center = new Point(centerX, centerY);
					for (int i = 0; i < coven.getDevotion().keySet().size(); i++) {
						EnumCovenants selectedCoven = (EnumCovenants) coven.getDevotion().keySet().toArray()[i];
						GlStateManager.pushMatrix();
						fontRenderer.drawString(event.getMatrixStack(), selectedCoven.toString(), point.x, point.y + 20,
								new Color(255, 0, 0, 255).getRGB());
						fontRenderer.drawString(event.getMatrixStack(),
								String.valueOf(coven.getDevotionByCoven(selectedCoven)), point.x, point.y + 30,
								new Color(255, 0, 0, 255).getRGB());
						GlStateManager.popMatrix();
						if (selectedCoven.equals(EnumCovenants.SELF)) {
							renderItem = Items.CRAFTING_TABLE;
						} else if (selectedCoven.equals(EnumCovenants.HASTUR)) {
							renderItem = ItemInit.yellow_sign.get();
						} else if (selectedCoven.equals(EnumCovenants.ELDRITCH)) {
							renderItem = ItemInit.everwatchful_pendant.get();
						} else if (selectedCoven.equals(EnumCovenants.ASCENDENT)) {
							renderItem = ItemInit.crossed_keys.get();
						} else if (selectedCoven.equals(EnumCovenants.MACHINE)) {
							renderItem = ItemInit.integral_cog.get();
						} else if (selectedCoven.equals(EnumCovenants.BEAST)) {
							renderItem = ItemInit.breath_of_the_beast.get();
						} else {
							renderItem = Items.BARRIER;
						}
						GlStateManager.pushMatrix();
						GlStateManager.enableAlphaTest();
						GlStateManager.enableBlend();
						Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(new ItemStack(renderItem),
								point.x, point.y);
						// GuiUtil.drawScaledTexturedModalRect(point.x, point.y, 0, 0, 16, 16, 0.062f);
						GlStateManager.disableBlend();
						GlStateManager.disableAlphaTest();
						GlStateManager.popMatrix();
						point = rotatePointAbout(point, center, angleBetweenEach);
					}
				}

				// Redraws Icons so they dont get overwrote
				// GuiUtil.drawTexturedModalRect(0, 0, 0, 0, 16, 16);
				Minecraft.getInstance().textureManager
						.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));

				// Coven color Overlay
				if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() != ItemInit.influence_supressor.get()
						&& !(EnchantmentHelper.getEnchantments(player.getItemStackFromSlot(EquipmentSlotType.HEAD))
								.containsKey(EnchantmentInit.influence_suppression.get()))) {
					for (EnumCovenants covens : coven.getDevotion().keySet()) {
						if (coven.getDevotionByCoven(covens) >= 10) {
							int devoMult = (coven.getDevotionByCoven(covens) / 3) < 250
									? (coven.getDevotionByCoven(covens) / 3)
									: 250;
							switch (covens) {
							case HASTUR:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(255, 255, 0, devoMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Hasturs View", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;
							case ELDRITCH:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(255, 0, 255, devoMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Azathoth View", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;
							case ASCENDENT:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(255, 255, 255, devoMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Seraph View", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;
							case BEAST:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(255, 0, 0, devoMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Beast View", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;

							case MACHINE:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(218, 96, 28, devoMult).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Machine View", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;

							case SELF:
								fontRenderer.drawString(event.getMatrixStack(), "Self Devotee", 5, 5,
										new Color(255, 0, 0, 15).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;

							default:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, event.getWindow().getWidth(),
										event.getWindow().getHeight(), new Color(0, 0, 0, 0).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "No Covenant", 5, 5,
										new Color(0, 0, 0, 0).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
								break;
							}
						}
					}
				}
			}
		}
	}

	private static Point rotatePointAbout(Point in, Point about, double degrees) {
		double rad = degrees * Math.PI / 180.0;
		double newX = Math.cos(rad) * (in.x - about.x) - Math.sin(rad) * (in.y - about.y) + about.x;
		double newY = Math.sin(rad) * (in.x - about.x) + Math.cos(rad) * (in.y - about.y) + about.y;
		return new Point((int) newX, (int) newY);
	}

}