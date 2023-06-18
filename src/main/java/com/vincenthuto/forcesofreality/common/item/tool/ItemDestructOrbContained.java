package com.vincenthuto.forcesofreality.common.item.tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemDestructOrbContained extends Item {

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
				world.addFreshEntity(ent);
			}
		}
	}

	/**
	 * Returns in AABB that is always 3x3 orthogonal to the side hit, but varies in
	 * depth in the direction of the side hit
	 */
	public static AABB getDeepBox(BlockPos pos, Direction direction, int depth) {
		switch (direction) {
		case EAST:
			return new AABB(pos.getX() - depth, pos.getY() - 1, pos.getZ() - 1, pos.getX(), pos.getY() + 1,
					pos.getZ() + 1);
		case WEST:
			return new AABB(pos.getX(), pos.getY() - 1, pos.getZ() - 1, pos.getX() + depth, pos.getY() + 1,
					pos.getZ() + 1);
		case UP:
			return new AABB(pos.getX() - 1, pos.getY() - depth, pos.getZ() - 1, pos.getX() + 1, pos.getY(),
					pos.getZ() + 1);
		case DOWN:
			return new AABB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 1, pos.getY() + depth,
					pos.getZ() + 1);
		case SOUTH:
			return new AABB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - depth, pos.getX() + 1, pos.getY() + 1,
					pos.getZ());
		case NORTH:
			return new AABB(pos.getX() - 1, pos.getY() - 1, pos.getZ(), pos.getX() + 1, pos.getY() + 1,
					pos.getZ() + depth);
		default:
			return new AABB(0, 0, 0, 0, 0, 0);
		}
	}

	/**
	 * Wrapper around BlockPos.getAllInBox() with an AABB Note that this is
	 * inclusive of all positions in the AABB!
	 */
	public static Iterable<BlockPos> getPositionsFromBox(AABB box) {
		return getPositionsFromBox(BlockPos.containing(box.minX, box.minY, box.minZ),
				BlockPos.containing(box.maxX, box.maxY, box.maxZ));
	}

	/**
	 * Wrapper around BlockPos.getAllInBox()
	 */
	public static Iterable<BlockPos> getPositionsFromBox(BlockPos corner1, BlockPos corner2) {
		return () -> BlockPos.betweenClosedStream(corner1, corner2).iterator();
	}

	public ItemDestructOrbContained(Properties prop) {
		super(prop);
	}

	@Nonnull
	@Override
	public InteractionResult useOn(UseOnContext ctx) {
		Level world = ctx.getLevel();
		if (world.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		Player player = ctx.getPlayer();
		ItemStack stack = ctx.getItemInHand();
		int numRows = 20;
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos pos : getPositionsFromBox(getDeepBox(ctx.getClickedPos(), ctx.getClickedFace(), --numRows))) {
			if (world.isEmptyBlock(pos)) {
				continue;
			}
			BlockState state = world.getBlockState(pos);
			float hardness = state.getDestroySpeed(world, pos);
			if (hardness == -1.0F || hardness >= 50.0F) {
				continue;
			}

			hasAction = true;
			// Ensure we are immutable so that changing blocks doesn't act weird
			pos = pos.immutable();
			if (PlayerHelper.hasBreakPermission((ServerPlayer) player, pos)) {
				List<ItemStack> list = Block.getDrops(state, (ServerLevel) world, pos, world.getBlockEntity(pos),
						player, stack);
				drops.addAll(list);
				world.removeBlock(pos, false);
				if (world.random.nextInt(8) == 0) {
					((ServerLevel) world).sendParticles(
							world.random.nextBoolean() ? ParticleTypes.POOF : ParticleTypes.LARGE_SMOKE, pos.getX(),
							pos.getY(), pos.getZ(), 2, 0, 0, 0, 0.05);
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, ctx.getClickedPos());
			world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.STONE_BREAK,
					SoundSource.PLAYERS, 1.0F, 1.0F);
		}
		return InteractionResult.SUCCESS;
	}

}
