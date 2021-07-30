package com.huto.forcesofreality.sound;

import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundHandler {

	public static final SoundEvent ENTITY_COLIN_AMBIENT = makeSoundEvent("entity.colin.ambient");
	public static final SoundEvent ENTITY_COLIN_HURT = makeSoundEvent("entity.colin.hurt");
	public static final SoundEvent ENTITY_COLIN_DEATH = makeSoundEvent("entity.colin.death");

	public static final SoundEvent ENTITY_HASTUR_AMBIENT = makeSoundEvent("entity.hastur.ambient");
	public static final SoundEvent ENTITY_HASTUR_HURT = makeSoundEvent("entity.hastur.hurt");
	public static final SoundEvent ENTITY_HASTUR_DEATH = makeSoundEvent("entity.hastur.death");
	public static final SoundEvent ENTITY_HASTUR_MUSIC = makeSoundEvent("entity.hastur.music");
	public static final SoundEvent ENTITY_HASTUR_HIT = makeSoundEvent("entity.hastur.hit");

	public static final SoundEvent ENTITY_TENTACLE_AMBIENT = makeSoundEvent("entity.tentacle.ambient");
	public static final SoundEvent ENTITY_TENTACLE_HURT = makeSoundEvent("entity.tentacle.hurt");
	public static final SoundEvent ENTITY_TENTACLE_DEATH = makeSoundEvent("entity.tentacle.death");
	public static final SoundEvent ENTITY_TENTACLE_SUMMON = makeSoundEvent("entity.tentacle.summon");

	public static final SoundEvent ENTITY_DENIZEN_AMBIENT = makeSoundEvent("entity.denizen.ambient");
	public static final SoundEvent ENTITY_DENIZEN_HURT = makeSoundEvent("entity.denizen.hurt");
	public static final SoundEvent ENTITY_DENIZEN_DEATH = makeSoundEvent("entity.denizen.death");

	public static final SoundEvent ENTITY_SERAPHIM_AMBIENT = makeSoundEvent("entity.seraphim.ambient");
	public static final SoundEvent ENTITY_SERAPHIM_HURT = makeSoundEvent("entity.seraphim.hurt");
	public static final SoundEvent ENTITY_SERAPHIM_DEATH = makeSoundEvent("entity.seraphim.death");
	public static final SoundEvent ENTITY_SERAPHIM_MUSIC = makeSoundEvent("entity.seraphim.music");
	public static final SoundEvent ENTITY_SERAPHIM_HIT = makeSoundEvent("entity.seraphim.hit");
	public static final SoundEvent ENTITY_SERAPHIM_FLARE = makeSoundEvent("entity.seraphim.flare");
	public static final SoundEvent ENTITY_SERAPHIM_THRONE = makeSoundEvent("entity.seraphim.thronesummon");

	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_AMBIENT = makeSoundEvent(
			"entity.beast_from_beyond.ambient");
	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_HURT = makeSoundEvent("entity.beast_from_beyond.hurt");
	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_DEATH = makeSoundEvent("entity.beast_from_beyond.death");
	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_MUSIC = makeSoundEvent("entity.beast_from_beyond.music");
	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_HIT = makeSoundEvent("entity.beast_from_beyond.hit");
	public static final SoundEvent ENTITY_BEAST_FROM_BEYOND_STEP = makeSoundEvent("entity.beast_from_beyond.step");

	public static final SoundEvent ENTITY_DARK_YOUNG_AMBIENT = makeSoundEvent("entity.dark_young.ambient");
	public static final SoundEvent ENTITY_DARK_YOUNG_HURT = makeSoundEvent("entity.dark_young.hurt");
	public static final SoundEvent ENTITY_DARK_YOUNG_HURTOTHER = makeSoundEvent("entity.dark_young.hurtother");
	public static final SoundEvent ENTITY_DARK_YOUNG_TELEPORT = makeSoundEvent("entity.dark_young.teleport");
	public static final SoundEvent ENTITY_DARK_YOUNG_DEATH = makeSoundEvent("entity.dark_young.death");
	public static final SoundEvent ENTITY_DARK_YOUNG_MUSIC = makeSoundEvent("entity.dark_young.music");
	public static final SoundEvent ENTITY_DARK_YOUNG_HIT = makeSoundEvent("entity.dark_young.hit");

	public static final SoundEvent ENTITY_DREADBOT_AMBIENT = makeSoundEvent("entity.dread_bot.ambient");
	public static final SoundEvent ENTITY_DREADBOT_HURT = makeSoundEvent("entity.dread_bot.hurt");
	public static final SoundEvent ENTITY_DREADBOT_DEATH = makeSoundEvent("entity.dread_bot.death");

	public static final SoundEvent ITEM_STAR_SLUG_STRIKE = makeSoundEvent("item.star_slug.strike");
	public static final SoundEvent ITEM_STAR_SLUG_STORM = makeSoundEvent("item.star_slug.storm");
	public static final SoundEvent ITEM_BOW_BLADE_OPEN = makeSoundEvent("item.bow_blade.open");
	public static final SoundEvent ITEM_BOW_BLADE_CLOSE = makeSoundEvent("item.bow_blade.close");

	private static SoundEvent makeSoundEvent(String name) {
		ResourceLocation loc = new ResourceLocation(ForcesOfReality.MOD_ID, name);
		return new SoundEvent(loc).setRegistryName(loc);
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> evt) {
		IForgeRegistry<SoundEvent> r = evt.getRegistry();
		r.register(ENTITY_COLIN_AMBIENT);
		r.register(ENTITY_COLIN_HURT);
		r.register(ENTITY_COLIN_DEATH);

		r.register(ENTITY_HASTUR_AMBIENT);
		r.register(ENTITY_HASTUR_HURT);
		r.register(ENTITY_HASTUR_DEATH);
		r.register(ENTITY_HASTUR_MUSIC);
		r.register(ENTITY_HASTUR_HIT);

		r.register(ENTITY_TENTACLE_AMBIENT);
		r.register(ENTITY_TENTACLE_HURT);
		r.register(ENTITY_TENTACLE_DEATH);
		r.register(ENTITY_TENTACLE_SUMMON);

		r.register(ENTITY_DENIZEN_AMBIENT);
		r.register(ENTITY_DENIZEN_HURT);
		r.register(ENTITY_DENIZEN_DEATH);

		r.register(ENTITY_SERAPHIM_AMBIENT);
		r.register(ENTITY_SERAPHIM_HURT);
		r.register(ENTITY_SERAPHIM_DEATH);
		r.register(ENTITY_SERAPHIM_MUSIC);

		r.register(ENTITY_BEAST_FROM_BEYOND_AMBIENT);
		r.register(ENTITY_BEAST_FROM_BEYOND_HURT);
		r.register(ENTITY_BEAST_FROM_BEYOND_DEATH);
		r.register(ENTITY_BEAST_FROM_BEYOND_MUSIC);
		r.register(ENTITY_BEAST_FROM_BEYOND_HIT);
		r.register(ENTITY_BEAST_FROM_BEYOND_STEP);

		r.register(ENTITY_DARK_YOUNG_AMBIENT);
		r.register(ENTITY_DARK_YOUNG_HURT);
		r.register(ENTITY_DARK_YOUNG_HURTOTHER);
		r.register(ENTITY_DARK_YOUNG_DEATH);
		r.register(ENTITY_DARK_YOUNG_MUSIC);
		r.register(ENTITY_DARK_YOUNG_HIT);
		r.register(ENTITY_DARK_YOUNG_TELEPORT);

		r.register(ENTITY_DREADBOT_AMBIENT);
		r.register(ENTITY_DREADBOT_HURT);
		r.register(ENTITY_DREADBOT_DEATH);

		r.register(ITEM_STAR_SLUG_STRIKE);
		r.register(ITEM_STAR_SLUG_STORM);
		r.register(ITEM_BOW_BLADE_OPEN);
		r.register(ITEM_BOW_BLADE_CLOSE);

	}

}
