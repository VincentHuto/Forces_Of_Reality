package com.huto.hutosmod.objects.blocks.bonsai;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.font.ModTextFormatting;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;
import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.PacketDistributor;

public class BlockBonsai extends Block {
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(1.9999875000000022, 0, 3.9999874999999996, 4.999987500000002, 1, 6.9999875),
					Block.makeCuboidShape(10.9999875, 0, 3.9999874999999996, 13.9999875, 1, 6.9999875),
					Block.makeCuboidShape(10.9999875, 0, 8.9999875, 13.9999875, 1, 11.9999875),
					Block.makeCuboidShape(1.9999875000000022, 0, 8.9999875, 4.999987500000002, 1, 11.9999875),
					Block.makeCuboidShape(12.9999875, 2, 4.9999875, 13.9999875, 5, 10.9999875),
					Block.makeCuboidShape(2.9999875000000022, 1, 4.9999875, 12.9999875, 2, 10.9999875),
					Block.makeCuboidShape(1.9999875000000022, 2, 4.9999875, 2.9999875000000022, 5, 10.9999875),
					Block.makeCuboidShape(2.9999875000000022, 2, 10.9999875, 12.9999875, 5, 11.9999875),
					Block.makeCuboidShape(2.9999875000000022, 2, 3.9999874999999996, 12.9999875, 5, 4.9999875),
					Block.makeCuboidShape(2.9999875000000022, 4, 4.9999875, 12.9999875, 5, 10.9999875))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(8.9999875, 0, 1.9999875000000014, 11.9999875, 1, 4.999987500000001),
					Block.makeCuboidShape(8.9999875, 0, 10.9999875, 11.9999875, 1, 13.9999875),
					Block.makeCuboidShape(3.9999875000000005, 0, 10.9999875, 6.9999875000000005, 1, 13.9999875),
					Block.makeCuboidShape(3.9999875000000005, 0, 1.9999875000000014, 6.9999875000000005, 1,
							4.999987500000001),
					Block.makeCuboidShape(4.9999875000000005, 2, 12.9999875, 10.9999875, 5, 13.9999875),
					Block.makeCuboidShape(4.9999875000000005, 1, 2.9999875000000022, 10.9999875, 2, 12.9999875),
					Block.makeCuboidShape(4.9999875000000005, 2, 1.9999875000000014, 10.9999875, 5, 2.9999875000000014),
					Block.makeCuboidShape(3.9999875000000005, 2, 2.9999875000000022, 4.9999875000000005, 5, 12.9999875),
					Block.makeCuboidShape(10.9999875, 2, 2.9999875000000022, 11.9999875, 5, 12.9999875),
					Block.makeCuboidShape(4.9999875000000005, 4, 2.9999875000000022, 10.9999875, 5, 12.9999875))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);
	EnumBonsaiTypes bonsaiType;
	int stage;

	public BlockBonsai(Properties properties, EnumBonsaiTypes type, int stageIn) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
		this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
		this.bonsaiType = type;
		this.stage = stageIn;
	}

	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return SHAPE_R;
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
	public boolean ticksRandomly(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (random.nextBoolean()) {
			switch (this.getBonsaiType()) {
			case ACACIA:
				break;
			case ANTI:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.anti_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.anti_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				break;
			case BIRCH:
				break;
			case DARKOAK:
				break;
			case JUNGLE:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.jungle_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.jungle_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				break;
			case MUSHROOM:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.mushroom_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.mushroom_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				break;
			case MYSTIC:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.somnolent_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.somnolent_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				break;
			case OAK:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.oak_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.oak_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				break;
			case SPRUCE:
				if (this.getStage() == 1) {
					worldIn.setBlockState(pos,
							BlockInit.spruce_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.spruce_bonsai_stage_3.get().getDefaultState().with(FACING, state.get(FACING)));
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
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
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
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Stage: " + stage));
		tooltip.add(new StringTextComponent(
				TextFormatting.GREEN + "Species: " + ModTextFormatting.toProperCase(bonsaiType.name())));
		tooltip.add(new StringTextComponent(
				TextFormatting.GOLD + "Grows: " + getShearDrop().getItem().getName().getString()));
	}

	public Item getShearDrop() {
		return null;
	}

	public void updatePlayerDevotion(World worldIn, PlayerEntity player) {
		if (!worldIn.isRemote) {
			ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
			Random rand = new Random();
			if (rand.nextInt(20) == 17) {
				coven.setCovenDevotion(EnumCovenants.SELF, 1);
				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player),
						new CovenantPacketServer(coven.getDevotion()));
				player.sendStatusMessage(
						new StringTextComponent(TextFormatting.AQUA + "Your Patience has been Rewarded"), true);
			} else {
				player.sendStatusMessage(new StringTextComponent(TextFormatting.AQUA + "Patience, All in due time..."),
						true);
			}
		}
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItemMainhand();
		Random rand = new Random();
		Item item = stack.getItem();

		if (item == Items.SHEARS && this.getStage() > 1) {
			ItemEntity outputItem = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
					new ItemStack(getShearDrop(), rand.nextInt(2) * this.stage));
			worldIn.addEntity(outputItem);
			switch (this.getBonsaiType()) {
			case ACACIA:
				break;
			case ANTI:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.anti_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);
				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.anti_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case BIRCH:
				break;
			case DARKOAK:
				break;
			case JUNGLE:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.jungle_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.jungle_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case MUSHROOM:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.mushroom_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.mushroom_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case MYSTIC:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.somnolent_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.somnolent_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case OAK:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.oak_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.oak_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			case SPRUCE:
				if (this.getStage() == 3) {
					worldIn.setBlockState(pos,
							BlockInit.spruce_bonsai_stage_2.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				if (this.getStage() == 2) {
					worldIn.setBlockState(pos,
							BlockInit.spruce_bonsai_stage_1.get().getDefaultState().with(FACING, state.get(FACING)));
					updatePlayerDevotion(worldIn, player);

				}
				break;
			default:
				break;

			}

			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;

		}

	}

}
