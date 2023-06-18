package com.vincenthuto.forcesofreality.common.item.armor;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.vincenthuto.forcesofreality.client.model.armor.ModelWrithingArmor;
import com.vincenthuto.forcesofreality.registry.ItemInit;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ItemWrithingArmor extends ArmorItem {

	public ItemWrithingArmor(ArmorMaterial materialIn, ArmorItem.Type slot) {
		super(materialIn, slot, new Item.Properties());
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
					EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				if (itemStack.getItem() == ItemInit.writhing_helmet.get()) {
					return ModelWrithingArmor.helmet.get();
				} else if (itemStack.getItem() == ItemInit.writhing_chestplate.get()) {
					return ModelWrithingArmor.chest.get();
				} else if (itemStack.getItem() == ItemInit.writhing_leggings.get()) {
					return ModelWrithingArmor.legs.get();
				} else if (itemStack.getItem() == ItemInit.writhing_boots.get()) {
					return ModelWrithingArmor.boots.get();
				}
				return IClientItemExtensions.super.getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot,
						original);
			}
		});
	}
}