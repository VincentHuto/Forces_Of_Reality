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
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.ItemHandlerHelper;

public class ToolVeinPickaxe extends PickaxeItem {

	public ToolVeinPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

/*	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player,
			@Nonnull Hand hand) {
		ItemStack stack = player.getHeldItem(hand);
		return actionResultFromType(mineOreVeinsInAOE(player, hand), stack);

	}*/
	
	/**
	 * Mines all ore veins in a Box around the player.
	 */
	public static ActionResultType mineOreVeinsInAOE(PlayerEntity player, Hand hand) {

		World world = player.getEntityWorld();
		ItemStack stack = player.getHeldItem(hand);
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos pos : getPositionsFromBox(player.getBoundingBox().grow(8))) {
			if (world.isAirBlock(pos)) {
				continue;
			}
			BlockState state = world.getBlockState(pos);
			if (ItemHelper.isOre(state) && state.getBlockHardness(world, pos) != -1 && stack.canHarvestBlock(state)) {
				if (world.isRemote) {
					return ActionResultType.SUCCESS;
				}
				// Ensure we are immutable so that changing blocks doesn't act weird
				if (harvestVein(world, player, stack, pos.toImmutable(), state.getBlock(), drops, 0) > 0) {
					hasAction = true;
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, player.getPosX(), player.getPosY(), player.getPosZ());
			PlayerHelper.swingItem(player, hand);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}


	public static ActionResult<ItemStack> actionResultFromType(ActionResultType type, ItemStack stack) {
		switch (type) {
		case SUCCESS:
			return ActionResult.resultSuccess(stack);
		case CONSUME:
			return ActionResult.resultConsume(stack);
		case FAIL:
			return ActionResult.resultFail(stack);
		case PASS:
		default:
			return ActionResult.resultPass(stack);
		}
	}

	@Nonnull
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity player = context.getPlayer();

		BlockPos pos = context.getPos();
		if (isOre(context.getWorld().getBlockState(pos))) {
			return tryVeinMine(context.getHand(), player, pos, context.getFace());
		}
		return ActionResultType.PASS;
	}

	/**
	 * Scans and harvests an ore vein.
	 */
	public static ActionResultType tryVeinMine(Hand hand, PlayerEntity player, BlockPos pos, Direction sideHit) {

		World world = player.getEntityWorld();
		ItemStack stack = player.getHeldItem(hand);
		BlockState target = world.getBlockState(pos);
		if (target.getBlockHardness(world, pos) <= -1 || !stack.canHarvestBlock(target)) {
			return ActionResultType.FAIL;
		}
		boolean hasAction = false;
		List<ItemStack> drops = new ArrayList<>();
		for (BlockPos newPos : getPositionsFromBox(getBroadDeepBox(pos, sideHit, 8))) {
			if (!world.isAirBlock(newPos)) {
				BlockState state = world.getBlockState(newPos);
				if (target.getBlock() == state.getBlock()) {
					if (world.isRemote) {
						return ActionResultType.SUCCESS;
					}
					// Ensure we are immutable so that changing blocks doesn't act weird
					if (harvestVein(world, player, stack, newPos.toImmutable(), state.getBlock(), drops, 0) > 0) {
						hasAction = true;
					}
				}
			}
		}
		if (hasAction) {
			createLootDrop(drops, world, pos);
			world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_STONE_BREAK,
					SoundCategory.PLAYERS, 1.0F, 1.0F);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.PASS;
	}

	/**
	 * Gets an AABB for AOE digging operations. The offset increases both the
	 * breadth and depth of the box.
	 */
	public static AxisAlignedBB getBroadDeepBox(BlockPos pos, Direction direction, int offset) {
		switch (direction) {
		case EAST:
			return new AxisAlignedBB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX(),
					pos.getY() + offset, pos.getZ() + offset);
		case WEST:
			return new AxisAlignedBB(pos.getX(), pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
		case UP:
			return new AxisAlignedBB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY(), pos.getZ() + offset);
		case DOWN:
			return new AxisAlignedBB(pos.getX() - offset, pos.getY(), pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
		case SOUTH:
			return new AxisAlignedBB(pos.getX() - offset, pos.getY() - offset, pos.getZ() - offset, pos.getX() + offset,
					pos.getY() + offset, pos.getZ());
		case NORTH:
			return new AxisAlignedBB(pos.getX() - offset, pos.getY() - offset, pos.getZ(), pos.getX() + offset,
					pos.getY() + offset, pos.getZ() + offset);
		default:
			return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
		}
	}

	/**
	 * Recursively mines out a vein of the given Block, starting from the provided
	 * coordinates
	 */
	public static int harvestVein(World world, PlayerEntity player, ItemStack stack, BlockPos pos, Block target,
			List<ItemStack> currentDrops, int numMined) {
		if (numMined >= 250) {
			return numMined;
		}
		AxisAlignedBB b = new AxisAlignedBB(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1,
				pos.getY() + 1, pos.getZ() + 1);
		for (BlockPos currentPos : getPositionsFromBox(b)) {
			BlockState currentState = world.getBlockState(currentPos);
			if (currentState.getBlock() == target) {
				// Ensure we are immutable so that changing blocks doesn't act weird
				currentPos = currentPos.toImmutable();
				if (PlayerHelper.hasBreakPermission((ServerPlayerEntity) player, currentPos)) {
					numMined++;
					currentDrops.addAll(Block.getDrops(currentState, (ServerWorld) world, currentPos,
							world.getTileEntity(currentPos), player, stack));
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



	public static boolean isOre(BlockState state) {
		return state.isIn(Tags.Blocks.ORES);
	}

	public static boolean isOre(Block b) {
		return Tags.Blocks.ORES.contains(b);
	}

	public static boolean isOre(Item i) {
		return isOre(Block.getBlockFromItem(i));
	}

}