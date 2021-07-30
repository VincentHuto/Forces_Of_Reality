package com.huto.forcesofreality.gui.pages.coven;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.gui.pages.GuiUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiButtonCovenArrow extends Button {

	final ResourceLocation texture = new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/coven_book.png");

	int buttonWidth = 16;
	int buttonHeight = 14;
	int u = 175;
	int v = 1;
	public int id;

	public GuiButtonCovenArrow(int idIn, int x, int y, int widthIn, int heightIn, int uIn, int vIn,
			Button.OnPress pressedAction) {
		super(x, y, widthIn, heightIn, new TextComponent(""), pressedAction);
		this.buttonWidth = widthIn;
		this.buttonHeight = heightIn;
		this.id = idIn;
		this.u = uIn;
		this.v = vIn;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(PoseStack matrix, int mouseX, int mouseY, float partialTicks) {
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

	// Stops the clicking noise when the page turn button is pressed
	@Override
	public void playDownSound(SoundHandler handler) {
		handler.play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0f, 1F));
	}

	public int getId() {
		return id;
	}

	public void setid() {
	}
}