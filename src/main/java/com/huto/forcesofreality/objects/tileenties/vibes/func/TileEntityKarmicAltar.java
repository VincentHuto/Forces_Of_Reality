package com.huto.forcesofreality.objects.tileenties.vibes.func;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationProvider;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.objects.tileenties.util.IExportableTile;
import com.huto.forcesofreality.objects.tileenties.vibes.TileVibeSimpleInventory;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;
import com.hutoslib.client.particle.ParticleColor;
import com.hutoslib.common.PacketHandler;
import com.hutoslib.common.VanillaPacketDispatcher;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class TileEntityKarmicAltar extends TileVibeSimpleInventory implements ITickableTileEntity, IExportableTile {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	int cooldown = 0;
	final int SET_COOLDOWN_EVENT = 1;
	public float maxVibes = 500;
	public float clientVibes = 0.0f;
	public final String TAG_SIZE = "tankSize";
	public static final String TAG_VIBES = "vibes";

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
		return !isVibeFull() ? true : false;
	}

	@Override
	public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
		if (cooldown > 0 || stack.getItem() == ItemInit.maker_activator.get() && !stack.getItem().isFood())
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
					this.receiveClientEvent(SET_COOLDOWN_EVENT, 60);
				}
				break;
			}

		if (did)
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
		return true;
	}

	public int count = 0;
	boolean consumed = false;

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		if (!world.isRemote) {
			world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2);
		}

		Random rand = new Random();
		double xpos = pos.getX() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * .3);
		double ypos = pos.getY() + 1.3;
		double zpos = pos.getZ() + 0.5 + ((rand.nextDouble() - rand.nextDouble()) * .3);
		int mod = 3 + rand.nextInt(10);

		// Grabs the item above the block

		List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class,
				new AxisAlignedBB(pos, pos.add(1, 1, 1)));
		for (ItemEntity item : items)
			if (item.isAlive() && !item.getItem().isEmpty() && item.getItem().isFood()) {
				ItemStack stack = item.getItem();
				addItem(null, stack, null);
				VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

			}

		// After the cooldown counter is done consume the item and add mana
		if (cooldown == 0) {
			if (itemHandler.getStackInSlot(0) != ItemStack.EMPTY) {
				sendUpdates();
				vibes.addVibes(30);
				itemHandler.setStackInSlot(0, ItemStack.EMPTY);
				VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
				world.addBlockEvent(getPos(), BlockInit.karmic_altar.get(), SET_COOLDOWN_EVENT, 60);
				this.receiveClientEvent(SET_COOLDOWN_EVENT, 60);

			}

		}

		count++;
		if (cooldown > 0) {
			if (count % 10 == 0) {
				count = 0;
				if (world.isRemote) {
					Vector3d vecabove = new Vector3d(getPos().getX(), getPos().getY(), getPos().getZ()).add(0.5, 0.5,
							0.5);
					Vector3d belowVec = new Vector3d(getPos().getX(), getPos().getY(), getPos().getZ());
					PacketHandler.sendLightningSpawn(vecabove, belowVec, 15f,
							(RegistryKey<World>) world.getDimensionKey(), ParticleColor.RED, 2, 10, 9, 0.2f);
					PacketHandler.sendLightningSpawn(vecabove, belowVec, 15f,
							(RegistryKey<World>) world.getDimensionKey(), ParticleColor.BLUE, 2, 10, 9, 0.2f);
				}
			}

		}

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
		if (vibes.getVibes() > 1 + rateIn) {
			this.vibes.subtractVibes(rateIn);
			exportToIn.vibes.addVibes(rateIn);
		}
	}

	@Override
	public boolean canExport() {
		if (vibes.getVibes() > 5) {
			return true;
		} else {
			return false;
		}
	}

	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getBlockState(), getBlockState());
		world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 3);
		markDirty();
	}

	// NBT data
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.merge(itemHandler.serializeNBT());
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_VIBES, vibes.getVibes());
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);

	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		super.getUpdatePacket();
		CompoundNBT nbtTag = new CompoundNBT();
		nbtTag.merge(itemHandler.serializeNBT());
		nbtTag.putFloat(TAG_SIZE, maxVibes);
		nbtTag.putFloat(TAG_VIBES, vibes.getVibes());
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}
}
