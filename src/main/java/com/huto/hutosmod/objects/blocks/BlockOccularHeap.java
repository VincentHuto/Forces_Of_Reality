package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;
import com.huto.hutosmod.objects.blocks.util.IBlockDevotionStation;
import com.huto.hutosmod.objects.items.ItemSacrificial;
import com.huto.hutosmod.objects.tileenties.TileEntityOccularHeap;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
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

public class BlockOccularHeap extends Block implements IBlockDevotionStation {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(7, 10, 7, 9, 12, 9),
			Block.makeCuboidShape(2, 1, 6, 5, 3, 13), Block.makeCuboidShape(5, 1, 3, 8, 3, 14),
			Block.makeCuboidShape(8, 1, 2, 11, 3, 12), Block.makeCuboidShape(11, 1, 4, 14, 3, 15),
			Block.makeCuboidShape(1, 0, 1, 15, 1, 15), Block.makeCuboidShape(9, 3, 6, 12, 5, 9),
			Block.makeCuboidShape(4, 3, 5, 7, 5, 13), Block.makeCuboidShape(7, 3, 9, 13, 5, 13),
			Block.makeCuboidShape(7, 3, 2, 10, 5, 6), Block.makeCuboidShape(6, 5, 4, 9, 7, 7),
			Block.makeCuboidShape(9, 5, 8, 12, 7, 11), Block.makeCuboidShape(10, 5, 10, 13, 6, 13),
			Block.makeCuboidShape(3, 5, 6, 7, 7, 9), Block.makeCuboidShape(5, 5, 9, 9, 7, 12),
			Block.makeCuboidShape(9, 5, 5, 13, 7, 8), Block.makeCuboidShape(3, 1, 4, 5, 2, 6),
			Block.makeCuboidShape(11, 1, 3, 13, 2, 4), Block.makeCuboidShape(9, 7, 7, 11, 9, 10),
			Block.makeCuboidShape(7, 7, 9, 9, 8, 11), Block.makeCuboidShape(5, 7, 5, 7, 8, 7),
			Block.makeCuboidShape(7, 7, 5, 11, 9, 7), Block.makeCuboidShape(5, 7, 7, 7, 9, 10),
			Block.makeCuboidShape(8.15, 8, 3.8499999999999996, 11.15, 10, 6.85),
			Block.makeCuboidShape(9.15, 8, 6.85, 12.15, 10, 10.85),
			Block.makeCuboidShape(9.15, 10, 6.85, 11.15, 11, 8.85),
			Block.makeCuboidShape(7.15, 10, 8.85, 10.15, 12, 10.85),
			Block.makeCuboidShape(6.15, 8, 8.85, 9.15, 10, 12.85),
			Block.makeCuboidShape(5.15, 8, 2.8499999999999996, 8.15, 10, 6.85),
			Block.makeCuboidShape(5.15, 10, 4.85, 7.15, 12, 8.85),
			Block.makeCuboidShape(7.15, 10, 4.85, 10.15, 12, 6.85),
			Block.makeCuboidShape(4.15, 8, 6.85, 7.15, 10, 9.85),
			Block.makeCuboidShape(5.15, 10, 8.85, 7.15, 11, 10.85), Block.makeCuboidShape(4, 4, 3, 6, 6, 5),
			Block.makeCuboidShape(3, 6, 9, 5, 8, 11), Block.makeCuboidShape(11, 3, 4, 13, 5, 6),
			Block.makeCuboidShape(10, 9, 4, 12, 11, 6), Block.makeCuboidShape(7, 12, 7, 9, 14, 9),
			Block.makeCuboidShape(10, 6, 11, 12, 8, 13)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(7.461538461538464, 10, 7.000000000000002, 9.461538461538463, 12, 9),
			Block.makeCuboidShape(6.461538461538464, 1, 11, 13.461538461538463, 3, 14),
			Block.makeCuboidShape(3.4615384615384643, 1, 8, 14.461538461538463, 3, 11),
			Block.makeCuboidShape(2.4615384615384643, 1, 5.000000000000002, 12.461538461538463, 3, 8),
			Block.makeCuboidShape(4.461538461538464, 1, 2.0000000000000018, 15.461538461538463, 3, 5.000000000000002),
			Block.makeCuboidShape(1.4615384615384643, 0, 1.0000000000000018, 15.461538461538463, 1, 15),
			Block.makeCuboidShape(6.461538461538464, 3, 4.000000000000002, 9.461538461538463, 5, 7.000000000000002),
			Block.makeCuboidShape(5.461538461538464, 3, 9, 13.461538461538463, 5, 12),
			Block.makeCuboidShape(9.461538461538463, 3, 3.0000000000000018, 13.461538461538463, 5, 9),
			Block.makeCuboidShape(2.4615384615384643, 3, 6.000000000000002, 6.461538461538464, 5, 9),
			Block.makeCuboidShape(4.461538461538464, 5, 7.000000000000002, 7.461538461538464, 7, 10),
			Block.makeCuboidShape(8.461538461538463, 5, 4.000000000000002, 11.461538461538463, 7, 7.000000000000002),
			Block.makeCuboidShape(10.461538461538463, 5, 3.0000000000000018, 13.461538461538463, 6, 6.000000000000002),
			Block.makeCuboidShape(6.461538461538464, 5, 9, 9.461538461538463, 7, 13),
			Block.makeCuboidShape(9.461538461538463, 5, 7.000000000000002, 12.461538461538463, 7, 11),
			Block.makeCuboidShape(5.461538461538464, 5, 3.0000000000000018, 8.461538461538463, 7, 7.000000000000002),
			Block.makeCuboidShape(4.461538461538464, 1, 11, 6.461538461538464, 2, 13),
			Block.makeCuboidShape(3.4615384615384643, 1, 3.0000000000000018, 4.461538461538464, 2, 5.000000000000002),
			Block.makeCuboidShape(7.461538461538464, 7, 5.000000000000002, 10.461538461538463, 9, 7.000000000000002),
			Block.makeCuboidShape(9.461538461538463, 7, 7.000000000000002, 11.461538461538463, 8, 9),
			Block.makeCuboidShape(5.461538461538464, 7, 9, 7.461538461538464, 8, 11),
			Block.makeCuboidShape(5.461538461538464, 7, 5.000000000000002, 7.461538461538464, 9, 9),
			Block.makeCuboidShape(7.461538461538464, 7, 9, 10.461538461538463, 9, 11),
			Block.makeCuboidShape(4.393701831248625, 8, 4.8015246918115775, 7.393701831248625, 10, 7.801524691811578),
			Block.makeCuboidShape(7.393701831248628, 8, 3.8015246918115775, 11.393701831248627, 10, 6.8015246918115775),
			Block.makeCuboidShape(7.393701831248628, 10, 4.8015246918115775, 9.393701831248627, 11, 6.8015246918115775),
			Block.makeCuboidShape(9.393701831248627, 10, 5.8015246918115775, 11.393701831248627, 12, 8.80152469181158),
			Block.makeCuboidShape(9.393701831248627, 8, 6.8015246918115775, 13.393701831248627, 10, 9.80152469181158),
			Block.makeCuboidShape(3.3937018312486247, 8, 7.801524691811578, 7.393701831248625, 10, 10.80152469181158),
			Block.makeCuboidShape(5.393701831248628, 10, 8.80152469181158, 9.393701831248627, 12, 10.80152469181158),
			Block.makeCuboidShape(5.393701831248625, 10, 5.8015246918115775, 7.393701831248625, 12, 8.80152469181158),
			Block.makeCuboidShape(7.393701831248628, 8, 8.80152469181158, 10.393701831248627, 10, 11.80152469181158),
			Block.makeCuboidShape(9.393701831248627, 10, 8.80152469181158, 11.393701831248627, 11, 10.80152469181158),
			Block.makeCuboidShape(3.4615384615384643, 4, 10, 5.461538461538464, 6, 12),
			Block.makeCuboidShape(5.816555668396135, 6, 11.338228432282307, 7.816555668396135, 8, 13.338228432282307),
			Block.makeCuboidShape(7.9378760119557805, 3, 2.145840276857191, 9.93787601195578, 5, 4.145840276857191),
			Block.makeCuboidShape(4.461538461538464, 9, 4.000000000000002, 6.461538461538464, 11, 6.000000000000002),
			Block.makeCuboidShape(7.461538461538464, 12, 7.000000000000002, 9.461538461538463, 14, 9),
			Block.makeCuboidShape(12.199229065635695, 6, 5.829840431513356, 14.199229065635695, 8, 7.829840431513355))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(7.461538461538464, 10, 6.538461538461538, 9.461538461538463, 12, 8.538461538461537),
			Block.makeCuboidShape(11.461538461538463, 1, 2.5384615384615383, 14.461538461538463, 3, 9.538461538461537),
			Block.makeCuboidShape(8.461538461538463, 1, 1.5384615384615383, 11.461538461538463, 3, 12.538461538461537),
			Block.makeCuboidShape(5.461538461538464, 1, 3.5384615384615383, 8.461538461538463, 3, 13.538461538461537),
			Block.makeCuboidShape(2.4615384615384643, 1, 0.5384615384615383, 5.461538461538464, 3, 11.538461538461537),
			Block.makeCuboidShape(1.4615384615384643, 0, 0.5384615384615383, 15.461538461538463, 1, 14.538461538461537),
			Block.makeCuboidShape(4.461538461538464, 3, 6.538461538461538, 7.461538461538464, 5, 9.538461538461537),
			Block.makeCuboidShape(9.461538461538463, 3, 2.5384615384615383, 12.461538461538463, 5, 10.538461538461537),
			Block.makeCuboidShape(3.4615384615384643, 3, 2.5384615384615383, 9.461538461538463, 5, 6.538461538461538),
			Block.makeCuboidShape(6.461538461538464, 3, 9.538461538461537, 9.461538461538463, 5, 13.538461538461537),
			Block.makeCuboidShape(7.461538461538464, 5, 8.538461538461537, 10.461538461538463, 7, 11.538461538461537),
			Block.makeCuboidShape(4.461538461538464, 5, 4.538461538461538, 7.461538461538464, 7, 7.538461538461537),
			Block.makeCuboidShape(3.4615384615384643, 5, 2.5384615384615383, 6.461538461538464, 6, 5.538461538461538),
			Block.makeCuboidShape(9.461538461538463, 5, 6.538461538461538, 13.461538461538463, 7, 9.538461538461537),
			Block.makeCuboidShape(7.461538461538464, 5, 3.5384615384615383, 11.461538461538463, 7, 6.538461538461538),
			Block.makeCuboidShape(3.4615384615384643, 5, 7.538461538461537, 7.461538461538464, 7, 10.538461538461537),
			Block.makeCuboidShape(11.461538461538463, 1, 9.538461538461537, 13.461538461538463, 2, 11.538461538461537),
			Block.makeCuboidShape(3.4615384615384643, 1, 11.538461538461537, 5.461538461538464, 2, 12.538461538461537),
			Block.makeCuboidShape(5.461538461538464, 7, 5.538461538461538, 7.461538461538464, 9, 8.538461538461537),
			Block.makeCuboidShape(7.461538461538464, 7, 4.538461538461538, 9.461538461538463, 8, 6.538461538461538),
			Block.makeCuboidShape(9.461538461538463, 7, 8.538461538461537, 11.461538461538463, 8, 10.538461538461537),
			Block.makeCuboidShape(5.461538461538464, 7, 8.538461538461537, 9.461538461538463, 9, 10.538461538461537),
			Block.makeCuboidShape(9.461538461538463, 7, 5.538461538461538, 11.461538461538463, 9, 8.538461538461537),
			Block.makeCuboidShape(5.26306315335004, 8, 8.606298168751376, 8.263063153350041, 10, 11.606298168751376),
			Block.makeCuboidShape(4.26306315335004, 8, 4.606298168751374, 7.26306315335004, 10, 8.606298168751373),
			Block.makeCuboidShape(5.26306315335004, 10, 6.606298168751374, 7.26306315335004, 11, 8.606298168751373),
			Block.makeCuboidShape(6.26306315335004, 10, 4.606298168751374, 9.263063153350041, 12, 6.606298168751374),
			Block.makeCuboidShape(7.26306315335004, 8, 2.6062981687513744, 10.263063153350041, 10, 6.606298168751374),
			Block.makeCuboidShape(8.263063153350041, 8, 8.606298168751376, 11.263063153350041, 10, 12.606298168751376),
			Block.makeCuboidShape(9.263063153350041, 10, 6.606298168751374, 11.263063153350041, 12, 10.606298168751373),
			Block.makeCuboidShape(6.26306315335004, 10, 8.606298168751376, 9.263063153350041, 12, 10.606298168751376),
			Block.makeCuboidShape(9.263063153350041, 8, 5.606298168751374, 12.263063153350041, 10, 8.606298168751373),
			Block.makeCuboidShape(9.263063153350041, 10, 4.606298168751374, 11.263063153350041, 11, 6.606298168751374),
			Block.makeCuboidShape(10.461538461538463, 4, 10.538461538461537, 12.461538461538463, 6, 12.538461538461537),
			Block.makeCuboidShape(11.79976689382077, 6, 8.183444331603866, 13.79976689382077, 8, 10.183444331603866),
			Block.makeCuboidShape(2.6073787383956537, 3, 6.062123988044222, 4.607378738395654, 5, 8.06212398804422),
			Block.makeCuboidShape(4.461538461538464, 9, 9.538461538461537, 6.461538461538464, 11, 11.538461538461537),
			Block.makeCuboidShape(7.461538461538464, 12, 6.538461538461538, 9.461538461538463, 14, 8.538461538461537),
			Block.makeCuboidShape(6.291378893051818, 6, 1.8007709343643068, 8.291378893051817, 8, 3.800770934364307))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(7.000000000000001, 10, 6.538461538461537, 9, 12, 8.538461538461537),
			Block.makeCuboidShape(3.000000000000001, 1, 1.5384615384615374, 10, 3, 4.538461538461537),
			Block.makeCuboidShape(2.000000000000001, 1, 4.538461538461537, 13, 3, 7.538461538461537),
			Block.makeCuboidShape(4.000000000000001, 1, 7.538461538461537, 14, 3, 10.538461538461537),
			Block.makeCuboidShape(1.0000000000000009, 1, 10.538461538461537, 12, 3, 13.538461538461537),
			Block.makeCuboidShape(1.0000000000000009, 0, 0.5384615384615374, 15, 1, 14.538461538461537),
			Block.makeCuboidShape(7.000000000000001, 3, 8.538461538461537, 10, 5, 11.538461538461537),
			Block.makeCuboidShape(3.000000000000001, 3, 3.5384615384615374, 11, 5, 6.538461538461537),
			Block.makeCuboidShape(3.000000000000001, 3, 6.538461538461537, 7.000000000000001, 5, 12.538461538461537),
			Block.makeCuboidShape(10, 3, 6.538461538461537, 14, 5, 9.538461538461537),
			Block.makeCuboidShape(9, 5, 5.538461538461537, 12, 7, 8.538461538461537),
			Block.makeCuboidShape(5.000000000000001, 5, 8.538461538461537, 8, 7, 11.538461538461537),
			Block.makeCuboidShape(3.000000000000001, 5, 9.538461538461537, 6.000000000000001, 6, 12.538461538461537),
			Block.makeCuboidShape(7.000000000000001, 5, 2.5384615384615374, 10, 7, 6.538461538461537),
			Block.makeCuboidShape(4.000000000000001, 5, 4.538461538461537, 7.000000000000001, 7, 8.538461538461537),
			Block.makeCuboidShape(8, 5, 8.538461538461537, 11, 7, 12.538461538461537),
			Block.makeCuboidShape(10, 1, 2.5384615384615374, 12, 2, 4.538461538461537),
			Block.makeCuboidShape(12, 1, 10.538461538461537, 13, 2, 12.538461538461537),
			Block.makeCuboidShape(6.000000000000001, 7, 8.538461538461537, 9, 9, 10.538461538461537),
			Block.makeCuboidShape(5.000000000000001, 7, 6.538461538461537, 7.000000000000001, 8, 8.538461538461537),
			Block.makeCuboidShape(9, 7, 4.538461538461537, 11, 8, 6.538461538461537),
			Block.makeCuboidShape(9, 7, 6.538461538461537, 11, 9, 10.538461538461537),
			Block.makeCuboidShape(6.000000000000001, 7, 4.538461538461537, 9, 9, 6.538461538461537),
			Block.makeCuboidShape(9.067836630289838, 8, 7.73693684664996, 12.067836630289838, 10, 10.73693684664996),
			Block.makeCuboidShape(5.067836630289837, 8, 8.73693684664996, 9.067836630289836, 10, 11.73693684664996),
			Block.makeCuboidShape(7.067836630289837, 10, 8.73693684664996, 9.067836630289836, 11, 10.73693684664996),
			Block.makeCuboidShape(5.067836630289837, 10, 6.73693684664996, 7.067836630289837, 12, 9.73693684664996),
			Block.makeCuboidShape(3.067836630289837, 8, 5.73693684664996, 7.067836630289837, 10, 8.73693684664996),
			Block.makeCuboidShape(9.067836630289838, 8, 4.73693684664996, 13.067836630289838, 10, 7.73693684664996),
			Block.makeCuboidShape(7.067836630289837, 10, 4.73693684664996, 11.067836630289836, 12, 6.73693684664996),
			Block.makeCuboidShape(9.067836630289838, 10, 6.73693684664996, 11.067836630289838, 12, 9.73693684664996),
			Block.makeCuboidShape(6.067836630289837, 8, 3.73693684664996, 9.067836630289836, 10, 6.73693684664996),
			Block.makeCuboidShape(5.067836630289837, 10, 4.73693684664996, 7.067836630289837, 11, 6.73693684664996),
			Block.makeCuboidShape(11, 4, 3.5384615384615374, 13, 6, 5.538461538461537),
			Block.makeCuboidShape(8.644982793142328, 6, 2.2002331061792306, 10.644982793142328, 8, 4.200233106179231),
			Block.makeCuboidShape(6.523662449582685, 3, 11.392621261604347, 8.523662449582684, 5, 13.392621261604347),
			Block.makeCuboidShape(10, 9, 9.538461538461537, 12, 11, 11.538461538461537),
			Block.makeCuboidShape(7.000000000000001, 12, 6.538461538461537, 9, 14, 8.538461538461537),
			Block.makeCuboidShape(2.2623093959027694, 6, 7.708621106948184, 4.262309395902769, 8, 9.708621106948183))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockOccularHeap(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		TileEntityOccularHeap te = (TileEntityOccularHeap) worldIn.getTileEntity(pos);
		ICovenant coven = player.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		ItemStack stack = player.getHeldItemMainhand();
		// Upgrade clause

		if (stack.isEmpty()) {
			if (!worldIn.isRemote) {
				player.sendStatusMessage(new StringTextComponent(
						TextFormatting.LIGHT_PURPLE + "Altar Strength:" + Integer.toString(te.devo.getDevotion())),
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
					player.playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 0.6F, 0.8F);
					return ActionResultType.SUCCESS;
				} else {
					te.checkStructure();
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

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
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
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
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
		return new TileEntityOccularHeap();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ELDRITCH;
	}

}
