package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.entities.guardians.EntityDarkYoung;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;
import com.huto.hutosmod.objects.blocks.util.IBlockDevotionStation;
import com.huto.hutosmod.objects.items.ItemSacrificial;
import com.huto.hutosmod.objects.tileenties.TileEntityOccularHeap;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class BlockOccularHeap extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(7, 10, 7, 9, 12, 9),
			Block.makeCuboidShape(2, 1, 6, 5, 3, 13), Block.makeCuboidShape(5, 1, 3, 8, 3, 14),
			Block.makeCuboidShape(8, 1, 2, 11, 3, 12), Block.makeCuboidShape(11, 1, 4, 14, 3, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 1, 15), Block.makeCuboidShape(9, 3, 6, 12, 5, 9),
			Block.makeCuboidShape(4, 3, 5, 7, 5, 13), Block.makeCuboidShape(7, 3, 9, 13, 5, 13),
			Block.makeCuboidShape(7, 3, 2, 10, 5, 6), Block.makeCuboidShape(6, 5, 4, 9, 7, 7),
			Block.makeCuboidShape(9, 5, 8, 12, 7, 11), Block.makeCuboidShape(10, 5, 10, 13, 6, 13),
			Block.makeCuboidShape(3, 5, 6, 7, 7, 9), Block.makeCuboidShape(5, 5, 9, 9, 7, 12),
			Block.makeCuboidShape(9, 5, 5, 13, 7, 8), Block.makeCuboidShape(3, 1, 4, 5, 2, 6),
			Block.makeCuboidShape(11, 1, 3, 13, 2, 4), Block.makeCuboidShape(9, 7, 7, 11, 9, 10),
			Block.makeCuboidShape(7, 7, 9, 9, 8, 11), Block.makeCuboidShape(5, 7, 5, 7, 8, 7),
			Block.makeCuboidShape(7, 7, 5, 11, 9, 7), Block.makeCuboidShape(5, 7, 7, 7, 9, 10),
			Block.makeCuboidShape(8.15, 8, 3.85, 11.15, 10, 6.85),
			Block.makeCuboidShape(9.15, 8, 6.85, 12.15, 10, 10.85),
			Block.makeCuboidShape(9.15, 10, 6.85, 11.15, 11, 8.85),
			Block.makeCuboidShape(7.15, 10, 8.85, 10.15, 12, 10.85),
			Block.makeCuboidShape(6.15, 8, 8.85, 9.15, 10, 12.85), Block.makeCuboidShape(5.15, 8, 2.85, 8.15, 10, 6.85),
			Block.makeCuboidShape(5.15, 10, 4.85, 7.15, 12, 8.85),
			Block.makeCuboidShape(7.15, 10, 4.85, 10.15, 12, 6.85),
			Block.makeCuboidShape(4.15, 8, 6.85, 7.15, 10, 9.85),
			Block.makeCuboidShape(5.15, 10, 8.85, 7.15, 11, 10.85), Block.makeCuboidShape(4, 4, 3, 6, 6, 5),
			Block.makeCuboidShape(3, 6, 9, 5, 8, 11), Block.makeCuboidShape(11, 3, 4, 13, 5, 6),
			Block.makeCuboidShape(10, 9, 4, 12, 11, 6), Block.makeCuboidShape(7, 12, 7, 9, 14, 9),
			Block.makeCuboidShape(10, 6, 11, 12, 8, 13)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(7.46, 10, 7.0, 9.46, 12, 9),
			Block.makeCuboidShape(6.46, 1, 11, 13.46, 3, 14), Block.makeCuboidShape(3.463, 1, 8, 14.46, 3, 11),
			Block.makeCuboidShape(2.463, 1, 5.0, 12.46, 3, 8), Block.makeCuboidShape(4.46, 1, 2.08, 15.46, 3, 5.0),
			Block.makeCuboidShape(1.463, 0, 1.08, 15.46, 1, 15), Block.makeCuboidShape(6.46, 3, 4.0, 9.46, 5, 7.0),
			Block.makeCuboidShape(5.46, 3, 9, 13.46, 5, 12), Block.makeCuboidShape(9.46, 3, 3.08, 13.46, 5, 9),
			Block.makeCuboidShape(2.463, 3, 6.0, 6.46, 5, 9), Block.makeCuboidShape(4.46, 5, 7.0, 7.46, 7, 10),
			Block.makeCuboidShape(8.46, 5, 4.0, 11.46, 7, 7.0), Block.makeCuboidShape(10.46, 5, 3.08, 13.46, 6, 6.0),
			Block.makeCuboidShape(6.46, 5, 9, 9.46, 7, 13), Block.makeCuboidShape(9.46, 5, 7.0, 12.46, 7, 11),
			Block.makeCuboidShape(5.46, 5, 3.08, 8.46, 7, 7.0), Block.makeCuboidShape(4.46, 1, 11, 6.46, 2, 13),
			Block.makeCuboidShape(3.463, 1, 3.08, 4.46, 2, 5.0), Block.makeCuboidShape(7.46, 7, 5.0, 10.46, 9, 7.0),
			Block.makeCuboidShape(9.46, 7, 7.0, 11.46, 8, 9), Block.makeCuboidShape(5.46, 7, 9, 7.46, 8, 11),
			Block.makeCuboidShape(5.46, 7, 5.0, 7.46, 9, 9), Block.makeCuboidShape(7.46, 7, 9, 10.46, 9, 11),
			Block.makeCuboidShape(4.4, 8, 4.8, 7.4, 10, 7.8), Block.makeCuboidShape(7.4, 8, 3.8, 11.4, 10, 6.8),
			Block.makeCuboidShape(7.4, 10, 4.8, 9.4, 11, 6.8), Block.makeCuboidShape(9.4, 10, 5.8, 11.4, 12, 8.8),
			Block.makeCuboidShape(9.4, 8, 6.8, 13.4, 10, 9.8), Block.makeCuboidShape(3.4, 8, 7.8, 7.4, 10, 10.8),
			Block.makeCuboidShape(5.4, 10, 8.8, 9.4, 12, 10.8), Block.makeCuboidShape(5.4, 10, 5.8, 7.4, 12, 8.8),
			Block.makeCuboidShape(7.4, 8, 8.8, 10.4, 10, 11.8), Block.makeCuboidShape(9.4, 10, 8.8, 11.4, 11, 10.8),
			Block.makeCuboidShape(3.463, 4, 10, 5.46, 6, 12), Block.makeCuboidShape(5.83, 6, 11.34, 7.83, 8, 13.34),
			Block.makeCuboidShape(7.94, 3, 2.15, 9.94, 5, 4.15), Block.makeCuboidShape(4.46, 9, 4.0, 6.46, 11, 6.0),
			Block.makeCuboidShape(7.46, 12, 7.0, 9.46, 14, 9), Block.makeCuboidShape(12.2, 6, 5.83, 14.2, 8, 7.83))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(7.46, 10, 6.54, 9.46, 12, 8.54),
			Block.makeCuboidShape(11.46, 1, 2.543, 14.46, 3, 9.54),
			Block.makeCuboidShape(8.46, 1, 1.543, 11.46, 3, 12.54),
			Block.makeCuboidShape(5.46, 1, 3.543, 8.46, 3, 13.54),
			Block.makeCuboidShape(2.463, 1, 0.543, 5.46, 3, 11.54),
			Block.makeCuboidShape(1.463, 0, 0.543, 15.46, 1, 14.54),
			Block.makeCuboidShape(4.46, 3, 6.54, 7.46, 5, 9.54), Block.makeCuboidShape(9.46, 3, 2.543, 12.46, 5, 10.54),
			Block.makeCuboidShape(3.463, 3, 2.543, 9.46, 5, 6.54), Block.makeCuboidShape(6.46, 3, 9.54, 9.46, 5, 13.54),
			Block.makeCuboidShape(7.46, 5, 8.54, 10.46, 7, 11.54), Block.makeCuboidShape(4.46, 5, 4.54, 7.46, 7, 7.54),
			Block.makeCuboidShape(3.463, 5, 2.543, 6.46, 6, 5.54), Block.makeCuboidShape(9.46, 5, 6.54, 13.46, 7, 9.54),
			Block.makeCuboidShape(7.46, 5, 3.543, 11.46, 7, 6.54),
			Block.makeCuboidShape(3.463, 5, 7.54, 7.46, 7, 10.54),
			Block.makeCuboidShape(11.46, 1, 9.54, 13.46, 2, 11.54),
			Block.makeCuboidShape(3.463, 1, 11.54, 5.46, 2, 12.54), Block.makeCuboidShape(5.46, 7, 5.54, 7.46, 9, 8.54),
			Block.makeCuboidShape(7.46, 7, 4.54, 9.46, 8, 6.54), Block.makeCuboidShape(9.46, 7, 8.54, 11.46, 8, 10.54),
			Block.makeCuboidShape(5.46, 7, 8.54, 9.46, 9, 10.54), Block.makeCuboidShape(9.46, 7, 5.54, 11.46, 9, 8.54),
			Block.makeCuboidShape(5.26, 8, 8.61, 8.26, 10, 11.61),
			Block.makeCuboidShape(4.26, 8, 4.606, 7.26, 10, 8.61),
			Block.makeCuboidShape(5.26, 10, 6.606, 7.26, 11, 8.61),
			Block.makeCuboidShape(6.26, 10, 4.606, 9.26, 12, 6.606),
			Block.makeCuboidShape(7.26, 8, 2.6064, 10.26, 10, 6.606),
			Block.makeCuboidShape(8.26, 8, 8.61, 11.26, 10, 12.61),
			Block.makeCuboidShape(9.26, 10, 6.606, 11.26, 12, 10.61),
			Block.makeCuboidShape(6.26, 10, 8.61, 9.26, 12, 10.61),
			Block.makeCuboidShape(9.26, 8, 5.606, 12.26, 10, 8.61),
			Block.makeCuboidShape(9.26, 10, 4.606, 11.26, 11, 6.606),
			Block.makeCuboidShape(10.46, 4, 10.54, 12.46, 6, 12.54),
			Block.makeCuboidShape(11.8, 6, 8.18, 13.8, 8, 10.18), Block.makeCuboidShape(2.61, 3, 6.062, 4.61, 5, 8.06),
			Block.makeCuboidShape(4.46, 9, 9.54, 6.46, 11, 11.54),
			Block.makeCuboidShape(7.46, 12, 6.54, 9.46, 14, 8.54),
			Block.makeCuboidShape(6.291378893051818, 6, 1.8, 8.291378893051817, 8, 3.800770934364307))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(7.0, 10, 6.54, 9, 12, 8.54),
			Block.makeCuboidShape(3.0, 1, 1.544, 10, 3, 4.54), Block.makeCuboidShape(2.0, 1, 4.54, 13, 3, 7.54),
			Block.makeCuboidShape(4.0, 1, 7.54, 14, 3, 10.54), Block.makeCuboidShape(1.0, 1, 10.54, 12, 3, 13.54),
			Block.makeCuboidShape(1.0, 0, 0.544, 15, 1, 14.54), Block.makeCuboidShape(7.0, 3, 8.54, 10, 5, 11.54),
			Block.makeCuboidShape(3.0, 3, 3.544, 11, 5, 6.54), Block.makeCuboidShape(3.0, 3, 6.54, 7.0, 5, 12.54),
			Block.makeCuboidShape(10, 3, 6.54, 14, 5, 9.54), Block.makeCuboidShape(9, 5, 5.54, 12, 7, 8.54),
			Block.makeCuboidShape(5.0, 5, 8.54, 8, 7, 11.54), Block.makeCuboidShape(3.0, 5, 9.54, 6.0, 6, 12.54),
			Block.makeCuboidShape(7.0, 5, 2.544, 10, 7, 6.54), Block.makeCuboidShape(4.0, 5, 4.54, 7.0, 7, 8.54),
			Block.makeCuboidShape(8, 5, 8.54, 11, 7, 12.54), Block.makeCuboidShape(10, 1, 2.544, 12, 2, 4.54),
			Block.makeCuboidShape(12, 1, 10.54, 13, 2, 12.54), Block.makeCuboidShape(6.0, 7, 8.54, 9, 9, 10.54),
			Block.makeCuboidShape(5.0, 7, 6.54, 7.0, 8, 8.54), Block.makeCuboidShape(9, 7, 4.54, 11, 8, 6.54),
			Block.makeCuboidShape(9, 7, 6.54, 11, 9, 10.54), Block.makeCuboidShape(6.0, 7, 4.54, 9, 9, 6.54),
			Block.makeCuboidShape(9.07, 8, 7.737, 12.07, 10, 10.737),
			Block.makeCuboidShape(5.0678, 8, 8.737, 9.07, 10, 11.737),
			Block.makeCuboidShape(7.0678, 10, 8.737, 9.07, 11, 10.737),
			Block.makeCuboidShape(5.0678, 10, 6.737, 7.0678, 12, 9.737),
			Block.makeCuboidShape(3.0678, 8, 5.737, 7.0678, 10, 8.737),
			Block.makeCuboidShape(9.07, 8, 4.737, 13.07, 10, 7.737),
			Block.makeCuboidShape(7.0678, 10, 4.737, 11.07, 12, 6.737),
			Block.makeCuboidShape(9.07, 10, 6.737, 11.07, 12, 9.737),
			Block.makeCuboidShape(6.0678, 8, 3.737, 9.07, 10, 6.737),
			Block.makeCuboidShape(5.0678, 10, 4.737, 7.0678, 11, 6.737),
			Block.makeCuboidShape(11, 4, 3.544, 13, 6, 5.54), Block.makeCuboidShape(8.64, 6, 2.2, 10.64, 8, 4.2),
			Block.makeCuboidShape(6.52, 3, 11.4, 8.52, 5, 13.4), Block.makeCuboidShape(10, 9, 9.54, 12, 11, 11.54),
			Block.makeCuboidShape(7.0, 12, 6.54, 9, 14, 8.54), Block.makeCuboidShape(2.3, 6, 7.71, 4.26, 8, 9.71))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockOccularHeap(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntityOccularHeap te = (TileEntityOccularHeap) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause

		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(new StringTextComponent(
						TextFormatting.LIGHT_PURPLE + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
					// player.playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 0.6F, 0.8F);
					return ActionResultType.SUCCESS;
				} else {
					if (te.devo.getDevotion() < 30) {
						te.checkStructure();
						te.devo.addDevotion(sac.getDevoAmount());
						player.getHeldItemMainhand().shrink(1);
						coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
						PacketHandler.CHANNELCOVENANT.send(
								PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
								new CovenantPacketServer(coven.getDevotion()));
						VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
						player.sendStatusMessage(
								new StringTextComponent(TextFormatting.GOLD + "Your offering was accepted"), true);
						return ActionResultType.SUCCESS;
					} else {
						te.checkStructure();
						te.devo.addDevotion(sac.getDevoAmount());
						player.getHeldItemMainhand().shrink(1);
						coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
						PacketHandler.CHANNELCOVENANT.send(
								PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
								new CovenantPacketServer(coven.getDevotion()));
						VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
						player.sendStatusMessage(
								new StringTextComponent(
										TextFormatting.DARK_PURPLE + "So much fealty was sure to draw attention..."),
								true);
						worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
						worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Explosion.Mode.NONE);
						EntityDarkYoung summon = new EntityDarkYoung(EntityInit.dark_young.get(), worldIn);
						summon.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
						worldIn.addEntity(summon);
						return ActionResultType.SUCCESS;
					}
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
			return SHAPE_S;
		case SOUTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_W;
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
		return new TileEntityOccularHeap();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ELDRITCH;
	}

}
