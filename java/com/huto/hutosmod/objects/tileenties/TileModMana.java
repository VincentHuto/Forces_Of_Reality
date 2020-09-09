package com.huto.hutosmod.objects.tileenties;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileModMana extends TileEntity {
	public TileModMana(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	float manaValue = 0.0F;
	float maxMana = 0.0F;

	public float getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(float maxMana) {
		this.maxMana = maxMana;
	}

	public float getManaValue() {
		return manaValue;
	}

	public void setManaValue(float manaValue) {
		this.manaValue = manaValue;
	}

	public void addManaValue(float manaValue) {
		this.manaValue += manaValue;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		CompoundNBT ret = super.write(compound);
		writePacketNBT(ret);
		return ret;
	}

	private boolean isVanilla = getClass().getName().startsWith("net.minecraft.");

	public boolean shouldRefresh(World world, BlockPos pos, BlockState oldState, BlockState newSate) {
		return isVanilla ? (oldState.getBlock() != newSate.getBlock()) : oldState != newSate;
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		readPacketNBT(nbt);

	}

	@Nonnull
	@Override
	public final CompoundNBT getUpdateTag() {
		return write(new CompoundNBT());
	}

	public void writePacketNBT(CompoundNBT cmp) {
	}

	public void readPacketNBT(CompoundNBT cmp) {
	}

	@Override
	public final SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT tag = new CompoundNBT();
		writePacketNBT(tag);
		return new SUpdateTileEntityPacket(pos, -999, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
		super.onDataPacket(net, packet);
		readPacketNBT(packet.getNbtCompound());
	}

}
