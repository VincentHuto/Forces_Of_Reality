package com.vincenthuto.forcesofreality.common.recipe;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemMachinaCage;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class UpgradeMachinaLampDataRecipe extends ShapedRecipe {
	public static class Serializer implements RecipeSerializer<UpgradeMachinaLampDataRecipe> {
		@Override
		public UpgradeMachinaLampDataRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			try {
				return new UpgradeMachinaLampDataRecipe(RecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json));
			} catch (Exception exception) {
				ForcesOfReality.LOGGER.info("Error reading Machina Recipe from packet: ", exception);
				throw exception;
			}
		}

		@Nullable
		@Override
		public UpgradeMachinaLampDataRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			return new UpgradeMachinaLampDataRecipe(RecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer));
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, UpgradeMachinaLampDataRecipe recipe) {
			try {
				RecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe);
			} catch (Exception exception) {
				ForcesOfReality.LOGGER.info("Error writing Machina Recipe to packet: ", exception);
				throw exception;
			}
		}
	}

	public static String TAG_TIER = "tier";

	public UpgradeMachinaLampDataRecipe(final ResourceLocation id, final String group, final int recipeWidth,
			final int recipeHeight, final NonNullList<Ingredient> ingredients, final ItemStack recipeOutput) {
		super(id, group, null, recipeWidth, recipeHeight, ingredients, recipeOutput);
	}

	public UpgradeMachinaLampDataRecipe(ShapedRecipe shapedRecipe) {
		super(shapedRecipe.getId(), shapedRecipe.getGroup(), null, shapedRecipe.getRecipeWidth(),
				shapedRecipe.getRecipeHeight(), shapedRecipe.getIngredients(), shapedRecipe.getResultItem(null));
	}

	@Override
	public ItemStack assemble(CraftingContainer inv, RegistryAccess p_266725_) {
		final ItemStack craftingResult = super.assemble(inv, p_266725_);
		ItemStack dataSource = ItemStack.EMPTY;

		if (!craftingResult.isEmpty()) {
			for (int i = 0; i < inv.getContainerSize(); i++) {
				final ItemStack item = inv.getItem(i);
				if (!item.isEmpty() && item.getItem() instanceof ItemMachinaCage) {
					dataSource = item;
					CompoundTag compound = dataSource.getOrCreateTag();
					int sel = compound.getInt(TAG_TIER);
					compound.putInt(TAG_TIER, sel + 1);
					craftingResult.setTag(compound);
					break;
				}
			}

		}

		return craftingResult;
	}

}