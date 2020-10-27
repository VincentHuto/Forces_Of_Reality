package com.huto.hutosmod.objects.items.tools;

import java.util.List;
import java.util.function.Predicate;

import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
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

public class ItemBowBlade extends ShootableItem {

	public boolean state;
	public static String TAG_STATE = "state";
	public float swordDam;
	public float bowDam;

	public ItemBowBlade(Properties prop, int tier, float swordDamIn, float bowDamIn) {
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

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
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
				playerIn.playSound(SoundHandler.ITEM_BOW_BLADE_OPEN, 0.6F, 0.8F );

			} else {
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				playerIn.playSound(SoundHandler.ITEM_BOW_BLADE_CLOSE, 0.6F, 0.8f);

			}
		} else {
			if (compound.getBoolean(TAG_STATE)) {
				ItemStack itemstack = playerIn.getHeldItem(handIn);
				boolean flag = !playerIn.findAmmo(itemstack).isEmpty();
				ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn,
						playerIn, handIn, flag);
				if (ret != null)
					return ret;

				if (!playerIn.abilities.isCreativeMode && !flag) {
					return ActionResult.resultFail(itemstack);
				} else {
					playerIn.setActiveHand(handIn);
					return ActionResult.resultConsume(itemstack);
				}
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

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return ARROWS;
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}

	public boolean isBowBladeInfinite(ItemStack bow) {
		int enchant = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_infinity.get(), bow);
		return enchant <= 0 ? false : true;
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

				boolean flag = playerentity.abilities.isCreativeMode
						|| EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_infinity.get(), stack) > 0;
				ItemStack itemstack = playerentity.findAmmo(stack);

				int i = this.getUseDuration(stack) - timeLeft;
				i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i,
						!itemstack.isEmpty() || flag);
				if (i < 0)
					return;

				if (!itemstack.isEmpty() || flag) {
					if (itemstack.isEmpty()) {
						itemstack = new ItemStack(Items.ARROW);
					}
					float f = getArrowVelocity(i);
					if (!((double) f < 0.1D)) {
						boolean flag1 = playerentity.abilities.isCreativeMode
								|| (itemstack.getItem() instanceof ArrowItem && this.isBowBladeInfinite(stack));
						if (!worldIn.isRemote) {
							ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem
									? itemstack.getItem()
									: Items.ARROW);
							AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack,
									playerentity);
							abstractarrowentity = customArrow(abstractarrowentity);
							abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
									playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
							if (f == 1.0F) {
								abstractarrowentity.setIsCritical(true);
							}
							int j = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_power.get(), stack);
							if (j > 0) {
								abstractarrowentity
										.setDamage(abstractarrowentity.getDamage() + (double) j * 0.5D + 0.5D);
							}

							int k = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_punch.get(), stack);
							if (k > 0) {
								abstractarrowentity.setKnockbackStrength(k);
							}

							if (EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.bow_blade_flame.get(),
									stack) > 0) {
								abstractarrowentity.setFire(100);
							}

							stack.damageItem(1, playerentity, (p_220009_1_) -> {
								p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
							});
							if (flag1 || playerentity.abilities.isCreativeMode
									&& (itemstack.getItem() == Items.SPECTRAL_ARROW
											|| itemstack.getItem() == Items.TIPPED_ARROW)) {
								abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
							}

							worldIn.addEntity(abstractarrowentity);
						}

						worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
								playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
								1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
						if (!flag1 && !playerentity.abilities.isCreativeMode) {
							itemstack.shrink(1);
							if (itemstack.isEmpty()) {
								playerentity.inventory.deleteStack(itemstack);
							}
						}

						playerentity.addStat(Stats.ITEM_USED.get(this));
					}
				}
			}
		}
	}

	/**
	 * Gets the velocity of the arrow entity from the bow's charge
	 */

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		return arrow;
	}

	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}
}
