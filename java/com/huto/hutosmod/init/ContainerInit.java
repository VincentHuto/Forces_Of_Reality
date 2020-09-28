package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.containers.ContainerChiselStation;
import com.huto.hutosmod.containers.ContainerVirtuousEnchanter;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, HutosMod.MOD_ID);
	public static final RegistryObject<ContainerType<ContainerVirtuousEnchanter>> virtuous_enchanter = CONTAINERS
			.register("virtuous_enchanter", () -> IForgeContainerType.create(ContainerVirtuousEnchanter::new));
	public static final RegistryObject<ContainerType<ContainerChiselStation>> runic_chisel_station = CONTAINERS
			.register("runic_chisel_station", () -> IForgeContainerType.create(ContainerChiselStation::new));
}
