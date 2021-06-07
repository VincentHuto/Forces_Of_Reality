package com.huto.forcesofreality.item.coven.tool;

import java.util.List;

import com.huto.forcesofreality.entity.util.ModEntityPredicates;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemVorpalSword extends SwordItem {

	public ItemVorpalSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(TextFormatting.ITALIC + "Vorpal Blade").mergeStyle(TextFormatting.AQUA);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Causes A Blast of Holy Distruption dealing damage to"));
		tooltip.add(new StringTextComponent("Surronding Evils and Beasts Alike upon their death."));
		tooltip.add(new StringTextComponent("+10% Max Mob Health Vorpal Damage").mergeStyle(TextFormatting.AQUA));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	public static DamageSource source = new DamageSource("vorpal");

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (ModEntityPredicates.VORPAL.test(target)) {
			target.attackEntityFrom(source, target.getMaxHealth() * 0.15f);
		}
		return super.hitEntity(stack, target, attacker);
	}

}
