package com.vincenthuto.forcesofreality.item.tool;

import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

public class NovaExplosion extends Explosion {

	public static final Comparator<ItemStack> ITEMSTACK_ASCENDING = (o1, o2) -> {
		if (o1.isEmpty() && o2.isEmpty()) {
			return 0;
		}
		if (o1.isEmpty()) {
			return 1;
		}
		if (o2.isEmpty()) {
			return -1;
		}
		if (o1.getItem() != o2.getItem()) {
			// Same item id
			return o1.getCount() - o2.getCount();
		}
		// Different id
		return Item.getId(o1.getItem()) - Item.getId(o2.getItem());
	};

	/**
	 * Compacts and sorts list of items, without regard for stack sizes
	 */
	public static void compactItemListNoStacksize(List<ItemStack> list) {
		for (int i = 0; i < list.size(); i++) {
			ItemStack s = list.get(i);
			if (!s.isEmpty()) {
				for (int j = i + 1; j < list.size(); j++) {
					ItemStack s1 = list.get(j);
					if (ItemHandlerHelper.canItemStacksStack(s, s1)) {
						s.grow(s1.getCount());
						list.set(j, ItemStack.EMPTY);
					}
				}
			}
		}
		list.removeIf(ItemStack::isEmpty);
		list.sort(ITEMSTACK_ASCENDING);
	}

	public static void createLootDrop(List<ItemStack> drops, Level world, BlockPos pos) {
		createLootDrop(drops, world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void createLootDrop(List<ItemStack> drops, Level world, double x, double y, double z) {
		if (!drops.isEmpty()) {
			compactItemListNoStacksize(drops);
			for (ItemStack drop : drops) {
				ItemEntity ent = new ItemEntity(world, x, y, z, drop);
				ent.setItem(drop);
				world.addFreshEntity(ent);
			}
		}
	}

	// Copies of private super fields
	private final Level world;

	private final Explosion.BlockInteraction mode;

	private final double x, y, z;

	private final float size;

	public NovaExplosion(Level world, @Nullable Entity entity, double x, double y, double z, float radius,
			boolean causesFire, Explosion.BlockInteraction mode) {
		super(world, entity, x, y, z, radius, causesFire, mode);
		this.world = world;
		this.mode = mode;
		this.size = radius;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// [VanillaCopy] super, but collecting all drops into one place, and no fire
	@Override
	public void finalizeExplosion(boolean spawnParticles) {
		world.playSound(null, x, y, z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0F,
				(1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.2F) * 0.7F);
		boolean differentMode = mode != Explosion.BlockInteraction.NONE;
		if (size >= 2.0F && differentMode) {
			world.addParticle(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 1.0D, 0.0D, 0.0D);
		} else {
			world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 1.0D, 0.0D, 0.0D);
		}

		NonNullList<ItemStack> allDrops = NonNullList.create();
		if (differentMode) {
			for (BlockPos pos : getToBlow()) {
				BlockState state = world.getBlockState(pos);
				Block block = state.getBlock();
				if (spawnParticles) {
					double d0 = pos.getX() + world.random.nextFloat();
					double d1 = pos.getY() + world.random.nextFloat();
					double d2 = pos.getZ() + world.random.nextFloat();
					double d3 = d0 - x;
					double d4 = d1 - y;
					double d5 = d2 - z;
					double d6 = Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5));
					d3 = d3 / d6;
					d4 = d4 / d6;
					d5 = d5 / d6;
					double d7 = 0.5D / (d6 / size + 0.1D);
					d7 = d7 * (world.random.nextFloat() * world.random.nextFloat() + 0.3F);
					d3 = d3 * d7;
					d4 = d4 * d7;
					d5 = d5 * d7;
					world.addParticle(ParticleTypes.POOF, (d0 + x) / 2.0D, (d1 + y) / 2.0D, (d2 + z) / 2.0D, d3, d4,
							d5);
					world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, d3, d4, d5);
				}

				if (!world.isEmptyBlock(pos)) {
					// Ensure we are immutable so that changing blocks doesn't act weird
					pos = pos.immutable();
					if (world instanceof ServerLevel && state.canDropFromExplosion(world, pos, this)) {
						BlockEntity BlockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
						LootContext.Builder builder = new LootContext.Builder((ServerLevel) world)
								.withRandom(world.random).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
								.withParameter(LootContextParams.TOOL, ItemStack.EMPTY)
								.withOptionalParameter(LootContextParams.BLOCK_ENTITY, BlockEntity);
						if (mode == Explosion.BlockInteraction.DESTROY) {
							builder.withParameter(LootContextParams.EXPLOSION_RADIUS, size);
						}

						// PE: Collect the drops we can, spawn the stuff we can't
						allDrops.addAll(state.getDrops(builder));
						state.spawnAfterBreak((ServerLevel) world, pos, ItemStack.EMPTY, differentMode);
					}
					world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
					block.wasExploded(world, pos, this);
				}
			}
		}

		// PE: Drop all together
		if (getSourceMob() == null) {
			createLootDrop(allDrops, world, x, y, z);
		} else {
			createLootDrop(allDrops, world, getSourceMob().blockPosition());
		}
	}
}