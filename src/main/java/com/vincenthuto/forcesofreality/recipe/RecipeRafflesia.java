
package com.vincenthuto.forcesofreality.recipe;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.vincenthuto.hutoslib.common.recipe.IModRecipe;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.items.IItemHandler;

public class RecipeRafflesia implements IModRecipe {
	public static RecipeRafflesia read(FriendlyByteBuf buf) {
		ResourceLocation id = buf.readResourceLocation();
		Ingredient[] inputs = new Ingredient[buf.readVarInt()];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = Ingredient.fromNetwork(buf);
		}
		ItemStack output = buf.readItem();
		float vibes = buf.readFloat();
		return new RecipeRafflesia(id, output, vibes, inputs);
	}
	private final ResourceLocation id;
	private final ItemStack output;
	private final ImmutableList<Ingredient> inputs;

	private final float vibes;

	public RecipeRafflesia(ResourceLocation id, ItemStack output, float vibesIn, Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 16);
		Preconditions.checkArgument(vibesIn <= 100000);
		this.id = id;
		this.output = output;
		this.inputs = ImmutableList.copyOf(inputs);
		this.vibes = vibesIn;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public List<Ingredient> getInputs() {
		return inputs;
	}

	@Override
	public ItemStack getOutput() {
		return output;
	}

	public float getVibeUsage() {
		return vibes;
	}

	public boolean matches(IItemHandler inv) {
		List<Ingredient> ingredientsMissing = new ArrayList<>(inputs);

		for (int i = 0; i < inv.getSlots(); i++) {
			ItemStack input = inv.getStackInSlot(i);
			if (input.isEmpty())
				break;

			int stackIndex = -1;

			for (int j = 0; j < ingredientsMissing.size(); j++) {
				Ingredient ingr = ingredientsMissing.get(j);
				if (ingr.test(input)) {

					stackIndex = j;
					break;
				}
			}

			if (stackIndex != -1)
				ingredientsMissing.remove(stackIndex);
			else
				return false;
		}
		return ingredientsMissing.isEmpty();
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeResourceLocation(id);
		buf.writeVarInt(inputs.size());
		for (Ingredient input : inputs) {
			input.toNetwork(buf);
		}
		buf.writeItemStack(output, false);
		buf.writeFloat(vibes);
	}

}