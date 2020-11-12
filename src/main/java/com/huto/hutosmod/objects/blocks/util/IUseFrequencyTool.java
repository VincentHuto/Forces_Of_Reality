
package com.huto.hutosmod.objects.blocks.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IUseFrequencyTool {

	/**
	 * Called when the block is used by an activatpr. Note that the player parameter
	 * can be null if this function is called from a dispenser.
	 */
	public boolean onUsedFrequency(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face);

}
