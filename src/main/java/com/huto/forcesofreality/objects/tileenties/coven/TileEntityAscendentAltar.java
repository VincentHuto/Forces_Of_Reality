package com.huto.forcesofreality.objects.tileenties.coven;

import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityAscendentAltar extends TileModDevotion implements ITickableTileEntity {

	public TileEntityAscendentAltar() {
		super(TileEntityInit.ascendent_altar.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDENT;
	}
}
