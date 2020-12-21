package com.huto.forces_of_reality.objects.tileenties;

import com.huto.forces_of_reality.capabilities.covenant.EnumCovenants;
import com.huto.forces_of_reality.init.TileEntityInit;
import com.huto.forces_of_reality.objects.tileenties.coven.TileModDevotion;

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
