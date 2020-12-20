package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.coven.TileModDevotion;

import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityMachinaImperfecta extends TileModDevotion implements ITickableTileEntity {

	public TileEntityMachinaImperfecta() {
		super(TileEntityInit.machina_imperfecta.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.MACHINE;
	}
}
