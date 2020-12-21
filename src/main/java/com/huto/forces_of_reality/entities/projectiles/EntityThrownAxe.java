
package com.huto.forces_of_reality.entities.projectiles;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.entities.utils.Vector3;
import com.huto.forces_of_reality.init.EntityInit;
import com.huto.forces_of_reality.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class EntityThrownAxe extends ThrowableEntity implements IRendersAsItem {
	private static final DataParameter<Integer> BOUNCES = EntityDataManager.createKey(EntityThrownAxe.class,
			DataSerializers.VARINT);
	private static final DataParameter<Boolean> FLARE = EntityDataManager.createKey(EntityThrownAxe.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> AURIC = EntityDataManager.createKey(EntityThrownAxe.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(EntityThrownAxe.class,
			DataSerializers.VARINT);
	private static final int MAX_BOUNCES = 16;
	private boolean bounced = false;
	private ItemStack stack = ItemStack.EMPTY;

	public EntityThrownAxe(EntityType<EntityThrownAxe> type, World world) {
		super(type, world);
	}

	public EntityThrownAxe(LivingEntity e, World world, ItemStack stack) {
		super(EntityInit.thrown_axe.get(), e, world);
		this.stack = stack.copy();
	}

	@Override
	protected void registerData() {
		dataManager.register(BOUNCES, 0);
		dataManager.register(FLARE, false);
		dataManager.register(AURIC, false);
		dataManager.register(RETURN_TO, -1);
	}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void tick() {
		// Standard motion
		Vector3d old = getMotion();

		super.tick();

		if (!bounced) {
			// Reset the drag applied by super
			setMotion(old);
		}

		bounced = false;

		// Returning motion
		if (isReturning()) {
			Entity thrower = func_234616_v_();
			if (thrower != null) {
				Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
				setMotion(motion.toVector3d());
			}
		}

		// Client FX
		if (world.isRemote && isFire()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				world.addParticle(ParticleTypes.CRIMSON_SPORE, getPosX() + r * (Math.random() - 0.5),
						getPosY() + r * (Math.random() - 0.5), getPosZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		} else if (world.isRemote && !isFire() && !isAuric()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				world.addParticle(ParticleTypes.WARPED_SPORE, getPosX() + r * (Math.random() - 0.5),
						getPosY() + r * (Math.random() - 0.5), getPosZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		}
		if (world.isRemote && isAuric()) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 3; i++) {
				world.addParticle(ParticleTypes.DRIPPING_HONEY, getPosX() + r * (Math.random() - 0.5),
						getPosY() + r * (Math.random() - 0.5), getPosZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));

			}
		}

		// Server state control
		if (!world.isRemote && (getTimesBounced() >= MAX_BOUNCES || ticksExisted > 30)) {
			Entity thrower = func_234616_v_();
			if (thrower == null) {
				dropAndKill();
			} else {
				setEntityToReturnTo(thrower.getEntityId());
				if (getDistanceSq(thrower) < 2) {
					dropAndKill();
				}
			}
		}
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		ItemEntity item = new ItemEntity(world, getPosX(), getPosY(), getPosZ(), stack);
		world.addEntity(item);
		remove();
	}

	private ItemStack getItemStack() {
		if (!stack.isEmpty()) {
			stack.copy();
		} else {
			if (isFire()) {
				return new ItemStack(ItemInit.null_trick_axe.get());
			} else if (isAuric()) {
				return new ItemStack(ItemInit.auric_trick_axe.get());
			} else {
				return new ItemStack(ItemInit.somnolent_trick_axe.get());
			}
		}
		return stack.copy();
	}

	@SuppressWarnings("static-access")
	@Override
	protected void onImpact(@Nonnull RayTraceResult pos) {
		if (isReturning()) {
			return;
		}

		switch (pos.getType()) {
		case BLOCK: {
			BlockRayTraceResult rtr = (BlockRayTraceResult) pos;
			Block block = world.getBlockState(rtr.getPos()).getBlock();
			if (block instanceof BushBlock || block instanceof LeavesBlock) {
				block.spawnDrops(block.getDefaultState(), world, this.getPosition());
				world.setBlockState(rtr.getPos(), Blocks.AIR.getDefaultState(), 2);
				world.addParticle(ParticleTypes.POOF, rtr.getPos().getX(), rtr.getPos().getY(), rtr.getPos().getZ(), 0,
						1, 0);
				return;
			} else if (block.getDefaultState().getMaterial() == Material.WOOD) {
				block.spawnDrops(block.getDefaultState(), world, this.getPosition());
				world.setBlockState(rtr.getPos(), Blocks.AIR.getDefaultState(), 2);
				world.addParticle(ParticleTypes.POOF, rtr.getPos().getX(), rtr.getPos().getY(), rtr.getPos().getZ(), 0,
						1, 0);
			}

			int bounces = getTimesBounced();
			if (bounces < MAX_BOUNCES) {
				Vector3 currentMovementVec = new Vector3(getMotion());
				Direction dir = rtr.getFace();
				Vector3 normalVector = new Vector3(dir.getXOffset(), dir.getYOffset(), dir.getZOffset()).normalize();
				Vector3 movementVec = normalVector.multiply(-2 * currentMovementVec.dotProduct(normalVector))
						.add(currentMovementVec);

				setMotion(movementVec.toVector3d());
				bounced = true;

				if (!world.isRemote) {
					setTimesBounced(getTimesBounced() + 1);
				}
			}

			break;
		}
		case ENTITY: {
			EntityRayTraceResult rtr = (EntityRayTraceResult) pos;
			if (!world.isRemote && rtr.getEntity() instanceof LivingEntity && rtr.getEntity() != func_234616_v_()) {
				Entity thrower = func_234616_v_();
				DamageSource src = DamageSource.GENERIC;
				if (thrower instanceof PlayerEntity) {
					src = DamageSource.causeThrownDamage(this, thrower);
				} else if (thrower instanceof LivingEntity) {
					src = DamageSource.causeMobDamage((LivingEntity) thrower);
				}
				rtr.getEntity().attackEntityFrom(src, 12);
				if (isAuric()) {
					rtr.getEntity().setFire(5);
					rtr.getEntity().setGlowing(true);
				}
				if (isFire()) {
					rtr.getEntity().setFire(5);
				} else if (world.rand.nextInt(3) == 0) {
					((LivingEntity) rtr.getEntity()).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 0));
				}
			}

			break;
		}
		default:
			break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 100f;
	}

	private int getTimesBounced() {
		return dataManager.get(BOUNCES);
	}

	private void setTimesBounced(int times) {
		dataManager.set(BOUNCES, times);
	}

	public boolean isFire() {
		return dataManager.get(FLARE);
	}

	public void setFire(boolean fire) {
		dataManager.set(FLARE, fire);
	}

	public boolean isAuric() {
		return dataManager.get(AURIC);
	}

	public void setAuric(boolean auric) {
		dataManager.set(AURIC, auric);
	}

	private boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	private void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (!stack.isEmpty()) {
			compound.put("fly_stack", stack.write(new CompoundNBT()));
		}
		compound.putBoolean("flare", isFire());
		compound.putBoolean("auric", isAuric());

	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("fly_stack")) {
			stack = ItemStack.read(compound.getCompound("fly_stack"));
		}
		setFire(compound.getBoolean("flare"));
		setAuric(compound.getBoolean("auric"));

	}

	@Nonnull
	@Override
	public ItemStack getItem() {
		return getItemStack();
	}
}
