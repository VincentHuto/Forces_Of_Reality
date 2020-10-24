package com.huto.hutosmod.gui.mindrunes;

import java.util.List;

import com.google.common.collect.Lists;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.gui.pages.GuiButtonTextured;
import com.huto.hutosmod.gui.pages.GuiUtil;
import com.huto.hutosmod.recipes.RecipeChiselStation;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiRunePattern extends Screen {
	final ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, "textures/gui/rune_pattern.png");
	private static final ResourceLocation GUI_Chisel = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/gui/chisel_station.png");
	int guiWidth = 175;
	int guiHeight = 228;
	int left, top;
	String title;
	static StringTextComponent titleComponent = new StringTextComponent("");
	ItemStack icon;
	Minecraft mc = Minecraft.getInstance();
	RecipeChiselStation recipe;
	public GuiButtonTextured[][] runeButtonArray = new GuiButtonTextured[8][8];
	protected List<Button> buttonList = Lists.<Button>newArrayList();

	@OnlyIn(Dist.CLIENT)
	public GuiRunePattern(ItemStack iconIn, RecipeChiselStation recipeIn) {
		super(titleComponent);
		this.icon = iconIn;
		this.recipe = recipeIn;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;
		this.renderBackground(matrixStack);

		GlStateManager.pushMatrix();
		{
			GlStateManager.color4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			GuiUtil.drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth - 1, guiHeight);

		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		for (int i = 0; i < buttonList.size(); i++) {
			buttonList.get(i).renderButton(matrixStack, 0, 0, 10);
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			// The 10 for the z translate draws the text ON the book
			GlStateManager.translatef(((width / 2) - font.getStringWidth(title) / 2) - 75, centerY + 50, 10);
			drawString(matrixStack, font, TextFormatting.GOLD + I18n.format(recipe.getOutput().getTranslationKey()), 0,
					0, 8060954);

		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			GlStateManager.translatef(centerX, centerY, 0);
			GlStateManager.translatef(3, 3, 0);
			GlStateManager.scalef(1.9f, 1.7f, 1.9f);
			RenderHelper.enableStandardItemLighting();
			Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(icon, 36, 6);
		}
		GlStateManager.popMatrix();
	}

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		buttonList.clear();
		int inc = 0;
		for (int i = 0; i < runeButtonArray.length; i++) {
			for (int j = 0; j < runeButtonArray.length; j++) {
				buttonList.add(runeButtonArray[i][j] = new GuiButtonTextured(GUI_Chisel, inc,
						left + guiWidth - (guiWidth - 55 - (i * 8)), top + guiHeight - (160 - (j * 8)), 8, 8, 176, 0,
						false, null, null));
				inc++;
			}
		}
		for (int l = 0; l < runeButtonArray.length; l++) {
			for (int m = 0; m < runeButtonArray.length; m++) {
				for (int k = 0; k < recipe.getActivatedRunes().size(); k++) {
					if (runeButtonArray[l][m].getId() == recipe.getActivatedRunes().get(k)) {
						runeButtonArray[l][m].setState(true);
					}
				}
			}
		}

		super.init();
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		return super.keyPressed(keyCode, scanCode, modifiers);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

}
