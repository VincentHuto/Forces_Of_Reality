package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.karma.IKarma;
import com.huto.hutosmod.capabilities.karma.KarmaProvider;
import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityKarmicExtractor extends TileModVibes implements ITickableTileEntity {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public float clientVibes = 0.0f;
	public static final String TAG_VIBES = "vibes";

	public TileEntityKarmicExtractor() {
		super(TileEntityInit.karmic_extractor.get());
	}

	@Override
	public void tick() {
	}

	public void onActivated(PlayerEntity player, ItemStack stack) {
		if (world.isRemote)
			return;

		IKarma karma = player.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
		ItemEntity outputItem = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
				new ItemStack(ItemInit.karmic_drop.get()));
		if (karma.getKarma() >= 1) {
			karma.subtractKarma(1);
			vibes.addVibes(20);
			world.addEntity(outputItem);

		}
		if (karma.getKarma() < 0) {
			karma.addKarma(1);
			vibes.addVibes(10);
			world.addEntity(outputItem);

		}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
	}
}
