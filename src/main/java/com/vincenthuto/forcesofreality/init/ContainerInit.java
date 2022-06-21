package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.container.ContainerMechanGlove;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerInit {
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,
			ForcesOfReality.MOD_ID);
//	public static List<MenuType<?>> RUNECONTAINER = new ArrayList<>();
//
//	/*
//	 * public static final RegistryObject<ContainerType<ContainerChiselStation>>
//	 * runic_chisel_station = CONTAINERS .register("runic_chisel_station", () ->
//	 * IForgeContainerType.create(ContainerChiselStation::new));
//	 */
//
//	@ObjectHolder("forcesofreality:player_runes")
//	public static MenuType<PlayerExpandedContainer> PLAYER_ADORNMENTS = createAdornmentContainer("player_runes",
//			(id, inv, data) -> new PlayerExpandedContainer(id, inv, !inv.player.level.isClientSide));
//
//	private static <T extends AbstractContainerMenu> MenuType<T> createAdornmentContainer(String name,
//			IContainerFactory<T> factory) {
//		MenuType<T> containerType = IForgeContainerType.create(factory);
//		containerType.setRegistryName(new ResourceLocation(ForcesOfReality.MOD_ID, name));
//		RUNECONTAINER.add(containerType);
//		return containerType;
//	}
//
//	@SubscribeEvent
//	public static void onContainerRegister(final RegistryEvent.Register<MenuType<?>> event) {
//		event.getRegistry().registerAll(RUNECONTAINER.toArray(new MenuType[0]));
//		// event.getRegistry().register(ContainerAdornmentBinder.type);
//		event.getRegistry().register(ContainerMechanGlove.type);
//
//	}
//
//	@SubscribeEvent
//	public static void onRecipeRegistry(final RegistryEvent.Register<RecipeSerializer<?>> event) {
////		event.getRegistry().register(new CopyAdornmentBinderDataRecipe.Serializer()
	
////				.setRegistryName(new ResourceLocation(ForcesOfReality.MOD_ID, "backpack_upgrade")));
//	}
	
	 public static final RegistryObject<MenuType<ContainerMechanGlove>> mechan_glove_container = CONTAINERS.register("mechan_glove_container", 
			 () ->IForgeMenuType.create(ContainerMechanGlove::new));
}
