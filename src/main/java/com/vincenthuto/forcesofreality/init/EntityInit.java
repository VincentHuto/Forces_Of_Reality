package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityBeastFromBeyond;
import com.vincenthuto.forcesofreality.entity.guardian.EntityDarkYoung;
import com.vincenthuto.forcesofreality.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.entity.guardian.EntityMalformedAutomaton;
import com.vincenthuto.forcesofreality.entity.guardian.EntitySeraphim;
import com.vincenthuto.forcesofreality.entity.guardian.EntityTheFirstBeast;
import com.vincenthuto.forcesofreality.entity.guardian.EntityTulpa;
import com.vincenthuto.forcesofreality.entity.lord.EntityLordOfTheWild;
import com.vincenthuto.forcesofreality.entity.lord.EntityMechan;
import com.vincenthuto.forcesofreality.entity.lord.EntityTetra;
import com.vincenthuto.forcesofreality.entity.lord.EntityTrueXanthousKing;
import com.vincenthuto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.vincenthuto.forcesofreality.entity.lord.EntityVeritas;
import com.vincenthuto.forcesofreality.entity.lord.EntityXanthousKing;
import com.vincenthuto.forcesofreality.entity.mob.EntityDerangedBeast;
import com.vincenthuto.forcesofreality.entity.mob.EntityDevotee;
import com.vincenthuto.forcesofreality.entity.mob.EntityDreadBot;
import com.vincenthuto.forcesofreality.entity.mob.EntityHasturVassal;
import com.vincenthuto.forcesofreality.entity.mob.EntityScuttlingOcculus;
import com.vincenthuto.forcesofreality.entity.passive.EntityAngelicFowl;
import com.vincenthuto.forcesofreality.entity.passive.EntityDenizen;
import com.vincenthuto.forcesofreality.entity.passive.EntityDenizenSage;
import com.vincenthuto.forcesofreality.entity.passive.EntitySlug;
import com.vincenthuto.forcesofreality.entity.projectile.EntityCorruptNote;
import com.vincenthuto.forcesofreality.entity.projectile.EntityDreadRocket;
import com.vincenthuto.forcesofreality.entity.projectile.EntityDreadRocketDirected;
import com.vincenthuto.forcesofreality.entity.projectile.EntityFirstBeastBolt;
import com.vincenthuto.forcesofreality.entity.projectile.EntityHolyFlare;
import com.vincenthuto.forcesofreality.entity.projectile.EntityHolySpirit;
import com.vincenthuto.forcesofreality.entity.projectile.EntityJudgement;
import com.vincenthuto.forcesofreality.entity.projectile.EntityShortCircuit;
import com.vincenthuto.forcesofreality.entity.projectile.EntityShorting;
import com.vincenthuto.forcesofreality.entity.projectile.EntityStarStrike;
import com.vincenthuto.forcesofreality.entity.projectile.EntityThrownAxe;
import com.vincenthuto.forcesofreality.entity.projectile.EntityTrackingOrb;
import com.vincenthuto.forcesofreality.entity.projectile.EntityWolfShot;
import com.vincenthuto.forcesofreality.entity.summon.EntityBlackGoat;
import com.vincenthuto.forcesofreality.entity.summon.EntityEldritchGrip;
import com.vincenthuto.forcesofreality.entity.summon.EntityHasturClone;
import com.vincenthuto.forcesofreality.entity.summon.EntityHasturSpawn;
import com.vincenthuto.forcesofreality.entity.summon.EntityPlayerTentacle;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.entity.summon.EntityTentacle;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
			ForcesOfReality.MOD_ID);

	// Passive

	public static final RegistryObject<EntityType<EntityAngelicFowl>> angelic_fowl = ENTITY_TYPES.register(
			"angelic_fowl",
			() -> EntityType.Builder.<EntityAngelicFowl>of(EntityAngelicFowl::new, MobCategory.CREATURE)
					.sized(0.4F, 0.7F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "angelic_fowl").toString()));

	public static final RegistryObject<EntityType<EntitySlug>> slug = ENTITY_TYPES.register("slug",
			() -> EntityType.Builder.<EntitySlug>of(EntitySlug::new, MobCategory.CREATURE).sized(0.4F, 0.1F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "slug").toString()));

	// Denizens
	public static final RegistryObject<EntityType<EntityDenizen>> denizen = ENTITY_TYPES.register("denizen",
			() -> EntityType.Builder.<EntityDenizen>of(EntityDenizen::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "denizen").toString()));

	public static final RegistryObject<EntityType<EntityDenizenSage>> denizen_sage = ENTITY_TYPES.register(
			"denizen_sage",
			() -> EntityType.Builder.<EntityDenizenSage>of(EntityDenizenSage::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "denizen_sage").toString()));

	// Self
	public static final RegistryObject<EntityType<EntityTulpa>> tulpa = ENTITY_TYPES.register("tulpa",
			() -> EntityType.Builder.<EntityTulpa>of(EntityTulpa::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "tulpa").toString()));
	public static final RegistryObject<EntityType<EntityVeritas>> veritas = ENTITY_TYPES.register("veritas",
			() -> EntityType.Builder.<EntityVeritas>of(EntityVeritas::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "veritas").toString()));

	// Hastur
	public static final RegistryObject<EntityType<EntityHastur>> hastur = ENTITY_TYPES.register("hastur",
			() -> EntityType.Builder.<EntityHastur>of(EntityHastur::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "hastur").toString()));

	public static final RegistryObject<EntityType<EntityDevotee>> devotee = ENTITY_TYPES.register("devotee",
			() -> EntityType.Builder.<EntityDevotee>of(EntityDevotee::new, MobCategory.MONSTER)
					.sized(0.9f, 1.3f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "devotee").toString()));

	public static final RegistryObject<EntityType<EntityXanthousKing>> xanthous_king = ENTITY_TYPES.register(
			"xanthous_king",
			() -> EntityType.Builder.<EntityXanthousKing>of(EntityXanthousKing::new, MobCategory.MONSTER)
					.sized(4f, 6f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "xanthous_king").toString()));

	public static final RegistryObject<EntityType<EntityTrueXanthousKing>> true_xanthous_king = ENTITY_TYPES.register(
			"true_xanthous_king",
			() -> EntityType.Builder
					.<EntityTrueXanthousKing>of(EntityTrueXanthousKing::new, MobCategory.MONSTER)
					.sized(1.2f, 2.3f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "true_xanthous_king").toString()));

	public static final RegistryObject<EntityType<EntityTentacle>> tentacle = ENTITY_TYPES.register("tentacle",
			() -> EntityType.Builder.<EntityTentacle>of(EntityTentacle::new, MobCategory.MONSTER)
					.sized(0.4F, 0.7F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "tentacle").toString()));

	public static final RegistryObject<EntityType<EntityHasturVassal>> hastur_vassal = ENTITY_TYPES.register(
			"hastur_vassal",
			() -> EntityType.Builder
					.<EntityHasturVassal>of(EntityHasturVassal::new, MobCategory.WATER_CREATURE)
					.sized(0.8F, 0.8F).clientTrackingRange(8)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "hastur_vassal").toString()));;

	public static final RegistryObject<EntityType<EntityHasturSpawn>> hastur_spawn = ENTITY_TYPES.register(
			"hastur_spawn",
			() -> EntityType.Builder.<EntityHasturSpawn>of(EntityHasturSpawn::new, MobCategory.MONSTER)
					.sized(0.4F, 1F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "hastur_spawn").toString()));

	public static final RegistryObject<EntityType<EntityHasturClone>> hastur_clone = ENTITY_TYPES.register(
			"hastur_clone",
			() -> EntityType.Builder.<EntityHasturClone>of(EntityHasturClone::new, MobCategory.MONSTER)
					.sized(1F, 1F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "hastur_clone").toString()));
	// Seraphim
	public static final RegistryObject<EntityType<EntitySeraphim>> seraphim = ENTITY_TYPES.register("seraphim",
			() -> EntityType.Builder.<EntitySeraphim>of(EntitySeraphim::new, MobCategory.MONSTER)
					.sized(0.9f, 1.6f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "seraphim").toString()));

	public static final RegistryObject<EntityType<EntityTetra>> tetra = ENTITY_TYPES.register("tetra",
			() -> EntityType.Builder.<EntityTetra>of(EntityTetra::new, MobCategory.MONSTER).sized(0.9f, 3f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "tetra").toString()));

//	public static final RegistryObject<EntityType<EntityThrone>> throne = ENTITY_TYPES.register("throne",
//			() -> EntityType.Builder.<EntityThrone>of(EntityThrone::new, MobCategory.MONSTER).sized(1F, 1F)
//					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "throne").toString()));

	// Eldritch
	public static final RegistryObject<EntityType<EntityDarkYoung>> dark_young = ENTITY_TYPES.register("dark_young",
			() -> EntityType.Builder.<EntityDarkYoung>of(EntityDarkYoung::new, MobCategory.MONSTER)
					.sized(1.7f, 2.5f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "dark_young").toString()));

	public static final RegistryObject<EntityType<EntityUzouthrhix>> uzouthrhix = ENTITY_TYPES.register("uzouthrhix",
			() -> EntityType.Builder.<EntityUzouthrhix>of(EntityUzouthrhix::new, MobCategory.MONSTER)
					.sized(4f, 6f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "uzouthrhix").toString()));

	public static final RegistryObject<EntityType<EntityScuttlingOcculus>> scuttling_occulus = ENTITY_TYPES.register(
			"scuttling_occulus",
			() -> EntityType.Builder
					.<EntityScuttlingOcculus>of(EntityScuttlingOcculus::new, MobCategory.MONSTER)
					.sized(0.5f, 0.5f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "scuttling_occulus").toString()));

	public static final RegistryObject<EntityType<EntityBlackGoat>> black_goat = ENTITY_TYPES.register("black_goat",
			() -> EntityType.Builder.<EntityBlackGoat>of(EntityBlackGoat::new, MobCategory.MONSTER)
					.sized(0.5F, 0.8F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "black_goat").toString()));
	// Beast
	public static final RegistryObject<EntityType<EntityBeastFromBeyond>> beast_from_beyond = ENTITY_TYPES.register(
			"beast_from_beyond",
			() -> EntityType.Builder
					.<EntityBeastFromBeyond>of(EntityBeastFromBeyond::new, MobCategory.MONSTER)
					.sized(1.7f, 1.7f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "beast_from_beyond").toString()));

	public static final RegistryObject<EntityType<EntityTheFirstBeast>> the_first_beast = ENTITY_TYPES.register(
			"the_first_beast",
			() -> EntityType.Builder.<EntityTheFirstBeast>of(EntityTheFirstBeast::new, MobCategory.MONSTER)
					.sized(1.7f, 2.7f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "the_first_beast").toString()));

	public static final RegistryObject<EntityType<EntityLordOfTheWild>> lord_of_the_wild = ENTITY_TYPES.register(
			"lord_of_the_wild",
			() -> EntityType.Builder.<EntityLordOfTheWild>of(EntityLordOfTheWild::new, MobCategory.MONSTER)
					.sized(1.7f, 1.7f)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "lord_of_the_wild").toString()));

	public static final RegistryObject<EntityType<EntitySummonedBeast>> summoned_beast = ENTITY_TYPES.register(
			"summoned_beast",
			() -> EntityType.Builder.<EntitySummonedBeast>of(EntitySummonedBeast::new, MobCategory.MONSTER)
					.sized(0.5F, 0.5F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "summoned_beast").toString()));
	public static final RegistryObject<EntityType<EntityDerangedBeast>> deranged_beast = ENTITY_TYPES.register(
			"deranged_beast",
			() -> EntityType.Builder.<EntityDerangedBeast>of(EntityDerangedBeast::new, MobCategory.MONSTER)
					.sized(1F, 1F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "deranged_beast").toString()));

	// Machine
	public static final RegistryObject<EntityType<EntityMechan>> mechan = ENTITY_TYPES.register("mechan",
			() -> EntityType.Builder.<EntityMechan>of(EntityMechan::new, MobCategory.MONSTER)
					.sized(0.9f, 1.7f).build(new ResourceLocation(ForcesOfReality.MOD_ID, "mechan").toString()));

	public static final RegistryObject<EntityType<EntityMalformedAutomaton>> malformed_automaton = ENTITY_TYPES
			.register("malformed_automaton",
					() -> EntityType.Builder
							.<EntityMalformedAutomaton>of(EntityMalformedAutomaton::new,
									MobCategory.MONSTER)
							.sized(3.4f, 5.5f)
							.build(new ResourceLocation(ForcesOfReality.MOD_ID, "malformed_automaton").toString()));
	public static final RegistryObject<EntityType<EntityDreadBot>> dread_bot = ENTITY_TYPES.register("dread_bot",
			() -> EntityType.Builder.<EntityDreadBot>of(EntityDreadBot::new, MobCategory.MONSTER)
					.sized(1.0F, 1.0F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "dread_bot").toString()));

	// Projectiles
	public static final RegistryObject<EntityType<EntityPlayerTentacle>> player_tentacle = ENTITY_TYPES.register(
			"player_tentacle",
			() -> EntityType.Builder
					.<EntityPlayerTentacle>of(EntityPlayerTentacle::new, MobCategory.CREATURE)
					.sized(1.4F, 1.5F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "player_tentacle").toString()));

	public static final RegistryObject<EntityType<EntityFirstBeastBolt>> first_beast_bolt = ENTITY_TYPES.register(
			"first_beast_bolt",
			() -> EntityType.Builder.<EntityFirstBeastBolt>of(EntityFirstBeastBolt::new, MobCategory.MISC)
					.sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "first_beast_bolt").toString()));

	public static final RegistryObject<EntityType<EntityTrackingOrb>> tracking_orb = ENTITY_TYPES.register(
			"tracking_orb",
			() -> EntityType.Builder.<EntityTrackingOrb>of(EntityTrackingOrb::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "tracking_orb").toString()));

	public static final RegistryObject<EntityType<EntityEldritchGrip>> eldritch_grip = ENTITY_TYPES.register(
			"eldritch_grip",
			() -> EntityType.Builder.<EntityEldritchGrip>of(EntityEldritchGrip::new, MobCategory.MONSTER)
					.sized(0.3f, 0.3F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "eldritch_grip").toString()));

	public static final RegistryObject<EntityType<EntityWolfShot>> wolf_shot = ENTITY_TYPES.register("wolf_shot",
			() -> EntityType.Builder.<EntityWolfShot>of(EntityWolfShot::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "wolf_shot").toString()));

	public static final RegistryObject<EntityType<EntityDreadRocket>> dread_rocket = ENTITY_TYPES.register(
			"dread_rocket",
			() -> EntityType.Builder.<EntityDreadRocket>of(EntityDreadRocket::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "dread_rocket").toString()));

	public static final RegistryObject<EntityType<EntityDreadRocketDirected>> dread_rocket_directed = ENTITY_TYPES
			.register("dread_rocket_directed", () -> EntityType.Builder
					.<EntityDreadRocketDirected>of(EntityDreadRocketDirected::new, MobCategory.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.4F, 0.4F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "dread_rocket_directed").toString()));

	public static final RegistryObject<EntityType<EntityShortCircuit>> short_circuit = ENTITY_TYPES.register(
			"short_circuit",
			() -> EntityType.Builder.<EntityShortCircuit>of(EntityShortCircuit::new, MobCategory.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.4F, 0.4F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "short_circuit").toString()));

	public static final RegistryObject<EntityType<EntityShorting>> shorting = ENTITY_TYPES.register("shorting",
			() -> EntityType.Builder.<EntityShorting>of(EntityShorting::new, MobCategory.MISC)
					.setTrackingRange(20).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.6F, 0.6F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "shorting").toString()));
	public static final RegistryObject<EntityType<EntityHolySpirit>> holy_spirit = ENTITY_TYPES.register("holy_spirit",
			() -> EntityType.Builder.<EntityHolySpirit>of(EntityHolySpirit::new, MobCategory.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true)
					.sized(0.25F, 0.25F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "holy_spirit").toString()));
	public static final RegistryObject<EntityType<EntityCorruptNote>> corrupt_note = ENTITY_TYPES.register(
			"corrupt_note",
			() -> EntityType.Builder.<EntityCorruptNote>of(EntityCorruptNote::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "corrupt_note").toString()));

	public static final RegistryObject<EntityType<EntityStarStrike>> star_strike = ENTITY_TYPES.register("star_strike",
			() -> EntityType.Builder.<EntityStarStrike>of(EntityStarStrike::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "star_strike").toString()));
	public static final RegistryObject<EntityType<EntityJudgement>> judgement = ENTITY_TYPES.register("judgement",
			() -> EntityType.Builder.<EntityJudgement>of(EntityJudgement::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).sized(0.7F, 0.7F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "judgement").toString()));
	public static final RegistryObject<EntityType<EntityHolyFlare>> holy_flare = ENTITY_TYPES.register("holy_flare",
			() -> EntityType.Builder.<EntityHolyFlare>of(EntityHolyFlare::new, MobCategory.MONSTER)
					.sized(0.4F, 0.7F).build(new ResourceLocation(ForcesOfReality.MOD_ID, "holy_flare").toString()));
	public static final RegistryObject<EntityType<EntityThrownAxe>> thrown_axe = ENTITY_TYPES.register("thrown_axe",
			() -> EntityType.Builder.<EntityThrownAxe>of(EntityThrownAxe::new, MobCategory.MISC)
					.setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true).sized(0.25F, 0.25F)
					.build(new ResourceLocation(ForcesOfReality.MOD_ID, "thrown_axe").toString()));

	@SubscribeEvent
	public static void onAttributeCreate(EntityAttributeCreationEvent event) {
		event.put(EntityInit.hastur.get(), EntityHastur.setAttributes().build());
		event.put(EntityInit.denizen.get(), EntityDenizen.setAttributes().build());
		event.put(EntityInit.denizen_sage.get(), EntityDenizenSage.setAttributes().build());
		event.put(EntityInit.angelic_fowl.get(), EntityAngelicFowl.setAttributes().build());
		event.put(EntityInit.tentacle.get(), EntityTentacle.setAttributes().build());
		event.put(EntityInit.player_tentacle.get(), EntityPlayerTentacle.setAttributes().build());
		event.put(EntityInit.hastur_spawn.get(), EntityHasturSpawn.setAttributes().build());
		event.put(EntityInit.slug.get(), EntitySlug.setAttributes().build());
		event.put(EntityInit.seraphim.get(), EntitySeraphim.setAttributes().build());
	//	event.put(EntityInit.throne.get(), EntityThrone.setAttributes().build());
		event.put(EntityInit.holy_flare.get(), EntityHolyFlare.setAttributes().build());
		event.put(EntityInit.eldritch_grip.get(), EntityEldritchGrip.setAttributes().build());
		event.put(EntityInit.hastur_clone.get(), EntityHasturClone.setAttributes().build());
		event.put(EntityInit.beast_from_beyond.get(),
				EntityBeastFromBeyond.setAttributes().build());
		event.put(EntityInit.summoned_beast.get(), EntitySummonedBeast.setAttributes().build());
		event.put(EntityInit.malformed_automaton.get(),
				EntityMalformedAutomaton.setAttributes().build());
		event.put(EntityInit.dark_young.get(), EntityDarkYoung.setAttributes().build());
		event.put(EntityInit.tulpa.get(), EntityTulpa.setAttributes().build());
		event.put(EntityInit.scuttling_occulus.get(),
				EntityScuttlingOcculus.setAttributes().build());
		event.put(EntityInit.hastur_vassal.get(), EntityHasturVassal.setAttributes().build());
		event.put(EntityInit.dread_bot.get(), EntityDreadBot.setAttributes().build());
		event.put(EntityInit.mechan.get(), EntityMechan.setAttributes().build());
		event.put(EntityInit.veritas.get(), EntityVeritas.setAttributes().build());
		event.put(EntityInit.black_goat.get(), EntityBlackGoat.setAttributes().build());
		event.put(EntityInit.deranged_beast.get(), EntityDerangedBeast.setAttributes().build());
		event.put(EntityInit.tetra.get(), EntityTetra.setAttributes().build());
		event.put(EntityInit.lord_of_the_wild.get(), EntityLordOfTheWild.setAttributes().build());
		event.put(EntityInit.uzouthrhix.get(), EntityUzouthrhix.setAttributes().build());
		event.put(EntityInit.xanthous_king.get(), EntityTrueXanthousKing.setAttributes().build());
		event.put(EntityInit.true_xanthous_king.get(),
				EntityTrueXanthousKing.setAttributes().build());
		event.put(EntityInit.devotee.get(), EntityDevotee.setAttributes().build());
		event.put(EntityInit.the_first_beast.get(), EntityTheFirstBeast.setAttributes().build());

	}
}
