package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.entities.projectiles.EntityCorruptNote;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		if (!worldIn.isRemote) {
			if (playerIn.isCrouching()) {
				this.summonNoteStorm(worldIn.rand.nextInt(3), worldIn, playerIn);
			} else {
				this.summomCorruptNote(1, worldIn, playerIn);
			}
		} else {
			playerIn.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BELL, 0.6F, 0.8F + (float) Math.random() * 0.2F);

		}

		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

	public void summomCorruptNote(int numMiss, World world, PlayerEntity player) {
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
