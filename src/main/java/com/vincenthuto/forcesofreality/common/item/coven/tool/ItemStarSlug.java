package com.vincenthuto.forcesofreality.common.item.coven.tool;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityStarStrike;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ItemStarSlug extends Item {

	public ItemStarSlug(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerentity = (Player) entityLiving;

			if (!worldIn.isClientSide) {
				this.summonMissleSwarn(worldIn.random.nextInt(25), worldIn, playerentity);
			} else {
				entityLiving.playSound(SoundInit.ITEM_STAR_SLUG_STRIKE.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
			}
			stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
				p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
			});
		}
		/*
		 * worldIn.playSound((PlayerEntity) null, entityLiving.getPosX(),
		 * entityLiving.getPosY(), entityLiving.getPosZ(),
		 * SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F /
		 * (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
		 */

		((Player) entityLiving).awardStat(Stats.ITEM_USED.get(this));

	}

	public void summonMissleSwarn(int numMiss, Level world, Player player) {
		EntityStarStrike[] missArray = new EntityStarStrike[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityStarStrike(player, false);
			float xMod = (world.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (world.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (world.random.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPos(player.getX() + 0.5 + xMod, player.getY() + 1.5 + yMod, player.getZ() + 0.5 + zMod);
			if (!world.isClientSide) {
				world.addFreshEntity(missArray[i]);

			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);

		playerIn.startUsingItem(handIn);
		return InteractionResultHolder.consume(itemstack);

	}

}
