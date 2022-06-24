package com.vincenthuto.forcesofreality;

import com.vincenthuto.forcesofreality.gui.GuiMechanGloveViewer;
import com.vincenthuto.forcesofreality.gui.guide.ForcesTitlePage;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.hutoslib.client.HLClientUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

public class ClientProxy implements IProxy {

	@Override
	public void openMechanGui() {
		Minecraft.getInstance().setScreen(
				new GuiMechanGloveViewer(new ItemStack(ItemInit.mechan_glove.get()), HLClientUtils.getClientPlayer()));
	}

	@Override
	public void openGuideGui() {
		Minecraft.getInstance().setScreen(new ForcesTitlePage());
	}
}
