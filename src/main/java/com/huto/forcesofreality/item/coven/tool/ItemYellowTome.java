package com.huto.forcesofreality.item.coven.tool;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.entity.guardian.EntityHastur;
import com.huto.forcesofreality.entity.summon.EntityPlayerTentacle;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.PacketDistributor;

import net.minecraft.world.item.Item.Properties;

public class ItemYellowTome extends Item {

	public ItemYellowTome(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);

	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;

			if (!worldIn.isRemote) {
				RayTraceResult result = entityLiving.pick(100, 0, false);
				Vector3d hitVec = result.getHitVec();
				ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven.getDevotionByCoven(EnumCovenants.HASTUR) >= 10) {
					if (!worldIn.isRemote) {
						if (worldIn.rand.nextInt(10) == 6) {

							coven.setCovenDevotion(EnumCovenants.HASTUR,
									coven.getDevotionByCoven(EnumCovenants.HASTUR) - 1);
							PacketHandler.CHANNELCOVENANT.send(
									PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerentity),
									new CovenantPacketServer(coven.getDevotion()));
							playerentity.sendStatusMessage(
									new StringTextComponent(
											TextFormatting.YELLOW + "Abuse of Power does not come without consequence"),
									true);
						}

						this.summonTentacleAid(worldIn.rand.nextInt(10), worldIn, (PlayerEntity) entityLiving, hitVec);
					}
					if (coven.getDevotionByCoven(EnumCovenants.HASTUR) >= 30
							&& playerentity.getRNG().nextInt(20) == 19) {
						EntityHastur summon = new EntityHastur(EntityInit.hastur.get(), worldIn);
						summon.setPosition(playerentity.getPosX() + 0.5, playerentity.getPosY() + 0.5,
								playerentity.getPosZ() + 0.5);
						playerentity.sendStatusMessage(new StringTextComponent("Lord Hastur decided to check in..."),
								true);
						worldIn.addEntity(summon);
					}
				} else {
					playerentity.sendStatusMessage(new StringTextComponent("Lord Hastur does not grant you his power"),
							true);
				}

				stack.damageItem(1, playerentity, (p_220009_1_) -> {
					p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
				});
			}

			playerentity.addStat(Stats.ITEM_USED.get(this));
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 2;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public void summonTentacleAid(int numTent, World world, PlayerEntity player, Vector3d hitVec) {
		EntityPlayerTentacle[] tentArray = new EntityPlayerTentacle[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityPlayerTentacle(EntityInit.player_tentacle.get(), world, player);
			tentArray[i].setTentacleType(world.rand.nextInt(4));
			float xMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (world.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (world.rand.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPosition(hitVec.getX() + 0.5 + xMod, hitVec.getY() + 1.5 + yMod,
					hitVec.getZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(tentArray[i]);

			}
		}
	}

}
