package com.huto.hutosmod.capabilities.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.vibes.VibrationPacketServer;
import com.huto.hutosmod.objects.tileenties.vibes.TileModVibes;
import com.huto.hutosmod.objects.tileenties.vibes.TileVibeSimpleInventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class VibrationEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	@SubscribeEvent
	public static void attachCapabilitiesTile(final AttachCapabilitiesEvent<TileEntity> event) {
		if (event.getObject() instanceof TileVibeSimpleInventory) {
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
		}
		if (event.getObject() instanceof TileModVibes) {
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	@SubscribeEvent
	public static void attachCapabilitiesChunk(final AttachCapabilitiesEvent<Chunk> e) {
		e.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		float amount = VibrationProvider.getPlayerVibes(player);
		PacketHandler.CHANNELVIBES.send(PacketDistributor.PLAYER.with(() -> player), new VibrationPacketServer(amount));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Resonance: " + TextFormatting.GOLD + amount + "Hz"), false);
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		float amount = VibrationProvider.getPlayerVibes(player);
		PacketHandler.CHANNELVIBES.send(PacketDistributor.PLAYER.with(() -> player), new VibrationPacketServer(amount));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Resonance: " + TextFormatting.GOLD + amount + "Hz"), false);
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		IVibrations vibesOld = event.getOriginal().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		IVibrations vibesNew = event.getEntity().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		vibesNew.setVibes(vibesOld.getVibes() - 20f);
		((PlayerEntity) event.getEntity()).sendStatusMessage(
				new StringTextComponent(TextFormatting.ITALIC + "Upon death, your resonance has decreased to: "
						+ TextFormatting.RED + TextFormatting.ITALIC + vibesNew.getVibes() + "Hz"),
				false);
	}
	
	
	
	
/*	
	@Nullable
	public static IVibrations getChunkEnergyHolder(final World world, ChunkPos chunkPos) {
		return world.getChunk(chunkPos.x,chunkPos.z).getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(NullPointerException::new);
	}
	
	
	
	@Nullable
	public static IVibrations getChunkEnergy(final World world, final ChunkPos chunkPos) {
		final IVibrations chunkEnergyHolder = getChunkEnergyHolder(world,chunkPos);
		if (chunkEnergyHolder == null) return null;

		return chunkEnergyHolder.getChunkEnergy(chunkPos);
	}
	
	@Nullable
	public static IVibrations getChunkEnergy(final Chunk chunk) {
		return getChunkEnergy(chunk.getWorld(), chunk.getPos());
	}
	
	*//**
	 * Load the {@link IVibrations} for a chunk when the chunk is loaded.
	 *
	 * @param event The event
	 *//*
	@SubscribeEvent
	public static void chunkDataLoad(final ChunkDataEvent.Load event) {
		final IWorld world = event.getWorld();
		final ChunkPos chunkPos = event.getChunk().getPos();

		final IVibrations VibrationsHolder = ((Chunk)world.getChunk(chunkPos.x, chunkPos.z)).getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(NullPointerException::new);
		if (!(VibrationsHolder instanceof IVibrations))
			return;

		final Vibrations Vibrations = new Vibrations(V, world, chunkPos);

		final CompoundNBT chunkData = event.getData();
		if (chunkData.hasKey(ID_STRING, Constants.NBT.TAG_INT)) {
			final IntNBT energyTag = (IntNBT) chunkData.getTag(ID_STRING);
			Vibrations.deserializeNBT(energyTag);
		}

		((IVibrations) VibrationsHolder).setVibrations(chunkPos, Vibrations);
	}

	*//**
	 * Create a default {@link IVibrations} for a chunk when it's loaded, if it
	 * doesn't already have one.
	 * <p>
	 * {@link ChunkDataEvent.Load} is never fired for client-side chunks, so this
	 * allows them to have a default {@link IVibrations} created when they load.
	 *
	 * @param event The event
	 *//*
	@SubscribeEvent
	public static void chunkLoad(final ChunkEvent.Load event) {
		final World world = (World) event.getWorld();
		final ChunkPos chunkPos = event.getChunk().getPos();

		final IVibrations VibrationsHolder = world.getChunk(chunkPos.x, chunkPos.z).getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(NullPointerException::new);
		if (!(VibrationsHolder instanceof IVibrations))
			return;

		if (VibrationsHolder.getChunkEnergy(chunkPos) != null)
			return;

		VibrationsHolder.setChunkEnergy(chunkPos, VibrationsHolder);
	}

	*//**
	 * Save the {@link IVibrations} for a chunk when a chunk is saved.
	 *
	 * @param event The event
	 *//*
	@SubscribeEvent
	public static void chunkDataSave(final ChunkDataEvent.Save event) {
		final IVibrations Vibrations = getVibrations(event.getChunk());
		if (!(Vibrations instanceof Vibrations))
			return;

		event.getData().setTag(ID_STRING, ((Vibrations) Vibrations).serializeNBT());
	}

	*//**
	 * Remove the {@link IVibrations} for a chunk when a chunk is unloaded.
	 *
	 * @param event The event
	 *//*
	@SubscribeEvent
	public static void chunkUnload(final ChunkEvent.Unload event) {
		final IVibrations VibrationsHolder = getVibrationsHolder(event.getWorld());
		if (!(VibrationsHolder instanceof IVibrations))
			return;

		((IVibrations) VibrationsHolder).removeVibrations(event.getChunk().getPos());
	}

	*//**
	 * Send the {@link IVibrations} to the client when a player starts watching the
	 * chunk.
	 *
	 * @param event The event
	 *//*
	@SubscribeEvent
	public static void chunkWatch(final ChunkWatchEvent.Watch event) {
		final ServerPlayerEntity player = event.getPlayer();
		final IVibrations Vibrations = getVibrations(player.getEntityWorld(), event.getChunk());
		if (Vibrations == null)
			return;

		PacketHandler.CHANNELVIBES.sendTo(new MessageUpdateVibrationsValue(Vibrations), player);
	}*/
}
