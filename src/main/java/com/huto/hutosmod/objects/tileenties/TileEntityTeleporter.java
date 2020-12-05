package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

public class TileEntityTeleporter extends TileEntity {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public TileEntityTeleporter() {
		super(TileEntityInit.teleporter.get());
	}

	public boolean shouldRenderFace(Direction direction) {
		if (getBlockState().getValues().get(FACING).equals(direction)) {
			return true;
		} else {
			return false;
		}
	}

}
