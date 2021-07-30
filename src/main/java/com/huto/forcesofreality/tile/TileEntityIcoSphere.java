package com.huto.forcesofreality.tile;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;

public class TileEntityIcoSphere extends BlockEntity implements TickableBlockEntity{

	public TileEntityIcoSphere() {
		super(TileEntityInit.obj_icosahedron.get());
	}
	@Override
	public AABB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8);
	} 


	@Override
	public void tick() {
		
	}

}
