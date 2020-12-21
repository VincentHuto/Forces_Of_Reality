package com.huto.forces_of_reality.objects.tileenties.coven;

import com.huto.forces_of_reality.init.TileEntityInit;

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
