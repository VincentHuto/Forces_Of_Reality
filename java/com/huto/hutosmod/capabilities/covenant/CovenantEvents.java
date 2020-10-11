package com.huto.hutosmod.capabilities.covenant;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RunesApi;
import com.huto.hutosmod.network.CovenantPacketServer;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.objects.items.runes.ItemContractRune;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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
		EnumCovenants covenant = CovenantProvider.getPlayerCovenant(player);
		PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> player),
				new CovenantPacketServer(covenant.toString()));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Covenant: " + TextFormatting.GOLD + covenant), false);
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		ICovenant covenantOld = event.getOriginal().getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(IllegalStateException::new);
		ICovenant covenantNew = event.getEntity().getCapability(CovenantProvider.COVEN_CAPA)
				.orElseThrow(IllegalStateException::new);
		covenantNew.setCovenant(covenantOld.getCovenant());
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
					coven.setCovenant(EnumCovenants.NONE);
					player.sendStatusMessage(
							new StringTextComponent(TextFormatting.DARK_AQUA + "Your Lord Renounces your Fealty"),
							false);

				}
			}
		}
	}

	@SubscribeEvent
	public static void applyKarmaBuffs(PlayerTickEvent event) {

	}

	@SubscribeEvent
	public static void applyKarmaDebuffs(PlayerTickEvent event) {

	}
}
