package com.huto.forces_of_reality.objects.tileenties;

import java.util.List;

import com.huto.forces_of_reality.init.TileEntityInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class TileEntitySlimeRepelent extends TileEntity implements ITickableTileEntity {

	public TileEntitySlimeRepelent() {
		super(TileEntityInit.slime_repelent.get());
	}

	@Override
	public void tick() {
		repel(world, new AxisAlignedBB(pos.add(-4, -4, -4), pos.add(4, 4, 4)), pos.getX() + 0.5,
				pos.getY() + 0.5, pos.getZ() + 0.5);
	}

	public static void repel(World world, AxisAlignedBB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, effectBounds);
		for (Entity ent : list) {
			if (ent instanceof SlimeEntity) {

				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);

				ent.setMotion(r.x / 1.2D / distance, r.y / 1.2D / distance, r.z / 1.2D / distance);

				for (int countparticles = 0; countparticles <= 10; ++countparticles) {
					world.addParticle(RedstoneParticleData.REDSTONE_DUST,
							ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
							ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
									- (double) ent.getYOffset() - 0.5,
							ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
							0.0D);

				}
			}
		}
	}
}
