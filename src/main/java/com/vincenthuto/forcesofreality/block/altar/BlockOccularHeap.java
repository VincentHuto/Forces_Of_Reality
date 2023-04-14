package com.vincenthuto.forcesofreality.block.altar;

import java.util.stream.Stream;

import com.vincenthuto.forcesofreality.block.util.IBlockDevotionStation;
import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.capa.covenant.ICovenant;
import com.vincenthuto.forcesofreality.entity.guardian.EntityDarkYoung;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.forcesofreality.item.ItemSacrificial;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityOccularHeap;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

public class BlockOccularHeap extends Block implements IBlockDevotionStation, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(7, 10, 7, 9, 12, 9), Block.box(2, 1, 6, 5, 3, 13), Block.box(5, 1, 3, 8, 3, 14),
					Block.box(8, 1, 2, 11, 3, 12), Block.box(11, 1, 4, 14, 3, 15), Block.box(1, 0, 1, 15, 1, 15),
					Block.box(9, 3, 6, 12, 5, 9), Block.box(4, 3, 5, 7, 5, 13), Block.box(7, 3, 9, 13, 5, 13),
					Block.box(7, 3, 2, 10, 5, 6), Block.box(6, 5, 4, 9, 7, 7), Block.box(9, 5, 8, 12, 7, 11),
					Block.box(10, 5, 10, 13, 6, 13), Block.box(3, 5, 6, 7, 7, 9), Block.box(5, 5, 9, 9, 7, 12),
					Block.box(9, 5, 5, 13, 7, 8), Block.box(3, 1, 4, 5, 2, 6), Block.box(11, 1, 3, 13, 2, 4),
					Block.box(9, 7, 7, 11, 9, 10), Block.box(7, 7, 9, 9, 8, 11), Block.box(5, 7, 5, 7, 8, 7),
					Block.box(7, 7, 5, 11, 9, 7), Block.box(5, 7, 7, 7, 9, 10),
					Block.box(8.15, 8, 3.85, 11.15, 10, 6.85), Block.box(9.15, 8, 6.85, 12.15, 10, 10.85),
					Block.box(9.15, 10, 6.85, 11.15, 11, 8.85), Block.box(7.15, 10, 8.85, 10.15, 12, 10.85),
					Block.box(6.15, 8, 8.85, 9.15, 10, 12.85), Block.box(5.15, 8, 2.85, 8.15, 10, 6.85),
					Block.box(5.15, 10, 4.85, 7.15, 12, 8.85), Block.box(7.15, 10, 4.85, 10.15, 12, 6.85),
					Block.box(4.15, 8, 6.85, 7.15, 10, 9.85), Block.box(5.15, 10, 8.85, 7.15, 11, 10.85),
					Block.box(4, 4, 3, 6, 6, 5), Block.box(3, 6, 9, 5, 8, 11), Block.box(11, 3, 4, 13, 5, 6),
					Block.box(10, 9, 4, 12, 11, 6), Block.box(7, 12, 7, 9, 14, 9), Block.box(10, 6, 11, 12, 8, 13))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream.of(Block.box(7.46, 10, 7.0, 9.46, 12, 9),
			Block.box(6.46, 1, 11, 13.46, 3, 14), Block.box(3.463, 1, 8, 14.46, 3, 11),
			Block.box(2.463, 1, 5.0, 12.46, 3, 8), Block.box(4.46, 1, 2.08, 15.46, 3, 5.0),
			Block.box(1.463, 0, 1.08, 15.46, 1, 15), Block.box(6.46, 3, 4.0, 9.46, 5, 7.0),
			Block.box(5.46, 3, 9, 13.46, 5, 12), Block.box(9.46, 3, 3.08, 13.46, 5, 9),
			Block.box(2.463, 3, 6.0, 6.46, 5, 9), Block.box(4.46, 5, 7.0, 7.46, 7, 10),
			Block.box(8.46, 5, 4.0, 11.46, 7, 7.0), Block.box(10.46, 5, 3.08, 13.46, 6, 6.0),
			Block.box(6.46, 5, 9, 9.46, 7, 13), Block.box(9.46, 5, 7.0, 12.46, 7, 11),
			Block.box(5.46, 5, 3.08, 8.46, 7, 7.0), Block.box(4.46, 1, 11, 6.46, 2, 13),
			Block.box(3.463, 1, 3.08, 4.46, 2, 5.0), Block.box(7.46, 7, 5.0, 10.46, 9, 7.0),
			Block.box(9.46, 7, 7.0, 11.46, 8, 9), Block.box(5.46, 7, 9, 7.46, 8, 11),
			Block.box(5.46, 7, 5.0, 7.46, 9, 9), Block.box(7.46, 7, 9, 10.46, 9, 11),
			Block.box(4.4, 8, 4.8, 7.4, 10, 7.8), Block.box(7.4, 8, 3.8, 11.4, 10, 6.8),
			Block.box(7.4, 10, 4.8, 9.4, 11, 6.8), Block.box(9.4, 10, 5.8, 11.4, 12, 8.8),
			Block.box(9.4, 8, 6.8, 13.4, 10, 9.8), Block.box(3.4, 8, 7.8, 7.4, 10, 10.8),
			Block.box(5.4, 10, 8.8, 9.4, 12, 10.8), Block.box(5.4, 10, 5.8, 7.4, 12, 8.8),
			Block.box(7.4, 8, 8.8, 10.4, 10, 11.8), Block.box(9.4, 10, 8.8, 11.4, 11, 10.8),
			Block.box(3.463, 4, 10, 5.46, 6, 12), Block.box(5.83, 6, 11.34, 7.83, 8, 13.34),
			Block.box(7.94, 3, 2.15, 9.94, 5, 4.15), Block.box(4.46, 9, 4.0, 6.46, 11, 6.0),
			Block.box(7.46, 12, 7.0, 9.46, 14, 9), Block.box(12.2, 6, 5.83, 14.2, 8, 7.83)).reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.box(7.46, 10, 6.54, 9.46, 12, 8.54), Block.box(11.46, 1, 2.543, 14.46, 3, 9.54),
					Block.box(8.46, 1, 1.543, 11.46, 3, 12.54), Block.box(5.46, 1, 3.543, 8.46, 3, 13.54),
					Block.box(2.463, 1, 0.543, 5.46, 3, 11.54), Block.box(1.463, 0, 0.543, 15.46, 1, 14.54),
					Block.box(4.46, 3, 6.54, 7.46, 5, 9.54), Block.box(9.46, 3, 2.543, 12.46, 5, 10.54),
					Block.box(3.463, 3, 2.543, 9.46, 5, 6.54), Block.box(6.46, 3, 9.54, 9.46, 5, 13.54),
					Block.box(7.46, 5, 8.54, 10.46, 7, 11.54), Block.box(4.46, 5, 4.54, 7.46, 7, 7.54),
					Block.box(3.463, 5, 2.543, 6.46, 6, 5.54), Block.box(9.46, 5, 6.54, 13.46, 7, 9.54),
					Block.box(7.46, 5, 3.543, 11.46, 7, 6.54), Block.box(3.463, 5, 7.54, 7.46, 7, 10.54),
					Block.box(11.46, 1, 9.54, 13.46, 2, 11.54), Block.box(3.463, 1, 11.54, 5.46, 2, 12.54),
					Block.box(5.46, 7, 5.54, 7.46, 9, 8.54), Block.box(7.46, 7, 4.54, 9.46, 8, 6.54),
					Block.box(9.46, 7, 8.54, 11.46, 8, 10.54), Block.box(5.46, 7, 8.54, 9.46, 9, 10.54),
					Block.box(9.46, 7, 5.54, 11.46, 9, 8.54), Block.box(5.26, 8, 8.61, 8.26, 10, 11.61),
					Block.box(4.26, 8, 4.606, 7.26, 10, 8.61), Block.box(5.26, 10, 6.606, 7.26, 11, 8.61),
					Block.box(6.26, 10, 4.606, 9.26, 12, 6.606), Block.box(7.26, 8, 2.6064, 10.26, 10, 6.606),
					Block.box(8.26, 8, 8.61, 11.26, 10, 12.61), Block.box(9.26, 10, 6.606, 11.26, 12, 10.61),
					Block.box(6.26, 10, 8.61, 9.26, 12, 10.61), Block.box(9.26, 8, 5.606, 12.26, 10, 8.61),
					Block.box(9.26, 10, 4.606, 11.26, 11, 6.606), Block.box(10.46, 4, 10.54, 12.46, 6, 12.54),
					Block.box(11.8, 6, 8.18, 13.8, 8, 10.18), Block.box(2.61, 3, 6.062, 4.61, 5, 8.06),
					Block.box(4.46, 9, 9.54, 6.46, 11, 11.54), Block.box(7.46, 12, 6.54, 9.46, 14, 8.54),
					Block.box(6.291378893051818, 6, 1.8, 8.291378893051817, 8, 3.800770934364307))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(Block.box(7.0, 10, 6.54, 9, 12, 8.54),
			Block.box(3.0, 1, 1.544, 10, 3, 4.54), Block.box(2.0, 1, 4.54, 13, 3, 7.54),
			Block.box(4.0, 1, 7.54, 14, 3, 10.54), Block.box(1.0, 1, 10.54, 12, 3, 13.54),
			Block.box(1.0, 0, 0.544, 15, 1, 14.54), Block.box(7.0, 3, 8.54, 10, 5, 11.54),
			Block.box(3.0, 3, 3.544, 11, 5, 6.54), Block.box(3.0, 3, 6.54, 7.0, 5, 12.54),
			Block.box(10, 3, 6.54, 14, 5, 9.54), Block.box(9, 5, 5.54, 12, 7, 8.54),
			Block.box(5.0, 5, 8.54, 8, 7, 11.54), Block.box(3.0, 5, 9.54, 6.0, 6, 12.54),
			Block.box(7.0, 5, 2.544, 10, 7, 6.54), Block.box(4.0, 5, 4.54, 7.0, 7, 8.54),
			Block.box(8, 5, 8.54, 11, 7, 12.54), Block.box(10, 1, 2.544, 12, 2, 4.54),
			Block.box(12, 1, 10.54, 13, 2, 12.54), Block.box(6.0, 7, 8.54, 9, 9, 10.54),
			Block.box(5.0, 7, 6.54, 7.0, 8, 8.54), Block.box(9, 7, 4.54, 11, 8, 6.54),
			Block.box(9, 7, 6.54, 11, 9, 10.54), Block.box(6.0, 7, 4.54, 9, 9, 6.54),
			Block.box(9.07, 8, 7.737, 12.07, 10, 10.737), Block.box(5.0678, 8, 8.737, 9.07, 10, 11.737),
			Block.box(7.0678, 10, 8.737, 9.07, 11, 10.737), Block.box(5.0678, 10, 6.737, 7.0678, 12, 9.737),
			Block.box(3.0678, 8, 5.737, 7.0678, 10, 8.737), Block.box(9.07, 8, 4.737, 13.07, 10, 7.737),
			Block.box(7.0678, 10, 4.737, 11.07, 12, 6.737), Block.box(9.07, 10, 6.737, 11.07, 12, 9.737),
			Block.box(6.0678, 8, 3.737, 9.07, 10, 6.737), Block.box(5.0678, 10, 4.737, 7.0678, 11, 6.737),
			Block.box(11, 4, 3.544, 13, 6, 5.54), Block.box(8.64, 6, 2.2, 10.64, 8, 4.2),
			Block.box(6.52, 3, 11.4, 8.52, 5, 13.4), Block.box(10, 9, 9.54, 12, 11, 11.54),
			Block.box(7.0, 12, 6.54, 9, 14, 8.54), Block.box(2.3, 6, 7.71, 4.26, 8, 9.71)).reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	public BlockOccularHeap(Properties properties) {
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
		return EnumCovenants.ELDRITCH;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
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
		return new BlockEntityOccularHeap(p_153215_, p_153216_);
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
		BlockEntityOccularHeap te = (BlockEntityOccularHeap) worldIn.getBlockEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getMainHandItem();
		// Upgrade clause

		if (stack.isEmpty()) {
//			if (!worldIn.isClientSide) {
//				player.displayClientMessage(Component.translatable(
//						ChatFormatting.LIGHT_PURPLE + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
//						true);
//			}
			if (worldIn.isClientSide) {
				player.playSound(SoundEvents.LODESTONE_COMPASS_LOCK, 0.6F, 0.8F);
			}
			return InteractionResult.SUCCESS;
		}

		if (stack.getItem() instanceof ItemSacrificial) {
			ItemSacrificial sac = (ItemSacrificial) stack.getItem();
			if (sac.getCoven() == te.getCovenType()) {
				if (worldIn.isClientSide) {
					player.playSound(SoundInit.ENTITY_SERAPHIM_FLARE.get(), 0.6F, 0.8F);
					return InteractionResult.SUCCESS;
				} else {
					if (te.devo.getDevotion() < 30) {
						te.checkStructure();
						te.devo.addDevotion(sac.getDevoAmount());
						player.getMainHandItem().shrink(1);
						coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
						PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
								new PacketCovenantServer(coven.getDevotion()));
						VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
						player.displayClientMessage(
								Component.translatable(ChatFormatting.GOLD + "Your offering was accepted"), true);
						return InteractionResult.SUCCESS;
					} else {
						te.checkStructure();
						te.devo.addDevotion(sac.getDevoAmount());
						player.getMainHandItem().shrink(1);
						coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
						PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
								new PacketCovenantServer(coven.getDevotion()));
						VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
						player.displayClientMessage(
								Component.translatable(
										ChatFormatting.DARK_PURPLE + "So much fealty was sure to draw attention..."),
								true);
						worldIn.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
						worldIn.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F,
								ExplosionInteraction.NONE);
						EntityDarkYoung summon = new EntityDarkYoung(EntityInit.dark_young.get(), worldIn);
						summon.setPos(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
						worldIn.addFreshEntity(summon);
						return InteractionResult.SUCCESS;
					}
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
