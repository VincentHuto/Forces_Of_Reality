package com.huto.forcesofreality.events;

import org.lwjgl.glfw.GLFW;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.gui.GuiMechanGlove;
import com.huto.forcesofreality.gui.GuiVirtuousEnchanter;
import com.huto.forcesofreality.gui.adornments.PlayerExpandedScreen;
import com.huto.forcesofreality.init.ContainerInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.models.animation.IAnimatable;
import com.huto.forcesofreality.render.entity.guardians.RenderBeastFromBeyond;
import com.huto.forcesofreality.render.entity.guardians.RenderColin;
import com.huto.forcesofreality.render.entity.guardians.RenderDarkYoung;
import com.huto.forcesofreality.render.entity.guardians.RenderHastur;
import com.huto.forcesofreality.render.entity.guardians.RenderMalformedAutomaton;
import com.huto.forcesofreality.render.entity.guardians.RenderSeraphim;
import com.huto.forcesofreality.render.entity.guardians.RenderTulpa;
import com.huto.forcesofreality.render.entity.item.RenderManaDustItem;
import com.huto.forcesofreality.render.entity.layer.ThermalLayerRender;
import com.huto.forcesofreality.render.entity.lords.RenderLordOfTheWild;
import com.huto.forcesofreality.render.entity.lords.RenderMechan;
import com.huto.forcesofreality.render.entity.lords.RenderTetra;
import com.huto.forcesofreality.render.entity.lords.RenderTrueXanthousKing;
import com.huto.forcesofreality.render.entity.lords.RenderUzouthrhix;
import com.huto.forcesofreality.render.entity.lords.RenderVeritas;
import com.huto.forcesofreality.render.entity.lords.RenderXanthousKing;
import com.huto.forcesofreality.render.entity.mobs.RenderDerangedBeast;
import com.huto.forcesofreality.render.entity.mobs.RenderDreadBot;
import com.huto.forcesofreality.render.entity.mobs.RenderHasturVassal;
import com.huto.forcesofreality.render.entity.mobs.RenderScuttlingOcculus;
import com.huto.forcesofreality.render.entity.passive.RenderAngelicFowl;
import com.huto.forcesofreality.render.entity.passive.RenderDenizen;
import com.huto.forcesofreality.render.entity.passive.RenderDenizenSage;
import com.huto.forcesofreality.render.entity.passive.RenderDreamWalker;
import com.huto.forcesofreality.render.entity.passive.RenderIbis;
import com.huto.forcesofreality.render.entity.passive.RenderSlug;
import com.huto.forcesofreality.render.entity.projectile.RenderCorruptNote;
import com.huto.forcesofreality.render.entity.projectile.RenderDreadRocket;
import com.huto.forcesofreality.render.entity.projectile.RenderDreadRocketDirected;
import com.huto.forcesofreality.render.entity.projectile.RenderEldritchGrip;
import com.huto.forcesofreality.render.entity.projectile.RenderHolyFlare;
import com.huto.forcesofreality.render.entity.projectile.RenderHolySpirit;
import com.huto.forcesofreality.render.entity.projectile.RenderPlayerTentacle;
import com.huto.forcesofreality.render.entity.projectile.RenderShortCircuit;
import com.huto.forcesofreality.render.entity.projectile.RenderShorting;
import com.huto.forcesofreality.render.entity.projectile.RenderStarStrike;
import com.huto.forcesofreality.render.entity.projectile.RenderTrackingOrb;
import com.huto.forcesofreality.render.entity.projectile.RenderWolfShot;
import com.huto.forcesofreality.render.entity.summons.RenderBlackGoat;
import com.huto.forcesofreality.render.entity.summons.RenderHasturClone;
import com.huto.forcesofreality.render.entity.summons.RenderHasturSpawn;
import com.huto.forcesofreality.render.entity.summons.RenderJudgement;
import com.huto.forcesofreality.render.entity.summons.RenderSummonedBeast;
import com.huto.forcesofreality.render.entity.summons.RenderTentacle;
import com.huto.forcesofreality.render.entity.summons.RenderThrone;
import com.huto.forcesofreality.render.tiles.RenderAdornmentModStation;
import com.huto.forcesofreality.render.tiles.RenderMagicLight;
import com.huto.forcesofreality.render.tiles.RenderMagicRingLight;
import com.huto.forcesofreality.render.tiles.RenderVirtuousEnchanter;
import com.huto.forcesofreality.render.tiles.coven.RenderAscendantAltar;
import com.huto.forcesofreality.render.tiles.coven.RenderHasturPylon;
import com.huto.forcesofreality.render.tiles.coven.RenderIcoSphere;
import com.huto.forcesofreality.render.tiles.coven.RenderMachinaImperfecta;
import com.huto.forcesofreality.render.tiles.coven.RenderOccularHeap;
import com.huto.forcesofreality.render.tiles.coven.RenderRafflesiaOfFidelity;
import com.huto.forcesofreality.render.tiles.coven.RenderSacrificialPyre;
import com.huto.forcesofreality.render.tiles.coven.RenderUntoldEasel;
import com.huto.forcesofreality.render.tiles.teleporter.RenderTeleporter;
import com.huto.forcesofreality.render.tiles.vibes.RenderAbsorber;
import com.huto.forcesofreality.render.tiles.vibes.RenderAutoInscriber;
import com.huto.forcesofreality.render.tiles.vibes.RenderCapacitor;
import com.huto.forcesofreality.render.tiles.vibes.RenderCrystalHarmonizer;
import com.huto.forcesofreality.render.tiles.vibes.RenderKarmicAltar;
import com.huto.forcesofreality.render.tiles.vibes.RenderKarmicExtractor;
import com.huto.forcesofreality.render.tiles.vibes.RenderLectorTable;
import com.huto.forcesofreality.render.tiles.vibes.RenderResonator;
import com.huto.forcesofreality.render.tiles.vibes.RenderStorageDrum;
import com.huto.forcesofreality.render.tiles.vibes.RenderThermalInfluxer;
import com.huto.forcesofreality.render.tiles.vibes.RenderVibeFuser;
import com.huto.forcesofreality.render.tiles.vibes.RenderWandMaker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

	public static NonNullList<KeyBinding> keyBinds = NonNullList.create();

	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {

		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(ThermalLayerRender::renderWorld);
		forgeBus.addListener(ThermalLayerRender::renderEntities);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.wand_maker.get(), RenderWandMaker::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibe_resonator.get(), RenderResonator::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.karmic_altar.get(), RenderKarmicAltar::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.karmic_extractor.get(), RenderKarmicExtractor::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.virtuous_enchanter.get(), RenderVirtuousEnchanter::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_storage_drum.get(), RenderStorageDrum::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_capacitor.get(), RenderCapacitor::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibratory_fuser.get(), RenderVibeFuser::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.vibe_absorber.get(), RenderAbsorber::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.hastur_pylon.get(), RenderHasturPylon::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.obj_icosahedron.get(), RenderIcoSphere::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.thermal_influxer.get(), RenderThermalInfluxer::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.rune_mod_station.get(), RenderAdornmentModStation::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.sacrifice_pyre.get(), RenderSacrificialPyre::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.ascendant_altar.get(), RenderAscendantAltar::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.machina_imperfecta.get(), RenderMachinaImperfecta::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.occular_heap.get(), RenderOccularHeap::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.untold_easel.get(), RenderUntoldEasel::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.light_block.get(), RenderMagicLight::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.light_ring_block.get(), RenderMagicRingLight::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.auto_inscriber.get(), RenderAutoInscriber::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.teleporter.get(), RenderTeleporter::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.lector_table.get(), RenderLectorTable::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.crystal_harmonizer.get(), RenderCrystalHarmonizer::new);
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.rafflesia_of_fidelity.get(),
				RenderRafflesiaOfFidelity::new);

		ScreenManager.registerFactory(ContainerInit.virtuous_enchanter.get(), GuiVirtuousEnchanter::new);

		// ScreenManager.registerFactory(ContainerInit.runic_chisel_station.get(),
		// GuiChiselStation::new);
		ScreenManager.registerFactory(ContainerInit.PLAYER_ADORNMENTS, PlayerExpandedScreen::new);
		// ScreenManager.registerFactory(ContainerAdornmentBinder.type,
		// GuiAdornmentBinder::new);
		ScreenManager.registerFactory(ContainerMechanGlove.type, GuiMechanGlove::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.dream_walker.get(), RenderDreamWalker::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.colin.get(), RenderColin::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.hastur.get(), RenderHastur::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.denizen.get(), RenderDenizen::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.denizen_sage.get(), RenderDenizenSage::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.ibis.get(), RenderIbis::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.angelic_fowl.get(), RenderAngelicFowl::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.tentacle.get(), RenderTentacle::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.player_tentacle.get(), RenderPlayerTentacle::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.tracking_orb.get(), RenderTrackingOrb::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.star_strike.get(), RenderStarStrike::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.corrupt_note.get(), RenderCorruptNote::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.wolf_shot.get(), RenderWolfShot::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.dread_rocket.get(), RenderDreadRocket::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.dread_rocket_directed.get(),
				RenderDreadRocketDirected::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.holy_spirit.get(), RenderHolySpirit::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.hastur_spawn.get(), RenderHasturSpawn::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.slug.get(), RenderSlug::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.scuttling_occulus.get(),
				RenderScuttlingOcculus::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.seraphim.get(), RenderSeraphim::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.throne.get(), RenderThrone::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.judgement.get(), RenderJudgement::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.holy_flare.get(), RenderHolyFlare::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.eldritch_grip.get(), RenderEldritchGrip::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.hastur_clone.get(), RenderHasturClone::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.tulpa.get(), RenderTulpa::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.dread_bot.get(), RenderDreadBot::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.mechan.get(), RenderMechan::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.short_circuit.get(), RenderShortCircuit::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.shorting.get(), RenderShorting::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.veritas.get(), RenderVeritas::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.black_goat.get(), RenderBlackGoat::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.hastur_vassal.get(), RenderHasturVassal::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.deranged_beast.get(), RenderDerangedBeast::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.tetra.get(), RenderTetra::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.xanthous_king.get(), RenderXanthousKing::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.true_xanthous_king.get(),
				RenderTrueXanthousKing::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityInit.beast_from_beyond.get(),
				RenderBeastFromBeyond::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.malformed_automaton.get(),
				RenderMalformedAutomaton::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.dark_young.get(), RenderDarkYoung::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.summoned_beast.get(), RenderSummonedBeast::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.thrown_axe.get(),
				renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.mana_dust.get(), RenderManaDustItem::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.lord_of_the_wild.get(), RenderLordOfTheWild::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.uzouthrhix.get(), RenderUzouthrhix::new);

		keyBinds.add(0, new KeyBinding("key.forcesofreality.mechanglovemode.desc", GLFW.GLFW_KEY_V,
				"key.forcesofreality.category"));
		keyBinds.add(1, new KeyBinding("key.forcesofreality.sparkdirector.desc", GLFW.GLFW_KEY_M,
				"key.forcesofreality.category"));

		ClientRegistry.registerKeyBinding(keyBinds.get(0));
		ClientRegistry.registerKeyBinding(keyBinds.get(1));

	}

	// for class loading issues
	public static Minecraft getClient() {
		return Minecraft.getInstance();
	}

	public static PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	public static ClientWorld getWorld() {
		return getClient().world;
	}

	public static float getPartialTicks() {
		return getClient().getRenderPartialTicks();
	}



	public static boolean handleAnimationPacket(int entityID, int animationIndex) {
		World world = ClientEventSubscriber.getWorld();
		IAnimatable entity = (IAnimatable) world.getEntityByID(entityID);

		if (animationIndex < 0)
			entity.setAnimation(IAnimatable.NO_ANIMATION);
		else
			entity.setAnimation(entity.getAnimations()[animationIndex]);
		return true;
	}
}
