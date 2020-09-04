package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.FORGE)
public class HutosModEvents {
	
	@SubscribeEvent
	public static void jumpEvent (LivingJumpEvent e) {
		LivingEntity entity = e.getEntityLiving();
		World world  = entity.getEntityWorld();
		world.setBlockState(entity.getPosition(), BlockInit.nightmare_earth.get().getDefaultState());
	//	entity.addVelocity(0, 2, 0);
	}
	

}
