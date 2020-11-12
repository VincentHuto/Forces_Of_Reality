package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.init.TileEntityInit;

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
