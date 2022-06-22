package com.vincenthuto.forcesofreality.item.armor;

import java.util.function.Consumer;

import com.vincenthuto.forcesofreality.ForcesOfReality.ForcesOfRealityItemGroup;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.model.armor.ModelWrithingArmor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;

public class ItemWrithingArmor extends ArmorItem {

	public ItemWrithingArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
		super(materialIn, slot, new Item.Properties().tab(ForcesOfRealityItemGroup.instance).fireResistant());
	}

	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
					
					EquipmentSlot armorSlot, HumanoidModel<?> _default) {
				if (itemStack.getItem() == ItemInit.writhing_helmet.get()) {
					return ModelWrithingArmor.helmet.get();
				} else if (itemStack.getItem() == ItemInit.writhing_chestplate.get()) {
					return ModelWrithingArmor.chest.get();
				} else if (itemStack.getItem() == ItemInit.writhing_leggings.get()) {
					return ModelWrithingArmor.legs.get();
				} else if (itemStack.getItem() == ItemInit.writhing_boots.get()) {
					return ModelWrithingArmor.boots.get();
				}
				return IItemRenderProperties.super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
			}
		});
	}
}