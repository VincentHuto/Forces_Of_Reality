package com.huto.forcesofreality.events.adornments;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentType;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT)
public class AdornmentItemSharedTooltip {

	@SubscribeEvent
	public static void tooltipEvent(ItemTooltipEvent event) {
		if (!event.getItemStack().isEmpty()) {
			event.getItemStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).ifPresent(rune -> {
				AdornmentType rt = rune.getAdornmentType();
				TranslatableComponent text = new TranslatableComponent("name." + rt);
				text.getStyle().applyFormatting(TextFormatting.GOLD); // setColor(TextFormatting)
				event.getToolTip().add(text);
			});
		}
	}
}
