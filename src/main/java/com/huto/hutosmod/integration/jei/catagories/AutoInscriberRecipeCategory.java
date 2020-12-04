
package com.huto.hutosmod.integration.jei.catagories;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.recipes.RecipeAutoInscriber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class AutoInscriberRecipeCategory implements IRecipeCategory<RecipeAutoInscriber> {

	public static final ResourceLocation UID = new ResourceLocation(HutosMod.MOD_ID, "auto_inscriber");
	private final IDrawable background;
	private final String localizedName;
	private final IDrawable overlay;
	private final IDrawable icon;

	public AutoInscriberRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createBlankDrawable(150, 110);
		localizedName = I18n.format("hutosmod.jei.auto_inscriber");
		overlay = guiHelper.createDrawable(new ResourceLocation("hutosmod", "textures/gui/auto_inscriber_overlay.png"),
				0, 0, 150, 110);
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.auto_inscriber.get()));
	}

	@Nonnull
	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Nonnull
	@Override
	public Class<? extends RecipeAutoInscriber> getRecipeClass() {
		return RecipeAutoInscriber.class;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return localizedName;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Nonnull
	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setIngredients(RecipeAutoInscriber recipe, IIngredients iIngredients) {
		List<List<ItemStack>> list = new ArrayList<>();
		for (Ingredient ingr : recipe.getInputs()) {
			list.add(Arrays.asList(ingr.getMatchingStacks()));
		}
		iIngredients.setInputLists(VanillaTypes.ITEM, list);
		iIngredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(RecipeAutoInscriber recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		overlay.draw(matrixStack);
		matrixStack.translate(5, 90, 0);
		// TileEntityVibeResonator te = new TileEntityVibeResonator();
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		fontRenderer.drawString(matrixStack,
				"Vibrational Cost: " + TextFormatting.ITALIC + Float.toString(recipe.getManaUsage()) + "/Level", 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		GlStateManager.disableBlend();
		GlStateManager.disableAlphaTest();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull RecipeAutoInscriber recipe,
			@Nonnull IIngredients ingredients) {
		recipeLayout.getItemStacks().init(0, true, 39, 60);
		GlStateManager.pushMatrix();
		GlStateManager.scaled(1.2, 4.2, 1.2);
		recipeLayout.getItemStacks().set(0, new ItemStack(BlockInit.auto_inscriber.get()));
		GlStateManager.popMatrix();

		recipeLayout.getItemStacks().init(1, true, 70, 17);
		recipeLayout.getItemStacks().set(1, ingredients.getInputs(VanillaTypes.ITEM).get(0));

		recipeLayout.getItemStacks().init(2, true, 40, 45);
		recipeLayout.getItemStacks().set(2, ingredients.getInputs(VanillaTypes.ITEM).get(1));

		recipeLayout.getItemStacks().init(3, false, 100, 45);
		recipeLayout.getItemStacks().set(3, ingredients.getOutputs(VanillaTypes.ITEM).get(0));

	}

}