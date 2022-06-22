package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.capa.tiledevotion.DevotionProvider;
import com.vincenthuto.forcesofreality.capa.tiledevotion.IDevotion;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DevotionalBlockEntity extends BlockEntity implements IDevotionalTile {

	public IDevotion devo = getCapability(DevotionProvider.DEVO_CAPA).orElseThrow(IllegalStateException::new);
	static final String TAG_DEVO = "devotion";
	public int clientDevo = 0;
	public static final String TAG_MODIFIER = "modifier";
	public int sacMod = 1;
	
	public DevotionalBlockEntity(BlockEntityType<?> BlockEntityTypeIn, BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityTypeIn, worldPosition, blockState);
	}

	public IDevotion getBloodCapability() {
		return devo;
	}

	public double getDevotion() {
		return devo.getDevotion();
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		if (tag != null) {
			devo.setDevotion(tag.getInt(TAG_DEVO));
		}

	}

	@Override
	public void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		if (tag != null) {
			tag.putDouble(TAG_DEVO, devo.getDevotion());
		}
	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.handleUpdateTag(tag);
		if (tag != null) {
			devo.setDevotion(tag.getInt(TAG_DEVO));
		}
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = new CompoundTag();
		tag.putDouble(TAG_DEVO, devo.getDevotion());
		return tag;
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		super.onDataPacket(net, pkt);
		if (pkt.getTag() != null) {
			CompoundTag tag = pkt.getTag();
			devo.setDevotion(tag.getInt(TAG_DEVO));
		}

	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);

	}

	private boolean isVanilla = getClass().getName().startsWith("net.minecraft.");

	public boolean shouldRefresh(Level world, BlockPos pos, BlockState oldState, BlockState newSate) {
		return isVanilla ? (oldState.getBlock() != newSate.getBlock()) : oldState != newSate;
	}

	public EnumCovenants getCovenType() {
		return EnumCovenants.SELF;

	}

}
