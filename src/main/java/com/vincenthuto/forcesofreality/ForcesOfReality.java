package com.vincenthuto.forcesofreality;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.datafixers.util.Pair;
import com.vincenthuto.forcesofreality.capa.covenant.CovenantEvents;
import com.vincenthuto.forcesofreality.capa.tiledevotion.DevotionEvents;
import com.vincenthuto.forcesofreality.events.ClientEventSubscriber;
import com.vincenthuto.forcesofreality.events.MechanGloveEvents;
import com.vincenthuto.forcesofreality.gui.guide.ForcesLib;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;
import com.vincenthuto.forcesofreality.init.BlockInit;
import com.vincenthuto.forcesofreality.init.ContainerInit;
import com.vincenthuto.forcesofreality.init.EnchantmentInit;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.FeatureInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.ParticleInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.forcesofreality.network.PacketHandler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod("forcesofreality")
@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class ForcesOfReality {
	// Creative Tab
	public static class ForcesOfRealityItemGroup extends CreativeModeTab {
		public static final ForcesOfRealityItemGroup instance = new ForcesOfRealityItemGroup(
				CreativeModeTab.TABS.length, "forcesofrealitytab");

		public ForcesOfRealityItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.allegiance_identifier.get());
		}
	}

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "forcesofreality";
	public static ForcesOfReality instance;
	public static IProxy proxy = new IProxy() {
	};

	public static boolean hemosLoaded = false;

	public static Pair<ResourceLocation, BlockItem> createItemBlock(Pair<Block, ResourceLocation> block) {
		return Pair.of(block.getSecond(),
				new BlockItem(block.getFirst(), new Item.Properties().tab(ForcesOfRealityItemGroup.instance)));
	}



	public static ItemStack findMechanGlove(Player player) {
		if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ItemMechanGlove)
			return player.getItemInHand(InteractionHand.MAIN_HAND);
		if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof ItemMechanGlove)
			return player.getItemInHand(InteractionHand.OFF_HAND);
		Inventory inventory = player.getInventory();
		for (int i = 0; i <= 35; i++) {
			ItemStack stack = inventory.getItem(i);
			if (stack.getItem() instanceof ItemMechanGlove)
				return stack;
		}
		return ItemStack.EMPTY;
	}

	public static ItemStack findMechanGloveInHand(Player player) {
		ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);
		if (!(heldItem.getItem() instanceof ItemMechanGlove)) {
			heldItem = player.getItemInHand(InteractionHand.OFF_HAND);
			if (!(heldItem.getItem() instanceof ItemMechanGlove)) {
				return ItemStack.EMPTY;
			}
		}
		return heldItem;
	}

	public static boolean isArmed(Player entity) {
		return findMechanGloveInHand(entity).getItem() instanceof ItemMechanGlove;
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegisterEvent event) {
		if (event.getRegistryKey() != ForgeRegistries.Keys.ITEMS) {
			return;
		}

		BlockInit.getAllBlockEntriesAsStream().map(m -> new Pair<>(m.get(), m.getId())).map(t -> createItemBlock(t))
				.forEach(item -> registerBlockItem(event, item));
	}

	private static void registerBlockItem(RegisterEvent event, Pair<ResourceLocation, BlockItem> item) {
		event.register(ForgeRegistries.Keys.ITEMS, helper -> helper.register(item.getFirst(), item.getSecond()));
	}

	@SuppressWarnings("deprecation")
	public ForcesOfReality() {
		DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		proxy.registerHandlers();
		hemosLoaded = ModList.get().isLoaded("hemomancy");
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ParticleInit.PARTICLE_TYPES.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		ItemInit.MODELEDITEMS.register(modEventBus);
		ItemInit.ADVITEMS.register(modEventBus);
		ItemInit.HANDHELDITEMS.register(modEventBus);
		ItemInit.SPAWNEGGS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		BlockInit.SPECIALBLOCKS.register(modEventBus);
		BlockEntityInit.TILES.register(modEventBus);
		ContainerInit.CONTAINERS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		EnchantmentInit.ENCHANTS.register(modEventBus);
		SoundInit.SOUND_EVENTS.register(modEventBus);
		modEventBus.addListener(this::commonSetup);
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(ClientEventSubscriber::initKeybinds);
		forgeBus.register(CovenantEvents.class);
		forgeBus.register(DevotionEvents.class);
		forgeBus.addListener(MechanGloveEvents::onClientTick);


	}

	private void clientSetup(final FMLClientSetupEvent event) {
//		MinecraftForge.EVENT_BUS.register(RenderLaserEvent.class);
		// this.addLayers();
		ForcesLib forces = new ForcesLib();
		forces.registerTome();
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
//		CapabilityInit.init();
//		ModRafflesiaRecipies.init();
		PacketHandler.registerChannels();

	}

	// Adornment Layers
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private void addLayers() {
//		Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
//		PlayerRenderer render;
//		render = skinMap.get("default");
//		render.addLayer(new AdornmentsRenderLayer(render));
//		render = skinMap.get("slim");
//		render.addLayer(new AdornmentsRenderLayer(render));
//	}

//	public static ItemStack findMechanGlove(Player player) {
//		if (player.getMainHandItem().getItem() instanceof ItemMechanGlove)
//			return player.getMainHandItem();
//		if (player.getOffhandItem().getItem() instanceof ItemMechanGlove)
//			return player.getOffhandItem();
//		Inventory inventory = player.getInventory();
//		for (int i = 0; i <= 35; i++) {
//			ItemStack stack = inventory.getItem(i);
//			if (stack.getItem() instanceof ItemMechanGlove)
//				return stack;
//		}
//		return ItemStack.EMPTY;
//	}
//
//	public static ItemStack findMechanGloveInHand(Player player) {
//		ItemStack heldItem = player.getMainHandItem();
//		if (!(heldItem.getItem() instanceof ItemMechanGlove)) {
//			heldItem = player.getOffhandItem();
//			if (!(heldItem.getItem() instanceof ItemMechanGlove)) {
//				return ItemStack.EMPTY;
//			}
//		}
//		return heldItem;
//	}

//	public static boolean isArmed(Player entity) {
//		return findMechanGloveInHand(entity).getItem() instanceof ItemMechanGlove;
//	}

//	@SubscribeEvent
//	public static void onRecipeRegistry(final RegistryEvent.Register<RecipeSerializer<?>> event) {
//		event.getRegistry().register(new CopyMechanGloveDataRecipe.Serializer()
//				.setRegistryName(new ResourceLocation(MOD_ID, "mechan_glove_upgrade")));
//		event.getRegistry().register(new UpgradeMachinaLampDataRecipe.Serializer()
//				.setRegistryName(new ResourceLocation(MOD_ID, "machina_cage")));
//	}

	@SuppressWarnings("unused")
	private void enqueueIMC(final InterModEnqueueEvent event) {
	}

	@SuppressWarnings("unused")
	private void processIMC(final InterModProcessEvent event) {

	}

	public void setupOnLoaded(FMLLoadCompleteEvent event) {

	}

}