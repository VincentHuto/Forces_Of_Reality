package com.vincenthuto.forcesofreality.common.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemAuricHelm extends ArmorItem {

	public ItemAuricHelm(ArmorMaterial materialIn, ArmorItem.Type slot, Properties builderIn) {
		super(materialIn, slot, builderIn);
	}

//	@Override
//	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
//		consumer.accept(new IItemRenderProperties() {
//			@Override
//			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
//					ArmorItem.Type armorSlot, HumanoidModel<?> _default) {
//				if (itemStack.getItem() == ItemInit.auric_helm.get()) {
//					return ModelAuricHelm.helmet.get();
//
//				}
//				return IItemRenderProperties.super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
//			}
//		});
//	}
}
