package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.world.level.block.entity.TickableBlockEntity;

public class TileEntityUntoldEasel extends TileModDevotion implements TickableBlockEntity {

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
