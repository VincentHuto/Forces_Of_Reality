package com.vincenthuto.forcesofreality.common.block;
/*
 * package com.vincenthuto.forcesofreality.objects.blocks;
 *
 * import
 * com.vincenthuto.forcesofreality.objects.tileenties.BlockEntityChiselStation;
 *
 * import net.minecraft.block.Block; import net.minecraft.block.BlockState;
 * import net.minecraft.block.HorizontalBlock; import
 * net.minecraft.entity.player.PlayerEntity; import
 * net.minecraft.entity.player.ServerPlayerEntity; import
 * net.minecraft.inventory.InventoryHelper; import
 * net.minecraft.item.BlockPlaceContext; import
 * net.minecraft.state.DirectionProperty; import
 * net.minecraft.state.StateContainer.Builder; import
 * net.minecraft.BlockEntity.BlockEntity; import
 * net.minecraft.util.InteractionResult; import net.minecraft.util.Direction;
 * import net.minecraft.util.Hand; import net.minecraft.util.Mirror; import
 * net.minecraft.util.Rotation; import net.minecraft.util.math.BlockPos; import
 * net.minecraft.util.math.BlockRayTraceResult; import
 * net.minecraft.util.math.shapes.IBooleanFunction; import
 * net.minecraft.util.math.shapes.CollisionContext; import
 * net.minecraft.util.math.shapes.VoxelShape; import
 * net.minecraft.util.math.shapes.VoxelShapes; import
 * net.minecraft.world.BlockGetter; import net.minecraft.world.LevelReader;
 * import net.minecraft.world.World; import
 * net.minecraftforge.fml.network.NetworkHooks;
 *
 * public class BlockChiselStation extends Block { public static final
 * DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING; private static
 * final VoxelShape SHAPE_N =
 * VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 4, 12, 3, 12),
 * Block.makeCuboidShape(2, 3, 2, 14, 7, 14), IBooleanFunction.OR);
 *
 * public BlockChiselStation(Properties properties) { super(properties);
 * this.setDefaultState(this.stateContainer.getBaseState().with(FACING,
 * Direction.SOUTH));
 *
 * }
 *
 * @Override public InteractionResult onBlockActivated(BlockState state, World
 * worldIn, BlockPos pos, Player player, Hand handIn, BlockRayTraceResult
 * result) { if (!worldIn.isRemote) { BlockEntity tile =
 * worldIn.getBlockEntity(pos); if (tile instanceof BlockEntityChiselStation) {
 * BlockEntityChiselStation te = (BlockEntityChiselStation) tile; if
 * (te.numPlayersUsing < 2) { NetworkHooks.openGui((ServerPlayerEntity) player,
 * (BlockEntityChiselStation) tile, pos); return InteractionResult.SUCCESS; }
 * }else { return InteractionResult.PASS;
 *
 * } } return InteractionResult.FAIL; }
 *
 * @Override public void onReplaced(BlockState state, Level worldIn, BlockPos
 * pos, BlockState newState, boolean isMoving) { if (state.getBlock() !=
 * newState.getBlock()) { BlockEntity te = worldIn.getBlockEntity(pos); if (te
 * instanceof BlockEntityChiselStation) { InventoryHelper.dropItems(worldIn,
 * pos, ((BlockEntityChiselStation) te).getItems()); } }
 *
 * }
 *
 * @Override public VoxelShape getShape(BlockState state, BlockGetter worldIn,
 * BlockPos pos, CollisionContext context) { return SHAPE_N; }
 *
 * @Override public void onNeighborChange(BlockState state, LevelReader world,
 * BlockPos pos, BlockPos neighbor) { }
 *
 * @Override public void neighborChanged(BlockState state, Level worldIn,
 * BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) { }
 *
 * @Override public BlockState getStateForPlacement(BlockPlaceContext context)
 * { return this.getDefaultState().with(FACING,
 * context.getPlacementHorizontalFacing().getOpposite()); }
 *
 * @Override public BlockState rotate(BlockState state, Rotation rot) { return
 * state.with(FACING, rot.rotate(state.get(FACING))); }
 *
 * @SuppressWarnings("deprecation")
 *
 * @Override public BlockState mirror(BlockState state, Mirror mirrorIn) {
 * return state.rotate(mirrorIn.toRotation(state.get(FACING))); }
 *
 * @Override protected void fillStateContainer(Builder<Block, BlockState>
 * builder) { builder.add(FACING); }
 *
 * @Override public boolean hasBlockEntity(BlockState state) { return true; }
 *
 * @Override public BlockEntity createBlockEntity(BlockState state, BlockGetter
 * world) { return new BlockEntityChiselStation(); }
 *
 * @SuppressWarnings("deprecation")
 *
 * @Override public void onBlockClicked(BlockState state, Level worldIn,
 * BlockPos pos, Player player) { super.onBlockClicked(state, worldIn,
 * pos, player); }
 *
 * }
 */