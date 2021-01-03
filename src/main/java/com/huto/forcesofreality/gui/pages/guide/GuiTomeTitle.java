package com.huto.forcesofreality.gui.pages.guide;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.guardians.EntityColin;
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
public class GuiTomeTitle extends Screen {

	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/newbook.png");
	Minecraft mc = Minecraft.getInstance();

	int guiWidth = 186;
	int guiHeight = 240;
	int left, top;
	final int BUTTONCLOSE = 0;
	final int BUTTONWHITE = 1;
	final int BUTTONYELLOW = 2;
	final int BUTTONBLUE = 3;
	final int BUTTONGREEN = 4;
//	final int BUTTONRED = 5;
	final int BUTTONORANGE = 6;
	final int BUTTONCYAN = 7;
	final int BUTTONDARKBLUE = 9;
	final int BUTTONEYE = 8;
	static String title = " Table of Contents";
	static StringTextComponent titleComponent = new StringTextComponent(title);
	String subtitle = " Duality of Nature";
	ItemStack icon = new ItemStack(ItemInit.somnolent_crystal.get());
	GuiButtonTextured buttonclose, whiteButton, yellowButton, blueButton, greenButton, orangeButton,
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
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(BlockInit.somnolent_sapling.get()), 0, -4);
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(BlockInit.somnolent_earth.get()), 0, 8);

			GlStateManager.pushMatrix();
			GlStateManager.translatef(3, -5, 0);
			GlStateManager.scalef(0.5f, 0.5f, 0.5f);
			mc.getItemRenderer().renderItemIntoGUI(new ItemStack(Items.FIRE_CHARGE), 0, -9);
			GlStateManager.popMatrix();

			GlStateManager.scalef(15, 15, 15);
			GlStateManager.translatef(0.5f, 1.2f, 0f);
			GlStateManager.rotatef(180, 100, 0, 360);
			// This lightmap turns the brightness back up so the gui doesnt get dark at
			// night

			// OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f,
			// 240f);
			// mc.getRenderManager().renderEntityStatic(entityIn, xIn, yIn, zIn,
			// rotationYawIn, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//			mc.getRenderManager().renderEntityStatic(CowEntity, 1, 0, 0, 0, partialTicks, matrixStack,null, 2);

			IRenderTypeBuffer.Impl bufferIn = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());

			mc.getRenderManager().renderEntityStatic(
					new EntityColin(EntityInit.colin.get(), ClientEventSubscriber.getClientPlayer().getEntityWorld()),
					1, 0, 0, 33, 0, matrixStack, bufferIn, 0);

			bufferIn.finish();

			GlStateManager.rotatef(-25, 0, 10, 40);
			GlStateManager.translatef(0f, 1.5f, 3f);
			GlStateManager.scalef(0.5f, 0.5f, 0.5f);
			// mc.getRenderManager().renderEntity(new EntityElemental(mc.world), 1, 0, 0,
			// 40, 0, true);

		}
		GlStateManager.popMatrix();

		if (buttonclose.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Close"), mouseX, mouseY);
		}
		if (whiteButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Intro"), mouseX, mouseY);
		}
		if (yellowButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("World Gen"), mouseX, mouseY);
		}
		if (blueButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Armor"), mouseX, mouseY);
		}
		if (greenButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Wands"), mouseX, mouseY);
		}
	/*	if (redButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Adornments"), mouseX, mouseY);
		}*/
		if (orangeButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Machines"), mouseX, mouseY);
		}
		if (darkBlueButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Generation"), mouseX, mouseY);
		}
		if (cyanButton.isHovered()) {
			renderTooltip(matrixStack, new StringTextComponent("Karma"), mouseX, mouseY);
		}
		if (isElder) {
			if (eyeButton.isHovered()) {
				renderTooltip(matrixStack, new StringTextComponent("Elder"), mouseX, mouseY);
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
		this.addButton(whiteButton = new GuiButtonTextured(texture, BUTTONWHITE, sideLoc - (guiWidth - 174),
				verticalLoc - 226, 23, 16, 186, 0, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.IntroPageList.get(0));
				}));
		this.addButton(yellowButton = new GuiButtonTextured(texture, BUTTONYELLOW, sideLoc - (guiWidth - 175),
				verticalLoc - 181, 23, 16, 186, 32, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.WorldGenPageList.get(0));
				}));
		this.addButton(blueButton = new GuiButtonTextured(texture, BUTTONBLUE, sideLoc - (guiWidth - 175),
				verticalLoc - 153, 23, 16, 186, 64, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.ArmorPageList.get(0));
				}));
		this.addButton(greenButton = new GuiButtonTextured(texture, BUTTONGREEN, sideLoc - (guiWidth - 177),
				verticalLoc - 121, 24, 16, 186, 96, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.WandsPageList.get(0));
				}));
		/*this.addButton(redButton = new GuiButtonTextured(texture, BUTTONRED, sideLoc - (guiWidth - 180),
				verticalLoc - 91, 24, 16, 186, 128, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.AdornmentsPageList.get(0));
				}));*/
		this.addButton(orangeButton = new GuiButtonTextured(texture, BUTTONORANGE, sideLoc - (guiWidth - 177),
				verticalLoc - 49, 24, 16, 186, 160, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.BlocksPageList.get(0));
				}));
		this.addButton(darkBlueButton = new GuiButtonTextured(texture, BUTTONDARKBLUE, sideLoc - (guiWidth - 177),
				verticalLoc - 69, 24, 16, 209, 160, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.GeneratePageList.get(0));
				}));
		this.addButton(cyanButton = new GuiButtonTextured(texture, BUTTONCYAN, sideLoc - (guiWidth - 177),
				verticalLoc - 200, 24, 16, 186, 192, null, (press) -> {
					mc.displayGuiScreen(TomePageLib.KarmaPageList.get(0));
				}));
		if (isElder) {
			this.addButton(eyeButton = new GuiButtonTextured(texture, BUTTONEYE, sideLoc - (guiWidth - 155),
					verticalLoc - 30, 16, 16, 209, 0, null, (press) -> {
						mc.displayGuiScreen(TomePageLib.ElderPageList.get(0));
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
