package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.entities.projectiles.EntityCorruptNote;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemDiscordantBell extends Item {

	public ItemDiscordantBell(Properties properties) {
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
				if (playerentity.isCrouching()) {
					this.summonNoteStorm(worldIn.rand.nextInt(3), worldIn, playerentity);
				} else {
					this.summomCorruptNote(worldIn, playerentity);
				}
			} else {
				playerentity.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BELL, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			}
			stack.damageItem(1, playerentity, (p_220009_1_) -> {
				p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
			});
		}

/*		worldIn.playSound((PlayerEntity) null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(),
				SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
				1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);*/

		((PlayerEntity) entityLiving).addStat(Stats.ITEM_USED.get(this));

	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000/4;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public void summomCorruptNote(World world, PlayerEntity player) {
		EntityCorruptNote missile = new EntityCorruptNote(player, false);
		missile.setPosition(player.getPosX() + (Math.random() - 0.5 * 0.1),
				player.getPosY() + 0.8 + (Math.random() - 0.5 * 0.1), player.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			player.playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addEntity(missile);
		}
	}

	public void summonNoteStorm(int numMiss, World world, PlayerEntity player) {
		EntityCorruptNote[] missArray = new EntityCorruptNote[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityCorruptNote(player, false);
			missArray[i].setPosition(player.getPosX() + ((Math.random() - 0.5) * 3.5), player.getPosY() + 0.8,
					player.getPosZ() + ((Math.random() - 0.5) * 3.5));
			if (!world.isRemote) {
				player.playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				world.addEntity(missArray[i]);

			}
		}
	}

}
