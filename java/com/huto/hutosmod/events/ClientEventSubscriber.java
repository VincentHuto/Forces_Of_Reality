package com.huto.hutosmod.events;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.gui.GuiVirtuousEnchanter;
import com.huto.hutosmod.gui.mindrunes.PlayerExpandedScreen;
import com.huto.hutosmod.init.ContainerInit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.items.ItemFrequencyMatcher;
import com.huto.hutosmod.render.effects.RenderMiningLaser2;
import com.huto.hutosmod.render.entity.RenderExampleMob;
import com.huto.hutosmod.render.tile.RenderAbsorber;
import com.huto.hutosmod.render.tile.RenderCapacitor;
import com.huto.hutosmod.render.tile.RenderHasturPylon;
import com.huto.hutosmod.render.tile.RenderIcoSphere;
import com.huto.hutosmod.render.tile.RenderKarmicAltar;
import com.huto.hutosmod.render.tile.RenderResonator;
import com.huto.hutosmod.render.tile.RenderStorageDrum;
import com.huto.hutosmod.render.tile.RenderVibeFuser;
import com.huto.hutosmod.render.tile.RenderVirtuousEnchanter;
import com.huto.hutosmod.render.tile.RenderWandMaker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {
	public static final KeyBinding KEY_RUNES = new KeyBinding("keybind.runesinventory", GLFW.GLFW_KEY_B,
			"key.categories.inventory");

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.wand_maker.get(), RenderWandMaker::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibe_resonator.get(), RenderResonator::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.karmic_altar.get(), RenderKarmicAltar::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.virtuous_enchanter.get(), RenderVirtuousEnchanter::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_storage_drum.get(), RenderStorageDrum::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_capacitor.get(), RenderCapacitor::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_fuser.get(), RenderVibeFuser::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibe_absorber.get(), RenderAbsorber::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.hastur_pylon.get(), RenderHasturPylon::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.obj_icosahedron.get(), RenderIcoSphere::new);

		ScreenManager.registerFactory(ContainerInit.virtuous_enchanter.get(), GuiVirtuousEnchanter::new);
		ScreenManager.registerFactory(HutosMod.Registration.PLAYER_RUNES, PlayerExpandedScreen::new);
		ClientRegistry.registerKeyBinding(KEY_RUNES);

		RenderingRegistry.registerEntityRenderingHandler(EntityInit.EXAMPLE_ENTITY.get(), RenderExampleMob::new);

	}


	public static PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

}
