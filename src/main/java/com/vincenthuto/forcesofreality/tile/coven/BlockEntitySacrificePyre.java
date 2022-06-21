package com.vincenthuto.forcesofreality.tile.coven;

import java.util.Random;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntitySacrificePyre extends DevotionalBlockEntity {
	public int ticks;
	public float flip;
	public float oFlip;
	public float flipT;
	public float flipA;
	public float nextPageTurningSpeed;
	public float pageTurningSpeed;
	public float nextPageAngle;
	public float pageAngle;
	public float tRot;
	public float yFloatLevel;
	private static final Random random = new Random();

	public BlockEntitySacrificePyre(BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityInit.sacrifice_pyre.get(), worldPosition, blockState);
	}

//	@Override
//	public void tick() {
//
//		this.pageTurningSpeed = this.nextPageTurningSpeed;
//		this.pageAngle = this.nextPageAngle;
//		Player playerentity = this.level.getNearestPlayer(this.worldPosition.getX() + 0.5D,
//				this.worldPosition.getY() + 0.5D, this.worldPosition.getZ() + 0.5D, 3.0D, false);
//		if (playerentity != null) {
//			this.yFloatLevel += 0.01;
//			if (this.yFloatLevel > 0) {
//				this.yFloatLevel = 0;
//			}
//			double d0 = playerentity.getX() - (this.worldPosition.getX() + 0.5D);
//			double d1 = playerentity.getZ() - (this.worldPosition.getZ() + 0.5D);
//			this.tRot = (float) Mth.atan2(d1, d0);
//			this.nextPageTurningSpeed += 0.1F;
//			if (this.nextPageTurningSpeed < 0.5F || random.nextInt(40) == 0) {
//				float f1 = this.flipT;
//
//				do {
//					this.flipT += random.nextInt(4) - random.nextInt(4);
//				} while (f1 == this.flipT);
//			}
//		} else {
//			this.yFloatLevel -= 0.01;
//			if (this.yFloatLevel < -0.7) {
//				this.yFloatLevel = -0.7f;
//			}
//			this.nextPageTurningSpeed -= 0.1F;
//		}
//
//		while (this.nextPageAngle >= (float) Math.PI) {
//			this.nextPageAngle -= ((float) Math.PI * 2F);
//		}
//
//		while (this.nextPageAngle < -(float) Math.PI) {
//			this.nextPageAngle += ((float) Math.PI * 2F);
//		}
//
//		while (this.tRot >= (float) Math.PI) {
//			this.tRot -= ((float) Math.PI * 2F);
//		}
//
//		while (this.tRot < -(float) Math.PI) {
//			this.tRot += ((float) Math.PI * 2F);
//		}
//
//		float f2;
//		for (f2 = this.tRot - this.nextPageAngle; f2 >= (float) Math.PI; f2 -= ((float) Math.PI * 2F)) {
//		}
//
//		while (f2 < -(float) Math.PI) {
//			f2 += ((float) Math.PI * 2F);
//		}
//
//		this.nextPageAngle += f2 * 0.4F;
//		this.nextPageTurningSpeed = Mth.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
//		++this.ticks;
//		this.oFlip = this.flip;
//		float f = (this.flipT - this.flip) * 0.4F;
//		f = Mth.clamp(f, -0.2F, 0.2F);
//		this.flipA += (f - this.flipA) * 0.9F;
//		this.flip += this.flipA;
//
//		if (level.isClientSide) {
//			int count = (int) ((int) (4 * 0.5f) + level.random.nextFloat());
//			if (count % 2 == 0) {
//				for (int i = 0; i < level.random.nextInt(count); i++) {
//					double randX = worldPosition.getX();
//					double randY = worldPosition.getY();
//					double randZ = worldPosition.getZ();
//
//					level.addParticle(ParticleTypes.FLAME, randX + 0.5, randY + 0.3, randZ + 0.5, 0, 0.005, 0);
//					level.addParticle(ParticleTypes.SMOKE, randX + 0.5, randY + 0.4, randZ + 0.5, 0, 0.005, 0);
//
//				}
//			}
//		}
//		++this.ticks;
//
//	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.BEAST;
	}
}
