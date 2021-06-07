package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityAscendantAltar extends TileModDevotion implements ITickableTileEntity {

	public TileEntityAscendantAltar() {
		super(TileEntityInit.ascendant_altar.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDANT;
	}
}
