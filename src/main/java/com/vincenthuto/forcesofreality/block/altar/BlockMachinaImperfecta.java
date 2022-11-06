package com.vincenthuto.forcesofreality.block.altar;

import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.block.util.IBlockDevotionStation;
import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.capa.covenant.ICovenant;
import com.vincenthuto.forcesofreality.entity.guardian.EntityMalformedAutomaton;
import com.vincenthuto.forcesofreality.init.BlockInit;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.forcesofreality.item.ItemSacrificial;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
import com.vincenthuto.forcesofreality.tile.BlockEntityMachinaImperfecta;
import com.vincenthuto.hutoslib.common.network.VanillaPacketDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.PacketDistributor;

public class BlockMachinaImperfecta extends Block implements IBlockDevotionStation, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.box(2, 14, 2, 14, 15, 14), Block.box(2, 2, 2, 14, 3, 14),
			Block.box(13, 3, 1, 15, 14, 3), Block.box(13, 3, 13, 15, 14, 15), Block.box(1, 3, 13, 3, 14, 15),
			Block.box(1, 3, 1, 3, 14, 3), Block.box(3, 3, 3, 13, 5, 13), Block.box(3, 5, 3, 13, 12, 13),
			Block.box(3, 12, 3, 13, 14, 13), Block.box(3, 5, 13, 5, 12, 14), Block.box(11, 5, 13, 13, 12, 14),
			Block.box(11, 5, 2, 13, 12, 3), Block.box(3, 5, 2, 5, 12, 3), Block.box(2, 5, 3, 3, 12, 5),
			Block.box(2, 5, 11, 3, 12, 13), Block.box(13, 5, 3, 14, 12, 5), Block.box(13, 5, 11, 14, 12, 13))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();
	private static final VoxelShape SHAPE_R = Block.box(-8, 0, -7, 24, 32, 25);
	private BlockPattern golemPattern;

	public BlockMachinaImperfecta(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull Level world, @Nonnull BlockPos pos,
			@Nonnull RandomSource random) {
		BlockEntityMachinaImperfecta tile = (BlockEntityMachinaImperfecta) world.getBlockEntity(pos);
		if (tile != null && tile instanceof BlockEntityMachinaImperfecta) {
			int count = (int) (6 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() + random.nextDouble();
					double randY = pos.getY() + random.nextDouble();
					double randZ = pos.getZ() + random.nextDouble();
					world.addParticle(DustParticleOptions.REDSTONE, randX, randY, randZ, 0, 0, 0);
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
		return EnumCovenants.MACHINE;
	}

	private BlockPattern getGolemPattern() {
		if (this.golemPattern == null) {
			this.golemPattern = BlockPatternBuilder.start()
					.aisle("~~~^~~~", "~~GMG~~", "~#~#~#~", "~#~#~#~", "~~#~#~~", "~~#~#~~")
					.where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(this)))
					.where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockInit.auric_block.get())))
					.where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR)))
					.where('M', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.MAGMA_BLOCK)))
					.where('G', BlockInWorld.hasState(BlockStatePredicate.forBlock(BlockInit.machine_glass.get())))
					.build();
		}
		return this.golemPattern;
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
		return new BlockEntityMachinaImperfecta(p_153215_, p_153216_);
	}

	@Override
	public void onNeighborChange(BlockState state, LevelReader world, BlockPos pos, BlockPos neighbor) {
	}

	// Golem Spawning
	@Override
	public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!oldState.is(state.getBlock())) {
			this.trySpawnGolem(worldIn, pos);
		}
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	private void trySpawnGolem(Level world, BlockPos pos) {
		BlockPattern.BlockPatternMatch blockpattern$patternhelper = this.getGolemPattern().find(world, pos);
		if (blockpattern$patternhelper != null) {
			blockpattern$patternhelper = this.getGolemPattern().find(world, pos);
			if (blockpattern$patternhelper != null) {
				for (int j = 0; j < this.getGolemPattern().getWidth(); ++j) {
					for (int k = 0; k < this.getGolemPattern().getHeight(); ++k) {
						BlockInWorld cachedblockinfo2 = blockpattern$patternhelper.getBlock(j, k, 0);
						world.setBlock(cachedblockinfo2.getPos(), Blocks.AIR.defaultBlockState(), 2);
						world.levelEvent(2001, cachedblockinfo2.getPos(), Block.getId(cachedblockinfo2.getState()));
					}
				}

				BlockPos blockpos = blockpattern$patternhelper.getBlock(1, 2, 0).getPos();
				EntityMalformedAutomaton irongolementity = new EntityMalformedAutomaton(
						EntityInit.malformed_automaton.get(), world);
				irongolementity.setPlayerCreated(true);
				irongolementity.moveTo(blockpos.getX() + 0.5D, blockpos.getY() + 0.05D, blockpos.getZ() + 0.5D, 0.0F,
						0.0F);
				world.addFreshEntity(irongolementity);

				for (ServerPlayer serverplayerentity1 : world.getEntitiesOfClass(ServerPlayer.class,
						irongolementity.getBoundingBox().inflate(5.0D))) {
					CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, irongolementity);
				}
				for (int i1 = 0; i1 < this.getGolemPattern().getWidth(); ++i1) {
					for (int j1 = 0; j1 < this.getGolemPattern().getHeight(); ++j1) {
						BlockInWorld cachedblockinfo1 = blockpattern$patternhelper.getBlock(i1, j1, 0);
						world.blockUpdated(cachedblockinfo1.getPos(), Blocks.AIR);
					}
				}
			}
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		BlockEntityMachinaImperfecta te = (BlockEntityMachinaImperfecta) worldIn.getBlockEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getMainHandItem();
		// Upgrade clause
		if (stack.isEmpty()) {
//			if (!worldIn.isClientSide) {
//				player.displayClientMessage(
//						Component.translatable(
//								ChatFormatting.GOLD + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
