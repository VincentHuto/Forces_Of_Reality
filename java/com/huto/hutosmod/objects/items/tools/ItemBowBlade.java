package com.huto.hutosmod.objects.items.tools;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemBowBlade extends ShootableItem {

	public boolean state;
	public static String TAG_STATE = "state";
	DamageSource bowBladeSource = new DamageSource("Bow Blade");

	public ItemBowBlade(Properties prop) {
		super(prop);
		prop.maxStackSize(1);

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

			// Do the Thing
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
				playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
			} else {
				playerIn.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
				compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
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
			} else {
				System.out.println("I AM A SWORD NOW");
			}

		}
		stack.setTag(compound);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		CompoundNBT compound = stack.getTag();
		if (!compound.getBoolean(TAG_STATE)) {
			target.attackEntityFrom(bowBladeSource, 8f);
		} else {
			target.attackEntityFrom(bowBladeSource, 1f);

		}
		return super.hitEntity(stack, target, attacker);
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

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return ARROWS;
	}

	@Override
	public int func_230305_d_() {
		return 15;
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
						|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
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
								|| (itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem())
										.isInfinite(itemstack, stack, playerentity));
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

							int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
							if (j > 0) {
								abstractarrowentity
										.setDamage(abstractarrowentity.getDamage() + (double) j * 0.5D + 0.5D);
							}

							int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
							if (k > 0) {
								abstractarrowentity.setKnockbackStrength(k);
							}

							if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
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
