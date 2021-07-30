package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TileEntityHasturPylon extends BlockEntity implements TickableBlockEntity {

	public TileEntityHasturPylon() {
		super(TileEntityInit.hastur_pylon.get());
	}

	@Override
	public void tick() {
	
	}

}
