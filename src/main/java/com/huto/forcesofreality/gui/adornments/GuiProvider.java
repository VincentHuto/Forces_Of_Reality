package com.huto.forcesofreality.gui.adornments;

import javax.annotation.Nullable;

import com.huto.forcesofreality.container.PlayerExpandedContainer;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class GuiProvider implements MenuProvider {

	@Override
	public Component getDisplayName() {
		return new TextComponent("PlayerAdornmentInv");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player playerEntity) {
		return new PlayerExpandedContainer(id, playerInventory, !playerEntity.world.isRemote);
	}
}
