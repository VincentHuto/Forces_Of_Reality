package com.huto.hutosmod.objects.items.tools;

import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.entities.projectiles.EntityThrownAxe;
import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemTrickAxe extends Item {

	public boolean state;
	public static String TAG_STATE = "state";
	public float swordDam;
	public float bowDam;

	public ItemTrickAxe(Properties prop, int tier, float swordDamIn, float bowDamIn) {
		super(prop);
		swordDam = swordDamIn;
		bowDam = bowDamIn;

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
		}

	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
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
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		DamageSource bowBladeSource = DamageSource.causePlayerDamage((PlayerEntity) attacker);
		CompoundNBT compound = stack.getTag();

		int j = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_fire_aspect.get(), stack);
		if (target instanceof LivingEntity) {
			if (j > 0 && !target.isBurning()) {
				target.setFire(j);
			}
		}

		int knockbackMod = 0;
		knockbackMod = knockbackMod
				+ EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_knockback.get(), stack);
		if (attacker.isSprinting()) {
			++knockbackMod;
		}
		if (knockbackMod > 0) {
			if (target instanceof LivingEntity) {
				((LivingEntity) target).applyKnockback((float) knockbackMod * 0.5F,
						(double) MathHelper.sin(attacker.rotationYaw * ((float) Math.PI / 180F)),
						(double) (-MathHelper.cos(attacker.rotationYaw * ((float) Math.PI / 180F))));
			} else {
				target.addVelocity(
						(double) (-MathHelper.sin(attacker.rotationYaw * ((float) Math.PI / 180F))
								* (float) knockbackMod * 0.5F),
						0.1D, (double) (MathHelper.cos(attacker.rotationYaw * ((float) Math.PI / 180F))
								* (float) knockbackMod * 0.5F));
			}

			attacker.setMotion(attacker.getMotion().mul(0.6D, 1.0D, 0.6D));
			attacker.setSprinting(false);
		}
		if (!compound.getBoolean(TAG_STATE)) {

			float damageModSharp = 1.0F + (float) Math.max(0,
					EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) - 1) * 0.5F;
			float damageModSmite = EnchantmentInit.bow_blade_smite.get().calcDamageByCreature(
					EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_smite.get(), stack),
					CreatureAttribute.UNDEAD);
			float damageModBane = EnchantmentInit.bow_blade_bane_of_arthropods.get().calcDamageByCreature(
					EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_bane_of_arthropods.get(), stack),
					CreatureAttribute.ARTHROPOD);

			float combindedSmteBane = damageModBane + damageModSmite;
			if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_smite.get(), stack) + EnchantmentHelper
					.getEnchantmentLevel(EnchantmentInit.bow_blade_bane_of_arthropods.get(), stack) > 0) {
				target.attackEntityFrom(bowBladeSource, (combindedSmteBane + swordDam));
			} else if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) > 0) {
				target.attackEntityFrom(bowBladeSource, (swordDam + damageModSharp));
			} else {
				target.attackEntityFrom(bowBladeSource, swordDam);

			}
			stack.damageItem(1, attacker, (entity) -> {
				entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});
		} else {
			stack.damageItem(1, attacker, (entity) -> {
				entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});
			target.attackEntityFrom(bowBladeSource, bowDam);

		}
		return true;
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
			float damageModSharp = 1.0F + (float) Math.max(0,
					EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) - 1) * 0.5F;
			if (stack.getTag().getBoolean(TAG_STATE)) {
				int s = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_power.get(), stack);
				tooltip.add(new TranslationTextComponent("State: Open").mergeStyle(TextFormatting.BLUE));

				if (s > 0) {
					tooltip.add(new TranslationTextComponent((bowDam + (s * 0.5D + 0.5D)) + " Additional Arrow Damage")
							.mergeStyle(TextFormatting.DARK_GREEN));
				} else {
					tooltip.add(new TranslationTextComponent((bowDam + " Additional Arrow Damage"))
							.mergeStyle(TextFormatting.DARK_GREEN));
				}

			} else {
				tooltip.add(new TranslationTextComponent("State: Closed").mergeStyle(TextFormatting.RED));
				if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) > 0) {
					tooltip.add(new TranslationTextComponent((damageModSharp + swordDam) + " Attack Damage")
							.mergeStyle(TextFormatting.DARK_GREEN));
				} else {
					tooltip.add(new TranslationTextComponent((swordDam) + " Attack Damage")
							.mergeStyle(TextFormatting.DARK_GREEN));
				}
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
					ItemStack copy = stack.copy();
					copy.setCount(1);
					EntityThrownAxe c = new EntityThrownAxe(playerentity, worldIn, copy);
					c.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 1.5F,
							1.0F);
					if (stack.getItem() == ItemInit.anti_tear.get()) {
						c.setFire(true);
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

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}
}
