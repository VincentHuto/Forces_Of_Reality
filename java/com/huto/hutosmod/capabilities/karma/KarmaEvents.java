package com.huto.hutosmod.capabilities.karma;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.network.KarmaPacketServer;
import com.huto.hutosmod.network.PacketHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class KarmaEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "karma"), new KarmaProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		int amount = KarmaProvider.getPlayerKarma(player);
		PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> player), new KarmaPacketServer(amount));
		player.sendStatusMessage(new StringTextComponent("Welcome! Current Karma: " + TextFormatting.GOLD + amount),
				false);
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
			if (event.getEntity() instanceof AnimalEntity) {
				karma.subtractKarma(1);
			} else if (event.getEntity() instanceof IMerchant) {
				karma.subtractKarma(10);
			} else if (event.getEntity() instanceof MobEntity) {
				karma.addKarma(1);

			}
			PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) p),
					new KarmaPacketServer(karma.getKarma()));
			p.sendStatusMessage(new StringTextComponent(" Current Karma: " + TextFormatting.GOLD + karma.getKarma()),
					false);
		}
	}

	@SubscribeEvent
	public static void applyKarmaBuffs(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		IKarma karma = player.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
		// messing with caabilites gets sorta sticky because they dont return back to
		// normal... change later
		if (karma.getKarma() >= 1.0F) {
			// player.capabilities.setPlayerWalkSpeed(0.1F);

		}

		if (karma.getKarma() >= 20.0F) {
			player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 1));
			// player.capabilities.setPlayerWalkSpeed(1F);

		}
		if (karma.getKarma() >= 40.0F) {
			player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 2));
			// player.capabilities.setPlayerWalkSpeed(0.2F);

		}
		if (karma.getKarma() >= 60.0F) {
			// player.capabilities.setPlayerWalkSpeed(0.3F);

		}
		if (karma.getKarma() >= 80.0F) {
			player.addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 2));

		}
		if (karma.getKarma() >= 100.0F) {
			// player.capabilities.isFlying= true;
		}

	}

	@SubscribeEvent
	public static void applyKarmaDebuffs(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		IKarma karma = player.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
		if (karma.getKarma() <= -20.0F) {
			player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 1, 2));
		}
	}

}
