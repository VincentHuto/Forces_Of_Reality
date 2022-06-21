
package com.vincenthuto.forcesofreality.block.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IActivatable {

	/**
	 * Called when the block is used by an activatpr. Note that the player parameter
	 * can be null if this function is called from a dispenser.
	 */
	public boolean onUsedByActivator(Player player, ItemStack stack, Level world, BlockPos pos, Direction face);

}
