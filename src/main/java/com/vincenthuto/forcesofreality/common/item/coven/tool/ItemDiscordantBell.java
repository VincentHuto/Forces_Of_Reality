package com.vincenthuto.forcesofreality.common.item.coven.tool;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityCorruptNote;
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

public class ItemDiscordantBell extends Item {

	public ItemDiscordantBell(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
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
			//if (coven.getDevotionByCoven(EnumCovenants.ASCENDANT) > 3) {
				if (!worldIn.isClientSide) {
					if (worldIn.random.nextInt(10) == 6) {

					//	coven.setCovenDevotion(EnumCovenants.ASCENDANT, -1);
//						PacketHandler.CHANNELCOVENANT.send(
//								PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerentity),
//								new PacketCovenantServer(coven.getDevotion()));
						playerentity.displayClientMessage(
								Component.translatable(
										ChatFormatting.DARK_AQUA + "Abuse of Power does not come without consequence"),
								true);
					}

					if (playerentity.isCrouching()) {
						this.summonNoteStorm(worldIn.random.nextInt(3), worldIn, playerentity);
					} else {
						this.summomCorruptNote(worldIn, playerentity);
					}
				} else {
					playerentity.playSound(SoundEvents.NOTE_BLOCK_BELL.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
				}
				stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
					p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
				});
			//} else {
				playerentity.displayClientMessage(Component.translatable("Lord Seraph does not grant you his power"),
						true);
		//	}
		}

		((Player) entityLiving).awardStat(Stats.ITEM_USED.get(this));

	}

	public void summomCorruptNote(Level world, Player player) {
		EntityCorruptNote missile = new EntityCorruptNote(player, false);
		missile.setPos(player.getX() + (Math.random() - 0.5 * 0.1), player.getY() + 0.8 + (Math.random() - 0.5 * 0.1),
				player.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			player.playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addFreshEntity(missile);
		}
	}

	public void summonNoteStorm(int numMiss, Level world, Player player) {
		EntityCorruptNote[] missArray = new EntityCorruptNote[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityCorruptNote(player, false);
			missArray[i].setPos(player.getX() + ((Math.random() - 0.5) * 3.5), player.getY() + 0.8,
					player.getZ() + ((Math.random() - 0.5) * 3.5));
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
