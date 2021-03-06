package com.huto.forcesofreality.objects.tileenties.coven;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilities.tiledevotion.DevotionProvider;
import com.huto.forcesofreality.capabilities.tiledevotion.IDevotion;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileModDevotion extends TileEntity {

	public IDevotion devo = getCapability(DevotionProvider.DEVO_CAPA).orElseThrow(IllegalStateException::new);
	public int clientDevo = 0;
	public static final String TAG_DEVO = "devotion";
	public static final String TAG_MODIFIER = "modifier";
	public int sacMod = 1;

	public TileModDevotion(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
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
		cmp.putInt(TAG_DEVO, devo.getDevotion());
		cmp.putInt(TAG_MODIFIER, sacMod);

	}

	public void readPacketNBT(CompoundNBT cmp) {
		clientDevo = cmp.getInt(TAG_DEVO);
		sacMod = cmp.getInt(TAG_MODIFIER);

	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT tag = new CompoundNBT();
		writePacketNBT(tag);
		CompoundNBT nbtTag = new CompoundNBT();
		nbtTag.putInt(TAG_DEVO, devo.getDevotion());
		nbtTag.putInt(TAG_MODIFIER, sacMod);

		return new SUpdateTileEntityPacket(pos, -999, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
		CompoundNBT tag = packet.getNbtCompound();
		super.onDataPacket(net, packet);
		readPacketNBT(packet.getNbtCompound());
		clientDevo = tag.getInt(TAG_DEVO);
		sacMod = tag.getInt(TAG_MODIFIER);

	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		clientDevo = tag.getInt(TAG_DEVO);
		sacMod = tag.getInt(TAG_MODIFIER);

	}

	public EnumCovenants getCovenType() {
		return EnumCovenants.SELF;

	}

}
