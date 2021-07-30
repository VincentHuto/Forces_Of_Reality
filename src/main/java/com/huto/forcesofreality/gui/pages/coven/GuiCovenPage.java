package com.huto.forcesofreality.gui.pages.coven;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.lwjgl.glfw.GLFW;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.gui.pages.GuiButtonTextured;
import com.huto.forcesofreality.gui.pages.GuiUtil;
import com.huto.forcesofreality.init.ItemInit;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiCovenPage extends Screen {
	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/coven_book.png");
	int guiWidth = 175;
	int guiHeight = 228;
	int left, top;
	final int ARROWF = 0, ARROWB = 1, TITLEBUTTON = 2, CLOSEBUTTON = 3;
	int pageNum;
	String title;
	static TextComponent titleComponent = new TextComponent("");
	String subtitle;
	String text;
	ItemStack icon;
	GuiButtonCovenArrow arrowF, arrowB;
	GuiButtonTextured buttonTitle;
	GuiButtonTextured buttonCloseTab;
	EditBox textBox;
	EnumTomeCovenants catagory;
	Minecraft mc = Minecraft.getInstance();

	@OnlyIn(Dist.CLIENT)
	public GuiCovenPage(int pageNumIn, EnumTomeCovenants catagoryIn, String titleIn, String subtitleIn,
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
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
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
			// Max Character Length ~663
			font.func_238418_a_(new StringTextComponent(I18n.format(text)), 0, 0, 175, 0);
		}
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		{
			GlStateManager.color4f(1, 1, 1, 1);
			if (pageNum != (getMatchingChapter().size() - 1)) {
				arrowF.render(matrixStack, mouseX, mouseY, 111);
			}

			if (pageNum > 0) {

				arrowB.render(matrixStack, mouseX, mouseY, 211);
			}
			buttonTitle.render(matrixStack, mouseX, mouseY, 311);
			buttonCloseTab.render(matrixStack, mouseX, mouseY, 411);
			GlStateManager.popMatrix();

		}
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

		textBox.render(matrixStack, mouseX, mouseY, partialTicks);
		if (!(mouseX >= (16 * 2) + 16 && mouseX <= (16 * 2) + 16 + width && mouseY >= (16 * 2) + 20
				&& mouseY <= (16 * 2) + 20 + height)) {
			List<ITextComponent> text = new ArrayList<ITextComponent>();
			text.add(new StringTextComponent(I18n.format(icon.getDisplayName().getString())));
			func_243308_b(matrixStack, text, centerX, centerY);
		}

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

	@Override
	protected void init() {
		left = width / 2 - guiWidth / 2;
		top = height / 2 - guiHeight / 2;
		buttons.clear();

		if (pageNum != (getMatchingChapter().size() - 1)) {
			this.addButton(arrowF = new GuiButtonCovenArrow(ARROWF, left + guiWidth - 18, top + guiHeight - 10, 16, 14,
					175, 1, (press) -> {
						if (pageNum != (getMatchingChapter().size() - 1)) {
							mc.displayGuiScreen(getMatchingChapter().get((pageNum + 1)));
						} else {
							mc.displayGuiScreen(getMatchingChapter().get((pageNum)));

						}
					}));
		}
		if (pageNum != 0) {
			this.addButton(
					arrowB = new GuiButtonCovenArrow(ARROWB, left, top + guiHeight - 10, 16, 14, 192, 1, (press) -> {
						if (pageNum > 0) {
							mc.displayGuiScreen(getMatchingChapter().get((pageNum - 1)));
						} else {
							mc.displayGuiScreen(getMatchingChapter().get((0)));

						}
					}));
		}
		this.addButton(buttonTitle = new GuiButtonTextured(texture, TITLEBUTTON, left - guiWidth + 150,
				top + guiHeight - 209, 24, 16, 174, 32, null, (press) -> {
					if (ClientUtils.getClientPlayer().getHeldItemMainhand()
							.getItem() == ItemInit.coven_tome_adv.get()) {
						mc.displayGuiScreen(new GuiCovenTitle(true));
					} else {
						mc.displayGuiScreen(new GuiCovenTitle(false));

					}
				}));
		this.addButton(buttonCloseTab = new GuiButtonTextured(texture, CLOSEBUTTON, left - guiWidth + 150,
				top + guiHeight - 193, 24, 16, 174, 64, null, (press) -> {
					this.closeScreen();
				}));
		textBox = new TextFieldWidget(font, left - guiWidth + 155, top + guiHeight - 227, 14, 14,
				new StringTextComponent(""));
		super.init();
	}

	public void updateTextBoxes() {
		if (!textBox.getText().isEmpty()) {
			if (NumberUtils.isCreatable(textBox.getText())) {
				int searchNum = (Integer.parseInt(textBox.getText()));
				if (searchNum < getMatchingChapter().size()) {
					mc.displayGuiScreen(getMatchingChapter().get(searchNum));
				} else if (searchNum >= getMatchingChapter().size()) {
					mc.displayGuiScreen(getMatchingChapter().get(getMatchingChapter().size() - 1));
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

	public List<GuiCovenPage> getMatchingChapter() {
		switch (this.catagory) {
		case HASTUR:
			return CovenPageLib.getHasturPageList();
		case ELDRITCH:
			return CovenPageLib.getEldritchPageList();
		case ASCENDANT:
			return CovenPageLib.getAscendantPageList();
		case BEAST:
			return CovenPageLib.getBeastPageList();
		case MACHINE:
			return CovenPageLib.getMachinePageList();
		case SELF:
			return CovenPageLib.getSelfPageList();
		case COMBINE:
			return CovenPageLib.getCombinationPageList();
		default:
			break;

		}
		return null;
	}

}
