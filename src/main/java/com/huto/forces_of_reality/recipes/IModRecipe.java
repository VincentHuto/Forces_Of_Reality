package com.huto.forces_of_reality.recipes;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public interface IModRecipe {
	List<Ingredient> getInputs();

	ItemStack getOutput();

	ResourceLocation getId();
}