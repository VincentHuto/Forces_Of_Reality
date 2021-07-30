package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.world.level.block.entity.TickableBlockEntity;

public class TileEntityAscendantAltar extends TileModDevotion implements TickableBlockEntity {

	public TileEntityAscendantAltar() {
		super(TileEntityInit.ascendant_altar.get());
	}

	@Override
	public void tick() {
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDANT;
	}
}
