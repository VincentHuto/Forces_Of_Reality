package com.huto.hutosmod.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.hutosmod.objects.items.ItemUpgrade;
import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockVibeAbsorber extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
					Block.makeCuboidShape(11, 2, 4, 12, 3, 5), Block.makeCuboidShape(4, 2, 4, 5, 3, 5),
					Block.makeCuboidShape(11, 2, 11, 12, 3, 12), Block.makeCuboidShape(4, 2, 11, 5, 3, 12),
					Block.makeCuboidShape(7, 2, 7, 9, 7, 9), Block.makeCuboidShape(7, 8, 7, 9, 10, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockVibeAbsorber(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote)
			return ActionResultType.PASS;
		TileEntityAbsorber te = (TileEntityAbsorber) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItem(handIn);
		if (stack.getItem() == ItemInit.upgrade_wrench.get()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// If there is something in your hand add it to the block if its not an //
		if (!stack.isEmpty() && stack.getItem() instanceof ItemUpgrade) {
			te.addItem(player, stack, handIn);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// Upgrade clause
		if (stack.getItem() == ItemInit.enhancedmagatama.get() && te.getTankLevel() < 3) {
			te.addTankLevel(1);
			te.checkTransferRate();
			te.getTankLevel();
			player.getHeldItemMainhand().shrink(1);
			player.getHeldItemOffhand().shrink(1);
			
			return ActionResultType.SUCCESS;
		}
		// Cycle Clause
		if (stack.getItem() == ItemInit.absorber_configurer.get()) {
			te.cycleEnumMode();
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;

		}
		// Says the tank is full
		if (te.getVibeCap().getVibes() >= te.getTankSize()) {
			String message = String.format("Drum is full");
			player.sendStatusMessage(new StringTextComponent(TextFormatting.BLUE + message), false);
			return ActionResultType.SUCCESS;

		}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
		return ActionResultType.FAIL;

	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityAbsorber tile = (TileEntityAbsorber) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityAbsorber) {
			int count = (int) (4 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;

					world.addParticle(ParticleTypes.PORTAL, randX, randY, randZ, 0, 0, 0);

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

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityAbsorber();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		// TODO Auto-generated method stub
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
