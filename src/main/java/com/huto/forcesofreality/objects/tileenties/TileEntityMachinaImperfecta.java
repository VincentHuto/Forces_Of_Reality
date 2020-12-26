package com.huto.forcesofreality.objects.tileenties;

import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.objects.tileenties.coven.TileModDevotion;

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
