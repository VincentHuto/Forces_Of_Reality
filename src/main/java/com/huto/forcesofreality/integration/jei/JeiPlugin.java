
package com.huto.forcesofreality.integration.jei;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.integration.jei.catagories.AutoInscriberRecipeCategory;
import com.huto.forcesofreality.integration.jei.catagories.HarmonizerRecipeCategory;
import com.huto.forcesofreality.integration.jei.catagories.RafflesiaRecipeCategory;
import com.huto.forcesofreality.integration.jei.catagories.ResonatorRecipeCategory;
import com.huto.forcesofreality.integration.jei.catagories.VibeFuserRecipeCategory;
import com.huto.forcesofreality.integration.jei.catagories.WandMakerRecipeCategory;
import com.huto.forcesofreality.recipes.ModFuserRecipies;
import com.huto.forcesofreality.recipes.ModHarmonizerRecipes;
import com.huto.forcesofreality.recipes.ModInscriberRecipes;
import com.huto.forcesofreality.recipes.ModRafflesiaRecipies;
import com.huto.forcesofreality.recipes.ModResonatorRecipies;
import com.huto.forcesofreality.recipes.ModWandRecipies;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	private static final ResourceLocation ID = new ResourceLocation(ForcesOfReality.MOD_ID, "main");

	@Override
	public void registerItemSubtypes(@Nonnull ISubtypeRegistration registry) {
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new WandMakerRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new ResonatorRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new VibeFuserRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
	//	registry.addRecipeCategories(new ChiselRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new AutoInscriberRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new HarmonizerRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new RafflesiaRecipeCategory(registry.getJeiHelpers().getGuiHelper()));

	}

	@Override
	public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
	}

	@Override
	public void registerRecipes(@Nonnull IRecipeRegistration registry) {
		registry.addRecipes(ModWandRecipies.wandMakerRecipies, WandMakerRecipeCategory.UID);
		registry.addRecipes(ModResonatorRecipies.resonatorRecipies, ResonatorRecipeCategory.UID);
		registry.addRecipes(ModFuserRecipies.fuserRecipies, VibeFuserRecipeCategory.UID);
	//	registry.addRecipes(ModChiselRecipes.runeRecipies, ChiselRecipeCategory.UID);
		registry.addRecipes(ModInscriberRecipes.inscriberRecipies, AutoInscriberRecipeCategory.UID);
		registry.addRecipes(ModHarmonizerRecipes.harmonizerRecipes, HarmonizerRecipeCategory.UID);
		registry.addRecipes(ModRafflesiaRecipies.rafflesiaRecipies, RafflesiaRecipeCategory.UID);
		registry.addIngredientInfo(new ItemStack(ItemInit.yellow_sign.get()), VanillaTypes.ITEM,
				"The Yellow Sign of Lord Hastur Himself");

	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry) {
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {

		registry.addRecipeCatalyst(new ItemStack(BlockInit.wand_maker.get()), WandMakerRecipeCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(BlockInit.vibe_resonator.get()), ResonatorRecipeCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(BlockInit.vibratory_fuser.get()), VibeFuserRecipeCategory.UID);
	//	registry.addRecipeCatalyst(new ItemStack(BlockInit.runic_chisel_station.get()), ChiselRecipeCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(BlockInit.auto_inscriber.get()), AutoInscriberRecipeCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(BlockInit.crystal_harmonizer.get()), HarmonizerRecipeCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(BlockInit.rafflesia_of_fidelity.get()), RafflesiaRecipeCategory.UID);

	}

	@Nonnull
	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}
}