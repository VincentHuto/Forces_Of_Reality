package com.huto.forcesofreality.capabilitie.adornment;

import net.minecraft.entity.LivingEntity;

public interface IAdornment {

	AdornmentType getAdornmentType();

	default void onWornTick(LivingEntity player) {
	}

	default void onEquipped(LivingEntity player) {
	}

	default void onUnequipped(LivingEntity player) {
	}

	default boolean canEquip(LivingEntity player) {
		return true;
	}

	default boolean canUnequip(LivingEntity player) {
		return true;
	}

	default boolean willAutoSync(LivingEntity player) {
		return false;
	}
}