package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityTrackingOrb;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

//@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProjectileInit {
/*
	public static final EntityType<EntityTrackingOrb> MAGIC_MISSILE = EntityType.Builder
			.<EntityTrackingOrb>create(EntityTrackingOrb::new, EntityClassification.MISC).setTrackingRange(64)
			.setUpdateInterval(2).setShouldReceiveVelocityUpdates(true).build("");

	public static <T> void register(Registry<? super T> reg, String name, T thing) {
		register(reg, name, thing);
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<EntityType<?>> evt) {
		IForgeRegistry<EntityType<?>> r = evt.getRegistry();
		r.register(MAGIC_MISSILE);

	}	*/
}
