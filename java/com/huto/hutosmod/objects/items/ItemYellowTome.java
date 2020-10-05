package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.entities.EntityPlayerTentacle;
import com.huto.hutosmod.init.EntityInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemYellowTome extends Item {

	public ItemYellowTome(Properties properties) {
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
				RayTraceResult result = entityLiving.pick(100, 0, false);
				Vector3d hitVec = result.getHitVec();
				ICovenant coven = entityLiving.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalArgumentException::new);
				if (coven.getCovenant() == EnumCovenants.HASTUR) {
					if (!worldIn.isRemote) {
						this.summonTentacleAid(worldIn.rand.nextInt(10), worldIn, (PlayerEntity) entityLiving, hitVec);
					}
				} else {
					playerentity.sendStatusMessage(new StringTextComponent("Lord Hastur does not grant you his power"),
							false);
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
