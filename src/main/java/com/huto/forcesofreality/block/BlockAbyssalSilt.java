package com.huto.forcesofreality.block;

import com.huto.forcesofreality.entity.mob.EntityScuttlingOcculus;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlockAbyssalSilt extends FallingBlock {

	public BlockAbyssalSilt(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult onBlockActivated(BlockState state, Level worldIn, BlockPos pos, Player player,
			InteractionHand handIn, BlockHitResult hit) {
		ItemStack stack = player.getHeldItemMainhand();
		Item item = stack.getItem();
		if (item == ItemInit.occular_seed.get()) {
			worldIn.setBlockState(pos, BlockInit.occular_heap.get().getDefaultState());
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
				entArray[i].setPosition(pos.getX() + worldIn.rand.nextInt(3) - worldIn.rand.nextInt(3), pos.getY() + 1,
						pos.getZ() + worldIn.rand.nextInt(3) - worldIn.rand.nextInt(3));
				worldIn.addEntity(entArray[i]);
			}
			worldIn.playSound(null, pos, SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.AMBIENT, 10f, 0.01F);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}

}
