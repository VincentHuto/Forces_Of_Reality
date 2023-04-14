package com.vincenthuto.forcesofreality.item.armor;

import java.util.function.Consumer;

import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.model.armor.ModelAuricArmor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ItemAuricArmor extends ArmorItem {

	public ItemAuricArmor(ArmorMaterial materialIn, ArmorItem.Type slot) {
		super(materialIn, slot, new Item.Properties());
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack,

					EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				if (itemStack.getItem() == ItemInit.auric_helm.get()) {
					return ModelAuricArmor.helmet.get();
				} else if (itemStack.getItem() == ItemInit.auric_chest.get()) {
					return ModelAuricArmor.chest.get();
				} else if (itemStack.getItem() == ItemInit.auric_leggings.get()) {
					return ModelAuricArmor.legs.get();
				} else if (itemStack.getItem() == ItemInit.auric_boots.get()) {
					return ModelAuricArmor.boots.get();
				}
				return IClientItemExtensions.super.getHumanoidArmorModel(entityLiving, itemStack, armorSlot, _default);
			}
		});
	}
}