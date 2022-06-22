package com.vincenthuto.forcesofreality.events;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.model.block.ModelHasturPylon;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelBeastFromBeyond;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelDarkYoung;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelHastur;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelMalformedAutomaton;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelSeraphim;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelTheFirstBeast;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelLordOfTheWild;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelMechan;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelTetra;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelTrueXanthousKing;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelUzouthrhix;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelVeritas;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelXanthousKing;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelDerangedBeast;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelDreadBot;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelHasturSpawn;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelScuttlingOcculus;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelTentacle;
import com.vincenthuto.forcesofreality.model.entity.mob.ModelVassalOfHastur;
import com.vincenthuto.forcesofreality.model.entity.passive.ModelAngelicFowl;
import com.vincenthuto.forcesofreality.model.entity.passive.ModelDenizen;
import com.vincenthuto.forcesofreality.model.entity.passive.ModelDenizenSage;
import com.vincenthuto.forcesofreality.model.entity.passive.ModelIbis;
import com.vincenthuto.forcesofreality.model.entity.passive.ModelSlug;
import com.vincenthuto.forcesofreality.model.entity.summon.ModelBlackGoat;
import com.vincenthuto.forcesofreality.model.entity.summon.ModelDreadRocketTracking;
import com.vincenthuto.forcesofreality.model.entity.summon.ModelEldritchGrip;
import com.vincenthuto.forcesofreality.model.entity.summon.ModelSummonedBeast;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderBeastFromBeyond;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderDarkYoung;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderHastur;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderMalformedAutomaton;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderSeraphim;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderTheFirstBeast;
import com.vincenthuto.forcesofreality.render.entity.guardians.RenderTulpa;
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

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class EntityEventSubscriber {
	
	@SubscribeEvent
	public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelHasturPylon.LAYER_LOCATION, ModelHasturPylon::createBodyLayer);

		event.registerLayerDefinition(ModelSummonedBeast.LAYER_LOCATION, ModelSummonedBeast::createBodyLayer);
		event.registerLayerDefinition(ModelEldritchGrip.LAYER_LOCATION, ModelEldritchGrip::createBodyLayer);
		event.registerLayerDefinition(ModelDreadRocketTracking.LAYER_LOCATION, ModelDreadRocketTracking::createBodyLayer);
		event.registerLayerDefinition(ModelBlackGoat.LAYER_LOCATION, ModelBlackGoat::createBodyLayer);
	
		event.registerLayerDefinition(ModelSlug.LAYER_LOCATION, ModelSlug::createBodyLayer);
		event.registerLayerDefinition(ModelIbis.LAYER_LOCATION, ModelIbis::createBodyLayer);
		event.registerLayerDefinition(ModelDenizenSage.LAYER_LOCATION, ModelDenizenSage::createBodyLayer);
		event.registerLayerDefinition(ModelDenizen.LAYER_LOCATION, ModelDenizen::createBodyLayer);
		event.registerLayerDefinition(ModelAngelicFowl.LAYER_LOCATION, ModelAngelicFowl::createBodyLayer);

		event.registerLayerDefinition(ModelVassalOfHastur.LAYER_LOCATION, ModelVassalOfHastur::createBodyLayer);
		event.registerLayerDefinition(ModelTentacle.LAYER_LOCATION, ModelTentacle::createBodyLayer);
		event.registerLayerDefinition(ModelScuttlingOcculus.LAYER_LOCATION, ModelScuttlingOcculus::createBodyLayer);
		event.registerLayerDefinition(ModelHasturSpawn.LAYER_LOCATION, ModelHasturSpawn::createBodyLayer);
		event.registerLayerDefinition(ModelDreadBot.LAYER_LOCATION, ModelDreadBot::createBodyLayer);
		event.registerLayerDefinition(ModelDerangedBeast.LAYER_LOCATION, ModelDerangedBeast::createBodyLayer);

		event.registerLayerDefinition(ModelXanthousKing.LAYER_LOCATION, ModelXanthousKing::createBodyLayer);
		event.registerLayerDefinition(ModelVeritas.LAYER_LOCATION, ModelVeritas::createBodyLayer);
		event.registerLayerDefinition(ModelUzouthrhix.LAYER_LOCATION, ModelUzouthrhix::createBodyLayer);
		event.registerLayerDefinition(ModelTrueXanthousKing.LAYER_LOCATION, ModelTrueXanthousKing::createBodyLayer);
		event.registerLayerDefinition(ModelTetra.LAYER_LOCATION, ModelTetra::createBodyLayer);
		event.registerLayerDefinition(ModelLordOfTheWild.LAYER_LOCATION, ModelLordOfTheWild::createBodyLayer);

		
		event.registerLayerDefinition(ModelTheFirstBeast.LAYER_LOCATION, ModelTheFirstBeast::createBodyLayer);
		event.registerLayerDefinition(ModelSeraphim.LAYER_LOCATION, ModelSeraphim::createBodyLayer);
		event.registerLayerDefinition(ModelMalformedAutomaton.LAYER_LOCATION, ModelMalformedAutomaton::createBodyLayer);
		event.registerLayerDefinition(ModelMechan.LAYER_LOCATION, ModelMechan::createBodyLayer);

		event.registerLayerDefinition(ModelHastur.LAYER_LOCATION, ModelHastur::createBodyLayer);
		event.registerLayerDefinition(ModelDarkYoung.LAYER_LOCATION, ModelDarkYoung::createBodyLayer);
		event.registerLayerDefinition(ModelBeastFromBeyond.LAYER_LOCATION, ModelBeastFromBeyond::createBodyLayer);

	}
	
	@SubscribeEvent
	public static void renderEntities(EntityRenderersEvent.RegisterRenderers event) {
		EntityRenderers.register(EntityInit.mechan.get(), RenderMechan::new);

		EntityRenderers.register(EntityInit.hastur.get(), RenderHastur::new);
		EntityRenderers.register(EntityInit.denizen.get(), RenderDenizen::new);
		EntityRenderers.register(EntityInit.denizen_sage.get(), RenderDenizenSage::new);
		EntityRenderers.register(EntityInit.angelic_fowl.get(), RenderAngelicFowl::new);
		EntityRenderers.register(EntityInit.tentacle.get(), RenderTentacle::new);
		// EntityRenderers.register(EntityInit.player_tentacle.get(),
		// RenderPlayerTentacle::new);
		EntityRenderers.register(EntityInit.tracking_orb.get(), RenderTrackingOrb::new);
		EntityRenderers.register(EntityInit.star_strike.get(), RenderStarStrike::new);
		EntityRenderers.register(EntityInit.corrupt_note.get(), RenderCorruptNote::new);
		EntityRenderers.register(EntityInit.wolf_shot.get(), RenderWolfShot::new);
		EntityRenderers.register(EntityInit.dread_rocket.get(), RenderDreadRocket::new);
		EntityRenderers.register(EntityInit.dread_rocket_directed.get(), RenderDreadRocketDirected::new);
		EntityRenderers.register(EntityInit.first_beast_bolt.get(), RenderFirstBeastBolt::new);
		EntityRenderers.register(EntityInit.holy_spirit.get(), RenderHolySpirit::new);
		EntityRenderers.register(EntityInit.hastur_spawn.get(), RenderHasturSpawn::new);
		EntityRenderers.register(EntityInit.slug.get(), RenderSlug::new);
		EntityRenderers.register(EntityInit.scuttling_occulus.get(), RenderScuttlingOcculus::new);
		EntityRenderers.register(EntityInit.seraphim.get(), RenderSeraphim::new);
//		EntityRenderers.register(EntityInit.throne.get(), RenderThrone::new);
		EntityRenderers.register(EntityInit.judgement.get(), RenderJudgement::new);
		EntityRenderers.register(EntityInit.holy_flare.get(), RenderHolyFlare::new);
		EntityRenderers.register(EntityInit.eldritch_grip.get(), RenderEldritchGrip::new);
		// EntityRenderers.register(EntityInit.hastur_clone.get(),
		// RenderHasturClone::new);
		EntityRenderers.register(EntityInit.tulpa.get(), RenderTulpa::new);
		EntityRenderers.register(EntityInit.dread_bot.get(), RenderDreadBot::new);
		EntityRenderers.register(EntityInit.short_circuit.get(), RenderShortCircuit::new);
		EntityRenderers.register(EntityInit.shorting.get(), RenderShorting::new);
		EntityRenderers.register(EntityInit.veritas.get(), RenderVeritas::new);
		EntityRenderers.register(EntityInit.black_goat.get(), RenderBlackGoat::new);
		EntityRenderers.register(EntityInit.hastur_vassal.get(), RenderHasturVassal::new);
		EntityRenderers.register(EntityInit.deranged_beast.get(), RenderDerangedBeast::new);
		EntityRenderers.register(EntityInit.tetra.get(), RenderTetra::new);
		EntityRenderers.register(EntityInit.xanthous_king.get(), RenderXanthousKing::new);
		// EntityRenderers.register(EntityInit.devotee.get(), RenderDevotee::new);
		EntityRenderers.register(EntityInit.the_first_beast.get(), RenderTheFirstBeast::new);

		EntityRenderers.register(EntityInit.true_xanthous_king.get(), RenderTrueXanthousKing::new);

		EntityRenderers.register(EntityInit.beast_from_beyond.get(), RenderBeastFromBeyond::new);
		EntityRenderers.register(EntityInit.malformed_automaton.get(), RenderMalformedAutomaton::new);
		EntityRenderers.register(EntityInit.dark_young.get(), RenderDarkYoung::new);
		EntityRenderers.register(EntityInit.summoned_beast.get(), RenderSummonedBeast::new);
		EntityRenderers.register(EntityInit.thrown_axe.get(), (ctx) -> {
	         return new ThrownItemRenderer<>(ctx, 1.0F, true);
	      });
		EntityRenderers.register(EntityInit.lord_of_the_wild.get(), RenderLordOfTheWild::new);
		EntityRenderers.register(EntityInit.uzouthrhix.get(), RenderUzouthrhix::new);

	}

	
}
