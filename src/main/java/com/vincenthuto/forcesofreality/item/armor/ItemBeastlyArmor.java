package com.vincenthuto.forcesofreality.item.armor;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.model.armor.ModelBeastlyArmor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class ItemBeastlyArmor extends ArmorItem {

	public ItemBeastlyArmor(ArmorMaterial materialIn, ArmorItem.Type slot) {
		super(materialIn, slot, new Item.Properties());
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
					EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				if (itemStack.getItem() == ItemInit.skull_helmet.get()) {
					return ModelBeastlyArmor.helmet.get();
				} else if (itemStack.getItem() == ItemInit.enticing_mantle.get()) {
					return ModelBeastlyArmor.chest.get();
				} else if (itemStack.getItem() == ItemInit.legs_of_fawn.get()) {
					return ModelBeastlyArmor.legs.get();
				} else if (itemStack.getItem() == ItemInit.cloven_hooves.get()) {
					return ModelBeastlyArmor.boots.get();
				}
				return IClientItemExtensions.super.getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot,
						original);
			}
		});
	}
}