
package com.huto.forcesofreality.integration.jei.catagories;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.objects.tileenties.util.EnumEssecenceType;
import com.huto.forcesofreality.recipes.RecipeResonator;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class ResonatorRecipeCategory implements IRecipeCategory<RecipeResonator> {

	public static final ResourceLocation UID = new ResourceLocation(ForcesOfReality.MOD_ID, "vibe_resonator");
	private final IDrawable background;
	private final String localizedName;
	private final IDrawable overlay;
	private final IDrawable icon;

	public ResonatorRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createBlankDrawable(150, 110);
		localizedName = I18n.format("forcesofreality.jei.resonator");
		overlay = guiHelper.createDrawable(new ResourceLocation("forcesofreality", "textures/gui/resonatoroverlay.png"), 0, 0,
				150, 110);
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.vibe_resonator.get()));
	}

	@Nonnull
	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Nonnull
	@Override
	public Class<? extends RecipeResonator> getRecipeClass() {
		return RecipeResonator.class;
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
	public void setIngredients(RecipeResonator recipe, IIngredients iIngredients) {
		List<List<ItemStack>> list = new ArrayList<>();
		for (Ingredient ingr : recipe.getInputs()) {
			list.add(Arrays.asList(ingr.getMatchingStacks()));
		}
		iIngredients.setInputLists(VanillaTypes.ITEM, list);
		iIngredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(RecipeResonator recipe, MatrixStack matrixStack, double mouseX, double mouseY) {

		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		overlay.draw(matrixStack);

		matrixStack.translate(10, 90, 0);
		// TileEntityVibeResonator te = new TileEntityVibeResonator();
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		fontRenderer.drawString(matrixStack,
				"Vibrational Cost: " + TextFormatting.ITALIC + Float.toString(recipe.getVibeUsage()) + "/Level", 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		matrixStack.translate(0, -10, 0);
		fontRenderer.drawString(matrixStack, "Phase:" + TextFormatting.ITALIC + recipe.getRecipeType().toString(), 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		GlStateManager.disableBlend();
		GlStateManager.disableAlphaTest();

	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull RecipeResonator recipe,
			@Nonnull IIngredients ingredients) {
		recipeLayout.getItemStacks().init(0, true, 64, 52);
		recipeLayout.getItemStacks().init(1, false, 64, 70);

		GlStateManager.pushMatrix();
		GlStateManager.scaled(1.2, 4.2, 1.2);

		Block catalyst;
		if (recipe.getRecipeType() == EnumEssecenceType.SOMNOLENT) {
			catalyst = BlockInit.somnolent_media.get();
		} else if (recipe.getRecipeType() == EnumEssecenceType.KARMIC) {
			catalyst = BlockInit.activated_obsidian.get();

		} else if (recipe.getRecipeType() == EnumEssecenceType.REVERT) {
			catalyst = BlockInit.reversion_catalyst.get();

		} else if (recipe.getRecipeType() == EnumEssecenceType.GREY) {
			catalyst = BlockInit.mind_fog.get();

		} else if (recipe.getRecipeType() == EnumEssecenceType.BOTH) {
			catalyst = BlockInit.nightmare_media.get();

		} else if (recipe.getRecipeType() == EnumEssecenceType.NULL) {
			catalyst = BlockInit.anti_media.get();

		} else if (recipe.getRecipeType() == EnumEssecenceType.ASCENDANT) {
			catalyst = BlockInit.anointing_focus.get();

		} else {
			catalyst = BlockInit.somnolent_stone_smooth.get();

		}
		ItemStack catalystStack = new ItemStack(catalyst);

		recipeLayout.getItemStacks().set(0, new ItemStack(BlockInit.vibe_resonator.get()));
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