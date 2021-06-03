package com.huto.forcesofreality.objects.blocks.altars;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.capabilities.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilities.covenant.ICovenant;
import com.huto.forcesofreality.entities.guardians.EntityMalformedAutomaton;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.objects.blocks.util.IBlockDevotionStation;
import com.huto.forcesofreality.objects.items.ItemSacrificial;
import com.huto.forcesofreality.objects.tileenties.TileEntityMachinaImperfecta;
import com.huto.forcesofreality.sounds.SoundHandler;
import com.hutoslib.common.VanillaPacketDispatcher;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CachedBlockInfo;
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

public class BlockMachinaImperfecta extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(2, 14, 2, 14, 15, 14),
			Block.makeCuboidShape(2, 2, 2, 14, 3, 14), Block.makeCuboidShape(13, 3, 1, 15, 14, 3),
			Block.makeCuboidShape(13, 3, 13, 15, 14, 15), Block.makeCuboidShape(1, 3, 13, 3, 14, 15),
			Block.makeCuboidShape(1, 3, 1, 3, 14, 3), Block.makeCuboidShape(3, 3, 3, 13, 5, 13),
			Block.makeCuboidShape(3, 5, 3, 13, 12, 13), Block.makeCuboidShape(3, 12, 3, 13, 14, 13),
			Block.makeCuboidShape(3, 5, 13, 5, 12, 14), Block.makeCuboidShape(11, 5, 13, 13, 12, 14),
			Block.makeCuboidShape(11, 5, 2, 13, 12, 3), Block.makeCuboidShape(3, 5, 2, 5, 12, 3),
			Block.makeCuboidShape(2, 5, 3, 3, 12, 5), Block.makeCuboidShape(2, 5, 11, 3, 12, 13),
			Block.makeCuboidShape(13, 5, 3, 14, 12, 5), Block.makeCuboidShape(13, 5, 11, 14, 12, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();;
	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);
	private BlockPattern golemPattern;

	public BlockMachinaImperfecta(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntityMachinaImperfecta te = (TileEntityMachinaImperfecta) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause
		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(
						new StringTextComponent(
								TextFormatting.GOLD + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
					player.playSound(SoundHandler.ITEM_STAR_SLUG_STORM, 0.6F, 0.8F);
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

	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return SHAPE_R;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityMachinaImperfecta tile = (TileEntityMachinaImperfecta) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityMachinaImperfecta) {
			int count = (int) (6 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() + random.nextDouble();
					double randY = pos.getY() + random.nextDouble();
					double randZ = pos.getZ() + random.nextDouble();
					world.addParticle(RedstoneParticleData.REDSTONE_DUST, randX, randY, randZ, 0, 0, 0);
					world.addParticle(ParticleTypes.SMOKE, randX, randY, randZ, 0, 0, 0);

				}
			}
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

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityMachinaImperfecta();
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.MACHINE;
	}

	// Golem Spawning
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (!oldState.isIn(state.getBlock())) {
			this.trySpawnGolem(worldIn, pos);
		}
	}

	private void trySpawnGolem(World world, BlockPos pos) {
		BlockPattern.PatternHelper blockpattern$patternhelper = this.getGolemPattern().match(world, pos);
		if (blockpattern$patternhelper != null) {
			blockpattern$patternhelper = this.getGolemPattern().match(world, pos);
			if (blockpattern$patternhelper != null) {
				for (int j = 0; j < this.getGolemPattern().getPalmLength(); ++j) {
					for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k) {
						CachedBlockInfo cachedblockinfo2 = blockpattern$patternhelper.translateOffset(j, k, 0);
						world.setBlockState(cachedblockinfo2.getPos(), Blocks.AIR.getDefaultState(), 2);
						world.playEvent(2001, cachedblockinfo2.getPos(),
								Block.getStateId(cachedblockinfo2.getBlockState()));
					}
				}

				BlockPos blockpos = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
				EntityMalformedAutomaton irongolementity = new EntityMalformedAutomaton(
						EntityInit.malformed_automaton.get(), world);
				irongolementity.setPlayerCreated(true);
				irongolementity.setLocationAndAngles((double) blockpos.getX() + 0.5D, (double) blockpos.getY() + 0.05D,
						(double) blockpos.getZ() + 0.5D, 0.0F, 0.0F);
				world.addEntity(irongolementity);

				for (ServerPlayerEntity serverplayerentity1 : world.getEntitiesWithinAABB(ServerPlayerEntity.class,
						irongolementity.getBoundingBox().grow(5.0D))) {
					CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, irongolementity);
				}
				for (int i1 = 0; i1 < this.getGolemPattern().getPalmLength(); ++i1) {
					for (int j1 = 0; j1 < this.getGolemPattern().getThumbLength(); ++j1) {
						CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.translateOffset(i1, j1, 0);
						world.func_230547_a_(cachedblockinfo1.getPos(), Blocks.AIR);
					}
				}
			}
		}
	}

	private BlockPattern getGolemPattern() {
		if (this.golemPattern == null) {
			this.golemPattern = BlockPatternBuilder.start()
					.aisle("~~~^~~~", "~~GMG~~", "~#~#~#~", "~#~#~#~", "~~#~#~~", "~~#~#~~")
					.where('^', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(this)))
					.where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockInit.auric_block.get())))
					.where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
					.where('M', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.MAGMA_BLOCK)))
					.where('G', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(BlockInit.machine_glass.get())))
					.build();
		}
		return this.golemPattern;
	}

}
