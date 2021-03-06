package com.huto.forcesofreality;

import com.huto.forcesofreality.entities.utils.Vector3;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.huto.forcesofreality.gui.GuiMechanGloveViewer;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.models.armor.ModelOldIronChestPlate;
import com.huto.forcesofreality.render.effects.FXLightning;
import com.huto.forcesofreality.render.effects.LightningHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy implements IProxy {
	private final ModelOldIronChestPlate oldIronChest = new ModelOldIronChestPlate(1.0f);

	@Override
	public void registerHandlers() {
		@SuppressWarnings("unused")
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(LightningHandler::onRenderWorldLast);

	}

	@Override
	public void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter,
			int colorInner) {
		Minecraft.getInstance().particles.addEffect(new FXLightning(Minecraft.getInstance().world, vectorStart,
				vectorEnd, ticksPerMeter, seed, colorOuter, colorInner));
	}

	@Override
	public void openMechanGui() {
		Minecraft.getInstance().displayGuiScreen(new GuiMechanGloveViewer(new ItemStack(ItemInit.mechan_glove.get()),
				ClientEventSubscriber.getClientPlayer()));
	}

	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getArmorModel(EquipmentSlotType armorSlot) {
		return (A) (armorSlot == EquipmentSlotType.LEGS ? oldIronChest : oldIronChest);
	}

}
