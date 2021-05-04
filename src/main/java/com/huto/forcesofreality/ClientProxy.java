package com.huto.forcesofreality;

import com.huto.forcesofreality.gui.GuiMechanGloveViewer;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.models.armor.ModelOldIronChestPlate;
import com.hutoslib.util.ClientUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class ClientProxy implements IProxy {
	private final ModelOldIronChestPlate oldIronChest = new ModelOldIronChestPlate(1.0f);

	@Override
	public void openMechanGui() {
		Minecraft.getInstance().displayGuiScreen(
				new GuiMechanGloveViewer(new ItemStack(ItemInit.mechan_glove.get()), ClientUtils.getClientPlayer()));
	}

	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getArmorModel(EquipmentSlotType armorSlot) {
		return (A) (armorSlot == EquipmentSlotType.LEGS ? oldIronChest : oldIronChest);
	}

}
