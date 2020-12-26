package com.huto.forcesofreality.objects.tileenties.coven;

import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
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
