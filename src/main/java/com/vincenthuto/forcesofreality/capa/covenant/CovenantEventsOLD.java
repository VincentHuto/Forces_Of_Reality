package com.vincenthuto.forcesofreality.capa.covenant;
//package com.vincenthuto.forcesofreality.capa.covenant;
//
//import java.awt.Point;
//import java.util.List;
//import java.util.Map;
//
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.entity.util.ModEntityPredicates;
//import com.vincenthuto.forcesofreality.init.ItemInit;
//import com.vincenthuto.forcesofreality.network.PacketHandler;
//import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
//import com.vincenthuto.forcesofreality.network.coven.SetFlyPKT;
//import com.vincenthuto.hutoslib.math.Vector3;
//
//import net.minecraft.ChatFormatting;
//import net.minecraft.client.gui.Font;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.ArmorItem.Type;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.AABB;
//import net.minecraftforge.event.AttachCapabilitiesEvent;
//import net.minecraftforge.event.TickEvent.PlayerTickEvent;
//import net.minecraftforge.event.entity.living.LivingDeathEvent;
//import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
//import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.network.PacketDistributor;
//
//public class CovenantEvents {
//	@SubscribeEvent
//	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
//		if (event.getObject() instanceof Player) {
//			System.out.println("Attatches Capability");
//			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "covenant"), new CovenantProvider());
//		}
//	}
//
//	@SubscribeEvent
//	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
//		ServerPlayer player = (ServerPlayer) event.getPlayer();
//		Map<EnumCovenants, Integer> covenant = CovenantProvider.getPlayerDevotion(player);
//		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
//				new PacketCovenantServer(covenant));
//		player.displayClientMessage(Component.translatable("Welcome! Current Covenant: " + ChatFormatting.GOLD + covenant),
//				false);
//	}
//
//	@SubscribeEvent
//	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
//		ServerPlayer player = (ServerPlayer) event.getPlayer();
//		Map<EnumCovenants, Integer> covenant = CovenantProvider.getPlayerDevotion(player);
//		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
//				new PacketCovenantServer(covenant));
//		player.displayClientMessage(Component.translatable("Welcome! Current Covenant: " + ChatFormatting.GOLD + covenant),
//				false);
//	}
//
//	@SubscribeEvent
//	public static void playerDeath(PlayerEvent.Clone event) {
//		ICovenant covenantOld = event.getOriginal().getCapability(CovenantProvider.COVEN_CAPA)
//				.orElseThrow(IllegalStateException::new);
//		ICovenant covenantNew = event.getEntity().getCapability(CovenantProvider.COVEN_CAPA)
//				.orElseThrow(IllegalStateException::new);
//		covenantNew.setDevotion(covenantOld.getDevotion());
//	}
//
//	@SubscribeEvent
//	public static void respawn(PlayerRespawnEvent event) {
//		if (event.getEntity() instanceof Player) {
//			Player player = (Player) event.getEntity();
//			if (!player.getCommandSenderWorld().isClientSide) {
//				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
//						new PacketCovenantServer(coven.getDevotion()));
//			}
//		}
//	}
//
////	@SubscribeEvent
////	public static void onDropAdornment(LivingDeathEvent e) {
////		if (e.getEntity() instanceof Player) {
////			Player player = (Player) e.getEntity();
////			IAdornmentsItemHandler runes = AdornmentsApi.getAdornmentsHandler(player)
////					.orElseThrow(IllegalArgumentException::new);
////			for (int i = 0; i < runes.getSlots(); ++i) {
////				if (!runes.getStackInSlot(i).isEmpty() && runes.getStackInSlot(i).getItem() instanceof ItemAdornment) {
//					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
////							.orElseThrow(IllegalArgumentException::new);
////					ItemAdornment contractAdornment = (ItemAdornment) runes.getStackInSlot(i).getItem();
////					coven.setCovenDevotion(contractAdornment.getAssignedCovenant(),
////							-contractAdornment.getDeepenAmount());
////					player.displayClientMessage(
////							Component.translatable(ChatFormatting.DARK_AQUA + "Your Lord Renounces your Fealty"), false);
//					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
//							new PacketCovenantServer(coven.getDevotion()));
////				}
////			}
////		}
////	}
//
//
//	public static void updateClientServerFlight(ServerPlayer player, boolean allowFlying) {
//		updateClientServerFlight(player, allowFlying, allowFlying && player.getAbilities().flying);
//	}
//
//	public static void updateClientServerFlight(ServerPlayer player, boolean allowFlying, boolean isFlying) {
//		if (player != null) {
//			player.getAbilities().mayfly = allowFlying;
//			player.getAbilities().flying = isFlying;
//		}
//	}
//
//	@SubscribeEvent
//	public static void checkArmor(LivingEquipmentChangeEvent e) {
//		if (e.getEntityLiving().tickCount > 100) {
//			if (e.getEntityLiving() instanceof Player) {
//				Player player = (Player) e.getEntityLiving();
//				if (player != null) {
//					ArmorItem.Type slotChanged = e.getSlot();
//					if (slotChanged == ArmorItem.Type.CHEST) {
//						if (e.getTo().getItem() == ItemInit.seraph_wings.get()) {
//							if (!player.isCreative()) {
//								if (player.level.isClientSide) {
//									PacketHandler.HANDLER.sendToServer(new SetFlyPKT(true, true));
//								} else {
//									updateClientServerFlight((ServerPlayer) player, true);
//								}
//							}
//						} else {
//							if (!player.isCreative()) {
//								if (player.level.isClientSide) {
//									PacketHandler.HANDLER.sendToServer(new SetFlyPKT(false, false));
//								} else {
//									updateClientServerFlight((ServerPlayer) player, false);
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//	@SubscribeEvent
//	public static void onPlayerKillsEntity(LivingDeathEvent event) {
//
//		if (event.getSource().getEntity() instanceof Player) {
//			Player p = (Player) event.getSource().getEntity();
//			if (p.getMainHandItem().getItem() == ItemInit.vorpal_blade.get()) {
//				if (ModEntityPredicates.VORPAL.test(event.getEntityLiving())) {
//					Vector3 pos = Vector3.fromEntityCenter(event.getEntityLiving());
//					Level worldIn = event.getEntity().level;
//
//					List<Entity> list = worldIn.getEntitiesOfClass(Entity.class,
//							new AABB(event.getEntityLiving().blockPosition().offset(-8, -8, -8),
//									event.getEntityLiving().blockPosition().offset(5, 8, 8)));
//					for (Entity ent : list) {
//						if (ModEntityPredicates.VORPAL.test(ent)) {
//							ent.setSecondsOnFire(3);
//							ent.setGlowingTag(true);
//						}
//					}
//
//					if (!worldIn.isClientSide) {
//						ServerLevel sWorld = (ServerLevel) worldIn;
//
//						for (int j = 0; j < 30; j++) {
//							sWorld.sendParticles(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.sin(j) / 9,
//									Math.sin(j) / 3, Math.cos(j) / 9, Math.sin(-j) / 9);
//							sWorld.sendParticles(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.cos(j) / 9,
//									Math.sin(j) / 3, Math.sin(j) / 9, Math.sin(-j) / 9);
//							sWorld.sendParticles(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.sin(-j) / 9,
//									Math.sin(j) / 3, Math.cos(-j) / 9, Math.sin(-j) / 9);
//							sWorld.sendParticles(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 1, Math.cos(-j) / 9,
//									Math.sin(j) / 3, Math.sin(-j) / 9, Math.sin(-j) / 9);
//						}
//						for (int i = 0; i < 30; i++) {
//							sWorld.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1, Math.sin(i) / 3,
//									Math.sin(i) / 3, Math.cos(i) / 3, 0.25f);
//							sWorld.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1, Math.cos(i) / 3,
//									Math.sin(i) / 3, Math.sin(i) / 3, 0.25f);
//							sWorld.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1,
//									Math.sin(-i) / 3, Math.sin(i) / 3, Math.cos(-i) / 3, 0.25f);
//							sWorld.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.x, pos.y, pos.z, 1,
//									Math.cos(-i) / 3, Math.sin(i) / 3, Math.sin(-i) / 3, 0.25f);
//						}
//					}
//				}
//			}
//		}
//
//	}
//
//	@SubscribeEvent
//	public static void checkArmor(PlayerTickEvent e) {
//		if (e.player.tickCount > 80 && e.player.tickCount < 100) {
//			Player player = e.player;
//			if (!e.player.level.isClientSide)
//				if (player != null) {
//					if (e.player.getItemBySlot(ArmorItem.Type.CHEST).getItem() == ItemInit.seraph_wings.get()) {
//						// System.out.println("EQUIPED WINGS");
//						if (!player.getCommandSenderWorld().isClientSide) {
//							if (!player.isCreative()) {
//								updateClientServerFlight((ServerPlayer) player, true);
//							} else {
//								updateClientServerFlight((ServerPlayer) player, false);
//
//							}
//						}
//					}
//				}
//		}
//	}
//
////	@SubscribeEvent
////	public static void playerTick(PlayerTickEvent evt) {
////		if (!evt.player.level.isClientSide) {
////			if (evt.player.level.getGameTime() % 100 == 0) {
////				evt.player.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> {
////					PacketHandler.sendCovenToClients(new SyncCovenPacket(covens.getDevotion(), evt.player.getId()),
////							evt.player);
////				});
////			}
////		}
////	}
//
//	private static Font fontRenderer;
//
////	@SuppressWarnings("deprecation")
////	@OnlyIn(Dist.CLIENT)
////	@SubscribeEvent(receiveCanceled = true)
////	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
////
////		if (fontRenderer == null) {
////			fontRenderer = Minecraft.getInstance().font;
////		}
////		Player player = Minecraft.getInstance().player;
////		if (player != null) {
////			if (player.isAlive()) {
////				ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
////						.orElseThrow(IllegalArgumentException::new);
////				ItemStack stack = player.getMainHandItem();
////				Item item = stack.getItem();
////
////				// Allegiance Identifier overlay
////				if (item == ItemInit.allegiance_identifier.get()) {
////					Item renderItem;
////					int centerX = (Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2) - 5;
////					int centerY = (Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2) - 15;
////					double angleBetweenEach = 360.0 / EnumCovenants.values().length;
////					Point point = new Point(centerX - 60, centerY - 36), center = new Point(centerX, centerY);
////					for (int i = 0; i < coven.getDevotion().keySet().size(); i++) {
////						EnumCovenants selectedCoven = (EnumCovenants) coven.getDevotion().keySet().toArray()[i];
////
////						fontRenderer.draw(event.getPoseStack(),
////								ModTextFormatting.toProperCase(selectedCoven.toString()), point.x, point.y + 20,
////								new Color(255, 0, 0, 255).getRGB());
////						fontRenderer.draw(event.getPoseStack(),
////								String.valueOf(coven.getDevotionByCoven(selectedCoven)), point.x, point.y + 30,
////								new Color(255, 0, 0, 255).getRGB());
////
////						if (selectedCoven.equals(EnumCovenants.SELF)) {
////							renderItem = Items.CRAFTING_TABLE;
////						} else if (selectedCoven.equals(EnumCovenants.HASTUR)) {
////							renderItem = ItemInit.yellow_sign.get();
////						} else if (selectedCoven.equals(EnumCovenants.ELDRITCH)) {
////							renderItem = ItemInit.everwatchful_pendant.get();
////						} else if (selectedCoven.equals(EnumCovenants.ASCENDANT)) {
////							renderItem = ItemInit.crossed_keys.get();
////						} else if (selectedCoven.equals(EnumCovenants.MACHINE)) {
////							renderItem = ItemInit.integral_cog.get();
////						} else if (selectedCoven.equals(EnumCovenants.BEAST)) {
////							renderItem = ItemInit.breath_of_the_beast.get();
////						} else {
////							renderItem = Items.BARRIER;
////						}
////
////						GlStateManager._enableAlphaTest();
////						GlStateManager._enableBlend();
////						Minecraft.getInstance().getItemRenderer().renderAndDecorateItem(event.getPoseStack(), new ItemStack(renderItem),
////								point.x, point.y);
////						// GuiUtil.drawScaledTexturedModalRect(point.x, point.y, 0, 0, 16, 16, 0.062f);
////						GlStateManager._disableBlend();
////						GlStateManager._disableAlphaTest();
////
////						point = rotatePointAbout(point, center, angleBetweenEach);
////					}
////				}
////
////				// Redraws Icons so they dont get overwrote
////				// GuiUtil.drawTexturedModalRect(0, 0, 0, 0, 16, 16);
////				Minecraft.getInstance().textureManager
////						.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////
////				// Coven color Overlay
////				if (player.getItemBySlot(ArmorItem.Type.HEAD).getItem() != ItemInit.influence_supressor.get()
////						&& !(EnchantmentHelper.getEnchantments(player.getItemBySlot(ArmorItem.Type.HEAD))
////								.containsKey(EnchantmentInit.influence_suppression.get()))) {
////					for (EnumCovenants covens : coven.getDevotion().keySet()) {
////						if (coven.getDevotionByCoven(covens) >= 10) {
////							int devoMult = (coven.getDevotionByCoven(covens) / 3) < 250
////									? (coven.getDevotionByCoven(covens) / 3)
////									: 250;
////							switch (covens) {
////							case HASTUR:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(), new Color(255, 255, 0, devoMult).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "Hasturs View", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////							case ELDRITCH:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(), new Color(255, 0, 255, devoMult).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "Azathoth View", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////							case ASCENDANT:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(),
////										new Color(255, 255, 255, devoMult).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "Seraph View", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////							case BEAST:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(), new Color(255, 0, 0, devoMult).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "Beast View", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////
////							case MACHINE:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(), new Color(218, 96, 28, devoMult).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "Machine View", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////
////							case SELF:
////								fontRenderer.draw(event.getPoseStack(), "Self Devotee", 5, 5,
////										new Color(255, 0, 0, 15).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////
////							default:
////								GuiComponent.fill(event.getPoseStack(), 0, 0, event.getWindow().getScreenWidth(),
////										event.getWindow().getScreenHeight(), new Color(0, 0, 0, 0).getRGB());
////								fontRenderer.draw(event.getPoseStack(), "No Covenant", 5, 5,
////										new Color(0, 0, 0, 0).getRGB());
////								Minecraft.getInstance().textureManager
////										.bind(new ResourceLocation("minecraft", "textures/gui/icons.png"));
////								break;
////							}
////						}
////					}
////				}
////			}
////		}
////	}
//
//	private static Point rotatePointAbout(Point in, Point about, double degrees) {
//		double rad = degrees * Math.PI / 180.0;
//		double newX = Math.cos(rad) * (in.x - about.x) - Math.sin(rad) * (in.y - about.y) + about.x;
//		double newY = Math.sin(rad) * (in.x - about.x) + Math.cos(rad) * (in.y - about.y) + about.y;
//		return new Point((int) newX, (int) newY);
//	}
//
//}