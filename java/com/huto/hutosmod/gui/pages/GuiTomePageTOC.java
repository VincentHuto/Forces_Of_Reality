package com.huto.hutosmod.gui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GuiTomePageTOC extends GuiTomePage {
	final ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, "textures/gui/book.png");
	int guiWidth = 175;
	int guiHeight = 228;
	int left, top;
	final int ARROWF = 0, ARROWB = 1, TITLEBUTTON = 2, CLOSEBUTTON = 3;

	GuiButtonArrowForward arrowF;
	GuiButtonArrowBackward arrowB;
	GuiButtonTextured buttonTitle;
	GuiButtonTextured buttonCloseTab;
	GuiButtonTextured buttonTOC;
	public static List<GuiTomePage> chapterPages = new ArrayList<GuiTomePage>();
	GuiButtonTextured[] buttonArray = new GuiButtonTextured[chapterPages.size()];
	public static List<GuiButtonTextured> buttonList = new ArrayList<GuiButtonTextured>();

	ItemStack icon;
	EnumTomeCatagories catagory;
	static StringTextComponent titleComponent = new StringTextComponent("");

	@OnlyIn(Dist.CLIENT)
	public GuiTomePageTOC(EnumTomeCatagories catagoryIn, ItemStack iconIn) {
		super(0, catagoryIn, "Table of Contents", "", iconIn, "");
		this.icon = iconIn;
		this.catagory = catagoryIn;
	}

	@SuppressWarnings({ "deprecation" })
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
			drawString(matrixStack, font, title, -5, 0, 8060954);
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			// Draw Strings
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			GlStateManager.color4f(1, 1, 1, 1);

			buttonTitle.renderButton(matrixStack, mouseX, mouseY, 311);
			buttonCloseTab.renderButton(matrixStack, mouseX, mouseY, 411);

			for (int i = 1; i < buttonList.size(); i++) {
				buttonList.get(i).renderButton(matrixStack, mouseX, mouseY, 511);
				GlStateManager.translatef(0, 0, 10);
				drawString(matrixStack, font, "Pg." + i, (buttonList.get(i).posX + 2), buttonList.get(i).posY + 2,
						8060954);
				drawString(matrixStack, font, getMatchingChapter().get(i).title, (int) (buttonList.get(i).posX + 25),
						buttonList.get(i).posY + 2, 8060954);

			}

			arrowF.renderButton(matrixStack, mouseX, mouseY, 511);
			arrowB.renderButton(matrixStack, mouseX, mouseY, 511);

		}
		GlStateManager.popMatrix();

		GlStateManager.translatef(3, 0, 0);
		GlStateManager.pushMatrix();
		{
			GlStateManager.translatef(centerX, centerY, 0);
			GlStateManager.translatef(3, 3, 0);
			GlStateManager.scalef(1.9f, 1.7f, 1.9f);
			RenderHelper.enableStandardItemLighting();
			Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(icon, 0, 2);
			
			
			
		}
		GlStateManager.popMatrix();

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

	static Minecraft mc = Minecraft.getInstance();
	static int count = 0;
	static AtomicInteger atomInt = new AtomicInteger(0);

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		int sideLoc = left + guiWidth;
		int verticalLoc = top + guiHeight;
		buttons.clear();
		buttonList.clear();
		checkChapter();

		this.addButton(buttonTitle = new GuiButtonTextured(texture, TITLEBUTTON, left - guiWidth + 150,
				top + guiHeight - 209, 24, 16, 174, 32, null, (press) -> {
					buttonUseCheck(buttonTitle);
				}));

		this.addButton(buttonCloseTab = new GuiButtonTextured(texture, CLOSEBUTTON, left - guiWidth + 150,
				top + guiHeight - 193, 24, 16, 174, 64, null, (press) -> {
					buttonUseCheck(buttonCloseTab);
				}));

		for (int i = 0; i < chapterPages.size(); i++) {
			buttonList.add(new GuiButtonTextured(texture, i, sideLoc - (guiWidth - 5), (verticalLoc - 210) + (i * 15),
					163, 14, 5, 228, null, new IPressable() {
						@Override
						public void onPress(Button press) {
							if (press instanceof GuiButtonTextured) {
								GuiButtonTextured button = (GuiButtonTextured) press;
								tableButtonCheck((button.getId()));
							}
						}
					}));
		}

		for (int i = 0; i < buttonList.size(); i++) {
			this.addButton(buttonList.get(i));
		}

		this.addButton(arrowF = new GuiButtonArrowForward(ARROWF, left + guiWidth - 18, top + guiHeight - 10,
				new IPressable() {
					@Override
					public void onPress(Button p_onPress_1_) {
						mc.displayGuiScreen(getMatchingChapter().get(1));
					}
				}));
		this.addButton(arrowB = new GuiButtonArrowBackward(ARROWB, left, top + guiHeight - 10, new IPressable() {
			@Override
			public void onPress(Button p_onPress_1_) {
				if (ClientEventSubscriber.getClientPlayer().getHeldItemMainhand().getItem() == ItemInit.elder_tome
						.get()) {
					mc.displayGuiScreen(new GuiTomeTitle(true));
				} else {
					mc.displayGuiScreen(new GuiTomeTitle(false));

				}
			}
		}));

	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}

	public void checkChapter() {
		switch (this.catagory) {
		case INTRO:
			chapterPages = TomePageLib.getIntroPageList();
			break;
		case KARMA:
			chapterPages = TomePageLib.getKarmaPageList();
			break;
		case WORLDGEN:
			chapterPages = TomePageLib.getWorldGenPageList();
			break;
		case EQUIPS:
			chapterPages = TomePageLib.getArmorPageList();
			break;
		case WANDS:
			chapterPages = TomePageLib.getWandsPageList();
			break;
		case RUNES:
			chapterPages = TomePageLib.getRunesPageList();
			break;
		case GENERATION:
			chapterPages = TomePageLib.getGeneratePageList();
			break;
		case MACHINES:
			chapterPages = TomePageLib.getBlocksPageList();
			break;
		case ELDER:
			chapterPages = TomePageLib.getElderPageList();
			break;
		default:
			break;

		}
	}

	@Override
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		return false;
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		for (IGuiEventListener iguieventlistener : this.getEventListeners()) {
			if (iguieventlistener.mouseClicked(mouseX, mouseY, mouseButton)) {
				this.setListener(iguieventlistener);
				if (mouseButton == 0) {
					this.setDragging(true);
				}

				return true;
			}
		}

		return false;
	}

	public void tableButtonCheck(int page) {
		mc.displayGuiScreen(this.getMatchingChapter().get(page));

	}

	public List<GuiTomePage> getMatchingChapter() {
		switch (this.catagory) {
		case INTRO:
			return TomePageLib.getIntroPageList();
		case KARMA:
			return TomePageLib.getKarmaPageList();
		case WORLDGEN:
			return TomePageLib.getWorldGenPageList();
		case EQUIPS:
			return TomePageLib.getArmorPageList();
		case WANDS:
			return TomePageLib.getWandsPageList();
		case RUNES:
			return TomePageLib.getRunesPageList();
		case GENERATION:
			return TomePageLib.getGeneratePageList();
		case MACHINES:
			return TomePageLib.getBlocksPageList();
		case ELDER:
			return TomePageLib.getElderPageList();
		default:
			break;

		}
		return null;
	}

}
