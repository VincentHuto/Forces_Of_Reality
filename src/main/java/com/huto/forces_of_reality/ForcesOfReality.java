package com.huto.forces_of_reality;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.huto.forces_of_reality.capabilities.covenant.CovenantEvents;
import com.huto.forces_of_reality.capabilities.karma.KarmaEvents;
import com.huto.forces_of_reality.capabilities.karma.KarmaHudEventHandler;
import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivationEvents;
import com.huto.forces_of_reality.capabilities.tiledevotion.DevotionEvents;
import com.huto.forces_of_reality.capabilities.vibes.SeerEventHandler;
import com.huto.forces_of_reality.capabilities.vibes.VibrationEvents;
import com.huto.forces_of_reality.capabilities.vibes.chunk.ChunkVibrationEvents;
import com.huto.forces_of_reality.events.MechanGloveEvents;
import com.huto.forces_of_reality.events.RuneBinderEvents;
import com.huto.forces_of_reality.events.SparkDirectorModEvents;
import com.huto.forces_of_reality.gui.pages.coven.CovenPageLib;
import com.huto.forces_of_reality.gui.pages.guide.TomePageLib;
import com.huto.forces_of_reality.init.BlockInit;
import com.huto.forces_of_reality.init.CapabilityInit;
import com.huto.forces_of_reality.init.ContainerInit;
import com.huto.forces_of_reality.init.EnchantmentInit;
import com.huto.forces_of_reality.init.EntityInit;
import com.huto.forces_of_reality.init.FeatureInit;
import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.init.ParticleInit;
import com.huto.forces_of_reality.init.TileEntityInit;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.objects.items.tools.ItemMechanGlove;
import com.huto.forces_of_reality.objects.items.tools.ItemRuneBinder;
import com.huto.forces_of_reality.recipes.CopyMechanGloveDataRecipe;
import com.huto.forces_of_reality.recipes.CopyRuneBinderDataRecipe;
import com.huto.forces_of_reality.recipes.ModChiselRecipes;
import com.huto.forces_of_reality.recipes.ModFuserRecipies;
import com.huto.forces_of_reality.recipes.ModHarmonizerRecipes;
import com.huto.forces_of_reality.recipes.ModInscriberRecipes;
import com.huto.forces_of_reality.recipes.ModResonatorRecipies;
import com.huto.forces_of_reality.recipes.ModWandRecipies;
import com.huto.forces_of_reality.recipes.UpgradeMachinaLampDataRecipe;
import com.huto.forces_of_reality.render.entity.layer.RunesRenderLayer;
import com.huto.forces_of_reality.worldgen.ModOreGen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("forces_of_reality")
@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class ForcesOfReality {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "forces_of_reality";
	public static ForcesOfReality instance;
	public static IProxy proxy = new IProxy() {
	};

	@SuppressWarnings("deprecation")
	public ForcesOfReality() {
		DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		proxy.registerHandlers();
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::doClientStuff);
		ParticleInit.PARTICLE_TYPES.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		TileEntityInit.TILES.register(modEventBus);
		ContainerInit.CONTAINERS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		EnchantmentInit.ENCHANTS.register(modEventBus);
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(RuneBinderEvents::pickupEvent);
		MinecraftForge.EVENT_BUS.addListener(RuneBinderEvents::onClientTick);
		MinecraftForge.EVENT_BUS.addListener(MechanGloveEvents::pickupEvent);
		MinecraftForge.EVENT_BUS.addListener(MechanGloveEvents::onClientTick);
		MinecraftForge.EVENT_BUS.addListener(SparkDirectorModEvents::onClientTick);

		// Register Capability Events
		MinecraftForge.EVENT_BUS.register(ChunkVibrationEvents.class);
		MinecraftForge.EVENT_BUS.register(VibrationEvents.class);
		MinecraftForge.EVENT_BUS.register(DevotionEvents.class);
		MinecraftForge.EVENT_BUS.register(KarmaActivationEvents.class);
		MinecraftForge.EVENT_BUS.register(KarmaEvents.class);
		MinecraftForge.EVENT_BUS.register(CovenantEvents.class);
		MinecraftForge.EVENT_BUS.register(SeerEventHandler.class);
		MinecraftForge.EVENT_BUS.register(KarmaHudEventHandler.class);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModOreGen::addStuffToBiomes);

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
		CapabilityInit.init();
		ModWandRecipies.init();
		ModResonatorRecipies.init();
		ModFuserRecipies.init();
		ModChiselRecipes.init();
		ModInscriberRecipes.init();
		ModHarmonizerRecipes.init();
		PacketHandler.registerChannels();
		PacketHandler.registerRuneBinderChannels();
		PacketHandler.registerMechanGloveChannels();
		event.enqueueWork(() -> {
			ModOreGen.registerConfiguredFeatures();
		});

	}

	private void doClientStuff(final FMLClientSetupEvent event) {
			TomePageLib.registerPages();
		CovenPageLib.registerPages();
		this.addLayers();
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	public void setupOnLoaded(FMLLoadCompleteEvent event) {

	}

	// Creative Tab
	public static class HutosModItemGroup extends ItemGroup {
		public static final HutosModItemGroup instance = new HutosModItemGroup(ItemGroup.GROUPS.length, "hutostab");

		public HutosModItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.activated_obsidian.get());
		}
	}

	// Rune Layers
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

	public static ItemStack findRuneBinder(PlayerEntity player) {
		if (player.getHeldItemMainhand().getItem() instanceof ItemRuneBinder)
			return player.getHeldItemMainhand();
		if (player.getHeldItemOffhand().getItem() instanceof ItemRuneBinder)
			return player.getHeldItemOffhand();
		PlayerInventory inventory = player.inventory;
		for (int i = 0; i <= 35; i++) {
			ItemStack stack = inventory.getStackInSlot(i);
			if (stack.getItem() instanceof ItemRuneBinder)
				return stack;
		}
		return ItemStack.EMPTY;
	}

	public static ItemStack findMechanGlove(PlayerEntity player) {
		if (player.getHeldItemMainhand().getItem() instanceof ItemMechanGlove)
			return player.getHeldItemMainhand();
		if (player.getHeldItemOffhand().getItem() instanceof ItemMechanGlove)
			return player.getHeldItemOffhand();
		PlayerInventory inventory = player.inventory;
		for (int i = 0; i <= 35; i++) {
			ItemStack stack = inventory.getStackInSlot(i);
			if (stack.getItem() instanceof ItemMechanGlove)
				return stack;
		}
		return ItemStack.EMPTY;
	}

	@SubscribeEvent
	public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
		event.getRegistry().register(new CopyRuneBinderDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "rune_binder_upgrade")));
		event.getRegistry().register(new CopyMechanGloveDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "mechan_glove_upgrade")));
		event.getRegistry().register(new UpgradeMachinaLampDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "machina_cage")));
	}

}
