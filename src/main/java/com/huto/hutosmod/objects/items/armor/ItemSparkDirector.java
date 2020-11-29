package com.huto.hutosmod.objects.items.armor;

import com.huto.hutosmod.models.armor.ModelSparkDirector;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSparkDirector extends ArmorItem {

	public ItemSparkDirector(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ArmorItem) {
				ModelSparkDirector model = new ModelSparkDirector();
				model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
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
