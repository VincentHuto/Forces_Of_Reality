package com.huto.hutosmod.capabilities.covenant;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
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
					coven.setCovenDevotion(EnumCovenants.HASTUR,
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

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
		if (fontRenderer == null) {
			fontRenderer = Minecraft.getInstance().fontRenderer;
		}
		PlayerEntity player = Minecraft.getInstance().player;
		if (player != null) {
			if (player.isAlive()) {
				if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.influence_supressor
						.get()) {
					ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA)
							.orElseThrow(IllegalArgumentException::new);
					for (EnumCovenants covens : coven.getDevotion().keySet()) {
						if (coven.getDevotionByCoven(covens) > 1) {
							switch (covens) {
							case HASTUR:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 255, 0, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Hasturs View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case ELDRITCH:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 0, 255, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Azathoth View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case ASCENDENT:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 255, 255, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Seraph View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());
								break;
							case BEAST:
								AbstractGui.fill(event.getMatrixStack(), 0, 0, 2000, 2000,
										new Color(255, 0, 0, 3).getRGB());
								fontRenderer.drawString(event.getMatrixStack(), "Beast View", 5, 5,
										new Color(255, 0, 0, 255).getRGB());

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

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void overrideTooltips1(ItemTooltipEvent e) {
		if (e.getItemStack().getItem() == ItemInit.yellow_sign.get()) {
		}
	}

	@SubscribeEvent
	public static void applyKarmaDebuffs(PlayerTickEvent e) {
		if (e.player.isAlive()) {
			if (e.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemInit.influence_supressor.get()) {
				Predicate<Entity> WARMBLOODED = new Predicate<Entity>() {
					@Override
					public boolean test(Entity e) {
						if (e instanceof AnimalEntity || e instanceof PlayerEntity || e instanceof AbstractRaiderEntity
								|| e instanceof ZombieEntity || e instanceof AbstractPiglinEntity
								|| e instanceof AmbientEntity || e instanceof WaterMobEntity
								|| e instanceof AbstractVillagerEntity) {
							return true;
						} else {
							return false;
						}
					}
				};

				ICovenant coven = e.player.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven.getDevotion().get(EnumCovenants.BEAST) >= 10) {
					List<Entity> entList = e.player.world.getEntitiesInAABBexcluding(e.player,
							e.player.getBoundingBox().grow(15), WARMBLOODED);
					for (Entity ent : entList) {
						if (ent instanceof LivingEntity) {
							LivingEntity livEnt = (LivingEntity) ent;
							livEnt.addPotionEffect(new EffectInstance(Effects.GLOWING, 2, 2, true, false));
						}
					}
				}
			}
		}
	}
}
