package com.huto.forcesofreality.objects.tileenties;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAdornmentModStation extends TileEntity implements ITickableTileEntity {

	public TileEntityAdornmentModStation() {
		super(TileEntityInit.rune_mod_station.get());
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			int count = (int) ((int) (4 * 0.5f) + world.rand.nextFloat());
			if (count %2 ==  0) {
				for (int i = 0; i < world.rand.nextInt(count); i++) {
					double randX = pos.getX();
					double randY = pos.getY();
					double randZ = pos.getZ() ;
					
					world.addParticle(ParticleTypes.FLAME, randX + 0.1, randY + 1, randZ+0.1, 0, 0.005, 0);
					world.addParticle(ParticleTypes.FLAME, randX + 0.9, randY + 1, randZ + 0.1, 0, 0.005, 0);
					world.addParticle(ParticleTypes.FLAME, randX+0.1, randY + 1, randZ + 0.9, 0, 0.005, 0);
					world.addParticle(ParticleTypes.FLAME, randX + 0.9, randY + 1, randZ + 0.9, 0, 0.005, 0);

				}
			}
		}

	}
}
