package com.huto.forcesofreality.item.armor;

import java.util.List;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.entity.projectile.EntityShorting;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemEmpCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemEmpCharm(Properties prop) {
		super(prop);

	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		if (stack.getTag().getBoolean(TAG_STATE)) {
			attractItems(worldIn, entityIn,
					new AxisAlignedBB(entityIn.getPositionVec().add(-4, -4, -4),
							entityIn.getPositionVec().add(4, 4, 4)),
					entityIn.getPositionVec().getX() + 0.5, entityIn.getPositionVec().getY() + 0.5,
					entityIn.getPositionVec().getZ() + 0.5);
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		CompoundNBT compound = stack.getTag();
		ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
		if (coven != null) {
			if (coven.getDevotionByCoven(EnumCovenants.MACHINE) > 3) {
				if (!compound.getBoolean(TAG_STATE)) {
					playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
					compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				} else {
					playerIn.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
					compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				}
				stack.setTag(compound);
			} else {
				playerIn.sendStatusMessage(
						new StringTextComponent("Unable to ignite Machina Spark").mergeStyle(TextFormatting.GOLD),
						true);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("Enable to have a chance to ").mergeStyle(TextFormatting.GOLD));
		tooltip.add(new TranslationTextComponent("passivly shock enemies").mergeStyle(TextFormatting.GOLD));
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: On").mergeStyle(TextFormatting.BLUE));
			} else {
				tooltip.add(new TranslationTextComponent("State: Off").mergeStyle(TextFormatting.RED));
			}
		}
	}

	public static void attractItems(World world, Entity player, AxisAlignedBB effectBounds, double x, double y,
			double z) {
		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player, effectBounds);
		if (world.rand.nextInt(100) % 25 == 0) {
			for (Entity ent : list) {
				if ((ent instanceof MonsterEntity || ent instanceof SlimeEntity)) {
					EntityShorting shorting = new EntityShorting((LivingEntity) player, false);
					shorting.setPosition(ent.getPosX(), ent.getPosY() + 1, ent.getPosZ());
					world.addEntity(shorting);
				}
			}
		}
	}
}
