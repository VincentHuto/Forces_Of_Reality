package com.vincenthuto.forcesofreality.common.item.coven.tool;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityTrackingOrb;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ItemDemonFlute extends Item {

	public ItemDemonFlute(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 4;
	}

	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerentity = (Player) entityLiving;
//			ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
//					.orElseThrow(IllegalArgumentException::new);
		//	if (coven.getDevotionByCoven(EnumCovenants.ELDRITCH) > 3) {
				if (!worldIn.isClientSide) {
					if (worldIn.random.nextInt(10) == 6) {
//						coven.setCovenDevotion(EnumCovenants.ELDRITCH, -1);
//						PacketHandler.CHANNELCOVENANT.send(
//								PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerentity),
//								new PacketCovenantServer(coven.getDevotion()));
						playerentity.displayClientMessage(Component.translatable(
								ChatFormatting.DARK_PURPLE + "Abuse of Power does not come without consequence"), true);
					}
					if (playerentity.isCrouching()) {
						this.summonNoteStorm(worldIn.random.nextInt(3), worldIn, playerentity);
					} else {
						this.summomCorruptNote(worldIn, playerentity);
					}
				} else {
					playerentity.playSound(SoundEvents.HOGLIN_CONVERTED_TO_ZOMBIFIED, 0.2F,
							0.8F + (float) Math.random() * 0.2F);
				}
				stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
					p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
				});
			//} else {
				playerentity.displayClientMessage(Component.translatable("Lord Azathoth does not grant you his power"),
						true);
			//}
		}

		((Player) entityLiving).awardStat(Stats.ITEM_USED.get(this));

	}

	public void summomCorruptNote(Level world, Player player) {
		EntityTrackingOrb missile = new EntityTrackingOrb(player, false);
		missile.setPos(player.getX() + (Math.random() - 0.5 * 0.1), player.getY() + 0.8f,
				player.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			player.playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addFreshEntity(missile);
		}
	}

	public void summonNoteStorm(int numMiss, Level world, Player player) {
		EntityTrackingOrb[] missArray = new EntityTrackingOrb[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityTrackingOrb(player, false);
			missArray[i].setPos(player.getX() + ((Math.random() - 0.5) * 1.5), player.getY() + 0.8f,
					player.getZ() + ((Math.random() - 0.5) * 1.5));
			if (!world.isClientSide) {
				player.playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
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
