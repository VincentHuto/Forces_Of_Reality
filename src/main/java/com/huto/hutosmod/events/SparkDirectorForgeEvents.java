package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.FORGE)
public class SparkDirectorForgeEvents {

/*	@SubscribeEvent
	public static void jumpEvent(LivingJumpEvent e) {
		LivingEntity entity = e.getEntityLiving();
		World world = e.getEntity().getEntityWorld();
		if(entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			if(player.inventory.armorInventory.get(2).getItem() == ItemInit.machina_spark_director.get()) {
				ItemStack stack = player.inventory.armorInventory.get(2);
				System.out.println(stack.getOrCreateTag());
				boolean flightActive = stack.getOrCreateTag().getBoolean("flightmode");

				e
			}
		}
	}*/
	
}
