package com.vincenthuto.forcesofreality.common.item.coven.tool;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.vincenthuto.hutoslib.math.Quaternion;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBeastCrossbow extends CrossbowItem implements Vanishable {
	private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile) {
		CompoundTag CompoundTag = crossbow.getOrCreateTag();
		ListTag listnbt;
		if (CompoundTag.contains("ChargedProjectiles", 9)) {
			listnbt = CompoundTag.getList("ChargedProjectiles", 10);
		} else {
			listnbt = new ListTag();
		}

		CompoundTag CompoundTag1 = new CompoundTag();
		projectile.save(CompoundTag1);
		listnbt.add(CompoundTag1);
		CompoundTag.put("ChargedProjectiles", listnbt);
	}

	private static void clearProjectiles(ItemStack stack) {
		CompoundTag CompoundTag = stack.getTag();
		if (CompoundTag != null) {
			ListTag listnbt = CompoundTag.getList("ChargedProjectiles", 9);
			listnbt.clear();
			CompoundTag.put("ChargedProjectiles", listnbt);
		}

	}

	private static AbstractArrow createArrow(Level worldIn, LivingEntity shooter, ItemStack crossbow, ItemStack ammo) {
		ArrowItem arrowitem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
		AbstractArrow abstractarrowentity = arrowitem.createArrow(worldIn, ammo, shooter);
		if (shooter instanceof Player) {
			abstractarrowentity.setCritArrow(true);
		}

		abstractarrowentity.setSoundEvent(SoundEvents.CROSSBOW_HIT);
		abstractarrowentity.setShotFromCrossbow(true);
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, crossbow);
		if (i > 0) {
			abstractarrowentity.setPierceLevel((byte) i);
		}

		return abstractarrowentity;
	}

	private static void fireProjectile(Level worldIn, LivingEntity shooter, InteractionHand handIn, ItemStack crossbow,
			ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy,
			float projectileAngle) {
		if (!worldIn.isClientSide) {
			boolean flag = projectile.getItem() == Items.FIREWORK_ROCKET;
			Projectile projecBlockEntity;
			if (flag) {
				projecBlockEntity = new FireworkRocketEntity(worldIn, projectile, shooter, shooter.getX(),
						shooter.getEyeY() - 0.15F, shooter.getZ(), true);
			} else {
				projecBlockEntity = createArrow(worldIn, shooter, crossbow, projectile);
				if (isCreativeMode || projectileAngle != 0.0F) {
					((AbstractArrow) projecBlockEntity).pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				}
			}

			if (shooter instanceof CrossbowAttackMob) {
				CrossbowAttackMob icrossbowuser = (CrossbowAttackMob) shooter;
				icrossbowuser.shootCrossbowProjectile(icrossbowuser.getTarget(), crossbow, projecBlockEntity,
						projectileAngle);
			} else {
				Vec3 vector3d1 = shooter.getUpVector(1.0F);
				Quaternion quaternion = new Quaternion(new Vector3(vector3d1), projectileAngle, true);
				Vec3 vector3d = shooter.getViewVector(1.0F);
				Vector3 vector3f = new Vector3(vector3d);
				vector3f.transform(quaternion);
				projecBlockEntity.shoot(vector3f.x, vector3f.y, vector3f.z, velocity, inaccuracy);
			}

			crossbow.hurtAndBreak(flag ? 3 : 1, shooter, (p_220017_1_) -> {
				p_220017_1_.broadcastBreakEvent(handIn);
			});
			worldIn.addFreshEntity(projecBlockEntity);
			worldIn.playSound((Player) null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.CROSSBOW_SHOOT,
					SoundSource.PLAYERS, 1.0F, soundPitch);
		}
	}

	public static void fireProjectiles(Level worldIn, LivingEntity shooter, InteractionHand handIn, ItemStack stack,
			float velocityIn, float inaccuracyIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		float[] afloat = getRandomSoundPitches(shooter.getRandom());

		for (int i = 0; i < list.size(); ++i) {
			ItemStack itemstack = list.get(i);
			boolean flag = shooter instanceof Player && ((Player) shooter).getAbilities().instabuild;
			if (!itemstack.isEmpty()) {
				if (i == 0) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, 0.0F);
				} else if (i == 1) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, -10.0F);
				} else if (i == 2) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, 10.0F);
				}
			}
		}

		fireProjectilesAfter(worldIn, shooter, stack);
	}

	/**
	 * Called after {@plainlink #fireProjectiles} to clear the charged projectile
	 * and to update the player advancements.
	 */

	private static void fireProjectilesAfter(Level worldIn, LivingEntity shooter, ItemStack stack) {
		if (shooter instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) shooter;
			if (!worldIn.isClientSide) {
				CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayerentity, stack);
			}

			serverplayerentity.awardStat(Stats.ITEM_USED.get(stack.getItem()));
		}

		clearProjectiles(stack);
	}

	private static float getCharge(int useTime, ItemStack stack) {
		float f = (float) useTime / (float) getChargeTime(stack);
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
		List<ItemStack> list = Lists.newArrayList();
		CompoundTag CompoundTag = stack.getTag();
		if (CompoundTag != null && CompoundTag.contains("ChargedProjectiles", 9)) {
			ListTag listnbt = CompoundTag.getList("ChargedProjectiles", 10);
			if (listnbt != null) {
				for (int i = 0; i < listnbt.size(); ++i) {
					CompoundTag CompoundTag1 = listnbt.getCompound(i);
					list.add(ItemStack.of(CompoundTag1));
				}
			}
		}

		return list;
	}

	/**
	 * The time the crossbow must be used to reload it
	 */

	public static int getChargeTime(ItemStack stack) {
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
		return i == 0 ? 25 : 25 - 5 * i;
	}

	private static float getRandomSoundPitch(boolean flagIn) {
		float f = flagIn ? 0.63F : 0.43F;
		return 1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.8F) + f;
	}

	private static float[] getRandomSoundPitches(RandomSource randomSource) {
		boolean flag = randomSource.nextBoolean();
		return new float[] { 1.0F, getRandomSoundPitch(flag), getRandomSoundPitch(!flag) };
	}

	private static float getShootingPower(ItemStack p_220013_0_) {
		return p_220013_0_.getItem() == Items.CROSSBOW && hasChargedProjectile(p_220013_0_, Items.FIREWORK_ROCKET)
				? 1.6F
				: 3.15F;
	}

	private static boolean hasAmmo(LivingEntity entityIn, ItemStack stack) {
		int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, stack);
		int j = i == 0 ? 1 : 3;
		boolean flag = entityIn instanceof Player && ((Player) entityIn).getAbilities().instabuild;
		ItemStack itemstack = entityIn.getProjectile(stack);
		ItemStack itemstack1 = itemstack.copy();

		for (int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}

			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(Items.ARROW);
				itemstack1 = itemstack.copy();
			}

			if (!loadProjectile(entityIn, stack, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
			return p_220010_1_.getItem() == ammoItem;
		});
	}

	public static boolean isCharged(ItemStack stack) {
		CompoundTag CompoundTag = stack.getTag();
		return CompoundTag != null && CompoundTag.getBoolean("Charged");
	}

	private static boolean loadProjectile(LivingEntity p_220023_0_, ItemStack stack, ItemStack p_220023_2_,
			boolean p_220023_3_, boolean p_220023_4_) {
		if (p_220023_2_.isEmpty()) {
			return false;
		} else {
			boolean flag = p_220023_4_ && p_220023_2_.getItem() instanceof ArrowItem;
			ItemStack itemstack;
			if (!flag && !p_220023_4_ && !p_220023_3_) {
				itemstack = p_220023_2_.split(1);
				if (p_220023_2_.isEmpty() && p_220023_0_ instanceof Player) {
					((Player) p_220023_0_).getInventory().removeItem(p_220023_2_);
				}
			} else {
				itemstack = p_220023_2_.copy();
			}

			addChargedProjectile(stack, itemstack);
			return true;
		}
	}

	public static void setCharged(ItemStack stack, boolean chargedIn) {
		CompoundTag CompoundTag = stack.getOrCreateTag();
		CompoundTag.putBoolean("Charged", chargedIn);
	}

	/** Set to {@code true} w.hen the crossbow is 20% charged. */
	private boolean isLoadingStart = false;

	/** Set to {@code true} when the crossbow is 50% charged. */
	private boolean isLoadingMiddle = false;

	public ItemBeastCrossbow(Item.Properties propertiesIn) {
		super(propertiesIn.stacksTo(1));
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		if (isCharged(stack) && !list.isEmpty()) {
			ItemStack itemstack = list.get(0);
			tooltip.add((Component.translatable("item.minecraft.crossbow.projectile")).append(" ")
					.append(itemstack.getDisplayName()));
			if (flagIn.isAdvanced() && itemstack.getItem() == Items.FIREWORK_ROCKET) {
				List<Component> list1 = Lists.newArrayList();
				Items.FIREWORK_ROCKET.appendHoverText(itemstack, worldIn, list1, flagIn);
				if (!list1.isEmpty()) {
					for (int i = 0; i < list1.size(); ++i) {
						list1.set(i,
								(Component.translatable("  ")).append(list1.get(i)).withStyle(ChatFormatting.GRAY));
					}

					tooltip.addAll(list1);
				}
			}

		}
	}

	/**
	 * Get the predicate to match ammunition when searching the player's inventory,
	 * not their main/offhand
	 */
	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return ARROW_ONLY;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 8;
	}

	private SoundEvent getSoundEvent(int enchantmentLevel) {
		switch (enchantmentLevel) {
		case 1:
			return SoundEvents.CROSSBOW_QUICK_CHARGE_1;
		case 2:
			return SoundEvents.CROSSBOW_QUICK_CHARGE_2;
		case 3:
			return SoundEvents.CROSSBOW_QUICK_CHARGE_3;
		default:
			return SoundEvents.CROSSBOW_LOADING_START;
		}
	}

	@Override
	public Predicate<ItemStack> getSupportedHeldProjectiles() {
		return ARROW_OR_FIREWORK;
	}

	/**
	 * returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getUseDuration(ItemStack stack) {
		return getChargeTime(stack) + 3;
	}

	/**
	 * Called as the item is being used by an entity.
	 */
	@Override
	public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (!worldIn.isClientSide) {
			int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
			SoundEvent soundevent = this.getSoundEvent(i);
			SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
			float f = (float) (stack.getUseDuration() - count) / (float) getChargeTime(stack);
			if (f < 0.2F) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
			}

			if (f >= 0.2F && !this.isLoadingStart) {
				this.isLoadingStart = true;
				worldIn.playSound((Player) null, livingEntityIn.getX(), livingEntityIn.getY(), livingEntityIn.getZ(),
						soundevent, SoundSource.PLAYERS, 0.5F, 1.0F);
			}

			if (f >= 0.5F && soundevent1 != null && !this.isLoadingMiddle) {
				this.isLoadingMiddle = true;
				worldIn.playSound((Player) null, livingEntityIn.getX(), livingEntityIn.getY(), livingEntityIn.getZ(),
						soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
			}
		}

	}

	/**
	 * Called when the player stops using an Item (stops holding the right mouse
	 * button).
	 */
	@Override
	public void releaseUsing(ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		int i = this.getUseDuration(stack) - timeLeft;
		float f = getCharge(i, stack);
		if (f >= 1.0F && !isCharged(stack) && hasAmmo(entityLiving, stack)) {
			setCharged(stack, true);
			SoundSource soundcategory = entityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
			worldIn.playSound((Player) null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(),
					SoundEvents.CROSSBOW_LOADING_END, soundcategory, 1.0F,
					1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.0F) + 0.2F);
		}

	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when
	 * this item is used on a Block, see {@link #onItemUse}.
	 */
	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		if (isCharged(itemstack)) {
			fireProjectiles(worldIn, playerIn, handIn, itemstack, getShootingPower(itemstack), 1.0F);
			setCharged(itemstack, false);
			return InteractionResultHolder.consume(itemstack);
		} else if (!playerIn.getProjectile(itemstack).isEmpty()) {
			if (!isCharged(itemstack)) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				playerIn.startUsingItem(handIn);
			}

			return InteractionResultHolder.consume(itemstack);
		} else {
			return InteractionResultHolder.fail(itemstack);
		}
	}

	@Override
	public boolean useOnRelease(ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}
}
