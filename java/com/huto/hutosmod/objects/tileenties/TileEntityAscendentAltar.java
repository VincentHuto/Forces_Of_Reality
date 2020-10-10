package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAscendentAltar extends TileEntity implements ITickableTileEntity {

	public TileEntityAscendentAltar() {
		super(TileEntityInit.ascendent_altar.get());
	}

	@Override
	public void tick() {
	}

}
