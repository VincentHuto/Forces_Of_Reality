package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemOldIronChest extends ArmorItem {

	public ItemOldIronChest(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@Override
//	public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//			EquipmentSlot armorSlot, A _default) {
//		return ForcesOfReality.proxy instanceof ClientProxy
//				? ((ClientProxy) ForcesOfReality.proxy).getArmorModel(armorSlot)
//				: null;
//	}
}
