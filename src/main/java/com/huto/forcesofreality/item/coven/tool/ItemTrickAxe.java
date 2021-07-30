package com.huto.forcesofreality.item.coven.tool;

import java.util.List;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.entity.projectile.EntityThrownAxe;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.sound.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemTrickAxe extends AxeItem {

	public boolean state;
	public static String TAG_STATE = "state";

	public ItemTrickAxe(Properties prop, Tier tier) {
		super(tier, 5.0F, -3.0F, prop);
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

		if (!stack.hasTag()) {
			stack.setTag(new CompoundTag());
			CompoundTag compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		if (stack.getTag().getBoolean(TAG_STATE)) {
		}

	}

	@Nonnull
	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, @Nonnull InteractionHand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		CompoundNBT compound = stack.getTag();
		if (playerIn.isSneaking()) {
			if (!compound.getBoolean(TAG_STATE)) {
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				playerIn.playSound(SoundHandler.ITEM_BOW_BLADE_OPEN, 0.6F, 0.8F);

			} else {
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				playerIn.playSound(SoundHandler.ITEM_BOW_BLADE_CLOSE, 0.6F, 0.8f);

			}
		} else {
			if (compound.getBoolean(TAG_STATE)) {
				ItemStack itemstack = playerIn.getHeldItem(handIn);
				playerIn.setActiveHand(handIn);
				return ActionResult.resultConsume(itemstack);
			}

		}
		stack.setTag(compound);
		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		if (state.getBlockHardness(worldIn, pos) != 0.0F) {
			stack.damageItem(2, entityLiving, (entity) -> {
				entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});
		}
		return true;
	}

	@Override
	public boolean isDamageable(ItemStack stack) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: Open").mergeStyle(TextFormatting.BLUE));

			} else {
				tooltip.add(new TranslationTextComponent("State: Closed").mergeStyle(TextFormatting.RED));
			}
		}
	}

	/**
	 * Called when the player stops using an Item (stops holding the right mouse
	 * button).
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			CompoundNBT compound = stack.getTag();
			if (compound.getBoolean(TAG_STATE)) {
				if (!worldIn.isRemote) {
					int i = this.getUseDuration(stack) - timeLeft;
					if (i > 21) {
						stack.damageItem(3, playerentity, (p_220009_1_) -> {
							p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
						});
						ItemStack copy = stack.copy();
						copy.setCount(1);
						EntityThrownAxe c = new EntityThrownAxe(playerentity, worldIn, copy);
						c.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 1.5F,
								1.0F);
						/*
						 * if (stack.getItem() == ItemInit.null_trick_axe.get()) { c.setFire(true); }
						 * else
						 */if (stack.getItem() == ItemInit.auric_trick_axe.get()) {
							c.setAuric(true);
						} else {
						}
						worldIn.addEntity(c);
						worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(),
								SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 0.5F,
								0.4F / (random.nextFloat() * 0.4F + 0.8F));
						stack.shrink(1);
					}
				}
			}

		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

}
