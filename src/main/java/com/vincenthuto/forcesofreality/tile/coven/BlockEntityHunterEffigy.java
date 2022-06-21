package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityHunterEffigy extends BlockEntity {
	public int sacrifices = 0;
	public static final String TAG_SACR = "sacrifices_made";

	public BlockEntityHunterEffigy(BlockPos pos, BlockState state) {
		super(BlockEntityInit.hunter_effigy.get(), pos, state);
	}

//	@Override
//	public void tick() {
//		List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, getRenderBoundingBox().inflate(0.5));
//		for (ItemEntity itemEnt : items)
//			if (itemEnt.isAlive() && !itemEnt.getItem().isEmpty()) {
//				ItemStack stack = itemEnt.getItem();
//				if (stack.getItem() == ItemInit.unkept_hide.get()) {
//					itemEnt.remove(RemovalReason.KILLED);
//					if (!level.isClientSide) {
//
//						for (int i = 0; i < 10; i++) {
//							double d0 = itemEnt.getX() + 0.5;
//							double d1 = itemEnt.getY();
//							double d2 = itemEnt.getZ() + 0.5;
//							((ServerLevel) level).sendParticles(ParticleTypes.SMOKE, d0, d1, d2, 2,
//									(level.random.nextFloat() * 1 - 0.5) / 3, (level.random.nextFloat() * 1 - 0.5) / 3,
//									(level.random.nextFloat() * 1 - 0.5) / 3, 0.1f);
//						}
//						if (getSacrifices() < 5) {
//							sacrifices++;
//						} else {
//							level.playLocalSound(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(),
//									SoundEvents.WOLF_GROWL, SoundSource.BLOCKS, 1, 1, false);
//							level.explode(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 1.0F,
//									Explosion.BlockInteraction.NONE);
//							EntityTheFirstBeast summon = new EntityTheFirstBeast(EntityInit.the_first_beast.get(),
//									level);
//							summon.setPos(worldPosition.getX() + 0.5, worldPosition.getY() + 1.5,
//									worldPosition.getZ() + 0.5);
//							level.addFreshEntity(summon);
//							setSacrifices(0);
//						}
//					}
//				}
//			}
//	}

	public int getSacrifices() {
		return sacrifices;
	}

	public void setSacrifices(int sacrifices) {
		this.sacrifices = sacrifices;
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		sacrifices = tag.getInt(TAG_SACR);
	}


	
	@Override
	protected void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.putInt(TAG_SACR, sacrifices);

	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) {
		CompoundTag tag = packet.getTag();
		super.onDataPacket(net, packet);
		sacrifices = tag.getInt(TAG_SACR);

	}

	@Override
	public void handleUpdateTag(CompoundTag tag) {
		super.handleUpdateTag(tag);
		sacrifices = tag.getInt(TAG_SACR);

	}

}
