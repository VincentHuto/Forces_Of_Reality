package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DevotionalBlockEntity extends BlockEntity {

	//public IDevotion devo = getCapability(DevotionProvider.DEVO_CAPA).orElseThrow(IllegalStateException::new);
	public int clientDevo = 0;
	public static final String TAG_DEVO = "devotion";
	public static final String TAG_MODIFIER = "modifier";
	public int sacMod = 1;

	public DevotionalBlockEntity(BlockEntityType<?> BlockEntityTypeIn, BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityTypeIn, worldPosition, blockState);
	}

	@Override
	protected void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		writePacketNBT(pTag);
	}

	private boolean isVanilla = getClass().getName().startsWith("net.minecraft.");

	public boolean shouldRefresh(Level world, BlockPos pos, BlockState oldState, BlockState newSate) {
		return isVanilla ? (oldState.getBlock() != newSate.getBlock()) : oldState != newSate;
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		readPacketNBT(tag);

	}

	public void writePacketNBT(CompoundTag cmp) {
	//	cmp.putInt(TAG_DEVO, devo.getDevotion());
		cmp.putInt(TAG_MODIFIER, sacMod);

	}

	public void readPacketNBT(CompoundTag cmp) {
		clientDevo = cmp.getInt(TAG_DEVO);
		sacMod = cmp.getInt(TAG_MODIFIER);

	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
		CompoundTag tag = packet.getTag();
		super.onDataPacket(net, packet);
		readPacketNBT(packet.getTag());
		clientDevo = tag.getInt(TAG_DEVO);
		sacMod = tag.getInt(TAG_MODIFIER);

	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.handleUpdateTag(tag);
		clientDevo = tag.getInt(TAG_DEVO);
		sacMod = tag.getInt(TAG_MODIFIER);

	}

	public EnumCovenants getCovenType() {
		return EnumCovenants.SELF;

	}

}
