package com.vincenthuto.forcesofreality.item.coven.tool;

import com.vincenthuto.forcesofreality.entity.projectile.EntityHolySpirit;
import com.vincenthuto.forcesofreality.init.EntityInit;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ItemDivineFeather extends Item {

	public ItemDivineFeather(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 2;
	}

	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerentity = (Player) entityLiving;

			if (!worldIn.isClientSide) {
//				ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
			//	if (coven.getDevotionByCoven(EnumCovenants.ASCENDANT) > 3) {
					if (!worldIn.isClientSide) {

						if (worldIn.random.nextInt(10) == 6) {

//							coven.setCovenDevotion(EnumCovenants.ASCENDANT, -1);
//							PacketHandler.CHANNELCOVENANT.send(
//									PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerentity),
//									new CovenantPacketServer(coven.getDevotion()));
							playerentity.displayClientMessage(Component.translatable(
									ChatFormatting.DARK_AQUA + "Abuse of Power does not come without consequence"),
									true);
						}

						EntityHolySpirit miss = new EntityHolySpirit(EntityInit.holy_spirit.get(), worldIn);
						miss.setPos(playerentity.getX(), playerentity.getY() + 1.5, playerentity.getZ());
						miss.setDirectionMotion(playerentity, playerentity.getXRot(), playerentity.getYRot(), 0.0F, 0.65F, 0F);
						worldIn.addFreshEntity(miss);
					}
				//} else {
					playerentity.displayClientMessage(
							Component.translatable("Lord Seraph does not grant you his power"), true);
				}
				stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
					p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
				});
			}

			//layerentity.awardStat(Stats.ITEM_USED.get(this));
		//}
	}

	public void summonTentacleAid(int numTent, Level world, Player player, Vec3 hitVec) {
		EntityHolySpirit[] tentArray = new EntityHolySpirit[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityHolySpirit(EntityInit.holy_spirit.get(), world);
			tentArray[i].setPos(hitVec.x() + 0.5, hitVec.y() + 1, hitVec.z() + 0.5);
			if (!world.isClientSide) {
				world.addFreshEntity(tentArray[i]);

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
