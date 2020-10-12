package com.huto.hutosmod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.huto.hutosmod.capabilities.covenant.CovenantEvents;
import com.huto.hutosmod.capabilities.karma.KarmaEvents;
import com.huto.hutosmod.capabilities.vibes.VibrationEvents;
import com.huto.hutosmod.containers.mindrunes.PlayerExpandedContainer;
import com.huto.hutosmod.events.ClientEventRender;
import com.huto.hutosmod.events.KarmaHudEventHandler;
import com.huto.hutosmod.events.SeerEventHandler;
import com.huto.hutosmod.gui.pages.TomePageLib;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.CapabilityInit;
import com.huto.hutosmod.init.ContainerInit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.particles.init.ParticleInit;
import com.huto.hutosmod.recipes.ModChiselRecipes;
import com.huto.hutosmod.recipes.ModFuserRecipies;
import com.huto.hutosmod.recipes.ModResonatorRecipies;
import com.huto.hutosmod.recipes.ModWandRecipies;
import com.huto.hutosmod.render.rune.RunesRenderLayer;
import com.huto.hutosmod.worldgen.ModOreGen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod("hutosmod")
@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class HutosMod {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "hutosmod";
	public static HutosMod instance;
	public static ServerConfig SERVER_CONFIG;
	public static ClientConfig CLIENT_CONFIG;


	public HutosMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::doClientStuff);
		ParticleInit.PARTICLE_TYPES.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		TileEntityInit.TILES.register(modEventBus);
		ContainerInit.CONTAINERS.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		// Register Vibration Events
		MinecraftForge.EVENT_BUS.register(VibrationEvents.class);
		MinecraftForge.EVENT_BUS.register(KarmaEvents.class);
		MinecraftForge.EVENT_BUS.register(CovenantEvents.class);
		MinecraftForge.EVENT_BUS.register(SeerEventHandler.class);
		MinecraftForge.EVENT_BUS.register(KarmaHudEventHandler.class);

		SERVER_CONFIG = registerConfig(ModConfig.Type.SERVER, ServerConfig.class, true);
		CLIENT_CONFIG = registerConfig(ModConfig.Type.CLIENT, ClientConfig.class);

	}

	/**
	 * Registers a config for the provided config type
	 *
	 * @param type             the config type
	 * @param configClass      the config class
	 * @param registerListener if a config reload listener should be registered
	 * @return the instantiated config
	 */
	public static <T extends ConfigBase> T registerConfig(ModConfig.Type type, Class<T> configClass,
			boolean registerListener) {
		Pair<T, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(builder -> {
			try {
				return configClass.getConstructor(ForgeConfigSpec.Builder.class).newInstance(builder);
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		});
		ModLoadingContext.get().registerConfig(type, specPair.getRight());
		T config = specPair.getLeft();
		config.setConfigSpec(specPair.getRight());
		if (registerListener) {
			Consumer<ModConfig.ModConfigEvent> consumer = evt -> {
				if (evt.getConfig().getType() == type) {
					config.onReload(evt);
				}
			};
			FMLJavaModLoadingContext.get().getModEventBus().addListener(consumer);
		}
		return config;
	}

	/**
	 * Registers a config for the provided config type
	 *
	 * @param type        the config type
	 * @param configClass the config class
	 * @return the instantiated config
	 */
	public static <T extends ConfigBase> T registerConfig(ModConfig.Type type, Class<T> configClass) {
		return registerConfig(type, configClass, false);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		// Automatically Registers BlockItems
		final IForgeRegistry<Item> registry = event.getRegistry();
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			if (block == BlockInit.obj_icosahedron.get()) {
				final Item.Properties properties = new Item.Properties().group(HutosModItemGroup.instance)
						.rarity(Rarity.EPIC);
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			} else {
				final Item.Properties properties = new Item.Properties().group(HutosModItemGroup.instance);
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			}
		});
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		ModOreGen.initGen();
		ModOreGen.setupGen();
		CapabilityInit.init();
		ModWandRecipies.init();
		ModResonatorRecipies.init();
		ModFuserRecipies.init();
		ModChiselRecipes.init();
		PacketHandler.registerChannels();

	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		TomePageLib.registerPages();
		MinecraftForge.EVENT_BUS.register(ClientEventRender.class);

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	public void setupOnLoaded(FMLLoadCompleteEvent event) {
		this.addLayers();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@OnlyIn(Dist.CLIENT)
	private void addLayers() {
		Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getRenderManager().getSkinMap();
		PlayerRenderer render;
		render = skinMap.get("default");
		render.addLayer(new RunesRenderLayer(render));
		render = skinMap.get("slim");
		render.addLayer(new RunesRenderLayer(render));
	}

	public static class HutosModItemGroup extends ItemGroup {
		public static final HutosModItemGroup instance = new HutosModItemGroup(ItemGroup.GROUPS.length, "hutosTab");

		public HutosModItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.activated_obsidian.get());
		}
	}

	@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Registration {

		public static List<ContainerType<?>> CONTAINERS = new ArrayList<>();

		@ObjectHolder("hutosmod:player_runes")
		public static ContainerType<PlayerExpandedContainer> PLAYER_RUNES = createContainer("player_runes",
				(id, inv, data) -> new PlayerExpandedContainer(id, inv, !inv.player.world.isRemote));

		private static <T extends Container> ContainerType<T> createContainer(String name,
				IContainerFactory<T> factory) {
			ContainerType<T> containerType = IForgeContainerType.create(factory);
			containerType.setRegistryName(new ResourceLocation(HutosMod.MOD_ID, name));
			CONTAINERS.add(containerType);
			return containerType;
		}

		@SubscribeEvent
		public static void onContainerRegister(final RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().registerAll(CONTAINERS.toArray(new ContainerType[0]));
		}
	}
}
