package com.huto.hutosmod.objects.tileenties;

import java.util.Random;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.MathHelper;

public class TileEntitySacrificePyre extends TileModDevotion implements ITickableTileEntity {
	public int ticks;
	public float field_195523_f;
	public float field_195524_g;
	public float field_195525_h;
	public float field_195526_i;
	public float nextPageTurningSpeed;
	public float pageTurningSpeed;
	public float nextPageAngle;
	public float pageAngle;
	public float field_195531_n;
	public float yFloatLevel;
	private static final Random random = new Random();

	public TileEntitySacrificePyre() {
		super(TileEntityInit.sacrifice_pyre.get());
	}

	@Override
	public void tick() {

		this.pageTurningSpeed = this.nextPageTurningSpeed;
		this.pageAngle = this.nextPageAngle;
		PlayerEntity playerentity = this.world.getClosestPlayer((double) this.pos.getX() + 0.5D,
				(double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D, 3.0D, false);
		if (playerentity != null) {
			this.yFloatLevel += 0.01;
			if (this.yFloatLevel > 0) {
				this.yFloatLevel = 0;
			}
			double d0 = playerentity.getPosX() - ((double) this.pos.getX() + 0.5D);
			double d1 = playerentity.getPosZ() - ((double) this.pos.getZ() + 0.5D);
			this.field_195531_n = (float) MathHelper.atan2(d1, d0);
			this.nextPageTurningSpeed += 0.1F;
			if (this.nextPageTurningSpeed < 0.5F || random.nextInt(40) == 0) {
				float f1 = this.field_195525_h;

				do {
					this.field_195525_h += (float) (random.nextInt(4) - random.nextInt(4));
				} while (f1 == this.field_195525_h);
			}
		} else {
			this.yFloatLevel -= 0.01;
			if (this.yFloatLevel < -0.7) {
				this.yFloatLevel = -0.7f;
			}
			this.nextPageTurningSpeed -= 0.1F;
		}

		while (this.nextPageAngle >= (float) Math.PI) {
			this.nextPageAngle -= ((float) Math.PI * 2F);
		}

		while (this.nextPageAngle < -(float) Math.PI) {
			this.nextPageAngle += ((float) Math.PI * 2F);
		}

		while (this.field_195531_n >= (float) Math.PI) {
			this.field_195531_n -= ((float) Math.PI * 2F);
		}

		while (this.field_195531_n < -(float) Math.PI) {
			this.field_195531_n += ((float) Math.PI * 2F);
		}

		float f2;
		for (f2 = this.field_195531_n - this.nextPageAngle; f2 >= (float) Math.PI; f2 -= ((float) Math.PI * 2F)) {
		}

		while (f2 < -(float) Math.PI) {
			f2 += ((float) Math.PI * 2F);
		}

		this.nextPageAngle += f2 * 0.4F;
		this.nextPageTurningSpeed = MathHelper.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
		++this.ticks;
		this.field_195524_g = this.field_195523_f;
		float f = (this.field_195525_h - this.field_195523_f) * 0.4F;
		f = MathHelper.clamp(f, -0.2F, 0.2F);
		this.field_195526_i += (f - this.field_195526_i) * 0.9F;
		this.field_195523_f += this.field_195526_i;

		if (world.isRemote) {
			int count = (int) ((int) (4 * 0.5f) + world.rand.nextFloat());
			if (count % 2 == 0) {
				for (int i = 0; i < world.rand.nextInt(count); i++) {
					double randX = pos.getX();
					double randY = pos.getY();
					double randZ = pos.getZ();

					world.addParticle(ParticleTypes.FLAME, randX + 0.5, randY + 0.3, randZ + 0.5, 0, 0.005, 0);
					world.addParticle(ParticleTypes.SMOKE, randX + 0.5, randY + 0.4, randZ + 0.5, 0, 0.005, 0);

				}
			}
		}
		++this.ticks;

	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.BEAST;
	}
}
