package com.huto.forcesofreality.entities.projectiles;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.init.EntityInit;
import com.hutoslib.client.particle.ParticleColor;
import com.hutoslib.common.HutosLibPacketHandler;
import com.hutoslib.math.Vector3;

import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityShorting extends ThrowableEntity {
	public static EntityType<EntityShorting> TYPE = EntityInit.shorting.get();
	private static final String TAG_TIME = "time";
	private static final DataParameter<Boolean> EVIL = EntityDataManager.createKey(EntityShorting.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TARGET = EntityDataManager.createKey(EntityShorting.class,
			DataSerializers.VARINT);
	public static LivingEntity secondHandThrower;
	double lockX, lockY = -1, lockZ;
	int time = 0;

	public EntityShorting(EntityType<EntityShorting> type, World world) {
		super(type, world);
	}

	public EntityShorting(World world) {
		this(TYPE, world);
		setEvil(true);

	}

	public EntityShorting(World world, boolean evil) {
		this(TYPE, world);
		setEvil(evil);

	}

	public EntityShorting(LivingEntity thrower, boolean evil) {
		super(TYPE, thrower, thrower.world);
		setEvil(evil);
	}

	public EntityShorting(LivingEntity secondHandThrowerIn, World world) {
		this(TYPE, world);
		setEvil(false);
		secondHandThrower = secondHandThrowerIn;
	}

	@Override
	protected void registerData() {
		dataManager.register(EVIL, false);
		dataManager.register(TARGET, 0);
	}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setEvil(boolean evil) {
		dataManager.set(EVIL, evil);
	}

	public boolean isEvil() {
		return dataManager.get(EVIL);
	}

	public void setTarget(LivingEntity e) {
		dataManager.set(TARGET, e == null ? -1 : e.getEntityId());
	}

	public LivingEntity getTargetEntity() {
		int id = dataManager.get(TARGET);
		Entity e = world.getEntityByID(id);
		if (e != null && e instanceof LivingEntity)
			return (LivingEntity) e;

		return null;
	}

	@Override
	public void tick() {
		super.tick();

		if (!world.isRemote && (!findTarget() || time > 30)) {
			remove();
			return;
		}
		Random rand = new Random();
		Vector3 endVec = Vector3.fromEntityCenter(this).add(rand.nextInt(2) - rand.nextInt(2),
				rand.nextInt(2) - rand.nextInt(2), rand.nextInt(2) - rand.nextInt(2));
		Vector3d speedVec = new Vector3d(endVec.x, endVec.y, endVec.z);

		if (this.rand.nextInt(10) % 3 == 0) {
			HutosLibPacketHandler.sendLightningSpawn(this.getPositionVec().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					(RegistryKey<World>) this.world.getDimensionKey(), ParticleColor.YELLOW, 2, 10, 9, 0.2f);
		}

		boolean evil = isEvil();
		Vector3 thisVec = Vector3.fromEntityCenter(this);

		LivingEntity target = getTargetEntity();
		if (target != null) {
			if (lockY == -1) {
				lockX = target.getPosX();
				lockY = target.getPosY();
				lockZ = target.getPosZ();
			}

			Vector3 targetVec = evil ? new Vector3(lockX, lockY, lockZ) : Vector3.fromEntityCenter(target);
			Vector3 diffVec = targetVec.subtract(thisVec);
			Vector3 motionVec = diffVec.normalize().multiply(evil ? 0.5 : 0.6);
			setMotion(motionVec.toVector3d());
			if (time < 10)
				setMotion(getMotion().getX(), Math.abs(getMotion().getY()), getMotion().getZ());
			List<LivingEntity> targetList = world.getEntitiesWithinAABB(LivingEntity.class,
					new AxisAlignedBB(getPosX() - 0.5, getPosY() - 0.5, getPosZ() - 0.5, getPosX() + 0.5,
							getPosY() + 0.5, getPosZ() + 0.5));
			if (targetList.contains(target)) {
				LivingEntity thrower = secondHandThrower;
				if (thrower != null) {
					PlayerEntity player = thrower instanceof PlayerEntity ? (PlayerEntity) thrower : null;
					if (thrower != null)
						target.attackEntityFrom(player == null ? DamageSource.causeMobDamage(thrower)
								: DamageSource.causePlayerDamage(player), evil ? 12 : 7);

				} else
					target.attackEntityFrom(DamageSource.GENERIC, evil ? 12 : 7);
				remove();
			}

			if (evil && diffVec.mag() < 0)
				remove();
		}

		time++;
	}

	@Override
	public void writeAdditional(CompoundNBT cmp) {
		super.writeAdditional(cmp);
		cmp.putInt(TAG_TIME, time);
	}

	@Override
	public void readAdditional(CompoundNBT cmp) {
		super.readAdditional(cmp);
		time = cmp.getInt(TAG_TIME);
	}

	public boolean findTarget() {
		LivingEntity target = getTargetEntity();
		if (target != null && target.isAlive() && target != func_234616_v_())
			return true;
		if (target != null)
			setTarget(null);

		double range = 5;
		AxisAlignedBB bounds = new AxisAlignedBB(getPosX() - range, getPosY() - range, getPosZ() - range,
				getPosX() + range, getPosY() + range, getPosZ() + range);
		@SuppressWarnings("rawtypes")
		List entities = world.getEntitiesWithinAABBExcludingEntity(secondHandThrower, bounds);
		if (entities.contains(this.func_234616_v_())) {
			entities.remove(this.func_234616_v_());
		}
		while (entities.size() > 0) {
			Entity e = (Entity) entities.get(world.rand.nextInt(entities.size()));
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
	protected void onImpact(@Nonnull RayTraceResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			Block block = world.getBlockState(((BlockRayTraceResult) pos).getPos()).getBlock();
			if (!(block instanceof BushBlock) && !(block instanceof LeavesBlock))
				remove();
			break;
		}
		case ENTITY: {
			if (((EntityRayTraceResult) pos).getEntity() == getTargetEntity()) {
				((EntityRayTraceResult) pos).getEntity().attackEntityFrom(DamageSource.GENERIC, 2f);
				remove();

			}
			remove();
			break;
		}
		default: {
			remove();
			break;
		}
		}
	}

}