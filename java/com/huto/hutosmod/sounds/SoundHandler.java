package com.huto.hutosmod.sounds;

import com.huto.hutosmod.HutosMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundHandler {

	public static SoundEvent ENTITY_COLIN_AMBIENT, ENTITY_COLIN_HURT, ENTITY_COLIN_DEATH;

	public static void registerSounds() {

		ENTITY_COLIN_AMBIENT = registerSound("entity.colin.ambient");
		 ENTITY_COLIN_HURT = registerSound("entity.colin.hurt");
		 ENTITY_COLIN_DEATH = registerSound("entity.colin.death");

	}

	public static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(HutosMod.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

}
