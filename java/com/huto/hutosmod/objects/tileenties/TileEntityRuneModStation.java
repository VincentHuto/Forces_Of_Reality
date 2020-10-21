package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRuneModStation extends TileEntity implements ITickableTileEntity {

	public TileEntityRuneModStation() {
		super(TileEntityInit.rune_mod_station.get());
	}

	@Override
	public void tick() {
	}

}
