package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class TileEntityVibeGatherer extends TileModVibes implements ITickableTileEntity {

	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	float maxVibes = 100;
	public TileEntityVibeGatherer() {
		super(TileEntityInit.vibe_gatherer.get());
	}

	public IVibrations getVibeCap() {
		return vibes;
	}

	public float getMaxVibes() {
		return maxVibes;
	}

	public void setMaxVibes(float maxVibes) {
		this.maxVibes = maxVibes;
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
		if (block == BlockInit.enchanted_stone_smooth.get() || block == BlockInit.enchanted_stone.get()) {
			return true;
		} else {
			return false;
		}

	}

}
