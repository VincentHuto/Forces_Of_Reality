package com.huto.forcesofreality.objects.tileenties.coven;

import com.huto.forcesofreality.init.TileEntityInit;

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
