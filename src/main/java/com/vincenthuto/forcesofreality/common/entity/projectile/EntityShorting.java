package com.vincenthuto.forcesofreality.common.entity.projectile;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.common.network.HLPacketHandler;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class EntityShorting extends ThrowableProjectile {
	public static EntityType<EntityShorting> TYPE = EntityInit.shorting.get();
	private static final String TAG_TIME = "time";
	private static final EntityDataAccessor<Boolean> EVIL = SynchedEntityData.defineId(EntityShorting.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> TARGET = SynchedEntityData.defineId(EntityShorting.class,
			EntityDataSerializers.INT);
	public static LivingEntity secondHandThrower;
	double lockX, lockY = -1, lockZ;
	int time = 0;

	public EntityShorting(EntityType<EntityShorting> type, Level world) {
		super(type, world);
	}

	public EntityShorting(Level world) {
		this(TYPE, world);
		setEvil(true);

	}

	public EntityShorting(Level world, boolean evil) {
		this(TYPE, world);
		setEvil(evil);

	}

	public EntityShorting(LivingEntity thrower, boolean evil) {
		super(TYPE, thrower, thrower.level());
		setEvil(evil);
	}

	public EntityShorting(LivingEntity secondHandThrowerIn, Level world) {
		this(TYPE, world);
		setEvil(false);
		secondHandThrower = secondHandThrowerIn;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_TIME, time);
	}

	@Override
	protected void defineSynchedData() {
		entityData.define(EVIL, false);
		entityData.define(TARGET, 0);
	}

	public boolean findTarget() {
		LivingEntity target = getTargetEntity();
		if (target != null && target.isAlive() && target != getOwner())
			return true;
		if (target != null)
			setTarget(null);

		double range = 5;
		AABB bounds = new AABB(getX() - range, getY() - range, getZ() - range, getX() + range, getY() + range,
				getZ() + range);
		@SuppressWarnings("rawtypes")
		List entities = level().getEntities(secondHandThrower, bounds);
		if (entities.contains(this.getOwner())) {
			entities.remove(this.getOwner());
		}
		while (entities.size() > 0) {
			Entity e = (Entity) entities.get(level().random.nextInt(entities.size()));
			if (!(e instanceof LivingEntity) || !e.isAlive()) { // Just in case...
				entities.remove(e);
				continue;
			}

			target = (LivingEntity) e;
			setTarget(target);
			break;
		}

		return target != null;
	}

	@Nonnull
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public LivingEntity getTargetEntity() {
		int id = entityData.get(TARGET);
		Entity e = level().getEntity(id);
		if (e != null && e instanceof LivingEntity)
			return (LivingEntity) e;

		return null;
	}

	public boolean isEvil() {
		return entityData.get(EVIL);
	}

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			Block block = level().getBlockState(((BlockHitResult) pos).getBlockPos()).getBlock();
			if (!(block instanceof BushBlock) && !(block instanceof LeavesBlock))
				remove(RemovalReason.KILLED);
			break;
		}
		case ENTITY: {
			if (((EntityHitResult) pos).getEntity() == getTargetEntity()) {
				((EntityHitResult) pos).getEntity().hurt(getTargetEntity().damageSources().generic(), 2f);
				remove(RemovalReason.KILLED);

			}
			remove(RemovalReason.KILLED);
			break;
		}
		default: {
			remove(RemovalReason.KILLED);
			break;
		}
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag cmp) {
		super.readAdditionalSaveData(cmp);
		time = cmp.getInt(TAG_TIME);
	}

	public void setEvil(boolean evil) {
		entityData.set(EVIL, evil);
	}

	public void setTarget(LivingEntity e) {
		entityData.set(TARGET, e == null ? -1 : e.getId());
	}

	@Override
	public void tick() {
		super.tick();

		if (!level().isClientSide && (!findTarget() || time > 30)) {
			remove(RemovalReason.KILLED);
			return;
		}
		Random rand = new Random();
		Vector3 endVec = Vector3.fromEntityCenter(this).add(rand.nextInt(2) - rand.nextInt(2),
				rand.nextInt(2) - rand.nextInt(2), rand.nextInt(2) - rand.nextInt(2));
		Vec3 speedVec = new Vec3(endVec.x, endVec.y, endVec.z);

		if (this.random.nextInt(10) % 3 == 0) {
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level().dimension(), ParticleColor.YELLOW, 2, 10, 9, 0.2f);
		}

		boolean evil = isEvil();
		Vector3 thisVec = Vector3.fromEntityCenter(this);

		LivingEntity target = getTargetEntity();
		if (target != null) {
			if (lockY == -1) {
				lockX = target.getX();
				lockY = target.getY();
				lockZ = target.getZ();
			}

			Vector3 targetVec = evil ? new Vector3(lockX, lockY, lockZ) : Vector3.fromEntityCenter(target);
			Vector3 diffVec = targetVec.subtract(thisVec);
			Vector3 motionVec = diffVec.normalize().multiply(evil ? 0.5 : 0.6);
			setDeltaMovement(motionVec.toVec3());
			if (time < 10)
				setDeltaMovement(getDeltaMovement().x(), Math.abs(getDeltaMovement().y()), getDeltaMovement().z());
			List<LivingEntity> targetList = level().getEntitiesOfClass(LivingEntity.class,
					new AABB(getX() - 0.5, getY() - 0.5, getZ() - 0.5, getX() + 0.5, getY() + 0.5, getZ() + 0.5));
			if (targetList.contains(target)) {
				LivingEntity thrower = secondHandThrower;
				if (thrower != null) {
					Player player = thrower instanceof Player ? (Player) thrower : null;
					if (thrower != null)
						target.hurt(
								player == null ? thrower.damageSources().mobAttack(thrower) : player.damageSources().playerAttack(player),
								evil ? 12 : 7);

				} else
					target.hurt(target.damageSources().generic(), evil ? 12 : 7);
				remove(RemovalReason.KILLED);
			}

			if (evil && diffVec.mag() < 0)
				remove(RemovalReason.KILLED);
		}

		time++;
	}

}