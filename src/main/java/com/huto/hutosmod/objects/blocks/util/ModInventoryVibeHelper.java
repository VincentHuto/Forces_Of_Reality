
package com.huto.hutosmod.objects.blocks.util;

import com.huto.hutosmod.objects.tileenties.vibes.TileVibeSimpleInventory;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class ModInventoryVibeHelper {

	public static InvWithLocation getInventoryWithLocation(World world, BlockPos pos) {
		IItemHandler ret = getInventory(world, pos);
		if(ret == null)
			return null;
		else return new InvWithLocation(ret, world, pos);
	}

	public static IItemHandler getInventory(World world, BlockPos pos) {
		TileEntity te = world.getTileEntity(pos);

		if(te == null)
			return null;

		IItemHandler ret = (IItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);


				return ret;
	}

	public static void dropInventory(TileVibeSimpleInventory inv, World world, BlockState state, BlockPos pos) {
		if(inv != null) {
			for(int j1 = 0; j1 < inv.getSizeInventory(); ++j1) {
				ItemStack itemstack = inv.getItemHandler().getStackInSlot(j1);

				if(!itemstack.isEmpty()) {
					net.minecraft.inventory.InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemstack);
				}
			}

			world.updateComparatorOutputLevel(pos, state.getBlock());
		}
	}

	public static void withdrawFromInventory(TileVibeSimpleInventory inv, PlayerEntity player) {
		for(int i = inv.getSizeInventory() - 1; i >= 0; i--) {
			ItemStack stackAt = inv.getItemHandler().getStackInSlot(i);
			if(!stackAt.isEmpty()) {
				ItemStack copy = stackAt.copy();
				ItemHandlerHelper.giveItemToPlayer(player, copy);
				inv.getItemHandler().setStackInSlot(i, ItemStack.EMPTY);
				player.world.updateComparatorOutputLevel(inv.getPos(), null);
				break;
			}
		}
	}

	public static void withdrawFromInventoryToInventory(TileVibeSimpleInventory inv, IItemHandler inventory) {
		for(int i = inv.getSizeInventory() - 1; i >= 0; i--) {
			ItemStack stackAt = inv.getItemHandler().getStackInSlot(i);
			if(!stackAt.isEmpty()) {
				//ItemStack copy = stackAt.copy();
				ItemHandlerHelper.insertItem(inventory, stackAt, false);
				inv.getItemHandler().setStackInSlot(i, ItemStack.EMPTY);
				break;
			}
		}
	}
}
