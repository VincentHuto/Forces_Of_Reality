package com.huto.forcesofreality.item.armor;

import com.huto.forcesofreality.model.armor.ModelAuricHelm;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class ItemAuricHelm extends ArmorItem {

	public ItemAuricHelm(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, A _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ArmorItem) {
				ModelAuricHelm model = new ModelAuricHelm();
		//		model.Head.rotateAngleX = (float) Math.sin(entityLiving.getEntityWorld().getGameTime())*0.1f;
				model.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
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
