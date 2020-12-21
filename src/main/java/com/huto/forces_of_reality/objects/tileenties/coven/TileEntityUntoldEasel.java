package com.huto.forces_of_reality.objects.tileenties.coven;

import com.huto.forces_of_reality.capabilities.covenant.EnumCovenants;
import com.huto.forces_of_reality.init.TileEntityInit;

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
