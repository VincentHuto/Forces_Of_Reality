package com.huto.hutosmod;

import com.huto.hutosmod.entities.utils.Vector3;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.gui.GuiMechanGloveViewer;
import com.huto.hutosmod.gui.GuiRuneBinderViewer;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.models.entity.ModelOldIronChestPlate;
import com.huto.hutosmod.render.effects.FXLightning;
import com.huto.hutosmod.render.effects.LightningHandler;

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
	public void openBinderGui() {
		Minecraft.getInstance().displayGuiScreen(new GuiRuneBinderViewer(new ItemStack(ItemInit.rune_binder.get()),
				ClientEventSubscriber.getClientPlayer()));
	}
	@Override
	public void openMechanGui() {
		Minecraft.getInstance().displayGuiScreen(new GuiMechanGloveViewer(new ItemStack(ItemInit.mechan_glove.get()),
				ClientEventSubscriber.getClientPlayer()));
	}

	@SuppressWarnings("unchecked")
	public <A extends BipedModel<?>> A getRubyArmorModel(EquipmentSlotType armorSlot) {
		return (A) (armorSlot == EquipmentSlotType.LEGS ? oldIronChest : oldIronChest);
	}

}
