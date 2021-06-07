package com.huto.forcesofreality.item.coven.tool;

import com.huto.forcesofreality.entity.projectile.EntityStarStrike;
import com.huto.forcesofreality.sound.SoundHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemStarSlug extends Item {

	public ItemStarSlug(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);

	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;

			if (!worldIn.isRemote) {
				this.summonMissleSwarn(worldIn.rand.nextInt(25), worldIn, playerentity);
			} else {
				entityLiving.playSound(SoundHandler.ITEM_STAR_SLUG_STRIKE, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			}
			stack.damageItem(1, playerentity, (p_220009_1_) -> {
				p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
			});
		}
		/*
		 * worldIn.playSound((PlayerEntity) null, entityLiving.getPosX(),
		 * entityLiving.getPosY(), entityLiving.getPosZ(),
		 * SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F /
		 * (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
		 */

		((PlayerEntity) entityLiving).addStat(Stats.ITEM_USED.get(this));

	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public void summonMissleSwarn(int numMiss, World world, PlayerEntity player) {
		EntityStarStrike[] missArray = new EntityStarStrike[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityStarStrike(player, false);
			float xMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (world.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPosition(player.getPosX() + 0.5 + xMod, player.getPosY() + 1.5 + yMod,
					player.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(missArray[i]);

			}
		}
	}

}
