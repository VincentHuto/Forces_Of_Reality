package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemVibeSeer extends ArmorItem {

	public ItemVibeSeer(ArmorMaterial materialIn, ArmorItem.Type slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			ArmorItem.Type armorSlot, A _default) {
//		if (itemStack != ItemStack.EMPTY) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//
//				ModelVibeSeer model = new ModelVibeSeer();
//
//				model.head.visible = armorSlot == ArmorItem.Type.HEAD;
//
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
