package com.vincenthuto.forcesofreality.common.block.altar;

import java.util.stream.Stream;

import com.vincenthuto.forcesofreality.common.block.util.IBlockDevotionStation;
import com.vincenthuto.forcesofreality.common.capability.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.common.capability.covenant.ICovenant;
import com.vincenthuto.forcesofreality.common.item.ItemSacrificial;
import com.vincenthuto.forcesofreality.common.network.PacketHandler;
import com.vincenthuto.forcesofreality.common.network.coven.PacketCovenantServer;
import com.vincenthuto.forcesofreality.common.tile.coven.BlockEntityAscendantAltar;
import com.vincenthuto.forcesofreality.registry.SoundInit;
import com.vincenthuto.hutoslib.common.network.VanillaPacketDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.PacketDistributor;

public class BlockAscendantAltar extends Block implements IBlockDevotionStation, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.box(0, 0, 1, 16, 1, 15), Block.box(3, 1, 4, 13, 3, 12),
			Block.box(3, 11, 4, 13, 13, 12), Block.box(0, 13, 1, 16, 14, 15), Block.box(1, 12, 14, 15, 13, 15),
			Block.box(3, 1, 2, 13, 2, 4), Block.box(3, 1, 12, 13, 2, 14), Block.box(1, 12, 1, 15, 13, 2),
			Block.box(13, 1, 2, 15, 2, 14), Block.box(13, 12, 2, 16, 13, 14), Block.box(1, 1, 2, 3, 2, 14),
			Block.box(0, 12, 2, 3, 13, 14), Block.box(9, 3, 6, 12, 11, 10), Block.box(4, 3, 6, 7, 11, 10))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream.of(Block.box(1, 0, 0, 15, 1, 16), Block.box(4, 1, 3, 12, 3, 13),
			Block.box(4, 11, 3, 12, 13, 13), Block.box(1, 13, 0, 15, 14, 16), Block.box(14, 12, 1, 15, 13, 15),
			Block.box(2, 1, 3, 4, 2, 13), Block.box(12, 1, 3, 14, 2, 13), Block.box(1, 12, 1, 2, 13, 15),
			Block.box(2, 1, 1, 14, 2, 3), Block.box(2, 12, 0, 14, 13, 3), Block.box(2, 1, 13, 14, 2, 15),
			Block.box(2, 12, 13, 14, 13, 16), Block.box(6, 3, 4, 10, 11, 7), Block.box(6, 3, 9, 10, 11, 12))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	public BlockAscendantAltar(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.SOUTH));

	}

	@SuppressWarnings("deprecation")
	@Override
	public void attack(BlockState state, Level worldIn, BlockPos pos, Player player) {
		super.attack(state, worldIn, pos, player);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDANT;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
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
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new BlockEntityAscendantAltar(p_153215_, p_153216_);
	}

	@Override
	public void onNeighborChange(BlockState state, LevelReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		BlockEntityAscendantAltar te = (BlockEntityAscendantAltar) worldIn.getBlockEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getMainHandItem();
		// Upgrade clause
		if (stack.isEmpty()) {
			if (!worldIn.isClientSide) {
//				player.displayClientMessage(
//						Component.translatable(
//								ChatFormatting.AQUA + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
//						true);
			}
			if (worldIn.isClientSide) {
				player.playSound(SoundEvents.LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
			}
			return InteractionResult.SUCCESS;
		}

		if (stack.getItem() instanceof ItemSacrificial sac) {
			if (sac.getCoven() == te.getCovenType()) {
				if (worldIn.isClientSide) {
					player.playSound(SoundInit.ENTITY_SERAPHIM_FLARE.get(), 0.6F, 0.8F);
					return InteractionResult.SUCCESS;
				} else {
					te.devo.addDevotion(sac.getDevoAmount());
					player.getMainHandItem().shrink(1);
					coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
//
					PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
							new PacketCovenantServer(coven.getDevotion()));
					VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
					player.displayClientMessage(
							Component.translatable(ChatFormatting.GOLD + "Your offering was accepted"), true);
					return InteractionResult.SUCCESS;

				}
			} else {
				player.displayClientMessage(Component.translatable(ChatFormatting.RED + "Incorrect Offering Type"),
						true);
				if (worldIn.isClientSide) {
					player.playSound(SoundEvents.LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
				}
				return InteractionResult.FAIL;
			}

		} else {
			player.displayClientMessage(Component.translatable(ChatFormatting.DARK_RED + "Item is not an offering"),
					true);
			if (worldIn.isClientSide) {
				player.playSound(SoundEvents.LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
			}
			return InteractionResult.FAIL;

		}

	}

}
