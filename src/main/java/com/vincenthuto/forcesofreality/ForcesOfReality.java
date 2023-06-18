package com.vincenthuto.forcesofreality;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.datafixers.util.Pair;
import com.vincenthuto.forcesofreality.client.event.ClientEvents;
import com.vincenthuto.forcesofreality.client.event.MechanGloveEvents;
import com.vincenthuto.forcesofreality.client.screen.guide.ForcesLib;
import com.vincenthuto.forcesofreality.common.capability.covenant.CovenantEvents;
import com.vincenthuto.forcesofreality.common.capability.tiledevotion.DevotionEvents;
import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.forcesofreality.common.network.PacketHandler;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;
import com.vincenthuto.forcesofreality.registry.BlockInit;
import com.vincenthuto.forcesofreality.registry.ContainerInit;
import com.vincenthuto.forcesofreality.registry.EnchantmentInit;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.FeatureInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.forcesofreality.registry.ParticleInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod("forcesofreality")
@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class ForcesOfReality {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "forcesofreality";
	public static ForcesOfReality instance;

	public static boolean hemosLoaded = false;

	public static final DeferredRegister<CreativeModeTab> CREATIVETABS = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, ForcesOfReality.MOD_ID);
	public static final RegistryObject<CreativeModeTab> forcestab = CREATIVETABS.register("forcesofrealitytab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group." + MOD_ID + ".forcesofrealitytab"))
					.icon(() -> new ItemStack(ItemInit.allegiance_identifier.get())).build());

	public ForcesOfReality() {
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

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
		CREATIVETABS.register(modEventBus);
		ContainerInit.CONTAINERS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		EnchantmentInit.ENCHANTS.register(modEventBus);
		SoundInit.SOUND_EVENTS.register(modEventBus);
		modEventBus.addListener(this::commonSetup);
		forgeBus.register(CovenantEvents.class);
		forgeBus.register(DevotionEvents.class);
		forgeBus.addListener(MechanGloveEvents::onClientTick);
		modEventBus.addListener(this::buildContents);

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

	public static Pair<ResourceLocation, BlockItem> createItemBlock(Pair<Block, ResourceLocation> block) {
		return Pair.of(block.getSecond(), new BlockItem(block.getFirst(), new Item.Properties()));
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

	public void buildContents(BuildCreativeModeTabContentsEvent populator) {
		if (populator.getTabKey() == forcestab.getKey()) {
			// Items
			ItemInit.ITEMS.getEntries().forEach(i -> populator.accept(i.get()));
			ItemInit.ADVITEMS.getEntries().forEach(i -> populator.accept(i.get()));
			ItemInit.MODELEDITEMS.getEntries().forEach(i -> populator.accept(i.get()));
			ItemInit.HANDHELDITEMS.getEntries().forEach(i -> populator.accept(i.get()));
			ItemInit.SPAWNEGGS.getEntries().forEach(i -> populator.accept(i.get()));

			// Blocks
			BlockInit.BLOCKS.getEntries().forEach(i -> populator.accept(i.get()));
			BlockInit.SPECIALBLOCKS.getEntries().forEach(i -> populator.accept(i.get()));
		}
	}

}