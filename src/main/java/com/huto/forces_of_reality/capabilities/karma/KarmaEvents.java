package com.huto.forces_of_reality.capabilities.karma;

import java.awt.Color;
import java.util.Optional;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.capabilities.karma.activation.IKarmaActivation;
import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivationProvider;
import com.huto.forces_of_reality.dimension.DimensionInit;
import com.huto.forces_of_reality.dimension.DimensionalPosition;
import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.karma.KarmaPacketServer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class KarmaEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "karma"), new KarmaProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		int amount = KarmaProvider.getPlayerKarma(player);
		PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> player), new KarmaPacketServer(amount));
		IKarmaActivation act = player.getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		if (act.getEnabled()) {
			player.sendStatusMessage(new StringTextComponent("Welcome! Current Karma: " + TextFormatting.GOLD + amount),
					false);
		}
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		int amount = KarmaProvider.getPlayerKarma(player);
		PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> player), new KarmaPacketServer(amount));
		IKarmaActivation act = player.getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		if (act.getEnabled()) {
			player.sendStatusMessage(new StringTextComponent("Welcome! Current Karma: " + TextFormatting.GOLD + amount),
					false);
		}
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		IKarma karmaOld = event.getOriginal().getCapability(KarmaProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		IKarma karmaNew = event.getEntity().getCapability(KarmaProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		karmaNew.setKarma(karmaOld.getKarma());
	}

	@SubscribeEvent
	public static void onPlayerKillsEntity(LivingDeathEvent event) {
		if (event.getSource().getTrueSource() instanceof PlayerEntity) {
			PlayerEntity p = (PlayerEntity) event.getSource().getTrueSource();
			IKarma karma = p.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
			IKarmaActivation karmaAct = p.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new);
			if (karmaAct.getActivation() != 0) {
				if (event.getEntity() instanceof AnimalEntity) {
					karma.subtractKarma(1);
				} else if (event.getEntity() instanceof IMerchant || event.getEntity() instanceof PlayerEntity) {
					karma.subtractKarma(10);
				} else if (event.getEntity() instanceof MobEntity) {
					karma.addKarma(1);

				}
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) p),
						new KarmaPacketServer(karma.getKarma()));
				p.sendStatusMessage(
						new StringTextComponent(" Current Karma: " + TextFormatting.GOLD + karma.getKarma()), false);
			}
		}
	}

	private static FontRenderer fontRenderer;

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
		if (fontRenderer == null) {
			fontRenderer = Minecraft.getInstance().fontRenderer;
		}
		PlayerEntity player = Minecraft.getInstance().player;
		if (player != null) {
			if (player.isAlive()) {
				if (player.world.getDimensionKey() == DimensionInit.dreamlands) {
					if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.mysterious_mask
							.get()) {
						IKarma karma = player.getCapability(KarmaProvider.KARMA_CAPA)
								.orElseThrow(IllegalArgumentException::new);
						IKarmaActivation karmaAct = player.getCapability(KarmaActivationProvider.KARMA_CAPA)
								.orElseThrow(IllegalStateException::new);
						if (karmaAct.getActivation() != 0) {
							if (karma.getKarma() > 0) {
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(0, 0, 255, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Positive View", 5, 20,
										new Color(255, 0, 0, 255).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
							} else if (karma.getKarma() == 0) {
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(0, 0, 0, 0).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Neutral View", 5, 20,
										new Color(255, 0, 0, 255).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
							} else if (karma.getKarma() < 0) {
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 0, 0, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Negative View", 5, 20,
										new Color(255, 0, 0, 255).getRGB());
								Minecraft.getInstance().textureManager
										.bindTexture(new ResourceLocation("minecraft", "textures/gui/icons.png"));
							}

						}
					}

				}
			}
		}

	}

	@SubscribeEvent
	public static void applyKarmaBuffs(PlayerTickEvent event) {
		// PlayerEntity player = event.player;

		/*
		 * IKarmaActivation karmaAct =
		 * player.getCapability(KarmaActivationProvider.KARMA_CAPA)
		 * .orElseThrow(IllegalStateException::new); if (karmaAct.getActivation() == 0)
		 * { IKarma karma = player.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(
		 * IllegalStateException::new); // messing with caabilites gets sorta sticky
		 * because they dont return back to // normal... change later if
		 * (karma.getKarma() >= 1.0F) { // player.capabilities.setPlayerWalkSpeed(0.1F);
		 * 
		 * }
		 * 
		 * if (karma.getKarma() >= 20.0F) { player.addPotionEffect(new
		 * EffectInstance(Effects.RESISTANCE, 100, 1)); //
		 * player.capabilities.setPlayerWalkSpeed(1F);
		 * 
		 * } if (karma.getKarma() >= 40.0F) { player.addPotionEffect(new
		 * EffectInstance(Effects.STRENGTH, 100, 2)); //
		 * player.capabilities.setPlayerWalkSpeed(0.2F);
		 * 
		 * } if (karma.getKarma() >= 60.0F) { //
		 * player.capabilities.setPlayerWalkSpeed(0.3F);
		 * 
		 * } if (karma.getKarma() >= 80.0F) { player.addPotionEffect(new
		 * EffectInstance(Effects.GLOWING, 100, 2));
		 * 
		 * } if (karma.getKarma() >= 100.0F) { // player.capabilities.isFlying= true; }
		 * ?
		 */

	}

	// TELLEPORT TO DREAMLANDS
	@SubscribeEvent
	public static void onPlayerSleep(PlayerSleepInBedEvent event) {
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();

		if (!world.isRemote && player instanceof ServerPlayerEntity) {
			boolean foundOnHead = false;
			ItemStack slotItemStack = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
			if (slotItemStack.getItem() == ItemInit.mysterious_mask.get()) {
				foundOnHead = true;
			}
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

			if (serverPlayer.world.getDimensionKey() == DimensionInit.dreamlands) {
				setLastDreamPosition(player);
			} else if (serverPlayer.world.getDimensionKey() != DimensionInit.dreamlands) {
				setLastOverworldPosition(player);
			}
			IKarmaActivation karmaAct = player.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new);
			if (karmaAct.getActivation() != 0) {
				if (foundOnHead) {
					// If player is in the Dreamlands
					if (serverPlayer.world.getDimensionKey() == DimensionInit.dreamlands) {
						Optional<DimensionalPosition> lastPos = getLastOverworldPosition(serverPlayer);
						if (!lastPos.isPresent()) {
							// Should be fine as youll never start in the dreamlands
							serverPlayer.sendStatusMessage(new TranslationTextComponent("no_prev_position"), true);
						} else {
							// Teleport to Overworld
							DimensionalPosition p = lastPos.get();
							BlockPos bp = p.getPosition();
							ResourceLocation dimRL = p.getDimension();
							RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimRL);
							ServerWorld ovw = world.getServer().getWorld(key);
							serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY(), bp.getZ() + 0.5,
									serverPlayer.rotationYaw, serverPlayer.rotationPitch);
						}
					}
					// If player is in the overworld
					else if (serverPlayer.world.getDimensionKey() != DimensionInit.dreamlands) {
						Optional<DimensionalPosition> lastPos = getLastDreamPosition(serverPlayer);
						if (!lastPos.isPresent()) {
							// This is for the first join
							DimensionalPosition p = new DimensionalPosition(DimensionInit.dreamlands.getLocation(),
									new BlockPos(player.getPosX(), player.getPosY() + 200, player.getPosZ()));
							BlockPos bp = p.getPosition();
							ResourceLocation dimRL = p.getDimension();
							RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimRL);
							ServerWorld ovw = world.getServer().getWorld(key);
							player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 255, false, true));
							serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY(), bp.getZ() + 0.5,
									serverPlayer.rotationYaw, serverPlayer.rotationPitch);
						} else {
							// Subsequent Joins
							DimensionalPosition p = lastPos.get();
							BlockPos bp = p.getPosition();
							ServerWorld ovw = world.getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									DimensionInit.dreamlands.getLocation()));
							serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY(), bp.getZ() + 0.5,
									serverPlayer.rotationYaw, serverPlayer.rotationPitch);
						}
					}

				}
			}
		}

	}

	// Saving player position to return too before and after teleport
	public static Optional<DimensionalPosition> getLastOverworldPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		if (!data.contains("overworld-lastpos")) {
			return Optional.empty();
		}
		CompoundNBT pos = data.getCompound("overworld-lastpos");
		return Optional.of(DimensionalPosition.fromNBT(pos));
	}

	public static void setLastOverworldPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		BlockPos pos = player.getPosition();
		ResourceLocation dim = player.world.getDimensionKey().getLocation();
		DimensionalPosition dp = new DimensionalPosition(dim, pos);
		CompoundNBT dimNbt = dp.serializeNBT();
		data.put("overworld-lastpos", dimNbt);
	}

	public static Optional<DimensionalPosition> getLastDreamPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		if (!data.contains("dream-lastpos")) {
			return Optional.empty();
		}
		CompoundNBT pos = data.getCompound("dream-lastpos");
		return Optional.of(DimensionalPosition.fromNBT(pos));
	}

	public static void setLastDreamPosition(PlayerEntity player) {
		CompoundNBT data = player.getPersistentData();
		BlockPos pos = player.getPosition();
		ResourceLocation dim = player.world.getDimensionKey().getLocation();
		DimensionalPosition dp = new DimensionalPosition(dim, pos);
		CompoundNBT dimNbt = dp.serializeNBT();
		data.put("dream-lastpos", dimNbt);
	}

}
