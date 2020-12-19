
package com.huto.hutosmod.integration.jei.catagories;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.tileenties.util.EnumCrystalTypes;
import com.huto.hutosmod.recipes.RecipeHarmonizer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class HarmonizerRecipeCategory implements IRecipeCategory<RecipeHarmonizer> {

	public static final ResourceLocation UID = new ResourceLocation(HutosMod.MOD_ID, "crystal_harmonizer");
	private final IDrawable background;
	private final String localizedName;
	private final IDrawable overlay;
	private final IDrawable icon;

	public HarmonizerRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createBlankDrawable(150, 110);
		localizedName = I18n.format("hutosmod.jei.harmonizer");
		overlay = guiHelper.createDrawable(new ResourceLocation("hutosmod", "textures/gui/resonatoroverlay.png"), 0, 0,
				150, 110);
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.crystal_harmonizer.get()));
	}

	@Nonnull
	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Nonnull
	@Override
	public Class<? extends RecipeHarmonizer> getRecipeClass() {
		return RecipeHarmonizer.class;
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
	public void setIngredients(RecipeHarmonizer recipe, IIngredients iIngredients) {
		List<List<ItemStack>> list = new ArrayList<>();
		for (Ingredient ingr : recipe.getInputs()) {
			list.add(Arrays.asList(ingr.getMatchingStacks()));
		}
		iIngredients.setInputLists(VanillaTypes.ITEM, list);
		iIngredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(RecipeHarmonizer recipe, MatrixStack matrixStack, double mouseX, double mouseY) {

		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		overlay.draw(matrixStack);

		matrixStack.translate(10, 90, 0);
		// TileEntityVibeResonator te = new TileEntityVibeResonator();
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		fontRenderer.drawString(matrixStack,
				"Vibrational Cost: " + TextFormatting.ITALIC + Float.toString(recipe.getManaUsage()) + "/Level", 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		matrixStack.translate(0, -10, 0);
		fontRenderer.drawString(matrixStack, "Phase:" + TextFormatting.ITALIC + recipe.getRecipeType().toString(), 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		GlStateManager.disableBlend();
		GlStateManager.disableAlphaTest();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull RecipeHarmonizer recipe,
			@Nonnull IIngredients ingredients) {
		recipeLayout.getItemStacks().init(0, true, 64, 52);
		recipeLayout.getItemStacks().init(1, false, 64, 70);

		GlStateManager.pushMatrix();
		GlStateManager.scaled(1.2, 4.2, 1.2);

		Block catalyst;
		if (recipe.getRecipeType() == EnumCrystalTypes.TOPAZ) {
			catalyst = Blocks.SANDSTONE;
		} else if (recipe.getRecipeType() == EnumCrystalTypes.AMETHYST) {
			catalyst = Blocks.END_STONE;

		} else if (recipe.getRecipeType() == EnumCrystalTypes.HEMATITE) {
			catalyst = Blocks.IRON_ORE;

		} else if (recipe.getRecipeType() == EnumCrystalTypes.ONYX) {
			catalyst = Blocks.OBSIDIAN;

		} else if (recipe.getRecipeType() == EnumCrystalTypes.SAPPHIRE) {
			catalyst = Blocks.LAPIS_BLOCK;

		} else if (recipe.getRecipeType() == EnumCrystalTypes.RUBY) {
			catalyst = Blocks.REDSTONE_BLOCK;

		} else if (recipe.getRecipeType() == EnumCrystalTypes.OPAL) {
			catalyst = BlockInit.opal_block.get();

		} else {
			catalyst = Blocks.AIR;

		}
		ItemStack catalystStack = new ItemStack(catalyst);

		recipeLayout.getItemStacks().set(0, new ItemStack(BlockInit.crystal_harmonizer.get()));
		recipeLayout.getItemStacks().set(1, catalystStack);
		GlStateManager.popMatrix();
		int index = 2;
		ingredients.getInputs(VanillaTypes.ITEM).size();
		Point point = new Point(64, 5);
		new Point(64, 52);

		for (List<ItemStack> o : ingredients.getInputs(VanillaTypes.ITEM)) {
			recipeLayout.getItemStacks().init(index, true, point.x, point.y);
			recipeLayout.getItemStacks().set(index, o);
			index += 1;
			point = new Point(64, -40 + ((index + 1) * 15));
		}

		recipeLayout.getItemStacks().init(index, false, 103, 17);
		recipeLayout.getItemStacks().set(index, ingredients.getOutputs(VanillaTypes.ITEM).get(0));

	}

}