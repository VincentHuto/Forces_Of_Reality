package com.huto.hutosmod.capabilities.mindrunes;

import net.minecraft.entity.LivingEntity;


public interface IRune {

    /**
     * This method return the type of Rune this is.
     * Type is used to determine the slots it can go into.
     */
    RuneType getRuneType();

    /**
     * This method is called once per tick if the Rune is being worn by a player
     */
    default void onWornTick(LivingEntity player) {
    }

    /**
     * This method is called when the Rune is equipped by a player
     */
    default void onEquipped(LivingEntity player) {
    }

    /**
     * This method is called when the Rune is unequipped by a player
     */
    default void onUnequipped(LivingEntity player) {
    }

    /**
     * can this Rune be placed in a Rune slot
     */
    default boolean canEquip(LivingEntity player) {
        return true;
    }

    /**
     * Can this Rune be removed from a Rune slot
     */
    default boolean canUnequip(LivingEntity player) {
        return true;
    }

    /**
     * Will Rune automatically sync to client if a change is detected in its NBT or damage values?
     * Default is off, so override and set to true if you want to auto sync.
     * This sync is not instant, but occurs every 10 ticks (.5 seconds).
     */
    default boolean willAutoSync(LivingEntity player) {
        return false;
    }
}