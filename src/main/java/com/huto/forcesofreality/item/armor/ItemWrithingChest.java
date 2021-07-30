package com.huto.forcesofreality.item.armor;

import com.huto.forcesofreality.model.armor.ModelWrithingChest;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.Item.Properties;

public class ItemWrithingChest extends ArmorItem {

	public ItemWrithingChest(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@SuppressWarnings("unchecked")
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, A _default) {
		if (itemStack != ItemStack.EMPTY) {
			if (itemStack.getItem() instanceof ArmorItem) {
				ModelWrithingChest model = new ModelWrithingChest();
				model.eye4.rotateAngleY = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				model.eye4.rotateAngleX = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				
				model.eye2.rotateAngleY = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				model.eye2.rotateAngleX = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				
				model.eye3.rotateAngleY = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				model.eye3.rotateAngleX = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				
				model.eye1.rotateAngleY = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				model.eye1.rotateAngleX = (float) Math.max(0.5f, (float) -Math.sin(entityLiving.ticksExisted * (entityLiving.world.rand.nextFloat()*0.1f)) * 1f)-15;
				
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
