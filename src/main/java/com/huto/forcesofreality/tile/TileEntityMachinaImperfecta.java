package com.huto.forcesofreality.tile;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.tile.coven.TileModDevotion;

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
