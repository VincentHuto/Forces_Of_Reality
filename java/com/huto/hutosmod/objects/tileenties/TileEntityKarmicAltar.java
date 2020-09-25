package com.huto.hutosmod.objects.tileenties;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.IExportableTile;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityKarmicAltar extends TileVibeSimpleInventory implements ITickableTileEntity,IExportableTile {
	public static final String TAG_VIBES = "vibes";
	public float clientVibes = 0.0f;
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	int cooldown = 0;
	private  final int SET_COOLDOWN_EVENT = 1;
	float maxVibes = 500;

	public TileEntityKarmicAltar() {
		super(TileEntityInit.karmic_altar.get());
	}

	public IVibrations getVibeCap() {
		return vibes;
	}

	public float getMaxVibes() {
		return maxVibes;
	}
	public boolean canGenerate() {
		return  !isVibeFull() ? true : false;
	}


	@Override
	public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
		if (cooldown > 0 || stack.getItem() == ItemInit.maker_activator.get())
			return false;

		boolean did = false;

		for (int i = 0; i < getSizeInventory(); i++)
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				did = true;
				ItemStack stackToAdd = stack.copy();
				stackToAdd.setCount(1);
				itemHandler.setStackInSlot(i, stackToAdd);
				if (player == null || !player.abilities.isCreativeMode) {
					stack.shrink(1);
					VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
					this.receiveClientEvent(SET_COOLDOWN_EVENT, 90);
				}
				break;
			}

		if (did)
			System.out.println("add ITEM");
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
		return true;
	}

	public int count = 0;
	boolean consumed = false;

	@SuppressWarnings("unused")
	@Override

	public void tick() {
		Random rand = new Random();
		double xpos = pos.getX() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * .3);
		double ypos = pos.getY() + 1.3;
		double zpos = pos.getZ() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * .3);
		int mod = 3 + rand.nextInt(10);

		// Grabs the item above the block
		List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class,
				new AxisAlignedBB(pos, pos.add(1, 1, 1)));
		for (ItemEntity item : items)
			if (item.isAlive() && !item.getItem().isEmpty()) {
				ItemStack stack = item.getItem();
				addItem(null, stack, null);
			}

		if (cooldown == 0) {
			if (itemHandler.getStackInSlot(0) != ItemStack.EMPTY) {
				itemHandler.setStackInSlot(0, ItemStack.EMPTY);
				sendUpdates();
				vibes.addVibes(30);
				VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
				world.addBlockEvent(getPos(), BlockInit.karmic_altar.get(), SET_COOLDOWN_EVENT, 90);
				this.receiveClientEvent(SET_COOLDOWN_EVENT, 90);

			}

		}

		// System.out.println(cooldown);
		count++;
		if (cooldown > 0) {
			if (count % 10 == 0) {
				count = 0;
				if (world.isRemote) {
					world.addParticle(ParticleTypes.WARPED_SPORE, xpos, ypos, zpos, 0, 0, 0);

				}
			}
		}
		/*
		 * if (world.isRemote) { Vector3 vec = Vector3.fromTileEntityCenter(this);
		 * Vector3 endVec = vec.add(0, 2.5, 0); HutosMod.proxy.lightningFX(vec, endVec,
		 * 2F, 0x00948B, 0x00E4D7); }
		 */
		// Decement the cooldown
		if (cooldown > 0) {
			cooldown--;
		}
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	protected SimpleItemStackHandler createItemHandler() {
		return new SimpleItemStackHandler(this, false) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
	}

	public boolean isEmpty() {
		for (int i = 0; i < getSizeInventory(); i++)
			if (!itemHandler.getStackInSlot(i).isEmpty())
				return false;

		return true;
	}

	@Override
	public boolean receiveClientEvent(int id, int param) {
		if (id == SET_COOLDOWN_EVENT) {
			cooldown = param;
			return true;
		} else {
			return super.receiveClientEvent(id, param);
		}
	}

	public int getCooldown() {
		return cooldown;
	}
	public boolean isVibeFull() {
		return vibes.getVibes() < maxVibes ? false : true;
	}
	
	
	
	@Override
	public void exportToAbsorber(TileEntityAbsorber exportToIn, float rateIn) {
		if (!this.isVibeFull() && vibes.getVibes()>1) {
			this.vibes.subtractVibes(rateIn);
			exportToIn.vibes.addVibes(rateIn);
		}
	}

	@Override
	public boolean canExport() {
		return canGenerate();
	}
}
