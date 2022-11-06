
package com.vincenthuto.forcesofreality.entity.projectile;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class EntityThrownAxe extends ThrowableProjectile implements ItemSupplier {
	private static final EntityDataAccessor<Integer> BOUNCES = SynchedEntityData.defineId(EntityThrownAxe.class,
			EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> FLARE = SynchedEntityData.defineId(EntityThrownAxe.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> AURIC = SynchedEntityData.defineId(EntityThrownAxe.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> RETURN_TO = SynchedEntityData.defineId(EntityThrownAxe.class,
			EntityDataSerializers.INT);
	private static final int MAX_BOUNCES = 16;
	private boolean bounced = false;
	private ItemStack stack = ItemStack.EMPTY;

	public EntityThrownAxe(EntityType<EntityThrownAxe> type, Level world) {
		super(type, world);
	}

	public EntityThrownAxe(LivingEntity e, Level world, ItemStack stack) {
		super(EntityInit.thrown_axe.get(), e, world);
		this.stack = stack.copy();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		if (!stack.isEmpty()) {
			compound.put("fly_stack", stack.save(new CompoundTag()));
		}
		compound.putBoolean("flare", isFire());
		compound.putBoolean("auric", isAuric());

	}

	@Override
	protected void defineSynchedData() {
		entityData.define(BOUNCES, 0);
		entityData.define(FLARE, false);
		entityData.define(AURIC, false);
		entityData.define(RETURN_TO, -1);
	}

	private void dropAndKill() {
		ItemStack stack = getItem();
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
		remove(RemovalReason.DISCARDED);
	}

	@Nonnull
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	private int getEntityToReturnTo() {
		return entityData.get(RETURN_TO);
	}

	@Override
	protected float getGravity() {
		return 100f;
	}

	@Nonnull
	@Override
	public ItemStack getItem() {
		return new ItemStack(ItemInit.auric_trick_axe.get());
	}

	private int getTimesBounced() {
		return entityData.get(BOUNCES);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	public boolean isAuric() {
		return entityData.get(AURIC);
	}

	public boolean isFire() {
		return entityData.get(FLARE);
	}

	private boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		if (isReturning()) {
			return;
		}

		switch (pos.getType()) {
		case BLOCK: {
			BlockHitResult rtr = (BlockHitResult) pos;
			Block block = level.getBlockState(rtr.getBlockPos()).getBlock();
			if (block instanceof BushBlock || block instanceof LeavesBlock) {
				Block.dropResources(block.defaultBlockState(), level, this.blockPosition());
				level.setBlock(rtr.getBlockPos(), Blocks.AIR.defaultBlockState(), 2);
				level.addParticle(ParticleTypes.POOF, rtr.getBlockPos().getX(), rtr.getBlockPos().getY(),
						rtr.getBlockPos().getZ(), 0, 1, 0);
				return;
			} else if (block.defaultBlockState().getMaterial() == Material.WOOD) {
				Block.dropResources(block.defaultBlockState(), level, this.blockPosition());
				level.setBlock(rtr.getBlockPos(), Blocks.AIR.defaultBlockState(), 2);
				level.addParticle(ParticleTypes.POOF, rtr.getBlockPos().getX(), rtr.getBlockPos().getY(),
						rtr.getBlockPos().getZ(), 0, 1, 0);
			}

			int bounces = getTimesBounced();
			if (bounces < MAX_BOUNCES) {
				Vector3 currentMovementVec = new Vector3(getDeltaMovement());
				Direction dir = rtr.getDirection();
				Vector3 normalVector = new Vector3(dir.getStepX(), dir.getStepY(), dir.getStepZ()).normalize();
				Vector3 movementVec = normalVector.multiply(-2 * currentMovementVec.dotProduct(normalVector))
						.add(currentMovementVec);

				setDeltaMovement(movementVec.toVec3());
				bounced = true;

				if (!level.isClientSide) {
					setTimesBounced(getTimesBounced() + 1);
				}
			}

			break;
		}
		case ENTITY: {
			EntityHitResult rtr = (EntityHitResult) pos;
			if (!level.isClientSide && rtr.getEntity() instanceof LivingEntity && rtr.getEntity() != getOwner()) {
				Entity thrower = getOwner();
				DamageSource src = DamageSource.GENERIC;
				if (thrower instanceof Player) {
					src = DamageSource.thrown(this, thrower);
				} else if (thrower instanceof LivingEntity) {
					src = DamageSource.mobAttack((LivingEntity) thrower);
				}
				rtr.getEntity().hurt(src, 12);
				if (isAuric()) {
					rtr.getEntity().setSecondsOnFire(5);
					rtr.getEntity().setGlowingTag(true);
				}
				if (isFire()) {
					rtr.getEntity().setSecondsOnFire(5);
				} else if (level.random.nextInt(3) == 0) {
					((LivingEntity) rtr.getEntity())
							.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
				}
			}

			break;
		}
		default:
			break;
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("fly_stack")) {
			stack = ItemStack.of(compound.getCompound("fly_stack"));
		}
		setFire(compound.getBoolean("flare"));
		setAuric(compound.getBoolean("auric"));

	}

	public void setAuric(boolean auric) {
		entityData.set(AURIC, auric);
	}

	private void setEntityToReturnTo(int entityID) {
		entityData.set(RETURN_TO, entityID);
	}

	public void setFire(boolean fire) {
		entityData.set(FLARE, fire);
	}

	private void setTimesBounced(int times) {
		entityData.set(BOUNCES, times);
	}

	@Override
	public void tick() {
		// Standard motion
		Vec3 old = getDeltaMovement();

		super.tick();

		if (!bounced) {
			// Reset the drag applied by super
			setDeltaMovement(old);
		}

		bounced = false;

		// Returning motion
		if (isReturning()) {
			Entity thrower = getOwner();
			if (thrower != null) {
				Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
				setDeltaMovement(motion.toVec3());
			}
		}

		// Client FX
		if (level.isClientSide && isFire()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				level.addParticle(ParticleTypes.CRIMSON_SPORE, getX() + r * (Math.random() - 0.5),
						getY() + r * (Math.random() - 0.5), getZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		} else if (level.isClientSide && !isFire() && !isAuric()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				level.addParticle(ParticleTypes.WARPED_SPORE, getX() + r * (Math.random() - 0.5),
						getY() + r * (Math.random() - 0.5), getZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		}
		if (level.isClientSide && isAuric()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				level.addParticle(ParticleTypes.DRIPPING_HONEY, getX() + r * (Math.random() - 0.5),
						getY() + r * (Math.random() - 0.5), getZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));

			}
		}

		// Server state control
		if (!level.isClientSide && (getTimesBounced() >= MAX_BOUNCES || tickCount > 30)) {
			Entity thrower = getOwner();
			if (thrower == null) {
				dropAndKill();
			} else {
				setEntityToReturnTo(thrower.getId());
				if (distanceToSqr(thrower) < 2) {
					dropAndKill();
				}
			}
		}
	}
}
