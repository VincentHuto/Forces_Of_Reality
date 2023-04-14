package com.vincenthuto.forcesofreality.item.tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.item.ItemHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolVeinPickaxe extends PickaxeItem {

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

	/*
	 * @Nonnull
	 *
	 * @Override public ActionResult<ItemStack> onItemRightClick(@Nonnull World
	 * world, @Nonnull PlayerEntity player,
	 *
	 * @Nonnull Hand hand) { ItemStack stack = player.getHeldItem(hand); return
	 * actionResultFromType(mineOreVeinsInAOE(player, hand), stack);
	 *
	 * }
	 */

	public static InteractionResultHolder<ItemStack> actionResultFromType(InteractionResult type, ItemStack stack) {
		switch (type) {
		case SUCCESS:
			return InteractionResultHolder.success(stack);
		case CONSUME:
			return InteractionResultHolder.consume(stack);
		case FAIL:
			return InteractionResultHolder.fail(stack);
		case PASS:
		default:
			return InteractionResultHolder.pass(stack);
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
	 * Gets an AABB for AOE digging operations. The offset increases both the
	 * breadth and depth of the box.
	 */
	public static AABB getBroadDeepBox(BlockPos pos, Direction direction, int offset) {
		switch (direction) {
		case EAST:
			return new AABB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX(),
					pos.getY() + offset, pos.getZ() + offset);
		case WEST:
			return new AABB(pos.getX(), pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
		case UP:
			return new AABB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY(), pos.getZ() + offset);
		case DOWN:
			return new AABB(pos.getX() - offset, pos.getY(), pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
		case SOUTH:
			return new AABB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ());
		case NORTH:
			return new AABB(pos.getX() - offset, pos.getY() - offset, pos.getZ(), pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
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

	/**
	 * Recursively mines out a vein of the given Block, starting from the provided
	 * coordinates
	 */
	public static int harvestVein(Level world, Player player, ItemStack stack, BlockPos pos, Block target,
			List<ItemStack> currentDrops, int numMined) {
		if (numMined >= 250) {
			return numMined;
		}
		AABB b = new AABB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1, pos.getY() + 1,
				pos.getZ() + 1);
		for (BlockPos currentPos : getPositionsFromBox(b)) {
			BlockState currentState = world.getBlockState(currentPos);
			if (currentState.getBlock() == target) {
				// Ensure we are immutable so that changing blocks doesn't act weird
				currentPos = currentPos.immutable();
				if (PlayerHelper.hasBreakPermission((ServerPlayer) player, currentPos)) {
					numMined++;
					currentDrops.addAll(Block.getDrops(currentState, (ServerLevel) world, currentPos,
							world.getBlockEntity(currentPos), player, stack));
					world.removeBlock(currentPos, false);
					numMined = harvestVein(world, player, stack, currentPos, target, currentDrops, numMined);
					if (numMined >= 250) {
						break;
					}
				}
			}
		}
		return numMined;
	}

	public static boolean isOre(Block b) {
		return ForgeRegistries.BLOCKS.tags().getTag(BlockTags.STONE_ORE_REPLACEABLES).contains(b)
				|| ForgeRegistries.BLOCKS.tags().getTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES).contains(b);
	}

	public static boolean isOre(BlockState state) {
		return state.is(Tags.Blocks.ORES);
	}

	public static boolean isOre(Item i) {
		return isOre(Block.byItem(i));
	}

	/**
	 * Mines all ore veins in a Box around the player.
	 */
	public static InteractionResult mineOreVeinsInAOE(Player player, InteractionHand hand) {

		Level world = player.getCommandSenderWorld();
		ItemStack stack = player.getItemInHand(hand);
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos pos : getPositionsFromBox(player.getBoundingBox().inflate(8))) {
			if (world.isEmptyBlock(pos)) {
				continue;
			}
			BlockState state = world.getBlockState(pos);
			if (ItemHelper.isOre(state) && state.getDestroySpeed(world, pos) != -1
					&& stack.isCorrectToolForDrops(state)) {
				if (world.isClientSide) {
					return InteractionResult.SUCCESS;
				}
				// Ensure we are immutable so that changing blocks doesn't act weird
				if (harvestVein(world, player, stack, pos.immutable(), state.getBlock(), drops, 0) > 0) {
					hasAction = true;
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, player.getX(), player.getY(), player.getZ());
			PlayerHelper.swingItem(player, hand);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	/**
	 * Scans and harvests an ore vein.
	 */
	public static InteractionResult tryVeinMine(InteractionHand hand, Player player, BlockPos pos, Direction sideHit) {

		Level world = player.getCommandSenderWorld();
		ItemStack stack = player.getItemInHand(hand);
		BlockState target = world.getBlockState(pos);
		if (target.getDestroySpeed(world, pos) <= -1 || !stack.isCorrectToolForDrops(target)) {
			return InteractionResult.FAIL;
		}
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos newPos : getPositionsFromBox(getBroadDeepBox(pos, sideHit, 8))) {
			if (!world.isEmptyBlock(newPos)) {
				BlockState state = world.getBlockState(newPos);
				if (target.getBlock() == state.getBlock()) {
					if (world.isClientSide) {
						return InteractionResult.SUCCESS;
					}
					// Ensure we are immutable so that changing blocks doesn't act weird
					if (harvestVein(world, player, stack, newPos.immutable(), state.getBlock(), drops, 0) > 0) {
						hasAction = true;
					}
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, pos);
			world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.STONE_BREAK,
					SoundSource.PLAYERS, 1.0F, 1.0F);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	public ToolVeinPickaxe(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Nonnull
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();

		BlockPos pos = context.getClickedPos();
		if (isOre(context.getLevel().getBlockState(pos))) {
			return tryVeinMine(context.getHand(), player, pos, context.getClickedFace());
		}
		return InteractionResult.PASS;
	}

}