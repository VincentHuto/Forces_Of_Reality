package com.huto.hutosmod.gui.pages;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class GuiTomeTitle extends Screen {

	final ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, "textures/gui/newbook.png");
	Minecraft mc = Minecraft.getInstance();

	int guiWidth = 186;
	int guiHeight = 240;
	int left, top;
	final int BUTTONCLOSE = 0;
	final int BUTTONWHITE = 1;
	final int BUTTONYELLOW = 2;
	final int BUTTONBLUE = 3;
	final int BUTTONGREEN = 4;
	final int BUTTONRED = 5;
	final int BUTTONORANGE = 6;
	final int BUTTONCYAN = 7;
	final int BUTTONDARKBLUE = 9;
	final int BUTTONEYE = 8;
	static String title = " Table of Contents";
	static StringTextComponent titleComponent = new StringTextComponent(title);
	String subtitle = " Duality of Nature";
	ItemStack icon = new ItemStack(ItemInit.mana_crystal.get());
	GuiButtonTextured buttonclose, whiteButton, yellowButton, blueButton, greenButton, redButton, orangeButton,
			cyanButton, darkBlueButton, eyeButton;
	boolean isElder;

	public GuiTomeTitle(boolean isElderIn) {
		super(titleComponent);
		this.isElder = isElderIn;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		int centerX = (width / 2) - guiWidth / 2;
		int centerY = (height / 2) - guiHeight / 2;

		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		GuiUtil.drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);

		/*
		 * drawString(matrixStack, font,TextFormatting.GOLD + title, 0, 0, 8060954);
		 * drawString(matrixStack, font,TextFormatting.GOLD + subtitle, 0, 10, 8060954);
		 */

		buttonclose.drawButton(mc, mouseX, mouseY, 16);
		whiteButton.renderButton(matrixStack, mouseX, mouseY, 16);
		yellowButton.renderButton(matrixStack, mouseX, mouseY, 16);
		blueButton.renderButton(matrixStack, mouseX, mouseY, 16);
		greenButton.renderButton(matrixStack, mouseX, mouseY, 16);
		redButton.renderButton(matrixStack, mouseX, mouseY, 16);
		orangeButton.renderButton(matrixStack, mouseX, mouseY, 16);
		cyanButton.renderButton(matrixStack, mouseX, mouseY, 16);
		darkBlueButton.renderButton(matrixStack, mouseX, mouseY, 16);
		if (isElder) {
			eyeButton.renderButton(matrixStack, mouseX, mouseY, 16);
		}

		int sideLoc = left + guiWidth;
		int verticalLoc = top + guiHeight;
		if (buttonclose.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Close"), sideLoc - (guiWidth - 10), verticalLoc - 50);
		}
		if (whiteButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("White"), sideLoc - (guiWidth - 174), verticalLoc - 226);
		}
		if (yellowButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Yellow"), sideLoc - (guiWidth - 175),
					verticalLoc - 181);
		}
		if (blueButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Blue"), sideLoc - (guiWidth - 175), verticalLoc - 153);
		}
		if (greenButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Green"), sideLoc - (guiWidth - 177), verticalLoc - 121);
		}
		if (redButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Red"), sideLoc - (guiWidth - 180), verticalLoc - 91);
		}
		if (orangeButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Orange"), sideLoc - (guiWidth - 177), verticalLoc - 49);
		}
		if (darkBlueButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Dark Blue"), sideLoc - (guiWidth - 177),
					verticalLoc - 69);
		}
		if (cyanButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Cyan"), sideLoc - (guiWidth - 177), verticalLoc - 200);
		}
		if (isElder) {
			if (eyeButton.isHovered()) {
				renderTooltip(matrixStack, new StringTextComponent("Elder"), sideLoc - (guiWidth - 155),
						verticalLoc - 30);
			}
		}
	}

	@Override
	public void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		int sideLoc = left + guiWidth;
		int verticalLoc = top + guiHeight;
		buttons.clear();
		System.out.println("Test");
		this.addButton(buttonclose = new GuiButtonTextured(texture, BUTTONCLOSE, sideLoc - (guiWidth - 10),
				verticalLoc - 50, 32, 32, 209, 32, null, (press) -> {
					closeScreen();
				}));
		this.addButton(whiteButton = new GuiButtonTextured(texture, BUTTONWHITE, sideLoc - (guiWidth - 174),
				verticalLoc - 226, 23, 16, 186, 0, null, (press) -> {
					closeScreen();
				}));
		this.addButton(yellowButton = new GuiButtonTextured(texture, BUTTONYELLOW, sideLoc - (guiWidth - 175),
				verticalLoc - 181, 23, 16, 186, 32, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(blueButton = new GuiButtonTextured(texture, BUTTONBLUE, sideLoc - (guiWidth - 175),
				verticalLoc - 153, 23, 16, 186, 64, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(greenButton = new GuiButtonTextured(texture, BUTTONGREEN, sideLoc - (guiWidth - 177),
				verticalLoc - 121, 24, 16, 186, 96, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(redButton = new GuiButtonTextured(texture, BUTTONRED, sideLoc - (guiWidth - 180),
				verticalLoc - 91, 24, 16, 186, 128, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(orangeButton = new GuiButtonTextured(texture, BUTTONORANGE, sideLoc - (guiWidth - 177),
				verticalLoc - 49, 24, 16, 186, 160, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(darkBlueButton = new GuiButtonTextured(texture, BUTTONDARKBLUE, sideLoc - (guiWidth - 177),
				verticalLoc - 69, 24, 16, 209, 160, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		this.addButton(cyanButton = new GuiButtonTextured(texture, BUTTONCYAN, sideLoc - (guiWidth - 177),
				verticalLoc - 200, 24, 16, 186, 192, null, (press) -> {
					mc.displayGuiScreen(null);
				}));
		if (isElder) {
			this.addButton(eyeButton = new GuiButtonTextured(texture, BUTTONEYE, sideLoc - (guiWidth - 155),
					verticalLoc - 30, 16, 16, 209, 0, null, (press) -> {
						mc.displayGuiScreen(null);
					}));
		}

	}

	@Override
	protected <T extends IGuiEventListener> T addListener(T listener) {

		return super.addListener(listener);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
