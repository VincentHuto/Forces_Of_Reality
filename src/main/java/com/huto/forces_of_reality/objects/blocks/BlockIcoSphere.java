package com.huto.forces_of_reality.objects.blocks;

import com.huto.forces_of_reality.objects.tileenties.TileEntityIcoSphere;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockIcoSphere extends Block {

	public BlockIcoSphere(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {

		return new TileEntityIcoSphere();
	}

}
