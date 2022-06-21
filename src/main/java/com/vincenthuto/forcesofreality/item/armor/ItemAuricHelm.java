package com.vincenthuto.forcesofreality.item.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemAuricHelm extends ArmorItem {

	public ItemAuricHelm(ArmorMaterial materialIn, EquipmentSlot slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@Override
//	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
//		consumer.accept(new IItemRenderProperties() {
//			@Override
//			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//					EquipmentSlot armorSlot, HumanoidModel<?> _default) {
//				if (itemStack.getItem() == ItemInit.auric_helm.get()) {
//					return ModelAuricHelm.helmet.get();
//
//				}
//				return IItemRenderProperties.super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
//			}
//		});
//	}
}
