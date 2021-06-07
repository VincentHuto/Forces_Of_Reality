package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class TileEntityOccularHeap extends TileModDevotion implements ITickableTileEntity {

	public TileEntityOccularHeap() {
		super(TileEntityInit.occular_heap.get());
	}

	public boolean checkStructure() {
		BlockPos adj = getPos().offset(Direction.DOWN);
		BlockState blockState = world.getBlockState(adj);
		Block block = blockState.getBlock();
		if (block == BlockInit.abyssal_silt.get()) {
			this.sacMod = 2;
			return true;
		} else {
			this.sacMod = 1;
			return false;
		}

	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ELDRITCH;
	}
}
