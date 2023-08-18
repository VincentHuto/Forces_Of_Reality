//package com.vincenthuto.forcesofreality.client.screen.guide;
//
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.registry.ItemInit;
//import com.vincenthuto.hutoslib.client.screen.guide.GuiGuideTitlePage;
//import com.vincenthuto.hutoslib.client.screen.guide.TomeLib;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//
//public class ForcesTitlePage extends GuiGuideTitlePage {
//
//	public static ForcesTitlePage screen;
//
//	public ForcesTitlePage() {
//		super( Component.translatable("Forces of Reality"), new ItemStack(ItemInit.allegiance_identifier.get()), ForcesLib.chapters,
//				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/forces_overlay.png"));
//	}
//
//	@Override
//	public TomeLib getOwnerTome() {
//		return new ForcesLib();
//	}
//	
//	
//	public static void openScreenViaItem() {
//		openScreen(true);
//	}
//
//	public static void openScreen(boolean ignoreNextMouseClick) {
//		if (screen == null) {
//			screen = new ForcesTitlePage();
//		}
//		Minecraft.getInstance().setScreen(screen);
//	}
//}
