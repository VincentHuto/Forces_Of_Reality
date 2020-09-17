package com.huto.hutosmod.objects.items;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemDestructOrbContained extends Item {

	public ItemDestructOrbContained(Properties prop) {
		super(prop);
	}

	@Nonnull
	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		World world = ctx.getWorld();
		if (world.isRemote) {
			return ActionResultType.SUCCESS;
		}
		PlayerEntity player = ctx.getPlayer();
		ItemStack stack = ctx.getItem();
		int numRows = 20;
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos pos : getPositionsFromBox(getDeepBox(ctx.getPos(), ctx.getFace(), --numRows))) {
			if (world.isAirBlock(pos)) {
				continue;
			}
			BlockState state = world.getBlockState(pos);
			float hardness = state.getBlockHardness(world, pos);
			if (hardness == -1.0F || hardness >= 50.0F) {
				continue;
			}

			hasAction = true;
			// Ensure we are immutable so that changing blocks doesn't act weird
			pos = pos.toImmutable();
			if (PlayerHelper.hasBreakPermission((ServerPlayerEntity) player, pos)) {
				List<ItemStack> list = Block.getDrops(state, (ServerWorld) world, pos, world.getTileEntity(pos), player,
						stack);
				drops.addAll(list);
				world.removeBlock(pos, false);
				if (world.rand.nextInt(8) == 0) {
					((ServerWorld) world).spawnParticle(
							world.rand.nextBoolean() ? ParticleTypes.POOF : ParticleTypes.LARGE_SMOKE, pos.getX(),
							pos.getY(), pos.getZ(), 2, 0, 0, 0, 0.05);
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, ctx.getPos());
			world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_STONE_BREAK,
					SoundCategory.PLAYERS, 1.0F, 1.0F);
		}
		return ActionResultType.SUCCESS;
	}

	public static void createLootDrop(List<ItemStack> drops, World world, BlockPos pos) {
		createLootDrop(drops, world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void createLootDrop(List<ItemStack> drops, World world, double x, double y, double z) {
		if (!drops.isEmpty()) {
			compactItemListNoStacksize(drops);
			for (ItemStack drop : drops) {
				ItemEntity ent = new ItemEntity(world, x, y, z);
				ent.setItem(drop);
				world.addEntity(ent);
			}
		}
	}

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
		return Item.getIdFromItem(o1.getItem()) - Item.getIdFromItem(o2.getItem());
	};

	/**
	 * Wrapper around BlockPos.getAllInBox() with an AABB Note that this is
	 * inclusive of all positions in the AABB!
	 */
	public static Iterable<BlockPos> getPositionsFromBox(AxisAlignedBB box) {
		return getPositionsFromBox(new BlockPos(box.minX, box.minY, box.minZ),
				new BlockPos(box.maxX, box.maxY, box.maxZ));
	}

	/**
	 * Wrapper around BlockPos.getAllInBox()
	 */
	public static Iterable<BlockPos> getPositionsFromBox(BlockPos corner1, BlockPos corner2) {
		return () -> BlockPos.getAllInBox(corner1, corner2).iterator();
	}

	/**
	 * Returns in AABB that is always 3x3 orthogonal to the side hit, but varies in
	 * depth in the direction of the side hit
	 */
	public static AxisAlignedBB getDeepBox(BlockPos pos, Direction direction, int depth) {
		switch (direction) {
		case EAST:
			return new AxisAlignedBB(pos.getX() - depth, pos.getY() - 1, pos.getZ() - 1, pos.getX(), pos.getY() + 1,
					pos.getZ() + 1);
		case WEST:
			return new AxisAlignedBB(pos.getX(), pos.getY() - 1, pos.getZ() - 1, pos.getX() + depth, pos.getY() + 1,
					pos.getZ() + 1);
		case UP:
			return new AxisAlignedBB(pos.getX() - 1, pos.getY() - depth, pos.getZ() - 1, pos.getX() + 1, pos.getY(),
					pos.getZ() + 1);
		case DOWN:
			return new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 1, pos.getY() + depth,
					pos.getZ() + 1);
		case SOUTH:
			return new AxisAlignedBB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - depth, pos.getX() + 1, pos.getY() + 1,
					pos.getZ());
		case NORTH:
			return new AxisAlignedBB(pos.getX() - 1, pos.getY() - 1, pos.getZ(), pos.getX() + 1, pos.getY() + 1,
					pos.getZ() + depth);
		default:
			return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
		}
	}

}
