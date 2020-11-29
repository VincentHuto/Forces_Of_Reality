package com.huto.hutosmod.objects.items.tools;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.entities.projectiles.EntityHolySpirit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.CovenantPacketServer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ItemDivineFeather extends Item {

	public ItemDivineFeather(Properties properties) {
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
				ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven.getDevotionByCoven(EnumCovenants.ASCENDENT) > 3) {
					if (!worldIn.isRemote) {

						if (worldIn.rand.nextInt(10) == 6) {

							coven.setCovenDevotion(EnumCovenants.ASCENDENT, -1);
							PacketHandler.CHANNELCOVENANT.send(
									PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerentity),
									new CovenantPacketServer(coven.getDevotion()));
							playerentity.sendStatusMessage(new StringTextComponent(
									TextFormatting.DARK_AQUA + "Abuse of Power does not come without consequence"),
									true);
						}

						EntityHolySpirit miss = new EntityHolySpirit(EntityInit.holy_spirit.get(), worldIn);
						miss.setPosition(playerentity.getPosX(), playerentity.getPosY() + 1.5, playerentity.getPosZ());
						miss.setDirectionMotion(playerentity, playerentity.rotationPitch, playerentity.rotationYaw,
								0.0F, 0.65F, 0F);
						worldIn.addEntity(miss);
					}
				} else {
					playerentity.sendStatusMessage(new StringTextComponent("Lord Seraph does not grant you his power"),
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
		EntityHolySpirit[] tentArray = new EntityHolySpirit[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityHolySpirit(EntityInit.holy_spirit.get(), world);
			tentArray[i].setPosition(hitVec.getX() + 0.5, hitVec.getY() + 1, hitVec.getZ() + 0.5);
			if (!world.isRemote) {
				world.addEntity(tentArray[i]);

			}
		}
	}

}
