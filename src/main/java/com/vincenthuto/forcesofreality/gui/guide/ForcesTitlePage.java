package com.vincenthuto.forcesofreality.gui.guide;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.hutoslib.client.screen.guide.GuiGuideTitlePage;
import com.vincenthuto.hutoslib.client.screen.guide.TomeLib;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ForcesTitlePage extends GuiGuideTitlePage {

	public ForcesTitlePage() {
		super( Component.translatable("Forces of Reality"), new ItemStack(ItemInit.allegiance_identifier.get()), ForcesLib.chapters,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/forces_overlay.png"));
	}

	@Override
	public TomeLib getOwnerTome() {
		return new ForcesLib();
	}
}
