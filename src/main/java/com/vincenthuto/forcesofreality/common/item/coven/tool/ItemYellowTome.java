package com.vincenthuto.forcesofreality.common.item.coven.tool;

import com.vincenthuto.forcesofreality.common.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityPlayerTentacle;
import com.vincenthuto.forcesofreality.registry.EntityInit;

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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ItemYellowTome extends Item {

	public ItemYellowTome(Properties properties) {
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
				HitResult result = entityLiving.pick(100, 0, false);
				Vec3 hitVec = result.getLocation();
//				ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalArgumentException::new);
//				if (coven.getDevotionByCoven(EnumCovenants.HASTUR) >= 10) {
					if (!worldIn.isClientSide) {
						if (worldIn.random.nextInt(10) == 6) {

//							coven.setCovenDevotion(EnumCovenants.HASTUR,
//									coven.getDevotionByCoven(EnumCovenants.HASTUR) - 1);
//							PacketHandler.CHANNELCOVENANT.send(
//									PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerentity),
//									new PacketCovenantServer(coven.getDevotion()));
							playerentity.displayClientMessage(
									Component.translatable(
											ChatFormatting.YELLOW + "Abuse of Power does not come without consequence"),
									true);
						}

						this.summonTentacleAid(worldIn.random.nextInt(10), worldIn, (Player) entityLiving, hitVec);
					}
			//		if (coven.getDevotionByCoven(EnumCovenants.HASTUR) >= 30
							//&& playerentity.getRandom().nextInt(20) == 19) {
						EntityHastur summon = new EntityHastur(EntityInit.hastur.get(), worldIn);
						summon.setPos(playerentity.getX() + 0.5, playerentity.getY() + 0.5, playerentity.getZ() + 0.5);
						playerentity.displayClientMessage(Component.translatable("Lord Hastur decided to check in..."),
								true);
						worldIn.addFreshEntity(summon);
					}
			//	} else {
					playerentity.displayClientMessage(
							Component.translatable("Lord Hastur does not grant you his power"), true);
					stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
						p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
					});
		}

			}

		//	playerentity.awardStat(Stats.ITEM_USED.get(this));
		//}
//	}

	public void summonTentacleAid(int numTent, Level world, Player player, Vec3 hitVec) {
		EntityPlayerTentacle[] tentArray = new EntityPlayerTentacle[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityPlayerTentacle(EntityInit.player_tentacle.get(), world, player);
			tentArray[i].setTentacleType(world.random.nextInt(4));
			float xMod = (world.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (world.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (world.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(hitVec.x() + 0.5 + xMod, hitVec.y() + 1.5 + yMod, hitVec.z() + 0.5 + zMod);
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
