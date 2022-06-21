package com.vincenthuto.forcesofreality.entity.projectile;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Predicates;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraftforge.network.NetworkHooks;

public class EntityCorruptNote extends ThrowableProjectile {
	public static EntityType<EntityCorruptNote> TYPE = EntityInit.corrupt_note.get();

	private static final String TAG_TIME = "time";
	private static final EntityDataAccessor<Boolean> EVIL = SynchedEntityData.defineId(EntityCorruptNote.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> TARGET = SynchedEntityData.defineId(EntityCorruptNote.class,
			EntityDataSerializers.INT);

	double lockX, lockY = -1, lockZ;
	int time = 0;

	public EntityCorruptNote(EntityType<EntityCorruptNote> type, Level world) {
		super(type, world);
	}

	public EntityCorruptNote(Level world) {
		this(TYPE, world);
	}

	public EntityCorruptNote(LivingEntity thrower, boolean evil) {
		super(TYPE, thrower, thrower.level);
		setEvil(evil);
	}

	@Override
	protected void defineSynchedData() {
		entityData.define(EVIL, false);
		entityData.define(TARGET, 0);
	}

	@Nonnull
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setEvil(boolean evil) {
		entityData.set(EVIL, evil);
	}

	public boolean isEvil() {
		return entityData.get(EVIL);
	}

	public void setTarget(LivingEntity e) {
		entityData.set(TARGET, e == null ? -1 : e.getId());
	}

	public LivingEntity getTargetEntity() {
		int id = entityData.get(TARGET);
		Entity e = level.getEntity(id);
		if (e != null && e instanceof LivingEntity)
			return (LivingEntity) e;

		return null;
	}

	@Override
	public void tick() {
		double lastTickPosX = this.xOld;
		double lastTickPosY = this.yOld;
		double lastTickPosZ = this.zOld;

		super.tick();

		if (!level.isClientSide && (!findTarget() || time > 40)) {
			remove(RemovalReason.KILLED);
			return;
		}

		boolean evil = isEvil();
		Vector3 thisVec = Vector3.fromEntityCenter(this);
		Vector3 oldPos = new Vector3(lastTickPosX, lastTickPosY, lastTickPosZ);
		Vector3 diff = thisVec.subtract(oldPos);
		Vector3 step = diff.normalize().multiply(0.05);
		int steps = (int) (diff.mag() / step.mag());
		Vector3 particlePos = oldPos;

		for (int i = 0; i < steps; i++) {
			level.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, particlePos.x, particlePos.y, particlePos.z, 0, 0,
					0);
			if (level.random.nextInt(steps) <= 1)
				level.addParticle(ParticleTypes.NOTE, particlePos.x + (Math.random() - 0.5) * 0.4,
						particlePos.y + (Math.random() - 0.5) * 0.4, particlePos.z + (Math.random() - 0.5) * 0.4, 0.3,
						0, 0);

			particlePos = particlePos.add(step);
		}

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
			List<LivingEntity> targetList = level.getEntitiesOfClass(LivingEntity.class,
					new AABB(getX() - 0.5, getY() - 0.5, getZ() - 0.5, getX() + 0.5, getY() + 0.5, getZ() + 0.5));
			if (targetList.contains(target)) {
				LivingEntity thrower = (LivingEntity) getOwner();
				if (thrower != null) {
					Player player = thrower instanceof Player ? (Player) thrower : null;
					target.hurt(player == null ? DamageSource.mobAttack(thrower) : DamageSource.playerAttack(player),
							evil ? 12 : 7);
				} else
					target.hurt(DamageSource.GENERIC, evil ? 12 : 7);

				remove(RemovalReason.KILLED);
			}

			if (evil && diffVec.mag() < 0)
				remove(RemovalReason.KILLED);
		}

		time++;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_TIME, time);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag cmp) {
		super.readAdditionalSaveData(cmp);
		time = cmp.getInt(TAG_TIME);
	}

	public boolean findTarget() {
		LivingEntity target = getTargetEntity();
		if (target != null && target.isAlive())
			return true;
		if (target != null)
			setTarget(null);

		double range = 20;
		AABB bounds = new AABB(getX() - range, getY() - range, getZ() - range, getX() + range, getY() + range,
				getZ() + range);
		@SuppressWarnings("rawtypes")
		List entities;
		if (isEvil()) {
			entities = level.getEntitiesOfClass(Player.class, bounds);
		} else {
			entities = level.getEntitiesOfClass(Entity.class, bounds, (Predicates.instanceOf(LivingEntity.class)));
			if (entities.contains(this.getOwner())) {
				entities.remove(this.getOwner());
			}
		}
		while (entities.size() > 0) {
			Entity e = (Entity) entities.get(level.random.nextInt(entities.size()));
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

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			Block block = level.getBlockState(((BlockHitResult) pos).getBlockPos()).getBlock();
			if (!(block instanceof BushBlock) && !(block instanceof LeavesBlock))
				remove(RemovalReason.KILLED);
			break;
		}
		case ENTITY: {
			if (((EntityHitResult) pos).getEntity() == getTargetEntity())
				remove(RemovalReason.KILLED);
			break;
		}
		default: {
			remove(RemovalReason.KILLED);
			break;
		}
		}
	}

}