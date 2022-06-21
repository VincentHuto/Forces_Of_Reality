package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemWrithingHelm extends ArmorItem {

	public ItemWrithingHelm(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			EquipmentSlot armorSlot, A _default) {
//		if (itemStack != ItemStack.EMPTY) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//				ModelWrithingHelmet model = new ModelWrithingHelmet();
//				model.bone2.yRot = Math.max(0.5f, (float) -Math.sin(entityLiving.tickCount * 0.1f) * 4f) - 13;
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
