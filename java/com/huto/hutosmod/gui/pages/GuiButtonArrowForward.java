package com.huto.hutosmod.gui.pages;

import com.huto.hutosmod.HutosMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class GuiButtonArrowForward extends Button {

	final ResourceLocation texture = new ResourceLocation(HutosMod.MOD_ID, "textures/gui/book.png");

	int buttonWidth = 16;
	int buttonHeight = 14;
	int u = 175;
	int v = 1;
	public int id;

	public GuiButtonArrowForward(int idIn, int x, int y, Button.IPressable pressedAction) {
		super(x, y, 16, 14, new StringTextComponent(""), pressedAction);
		this.id = idIn;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void renderButton(MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
		if (visible) {
			GlStateManager.enableAlphaTest();
			GlStateManager.enableBlend();
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
				this.isHovered = true;
			} else {
				this.isHovered = false;
			}
			if (this.isHovered) {
				v = 18;
			} else {
				v = 1;
			}
			GuiUtil.drawTexturedModalRect(x, y, u, v, width, height);
		}
	}

	public int getId() {
		return id;
	}

	public void setid() {
	}
}