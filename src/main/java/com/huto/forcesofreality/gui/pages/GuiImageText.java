package com.huto.forcesofreality.gui.pages;

import net.minecraft.util.text.ITextComponent;

public class GuiImageText {

	public ITextComponent text;
	public int x, y, maxWidth;

	public GuiImageText(ITextComponent textIn, int xIn, int yIn, int maxWidthIn) {
		this.text = textIn;
		this.x = xIn;
		this.y = yIn;
		this.maxWidth = maxWidthIn;
	}

}
