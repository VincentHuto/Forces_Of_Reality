
package com.vincenthuto.forcesofreality.integration.jei;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.ItemInit;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	private static final ResourceLocation ID = new ResourceLocation(ForcesOfReality.MOD_ID, "main");

	@Nonnull
	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
	//	registry.addRecipeCategories(new RafflesiaRecipeCategory(registry.getJeiHelpers().getGuiHelper()));

	}

	@Override
	public void registerItemSubtypes(@Nonnull ISubtypeRegistration registry) {
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {

		//registry.addRecipeCatalyst(new ItemStack(BlockInit.rafflesia_of_fidelity.get()), RafflesiaRecipeCategory.UID);

	}

	@Override
	public void registerRecipes(@Nonnull IRecipeRegistration registry) {
	//	registry.addRecipes(ModRafflesiaRecipies.rafflesiaRecipies, RafflesiaRecipeCategory.UID);
		registry.addIngredientInfo(new ItemStack(ItemInit.yellow_sign.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("The Yellow Sign of Lord Hastur Himself, carried at the hearts of his devotees."));
		registry.addIngredientInfo(new ItemStack(ItemInit.crossed_keys.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("The keys to the kingdom to which seraph presides over."));
		registry.addIngredientInfo(new ItemStack(ItemInit.everwatchful_pendant.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("The watchful eye of the eldritch lords, manifested as a pendant to make sure thy wills be done."));
		registry.addIngredientInfo(new ItemStack(ItemInit.breath_of_the_beast.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("An intoxicating brew, carried by beastly men to invigorate and embolden them."));
		registry.addIngredientInfo(new ItemStack(ItemInit.integral_cog.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("To the followers of the machine, this Itegral Cog is the most important piece of themselves"));
		registry.addIngredientInfo(new ItemStack(ItemInit.machina_soul.get()), VanillaTypes.ITEM_STACK,
				Component.translatable("Created by tossing Somnolent dust on the ground with glowstone dust and redstone dust"));

	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry) {
	}

	@Override
	public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
	}
}