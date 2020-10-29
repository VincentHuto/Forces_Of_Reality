package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAuspiciousBundle extends TileEntity implements ITickableTileEntity {

	public TileEntityAuspiciousBundle() {
		super(TileEntityInit.auspicious_bundle.get());
	}

	@Override
	public void tick() {
	}

}
