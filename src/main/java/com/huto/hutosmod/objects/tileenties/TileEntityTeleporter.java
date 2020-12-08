package com.huto.hutosmod.objects.tileenties;

import java.util.Optional;

import com.huto.hutosmod.dimension.DimensionalPosition;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.vibes.TileModVibes;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityTeleporter extends TileModVibes implements ITickableTileEntity{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public TileEntityTeleporter() {
		super(TileEntityInit.teleporter.get());
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		// TODO Auto-generated method stub
		super.read(state, nbt);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		// TODO Auto-generated method stub
		return super.write(compound);
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		// TODO Auto-generated method stub
		return super.getRenderBoundingBox().grow(8);
	}

	public boolean shouldRenderFace(Direction direction) {
		if (getBlockState().getValues().get(FACING).equals(direction)) {
			return true;
		} else {
			return false;
		}
	}

	public void setTeleportPosition( World world, BlockPos pos, ResourceLocation resourceLocation, PlayerEntity player) {
		CompoundNBT data = getTileData();
		DimensionalPosition dp = new DimensionalPosition(resourceLocation, pos);
		CompoundNBT dimNbt = dp.serializeNBT();
		data.put("dim-lastpos", dimNbt);
	}

	public Optional<DimensionalPosition> getTeleportPosition() {
		CompoundNBT data = getTileData();
		if (!data.contains("dim-lastpos")) {
			return Optional.empty();
		}
		CompoundNBT pos = data.getCompound("dim-lastpos");
		return Optional.of(DimensionalPosition.fromNBT(pos));
	}

	@Override
	public void tick() {
	}

}
