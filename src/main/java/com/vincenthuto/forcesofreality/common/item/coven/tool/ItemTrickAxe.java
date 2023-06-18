package com.vincenthuto.forcesofreality.common.item.coven.tool;

import java.util.List;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityThrownAxe;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemTrickAxe extends AxeItem {

	public static String TAG_STATE = "state";
	public boolean state;

	public ItemTrickAxe(Properties prop, Tier tier) {
		super(tier, 5.0F, -3.0F, prop);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(Component.translatable("State: Open").withStyle(ChatFormatting.BLUE));

			} else {
				tooltip.add(Component.translatable("State: Closed").withStyle(ChatFormatting.RED));
			}
		}
	}

	public boolean getState() {
		return state;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
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

	@Override
	public boolean isDamageable(ItemStack stack) {
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		if (state.getDestroySpeed(worldIn, pos) != 0.0F) {
			stack.hurtAndBreak(2, entityLiving, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}
		return true;
	}

	/**
	 * Called when the player stops using an Item (stops holding the right mouse
	 * button).
	 */
	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player) {
			Player playerentity = (Player) entityLiving;
			CompoundTag compound = stack.getTag();
			if (compound.getBoolean(TAG_STATE)) {
				if (!worldIn.isClientSide) {
					int i = this.getUseDuration(stack) - timeLeft;
					if (i > 21) {
						stack.hurtAndBreak(3, playerentity, (p_220009_1_) -> {
							p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
						});
						ItemStack copy = stack.copy();
						copy.setCount(1);
						EntityThrownAxe c = new EntityThrownAxe(playerentity, worldIn, copy);
						c.shootFromRotation(playerentity, playerentity.getXRot(), playerentity.getYRot(), 0.0F, 1.5F, 1.0F);
						/*
						 * if (stack.getItem() == ItemInit.null_trick_axe.get()) { c.setFire(true); }
						 * else
						 */if (stack.getItem() == ItemInit.auric_trick_axe.get()) {
							c.setAuric(true);
						} else {
						}
						worldIn.addFreshEntity(c);
						worldIn.playSound(null, playerentity.getX(), playerentity.getY(), playerentity.getZ(),
								SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 0.5F,
								0.4F / (RandomSource.create().nextFloat() * 0.4F + 0.8F));
						stack.shrink(1);
					}
				}
			}

		}
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Nonnull
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, @Nonnull InteractionHand handIn) {
		ItemStack stack = playerIn.getMainHandItem();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundTag());
			CompoundTag compound = stack.getTag();
			compound.putBoolean(TAG_STATE, false);
		}
		CompoundTag compound = stack.getTag();
		if (playerIn.isShiftKeyDown()) {
			if (!compound.getBoolean(TAG_STATE)) {
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				playerIn.playSound(SoundInit.ITEM_BOW_BLADE_OPEN.get(), 0.6F, 0.8F);

			} else {
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				playerIn.playSound(SoundInit.ITEM_BOW_BLADE_CLOSE.get(), 0.6F, 0.8f);

			}
		} else {
			if (compound.getBoolean(TAG_STATE)) {
				ItemStack itemstack = playerIn.getItemInHand(handIn);
				playerIn.startUsingItem(handIn);
				return InteractionResultHolder.consume(itemstack);
			}

		}
		stack.setTag(compound);
		return super.use(worldIn, playerIn, handIn);

	}

}
