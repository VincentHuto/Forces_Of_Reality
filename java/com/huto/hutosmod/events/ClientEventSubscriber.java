package com.huto.hutosmod.events;

import org.lwjgl.glfw.GLFW;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.gui.GuiVirtuousEnchanter;
import com.huto.hutosmod.gui.mindrunes.PlayerExpandedScreen;
import com.huto.hutosmod.init.ContainerInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.render.tile.RenderCapacitor;
import com.huto.hutosmod.render.tile.RenderKarmicAltar;
import com.huto.hutosmod.render.tile.RenderResonator;
import com.huto.hutosmod.render.tile.RenderStorageDrum;
import com.huto.hutosmod.render.tile.RenderVibeFuser;
import com.huto.hutosmod.render.tile.RenderVirtuousEnchanter;
import com.huto.hutosmod.render.tile.RenderWandMaker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {
    public static final KeyBinding KEY_RUNES = new KeyBinding("keybind.runesinventory", GLFW.GLFW_KEY_B, "key.categories.inventory");

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.wand_maker.get(), RenderWandMaker::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibe_resonator.get(), RenderResonator::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.karmic_altar.get(), RenderKarmicAltar::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.virtuous_enchanter.get(), RenderVirtuousEnchanter::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_storage_drum.get(), RenderStorageDrum::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_capacitor.get(), RenderCapacitor::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_fuser.get(), RenderVibeFuser::new);

		ScreenManager.registerFactory(ContainerInit.virtuous_enchanter.get(), GuiVirtuousEnchanter::new);
        ScreenManager.registerFactory(HutosMod.Registration.PLAYER_RUNES, PlayerExpandedScreen::new);
        ClientRegistry.registerKeyBinding(KEY_RUNES);
	}

	public static PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

}
