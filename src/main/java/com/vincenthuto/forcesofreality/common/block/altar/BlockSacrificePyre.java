package com.vincenthuto.forcesofreality.common.block.altar;

import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.common.block.util.IBlockDevotionStation;
import com.vincenthuto.forcesofreality.common.capability.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.common.capability.covenant.ICovenant;
import com.vincenthuto.forcesofreality.common.item.ItemSacrificial;
import com.vincenthuto.forcesofreality.common.network.PacketHandler;
import com.vincenthuto.forcesofreality.common.network.coven.PacketCovenantServer;
import com.vincenthuto.forcesofreality.common.tile.coven.BlockEntitySacrificePyre;
import com.vincenthuto.forcesofreality.registry.SoundInit;
import com.vincenthuto.hutoslib.common.network.VanillaPacketDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
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

public class BlockSacrificePyre extends Block implements IBlockDevotionStation, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(4, 0, 2, 6, 2, 10), Block.box(9, 0, 6, 11, 2, 15), Block.box(6, 0, 4, 14, 1, 6),
					Block.box(1, 0, 11, 9, 2, 13), Block.box(2, 0, 10, 9, 1, 11), Block.box(11, 0, 6.1, 12, 7, 7.1),
					Block.box(6, 2, 1, 7, 3, 8),
					Block.box(7.121320343559642, 2.1213203435596424, 8, 14.121320343559642, 3.1213203435596424, 9),
					Block.box(6, 0, 7, 7, 1, 14), Block.box(8, 4, 1, 9, 5, 8), Block.box(1, 0, 1, 15, 0, 15))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_R = Block.box(-8, 0, -7, 24, 32, 25);

	public BlockSacrificePyre(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull Level world, @Nonnull BlockPos pos,
			@Nonnull RandomSource random) {
		BlockEntitySacrificePyre tile = (BlockEntitySacrificePyre) world.getBlockEntity(pos);
		if (tile != null && tile instanceof BlockEntitySacrificePyre) {
			int count = (int) (6 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() + random.nextDouble();
					double randY = pos.getY() + random.nextDouble();
					double randZ = pos.getZ() + random.nextDouble();
					world.addParticle(ParticleTypes.FLAME, randX, randY, randZ, 0, 0, 0);
					world.addParticle(ParticleTypes.SMOKE, randX, randY, randZ, 0, 0, 0);

				}
			}
		}
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
		return EnumCovenants.BEAST;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return SHAPE_R;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE_N;
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
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new BlockEntitySacrificePyre(p_153215_, p_153216_);
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
		BlockEntitySacrificePyre te = (BlockEntitySacrificePyre) worldIn.getBlockEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getMainHandItem();
		// Upgrade clause
		if (stack.isEmpty()) {
//			if (!worldIn.isClientSide) {
//				player.displayClientMessage(
//						Component.translatable(
//								ChatFormatting.RED + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
					player.playSound(SoundInit.ITEM_STAR_SLUG_STORM.get(), 0.6F, 0.8F);
					return InteractionResult.SUCCESS;
				} else {
					te.devo.addDevotion(sac.getDevoAmount());
					player.getMainHandItem().shrink(1);
					coven.setCovenDevotion(te.getCovenType(), sac.devoAmount * te.sacMod);
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
