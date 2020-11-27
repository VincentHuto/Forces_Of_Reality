package com.huto.hutosmod.objects.blocks.altars;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;
import com.huto.hutosmod.objects.blocks.util.IBlockDevotionStation;
import com.huto.hutosmod.objects.items.ItemSacrificial;
import com.huto.hutosmod.objects.tileenties.TileEntitySacrificePyre;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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

public class BlockSacrificePyre extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(4, 0, 2, 6, 2, 10), Block.makeCuboidShape(9, 0, 6, 11, 2, 15),
					Block.makeCuboidShape(6, 0, 4, 14, 1, 6), Block.makeCuboidShape(1, 0, 11, 9, 2, 13),
					Block.makeCuboidShape(2, 0, 10, 9, 1, 11), Block.makeCuboidShape(11, 0, 6.1, 12, 7, 7.1),
					Block.makeCuboidShape(6, 2, 1, 7, 3, 8),
					Block.makeCuboidShape(7.121320343559642, 2.1213203435596424, 8, 14.121320343559642,
							3.1213203435596424, 9),
					Block.makeCuboidShape(6, 0, 7, 7, 1, 14), Block.makeCuboidShape(8, 4, 1, 9, 5, 8),
					Block.makeCuboidShape(1, 0, 1, 15, 0, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();;

	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);

	public BlockSacrificePyre(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntitySacrificePyre te = (TileEntitySacrificePyre) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause
		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(
						new StringTextComponent(
								TextFormatting.RED + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
					coven.setCovenDevotion(te.getCovenType(), sac.devoAmount* te.sacMod);
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
		TileEntitySacrificePyre tile = (TileEntitySacrificePyre) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntitySacrificePyre) {
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
		return new TileEntitySacrificePyre();
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.BEAST;
	}

}
