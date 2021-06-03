package com.huto.forcesofreality.objects.items.armor;

import com.google.common.base.Supplier;
import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum EnumModArmorTiers implements IArmorMaterial {
	ANOINTED(ForcesOfReality.MOD_ID + ":anointed_iron", 37, new int[] { 3, 6, 8, 3 }, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.anointed_iron_scrap.get());
			}),
	ELDER(ForcesOfReality.MOD_ID + ":elder", 37, new int[] { 1, 2, 3, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.unsettling_fabric.get());
			}),
	SUPPRESSOR(ForcesOfReality.MOD_ID + ":influence_supressor", 37, new int[] { 1, 1, 1, 1 }, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.anointed_iron_scrap.get());
			}),
	SKULL(ForcesOfReality.MOD_ID + ":skull", 37, new int[] { 3, 1, 1, 3 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.beastly_bone.get());
			}),
	MANTLE(ForcesOfReality.MOD_ID + ":mantle", 5, new int[] { 1, 3, 3, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.beastly_bone.get());
			}),

	SPARKDIRECTOR(ForcesOfReality.MOD_ID + ":spark_director", 37, new int[] { 1, 4, 2, 1 }, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.auric_ingot.get());
			}),
	AURICHELM(ForcesOfReality.MOD_ID + ":auric_helm", 17, new int[] { 2, 4, 5, 2 }, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.auric_ingot.get());
			}),
	SPARKDIRECTOR_ARMORED(ForcesOfReality.MOD_ID + ":spark_director_armored", 17, new int[] { 2, 5, 6, 2 }, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.0F, 0.3F, () -> {
				return Ingredient.fromItems(ItemInit.auric_ingot.get());
			}),
	AURICCHEST(ForcesOfReality.MOD_ID + ":auric_chest", 17, new int[] { 2, 5, 6, 2 }, 25,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 6.0F, 0.3F, () -> {
				return Ingredient.fromItems(ItemInit.auric_ingot.get());
			}),
	SERAPHWINGS(ForcesOfReality.MOD_ID + ":seraph_wings", 37, new int[] { 6, 6, 6, 6 }, 15,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.seraph_feather.get());
			}),
	WRITHING(ForcesOfReality.MOD_ID + ":writhing", 15, new int[] { 1, 4, 5, 2 }, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.writhing_thread.get());
			}),
	WRITHINGHELM(ForcesOfReality.MOD_ID + ":writhinghelm", 15, new int[] { 1, 4, 5, 2 }, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.suspicious_eye.get());
			}),
	WRITHINGCHEST(ForcesOfReality.MOD_ID + ":writhingchest", 5, new int[] { 1, 4, 5, 2 }, 12,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 0.1F, () -> {
				return Ingredient.fromItems(ItemInit.writhing_thread.get());
			});
	;

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float field_234660_o_;
	private final LazyValue<Ingredient> repairMaterial;

	private EnumModArmorTiers(String name, int damgaeFactor, int[] armorVals, int ench, SoundEvent soundevent,
			float tough, float p_i231593_9_, Supplier<Ingredient> repairIng) {
		this.name = name;
		this.maxDamageFactor = damgaeFactor;
		this.damageReductionAmountArray = armorVals;
		this.enchantability = ench;
		this.soundEvent = soundevent;
		this.toughness = tough;
		this.field_234660_o_ = p_i231593_9_;
		this.repairMaterial = new LazyValue<>(repairIng);
	}

	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.field_234660_o_;
	}

}
