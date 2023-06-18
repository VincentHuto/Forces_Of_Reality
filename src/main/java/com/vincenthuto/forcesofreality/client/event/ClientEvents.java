package com.vincenthuto.forcesofreality.client.event;

import org.lwjgl.glfw.GLFW;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.render.entity.layer.ThermalLayerRender;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderAscendantAltar;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderHasturPylon;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderHunterEffigy;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderMachinaImperfecta;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderOccularHeap;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderRafflesiaOfFidelity;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderSacrificialPyre;
import com.vincenthuto.forcesofreality.client.render.tile.coven.RenderUntoldEasel;
import com.vincenthuto.forcesofreality.client.screen.GuiMechanGlove;
import com.vincenthuto.forcesofreality.client.screen.guide.ForcesLib;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;
import com.vincenthuto.forcesofreality.registry.ContainerInit;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

	public static NonNullList<KeyMapping> keyBinds = NonNullList.create();
	public static KeyMapping mechanglovemode;
	public static KeyMapping sparkdirector;

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {

		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(ThermalLayerRender::renderWorld);
		forgeBus.addListener(ThermalLayerRender::renderEntities);
		BlockEntityRenderers.register(BlockEntityInit.hastur_pylon.get(), RenderHasturPylon::new);
		// BlockEntityRenderers.register(BlockEntityInit.self_reflection_station.get(),
		// RenderAdornmentModStation::new);
		BlockEntityRenderers.register(BlockEntityInit.sacrifice_pyre.get(), RenderSacrificialPyre::new);
		BlockEntityRenderers.register(BlockEntityInit.ascendant_altar.get(), RenderAscendantAltar::new);
		BlockEntityRenderers.register(BlockEntityInit.machina_imperfecta.get(), RenderMachinaImperfecta::new);
		BlockEntityRenderers.register(BlockEntityInit.occular_heap.get(), RenderOccularHeap::new);
		BlockEntityRenderers.register(BlockEntityInit.untold_easel.get(), RenderUntoldEasel::new);
		BlockEntityRenderers.register(BlockEntityInit.rafflesia_of_fidelity.get(), RenderRafflesiaOfFidelity::new);
		BlockEntityRenderers.register(BlockEntityInit.hunter_effigy.get(), RenderHunterEffigy::new);

		// ScreenManager.registerFactory(ContainerInit.runic_chisel_station.get(),
		// GuiChiselStation::new);
		// MenuScreens.register(ContainerInit.PLAYER_ADORNMENTS,
		// PlayerExpandedScreen::new);
		// ScreenManager.registerFactory(ContainerAdornmentBinder.type,
		// GuiAdornmentBinder::new);
		MenuScreens.register(ContainerInit.mechan_glove_container.get(), GuiMechanGlove::new);
	}

	@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public void clientSetup(final FMLClientSetupEvent event) {
//			MinecraftForge.EVENT_BUS.register(RenderLaserEvent.class);
			// this.addLayers();
			ForcesLib forces = new ForcesLib();
			forces.registerTome();
		}

		@SubscribeEvent
		public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
			event.register(ClientEvents.mechanglovemode = new KeyMapping("key.forcesofreality.mechanglovemode.desc",
					GLFW.GLFW_KEY_N, "key.forcesofreality.category"));
			event.register(ClientEvents.sparkdirector = new KeyMapping("key.forcesofreality.sparkdirector.desc",
					GLFW.GLFW_KEY_M, "key.forcesofreality.category"));

		}
	}

}
