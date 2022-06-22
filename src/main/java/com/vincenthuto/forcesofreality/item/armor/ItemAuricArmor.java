package com.vincenthuto.forcesofreality.item.armor;

import com.vincenthuto.forcesofreality.ForcesOfReality.ForcesOfRealityItemGroup;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class ItemAuricArmor extends ArmorItem {

	public ItemAuricArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
		super(materialIn, slot, new Item.Properties().tab(ForcesOfRealityItemGroup.instance).fireResistant());
	}

//	@Override
//	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
//		consumer.accept(new IItemRenderProperties() {
//			@Override
//			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//					EquipmentSlot armorSlot, HumanoidModel<?> _default) {
//				if (itemStack.getItem() == ItemInit.writhing_helmet.get()) {
//					return ModelAuricArmor.helmet.get();
//				}
//				return IItemRenderProperties.super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
//			}
//		});
//	}
}