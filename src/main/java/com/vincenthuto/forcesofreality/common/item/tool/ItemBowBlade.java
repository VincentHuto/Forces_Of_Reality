package com.vincenthuto.forcesofreality.common.item.tool;

import java.util.List;
import java.util.function.Predicate;

import com.vincenthuto.forcesofreality.registry.EnchantmentInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemBowBlade extends ProjectileWeaponItem {

	public static String TAG_STATE = "state";

	/**
	 * Gets the velocity of the arrow entity from the bow's charge
	 */

	public static float getArrowVelocity(int charge) {
		float f = charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	public boolean state;
	public float swordDam;

	public float bowDam;

	public ItemBowBlade(Properties prop, int tier, float swordDamIn, float bowDamIn) {
		super(prop);
		swordDam = swordDamIn;
		bowDam = bowDamIn;

	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			float damageModSharp = 1.0F + Math.max(0,
					EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) - 1)
					* 0.5F;
			if (stack.getTag().getBoolean(TAG_STATE)) {
				int s = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_power.get(), stack);
				tooltip.add(Component.translatable("State: Open").withStyle(ChatFormatting.BLUE));

				if (s > 0) {
					tooltip.add(Component.translatable((bowDam + (s * 0.5D + 0.5D)) + " Additional Arrow Damage")
							.withStyle(ChatFormatting.DARK_GREEN));
				} else {
					tooltip.add(Component.translatable((bowDam + " Additional Arrow Damage"))
							.withStyle(ChatFormatting.DARK_GREEN));
				}

			} else {
				tooltip.add(Component.translatable("State: Closed").withStyle(ChatFormatting.RED));
				if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) > 0) {
					tooltip.add(Component.translatable((damageModSharp + swordDam) + " Attack Damage")
							.withStyle(ChatFormatting.DARK_GREEN));
				} else {
					tooltip.add(
							Component.translatable((swordDam) + " Attack Damage").withStyle(ChatFormatting.DARK_GREEN));
				}
			}
		}
	}

	public AbstractArrow customArrow(AbstractArrow arrow) {
		return arrow;
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return ARROW_ONLY;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	public boolean getState() {
		return state;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		DamageSource bowBladeSource = attacker.damageSources().playerAttack((Player) attacker);
		
		CompoundTag compound = stack.getTag();

		int j = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_fire_aspect.get(), stack);
		if (target instanceof LivingEntity) {
			if (j > 0 && !target.isOnFire()) {
				target.setSecondsOnFire(j);
			}
		}

		int knockbackMod = 0;
		knockbackMod = knockbackMod
				+ EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_knockback.get(), stack);
		if (attacker.isSprinting()) {
			++knockbackMod;
		}
		if (knockbackMod > 0) {
			if (target instanceof LivingEntity) {
				target.knockback(knockbackMod * 0.5F, Mth.sin(attacker.getYRot() * ((float) Math.PI / 180F)),
						(-Mth.cos(attacker.getYRot() * ((float) Math.PI / 180F))));
			} else {
				target.push(-Mth.sin(attacker.getYRot() * ((float) Math.PI / 180F)) * knockbackMod * 0.5F,
						0.1D,
						Mth.cos(attacker.getYRot() * ((float) Math.PI / 180F)) * knockbackMod * 0.5F);
			}

			attacker.setDeltaMovement(attacker.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
			attacker.setSprinting(false);
		}
		if (!compound.getBoolean(TAG_STATE)) {

			float damageModSharp = 1.0F + Math.max(0,
					EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(), stack) - 1)
					* 0.5F;
			float damageModSmite = EnchantmentInit.bow_blade_smite.get().getDamageBonus(
					EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_smite.get(), stack),
					MobType.UNDEAD);
			float damageModBane = EnchantmentInit.bow_blade_bane_of_arthropods.get().getDamageBonus(EnchantmentHelper
					.getItemEnchantmentLevel(EnchantmentInit.bow_blade_bane_of_arthropods.get(), stack),
					MobType.ARTHROPOD);

			float combindedSmteBane = damageModBane + damageModSmite;
			if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_smite.get(), stack)
					+ EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_bane_of_arthropods.get(),
							stack) > 0) {
				target.hurt(bowBladeSource, (combindedSmteBane + swordDam));
			} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_sharpness.get(),
					stack) > 0) {
				target.hurt(bowBladeSource, (swordDam + damageModSharp));
			} else {
				target.hurt(bowBladeSource, swordDam);

			}
			stack.hurtAndBreak(1, attacker, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		} else {
			stack.hurtAndBreak(1, attacker, (entity) -> {
				entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
			target.hurt(bowBladeSource, bowDam);

		}
		return true;
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

	public boolean isBowBladeInfinite(ItemStack bow) {
		int enchant = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_infinity.get(), bow);
		return enchant <= 0 ? false : true;
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

				boolean flag = playerentity.getAbilities().instabuild || EnchantmentHelper
						.getItemEnchantmentLevel(EnchantmentInit.bow_blade_infinity.get(), stack) > 0;
				ItemStack itemstack = playerentity.getProjectile(stack);

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
					if (!(f < 0.1D)) {
						boolean flag1 = playerentity.getAbilities().instabuild
								|| (itemstack.getItem() instanceof ArrowItem && this.isBowBladeInfinite(stack));
						if (!worldIn.isClientSide) {
							ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem
									? itemstack.getItem()
									: Items.ARROW);
							AbstractArrow abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
							abstractarrowentity = customArrow(abstractarrowentity);
							abstractarrowentity.shootFromRotation(playerentity, playerentity.getXRot(), playerentity.getYRot(),
									0.0F, f * 3.0F, 1.0F);
							if (f == 1.0F) {
								abstractarrowentity.setCritArrow(true);
							}
							int j = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_power.get(),
									stack);
							if (j > 0) {
								abstractarrowentity
										.setBaseDamage(abstractarrowentity.getBaseDamage() + j * 0.5D + 0.5D);
							}

							int k = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_punch.get(),
									stack);
							if (k > 0) {
								abstractarrowentity.setKnockback(k);
							}

							if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.bow_blade_flame.get(),
									stack) > 0) {
								abstractarrowentity.setSecondsOnFire(100);
							}

							stack.hurtAndBreak(1, playerentity, (p_220009_1_) -> {
								p_220009_1_.broadcastBreakEvent(playerentity.getUsedItemHand());
							});
							if (flag1 || playerentity.getAbilities().instabuild
									&& (itemstack.getItem() == Items.SPECTRAL_ARROW
											|| itemstack.getItem() == Items.TIPPED_ARROW)) {
								abstractarrowentity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
							}

							worldIn.addFreshEntity(abstractarrowentity);
						}

						worldIn.playSound((Player) null, playerentity.getX(), playerentity.getY(), playerentity.getZ(),
								SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F,
								1.0F / (RandomSource.create().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
						if (!flag1 && !playerentity.getAbilities().instabuild) {
							itemstack.shrink(1);
							if (itemstack.isEmpty()) {
								playerentity.getInventory().removeItem(itemstack);
							}
						}

						playerentity.awardStat(Stats.ITEM_USED.get(this));
					}
				}
			}
		}
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
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
				boolean flag = !playerIn.getProjectile(itemstack).isEmpty();
				InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory
						.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
				if (ret != null)
					return ret;

				if (!playerIn.getAbilities().instabuild && !flag) {
					return InteractionResultHolder.fail(itemstack);
				} else {
					playerIn.startUsingItem(handIn);
					return InteractionResultHolder.consume(itemstack);
				}
			}

		}
		stack.setTag(compound);
		return super.use(worldIn, playerIn, handIn);
	}
}
