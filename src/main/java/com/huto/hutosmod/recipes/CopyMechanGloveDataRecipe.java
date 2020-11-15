package com.huto.hutosmod.recipes;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.items.tools.ItemMechanGlove;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class CopyMechanGloveDataRecipe extends ShapedRecipe {
	public CopyMechanGloveDataRecipe(final ResourceLocation id, final String group, final int recipeWidth,
			final int recipeHeight, final NonNullList<Ingredient> ingredients, final ItemStack recipeOutput) {
		super(id, group, recipeWidth, recipeHeight, ingredients, recipeOutput);
	}

	public CopyMechanGloveDataRecipe(ShapedRecipe shapedRecipe) {
		super(shapedRecipe.getId(), shapedRecipe.getGroup(), shapedRecipe.getRecipeWidth(),
				shapedRecipe.getRecipeHeight(), shapedRecipe.getIngredients(), shapedRecipe.getRecipeOutput());
	}

	@Override
	public ItemStack getCraftingResult(CraftingInventory inv) {
		final ItemStack craftingResult = super.getCraftingResult(inv);
		ItemStack dataSource = ItemStack.EMPTY;

		if (!craftingResult.isEmpty()) {
			for (int i = 0; i < inv.getSizeInventory(); i++) {
				final ItemStack item = inv.getStackInSlot(i);
				if (!item.isEmpty() && item.getItem() instanceof ItemMechanGlove) {
					dataSource = item;
					break;
				}
			}

			if (!dataSource.isEmpty() && dataSource.hasTag()) {
				craftingResult.setTag(dataSource.getTag().copy());
			}
		}

		return craftingResult;
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<CopyMechanGloveDataRecipe> {
		@Nullable
		@Override
		public CopyMechanGloveDataRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			return new CopyMechanGloveDataRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, buffer));
		}

		@Override
		public CopyMechanGloveDataRecipe read(ResourceLocation recipeId, JsonObject json) {
			try {
				return new CopyMechanGloveDataRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, json));
			} catch (Exception exception) {
				HutosMod.LOGGER.info("Error reading CopyMechanGlove Recipe from packet: ", exception);
				throw exception;
			}
		}

		@Override
		public void write(PacketBuffer buffer, CopyMechanGloveDataRecipe recipe) {
			try {
				IRecipeSerializer.CRAFTING_SHAPED.write(buffer, recipe);
			} catch (Exception exception) {
				HutosMod.LOGGER.info("Error writing CopyMechanGlove Recipe to packet: ", exception);
				throw exception;
			}
		}
	}

}