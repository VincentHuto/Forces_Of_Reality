package com.vincenthuto.forcesofreality.events;

import org.lwjgl.glfw.GLFW;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.container.ContainerMechanGlove;
import com.vincenthuto.forcesofreality.gui.GuiMechanGlove;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;
import com.vincenthuto.forcesofreality.init.ContainerInit;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderBeastFromBeyond;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderDarkYoung;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderHastur;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderMalformedAutomaton;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderSeraphim;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderTheFirstBeast;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderTulpa;
import com.vincenthuto.forcesofreality.render.entity.layer.ThermalLayerRender;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderLordOfTheWild;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderMechan;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderTetra;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderTrueXanthousKing;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderUzouthrhix;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderVeritas;
import com.vincenthuto.forcesofreality.render.entity.lords.RenderXanthousKing;
import com.vincenthuto.forcesofreality.render.entity.mobs.RenderDerangedBeast;
import com.vincenthuto.forcesofreality.render.entity.mobs.RenderDreadBot;
import com.vincenthuto.forcesofreality.render.entity.mobs.RenderHasturVassal;
import com.vincenthuto.forcesofreality.render.entity.mobs.RenderScuttlingOcculus;
import com.vincenthuto.forcesofreality.render.entity.passive.RenderAngelicFowl;
import com.vincenthuto.forcesofreality.render.entity.passive.RenderDenizen;
import com.vincenthuto.forcesofreality.render.entity.passive.RenderDenizenSage;
import com.vincenthuto.forcesofreality.render.entity.passive.RenderSlug;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderCorruptNote;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderDreadRocket;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderDreadRocketDirected;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderEldritchGrip;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderFirstBeastBolt;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderHolyFlare;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderHolySpirit;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderShortCircuit;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderShorting;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderStarStrike;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderTrackingOrb;
import com.vincenthuto.forcesofreality.render.entity.projectile.RenderWolfShot;
import com.vincenthuto.forcesofreality.render.entity.summons.RenderBlackGoat;
import com.vincenthuto.forcesofreality.render.entity.summons.RenderHasturSpawn;
import com.vincenthuto.forcesofreality.render.entity.summons.RenderJudgement;
import com.vincenthuto.forcesofreality.render.entity.summons.RenderSummonedBeast;
import com.vincenthuto.forcesofreality.render.entity.summons.RenderTentacle;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderAscendantAltar;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderHasturPylon;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderHunterEffigy;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderMachinaImperfecta;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderOccularHeap;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderRafflesiaOfFidelity;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderSacrificialPyre;
import com.vincenthuto.forcesofreality.render.tile.coven.RenderUntoldEasel;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

	public static NonNullList<KeyMapping> keyBinds = NonNullList.create();

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {

		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		//forgeBus.addListener(ThermalLayerRender::renderWorld);
	//	forgeBus.addListener(ThermalLayerRender::renderEntities);
		BlockEntityRenderers.register(BlockEntityInit.hastur_pylon.get(), RenderHasturPylon::new);
		//BlockEntityRenderers.register(BlockEntityInit.self_reflection_station.get(), RenderAdornmentModStation::new);
		BlockEntityRenderers.register(BlockEntityInit.sacrifice_pyre.get(), RenderSacrificialPyre::new);
		BlockEntityRenderers.register(BlockEntityInit.ascendant_altar.get(), RenderAscendantAltar::new);
		BlockEntityRenderers.register(BlockEntityInit.machina_imperfecta.get(), RenderMachinaImperfecta::new);
		BlockEntityRenderers.register(BlockEntityInit.occular_heap.get(), RenderOccularHeap::new);
		BlockEntityRenderers.register(BlockEntityInit.untold_easel.get(), RenderUntoldEasel::new);
		BlockEntityRenderers.register(BlockEntityInit.rafflesia_of_fidelity.get(), RenderRafflesiaOfFidelity::new);
		BlockEntityRenderers.register(BlockEntityInit.hunter_effigy.get(), RenderHunterEffigy::new);

		// ScreenManager.registerFactory(ContainerInit.runic_chisel_station.get(),
		// GuiChiselStation::new);
	//	MenuScreens.register(ContainerInit.PLAYER_ADORNMENTS, PlayerExpandedScreen::new);
		// ScreenManager.registerFactory(ContainerAdornmentBinder.type,
		// GuiAdornmentBinder::new);
		MenuScreens.register(ContainerInit.mechan_glove_container.get(), GuiMechanGlove::new);
		

		keyBinds.add(0, new KeyMapping("key.forcesofreality.mechanglovemode.desc", GLFW.GLFW_KEY_V,
				"key.forcesofreality.category"));
		keyBinds.add(1, new KeyMapping("key.forcesofreality.sparkdirector.desc", GLFW.GLFW_KEY_M,
				"key.forcesofreality.category"));
		ClientRegistry.registerKeyBinding(keyBinds.get(0));
		ClientRegistry.registerKeyBinding(keyBinds.get(1));

	}

}
