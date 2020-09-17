
package com.huto.hutosmod.jei.catagories;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.recipes.RecipeFuser;
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

public class VibeFuserRecipeCategory implements IRecipeCategory<RecipeFuser> {

	public static final ResourceLocation UID = new ResourceLocation(HutosMod.MOD_ID, "vibe_fuser");
	private final IDrawable background;
	private final String localizedName;
	private final IDrawable overlay;
	private final IDrawable icon;

	public VibeFuserRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createBlankDrawable(150, 110);
		localizedName = I18n.format("hutosmod.jei.vibefuser");
		overlay = guiHelper.createDrawable(new ResourceLocation("hutosmod", "textures/gui/fuseroverlay.png"), 0, 0, 150,
				110);
		icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.vibratory_fuser.get()));
	}

	@Nonnull
	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Nonnull
	@Override
	public Class<? extends RecipeFuser> getRecipeClass() {
		return RecipeFuser.class;
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
	public void setIngredients(RecipeFuser recipe, IIngredients iIngredients) {
		List<List<ItemStack>> list = new ArrayList<>();
		for (Ingredient ingr : recipe.getInputs()) {
			list.add(Arrays.asList(ingr.getMatchingStacks()));
		}
		iIngredients.setInputLists(VanillaTypes.ITEM, list);
		iIngredients.setOutput(VanillaTypes.ITEM, recipe.getOutput());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void draw(RecipeFuser recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		overlay.draw(matrixStack);
		matrixStack.translate(25, 90, 0);
		FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
		fontRenderer.drawString(matrixStack,
				"Vibrational Cost: " + TextFormatting.ITALIC + Float.toString(recipe.getManaUsage()), 0,
				(int) (fontRenderer.FONT_HEIGHT), 0);
		GlStateManager.disableBlend();
		GlStateManager.disableAlphaTest();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull RecipeFuser recipe,
			@Nonnull IIngredients ingredients) {
		recipeLayout.getItemStacks().init(0, true, 64, 52);
		GlStateManager.pushMatrix();
		GlStateManager.scaled(1.2, 4.2, 1.2);
		recipeLayout.getItemStacks().set(0, new ItemStack(BlockInit.vibratory_fuser.get()));
		GlStateManager.popMatrix();

		int index = 1;
		double angleBetweenEach = 360.0 / ingredients.getInputs(VanillaTypes.ITEM).size();
		Point point = new Point(64, 20), center = new Point(64, 52);

		for (List<ItemStack> o : ingredients.getInputs(VanillaTypes.ITEM)) {
			recipeLayout.getItemStacks().init(index, true, point.x, point.y);
			recipeLayout.getItemStacks().set(index, o);
			index += 1;
			point = rotatePointAbout(point, center, angleBetweenEach);
		}

		recipeLayout.getItemStacks().init(index, false, 103, 17);
		recipeLayout.getItemStacks().set(index, ingredients.getOutputs(VanillaTypes.ITEM).get(0));

	}

	private Point rotatePointAbout(Point in, Point about, double degrees) {
		double rad = degrees * Math.PI / 180.0;
		double newX = Math.cos(rad) * (in.x - about.x) - Math.sin(rad) * (in.y - about.y) + about.x;
		double newY = Math.sin(rad) * (in.x - about.x) + Math.cos(rad) * (in.y - about.y) + about.y;
		return new Point((int) newX, (int) newY);
	}

}