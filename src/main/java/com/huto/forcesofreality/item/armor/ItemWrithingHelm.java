package com.huto.forcesofreality.item.armor;

import com.huto.forcesofreality.model.armor.ModelWrithingHelmet;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class ItemWrithingHelm extends ArmorItem {

	public ItemWrithingHelm(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, A _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ArmorItem) {
				ModelWrithingHelmet model = new ModelWrithingHelmet();
				model.bone2.rotateAngleY = (float) Math.max(0.5f,
						(float) -Math.sin(entityLiving.ticksExisted * 0.1f) * 4f) - 13;
				model.isChild = _default.isChild;
				model.isSneak = _default.isSneak;
				model.isSitting = _default.isSitting;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;

				return (A) model;
			}
		}
		return null;
	}

}
