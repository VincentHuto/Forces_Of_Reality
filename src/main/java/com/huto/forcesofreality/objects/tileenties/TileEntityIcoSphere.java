package com.huto.forcesofreality.objects.tileenties;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityIcoSphere extends TileEntity implements ITickableTileEntity{

	public TileEntityIcoSphere() {
		super(TileEntityInit.obj_icosahedron.get());
	}
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(8);
	} 


	@Override
	public void tick() {
		
	}

}
