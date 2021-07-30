package com.huto.forcesofreality.tile;

import com.huto.forcesofreality.init.TileEntityInit;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TileEntityAdornmentModStation extends BlockEntity implements TickableBlockEntity {

	public TileEntityAdornmentModStation() {
		super(TileEntityInit.self_reflection_station.get());
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
