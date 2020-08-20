package com.huto.hutosmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.huto.hutosmod.init.BlockInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("hutosmod")
public class HutosMod {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "hutosmod";
	public static HutosMod instance;

	public HutosMod() {
		instance=this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
	}

	
	public static class HutosModItemGroup extends ItemGroup{

		public static final HutosModItemGroup instance = new HutosModItemGroup(ItemGroup.GROUPS.length, "hutosTab");
		
		public HutosModItemGroup(int index, String label) {
			super(index, label);
		}
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.example_block);
		}
		
	}
	

	
	/*
	 * //THESE TWO METHODS ARE FOR INTERMOD COMPATABLITIY private void
	 * enqueueIMC(final InterModEnqueueEvent event) { // some example code to
	 * dispatch IMC to another mod InterModComms.sendTo("examplemod", "helloworld",
	 * () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";}); }
	 * 
	 * private void processIMC(final InterModProcessEvent event) { // some example
	 * code to receive and process InterModComms from other mods
	 * LOGGER.info("Got IMC {}", event.getIMCStream().
	 * map(m->m.getMessageSupplier().get()). collect(Collectors.toList())); }
	 */
}

