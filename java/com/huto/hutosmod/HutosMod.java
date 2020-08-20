package com.huto.hutosmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("hutosmod")
public class HutosMod {
	// Directly reference a log4j logger.
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "hutosmod";
	public static HutosMod instance;

	public HutosMod() {
		instance=this;
		
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		/*
		 * FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC)
		 * ;
		 * FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC)
		 * ;
		 */
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

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
