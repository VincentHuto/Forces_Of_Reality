package com.vincenthuto.forcesofreality.gui.guide;

import com.vincenthuto.hutoslib.client.screen.guide.GuiGuidePage;
import com.vincenthuto.hutoslib.client.screen.guide.TomeLib;

import net.minecraft.world.item.ItemStack;

public class ForcesGuidePage extends GuiGuidePage {

	public ForcesGuidePage(int pageNumIn, String catagoryIn) {
		super(pageNumIn, catagoryIn);
	}

	public ForcesGuidePage(int pageNumIn, String catagoryIn, String textIn) {
		super(pageNumIn, catagoryIn, "", "", ItemStack.EMPTY, textIn);
	}

	public ForcesGuidePage(int pageNumIn, String catagoryIn, String titleIn, String subtitleIn, String textIn) {
		super(pageNumIn, catagoryIn, titleIn, subtitleIn, ItemStack.EMPTY, textIn);
	}

	public ForcesGuidePage(int pageNumIn, String catagoryIn, String titleIn, String subtitleIn, String textIn,
			ItemStack icon) {
		super(pageNumIn, catagoryIn, titleIn, subtitleIn, icon, textIn);

	}


	@Override
	public TomeLib getOwnerTome() {
		return new ForcesLib();
	}

}
