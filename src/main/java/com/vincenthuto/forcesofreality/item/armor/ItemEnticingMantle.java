package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemEnticingMantle extends ArmorItem {

	public ItemEnticingMantle(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			EquipmentSlot armorSlot, A _default) {
//		if (itemStack != ItemStack.EMPTY) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//				ModelEnticingMantle model = new ModelEnticingMantle();
//				model.body.visible = armorSlot == EquipmentSlot.CHEST;
//				model.young = _default.young;
//				model.crouching = _default.crouching;
//				model.riding = _default.riding;
//				model.rightArmPose = _default.rightArmPose;
//				model.leftArmPose = _default.leftArmPose;
//
//				return (A) model;
//			}
//		}
//		return null;
//	}

}
