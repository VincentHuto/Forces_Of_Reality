package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.IVibrations;
import com.huto.hutosmod.capabilities.VibrationProvider;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class TileEntityWaveGatherer extends TileModVibes implements ITickableTileEntity {

	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);

	public TileEntityWaveGatherer() {
		super(TileEntityInit.wave_gatherer.get());
	}

	@Override
	public void tick() {
		if (checkStructure() && vibes.getVibes() < 100) {
			vibes.addVibes(0.2f);
			System.out.println(vibes.getVibes());
		}
	}

	public boolean checkStructure() {
		BlockPos adj = getPos().offset(Direction.DOWN);
		BlockState blockState = world.getBlockState(adj);
		Block block = blockState.getBlock();
		if (block == Blocks.WATER) {
			return true;
		} else {
			return false;
		}

	}

}
