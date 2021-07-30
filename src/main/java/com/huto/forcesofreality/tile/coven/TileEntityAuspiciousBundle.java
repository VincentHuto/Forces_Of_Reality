package com.huto.forcesofreality.tile.coven;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TileEntityAuspiciousBundle extends BlockEntity implements TickableBlockEntity {

	public TileEntityAuspiciousBundle() {
		super(TileEntityInit.auspicious_bundle.get());
	}

	@Override
	public void tick() {
	}

}
