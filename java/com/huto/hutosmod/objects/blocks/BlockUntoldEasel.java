package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import javax.annotation.Nonnull;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.network.CovenantPacketServer;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.objects.blocks.util.IBlockDevotionStation;
import com.huto.hutosmod.objects.items.ItemSacrificial;
import com.huto.hutosmod.objects.tileenties.TileEntityUntoldEasel;
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
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class BlockUntoldEasel extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Block.makeCuboidShape(4, 0, 4, 13, 17, 13);

	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);

	public BlockUntoldEasel(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntityUntoldEasel te = (TileEntityUntoldEasel) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause
		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(
						new StringTextComponent(
								TextFormatting.YELLOW + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
		TileEntityUntoldEasel tile = (TileEntityUntoldEasel) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityUntoldEasel) {
			int count = (int) (6 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() + random.nextDouble();
					double randY = pos.getY() + random.nextDouble();
					double randZ = pos.getZ() + random.nextDouble();
					world.addParticle(ParticleTypes.FALLING_HONEY, randX, randY, randZ, 0, 0, 0);
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
		return new TileEntityUntoldEasel();
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.HASTUR;
	}

}
