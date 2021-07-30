package com.huto.forcesofreality.item.armor;

import com.huto.forcesofreality.ClientProxy;
import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class ItemOldIronChest extends ArmorItem {

	public ItemOldIronChest(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, A _default) {
		return ForcesOfReality.proxy instanceof ClientProxy ? ((ClientProxy) ForcesOfReality.proxy).getArmorModel(armorSlot)
				: null;
	}
}
