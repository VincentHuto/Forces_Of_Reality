
package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.hutoslib.common.recipe.IModRecipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;

public class RecipeRafflesia implements IModRecipe {
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

	@Override
	public ResourceLocation getId() {
		return id;
	}

	public List<Ingredient> getInputs() {
		return inputs;
	}

	public ItemStack getOutput() {
		return output;
	}

	public float getVibeUsage() {
		return vibes;
	}

	public void write(PacketBuffer buf) {
		buf.writeResourceLocation(id);
		buf.writeVarInt(inputs.size());
		for (Ingredient input : inputs) {
			input.write(buf);
		}
		buf.writeItemStack(output, false);
		buf.writeFloat(vibes);
	}

	public static RecipeRafflesia read(PacketBuffer buf) {
		ResourceLocation id = buf.readResourceLocation();
		Ingredient[] inputs = new Ingredient[buf.readVarInt()];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = Ingredient.read(buf);
		}
		ItemStack output = buf.readItemStack();
		float vibes = buf.readFloat();
		return new RecipeRafflesia(id, output, vibes, inputs);
	}

}