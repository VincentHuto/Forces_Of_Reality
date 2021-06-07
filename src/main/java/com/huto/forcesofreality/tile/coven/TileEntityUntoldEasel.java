package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityUntoldEasel extends TileModDevotion implements ITickableTileEntity {

	public TileEntityUntoldEasel() {
		super(TileEntityInit.untold_easel.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.HASTUR;
	}
}
