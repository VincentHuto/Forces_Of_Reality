package com.huto.forcesofreality.gui.pages.coven;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.guardians.EntitySeraphim;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.huto.forcesofreality.gui.pages.GuiButtonTextured;
import com.huto.forcesofreality.gui.pages.GuiUtil;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiCovenTitle extends Screen {

	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/coven_title.png");
	Minecraft mc = Minecraft.getInstance();

	int guiWidth = 186;
	int guiHeight = 240;
	int left, top;
	final int BUTTONCLOSE = 0;
	final int BUTTONHASTUR = 1;
	final int BUTTONELDRITCH = 2;
	final int BUTTONASCEND = 3;
	final int BUTTONBEAST = 4;
	final int BUTTONMACHINE = 5;
	final int BUTTONSELF = 6;
	int BUTTONEYE = 8;
	static String title = " Table of Contents";
	static StringTextComponent titleComponent = new StringTextComponent(title);
	String subtitle = " Covenants";
	ItemStack icon = new ItemStack(Items.PAPER);
	GuiButtonTextured buttonclose, hasturButton, eldritchButton, ascendButton, beastButton, machineButton, selfButton,
			eyeButton;
	boolean isElder;

	public GuiCovenTitle(boolean isElderIn) {
		super(titleComponent);
		this.isElder = isElderIn;

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
			GuiUtil.drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			// The 10 for the z translate draws the text ON the book
			GlStateManager.translatef((width / 2) - font.getStringWidth(title) / 2, centerY + 10, 10);
			drawString(matrixStack, font, TextFormatting.GOLD + title, 0, 0, 8060954);
			drawString(matrixStack, font, TextFormatting.GOLD + subtitle, 0, 10, 8060954);
		}
		GlStateManager.popMatrix();

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).render(matrixStack, mouseX, mouseY, partialTicks);
			if (isElder) {
				eyeButton.renderButton(matrixStack, mouseX, mouseY, 16);
			}

		}

		GlStateManager.pushMatrix();
		{

			GlStateManager.translatef(centerX, centerY, 0);
			GlStateManager.scalef(2, 2, 2);
			mc.getItemRenderer().renderItemAndEffectIntoGUI(icon, 0, 0);
			GlStateManager.scalef(2, 2, 2);
			GlStateManager.translatef(18, 25, 0);
			// Enables lighting so it doesnt look dark
			RenderHelper.enableStandardItemLighting();
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(BlockInit.hastur_pylon.get()), 0, -4);
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(BlockInit.ascendant_altar.get()), 0, 8);

			GlStateManager.pushMatrix();
			GlStateManager.translatef(3, -5, 0);
			GlStateManager.scalef(0.5f, 0.5f, 0.5f);
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(ItemInit.ball_of_eyes.get()), 0, -9);
			GlStateManager.popMatrix();

			GlStateManager.scalef(15, 15, 15);
			GlStateManager.translatef(0.5f, 1.2f, 0f);
			GlStateManager.rotatef(180, 100, 0, 360);

			// OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f,
			// 240f);

			IRenderTypeBuffer.Impl bufferIn = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());

			mc.getRenderManager().renderEntityStatic(
					new EntitySeraphim(EntityInit.seraphim.get(),
							ClientEventSubscriber.getClientPlayer().getEntityWorld()),
					1, 0, 0, 33, partialTicks, matrixStack, bufferIn, 255255255);

			bufferIn.finish();
			GlStateManager.rotatef(-25, 0, 10, 40);
			GlStateManager.translatef(0f, 1.5f, 3f);
			GlStateManager.scalef(0.5f, 0.5f, 0.5f);

		}
		GlStateManager.popMatrix();

		if (buttonclose.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Close"), mouseX, mouseY);
		}
		if (hasturButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Hastur"), mouseX, mouseY);
		}
		if (eldritchButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Eldrtich"), mouseX, mouseY);
		}
		if (ascendButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Ascendants"), mouseX, mouseY);
		}
		if (beastButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Beast"), mouseX, mouseY);
		}
		if (machineButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Machina"), mouseX, mouseY);
		}
		if (selfButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Self"), mouseX, mouseY);
		}
		if (isElder) {
			if (eyeButton.isHovered()) {
				renderTooltip(matrixStack, new StringTextComponent("Combinations"), mouseX, mouseY);
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
		this.addButton(buttonclose = new GuiButtonTextured(texture, BUTTONCLOSE, sideLoc - (guiWidth - 10),
				verticalLoc - 50, 32, 32, 209, 32, null, (press) -> {
					closeScreen();
				}));

		this.addButton(selfButton = new GuiButtonTextured(texture, BUTTONSELF, sideLoc - (guiWidth - 174),
				verticalLoc - 226, 24, 16, 186, 160, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.SelfPageList.get(0));
				}));

		this.addButton(hasturButton = new GuiButtonTextured(texture, BUTTONHASTUR, sideLoc - (guiWidth - 175),
				verticalLoc - 181, 23, 16, 186, 0, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.HasturPageList.get(0));
				}));
		this.addButton(ascendButton = new GuiButtonTextured(texture, BUTTONASCEND, sideLoc - (guiWidth - 175),
				verticalLoc - 153, 23, 16, 186, 64, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.AscendantPageList.get(0));
				}));

		this.addButton(eldritchButton = new GuiButtonTextured(texture, BUTTONELDRITCH, sideLoc - (guiWidth - 177),
				verticalLoc - 121, 23, 16, 186, 32, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.EldritchPageList.get(0));
				}));

		this.addButton(machineButton = new GuiButtonTextured(texture, BUTTONMACHINE, sideLoc - (guiWidth - 177),
				verticalLoc - 100, 24, 16, 186, 128, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.MachinePageList.get(0));
				}));

		this.addButton(beastButton = new GuiButtonTextured(texture, BUTTONBEAST, sideLoc - (guiWidth - 176),
				verticalLoc - 73, 23, 16, 186, 96, null, (press) -> {
					mc.displayGuiScreen(CovenPageLib.BeastPageList.get(0));
				}));
		if (isElder) {
			this.addButton(eyeButton = new GuiButtonTextured(texture, BUTTONEYE, sideLoc - (guiWidth - 155),
					verticalLoc - 30, 16, 16, 209, 0, null, (press) -> {
						mc.displayGuiScreen(CovenPageLib.CombinationPageList.get(0));
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
