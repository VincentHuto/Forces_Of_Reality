package com.huto.forcesofreality.gui.pages;

import net.minecraft.network.chat.Component;

public class GuiImageText {

	public Component text;
	public int x, y, maxWidth;

	public GuiImageText(Component textIn, int xIn, int yIn, int maxWidthIn) {
		this.text = textIn;
		this.x = xIn;
		this.y = yIn;
		this.maxWidth = maxWidthIn;
	}

}
