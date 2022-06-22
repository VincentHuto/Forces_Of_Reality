package com.vincenthuto.forcesofreality.block.bonsai;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.vincenthuto.forcesofreality.block.util.EnumBonsaiTypes;
import com.vincenthuto.forcesofreality.font.ModTextFormatting;
import com.vincenthuto.forcesofreality.init.BlockInit;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockBonsai extends Block {
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(1.9999875000000022, 0, 3.9999874999999996, 4.999987500000002, 1, 6.9999875),
					Block.box(10.9999875, 0, 3.9999874999999996, 13.9999875, 1, 6.9999875),
					Block.box(10.9999875, 0, 8.9999875, 13.9999875, 1, 11.9999875),
					Block.box(1.9999875000000022, 0, 8.9999875, 4.999987500000002, 1, 11.9999875),
					Block.box(12.9999875, 2, 4.9999875, 13.9999875, 5, 10.9999875),
					Block.box(2.9999875000000022, 1, 4.9999875, 12.9999875, 2, 10.9999875),
					Block.box(1.9999875000000022, 2, 4.9999875, 2.9999875000000022, 5, 10.9999875),
					Block.box(2.9999875000000022, 2, 10.9999875, 12.9999875, 5, 11.9999875),
					Block.box(2.9999875000000022, 2, 3.9999874999999996, 12.9999875, 5, 4.9999875),
					Block.box(2.9999875000000022, 4, 4.9999875, 12.9999875, 5, 10.9999875))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.box(8.9999875, 0, 1.9999875000000014, 11.9999875, 1, 4.999987500000001),
					Block.box(8.9999875, 0, 10.9999875, 11.9999875, 1, 13.9999875),
					Block.box(3.9999875000000005, 0, 10.9999875, 6.9999875000000005, 1, 13.9999875),
					Block.box(3.9999875000000005, 0, 1.9999875000000014, 6.9999875000000005, 1, 4.999987500000001),
					Block.box(4.9999875000000005, 2, 12.9999875, 10.9999875, 5, 13.9999875),
					Block.box(4.9999875000000005, 1, 2.9999875000000022, 10.9999875, 2, 12.9999875),
					Block.box(4.9999875000000005, 2, 1.9999875000000014, 10.9999875, 5, 2.9999875000000014),
					Block.box(3.9999875000000005, 2, 2.9999875000000022, 4.9999875000000005, 5, 12.9999875),
					Block.box(10.9999875, 2, 2.9999875000000022, 11.9999875, 5, 12.9999875),
					Block.box(4.9999875000000005, 4, 2.9999875000000022, 10.9999875, 5, 12.9999875))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_R = Block.box(-8, 0, -7, 24, 32, 25);
	EnumBonsaiTypes bonsaiType;
	int stage;

	public BlockBonsai(Properties properties, EnumBonsaiTypes type, int stageIn) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
		this.bonsaiType = type;
		this.stage = stageIn;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return SHAPE_R;
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
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (random.nextBoolean()) {
			switch (this.getBonsaiType()) {
			case ACACIA:
				break;
			case ANTI:
				/*
				 * if (this.getStage() == 1) { worldIn.setBlockState(pos,
				 * BlockInit.anti_bonsai_stage_2.get().getDefaultState().with(FACING,
				 * state.get(FACING))); } if (this.getStage() == 2) { worldIn.setBlockState(pos,
				 * BlockInit.anti_bonsai_stage_3.get().getDefaultState().with(FACING,
				 * state.get(FACING))); }
				 */
				break;
			case BIRCH:
				break;
			case DARKOAK:
				break;
			case JUNGLE:
				if (this.getStage() == 1) {
					worldIn.setBlockAndUpdate(pos, BlockInit.jungle_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.jungle_bonsai_stage_3.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				break;
			case MUSHROOM:
				if (this.getStage() == 1) {
					worldIn.setBlockAndUpdate(pos, BlockInit.mushroom_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.mushroom_bonsai_stage_3.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				break;
			case MYSTIC:
				/*
				 * if (this.getStage() == 1) { worldIn.setBlockState(pos,
				 * BlockInit.somnolent_bonsai_stage_2.get().getDefaultState().with(FACING,
				 * state.get(FACING))); } if (this.getStage() == 2) { worldIn.setBlockState(pos,
				 * BlockInit.somnolent_bonsai_stage_3.get().getDefaultState().with(FACING,
				 * state.get(FACING))); }
				 */
				break;
			case OAK:
				if (this.getStage() == 1) {
					worldIn.setBlockAndUpdate(pos, BlockInit.oak_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.oak_bonsai_stage_3.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				break;
			case SPRUCE:
				if (this.getStage() == 1) {
					worldIn.setBlockAndUpdate(pos, BlockInit.spruce_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.spruce_bonsai_stage_3.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
				}
				break;
			default:
				break;

			}
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					worldIn.addParticle(ParticleTypes.REVERSE_PORTAL, randX, randY, randZ, 0, 0, 0);
					worldIn.addParticle(ParticleTypes.SMOKE, randX, randY, randZ, 0, 0, 0);

				}
			}
		}
	}

	@Override
	public void onNeighborChange(BlockState state, LevelReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
		builder.add(STAGE);
	}

	public EnumBonsaiTypes getBonsaiType() {
		return bonsaiType;
	}

	public void setBonsaiType(EnumBonsaiTypes bonsaiType) {
		this.bonsaiType = bonsaiType;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(Component.translatable(ChatFormatting.GOLD + "Stage: " + stage));
		tooltip.add(Component.translatable(
				ChatFormatting.GREEN + "Species: " + ModTextFormatting.toProperCase(bonsaiType.name())));
		tooltip.add(Component.translatable(
				ChatFormatting.GOLD + "Grows: " + getShearDrop().asItem().getDescription().getString()));
	}

	public Item getShearDrop() {
		return null;
	}

	public void updatePlayerDevotion(Level worldIn, Player player) {
		if (!worldIn.isClientSide) {
//			ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
			Random rand = new Random();
			if (rand.nextInt(20) == 17) {
//				coven.setCovenDevotion(EnumCovenants.SELF, 1);
//				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player),
//						new PacketCovenantServer(coven.getDevotion()));
				player.displayClientMessage(Component.translatable(ChatFormatting.AQUA + "Your Patience has been Rewarded"),
						true);
			} else {
				player.displayClientMessage(Component.translatable(ChatFormatting.AQUA + "Patience, All in due time..."),
						true);
			}
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		ItemStack stack = player.getMainHandItem();
		Random rand = new Random();
		Item item = stack.getItem();

		if (item == Items.SHEARS && this.getStage() > 1) {
			ItemEntity outputItem = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
					new ItemStack(getShearDrop(), rand.nextInt(2) * this.stage));
			worldIn.addFreshEntity(outputItem);
			switch (this.getBonsaiType()) {
			case ACACIA:
				break;
			case ANTI:
				/*
				 * if (this.getStage() == 3) { worldIn.setBlockState(pos,
				 * BlockInit.anti_bonsai_stage_2.get().getDefaultState().with(FACING,
				 * state.get(FACING))); updatePlayerDevotion(worldIn, player); } if
				 * (this.getStage() == 2) { worldIn.setBlockState(pos,
				 * BlockInit.anti_bonsai_stage_1.get().getDefaultState().with(FACING,
				 * state.get(FACING))); updatePlayerDevotion(worldIn, player);
				 *
				 * }
				 */
				break;
			case BIRCH:
				break;
			case DARKOAK:
				break;
			case JUNGLE:
				if (this.getStage() == 3) {
					worldIn.setBlockAndUpdate(pos, BlockInit.jungle_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.jungle_bonsai_stage_1.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case MUSHROOM:
				if (this.getStage() == 3) {
					worldIn.setBlockAndUpdate(pos, BlockInit.mushroom_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.mushroom_bonsai_stage_1.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case MYSTIC:
				/*
				 * if (this.getStage() == 3) { worldIn.setBlockState(pos,
				 * BlockInit.somnolent_bonsai_stage_2.get().getDefaultState().with(FACING,
				 * state.get(FACING))); updatePlayerDevotion(worldIn, player);
				 *
				 * } if (this.getStage() == 2) { worldIn.setBlockState(pos,
				 * BlockInit.somnolent_bonsai_stage_1.get().getDefaultState().with(FACING,
				 * state.get(FACING))); updatePlayerDevotion(worldIn, player);
				 *
				 * }
				 */
				break;
			case OAK:
				if (this.getStage() == 3) {
					worldIn.setBlockAndUpdate(pos, BlockInit.oak_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.oak_bonsai_stage_1.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case SPRUCE:
				if (this.getStage() == 3) {
					worldIn.setBlockAndUpdate(pos, BlockInit.spruce_bonsai_stage_2.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockAndUpdate(pos, BlockInit.spruce_bonsai_stage_1.get().defaultBlockState()
							.setValue(FACING, state.getValue(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			default:
				break;

			}

			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.FAIL;

		}

	}

}
