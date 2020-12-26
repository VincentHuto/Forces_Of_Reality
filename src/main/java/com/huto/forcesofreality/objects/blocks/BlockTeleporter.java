package com.huto.forcesofreality.objects.blocks;

import java.util.Optional;

import com.huto.forcesofreality.dimension.DimensionalPosition;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.items.ItemHarmonicImprint;
import com.huto.forcesofreality.objects.tileenties.TileEntityTeleporter;
import com.huto.forcesofreality.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BlockTeleporter extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Block.makeCuboidShape(-16, 0, -2, 32, 33, 18);
	private static final VoxelShape COLSHAPE_N = Block.makeCuboidShape(-16, 0, -2, 33, 32, 18);

	private static final VoxelShape SHAPE_E = Block.makeCuboidShape(-2, 0, -16, 18, 33, 32);
	private static final VoxelShape COLSHAPE_E = Block.makeCuboidShape(-2, 0, -16, 18, 33, 32);

	public BlockTeleporter(Properties properties) {
		super(properties);

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_E;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
		case NORTH:
			return COLSHAPE_N;
		case SOUTH:
			return COLSHAPE_N;
		case EAST:
			return COLSHAPE_E;
		case WEST:
			return COLSHAPE_E;
		default:
			return COLSHAPE_N;
		}
	}

	@Override
	public boolean collisionExtendsVertically(BlockState state, IBlockReader world, BlockPos pos,
			Entity collidingEntity) {
		return true;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player,
			Hand hand, BlockRayTraceResult result) {
		ItemStack stack = player.getHeldItemMainhand();
		boolean isRenamed = !I18n.format(stack.getDisplayName().getString())
				.equals(I18n.format(I18n.format(stack.getTranslationKey())));

		if (hand == Hand.OFF_HAND) {
			return ActionResultType.FAIL;
		}
		if (!world.isRemote && player instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			TileEntityTeleporter te = (TileEntityTeleporter) world.getTileEntity(pos);

			if (stack.getItem() instanceof ItemHarmonicImprint) {
				DimensionalPosition dp = DimensionalPosition.fromNBT(stack.getOrCreateTag().getCompound("LinkedPos"));
				te.setTeleportPosition(world, dp.getPosition(), dp.getDimension(), player);
				VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
				te.sendUpdates();
				if (isRenamed) {
					te.setTeleportName(I18n.format(stack.getDisplayName().getString()));
				} else {
					te.setTeleportName("Linked Position: "
							+ te.getTeleportPosition().orElseThrow(NullPointerException::new).getPosition()
									.getCoordinatesAsString()
							+ " In " + ModTextFormatting.toProperCase(te.getTeleportPosition()
									.orElseThrow(NullPointerException::new).getDimension().getPath()));

				}
			} else {
				if (!te.getTeleportPosition().isPresent()) {
					serverPlayer.sendStatusMessage(new TranslationTextComponent("No linked Position"), true);
				} else {
					serverPlayer.sendStatusMessage(new TranslationTextComponent(te.getTeleportName()), true);
				}
			}

			Optional<DimensionalPosition> lastPos = te.getTeleportPosition();
			if (serverPlayer.isSneaking()) {
				DimensionalPosition p = lastPos.get();
				BlockPos bp = p.getPosition();
				ResourceLocation dimRL = p.getDimension();
				RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimRL);
				ServerWorld ovw = world.getServer().getWorld(key);
				serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY() + 1, bp.getZ() + 0.5, serverPlayer.rotationYaw,
						serverPlayer.rotationPitch);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		 super.onEntityCollision(state, worldIn, pos, entityIn);
		if (!worldIn.isRemote && entityIn instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entityIn;
			TileEntityTeleporter te = (TileEntityTeleporter) worldIn.getTileEntity(pos);
			boolean foundOnHead = false;
			ItemStack slotItemStack = ((PlayerEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);
			if (slotItemStack.getItem() == ItemInit.mysterious_mask.get()) {
				foundOnHead = true;
			}
			if (foundOnHead) {
				if (!te.getTeleportPosition().isPresent()) {
					serverPlayer.sendStatusMessage(new TranslationTextComponent("No linked Position"), true);
				} else {
					serverPlayer.sendStatusMessage(new TranslationTextComponent(te.getTeleportName()), true);
					Optional<DimensionalPosition> lastPos = te.getTeleportPosition();
					if (!serverPlayer.isSneaking()) {
						DimensionalPosition p = lastPos.get();
						BlockPos bp = p.getPosition();
						ResourceLocation dimRL = p.getDimension();
						RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, dimRL);
						ServerWorld ovw = worldIn.getServer().getWorld(key);
						serverPlayer.teleport(ovw, bp.getX() + 0.5, bp.getY() + 1, bp.getZ() + 0.5,
								serverPlayer.rotationYaw, serverPlayer.rotationPitch);
					}
				}
			}
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
		// TODO Auto-generated method stub
		switch ((Direction) state.get(FACING)) {
		case NORTH:
			return COLSHAPE_N;
		case SOUTH:
			return COLSHAPE_N;
		case EAST:
			return COLSHAPE_E;
		case WEST:
			return COLSHAPE_E;
		default:
			return COLSHAPE_N;
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityTeleporter();
	}

}