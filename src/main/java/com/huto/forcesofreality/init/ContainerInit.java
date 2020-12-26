package com.huto.forcesofreality.init;

import java.util.ArrayList;
import java.util.List;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerChiselStation;
import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.containers.ContainerRuneBinder;
import com.huto.forcesofreality.containers.ContainerVirtuousEnchanter;
import com.huto.forcesofreality.containers.PlayerExpandedContainer;
import com.huto.forcesofreality.recipes.CopyRuneBinderDataRecipe;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, ForcesOfReality.MOD_ID);
	public static List<ContainerType<?>> RUNECONTAINER = new ArrayList<>();

	public static final RegistryObject<ContainerType<ContainerVirtuousEnchanter>> virtuous_enchanter = CONTAINERS
			.register("virtuous_enchanter", () -> IForgeContainerType.create(ContainerVirtuousEnchanter::new));
	public static final RegistryObject<ContainerType<ContainerChiselStation>> runic_chisel_station = CONTAINERS
			.register("runic_chisel_station", () -> IForgeContainerType.create(ContainerChiselStation::new));

	@ObjectHolder("forcesofreality:player_runes")
	public static ContainerType<PlayerExpandedContainer> PLAYER_RUNES = createRuneContainer("player_runes",
			(id, inv, data) -> new PlayerExpandedContainer(id, inv, !inv.player.world.isRemote));

	private static <T extends Container> ContainerType<T> createRuneContainer(String name,
			IContainerFactory<T> factory) {
		ContainerType<T> containerType = IForgeContainerType.create(factory);
		containerType.setRegistryName(new ResourceLocation(ForcesOfReality.MOD_ID, name));
		RUNECONTAINER.add(containerType);
		return containerType;
	}

	@SubscribeEvent
	public static void onContainerRegister(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().registerAll(RUNECONTAINER.toArray(new ContainerType[0]));
		event.getRegistry().register(ContainerRuneBinder.type);
		event.getRegistry().register(ContainerMechanGlove.type);

	}

	@SubscribeEvent
	public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
		event.getRegistry().register(new CopyRuneBinderDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(ForcesOfReality.MOD_ID, "backpack_upgrade")));
	}
}
