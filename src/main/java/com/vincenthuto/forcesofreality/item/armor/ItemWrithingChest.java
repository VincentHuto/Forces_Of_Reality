package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemWrithingChest extends ArmorItem {

	public ItemWrithingChest(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			EquipmentSlot armorSlot, A _default) {
//		if (itemStack != ItemStack.EMPTY) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//				ModelWrithingChest model = new ModelWrithingChest();
//				model.eye4.yRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//				model.eye4.xRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//
//				model.eye2.yRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//				model.eye2.xRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//
//				model.eye3.yRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//				model.eye3.xRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//
//				model.eye1.yRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//				model.eye1.xRot = Math.max(0.5f,
//						(float) -Math.sin(entityLiving.tickCount * (entityLiving.level.random.nextFloat() * 0.1f)) * 1f)
//						- 15;
//
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
