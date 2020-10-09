package com.huto.hutosmod.sounds;

import com.huto.hutosmod.HutosMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
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
	public static final SoundEvent STAR_SLUG_STRIKE = makeSoundEvent("item.star_slug.strike");
	public static final SoundEvent STAR_SLUG_STORM = makeSoundEvent("item.star_slug.storm");

	public static final SoundEvent ENTITY_SERAPHIM_AMBIENT = makeSoundEvent("entity.seraphim.ambient");
	public static final SoundEvent ENTITY_SERAPHIM_HURT = makeSoundEvent("entity.seraphim.hurt");
	public static final SoundEvent ENTITY_SERAPHIM_DEATH = makeSoundEvent("entity.seraphim.death");
	public static final SoundEvent ENTITY_SERAPHIM_MUSIC = makeSoundEvent("entity.seraphim.music");
	public static final SoundEvent ENTITY_SERAPHIM_HIT = makeSoundEvent("entity.seraphim.hit");
	public static final SoundEvent ENTITY_SERAPHIM_FLARE = makeSoundEvent("entity.seraphim.flare");
	public static final SoundEvent ENTITY_SERAPHIM_THRONE= makeSoundEvent("entity.seraphim.thronesummon");

	private static SoundEvent makeSoundEvent(String name) {
		ResourceLocation loc = new ResourceLocation(HutosMod.MOD_ID, name);
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

		r.register(STAR_SLUG_STRIKE);
		r.register(STAR_SLUG_STORM);

		r.register(ENTITY_SERAPHIM_AMBIENT);
		r.register(ENTITY_SERAPHIM_HURT);
		r.register(ENTITY_SERAPHIM_DEATH);
		r.register(ENTITY_SERAPHIM_MUSIC);
		r.register(ENTITY_SERAPHIM_HIT);
		r.register(ENTITY_SERAPHIM_FLARE);
		r.register(ENTITY_SERAPHIM_THRONE);

	}

}
