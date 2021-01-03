package com.huto.forcesofreality;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.huto.forcesofreality.capabilities.covenant.CovenantEvents;
import com.huto.forcesofreality.capabilities.karma.KarmaEvents;
import com.huto.forcesofreality.capabilities.karma.KarmaHudEventHandler;
import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivationEvents;
import com.huto.forcesofreality.capabilities.tiledevotion.DevotionEvents;
import com.huto.forcesofreality.capabilities.vibes.SeerEventHandler;
import com.huto.forcesofreality.capabilities.vibes.VibrationEvents;
import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrationEvents;
import com.huto.forcesofreality.events.MechanGloveEvents;
import com.huto.forcesofreality.events.SparkDirectorModEvents;
import com.huto.forcesofreality.gui.pages.coven.CovenPageLib;
import com.huto.forcesofreality.gui.pages.guide.TomePageLib;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.CapabilityInit;
import com.huto.forcesofreality.init.ContainerInit;
import com.huto.forcesofreality.init.EnchantmentInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.FeatureInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.init.ParticleInit;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.init.TreeDecoratorInit;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.objects.items.coven.tool.ItemMechanGlove;
import com.huto.forcesofreality.recipes.CopyMechanGloveDataRecipe;
import com.huto.forcesofreality.recipes.ModFuserRecipies;
import com.huto.forcesofreality.recipes.ModHarmonizerRecipes;
import com.huto.forcesofreality.recipes.ModInscriberRecipes;
import com.huto.forcesofreality.recipes.ModRafflesiaRecipies;
import com.huto.forcesofreality.recipes.ModResonatorRecipies;
import com.huto.forcesofreality.recipes.ModWandRecipies;
import com.huto.forcesofreality.recipes.UpgradeMachinaLampDataRecipe;
import com.huto.forcesofreality.render.entity.layer.AdornmentsRenderLayer;
import com.huto.forcesofreality.worldgen.ModFeatures;
import com.huto.forcesofreality.worldgen.ModOreGen;

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

@Mod("forcesofreality")
@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class ForcesOfReality {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "forcesofreality";
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
		TreeDecoratorInit.TREEDECORATORS.register(modEventBus);
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		// MinecraftForge.EVENT_BUS.addListener(AdornmentBinderEvents::pickupEvent);
		// MinecraftForge.EVENT_BUS.addListener(AdornmentBinderEvents::onClientTick);
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
				final Item.Properties properties = new Item.Properties().group(ForcesOfRealityItemGroup.instance)
						.rarity(Rarity.EPIC);
				final BlockItem blockItem = new BlockItem(block, properties);
				blockItem.setRegistryName(block.getRegistryName());
				registry.register(blockItem);
			} else {
				final Item.Properties properties = new Item.Properties().group(ForcesOfRealityItemGroup.instance);
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
		ModRafflesiaRecipies.init();
		// ModChiselRecipes.init();
		ModInscriberRecipes.init();
		ModHarmonizerRecipes.init();
		PacketHandler.registerChannels();
		// PacketHandler.registerAdornmentBinderChannels();
		PacketHandler.registerMechanGloveChannels();
		ModFeatures.setup();
		MinecraftForge.EVENT_BUS.register(new ModFeatures());

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
	public static class ForcesOfRealityItemGroup extends ItemGroup {
		public static final ForcesOfRealityItemGroup instance = new ForcesOfRealityItemGroup(ItemGroup.GROUPS.length,
				"forcesofrealitytab");

		public ForcesOfRealityItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.activated_obsidian.get());
		}
	}

	// Adornment Layers

	@SuppressWarnings({ "rawtypes", "unchecked" })

	@OnlyIn(Dist.CLIENT)
	private void addLayers() {
		Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getRenderManager().getSkinMap();
		PlayerRenderer render;
		render = skinMap.get("default");
		render.addLayer(new AdornmentsRenderLayer(render));
		render = skinMap.get("slim");
		render.addLayer(new AdornmentsRenderLayer(render));
	}

	/*
	 * public static ItemStack findAdornmentBinder(PlayerEntity player) { if
	 * (player.getHeldItemMainhand().getItem() instanceof ItemAdornmentBinder) return
	 * player.getHeldItemMainhand(); if (player.getHeldItemOffhand().getItem()
	 * instanceof ItemAdornmentBinder) return player.getHeldItemOffhand();
	 * PlayerInventory inventory = player.inventory; for (int i = 0; i <= 35; i++) {
	 * ItemStack stack = inventory.getStackInSlot(i); if (stack.getItem() instanceof
	 * ItemAdornmentBinder) return stack; } return ItemStack.EMPTY; }
	 */
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
		/*
		 * event.getRegistry().register(new CopyAdornmentBinderDataRecipe.Serializer()
		 * .setRegistryName(new ResourceLocation(MOD_ID, "rune_binder_upgrade")));
		 */
		event.getRegistry().register(new CopyMechanGloveDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "mechan_glove_upgrade")));
		event.getRegistry().register(new UpgradeMachinaLampDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "machina_cage")));
	}

}
