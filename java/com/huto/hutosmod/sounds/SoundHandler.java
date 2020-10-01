package com.huto.hutosmod.sounds;

import com.huto.hutosmod.HutosMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundHandler {

	public static SoundEvent ENTITY_COLIN_AMBIENT, ENTITY_COLIN_HURT, ENTITY_COLIN_DEATH;
	public static SoundEvent ENTITY_HASTUR_AMBIENT, ENTITY_HASTUR_HURT, ENTITY_HASTUR_DEATH, ENTITY_HASTUR_MUSIC,
			ENTITY_HASTUR_HIT;
	public static SoundEvent ENTITY_DENIZEN_AMBIENT, ENTITY_DENIZEN_HURT, ENTITY_DENIZEN_DEATH;

	public static void registerSounds() {

		ENTITY_COLIN_AMBIENT = registerSound("entity.colin.ambient");
		ENTITY_COLIN_HURT = registerSound("entity.colin.hurt");
		ENTITY_COLIN_DEATH = registerSound("entity.colin.death");

		ENTITY_HASTUR_AMBIENT = registerSound("entity.hastur.ambient");
		ENTITY_HASTUR_HURT = registerSound("entity.hastur.hurt");
		ENTITY_HASTUR_DEATH = registerSound("entity.hastur.death");
		ENTITY_HASTUR_MUSIC = registerSound("entity.hastur.music");
		ENTITY_HASTUR_HIT = registerSound("entity.hastur.hit");

		ENTITY_DENIZEN_AMBIENT = registerSound("entity.denizen.ambient");
		ENTITY_DENIZEN_HURT = registerSound("entity.denizen.hurt");
		ENTITY_DENIZEN_DEATH = registerSound("entity.denizen.death");

	}

	public static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(HutosMod.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

}
