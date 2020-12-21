package com.huto.forces_of_reality.objects.tileenties.vibes.func;

import com.huto.forces_of_reality.capabilities.karma.IKarma;
import com.huto.forces_of_reality.capabilities.karma.KarmaProvider;
import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.init.TileEntityInit;
import com.huto.forces_of_reality.objects.tileenties.util.IExportableTile;
import com.huto.forces_of_reality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forces_of_reality.objects.tileenties.vibes.TileModVibes;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityAbsorber;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityKarmicExtractor extends TileModVibes implements ITickableTileEntity, IExportableTile {

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

	@Override
	public void exportToAbsorber(TileEntityAbsorber exportToIn, float rateIn) {
		if (vibes.getVibes() > 1) {
			this.vibes.subtractVibes(rateIn);
			exportToIn.vibes.addVibes(rateIn);
		}
	}

	public boolean canExport() {
		if (vibes.getVibes() > 10) {
			return true;
		}

		return false;
	}

	@Override
	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getBlockState(), getBlockState());
		world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 3);
		markDirty();
	}
}
