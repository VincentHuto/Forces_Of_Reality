package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityOccularHeap extends TileModDevotion implements ITickableTileEntity {

	public TileEntityOccularHeap() {
		super(TileEntityInit.occular_heap.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ELDRITCH;
	}
}
