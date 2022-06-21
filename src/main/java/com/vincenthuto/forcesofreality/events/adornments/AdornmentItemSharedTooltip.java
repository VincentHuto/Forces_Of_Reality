//package com.vincenthuto.forcesofreality.events.adornments;
//
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.capa.adornment.AdornmentType;
//import com.vincenthuto.forcesofreality.capa.adornment.AdornmentsCapabilities;
//
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.MutableComponent;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.event.entity.player.ItemTooltipEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT)
//public class AdornmentItemSharedTooltip {
//
//	@SubscribeEvent
//	public static void tooltipEvent(ItemTooltipEvent event) {
//		if (!event.getItemStack().isEmpty()) {
//			event.getItemStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).ifPresent(rune -> {
//				AdornmentType rt = rune.getAdornmentType();
//				MutableComponent text = Component.translatable("name." + rt);
//				text.getStyle().applyFormat(ChatFormatting.GOLD); // setColor(TextFormatting)
//				event.getToolTip().add(text);
//			});
//		}
//	}
//}
