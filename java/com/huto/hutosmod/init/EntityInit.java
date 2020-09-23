package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.ExampleEntity;

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

	public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPES
			.register("example_entity",
					() -> EntityType.Builder.<ExampleEntity>create(ExampleEntity::new, EntityClassification.CREATURE)
							.size(0.9f, 1.3f)
							.build(new ResourceLocation(HutosMod.MOD_ID, "example_entity").toString()));

	@SubscribeEvent
	public static void registerAttributes(final FMLCommonSetupEvent event) {
		GlobalEntityTypeAttributes.put(EntityInit.EXAMPLE_ENTITY.get(),
				ExampleEntity.func_233666_p_().create());/* (or your own) */
	}
}
