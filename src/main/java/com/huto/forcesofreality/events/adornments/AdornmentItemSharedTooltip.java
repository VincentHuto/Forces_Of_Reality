package com.huto.forcesofreality.events.adornments;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.adornments.AdornmentType;
import com.huto.forcesofreality.capabilities.adornments.AdornmentsCapabilities;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
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
				TranslationTextComponent text = new TranslationTextComponent("name." + rt);
				text.getStyle().applyFormatting(TextFormatting.GOLD); // setColor(TextFormatting)
				event.getToolTip().add(text);
			});
		}
	}
}
