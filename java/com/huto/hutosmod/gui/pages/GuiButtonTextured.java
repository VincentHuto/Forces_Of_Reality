package com.huto.hutosmod.gui.pages;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiButtonTextured extends Button {

	final ResourceLocation texture;
	int id, posX, posY, buttonWidth, buttonHeight, u, v, adjV, newV;
	boolean state;
	protected Button.ITooltip onTooltip;
	public static ITextComponent text;
	public  Button.IPressable action;
	public GuiButtonTextured(ResourceLocation texIn, int idIn, int posXIn, int posYIn, int buttonWidthIn,
			int buttonHeightIn, int uIn, int vIn, Button.ITooltip tooltip, Button.IPressable actionIn) {
		super(posXIn, posYIn, buttonHeightIn, buttonWidthIn, text, actionIn, tooltip);
		this.texture = texIn;
		this.id = idIn;
		this.posX = posXIn;
		this.posY = posYIn;
		this.width = buttonWidthIn;
		this.height = buttonHeightIn;
		this.u = uIn;
		this.v = vIn;
		this.adjV = vIn + buttonHeightIn;
		this.newV = vIn;
		this.onTooltip = tooltip;
		this.action = actionIn;

	}

	public GuiButtonTextured(ResourceLocation texIn, int idIn, int posXIn, int posYIn, int buttonWidthIn,
			int buttonHeightIn, int uIn, int vIn, Button.ITooltip tooltip, Button.IPressable action, boolean stateIn) {
		super(posXIn, posYIn, buttonHeightIn, buttonWidthIn, text, action, tooltip);

		this.texture = texIn;
		this.id = idIn;
		this.posX = posXIn;
		this.posY = posYIn;
		this.width = buttonWidthIn;
		this.height = buttonHeightIn;
		this.u = uIn;
		this.v = vIn;
		this.adjV = vIn + buttonHeightIn;
		this.newV = vIn;
		this.state = stateIn;

	}

	@Override
	public void renderButton(MatrixStack matrix, int mouseX, int mouseY, float particks) {
		if (visible) {
			GlStateManager.enableAlphaTest();
			GlStateManager.enableBlend();;

			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height || state) {
				this.isHovered = true;
				v = newV;
				GuiUtil.drawTexturedModalRect(posX, posY, u, adjV, width, height);
			} else {
				this.isHovered = false;
				newV = v;
				GuiUtil.drawTexturedModalRect(posX, posY, u, v, width, height);
			}
		}

	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY, float particks) {
		if (visible) {
			mc.getTextureManager().bindTexture(texture);
			if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height || state) {
				this.isHovered = true;
				v = newV;
				GuiUtil.drawTexturedModalRect(posX, posY, u, adjV, width, height);
			} else {
				this.isHovered = false;
				newV = v;
				GuiUtil.drawTexturedModalRect(posX, posY, u, v, width, height);
			}
		}

	}

	public Button.IPressable getAction() {
		return action;
	}

	public void setAction(Button.IPressable action) {
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
