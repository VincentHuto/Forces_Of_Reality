package com.huto.hutosmod.gui.pages;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiTomeImage extends Widget {

	public final ResourceLocation texture;
	public int id, zone, posX, posY, buttonWidth, buttonHeight, u, v;
	boolean state;
	protected Button.ITooltip onTooltip;
	public static ITextComponent text;

	/***
	 * Full Control
	 * 
	 * @param texIn          Texture Location
	 * @param idIn           widget Id
	 * @param zoneIn         Which image zone to go to 0-11 54x54 each 3 x 4
	 * @param posXIn         Screen X
	 * @param posYIn         Screen Y
	 * @param buttonWidthIn  Button Size Width
	 * @param buttonHeightIn Button Size Height
	 * @param uIn            Texture X Loc
	 * @param vIn            Texture Y Loc
	 */
	public GuiTomeImage(ResourceLocation texIn, int idIn, int zoneIn, int posXIn, int posYIn, int buttonWidthIn,
			int buttonHeightIn, int uIn, int vIn) {
		super(posXIn, posYIn, buttonHeightIn, buttonWidthIn, text);
		this.texture = texIn;
		this.id = idIn;
		this.zone = zoneIn;
		this.posX = posXIn;
		this.posY = posYIn;
		this.width = buttonWidthIn;
		this.height = buttonHeightIn;
		this.u = uIn;
		this.v = vIn;
	}

	/***
	 * default, image is to size in file, no more no less Let the Logic Work it out
	 * 54 x 54
	 */

	public GuiTomeImage(ResourceLocation texIn, int idIn, int zoneIn) {
		super(0, 0, 54, 54, text);
		this.texture = texIn;
		this.id = idIn;
		this.zone = zoneIn;
		switch (zone) {
		case 0:
			this.posX = 0;
			this.posY = 0;
		case 1:
			this.posX = 54;
			this.posY = 0;
		case 2:
			this.posX = 108;
			this.posY = 0;
		case 3:
			this.posX = 0;
			this.posY = 54;
		case 4:
			this.posX = 54;
			this.posY = 54;
		case 5:
			this.posX = 108;
			this.posY = 54;
		case 6:
			this.posX = 0;
			this.posY = 108;
		case 7:
			this.posX = 54;
			this.posY = 108;
		case 8:
			this.posX = 108;
			this.posY = 108;
		case 9:
			this.posX = 0;
			this.posY = 162;
		case 10:
			this.posX = 54;
			this.posY = 162;
		case 11:
			this.posX = 108;
			this.posY = 162;
		default:
			this.posX = 0;
			this.posY = 0;
		}
		this.width = 54;
		this.height = 54;
		this.u = 0;
		this.v = 0;
	}

	/***
	 * Proper Zone Spacing but allows for image size flexibility
	 */

	public GuiTomeImage(ResourceLocation texIn, int idIn, int zoneIn, int buttonWidthIn, int buttonHeightIn) {
		super(0, 0, buttonHeightIn, buttonWidthIn, text);
		this.texture = texIn;
		this.id = idIn;
		this.zone = zoneIn;
		switch (zone) {
		case 0:
			this.posX = 0;
			this.posY = 0;
		case 1:
			this.posX = 54;
			this.posY = 0;
		case 2:
			this.posX = 108;
			this.posY = 0;
		case 3:
			this.posX = 0;
			this.posY = 54;
		case 4:
			this.posX = 54;
			this.posY = 54;
		case 5:
			this.posX = 108;
			this.posY = 54;
		case 6:
			this.posX = 0;
			this.posY = 108;
		case 7:
			this.posX = 54;
			this.posY = 108;
		case 8:
			this.posX = 108;
			this.posY = 108;
		case 9:
			this.posX = 0;
			this.posY = 162;
		case 10:
			this.posX = 54;
			this.posY = 162;
		case 11:
			this.posX = 108;
			this.posY = 162;
		default:
			this.posX = 0;
			this.posY = 0;
		}

		this.width = buttonWidthIn;
		this.height = buttonHeightIn;
		this.u = 0;
		this.v = 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		GlStateManager.enableAlphaTest();
		GlStateManager.enableBlend();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		GuiUtil.drawTexturedModalRect(this.posX, this.posY, u, v, this.width, this.height);
		GlStateManager.disableAlphaTest();
		GlStateManager.disableBlend();

	}
}