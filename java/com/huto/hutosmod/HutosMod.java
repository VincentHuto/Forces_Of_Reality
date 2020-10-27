package com.huto.hutosmod;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.huto.hutosmod.capabilities.covenant.CovenantEvents;
import com.huto.hutosmod.capabilities.karma.KarmaEvents;
import com.huto.hutosmod.capabilities.karma.KarmaHudEventHandler;
import com.huto.hutosmod.capabilities.vibes.SeerEventHandler;
import com.huto.hutosmod.capabilities.vibes.VibrationEvents;
import com.huto.hutosmod.containers.ContainerRuneBinder;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.gui.pages.coven.CovenPageLib;
import com.huto.hutosmod.gui.pages.guide.TomePageLib;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.CapabilityInit;
import com.huto.hutosmod.init.ContainerInit;
import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.TogglePickupMessage;
import com.huto.hutosmod.objects.items.equipment.ItemRuneBinder;
import com.huto.hutosmod.particles.init.ParticleInit;
import com.huto.hutosmod.recipes.CopyRuneBinderDataRecipe;
import com.huto.hutosmod.recipes.ModChiselRecipes;
import com.huto.hutosmod.recipes.ModFuserRecipies;
import com.huto.hutosmod.recipes.ModResonatorRecipies;
import com.huto.hutosmod.recipes.ModWandRecipies;
import com.huto.hutosmod.render.rune.RunesRenderLayer;
import com.huto.hutosmod.worldgen.ModOreGen;

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
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.Event;
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

@Mod("hutosmod")
@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class HutosMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "hutosmod";
	public static HutosMod instance;
	public static IProxy proxy = new IProxy() {
	};

	@SuppressWarnings("deprecation")
	public HutosMod() {
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
		EntityInit.ENTITY_TYPES.register(modEventBus);
		EnchantmentInit.ENCHANTS.register(modEventBus);
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.addListener(this::pickupEvent);
		MinecraftForge.EVENT_BUS.addListener(this::onClientTick);

		// Register Vibration Events
		MinecraftForge.EVENT_BUS.register(VibrationEvents.class);
		MinecraftForge.EVENT_BUS.register(KarmaEvents.class);
		MinecraftForge.EVENT_BUS.register(CovenantEvents.class);
		MinecraftForge.EVENT_BUS.register(SeerEventHandler.class);
		MinecraftForge.EVENT_BUS.register(KarmaHudEventHandler.class);

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
		PacketHandler.registerRuneBinderChannels();

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
		public static final HutosModItemGroup instance = new HutosModItemGroup(ItemGroup.GROUPS.length, "hutosTab");

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

	private void pickupEvent(EntityItemPickupEvent event) {
		if (event.getPlayer().openContainer instanceof ContainerRuneBinder || event.getPlayer().isSneaking()
				|| event.getItem().getItem().getItem() instanceof ItemRuneBinder)
			return;
		PlayerInventory playerInv = event.getPlayer().inventory;
		for (int i = 0; i <= 8; i++) {
			ItemStack stack = playerInv.getStackInSlot(i);
			if (stack.getItem() instanceof ItemRuneBinder
					&& ((ItemRuneBinder) stack.getItem()).pickupEvent(event, stack)) {
				event.setResult(Event.Result.ALLOW);
				return;
			}
		}
	}

	private void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(0).isPressed())
			PacketHandler.RUNEBINDER.sendToServer(new TogglePickupMessage());
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

	@SubscribeEvent
	public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
		event.getRegistry().register(new CopyRuneBinderDataRecipe.Serializer()
				.setRegistryName(new ResourceLocation(MOD_ID, "rune_binder_upgrade")));
	}

}
