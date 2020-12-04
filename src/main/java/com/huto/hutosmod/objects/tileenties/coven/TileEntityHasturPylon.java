package com.huto.hutosmod.objects.tileenties.coven;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHasturPylon extends TileEntity implements ITickableTileEntity {

	public TileEntityHasturPylon() {
		super(TileEntityInit.hastur_pylon.get());
	}

	@Override
	public void tick() {
	
	}

}
