package com.huto.forcesofreality.recipe;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.item.coven.tool.ItemMachinaCage;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class UpgradeMachinaLampDataRecipe extends ShapedRecipe {
	public static String TAG_TIER = "tier";

	public UpgradeMachinaLampDataRecipe(final ResourceLocation id, final String group, final int recipeWidth,
			final int recipeHeight, final NonNullList<Ingredient> ingredients, final ItemStack recipeOutput) {
		super(id, group, recipeWidth, recipeHeight, ingredients, recipeOutput);
	}

	public UpgradeMachinaLampDataRecipe(ShapedRecipe shapedRecipe) {
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
				if (!item.isEmpty() && item.getItem() instanceof ItemMachinaCage) {
					dataSource = item;
					CompoundNBT compound = dataSource.getOrCreateTag();
					int sel = compound.getInt(TAG_TIER);
					compound.putInt(TAG_TIER, sel + 1);
					craftingResult.setTag(compound);
					break;
				}
			}

		}

		return craftingResult;
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<UpgradeMachinaLampDataRecipe> {
		@Nullable
		@Override
		public UpgradeMachinaLampDataRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			return new UpgradeMachinaLampDataRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, buffer));
		}

		@Override
		public UpgradeMachinaLampDataRecipe read(ResourceLocation recipeId, JsonObject json) {
			try {
				return new UpgradeMachinaLampDataRecipe(IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, json));
			} catch (Exception exception) {
				ForcesOfReality.LOGGER.info("Error reading Machina Recipe from packet: ", exception);
				throw exception;
			}
		}

		@Override
		public void write(PacketBuffer buffer, UpgradeMachinaLampDataRecipe recipe) {
			try {
				IRecipeSerializer.CRAFTING_SHAPED.write(buffer, recipe);
			} catch (Exception exception) {
				ForcesOfReality.LOGGER.info("Error writing Machina Recipe to packet: ", exception);
				throw exception;
			}
		}
	}

}