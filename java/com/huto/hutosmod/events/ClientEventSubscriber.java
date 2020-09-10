package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.tileenties.TileEntityInit;
import com.huto.hutosmod.render.RenderWandMaker;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		// if(world.isRemote) Basically, Makes the plants see through, similar to
		// isFullblock thing
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderTypeLookup.setRenderLayer(BlockInit.display_glass.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.mind_fog.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.morel_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.singeri_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.passion_flower.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.mystic_sapling.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.wand_maker.get(), RenderType.getCutout());

		}
	}
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.wand_maker.get(), RenderWandMaker::new);

	}
	
}
