package com.huto.forcesofreality.capabilitie.covenant;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Map;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsApi;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.huto.forcesofreality.entity.util.ModEntityPredicates;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.init.EnchantmentInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.item.ItemAdornment;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.network.coven.SetFlyPKT;
import com.huto.forcesofreality.network.coven.SyncCovenPacket;
import com.hutoslib.math.Vector3;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class CovenantEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "covenant"), new CovenantProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayer player = (ServerPlayer) event.getPlayer();
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

	@SubscribeEvent
	public static void onDropAdornment(LivingDeathEvent e) {
		if (e.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) e.getEntity();
			IAdornmentsItemHandler runes = AdornmentsApi.getAdornmentsHandler(player)
					.orElseThrow(IllegalArgumentException::new);
			for (int i = 0; i < runes.getSlots(); ++i) {
				if (!runes.getStackInSlot(i).isEmpty() && runes.getStackInSlot(i).getItem() instanceof ItemAdornment) {
					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
							.orElseThrow(IllegalArgumentException::new);
					ItemAdornment contractAdornment = (ItemAdornment) runes.getStackInSlot(i).getItem();
					coven.setCovenDevotion(contractAdornment.getAssignedCovenant(),
							-contractAdornment.getDeepenAmount());
					player.sendStatusMessage(
							new StringTextComponent(TextFormatting.DARK_AQUA + "Your Lord Renounces your Fealty"),
							false);
					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
							new CovenantPacketServer(coven.getDevotion()));
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerMine(BlockEvent.BreakEvent evt) {

		Block block = evt.getWorld().getBlockState(evt.getPos()).getBlock();
		if (Tags.Items.ORES.contains(block.asItem())) {
			System.out.println("o");
		}
		if (Tags.Items.CROPS.contains(block.asItem())) {
			System.out.println("c");
		}
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying) {
		updateClientServerFlight(player, allowFlying, allowFlying && player.abilities.isFlying);
	}

	public static void updateClientServerFlight(ServerPlayerEntity player, boolean allowFlying, boolean isFlying) {
		if (player != null) {
			player.abilities.allowFlying = allowFlying;
			player.abilities.isFlying = isFlying;
		}
	}

	@SubscribeEvent
	public static void checkArmor(LivingEquipmentChangeEvent e) {
		if (e.getEntityLiving().ticksExisted > 100) {
			if (e.getEntityLiving() instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) e.getEntityLiving();
				if (player != null) {
					EquipmentSlotType slotChanged = e.getSlot();
					if (slotChanged == EquipmentSlotType.CHEST) {
						if (e.getTo().getItem() == ItemInit.seraph_wings.get()) {
							if (!((PlayerEntity) player).isCreative()) {
								if (player.world.isRemote) {
									PacketHandler.HANDLER.sendToServer(new SetFlyPKT(true, true));
								} else {
									updateClientServerFlight((ServerPlayerEntity) player, true);
								}
							}
						} else {
							if (!((PlayerEntity) player).isCreative()) {
								if (player.world.isRemote) {
									PacketHandler.HANDLER.sendToServer(new SetFlyPKT(false, false));
								} else {
									updateClientServerFlight((ServerPlayerEntity) player, false);
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerKillsEntity(LivingDeathEvent event) {

		if (event.getSource().getTrueSource() instanceof PlayerEntity) {
			PlayerEntity p = (PlayerEntity) event.getSource().getTrueSource();
			if (p.getHeldItemMainhand().getItem() == ItemInit.vorpal_blade.get()) {
				if (ModEntityPredicates.VORPAL.test(event.getEntityLiving())) {
					Vector3 pos = Vector3.fromEntityCenter(event.getEntityLiving());
					World worldIn = event.getEntity().world;

					List<Entity> list = worldIn.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(event.getEntityLiving().getPosition().add(-8, -8, -8),
									event.getEntityLiving().getPosition().add(5, 8, 8)));
					for (Entity ent : list) {
						if (ModEntityPredicates.VORPAL.test(ent)) {
							ent.setFire(3);
							ent.setGlowing(true);
						}
					}

					if (!worldIn.isRemote) {
						ServerWorld sWorld = (ServerWorld) worldIn;

						for (int j = 0; j < 30; j++) {
							sWorld.spawnParticle(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.sin(j) / 9,
									Math.sin(j) / 3, Math.cos(j) / 9, Math.sin(-j) / 9);
							sWorld.spawnParticle(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.cos(j) / 9,
									Math.sin(j) / 3, Math.sin(j) / 9, Math.sin(-j) / 9);
							sWorld.spawnParticle(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.sin(-j) / 9,
									Math.sin(j) / 3, Math.cos(-j) / 9, Math.sin(-j) / 9);
							sWorld.spawnParticle(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.cos(-j) / 9,
									Math.sin(j) / 3, Math.sin(-j) / 9, Math.sin(-j) / 9);
						}
						for (int i = 0; i < 30; i++) {
							sWorld.spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1, Math.sin(i) / 3,
									Math.sin(i) / 3, Math.cos(i) / 3, 0.25f);
							sWorld.spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1, Math.cos(i) / 3,
									Math.sin(i) / 3, Math.sin(i) / 3, 0.25f);
							sWorld.spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1,
									Math.sin(-i) / 3, Math.sin(i) / 3, Math.cos(-i) / 3, 0.25f);
							sWorld.spawnParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1,
									Math.cos(-i) / 3, Math.sin(i) / 3, Math.sin(-i) / 3, 0.25f);
						}
					}
				}
			}
		}

	}

	@SubscribeEvent
	public static void checkArmor(PlayerTickEvent e) {
		if (e.player.ticksExisted > 80 && e.player.ticksExisted < 100) {
			PlayerEntity player = e.player;
			if (!e.player.world.isRemote)
				if (player != null) {
					if (e.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemInit.seraph_wings
							.get()) {
						// System.out.println("EQUIPED WINGS");
						if (!player.getEntityWorld().isRemote) {
							if (!((PlayerEntity) player).isCreative()) {
								updateClientServerFlight((ServerPlayerEntity) player, true);
							} else {
								updateClientServerFlight((ServerPlayerEntity) player, false);

							}
						}
					}
				}
		}
	}

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent evt) {
		if (!evt.player.world.isRemote) {
			if (evt.player.world.getGameTime() % 100 == 0) {
				evt.player.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
					PacketHandler.sendCovenToClients(
							new SyncCovenPacket(covens.getDevotion(), evt.player.getEntityId()), evt.player);
				});
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
						fontRenderer.drawString(event.getMatrixStack(),
								ModTextFormatting.toProperCase(selectedCoven.toString()), point.x, point.y + 20,
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
						} else if (selectedCoven.equals(EnumCovenants.ASCENDANT)) {
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
							case ASCENDANT:
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