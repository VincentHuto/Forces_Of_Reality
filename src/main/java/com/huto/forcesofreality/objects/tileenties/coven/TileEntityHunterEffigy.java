package com.huto.forcesofreality.objects.tileenties.coven;

import java.util.List;

import com.huto.forcesofreality.entities.guardians.EntityTheFirstBeast;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;

public class TileEntityHunterEffigy extends TileEntity implements ITickableTileEntity {
	public int sacrifices = 0;
	public static final String TAG_SACR = "sacrifices_made";

	public TileEntityHunterEffigy() {
		super(TileEntityInit.hunter_effigy.get());
	}

	@Override
	public void tick() {
		List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, getRenderBoundingBox().grow(0.5));
		for (ItemEntity itemEnt : items)
			if (itemEnt.isAlive() && !itemEnt.getItem().isEmpty()) {
				ItemStack stack = itemEnt.getItem();
				System.out.println(itemEnt);

				if (stack.getItem() == ItemInit.unkept_hide.get()) {
					itemEnt.remove();
					if (!world.isRemote) {

						for (int i = 0; i < 10; i++) {
							double d0 = itemEnt.getPosX() + 0.5;
							double d1 = itemEnt.getPosY();
							double d2 = itemEnt.getPosZ() + 0.5;
							((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, d0, d1, d2, 2,
									(world.rand.nextFloat() * 1 - 0.5) / 3, (world.rand.nextFloat() * 1 - 0.5) / 3,
									(world.rand.nextFloat() * 1 - 0.5) / 3, 0.1f);
						}
						if (getSacrifices() < 5) {
							sacrifices++;
						} else {
							world.playSound(getPos().getX(), getPos().getY(), getPos().getZ(),
									SoundEvents.ENTITY_WOLF_GROWL, SoundCategory.BLOCKS, 1, 1, false);
							world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Explosion.Mode.NONE);
							EntityTheFirstBeast summon = new EntityTheFirstBeast(EntityInit.the_first_beast.get(),
									world);
							summon.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
							world.addEntity(summon);
							setSacrifices(0);
						}
					}
				}
			}
	}

	public int getSacrifices() {
		return sacrifices;
	}

	public void setSacrifices(int sacrifices) {
		this.sacrifices = sacrifices;
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		sacrifices = nbt.getInt(TAG_SACR);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		CompoundNBT ret = super.write(compound);
		compound.putInt(TAG_SACR, sacrifices);
		return ret;
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT tag = new CompoundNBT();
		tag.putInt(TAG_SACR, sacrifices);
		return new SUpdateTileEntityPacket(pos, -999, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
		CompoundNBT tag = packet.getNbtCompound();
		super.onDataPacket(net, packet);
		sacrifices = tag.getInt(TAG_SACR);

	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		sacrifices = tag.getInt(TAG_SACR);

	}

}
