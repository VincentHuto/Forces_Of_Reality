package com.vincenthuto.forcesofreality.item.armor;

import java.util.List;

import com.vincenthuto.forcesofreality.entity.projectile.EntityShorting;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class ItemEmpCharm extends Item {

	public static boolean state;
	public static String TAG_STATE = "state";

	public static void attractItems(Level world, Entity player, AABB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntities(player, effectBounds);
		if (world.random.nextInt(100) % 25 == 0) {
			for (Entity ent : list) {
				if ((ent instanceof Monster || ent instanceof Slime)) {
					EntityShorting shorting = new EntityShorting((LivingEntity) player, false);
					shorting.setPos(ent.getX(), ent.getY() + 1, ent.getZ());
					world.addFreshEntity(shorting);
				}
			}
		}
	}

	public ItemEmpCharm(Properties prop) {
		super(prop);

	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(Component.translatable("Enable to have a chance to ").withStyle(ChatFormatting.GOLD));
		tooltip.add(Component.translatable("passivly shock enemies").withStyle(ChatFormatting.GOLD));
		if (stack.hasTag()) {
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(Component.translatable("State: On").withStyle(ChatFormatting.BLUE));
			} else {
				tooltip.add(Component.translatable("State: Off").withStyle(ChatFormatting.RED));
			}
		}
	}

	public boolean getState() {
		return state;
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
			attractItems(worldIn, entityIn,
					new AABB(entityIn.position().add(-4, -4, -4), entityIn.position().add(4, 4, 4)),
					entityIn.position().x() + 0.5, entityIn.position().y() + 0.5, entityIn.position().z() + 0.5);
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
		//ICovenant coven = playerIn.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);
//		if (coven != null) {
//			if (coven.getDevotionByCoven(EnumCovenants.MACHINE) > 3) {
				if (!compound.getBoolean(TAG_STATE)) {
					playerIn.playSound(SoundEvents.BEACON_ACTIVATE, 0.40f, 1F);
					compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				} else {
					playerIn.playSound(SoundEvents.BEACON_DEACTIVATE, 0.40f, 1F);
					compound.putBoolean(TAG_STATE, !compound.getBoolean(TAG_STATE));
				}
				stack.setTag(compound);
			//} else {
				playerIn.displayClientMessage(
						Component.translatable("Unable to ignite Machina Spark").withStyle(ChatFormatting.GOLD), true);
			//}
		//}
		return super.use(worldIn, playerIn, handIn);
	}
}
