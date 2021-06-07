package com.huto.forcesofreality.item.coven.tool;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.entity.projectile.EntityTrackingOrb;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.sound.SoundHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemDemonFlute extends Item {

	public ItemDemonFlute(Properties properties) {
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
			ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalArgumentException::new);
			if (coven.getDevotionByCoven(EnumCovenants.ELDRITCH) > 3) {
				if (!worldIn.isRemote) {
					if (worldIn.rand.nextInt(10) == 6) {
						coven.setCovenDevotion(EnumCovenants.ELDRITCH, -1);
						PacketHandler.CHANNELCOVENANT.send(
								PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerentity),
								new CovenantPacketServer(coven.getDevotion()));
						playerentity.sendStatusMessage(new StringTextComponent(
								TextFormatting.DARK_PURPLE + "Abuse of Power does not come without consequence"), true);
					}
					if (playerentity.isCrouching()) {
						this.summonNoteStorm(worldIn.rand.nextInt(3), worldIn, playerentity);
					} else {
						this.summomCorruptNote(worldIn, playerentity);
					}
				} else {
					playerentity.playSound(SoundEvents.ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED, 0.2F,
							0.8F + (float) Math.random() * 0.2F);
				}
				stack.damageItem(1, playerentity, (p_220009_1_) -> {
					p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
				});
			} else {
				playerentity.sendStatusMessage(new StringTextComponent("Lord Azathoth does not grant you his power"),
						true);
			}
		}

		((PlayerEntity) entityLiving).addStat(Stats.ITEM_USED.get(this));

	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 4;
	}
	
	

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	public void summomCorruptNote(World world, PlayerEntity player) {
		EntityTrackingOrb missile = new EntityTrackingOrb(player, false);
		missile.setPosition(player.getPosX() + (Math.random() - 0.5 * 0.1), player.getPosY() + 0.8f,
				player.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			player.playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addEntity(missile);
		}
	}

	public void summonNoteStorm(int numMiss, World world, PlayerEntity player) {
		EntityTrackingOrb[] missArray = new EntityTrackingOrb[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityTrackingOrb(player, false);
			missArray[i].setPosition(player.getPosX() + ((Math.random() - 0.5) * 1.5), player.getPosY() + 0.8f,
					player.getPosZ() + ((Math.random() - 0.5) * 1.5));
			if (!world.isRemote) {
				player.playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				world.addEntity(missArray[i]);

			}
		}
	}

}
