package com.vincenthuto.forcesofreality.common.block;

import com.vincenthuto.forcesofreality.common.entity.mob.EntityScuttlingOcculus;
import com.vincenthuto.forcesofreality.registry.BlockInit;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockAbyssalSilt extends FallingBlock {

	public BlockAbyssalSilt(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		ItemStack stack = player.getMainHandItem();
		Item item = stack.getItem();
		if (item == ItemInit.occular_seed.get()) {
			worldIn.setBlockAndUpdate(pos, BlockInit.occular_heap.get().defaultBlockState());
			stack.shrink(1);
			// inner ring
			for (int j = 0; j < 30; j++) {

				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.sin(j) / 9, Math.sin(j) / 3, Math.cos(j) / 9);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.cos(j) / 9, Math.sin(j) / 3, Math.sin(j) / 9);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.sin(-j) / 9, Math.sin(j) / 3, Math.cos(-j) / 9);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.cos(-j) / 9, Math.sin(j) / 3, Math.sin(-j) / 9);

			}
			// outer ring
			for (int i = 0; i < 30; i++) {
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.sin(i) / 3, Math.sin(i) / 3, Math.cos(i) / 3);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.cos(i) / 3, Math.sin(i) / 3, Math.sin(i) / 3);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.sin(-i) / 3, Math.sin(i) / 3, Math.cos(-i) / 3);
				worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
						Math.cos(-i) / 3, Math.sin(i) / 3, Math.sin(-i) / 3);
			}

			EntityScuttlingOcculus[] entArray = new EntityScuttlingOcculus[3];
			for (int i = 0; i < entArray.length; i++) {
				entArray[i] = new EntityScuttlingOcculus(EntityInit.scuttling_occulus.get(), worldIn);
				entArray[i].setPos(pos.getX() + worldIn.random.nextInt(3) - worldIn.random.nextInt(3), pos.getY() + 1,
						pos.getZ() + worldIn.random.nextInt(3) - worldIn.random.nextInt(3));
				worldIn.addFreshEntity(entArray[i]);
			}
			worldIn.playSound(null, pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.AMBIENT, 10f, 0.01F);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}

}
