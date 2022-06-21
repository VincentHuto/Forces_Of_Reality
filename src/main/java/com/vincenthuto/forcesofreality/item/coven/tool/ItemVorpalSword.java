package com.vincenthuto.forcesofreality.item.coven.tool;

import java.util.List;

import com.vincenthuto.forcesofreality.entity.util.ModEntityPredicates;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemVorpalSword extends SwordItem {

	public static DamageSource source = new DamageSource("vorpal");

	public ItemVorpalSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("Causes A Blast of Holy Distruption dealing damage to"));
		tooltip.add(Component.translatable("Surronding Evils and Beasts Alike upon their death."));
		tooltip.add(Component.translatable("+10% Max Mob Health Vorpal Damage").withStyle(ChatFormatting.AQUA));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public Component getName(ItemStack stack) {
		return Component.translatable(ChatFormatting.ITALIC + "Vorpal Blade").withStyle(ChatFormatting.AQUA);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (ModEntityPredicates.VORPAL.test(target)) {
			target.hurt(source, target.getMaxHealth() * 0.15f);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

}
