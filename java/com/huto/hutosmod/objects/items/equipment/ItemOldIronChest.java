package com.huto.hutosmod.objects.items.equipment;

import com.huto.hutosmod.ClientProxy;
import com.huto.hutosmod.HutosMod;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class ItemOldIronChest extends ArmorItem {

	public ItemOldIronChest(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlotType armorSlot, A _default) {
		return HutosMod.proxy instanceof ClientProxy ? ((ClientProxy) HutosMod.proxy).getRubyArmorModel(armorSlot)
				: null;
	}
}
