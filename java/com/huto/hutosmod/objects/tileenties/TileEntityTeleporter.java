package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityTeleporter extends TileEntity {

	public TileEntityTeleporter() {
		super(TileEntityInit.teleporter.get());
	}

}
