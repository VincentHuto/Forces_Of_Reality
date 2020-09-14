package com.huto.hutosmod.gui.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.glfw.GLFW;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GuiTomePage extends Screen {
	final ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, "textures/gui/book.png");
	int guiWidth = 175;
	int guiHeight = 228;
	int left, top;
	final int ARROWF = 0, ARROWB = 1, TITLEBUTTON = 2, CLOSEBUTTON = 3;

	GuiButtonArrowForward arrowF;
	GuiButtonArrowBackward arrowB;
	GuiButtonTextured buttonTitle;
	GuiButtonTextured buttonCloseTab;

	TextFieldWidget textBox;
	int pageNum;
	String title;
	String subtitle;
	ItemStack icon;
	String text;
	EnumTomeCatagories catagory;
	static StringTextComponent titleComponent = new StringTextComponent("");

	@OnlyIn(Dist.CLIENT)
	public GuiTomePage(int pageNumIn, EnumTomeCatagories catagoryIn, String titleIn, String subtitleIn,
			ItemStack iconIn, String textIn) {
		super(titleComponent);
		this.title = titleIn;
		this.subtitle = subtitleIn;
		this.icon = iconIn;
		this.text = textIn;
		this.pageNum = pageNumIn;
		this.catagory = catagoryIn;
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
		{
			GlStateManager.translatef((width / 2) - 40, centerY + 10, 10);
			GlStateManager.scalef(1, 1, 1);
			drawString(matrixStack, font, "Pg." + pageNum, 90, 0, 0000000);
			drawString(matrixStack, font, title, -5, 0, 8060954);
			drawString(matrixStack, font, subtitle, -5, 10, 8060954);
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			GlStateManager.translatef((width / 2) - 20, centerY + 10, 10);
			GlStateManager.scalef(0.9f, 1, 1);
			GlStateManager.translatef(-65f, 25, 0);

			// drawCenteredString(matrixStack, font, I18n.format(text), 175, 10, 10);
			// Split String(text,x,y,wrapwidth,color)
			font.func_238418_a_(new StringTextComponent(I18n.format(text)), 0, 0, 175, 0);
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			GlStateManager.color4f(1, 1, 1, 1);
			switch (this.catagory) {
			case ELDER:
				if (pageNum != (TomePageLib.ElderPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case EQUIPS:
				if (pageNum != (TomePageLib.ArmorPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case INTRO:
				if (pageNum != (TomePageLib.IntroPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case KARMA:
				if (pageNum != (TomePageLib.KarmaPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case MACHINES:
				if (pageNum != (TomePageLib.BlocksPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case RUNES:
				if (pageNum != (TomePageLib.RunesPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case WANDS:
				if (pageNum != (TomePageLib.WandsPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case GENERATION:
				if (pageNum != (TomePageLib.GeneratePageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			case WORLDGEN:
				if (pageNum != (TomePageLib.WorldGenPageList.size() - 1)) {
					arrowF.renderButton(matrixStack, mouseX, mouseY, 111);
				}
				break;
			default:
				break;

			}

			if (pageNum > 0) {

				arrowB.renderButton(matrixStack, mouseX, mouseY, 211);
			}
			buttonTitle.renderButton(matrixStack, mouseX, mouseY, 311);
			buttonCloseTab.renderButton(matrixStack, mouseX, mouseY, 411);
			GlStateManager.popMatrix();

		}
		GlStateManager.translatef(3, 0, 0);
		GlStateManager.pushMatrix();
		{
			GlStateManager.translatef(centerX, centerY, 0);
			GlStateManager.translatef(3, 3, 0);
			GlStateManager.scalef(1.9f, 1.7f, 1.9f);
			RenderHelper.enableStandardItemLighting();
			Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(icon, 0, 0);
		}
		GlStateManager.popMatrix();
		textBox.render(matrixStack, mouseX, mouseY, partialTicks);
		List<ITextComponent> text = new ArrayList<ITextComponent>();
		text.add(new StringTextComponent(I18n.format(icon.getDisplayName().getString())));
		func_243308_b(matrixStack, text, centerX, centerY);

		List<ITextComponent> titlePage = new ArrayList<ITextComponent>();
		titlePage.add(new StringTextComponent(I18n.format("Title")));
		titlePage.add(new StringTextComponent(I18n.format("Return to Catagories")));
		if (buttonTitle.isHovered()) {
			func_243308_b(matrixStack, titlePage, left - guiWidth + 149, top + guiHeight - 209);
		}
		List<ITextComponent> ClosePage = new ArrayList<ITextComponent>();
		ClosePage.add(new StringTextComponent(I18n.format("Close Book")));
		if (buttonCloseTab.isHovered()) {
			func_243308_b(matrixStack, ClosePage, left - guiWidth + 149, top + guiHeight - 193);
		}
	}

	Minecraft mc = Minecraft.getInstance();

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		buttons.clear();

		switch (this.catagory) {
		case ELDER:
			if (pageNum != (TomePageLib.ElderPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case EQUIPS:
			if (pageNum != (TomePageLib.ArmorPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case INTRO:
			if (pageNum != (TomePageLib.IntroPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case KARMA:
			if (pageNum != (TomePageLib.KarmaPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case MACHINES:
			if (pageNum != (TomePageLib.BlocksPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case GENERATION:
			if (pageNum != (TomePageLib.GeneratePageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case RUNES:
			if (pageNum != (TomePageLib.RunesPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case WANDS:
			if (pageNum != (TomePageLib.WandsPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		case WORLDGEN:
			if (pageNum != (TomePageLib.WorldGenPageList.size() - 1)) {
				this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
						(press) -> {
							buttonUseCheck(arrowF);
						}));
			}
			if (pageNum != 0) {
				this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, (press) -> {
					buttonUseCheck(arrowB);
				}));
			}
			break;
		default:
			break;

		}

		this.addButton(buttonTitle = new GuiButtonTextured(texture, TITLEBUTTON, left - guiWidth + 150,
				top + guiHeight - 209, 24, 16, 174, 32, null, (press) -> {
					buttonUseCheck(buttonTitle);
				}));

		this.addButton(buttonCloseTab = new GuiButtonTextured(texture, CLOSEBUTTON, left - guiWidth + 150,
				top + guiHeight - 193, 24, 16, 174, 64, null, (press) -> {
					buttonUseCheck(buttonCloseTab);
				}));
		textBox = new TextFieldWidget(font, left - guiWidth + 155, top + guiHeight - 227, 14, 14,
				new StringTextComponent(""));
		super.init();
	}

	public void buttonUseCheck(Button buttonIn) {
		if (buttonIn instanceof GuiButtonTextured) {

			GuiButtonTextured button = (GuiButtonTextured) buttonIn;
			switch (button.getId()) {
			case CLOSEBUTTON:
				this.closeScreen();
				break;

			case TITLEBUTTON:
				if (ClientEventSubscriber.getClientPlayer().getHeldItemMainhand().getItem() == ItemInit.elder_tome
						.get()) {
					mc.displayGuiScreen(new GuiTomeTitle(true));
				} else {
					mc.displayGuiScreen(new GuiTomeTitle(false));

				}
				break;

			}

		}

		if (buttonIn instanceof GuiButtonArrowForward) {
			GuiButtonArrowForward button = (GuiButtonArrowForward) buttonIn;
			switch (button.getId()) {
			case ARROWF:
				if (this.catagory == EnumTomeCatagories.INTRO) {
					if (pageNum != (TomePageLib.IntroPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.IntroPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.IntroPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.EQUIPS) {
					if (pageNum != (TomePageLib.ArmorPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.KARMA) {
					if (pageNum != (TomePageLib.KarmaPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.MACHINES) {
					if (pageNum != (TomePageLib.BlocksPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.GENERATION) {
					if (pageNum != (TomePageLib.GeneratePageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get((pageNum)));
						break;
					}
				}

				if (this.catagory == EnumTomeCatagories.WANDS) {
					if (pageNum != (TomePageLib.WandsPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.WORLDGEN) {
					if (pageNum != (TomePageLib.WorldGenPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.RUNES) {
					if (pageNum != (TomePageLib.RunesPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get((pageNum)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.ELDER) {
					if (pageNum != (TomePageLib.ElderPageList.size() - 1)) {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get((pageNum + 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get((pageNum)));
						break;
					}
				}

			}

		}

		if (buttonIn instanceof GuiButtonArrowBackward) {
			GuiButtonArrowBackward button = (GuiButtonArrowBackward) buttonIn;
			switch (button.getId()) {
			case ARROWB:
				if (this.catagory == EnumTomeCatagories.INTRO) {
					if (pageNum > 0) {
						System.out.println("TEST");

						mc.displayGuiScreen(TomePageLib.IntroPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.IntroPageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.EQUIPS) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get(0));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.KARMA) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.MACHINES) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.GENERATION) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.WANDS) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.WORLDGEN) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get((0)));
						break;
					}
				}
				if (this.catagory == EnumTomeCatagories.RUNES) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get((0)));
						break;
					}
				}

				if (this.catagory == EnumTomeCatagories.ELDER) {
					if (pageNum > 0) {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get((pageNum - 1)));
						break;
					} else {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get((0)));
						break;
					}
				}

			}
		}
	}

	public void updateTextBoxes() {
		if (!textBox.getText().isEmpty()) {
			if (NumberUtils.isCreatable(textBox.getText())) {
				int searchNum = (Integer.parseInt(textBox.getText()));

				switch (this.catagory) {
				case ELDER:
					if (searchNum < TomePageLib.ElderPageList.size()) {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.ElderPageList.size()) {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get(TomePageLib.ElderPageList.size() - 1));
					}
					break;
				case EQUIPS:
					if (searchNum < TomePageLib.ArmorPageList.size()) {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.ArmorPageList.size()) {
						mc.displayGuiScreen(TomePageLib.ArmorPageList.get(TomePageLib.ArmorPageList.size() - 1));
					}
					break;
				case INTRO:
					if (searchNum < TomePageLib.IntroPageList.size()) {
						mc.displayGuiScreen(TomePageLib.IntroPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.IntroPageList.size()) {
						mc.displayGuiScreen(TomePageLib.IntroPageList.get(TomePageLib.IntroPageList.size() - 1));
					}
					break;
				case KARMA:
					if (searchNum < TomePageLib.KarmaPageList.size()) {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.KarmaPageList.size()) {
						mc.displayGuiScreen(TomePageLib.KarmaPageList.get(TomePageLib.KarmaPageList.size() - 1));
					}
					break;
				case MACHINES:
					if (searchNum < TomePageLib.BlocksPageList.size()) {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.BlocksPageList.size()) {
						mc.displayGuiScreen(TomePageLib.BlocksPageList.get(TomePageLib.BlocksPageList.size() - 1));
					}
					break;
				case GENERATION:
					if (searchNum < TomePageLib.GeneratePageList.size()) {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get(searchNum));
					} else if (searchNum >= TomePageLib.GeneratePageList.size()) {
						mc.displayGuiScreen(TomePageLib.GeneratePageList.get(TomePageLib.GeneratePageList.size() - 1));
					}
					break;
				case RUNES:
					if (searchNum < TomePageLib.RunesPageList.size()) {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.RunesPageList.size()) {
						mc.displayGuiScreen(TomePageLib.RunesPageList.get(TomePageLib.RunesPageList.size() - 1));
					}
					break;
				case WANDS:
					if (searchNum < TomePageLib.WandsPageList.size()) {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.WandsPageList.size()) {
						mc.displayGuiScreen(TomePageLib.WandsPageList.get(TomePageLib.WandsPageList.size() - 1));
					}
					break;
				case WORLDGEN:
					if (searchNum < TomePageLib.WorldGenPageList.size()) {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get(searchNum));
					} else if (searchNum >= TomePageLib.WorldGenPageList.size()) {
						mc.displayGuiScreen(TomePageLib.WorldGenPageList.get(TomePageLib.WorldGenPageList.size() - 1));
					}
					break;
				default:
					break;

				}

			}
		}
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		textBox.setText(GLFW.glfwGetKeyName(keyCode, scanCode));
		updateTextBoxes();
		return super.keyPressed(keyCode, scanCode, modifiers);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		textBox.mouseClicked(mouseX, mouseY, mouseButton);
		updateTextBoxes();
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

}
