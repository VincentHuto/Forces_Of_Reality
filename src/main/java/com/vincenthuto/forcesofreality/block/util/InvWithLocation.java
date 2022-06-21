package com.vincenthuto.forcesofreality.block.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;

public class InvWithLocation {

	public final IItemHandler handler;
	public final Level world;
	public final BlockPos pos;

	public InvWithLocation(IItemHandler itemHandler, Level world, BlockPos pos) {
		handler = itemHandler;
		this.world = world;
		this.pos = pos;
	}

	@Override
	public int hashCode() {
		return 31 * handler.hashCode() ^ world.hashCode() ^ pos.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof InvWithLocation && handler.equals(((InvWithLocation) o).handler)
				&& world == ((InvWithLocation) o).world && pos.equals(((InvWithLocation) o).pos);
	}

}
