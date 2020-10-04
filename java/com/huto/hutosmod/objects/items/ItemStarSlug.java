package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.entities.projectiles.EntityStarStrike;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemStarSlug extends Item {

	public ItemStarSlug(Properties properties) {
		super(properties);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			this.summonMissleSwarn(worldIn.rand.nextInt(10), worldIn, playerIn);
		} else {
			playerIn.playSound(SoundHandler.STAR_SLUG_STORM, 0.6F, 0.8F + (float) Math.random() * 0.2F);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
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
