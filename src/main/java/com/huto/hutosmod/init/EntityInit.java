package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.guardians.EntityBeastFromBeyond;
import com.huto.hutosmod.entities.guardians.EntityColin;
import com.huto.hutosmod.entities.guardians.EntityDarkYoung;
import com.huto.hutosmod.entities.guardians.EntityHastur;
import com.huto.hutosmod.entities.guardians.EntityMalformedAutomaton;
import com.huto.hutosmod.entities.guardians.EntitySeraphim;
import com.huto.hutosmod.entities.guardians.EntityTulpa;
import com.huto.hutosmod.entities.item.EntityManaDustItem;
import com.huto.hutosmod.entities.lords.EntityMechan;
import com.huto.hutosmod.entities.lords.EntityVeritas;
import com.huto.hutosmod.entities.mobs.EntityDreadBot;
import com.huto.hutosmod.entities.mobs.EntityScuttlingOcculus;
import com.huto.hutosmod.entities.passive.EntityDenizen;
import com.huto.hutosmod.entities.passive.EntityDenizenSage;
import com.huto.hutosmod.entities.passive.EntityDreamWalker;
import com.huto.hutosmod.entities.passive.EntityIbis;
import com.huto.hutosmod.entities.passive.EntitySlug;
import com.huto.hutosmod.entities.projectiles.EntityCorruptNote;
import com.huto.hutosmod.entities.projectiles.EntityDreadRocket;
import com.huto.hutosmod.entities.projectiles.EntityDreadRocketDirected;
import com.huto.hutosmod.entities.projectiles.EntityHolyFlare;
import com.huto.hutosmod.entities.projectiles.EntityHolySpirit;
import com.huto.hutosmod.entities.projectiles.EntityJudgement;
import com.huto.hutosmod.entities.projectiles.EntityShortCircuit;
import com.huto.hutosmod.entities.projectiles.EntityShorting;
import com.huto.hutosmod.entities.projectiles.EntityStarStrike;
import com.huto.hutosmod.entities.projectiles.EntityThrownAxe;
import com.huto.hutosmod.entities.projectiles.EntityTrackingOrb;
import com.huto.hutosmod.entities.projectiles.EntityWolfShot;
import com.huto.hutosmod.entities.summons.EntityBlackGoat;
import com.huto.hutosmod.entities.summons.EntityEldritchGrip;
import com.huto.hutosmod.entities.summons.EntityHasturClone;
import com.huto.hutosmod.entities.summons.EntityHasturSpawn;
import com.huto.hutosmod.entities.summons.EntityPlayerTentacle;
import com.huto.hutosmod.entities.summons.EntitySummonedBeast;
import com.huto.hutosmod.entities.summons.EntityTentacle;
import com.huto.hutosmod.entities.summons.EntityThrone;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class EntityInit {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			HutosMod.MOD_ID);

	// Passive
	public static final RegistryObject<EntityType<EntityIbis>> ibis = ENTITY_TYPES.register("ibis",
			() -> EntityType.Builder.<EntityIbis>create(EntityIbis::new, EntityClassification.CREATURE).size(0.4F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "ibis").toString()));

	public static final RegistryObject<EntityType<EntitySlug>> slug = ENTITY_TYPES.register("slug",
			() -> EntityType.Builder.<EntitySlug>create(EntitySlug::new, EntityClassification.CREATURE).size(0.4F, 0.1F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "slug").toString()));

	public static final RegistryObject<EntityType<EntityDreamWalker>> dream_walker = ENTITY_TYPES
			.register("dream_walker",
					() -> EntityType.Builder
							.<EntityDreamWalker>create(EntityDreamWalker::new, EntityClassification.CREATURE)
							.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "dream_walker").toString()));
	// Elders
	public static final RegistryObject<EntityType<EntityColin>> colin = ENTITY_TYPES.register("colin",
			() -> EntityType.Builder.<EntityColin>create(EntityColin::new, EntityClassification.CREATURE)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "colin").toString()));

	// Denizens
	public static final RegistryObject<EntityType<EntityDenizen>> denizen = ENTITY_TYPES.register("denizen",
			() -> EntityType.Builder.<EntityDenizen>create(EntityDenizen::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "denizen").toString()));

	public static final RegistryObject<EntityType<EntityDenizenSage>> denizen_sage = ENTITY_TYPES
			.register("denizen_sage",
					() -> EntityType.Builder
							.<EntityDenizenSage>create(EntityDenizenSage::new, EntityClassification.MONSTER)
							.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "denizen_sage").toString()));

	// Self
	public static final RegistryObject<EntityType<EntityTulpa>> tulpa = ENTITY_TYPES.register("tulpa",
			() -> EntityType.Builder.<EntityTulpa>create(EntityTulpa::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "tulpa").toString()));
	public static final RegistryObject<EntityType<EntityVeritas>> veritas = ENTITY_TYPES.register("veritas",
			() -> EntityType.Builder.<EntityVeritas>create(EntityVeritas::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "veritas").toString()));

	// Hastur
	public static final RegistryObject<EntityType<EntityHastur>> hastur = ENTITY_TYPES.register("hastur",
			() -> EntityType.Builder.<EntityHastur>create(EntityHastur::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "hastur").toString()));

	public static final RegistryObject<EntityType<EntityTentacle>> tentacle = ENTITY_TYPES.register("tentacle",
			() -> EntityType.Builder.<EntityTentacle>create(EntityTentacle::new, EntityClassification.MONSTER)
					.size(0.4F, 0.7F).build(new ResourceLocation(HutosMod.MOD_ID, "tentacle").toString()));

	public static final RegistryObject<EntityType<EntityHasturSpawn>> hastur_spawn = ENTITY_TYPES
			.register("hastur_spawn",
					() -> EntityType.Builder
							.<EntityHasturSpawn>create(EntityHasturSpawn::new, EntityClassification.MONSTER)
							.size(0.4F, 0.7F).build(new ResourceLocation(HutosMod.MOD_ID, "hastur_spawn").toString()));

	public static final RegistryObject<EntityType<EntityHasturClone>> hastur_clone = ENTITY_TYPES
			.register("hastur_clone",
					() -> EntityType.Builder
							.<EntityHasturClone>create(EntityHasturClone::new, EntityClassification.MONSTER)
							.size(1F, 1F).build(new ResourceLocation(HutosMod.MOD_ID, "hastur_clone").toString()));
	// Seraphim
	public static final RegistryObject<EntityType<EntitySeraphim>> seraphim = ENTITY_TYPES.register("seraphim",
			() -> EntityType.Builder.<EntitySeraphim>create(EntitySeraphim::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "seraphim").toString()));
	public static final RegistryObject<EntityType<EntityThrone>> throne = ENTITY_TYPES.register("throne",
			() -> EntityType.Builder.<EntityThrone>create(EntityThrone::new, EntityClassification.MONSTER).size(1F, 1F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "throne").toString()));

	// Eldritch
	public static final RegistryObject<EntityType<EntityDarkYoung>> dark_young = ENTITY_TYPES.register("dark_young",
			() -> EntityType.Builder.<EntityDarkYoung>create(EntityDarkYoung::new, EntityClassification.MONSTER)
					.size(1.7f, 1.7f).build(new ResourceLocation(HutosMod.MOD_ID, "dark_young").toString()));

	public static final RegistryObject<EntityType<EntityScuttlingOcculus>> scuttling_occulus = ENTITY_TYPES.register(
			"scuttling_occulus",
			() -> EntityType.Builder
					.<EntityScuttlingOcculus>create(EntityScuttlingOcculus::new, EntityClassification.MONSTER)
					.size(0.5f, 0.5f).build(new ResourceLocation(HutosMod.MOD_ID, "scuttling_occulus").toString()));

	public static final RegistryObject<EntityType<EntityBlackGoat>> black_goat = ENTITY_TYPES.register("black_goat",
			() -> EntityType.Builder.<EntityBlackGoat>create(EntityBlackGoat::new, EntityClassification.MONSTER)
					.size(0.5F, 0.5F).build(new ResourceLocation(HutosMod.MOD_ID, "black_goat").toString()));
	// Beast
	public static final RegistryObject<EntityType<EntityBeastFromBeyond>> beast_from_beyond = ENTITY_TYPES.register(
			"beast_from_beyond",
			() -> EntityType.Builder
					.<EntityBeastFromBeyond>create(EntityBeastFromBeyond::new, EntityClassification.MONSTER)
					.size(1.7f, 1.7f).build(new ResourceLocation(HutosMod.MOD_ID, "beast_from_beyond").toString()));
	public static final RegistryObject<EntityType<EntitySummonedBeast>> summoned_beast = ENTITY_TYPES.register(
			"summoned_beast",
			() -> EntityType.Builder.<EntitySummonedBeast>create(EntitySummonedBeast::new, EntityClassification.MONSTER)
					.size(0.5F, 0.5F).build(new ResourceLocation(HutosMod.MOD_ID, "summoned_beast").toString()));

	// Machine
	public static final RegistryObject<EntityType<EntityMechan>> mechan = ENTITY_TYPES.register("mechan",
			() -> EntityType.Builder.<EntityMechan>create(EntityMechan::new, EntityClassification.MONSTER)
					.size(0.9f, 1.3f).build(new ResourceLocation(HutosMod.MOD_ID, "mechan").toString()));

	public static final RegistryObject<EntityType<EntityMalformedAutomaton>> malformed_automaton = ENTITY_TYPES
			.register("malformed_automaton", () -> EntityType.Builder
					.<EntityMalformedAutomaton>create(EntityMalformedAutomaton::new, EntityClassification.MONSTER)
					.size(3.4f, 5.5f).build(new ResourceLocation(HutosMod.MOD_ID, "malformed_automaton").toString()));
	public static final RegistryObject<EntityType<EntityDreadBot>> dread_bot = ENTITY_TYPES.register("dread_bot",
			() -> EntityType.Builder.<EntityDreadBot>create(EntityDreadBot::new, EntityClassification.MONSTER)
					.size(0.5F, 0.5F).build(new ResourceLocation(HutosMod.MOD_ID, "dread_bot").toString()));
	// Machine

	// Projectiles
	public static final RegistryObject<EntityType<EntityPlayerTentacle>> player_tentacle = ENTITY_TYPES.register(
			"player_tentacle",
			() -> EntityType.Builder
					.<EntityPlayerTentacle>create(EntityPlayerTentacle::new, EntityClassification.CREATURE)
					.size(1.4F, 1.5F).build(new ResourceLocation(HutosMod.MOD_ID, "player_tentacle").toString()));

	public static final RegistryObject<EntityType<EntityTrackingOrb>> tracking_orb = ENTITY_TYPES.register(
			"tracking_orb",
			() -> EntityType.Builder.<EntityTrackingOrb>create(EntityTrackingOrb::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "tracking_orb").toString()));

	public static final RegistryObject<EntityType<EntityEldritchGrip>> eldritch_grip = ENTITY_TYPES
			.register("eldritch_grip",
					() -> EntityType.Builder
							.<EntityEldritchGrip>create(EntityEldritchGrip::new, EntityClassification.MONSTER)
							.size(0.3f, 0.3F).build(new ResourceLocation(HutosMod.MOD_ID, "eldritch_grip").toString()));

	public static final RegistryObject<EntityType<EntityWolfShot>> wolf_shot = ENTITY_TYPES.register("wolf_shot",
			() -> EntityType.Builder.<EntityWolfShot>create(EntityWolfShot::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "wolf_shot").toString()));

	public static final RegistryObject<EntityType<EntityDreadRocket>> dread_rocket = ENTITY_TYPES.register(
			"dread_rocket",
			() -> EntityType.Builder.<EntityDreadRocket>create(EntityDreadRocket::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "dread_rocket").toString()));

	public static final RegistryObject<EntityType<EntityDreadRocketDirected>> dread_rocket_directed = ENTITY_TYPES
			.register("dread_rocket_directed", () -> EntityType.Builder
					.<EntityDreadRocketDirected>create(EntityDreadRocketDirected::new, EntityClassification.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.4F, 0.4F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "dread_rocket_directed").toString()));

	public static final RegistryObject<EntityType<EntityShortCircuit>> short_circuit = ENTITY_TYPES.register(
			"short_circuit",
			() -> EntityType.Builder.<EntityShortCircuit>create(EntityShortCircuit::new, EntityClassification.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.4F, 0.4F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "short_circuit").toString()));

	public static final RegistryObject<EntityType<EntityShorting>> shorting = ENTITY_TYPES.register("shorting",
			() -> EntityType.Builder.<EntityShorting>create(EntityShorting::new, EntityClassification.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.4F, 0.4F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "shorting").toString()));
	public static final RegistryObject<EntityType<EntityHolySpirit>> holy_spirit = ENTITY_TYPES.register(
			"holy_spirit",
			() -> EntityType.Builder
					.<EntityHolySpirit>create(EntityHolySpirit::new, EntityClassification.MISC)
					.setTrackingRange(150).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.25F, 0.25F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "holy_spirit").toString()));
	
	public static final RegistryObject<EntityType<EntityCorruptNote>> corrupt_note = ENTITY_TYPES.register(
			"corrupt_note",
			() -> EntityType.Builder.<EntityCorruptNote>create(EntityCorruptNote::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "corrupt_note").toString()));

	public static final RegistryObject<EntityType<EntityStarStrike>> star_strike = ENTITY_TYPES.register("star_strike",
			() -> EntityType.Builder.<EntityStarStrike>create(EntityStarStrike::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "star_strike").toString()));
	public static final RegistryObject<EntityType<EntityJudgement>> judgement = ENTITY_TYPES.register("judgement",
			() -> EntityType.Builder.<EntityJudgement>create(EntityJudgement::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(12).setShouldReceiveVelocityUpdates(true).size(0.7F, 0.7F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "judgement").toString()));
	public static final RegistryObject<EntityType<EntityHolyFlare>> holy_flare = ENTITY_TYPES.register("holy_flare",
			() -> EntityType.Builder.<EntityHolyFlare>create(EntityHolyFlare::new, EntityClassification.MONSTER)
					.size(0.4F, 0.7F).build(new ResourceLocation(HutosMod.MOD_ID, "holy_flare").toString()));
	public static final RegistryObject<EntityType<EntityThrownAxe>> thrown_axe = ENTITY_TYPES.register("thrown_axe",
			() -> EntityType.Builder.<EntityThrownAxe>create(EntityThrownAxe::new, EntityClassification.MISC)
					.setTrackingRange(64).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true).size(0.25F, 0.25F)
					.build(new ResourceLocation(HutosMod.MOD_ID, "thrown_axe").toString()));

	public static final RegistryObject<EntityType<EntityManaDustItem>> mana_dust = ENTITY_TYPES.register("mana_dust",
			() -> EntityType.Builder.<EntityManaDustItem>create(EntityManaDustItem::new, EntityClassification.MISC)
					.size(0.25F, 0.25F).build(new ResourceLocation(HutosMod.MOD_ID, "mana_dust").toString()));

	@SubscribeEvent
	public static void registerAttributes(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(EntityInit.dream_walker.get(), EntityDreamWalker.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.colin.get(), EntityColin.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.hastur.get(), EntityHastur.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.denizen.get(), EntityDenizen.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.denizen_sage.get(), EntityDenizenSage.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.ibis.get(), EntityIbis.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.tentacle.get(), EntityTentacle.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.player_tentacle.get(), EntityPlayerTentacle.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.hastur_spawn.get(), EntityHasturSpawn.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.slug.get(), EntitySlug.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.seraphim.get(), EntitySeraphim.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.throne.get(), EntityThrone.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.holy_flare.get(), EntityHolyFlare.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.eldritch_grip.get(), EntityEldritchGrip.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.hastur_clone.get(), EntityHasturClone.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.beast_from_beyond.get(),
				EntityBeastFromBeyond.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.summoned_beast.get(), EntitySummonedBeast.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.malformed_automaton.get(),
				EntityMalformedAutomaton.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.dark_young.get(), EntityDarkYoung.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.tulpa.get(), EntityTulpa.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.scuttling_occulus.get(),
				EntityScuttlingOcculus.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.dread_bot.get(), EntityDreadBot.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.mechan.get(), EntityMechan.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.veritas.get(), EntityVeritas.setAttributes().create());
		GlobalEntityTypeAttributes.put(EntityInit.black_goat.get(), EntityBlackGoat.setAttributes().create());

	}
}
