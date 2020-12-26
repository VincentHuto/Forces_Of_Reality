package com.huto.forcesofreality.objects.blocks.altars;

import java.util.stream.Stream;

import com.huto.forcesofreality.capabilities.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilities.covenant.ICovenant;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.objects.blocks.util.IBlockDevotionStation;
import com.huto.forcesofreality.objects.items.ItemSacrificial;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityAscendentAltar;
import com.huto.forcesofreality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forcesofreality.sounds.SoundHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class BlockAscendentAltar extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(0, 0, 1, 16, 1, 15), Block.makeCuboidShape(3, 1, 4, 13, 3, 12),
					Block.makeCuboidShape(3, 11, 4, 13, 13, 12), Block.makeCuboidShape(0, 13, 1, 16, 14, 15),
					Block.makeCuboidShape(1, 12, 14, 15, 13, 15), Block.makeCuboidShape(3, 1, 2, 13, 2, 4),
					Block.makeCuboidShape(3, 1, 12, 13, 2, 14), Block.makeCuboidShape(1, 12, 1, 15, 13, 2),
					Block.makeCuboidShape(13, 1, 2, 15, 2, 14), Block.makeCuboidShape(13, 12, 2, 16, 13, 14),
					Block.makeCuboidShape(1, 1, 2, 3, 2, 14), Block.makeCuboidShape(0, 12, 2, 3, 13, 14),
					Block.makeCuboidShape(9, 3, 6, 12, 11, 10), Block.makeCuboidShape(4, 3, 6, 7, 11, 10))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(1, 0, 0, 15, 1, 16), Block.makeCuboidShape(4, 1, 3, 12, 3, 13),
					Block.makeCuboidShape(4, 11, 3, 12, 13, 13), Block.makeCuboidShape(1, 13, 0, 15, 14, 16),
					Block.makeCuboidShape(14, 12, 1, 15, 13, 15), Block.makeCuboidShape(2, 1, 3, 4, 2, 13),
					Block.makeCuboidShape(12, 1, 3, 14, 2, 13), Block.makeCuboidShape(1, 12, 1, 2, 13, 15),
					Block.makeCuboidShape(2, 1, 1, 14, 2, 3), Block.makeCuboidShape(2, 12, 0, 14, 13, 3),
					Block.makeCuboidShape(2, 1, 13, 14, 2, 15), Block.makeCuboidShape(2, 12, 13, 14, 13, 16),
					Block.makeCuboidShape(6, 3, 4, 10, 11, 7), Block.makeCuboidShape(6, 3, 9, 10, 11, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockAscendentAltar(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntityAscendentAltar te = (TileEntityAscendentAltar) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause
		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(
						new StringTextComponent(
								TextFormatting.AQUA + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
						true);
			}
			if (worldIn.isRemote) {
				player.playSound(SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
			}
			return ActionResultType.SUCCESS;
		}

		if (stack.getItem() instanceof ItemSacrificial) {
			ItemSacrificial sac = (ItemSacrificial) stack.getItem();
			if (sac.getCoven() == te.getCovenType()) {
				if (worldIn.isRemote) {
					player.playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 0.6F, 0.8F);
					return ActionResultType.SUCCESS;
				} else {
					te.devo.addDevotion(sac.getDevoAmount());
					player.getHeldItemMainhand().shrink(1);
					coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);

					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
							new CovenantPacketServer(coven.getDevotion()));
					VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
					player.sendStatusMessage(
							new StringTextComponent(TextFormatting.GOLD + "Your offering was accepted"), true);
					return ActionResultType.SUCCESS;

				}
			} else {
				player.sendStatusMessage(new StringTextComponent(TextFormatting.RED + "Incorrect Offering Type"), true);
				if (worldIn.isRemote) {
					player.playSound(SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
				}
				return ActionResultType.FAIL;
			}

		} else {
			player.sendStatusMessage(new StringTextComponent(TextFormatting.DARK_RED + "Item is not an offering"),
					true);
			if (worldIn.isRemote) {
				player.playSound(SoundEvents.ITEM_LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
			}
			return ActionResultType.FAIL;

		}

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
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
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
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityAscendentAltar();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDENT;
	}

}
